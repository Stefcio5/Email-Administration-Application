package emailapp;

import java.util.Scanner;

/**
 * Created by Stefcio on 14.03.2018.
 */
public class EmailApp {
    public static void main(String[] args) {
        System.out.println("Enter your first name: ");
        Scanner in = new Scanner(System.in);
        String firstName = in.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = in.nextLine();

    Email em1 = new Email(firstName, lastName);
        System.out.println(em1.showInfo());
        em1.saveWorkerToFile();

    }
}
