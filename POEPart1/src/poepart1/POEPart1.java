/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart1;

import java.util.Scanner;

/**
 *
 * @author musan
 */
public class POEPart1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       

    
        Login login = new Login();
        login.displayMenu();
    }
}

class Login {
    Scanner input = new Scanner(System.in);
    private String registeredUsername = null;
    private String registeredPassword = null;

    void displayMenu() {
        boolean continueApp = true;
        boolean isRegistered = false;

        while (continueApp) {
            System.out.println("==========================================");
            System.out.println("Welcome to QuickChat");
            System.out.println("==========================================");

            if (!isRegistered) {
                System.out.println("1. Register");
                System.out.println("2. Exit");
                System.out.println("==========================================");
                System.out.println("Choose an option: ");
                String choice = input.nextLine();

                if (choice.equals("1")) {
                    String registerResult = registerStatus();
                    System.out.println(registerResult);
                    isRegistered = true;
                } else if (choice.equals("2")) {
                    System.out.println("Thank you for using the system. Goodbye!");
                    continueApp = false;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.println("==========================================");
                System.out.println("Choose an option: ");
                String choice = input.nextLine();

                if (choice.equals("1")) {
                    boolean loginResult = loginStatus();
                    if (loginResult) {
                        continueApp = false;
                        MessageApp messageApp = new MessageApp();
                        messageApp.run();
                    }
                } else if (choice.equals("2")) {
                    System.out.println("Thank you for using the system. Goodbye!");
                    continueApp = false;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    String registerStatus() {
        String userName = "";
        String password = "";
        String cellphoneNumber = "";
        boolean validUsername = false;
        boolean validPassword = false;
        boolean validCellphone = false;

        while (!validUsername) {
            System.out.println("Enter your username (must contain _ and be exactly 5 characters): ");
            userName = input.nextLine();
            if (checkUserName(userName)) {
                System.out.println("Username successfully captured.");
                validUsername = true;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is exactly 5 characters.");
            }
        }

        while (!validPassword) {
            System.out.println("Enter your password (at least 8 chars, capital letter, number, special character): ");
            password = input.nextLine();
            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                validPassword = true;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        }

        while (!validCellphone) {
            System.out.println("Enter your cellphone number (format: +27XXXXXXXXX): ");
            cellphoneNumber = input.nextLine();
            if (checkCellPhoneNumber(cellphoneNumber)) {
                System.out.println("Cell phone number successfully added.");
                validCellphone = true;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        return registerUser(userName, password, cellphoneNumber);
    }

    boolean checkUserName(String u) { 
        return u.contains("_") && u.length() == 5; 
    }
    
    boolean checkPasswordComplexity(String p) { 
        return p.length()>=8 && p.matches(".*[A-Z].*") && p.matches(".*[0-9].*") && p.matches(".*[^a-zA-Z0-9].*"); 
    }
    
    boolean checkCellPhoneNumber(String c) { 
        return c.matches("^\\+27\\d{9}$"); 
    }

    String registerUser(String userName, String password, String cellPhoneNumber) {
        if (checkUserName(userName) && checkPasswordComplexity(password) && checkCellPhoneNumber(cellPhoneNumber)) {
            registeredUsername = userName;
            registeredPassword = password;
            return "Registration successful";
        }
        return "Registration failed";
    }

    boolean loginUser(String u, String p) { 
        return u.equals(registeredUsername) && p.equals(registeredPassword); 
    }
    
    boolean loginStatus() {
        System.out.println("Enter username:"); String u = input.nextLine();
        System.out.println("Enter password:"); String p = input.nextLine();
        if (loginUser(u,p)) { 
            System.out.println("Login successful"); 
            return true; 
        }
        else { 
            System.out.println("Login failed, please try again."); 
            return false; 
        }
    }
}
    
    

