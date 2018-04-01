package rmit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<Customer>();
        String userOption = getUserOption("mainMenu");
        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    System.out.println("Customers setting");
                    customer(customerList);
                    break;
                case "2":
                    System.out.println("Shops setting");
                    break;
                case "3":
                    System.out.println("Buying setting");
                    break;
                case "4":
                    System.out.println("Drawing setting");
                    break;
            }
            userOption = getUserOption("mainMenu");
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
            userOption = getUserOption("customerSetting");
        }
    }

    private static String getUserOption(String setting) {
        if (setting.equals("mainMenu")) {
            System.out.println("Main Menu");
            System.out.println("1: Customers");
            System.out.println("2: Shops");
            System.out.println("3: Buying");
            System.out.println("4: Drawing");
            System.out.println("5: Exit");
        } else {
            System.out.println("1. Add");
            System.out.println("2. Edit");
            System.out.println("3. Delete");
            System.out.println("4. View");
            System.out.println("5. Return to Main Menu");
        }


        String[] options = {"1", "2", "3", "4", "5"};
        Scanner sc = new Scanner(System.in);
        String userOption=null;
        boolean valid = false;
        while (!valid) {
            System.out.print("Please choose an option (1-5): ");
            userOption = sc.nextLine();
            if (!Arrays.asList(options).contains(userOption))
                System.out.println("Invalid option!");
            else valid = true;
        }
        return userOption;
    }

}
