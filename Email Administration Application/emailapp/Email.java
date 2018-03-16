package emailapp;

import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Stefcio on 14.03.2018.
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private String alternateEmail;
    private int mailboxCapacity = 500;
    private String companySuffix = "company.com";

    // Constructor to receive first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Call method asking for department and return
        this.department = setDepartment();

        // Generate random password
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("Your password is: " + password);

        // Combine elements to create email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

        // Ask to change password
        askToChangePassword();
    }




    // Ask for department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + " " + lastName +"." + " Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if(departmentChoice == 1){
            return "sales";
        }
        else if(departmentChoice == 2){
            return "development";
        }
        else if (departmentChoice == 3){
            return "accounting";
        }
        else {
            return "";
        }

    }

    // Random password generator
    private String generatePassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUWXYZ0123456789";
        char [] password = new char[length];
        for (int i= 0; i <length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password [i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set alternate email
    public void setAlternateEmail(String alternateEmail){
    this.alternateEmail = alternateEmail;
    }

    // Change password
    public void changePassword(String newpassword){
            this.password = newpassword;
    }
    public void askToChangePassword(){
        System.out.println("Change your password. First type your current password");
        Scanner in = new Scanner(System.in);
        String pass = in.nextLine();
        if (!pass.equals(password)){
            System.out.println("Wrong password. Try again");
            askToChangePassword();
        }
        else {
            System.out.println("Type new password");
            String newpassword = in.nextLine();
            changePassword(newpassword);
            System.out.println("Your new password is: " + getPassword());
        }

    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
                "COMPANY EMAIL: " + email + "\n" +
                "MAILBOX CAPACITY: " + mailboxCapacity + " mb";
    }

    // Save worker data to file
    public void saveWorkerToFile(){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter( firstName + lastName + ".txt"));
            out.write("Name: " + firstName + " " + lastName + " \n");
            out.write("Department: " + department + " \n");
            out.write("Email: " + email + " \n");
            out.write("Mailbox capacity: " + mailboxCapacity + " \n");
            out.write("Password: " + password);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
