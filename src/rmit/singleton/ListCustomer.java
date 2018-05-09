package rmit.singleton;

import rmit.Customer;

import java.util.HashMap;
import java.util.Map;

public class ListCustomer {
    private Map<Integer, Customer> lsCustomer = new HashMap<>();
    private static ListCustomer instance = null;
    private ListCustomer() {
    }
    public static ListCustomer getInstance(){
        if(instance == null){
            instance = new ListCustomer();
        }
        return instance;
    }


    public Map<Integer, Customer> getLsCustomer(){
        return lsCustomer;
    }


}
