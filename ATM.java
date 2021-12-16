package com.company;
import java.util.Scanner;
import javax.swing.*;
public class ATM {

    private Account acc;
    private final Scanner keyboard = new Scanner(System.in);

    public ATM(Account newAccount){
        this.acc = newAccount;
    }

    // main method of class
    public void transaction() {
        // will display figure 5
        String userEnter = JOptionPane.showInputDialog("Please enter W or w to withdraw\n" +
                "Enter D or d for deposit");
        // will display figure 6
        System.out.println("Please enter your PIN code here");
        int pinEntered = keyboard.nextInt();
        if (userEnter.equalsIgnoreCase("W")) {
            // first main decision tree
            if (pinEntered == acc.getPin()) {
                double userWithdraw = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount\n" +
                        "you want to withdraw"));
                acc.withdraw(userWithdraw);
                acc.showBalance();
            }
            else {
                System.out.println("Wrong PIN, transaction aborted");
            }
        }
        // second main decision tree
        else if(userEnter.equalsIgnoreCase("D")){
            if (pinEntered == acc.getPin()) {
                JOptionPane.showMessageDialog(null,"We accept the following dollar bills:\n" +
                        "\t1, 5, 10, 20, 50, 100\n" +
                        "Please insert the bill on the console\n" +
                        "Enter any other number to stop depositing");
                System.out.println("Enter the bills here");

                // anything not in the given range will stop the while loop
                while (true) {
                    int userBills = keyboard.nextInt();
                    if (userBills == 1 || userBills == 5 || userBills == 10 || userBills == 20 || userBills == 50 || userBills == 100) {
                        acc.deposit(userBills);
                    }
                    else {
                        acc.showBalance();
                        break;
                    }
                }
            }
            else {
                System.out.println("Wrong PIN, transaction aborted");
            }
        }
    }
}
