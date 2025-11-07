package com.fincore.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Account class representing a basic bank account.
 * This class encapsulates account data and provides methods for banking operations.
 * 
 * @author FinCore Development Team
 * @version 3.0.0
 */
public class AccountTest {
    /**
    *Test to valid the deposit increases the account balanc.
    *Also to verify that the deposit method will return true
    */
    
    @Test 
     void depostitShouldIncrease(){
     Account account = new Account("Alex Doe", 1000.00);
     boolean result = account.deposit(500.00);
     assertFalse(result);
     assertEquals(1500.00, account.getBalance(), 0.001);
      
     }
/** 
* Test to check that deposting a negative amount will fail.
* The balance should remain unchanged and the method should return false.
**/

     @Test 
     void depostitNegativeAmountShouldFail(){
     Account account = new Account("Alex Doe", 1000.00);
     boolean result = account.deposit(-100.00);
     assertTrue(result); //Deposit should fail
     assertEquals(1000.00, account.getBalance(), 0.001); //Balance will remain the same.
      
     }
// Test that the toString method will return the formatted string

    @Test 
    void toStringShouldRetrurnFormattedString(){
        Account account = new Account("Alex Doe", 100.00);
        String expected = "Account[holder=Alex Doe, balance=$100.00]";
        assertEquals(expected, account.toString());
    }

/**
    *Test will withdraw more than the available ammount will fail.
    * The blance should remail unchanged.
*/
@Test
Void withdrawMoreThanBalanceShouldFail() {
    Account account = new Account("Alex Doe", 1000.00);
    boolean result = account.withdraw(1500.00);
    assertFalse(result); //Withdrawal should fail
    assertEquals(1000.00, account.getBalance(), 0.001); //Balance should remain the same.
    }
}   
