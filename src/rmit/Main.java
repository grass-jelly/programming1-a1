package rmit;

import java.util.*;

public class Main {
    private static Map<Integer, Customer> customerList = new HashMap<>();
    private static int customerID=1;
    public static void main(String[] args) {
        List<Shop> listShop = new ArrayList<>();

        Customer customer1 = new Customer(customerID++, "Linh Do", "1997-05-04", "702 Nguyen Van Linh, D7",
                "0912900300", "linhdo@gmail.com");
        Customer customer2 = new Customer(customerID++, "John Doe", "1990-09-01", "42 Nguyen Hue, D1",
                "0912900400", "johndoe@gmail.com");
        Customer customer3 = new Customer(customerID++, "Mary Angelou", "1980-04-04",
                "1050 College St, D2", "0912900800", "maryangelou@gmail.com");
        customerList.put(1, customer1);
        customerList.put(2, customer2);
        customerList.put(3, customer3);

        Shop shop1 = new Shop(1, "100 Dien Bien Phu, Q10", "Nghi Quynh", "quynh@gmail.com",
                "0986292444", 800000);
        Shop shop2 = new Shop(2, "256 Dinh Tien Hoang, Q.GoVap", "Nhut Khanh", "khanh@gmail.com",
                "0986393456", 1000000);

        listShop.addAll(Arrays.asList(shop1, shop2));

        String userOption = getUserOptionMain();
        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    customer(customerList);
                    break;
                case "2":
                    shopsetting(listShop);
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
            Drawing drawing = new Drawing();
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
            Validation v = new Validation();
            switch (userOption) {
                case "1":
                    id = customerID++;
                    customerList.put(id, new Customer(id, v.getName(), v.getBirthdate(), v.getAddress(), v.getPhone(), v.getEmail()));
                    System.out.println("Add Successful!!");
                    break;
                case "2":
                    System.out.println("2");
                    // get id
                    id = v.getId(customerList.keySet());
                    // get option
                    userOption = getCustomerEditOption();
                    Customer customer = customerList.get(id);
                    switch (userOption) {
                        case "1":
                            customer.setName(v.getName());
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
                    id = v.getId(customerList.keySet());
                    customerList.remove(id);
                    System.out.println("Delete Successful!!");
                    break;
                case "4":
                    System.out.printf("%-7s%-22s%-22s%-22s%-22s%-22s\n","ID", "Name","Birthdate","Address","Phone","Email");
                    System.out.println("---------------------------------------------------------------------------" +
                            "----------------------------------------");
                    for (Customer cus : customerList.values())
                        System.out.println(cus);
                    break;
            }
            userOption = getUserOptionCustomer();
        }
    }

    private static void shopsetting(List<Shop> listShop) {
        String userOption = getUserOptionShop();
        Validation valid;
        Scanner sc;
        int Code;
        String Address, Email, Owner, Phone;
        double AccountBalance;

        while (!userOption.equals("5")) {
            switch (userOption) {
                case "1":
                    valid = new Validation();
                    Code = valid.getCodeInput();
                    Address = valid.getAddress();
                    Owner = valid.getName();
                    Email = valid.getEmail();
                    Phone = valid.getPhone();
                    AccountBalance = valid.getAccountBalance();
                    Shop shopST = new Shop(Code, Address,Owner, Email, Phone, AccountBalance);
                    listShop.add(shopST);
                    System.out.println("Add Successful!!");
                    break;
                case "2":

                    String userEditOption = getUserEditOption();
                    while(!userEditOption.equals("3")){
                        switch (userEditOption){
                            case "1":
                                editAllFieldShop(listShop);
                                break;
                            case "2":
                                String userFieldEditOption = getUserFieldEditOption();
                                while(!userFieldEditOption.equals("6")){
                                    switch (userFieldEditOption){
                                        case "1":
                                            editOneFieldShop(listShop, "Address");
                                            break;
                                        case "2":
                                            editOneFieldShop(listShop, "Owner");
                                            break;
                                        case "3":
                                            editOneFieldShop(listShop, "Email");
                                            break;
                                        case "4":
                                            editOneFieldShop(listShop, "Phone");
                                            break;
                                        case "5":
                                            editOneFieldShop(listShop, "AccountBalance");
                                            break;
                                    }
                                    userFieldEditOption = getUserFieldEditOption();
                                }
                                break;
                        }
                        userEditOption = getUserEditOption();
                    }
                    break;
                case "3":
                    sc = new Scanner(System.in);
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
                    System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n","Code","Address","Owner","Email","Phone","AccountBalance");
                    System.out.println("---------------------------------------------------------------------------" +
                            "----------------------------------------------------");
                    for(Shop item: listShop){
                        System.out.println(item);
                    }
                    break;
            }
            userOption = getUserOptionShop();
        }
    }

