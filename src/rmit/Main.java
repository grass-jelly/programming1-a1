package rmit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {
        List<Customer> customerList = new ArrayList<Customer>();
        String userOption = getUserOptionMain();
        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    customer(customerList);
                    break;
                case "2":
                    System.out.println("Shops setting");
                    shop();
                    break;
                case "3":
                    System.out.println("Buying setting");
                    break;
                case "4":
                    drawing();
                    break;
            }
            userOption = getUserOptionMain();
        }
    }

    private static void drawing() {
        String userOption = getUserOptionDrawing();
        while (userOption.equals("1")) {
            Drawing drawing = new Drawing();
            int[] jackpot = drawing.generate();
            String newDrawOption = getUserOptionNewDraw(jackpot);
            while (!newDrawOption.equals("3")) {
                if (newDrawOption.equals("1"))
                    drawing.trigger1(jackpot, 1);
                else drawing.trigger5(jackpot);
                newDrawOption = getUserOptionNewDraw(jackpot);
            }
            userOption = getUserOptionDrawing();
        }
    }

    private static void shop() throws IOException {
        Scanner sc = new Scanner(System.in);
        String userOption = getUserOption("shopSetting");
        Shop shop = new Shop();
        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    String Code, Address, Owner, Phone, Email;
                    double accountBalance;
                    System.out.println("Type Code: ");
                    Code = sc.nextLine();
                    System.out.println("Type Address: ");
                    Address = sc.nextLine();
                    System.out.println("Type Owner: ");
                    Owner = sc.nextLine();
                    System.out.println("Type Phone: ");
                    Phone = sc.nextLine();
                    System.out.println("Type Email: ");
                    Email = sc.nextLine();
                    System.out.println("Type Account Balance: ");
                    accountBalance = sc.nextDouble();
                    shop.add(Code, Address, Owner, Phone, Email, accountBalance);
                    System.out.println("Add Shop Successful!!!");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    List<String> listShop;
                    listShop = shop.viewAll();
                    System.out.println("***************List Shop***************");
                    for(String a: listShop){
                        System.out.println(a);
                    }
                    break;
            }
            userOption = getUserOption("shopSetting");
        }
    }

    private static void customer(List<Customer> customerList) {
        String userOption = getUserOption("customerSetting");

        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    System.out.println("1");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("4");
                    break;
            }
            userOption = getUserOptionCustomer();
        }
    }

    private static String validate(String[] options) {
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

    private static String getUserOptionMain() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Main Menu");
        System.out.println("1: Customers");
        System.out.println("2: Shops");
        System.out.println("3: Buying");
        System.out.println("4: Drawing");
        System.out.println("5: Exit");
        String[] options = {"1", "2", "3", "4", "5"};
        return validate(options);

    }

    private static String getUserOptionCustomer() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Customers");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Return to Main Menu");
    private static String getUserOption(String setting) {
        if (setting.equals("mainMenu")) {
            System.out.println("***************************");
            System.out.println("Main Menu");
            System.out.println("1: Customers");
            System.out.println("2: Shops");
            System.out.println("3: Buying");
            System.out.println("4: Drawing");
            System.out.println("5: Exit");
        } else {
            System.out.println("***************************");
            System.out.println("1. Add");
            System.out.println("2. Edit");
            System.out.println("3. Delete");
            System.out.println("4. View");
            System.out.println("5. Return to Main Menu");
        }


        String[] options = {"1", "2", "3", "4", "5"};
        return validate(options);
    }

    private static String getUserOptionDrawing() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Drawing");
        System.out.println("1. New Draw");
        System.out.println("2. Return to Main Menu");
        String[] options = {"1", "2"};
        return validate(options);
    }

    private static String getUserOptionNewDraw(int[] jackpot) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("New Draw");
        System.out.println("Jackpot: " + Arrays.toString(jackpot));
        System.out.println("1. Trigger once");
            System.out.println("2. Trigger 5x");
            System.out.println("3. Back");
            String[] options = {"1", "2", "3"};
            return validate(options);
    }


}
