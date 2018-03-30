package rmit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            menu();
            int user_Option = scanner.nextInt();
            if(user_Option == 1){
                System.out.println("Customer setting");
                break;
            }else if(user_Option == 2){
                System.out.println("Shop setting");

            }else if(user_Option == 3){
                System.out.println("Buying setting");
                break;
            }else if(user_Option == 4){
                System.out.println("Drawing setting");
                break;
            }else if(user_Option == 5){
                System.out.println("Exit Program!!");
                break;
            }else {
                System.out.println("Invalid Option!!");
            }

        }
    }

    private static void menu(){
        System.out.println("1: Customer");
        System.out.println("2: Shop");
        System.out.println("3: Buying");
        System.out.println("4: Drawing");
        System.out.println("5: Exit");
        System.out.println("Please choose options from 1 to 5: ");
    }


}
