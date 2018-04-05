package rmit;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
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
            System.out.print("Please choose an option: ");
            userOption = sc.nextLine();
            if (!Arrays.asList(options).contains(userOption))
                System.out.println("Invalid option!");
            else valid = true;
        }
        return userOption;
    }


    public int getId(Set<Integer> ids) {
        Scanner sc = new Scanner(System.in);
        int input=0;
        while (true) {
            System.out.print("Please enter the customer/shop ID to edit/delete: ");
            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Invalid ID!");
            }
            else {
                input = sc.nextInt();
                if (!ids.contains(input)) System.out.println("Invalid ID!");
                else break;
            }
        }
        return input;
    }

    public double getAccountBalance(){
        double AccountBalanceInput;
        Scanner sc;
        while(true){
            System.out.print("Please enter the shop's Account Balance: ");
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

    public int getCodeInput(){
        int CodeInput;
        Scanner sc;
        while(true){
            System.out.print("Please enter the shop's code: ");
            sc = new Scanner(System.in);
            if(sc.hasNextInt()){
                CodeInput = sc.nextInt();
                sc.nextLine();
                break;
            }else {
                System.out.println("Wrong Input!!!");
            }
        }
        return CodeInput;
    }

    public String getName() {
        Scanner sc = new Scanner(System.in);
        String str=null;
        boolean valid = false;
        while (!valid) {
            System.out.print("Please enter the customer's name: ");
            str = sc.nextLine();
            if (str.equals(""))
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
            System.out.print("Please enter the customer's address: ");
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
            System.out.print("Please enter the customer's phone number(10 digits): ");
            phone = sc.nextLine();
            if (!isValidPhone(phone))
                System.out.println("Invalid phone number!");
            else valid = true;
        }
        return phone;
    }

    private boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public String getBirthdate() {
        Scanner sc = new Scanner(System.in);
        String inputDate=null;
        boolean valid = false;
        while (!valid) {
            System.out.print("Please enter the customer's birthdate (YYYY-MM-DD): ");
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
            System.out.print("Please enter the customer's email: ");
            email = sc.nextLine();
            if (!isValidEmail(email))
                System.out.println("Invalid email!");
            else valid = true;
        }
        return email;
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
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
