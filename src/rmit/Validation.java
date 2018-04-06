package rmit;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static String validateMenu(String[] options) {
        Scanner sc = new Scanner(System.in);
        String userOption=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please choose an option: ");
            userOption = sc.nextLine();
            if (!Arrays.asList(options).contains(userOption))
                System.out.println("Invalid option!");
            else valid = true;
        }
        return userOption;
    }


    public int getId(Set<Integer> ids) {
        Scanner sc = new Scanner(System.in);
        int id=0;
        String input;
        while (true) {
            System.out.println("Please enter the customer/shop ID to edit/delete: ");
            input = sc.nextLine();
            if (!input.matches("\\d+")) {
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

    public double getAccountBalance(){
        double AccountBalanceInput;
        Scanner sc;
        while(true){
            System.out.println("Please enter the shop's Account Balance: ");
            sc = new Scanner(System.in);
            if(sc.hasNextDouble()){
                AccountBalanceInput = sc.nextDouble();
                break;
            }else {
                System.out.println("Wrong Input!!!");
            }
        }
        return AccountBalanceInput;
    }


    public String getName() {
        Scanner sc = new Scanner(System.in);
        String str=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the customer's name: ");
            str = sc.nextLine();
            if (!str.matches("^[A-z]+$"))
                System.out.println("Invalid name!");
            else valid = true;
        }
        return str;
    }

    public String getAddress() {
        Scanner sc = new Scanner(System.in);
        String str=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the customer's address: ");
            str = sc.nextLine();
            if (str.equals(""))
                System.out.println("Invalid address!");
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
            if (!phone.matches("^[0-9]{10}$"))
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
            if (!isValidDate(inputDate))
                System.out.println("Invalid birthdate!");
            else valid = true;
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
            if (!email.matches("^.+@.+\\..+$"))
                System.out.println("Invalid email!");
            else valid = true;
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
