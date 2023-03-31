package email_app;

import java.util.Scanner;

public class EmailApp {

    @SuppressWarnings("resource") //Supresses close scanner warning
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstName;
        String lastName;

        firstName = in.nextLine();
        lastName = in.nextLine();

        Email email1 = new Email(firstName, lastName);
        Email email2 = new Email("bugus", "sugus");
    }
}