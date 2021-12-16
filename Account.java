package com.company;
import java.util.Random;
import javax.swing.*;
public class Account {

    private final Random rd = new Random();
    // will store balance account value
    private double balance;
    //will store the pin-number
    private int pin;

    // Account constructor
    public Account(double bal){
        setBalance(bal);
        createPin();
    }

    public int getPin(){
        return this.pin;
    }

    // will randomly generate a four digit PIN number
    public void createPin(){
        this.pin = rd.nextInt(9000) + 1000;
    }

    public void setBalance(double assignBalance){
        // will store the balance number
        this.balance = assignBalance;
    }

    // displays balance account for the user
    public void showBalance(){
        JOptionPane.showMessageDialog(null, "Current balance is\n$" +
                this.balance);
    }

    public void deposit(double amount) {
        // will add to the total balance
        this.balance += amount;
    }

    public void withdraw(double amount){
        // need to subtract from total balance
        this.balance -= amount;
    }
}
