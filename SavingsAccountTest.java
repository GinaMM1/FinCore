package com.fincore.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
*Unit tests for SavingsAccount clas.
*Each test verifies interest-realted functonality and inherited behavior from Account.
 */
public class SavingsAccount {
    /**
    *Test implies to applying interest correctly will increase the account balance.
    *Verifies that the interest is calculated and added based on the current balance and interest rate.
    **/
    @Test
    void testApplyInerestIncreasesBalance(){
        SavingsAccount account = new SavingsAccount("Alex Doe", 1000.00, 0.05);
        account.applyInterest(); //Should add the 5% of 1000 = 50
        assert.Equals(1050.00, account.getBalance(), 0.001); //The new should be 1050.00
    }
    
    /** 
    *Test that settting interest rate will update the internal interestRate field.
    */
    @Test
    void testSetValidInterestRate(){
        SavingsAccount account = new SavingsAccount("Alex Doe", 1000.00, 0.05);
        account.setInterestRate(0.10);
        assertEquals(0.10, account.getInterestRate()); // Should show the new rate.
    }
    /** 
    * Test the toString method will retnr the expected formatted string
    * including the account holder,  balance and the interest rate.
    */
    @Test
    void testToStringFormat(){
        SavingsAccount account = new SavingsAccount("Alex Doe", 1000.00, 0.05);
        String expected = "SavingsAccount[holder=Alex Doe, balance=$1000.00, interestRate=5.00%]";
        assertEquals(expected, account.toString());
    }
    /**
    *Test that when setting a negative rate it does not change the current rate.
    *Ensures valid input validation is applied .
    */
    @Test
    void testSetNegativeInterestRate(){
        SavingsAccount account = new Account("Alex Doe", 1000.00);
        boolean result = account.withdraw(200.00);
        assertTrue(result); //Withdrawal should be sucessful.
        assertEquals(800.00, account.getBalance(), 0.001); //Balance should be reduced
    }
    /**
     * Test that withdrawing more than the available balance fails.
     *The balance should remain unchanged
     */
    @Test
    void withdrawMoreThanBalanceShouldFail() {
        Account account = new Account("Alex Doe", 1000.00);
        boolean result = account.withdraw(1500.00);
        assertFalse(result); //Withdrawal should fail
        assertEquals(1000.00, account.getBalance(), 0.001); //The balance should remain the same.
    }
}
 
