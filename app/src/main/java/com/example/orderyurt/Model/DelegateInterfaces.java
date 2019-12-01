package com.example.orderyurt.Model;

import android.view.View;

public class DelegateInterfaces {

    public interface addCouponModelDelegate{
        void goToRestPageActivity();
    }

    public interface addItemModelDelegate {
        void goToEditMenuActivity();
    }

    public interface addReviewModelDelegate {
         void goToViewRestPageActivity();
    }

    public interface custPageModelDelegate {
        void goToSubscriberActivity(View view);
        void goToLoginActivity();
        void setTitle(String name);
    }
}
