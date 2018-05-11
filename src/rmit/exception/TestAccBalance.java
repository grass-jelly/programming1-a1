package rmit.exception;

import java.util.Scanner;

public class TestAccBalance {
    public static boolean getAccountBalance(String temp) throws AccBalanceException{
            if(temp.trim().length() == 0){
                throw new AccBalanceException("Can not enter blank input!!");
            }else if (!temp.trim().matches("[0-9]+(\\.[0-9]+)") && !temp.trim().matches("\\d+")){
                throw new AccBalanceException("Must be a positive number!");
            }else{
                return true;
            }


    }
}
