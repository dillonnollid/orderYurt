package com.example.orderyurt.Login;

import android.app.Activity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.orderyurt.Controllers.MainActivity;
import com.example.orderyurt.Controllers.R;
import com.example.orderyurt.data.DataAPI;
import com.example.orderyurt.data.ServiceGenerator;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button registerButton = findViewById(R.id.register);
        registerButton.setEnabled(true);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);


        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                   authenticateLogin(usernameEditText.getText().toString(),passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                authenticateLogin(usernameEditText.getText().toString(),passwordEditText.getText().toString());
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(LoginActivity.this, RegisterAccount.class);
                startActivity(intent);
            }
        });
    }

    private void updateUiWithUser(String username) {
        String welcome = getString(R.string.welcome) +" "+ username +"!";
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(String errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    private void authenticateLogin(final String username, String password){
        DataAPI loginAPI;
        loginAPI = ServiceGenerator.createService(DataAPI.class);

        Call<Map<String,String>> call = loginAPI.authenticateLogin(username,password);

        try {
            // TODO: handle loggedInUser authentication
            Log.i("test","test2");
            call.enqueue(new Callback<Map<String,String>>() {
                @Override
                public void onResponse(Call<Map<String,String>>  call, Response<Map<String,String>> response) {
                    if (!response.isSuccessful()){
//                                new Result.Error(new IOException("Error logging in. Code: " + response.code()));
                    }
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        if(response.body().containsValue("good")) {
                            Log.i("onResponse", "success: " +response.body().toString());
                            updateUiWithUser(username);
                            setResult(Activity.RESULT_OK);

                            //Complete and destroy login activity once successful
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Log.i("onResponse","fail: "+response.code() + response.body().toString());
                            showLoginFailed(response.code() + response.body().toString());
                        }
                    }
                }
                @Override
                public void onFailure(Call<Map<String,String>>  call, Throwable t) {
                    System.out.println("error in call");
                }
            });

        } catch (Exception e) {
            Log.i("LoginDataSource.Exception","do nothing");
        }
    }
}
