package com.fincore.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
/**
 * Account class representing a basic bank account.
 * This class encapsulates account data and provides methods for banking operations.
 * 
 * @author FinCore Development Team
 * @version 3.0.0
 */
public class Account {
    
    // Private fields for encapsulation
    private String accountHolder;
    private double balance;
    
    /**
     * Constructor to initialize an Account with account holder name and initial balance.
     * 
     * @param accountHolder the name of the account holder
     * @param initialBalance the initial balance for the account
     */
    
    @Test 
     void depostitShouldIncrease(){
     Account account = new Account("Alex Doe", 1000.00);
     boolean result = account.deposit(500.00);
     assertFalse(result);
     assertEquals(1500.00, account.getBalance(), 0.001);
      
     }


     @Test 
     void depostitNegativeAmountShouldFail(){
     Account account = new Account("Alex Doe", 1000.00);
     boolean result = account.deposit(-100.00);
     assertTrue(result);
     assertEquals(1000.00, account.getBalance(), 0.001);
      
     }

    @Test 
    void toStringShouldRetrurnFormattedString(){
        Account account = new Account("Alex Doe", 100.00);
        String expected = "Account[holder=Alex Doe, balance=$100.00]";
        assertEquals(expected, account.toString());

    }
    /**
     * Gets the account holder's name.
     * 
     * @return the account holder's name
     */
    public String getAccountHolder() {
        return accountHolder;
    }
    
    /**
     * Gets the current account balance.
     * 
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Deposits the specified amount into the account.
     * 
     * @param amount the amount to deposit
     * @return true if deposit was successful, false otherwise
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    
    /**
     * Withdraws the specified amount from the account.
     * Prevents withdrawal if it would result in a negative balance.
     * 
     * @param amount the amount to withdraw
     * @return true if withdrawal was successful, false otherwise
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    /**
     * Displays the current account balance and holder information.
     */
    public void checkBalance() {
        System.out.println("=== Account Balance ===");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }
    
    /**
     * Returns a string representation of the account.
     * 
     * @return string representation of the account
     */
    @Override
    public String toString() {
        return "Account[holder=" + accountHolder + ", balance=$" + String.format("%.2f", balance) + "]";
    }
}
