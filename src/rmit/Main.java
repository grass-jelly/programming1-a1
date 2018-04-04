package rmit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Shop> listShop = new ArrayList<>();
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<Customer>();
        Customer customer1 = new Customer("Linh Do", "1997-05-04", "702 Nguyen Van Linh, D7",
                "0912900300", "linhdo@gmail.com");
        Customer customer2 = new Customer("John Doe", "1990-09-01", "42 Nguyen Hue, D1",
                "0912900400", "johndoe@gmail.com");
        Customer customer3 = new Customer("Mary Angelou", "1980-04-04",
                "1050 College St, D2", "0912900800", "maryangelou@gmail.com");
        customerList.addAll(Arrays.asList(customer1, customer2, customer3));

        Shop shop1 = new Shop();
        shop1.setCode(1);
        shop1.setAccountBalance(800000);
        shop1.setAddress("Q2");
        shop1.setEmail("quynh@gmail.com");
        shop1.setOwner("Quynh");
        shop1.setPhone("0986292444");
        listShop.add(shop1);

        Shop shop2 = new Shop();
        shop2.setCode(2);
        shop2.setAccountBalance(1000000);
        shop2.setAddress("Q3");
        shop2.setEmail("khanh@gmail.com");
        shop2.setOwner("Khanh");
        shop2.setPhone("0986393456");
        listShop.add(shop2);

        String userOption = getUserOptionMain();
        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    customer(customerList);
                    break;
                case "2":
                    System.out.println("Shops setting");
                    shopsetting();
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

    private static void customer(List<Customer> customerList) {
        String userOption = getUserOptionCustomer();
        while (!userOption.equals("5")) {
            Validation v = new Validation();
            switch (userOption) {
                case "1":
                    customerList.add(new Customer(v.getName(), v.getBirthdate(), v.getAddress(), v.getPhone(), v.getEmail()));
                    System.out.println("Add Successful!!");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.printf("%-22s%-22s%-22s%-22s%-22s\n","Name","Birthdate","Address","Phone","Email");
                    System.out.println("---------------------------------------------------------------------------" +
                            "---------------------------------");
                    for (Customer customer : customerList)
                        System.out.println(customer);
                    break;
            }
            userOption = getUserOptionCustomer();
        }
    }

    private static void shopsetting() {
        String userOption = getUserOptionShop();
        Scanner sc = new Scanner(System.in);
        Shop shopST = new Shop();
        int Code;
        String Address, Email, Owner, Phone;
        double AccountBalance;

        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    System.out.println("Please type the Code: ");
                    Code = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please type the Address: ");
                    Address = sc.nextLine();
                    System.out.println("Please type the Owner: ");
                    Owner = sc.nextLine();
                    System.out.println("Please type the Email: ");
                    Email = sc.nextLine();
                    System.out.println("Please type the Phone: ");
                    Phone = sc.nextLine();
                    System.out.println("Please type the Account Balance: ");
                    AccountBalance = sc.nextDouble();

                    shopST.setCode(Code);
                    shopST.setAddress(Address);
                    shopST.setOwner(Owner);
                    shopST.setEmail(Email);
                    shopST.setPhone(Phone);
                    shopST.setAccountBalance(AccountBalance);

                    listShop.add(shopST);
                    System.out.println("Add Successful!!");
                    break;
                case "2":
                    int index = 0;
                    System.out.println("************Edit Mode************");
                    System.out.println("Please type the code shop: ");
                    Code = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please type the Address: ");
                    Address = sc.nextLine();
                    System.out.println("Please type the Owner: ");
                    Owner = sc.nextLine();
                    System.out.println("Please type the Email: ");
                    Email = sc.nextLine();
                    System.out.println("Please type the Phone: ");
                    Phone = sc.nextLine();
                    System.out.println("Please type the Account Balance: ");
                    AccountBalance = sc.nextDouble();
                    for(Shop item: listShop){
                        if(item.getCode() == Code){
                            index = listShop.indexOf(item);
                        }
                    }
                    listShop.set(index, new Shop(Code, Address, Owner, Email, Phone, AccountBalance));
                    System.out.println("Edit Successful!!!");
                    break;
                case "3":
                    System.out.println("Please type the code shop: ");
                    Code = sc.nextInt();
                    for(Shop item: listShop){
                        if(item.getCode() == Code){
                            listShop.remove(item);
                            System.out.println("Delete Successful!!");
                            break;
                        }
                    }
                    break;
                case "4":
                    System.out.println("*********************List Shops*********************");
                    System.out.println("Code    Address    Owner    Email    Phone    AccountBalance");
                    for(Shop item: listShop){
                        System.out.println(item.getCode() + "\t" + item.getAddress() + "\t" + item.getOwner() + "\t" + item.getEmail() + "\t" + item.getPhone() + "\t" + item.getAccountBalance());
                    }
                    break;
            }
            userOption = getUserOptionShop();
        }
    }

    private static String getUserOptionMain() {
        System.out.println("---------------------------------------------------------------------------" +
                "---------------------------------");
        System.out.println("Main Menu");
        System.out.println("1: Customers");
        System.out.println("2: Shops");
        System.out.println("3: Buying");
        System.out.println("4: Drawing");
        System.out.println("5: Exit");
        String[] options = {"1", "2", "3", "4", "5"};
        return Validation.validateMenu(options);

    }

    private static String getUserOptionCustomer() {
        System.out.println("---------------------------------------------------------------------------" +
                "---------------------------------");
        System.out.println("Customers");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Return to Main Menu");
        String[] options = {"1", "2", "3", "4", "5"};
        return Validation.validateMenu(options);
    }

    private static String getUserOptionShop() {
        System.out.println("---------------------------------------------------------------------------" +
                "---------------------------------");
        System.out.println("Shops");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Return to Main Menu");
        String[] options = {"1", "2", "3", "4", "5"};
        return Validation.validateMenu(options);
    }

    private static String getUserOptionDrawing() {
        System.out.println("---------------------------------------------------------------------------" +
                "---------------------------------");
        System.out.println("Drawing");
        System.out.println("1. New Draw");
        System.out.println("2. Return to Main Menu");
        String[] options = {"1", "2"};
        return Validation.validateMenu(options);
    }

    private static String getUserOptionNewDraw(int[] jackpot) {
        System.out.println("---------------------------------------------------------------------------" +
                "---------------------------------");
        System.out.println("New Draw");
        System.out.println("Jackpot: " + Arrays.toString(jackpot));
        System.out.println("1. Trigger once");
            System.out.println("2. Trigger 5x");
            System.out.println("3. Back");
            String[] options = {"1", "2", "3"};
            return Validation.validateMenu(options);
    }


}
