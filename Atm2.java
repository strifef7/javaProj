/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm2;
import java.util.Scanner;

/**
 *
 * @author jwp5812
 */
public class Atm2 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int transCode;
        int userPIN;
        int i;
        double withdrawAmt;
        double depositAmt;
        // Account balance will start at 00.00
        double accountBal = 00.00;

        // Declare user PIN.
        // Use this PIN to access atm controls
        int masterPIN = 1234;

        for (i = 0; i <= 2; ++i){
            System.out.println("[[~~ Welcome To the Java Banking System ~~]]");
            System.out.print("Please enter 4 digit PIN: ");
            userPIN = input.nextInt();
            if(i == 2){
                System.out.println("Incorrent PIN entered 3 times " +
                    "please contact customer service to reset PIN.");
                return;
            }

            if (userPIN == masterPIN){
                System.out.println("Welcome to your account, please make a selection " +
                    "from the following opions:");
                System.out.println("[1] Deposit");
                System.out.println("[2] Withdraw");
                System.out.println("[3] Balance");
                System.out.println("[4] Quit");

                transCode = input.nextInt();

                switch(transCode){
                    case 1:
                        System.out.print("Enter Deposit Ammount: ");
                        depositAmt = input.nextDouble();
                        accountBal = accountBal + depositAmt;
                        System.out.printf("Deposit Accepted, Balance: $%.2f", accountBal);
                        System.out.println();
                        break;

                    case 2:
                        System.out.printf("Account Balance: $%.2f", accountBal);
                        System.out.println();
                        System.out.print("Please enter withdraw ammout in " +
                            "$5 increments: ");
                        withdrawAmt = input.nextDouble();
                            if((withdrawAmt <= accountBal) && (withdrawAmt %5 == 0) && 
                                (withdrawAmt >= 5.00 )){
                                accountBal = accountBal - withdrawAmt;
                                System.out.printf("New Account Balance is: $%.2f",accountBal);
                                System.out.println();
                                System.out.println("Please take bills below.");
                                System.out.println("Thank You for banking with us!");
                                break;
                            }
                            else if (withdrawAmt >= accountBal){
                                System.out.println("Error! Withdraw ammount exceedes " +
                                    "account balance. Please try again!");
                                break;
                            }
                            else {
                                System.out.println("Error! Please enter a withdraw ammount " +
                                    "in $5 incriments.");
                                break;
                            }

                    case 3:
                        System.out.printf("Account balance: $%.2f", accountBal);
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("Thanks for banking with us. Goodbye!");
                        return;

                    default:
                        System.out.println("Error! Please enter a valid transaction selection!");      

            }

        }
            
            else {
                System.out.println("Error. Incorrect PIN entered. Please try again.");
                continue;
            }
            
    }
  }  
    
}
