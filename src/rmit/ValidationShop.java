package rmit;

import java.util.Scanner;
import java.util.Set;

public class ValidationShop extends Validation {

    @Override
    public int getId(Set<Integer> ids) {
        Scanner sc = new Scanner(System.in);
        int id;
        String input;
        while (true) {
            System.out.println("Please enter the shop ID to edit/delete: ");
            input = sc.nextLine();
            if(input.trim().length() == 0){
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

    public double getAccountBalance(){
        Scanner sc;
        while(true){
            System.out.println("Please enter the shop's Account Balance: ");
            sc = new Scanner(System.in);
            String temp = sc.nextLine();
            if(temp.trim().length() == 0){
                System.out.println("Can not enter blank input!!");
            }else if (temp.trim().matches("[0-9]+(\\.[0-9]+)")){
                return Double.valueOf(temp);
            }else if (temp.trim().matches("\\d+")) {
                return Double.valueOf(temp);
            }else{
                System.out.println("Wrong Input!!!");
            }
        }
    }

    @Override
    public String getAddress() {
        Scanner sc = new Scanner(System.in);
        String str=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the shop's address: ");
            str = sc.nextLine();
            if (str.trim().length() == 0)
                System.out.println("Can not enter blank input!!");
            else valid = true;
        }
        return str;
    }

    @Override
    public String getPhone() {
        Scanner sc = new Scanner(System.in);
        String phone=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the shop's phone number(10 digits): ");
            phone = sc.nextLine();
            if (phone.trim().length() == 0){
                System.out.println("Can not enter blank input!!");
            }else if (!phone.matches("^[0-9]{10}$"))
                System.out.println("Invalid phone number!");
            else valid = true;
        }
        return phone;
    }

    @Override
    public String getName() {
        Scanner sc = new Scanner(System.in);
        String str=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the shop's name: ");
            str = sc.nextLine();
            if (str.trim().length() == 0) {
                System.out.println("Can not enter blank input!!");
            }else if (!str.matches("^[A-z]+$"))
                System.out.println("Invalid name!");
            else valid = true;
        }
        return str;
    }

    @Override
    public String getEmail() {
        Scanner sc = new Scanner(System.in);
        String email=null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter the shop's email: ");
            email = sc.nextLine();
            if (email.trim().length() == 0) {
                System.out.println("Can not enter blank input!!");
            }else if (!email.matches("^.+@.+\\..+$"))
                System.out.println("Invalid email!");
            else valid = true;
        }
        return email;
    }
}
