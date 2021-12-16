package com.company;
import javax.swing.*;
/*
* John Hodges
* CS160 -- Fall 2021
* Project: At the ATM-Machine
* Description: the purpose of this class is to display a GUI for the user to interact with.
* The user will decide whether to open an account or not. If the user wants to open an account, they will
* be prompted to deposit the minimum amount and the user will be given a PIN-number. If the user wants a
* transaction, the ATM class will be called and the transaction method will be used. When the transaction method is
* called, the user will enter their PIN-number, if the PIN-number is wrong the program will exit, but if the PIN-number
* is correct then the user can either deposit or withdraw from their account. Once the user is satisfied with their account
* they can exit the program and the transaction will be finished.
* */

public class Applications {
    public static void main(String[] args) {
        Account acc = null;
        ATM atm = null;
        boolean client = true;
        boolean transactionRequired;

        while(client){
            transactionRequired = true;
            int decision = JOptionPane.showConfirmDialog(null, "Would you like to open an account?\n" +
                    "The minimum deposit is 100 dollars.\n" +
                    "If you have an account please click Cancel");
            if (decision == JOptionPane.YES_OPTION){
                double userEnter = Double.parseDouble(JOptionPane.showInputDialog(null,"Please enter the amount for deposit\nPlease take note a PIN " +
                        "code will be issued for you"));
                acc = new Account(userEnter);
                atm = new ATM(acc);
                JOptionPane.showMessageDialog(null,"Take note of your PIN:\n" + acc.getPin());

            }
            else if (decision == JOptionPane.NO_OPTION){
                System.out.println("The process terminates\n" +
                        "Good Bye!");
                System.exit(0);
            }
            else if (acc == null){
                JOptionPane.showMessageDialog(null, "Sorry, you do not have an account.");
                client = false;
                System.exit(0);
            }
            else {
                atm = new ATM(acc);
            }

            while(transactionRequired){
                int userTrans = JOptionPane.showConfirmDialog(null, "Please click Yes for a transaction\n" +
                        "Click No to exit current process");
                if (userTrans == JOptionPane.NO_OPTION){
                    transactionRequired = false;
                }
                else {
                    atm.transaction();
                }
            }
        }

    }
}
