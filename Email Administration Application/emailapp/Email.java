package emailapp;

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
    private String alternateEmail;
    private int mailboxCapacity;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName+ " " + this.lastName);
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("Your password is: " + password);
    }

    private String setDepartment(){
        System.out.println("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if(departmentChoice == 1){
            return "sales";
        }
        else if(departmentChoice == 2){
            return "development";
        }
        else if (departmentChoice == 3){
            return "Accounting";
        }
        else {
            return "";
        }

    }
    private String generatePassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUWXYZ0123456789";
        char [] password = new char[length];
        for (int i= 0; i <length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password [i] = passwordSet.charAt(random);
        }
        return new String(password);
    }
}
