package rmit;

import rmit.Singleton.Validation;
import rmit.Singleton.ValidationShop;

import java.util.*;

public class Main {
    private static Map<Integer, Customer> customerList = new HashMap<>();
    private static Map<Integer, Shop> shopList = new HashMap<>();
    private static Drawing drawing = new Drawing();
    private static int customerID=1, shopID=1;
    public static void main(String[] args) {

        Customer customer1 = new Customer(customerID++, "Linh Do", "1997-05-04", "702 Nguyen Van Linh, D7",
                "0912900300", "linhdo@gmail.com");
        customer1.subscribe(drawing);
        Customer customer2 = new Customer(customerID++, "John Doe", "1990-09-01", "42 Nguyen Hue, D1",
                "0912900400", "johndoe@gmail.com");
        customer2.subscribe(drawing);
        Customer customer3 = new Customer(customerID++, "Mary Angelou", "1980-04-04",
                "1050 College St, D2", "0912900800", "maryangelou@gmail.com");
        customer3.subscribe(drawing);
        customerList.put(1, customer1);
        customerList.put(2, customer2);
        customerList.put(3, customer3);

        Shop shop1 = new Shop(shopID++, "100 Dien Bien Phu, Q10", "Nghi Quynh", "quynh@gmail.com",
                "0986292444", 800000);
        Shop shop2 = new Shop(shopID++, "256 Dinh Tien Hoang, Q.GoVap", "Nhut Khanh", "khanh@gmail.com",
                "0986393456", 1000000);

        shopList.put(1, shop1);
        shopList.put(2, shop2);

        String userOption = getUserOptionMain();
        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    customer(customerList);
                    break;
                case "2":
                    shop(shopList);
                    break;
                case "3":
                    drawing();
                    break;
                case "4":
                    buying();
                    break;
            }
            userOption = getUserOptionMain();
        }
    }

    private static void drawing() {
        String userOption = getUserOptionDrawing();
        while (userOption.equals("1")) {
            int[] jackpot = drawing.generate();
            System.out.println("Jackpot: " + Arrays.toString(jackpot));
            userOption = getUserOptionDrawing();
        }
    }

    private static void buying() {
        String userOption = getUserOptionBuying();
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
            userOption = getUserOptionBuying();
        }
    }

    private static void customer(Map<Integer, Customer> customerList) {
        String userOption = getUserOptionCustomer();
        int id;
        while (!userOption.equals("5")) {
            Validation v = Validation.getInstance();
            switch (userOption) {
                case "1":
                    id = customerID++;
                    Customer cus = new Customer(id, v.getName(), v.getBirthdate(), v.getAddress(), v.getPhone(), v.getEmail());
                    customerList.put(id, cus);
                    cus.subscribe(drawing);
                    System.out.println("Add Successful!!");
                    break;
                case "2":
                    viewCustomer();
                    // get id
                    id = v.getId(customerList.keySet());
                    // get option
                    userOption = getCustomerEditOption();
                    Customer customer = customerList.get(id);
                    switch (userOption) {
                        case "1":
                            CustomerSetNameCommand cm = new CustomerSetNameCommand(customer, v.getName());
                            cm.execute();
                            break;
                        case "2":
                            customer.setBirthdate(v.getBirthdate());
                            break;
                        case "3":
                            customer.setAddress(v.getAddress());
                            break;
                        case "4":
                            customer.setPhone(v.getPhone());
                            break;
                        case "5":
                            customer.setEmail(v.getEmail());
                            break;
                    }
                    System.out.println("Edit Successful!!");
                    break;
                case "3":
                    viewCustomer();
                    id = v.getId(customerList.keySet());
                    customerList.remove(id);
                    System.out.println("Delete Successful!!");
                    break;
                case "4":
                    viewCustomer();
                    break;
            }
            userOption = getUserOptionCustomer();
        }
    }

    private static void shop(Map<Integer, Shop> shopList) {
        String userOption = getUserOptionShop();
        int id;
        ValidationShop v = ValidationShop.getInstance();

        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    id = shopID++;
                    shopList.put(id, new Shop(id, v.getAddress(), v.getName(), v.getEmail(), v.getPhone(), v.getAccountBalance()));
                    System.out.println("Add Successful!!");
                    break;
                case "2":
                    viewShop();
                    // get id
                    id = v.getId(shopList.keySet());
                    // get option
                    userOption = getShopEditOption();
                    Shop shop = shopList.get(id);
                    switch (userOption) {
                        case "1":
                            shop.setAddress(v.getAddress());
                            break;
                        case "2":
                            shop.setOwner(v.getName());
                            break;
                        case "3":
                            shop.setPhone(v.getPhone());
                            break;
                        case "4":
                            shop.setEmail(v.getEmail());
                            break;
                        case "5":
                            shop.setAccountBalance(v.getAccountBalance());
                            break;
                    }
                    System.out.println("Edit Successful!!");
                    break;
                case "3":
                    viewShop();
                    id = v.getId(shopList.keySet());
                    shopList.remove(id);
                    System.out.println("Delete Successful!!");
                    break;
                case "4":
                    viewShop();
                    break;
            }
            userOption = getUserOptionShop();
        }
    }

    private static String getShopEditOption(){

        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        System.out.println("Edit Shop");
        System.out.println("1: Address");
        System.out.println("2: Owner");
        System.out.println("3: Phone");
        System.out.println("4: Email");
        System.out.println("5: Account Balance");
        String[] options = {"1", "2", "3", "4", "5"};
        return Validation.validateMenu(options);
    }

    private static String getCustomerEditOption() {
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        System.out.println("Edit Customer");
        System.out.println("1: Name");
        System.out.println("2: Birthdate");
        System.out.println("3: Address");
        System.out.println("4: Phone");
        System.out.println("5: Email");
        String[] options = {"1", "2", "3", "4", "5"};
        return Validation.validateMenu(options);

    }

    private static String getUserOptionMain() {
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        System.out.println("Main Menu");
        System.out.println("1: Customers");
        System.out.println("2: Shops");
        System.out.println("3: Drawing");
        System.out.println("4: Buying");
        System.out.println("5: Exit");
        String[] options = {"1", "2", "3", "4", "5"};
        return Validation.validateMenu(options);

    }

    private static String getUserOptionCustomer() {
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        System.out.println("Customers");
        System.out.println("1: Add");
        System.out.println("2: Edit");
        System.out.println("3: Delete");
        System.out.println("4: View");
        System.out.println("5: Return to Main Menu");
        String[] options = {"1", "2", "3", "4", "5"};
        return Validation.validateMenu(options);
    }

    private static String getUserOptionShop() {
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        System.out.println("Shops");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Return to Main Menu");
        String[] options = {"1", "2", "3", "4", "5"};
        return Validation.validateMenu(options);
    }

    private static String getUserOptionBuying() {
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        System.out.println("Buying");
        System.out.println("1: New Simulation");
        System.out.println("2: Return to Main Menu");
        String[] options = {"1", "2"};
        return Validation.validateMenu(options);
    }

    private static String getUserOptionDrawing() {
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        System.out.println("Drawing");
        System.out.println("1: New Draw");
        System.out.println("2: Return to Main Menu");
        String[] options = {"1", "2"};
        return Validation.validateMenu(options);
    }

    private static String getUserOptionNewDraw(int[] jackpot) {
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        System.out.println("New Simulation");
        System.out.println("Jackpot: " + Arrays.toString(jackpot));
        System.out.println("1. Trigger once");
        System.out.println("2. Trigger 5x");
        System.out.println("3. Back");
        String[] options = {"1", "2", "3"};
        return Validation.validateMenu(options);
    }

    private static void viewCustomer() {

        System.out.printf("%-7s%-22s%-22s%-22s%-22s%-22s\n","ID", "Name","Birthdate","Address","Phone","Email");
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        for (Customer cus : customerList.values())
            System.out.println(cus);
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");

    }

    private static void viewShop() {

        System.out.printf("%-7s%-22s%-22s%-22s%-22s%-22s\n","Code","Address","Owner","Email","Phone","Account Balance");
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");
        for (Shop shop : shopList.values())
            System.out.println(shop);
        System.out.println("---------------------------------------------------------------------------" +
                "----------------------------------------");

    }

}
