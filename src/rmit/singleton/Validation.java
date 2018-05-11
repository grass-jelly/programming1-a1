package rmit.singleton;

import rmit.exception.NameException;
import rmit.exception.TestName;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Validation {

    //Validation Singletone
    private static Validation instance = new Validation();
    private Validation() {
    }
    public static Validation getInstance(){
        return instance;
    }

    public static String validateMenu(String[] options) {
        Scanner sc = new Scanner(System.in);
        String userOption=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please choose an option: ");
            userOption = sc.nextLine();
            if(userOption.trim().length() == 0){
                System.out.println("Can not enter blank input!!");
            }else if (!Arrays.asList(options).contains(userOption)) {
                System.out.println("Invalid option!");
            }else {
                valid = true;
            }
        }
        return userOption;
    }


    public int getId(Set<Integer> ids) {
        Scanner sc = new Scanner(System.in);
        int id;
        String input;
        while (true) {
            System.out.println("Please enter the customer ID to edit/delete: ");
            input = sc.nextLine();
            if(input.trim().length() == 0) {
                System.out.println("Can not enter blank input!!");
            }else if (!input.matches("\\d+")) {
                System.out.println("Invalid ID!");
            }
            else {
                id = Integer.valueOf(input);
                if (!ids.contains(id)) System.out.println("Invalid ID!");
                else break;
            }
        }
        return id;
    }



    public String getName(){
        Scanner sc = new Scanner(System.in);
        String str=null;
        while (true) {
            System.out.println("Please enter the customer's name: ");
            str = sc.nextLine();
            if (!testName(str)){
                continue;
            }
            else{
                break;
            }
        }
        return str;
    }

    public static boolean testName(String str) {
        try {
            return TestName.getName(str);
        } catch (NameException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String getAddress() {
        Scanner sc = new Scanner(System.in);
        String str=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the customer's address: ");
            str = sc.nextLine();
            if (str.trim().length() == 0)
                System.out.println("Can not enter blank input!!");
            else valid = true;
        }
        return str;
    }

    public String getPhone() {
        Scanner sc = new Scanner(System.in);
        String phone=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the customer's phone number(10 digits): ");
            phone = sc.nextLine();
            if (phone.trim().length() == 0){
                System.out.println("Can not enter blank input!!");
            }else if (!phone.matches("^[0-9]{10}$"))
                System.out.println("Invalid phone number!");
            else valid = true;
        }
        return phone;
    }

    public String getBirthdate() {
        Scanner sc = new Scanner(System.in);
        String inputDate=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the customer's birthdate (YYYY-MM-DD): ");
            inputDate = sc.nextLine();
            if (inputDate.trim().length() == 0) {
                System.out.println("Can not enter blank input!!");
            }else if (!isValidDate(inputDate)) {
                System.out.println("Invalid birthdate!");
            }else{
                valid = true;
            }
        }
        return inputDate;
    }

    public String getEmail() {
        Scanner sc = new Scanner(System.in);
        String email=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the customer's email: ");
            email = sc.nextLine();
            if (email.trim().length() == 0) {
                System.out.println("Can not enter blank input!!");
            }else if (!email.matches("^.+@.+\\..+$")) {
                System.out.println("Invalid email!");
            }else{
                valid = true;
            }
        }
        return email;
    }

    private boolean isValidDate(String inputDate) {
        try {
            LocalDate.parse(inputDate);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
