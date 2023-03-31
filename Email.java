package email_app;

import java.util.Scanner;

public class Email {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String company;
    private String altEmail;
    private int defaultPasswordLength;
    private int mailboxCapacity;

     //Constructor
    @SuppressWarnings("resource") //Closes close scanner warning
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println(this.firstName + " " + this.lastName);

        //Department
        this.department = setDepartment();
        System.out.println(this.department);

        //Gen password
        this.defaultPasswordLength = 8;
        System.out.println(this.defaultPasswordLength);
        this.password = genPassword(defaultPasswordLength);
        System.out.println(this.password);

        //Set company
        this.company = "werbo";

        //Gen email
        this.email = genEmail(this.firstName, this.lastName, this.department, this.company);
        System.out.println(this.email);

        //Set default mailbox capacity
        this.mailboxCapacity = 50;
        System.out.println(String.format("Default mailbox capacity: %s", this.mailboxCapacity));

        //MAINLOOP----------------------------------------------------------------------------------
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Cmd: ");
            String cmd = scan.nextLine();

            //Set mailbox capacity
            if (cmd.equals("mbox_set_cap")) {
                this.mailboxCapacity = setMailBoxCapacity();
                System.out.println(String.format("New mailbox capacity: %s", this.mailboxCapacity));
            }
            //Change password
            else if (cmd.equals("change_password")) {
                this.password = changePassword();
                System.out.println(String.format("New password: %s", this.password));
            }
            //Set alternate email
            else if (cmd.equals("alt_email")) {
                this.altEmail = defAltEmail();
                System.out.println(String.format("Alternate email: %s", this.altEmail));
            }
            //Exit loop
            else if (cmd.equals("!!")) {
                System.out.println(displayData());
                System.out.println("Quit");
                break;
            }
            else {
                System.out.println("Invalid command!");
                continue;
            }
        } while(scan.hasNextLine());
    }

    //Set department
    @SuppressWarnings("resource") //Closes close scanner warning
    private String setDepartment() {
        Scanner in = new Scanner(System.in);
        System.out.print("DEPARTMENTS\n1 Sales\n2 Develepment\n3 Accounting\nChoose department: ");
        int dpChoice = in.nextInt();

        if (dpChoice == 1) { return "sales"; }
        else if (dpChoice == 2) { return "dev"; }
        else if (dpChoice == 3) { return "acc"; }
        else { return ""; }
    }

    //Set password
    private String genPassword(int length) {
        String passChars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789@#!$%";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passChars.length());
            password[i] = passChars.charAt(rand);
        }

        return new String(password); 
    }

    //Gen email
    private String genEmail(String firstName, String lastName, String departmet, String company) {
        return String.format("%s%s@%s.%s.com", firstName, lastName, departmet, company);
    }

    //Set mailbox capacity
    @SuppressWarnings("resource") //Closes close scanner warning
    private int setMailBoxCapacity() {
        Scanner in = new Scanner(System.in);
        System.out.print("Set mailbox capacity: ");
        int newMboxCap = in.nextInt();

        return newMboxCap;
    }

    @SuppressWarnings("resource") //Closes close scanner warning
    private String changePassword() {
        Scanner in = new Scanner(System.in);
        System.out.print("Change password: ");
        String newPass = in.nextLine();

        return newPass;
    }

    //Define alternate email
    @SuppressWarnings("resource") //Closes close scanner warning
    private String defAltEmail() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter alternate email: ");
        String altMail = in.nextLine();

        return altMail;
    }

    //Display data
    private String displayData() {
        String data = String.format("Name: %s %s \nEmail: %s \nMailbox capacity: %s", this.firstName, this.lastName, this.email, this.mailboxCapacity);
        return data;
    }
}