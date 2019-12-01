package com.example.orderyurt;

import com.example.orderyurt.Pay.BasePay;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PaymentTest {
    private BasePay bp;

    /**
    * Instantiates a new BasePay object.
     */
    @Before
    public void setUp(){
        bp = new BasePay();
    }
    /**
    * Tries to verify a card with a card number and cvv too long.
    * Expects the method to return false, indicating that the card details are invalid.
     */
    @Test
    public void cardNumbeTooLong_ExpectFalse(){
        boolean result = bp.verifyCard("111111111111111111", "1234");
        assertFalse(result);
    }
    /**
    * Tries to verify a card with a card number and cvv too short.
    * Expects the method to return false, indicating that the card details are invalid.
     */
    @Test
    public void cardNumbeTooShort_ExpectFalse(){
        boolean result = bp.verifyCard("11", "12");
        assertFalse(result);
    }
    /**
    * Tries to verify a card with correctly sized card number and cvv.
    * Expects the method to return true, indicating that the card details are valid.
     */
    @Test
    public void cardNumberValid_ExpectTrue(){
        boolean result = bp.verifyCard("1111111111111111", "123");
        assertTrue(result);
    }
}