    private static void editOneFieldShop(List<Shop> listShop, String nameField){
        Validation valid = new Validation();
        Shop shop = new Shop();
        Scanner sc = new Scanner(System.in);
        String Address, Owner, Email, Phone;
        double AccountBalance;
        int index = 0;
        System.out.println("************Edit Mode************");
        System.out.println("Please enter the shop's code that you want to modify: ");
        int Code = sc.nextInt();
        sc.nextLine();
        for(Shop item: listShop){
            if(item.getCode() == Code){
                index = listShop.indexOf(item);
                shop = item;
            }
        }
        switch (nameField){
            case "Address":
                System.out.println("New Address");
                Address = valid.getAddress();
                listShop.set(index, new Shop(Code, Address, shop.getOwner(), shop.getEmail(), shop.getPhone(),
                        shop.getAccountBalance()));
                System.out.println("Edit Successful!!!");
                break;
            case "Owner":
                System.out.println("New Owner");
                Owner = valid.getName();
                listShop.set(index, new Shop(Code, shop.getAddress(), Owner, shop.getEmail(), shop.getPhone(),
                        shop.getAccountBalance()));
                System.out.println("Edit Successful!!!");
                break;
            case "Email":
                System.out.println("New Email");
                Email = valid.getEmail();
                listShop.set(index, new Shop(Code, shop.getAddress(), shop.getOwner(), Email, shop.getPhone(),
                        shop.getAccountBalance()));
                System.out.println("Edit Successful!!!");
                break;
            case "Phone":
                System.out.println("New Phone Number");
                Phone = valid.getPhone();
                listShop.set(index, new Shop(Code, shop.getAddress(), shop.getOwner(), shop.getEmail(), Phone,
                        shop.getAccountBalance()));
                System.out.println("Edit Successful!!!");
                break;
            case "AccountBalance":
                System.out.println("New Account Balance Number");
                AccountBalance = valid.getAccountBalance();
                listShop.set(index, new Shop(Code, shop.getAddress(), shop.getOwner(), shop.getEmail(),
                        shop.getPhone(), AccountBalance));
                System.out.println("Edit Successful!!!");
                break;
        }
    }

    private static void editAllFieldShop(List<Shop> listShop){
        Scanner sc;
        String Address, Owner, Email, Phone;
        double AccountBalance;
        sc = new Scanner(System.in);
        int index = 0;
        System.out.println("************Edit Mode************");
        System.out.println("Please type the shop's code that you want to modify: ");
        int Code = sc.nextInt();
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
    }

    private static String getUserEditOption(){

        String[] options = {"1", "2", "3"};
        System.out.println("**********************Edit Mode**********************");
        System.out.println("1. Modify all fields");
        System.out.println("2. Modify One field.");
        System.out.println("3. Return to Shop Menu");
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

    private static String getUserFieldEditOption() {
        System.out.println("---------------------------------------------------------------------------" +
                "---------------------------------");
        System.out.println("1. Address");
        System.out.println("2. Owner");
        System.out.println("3. Email");
        System.out.println("4. Phone");
        System.out.println("5. Account Balance");
        System.out.println("6. Return");
        String[] options = {"1", "2", "3","4", "5", "6"};
        return Validation.validateMenu(options);
    }


}
