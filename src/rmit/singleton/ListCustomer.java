package rmit.singleton;

import rmit.Customer;

import java.util.HashMap;
import java.util.Map;

public class ListCustomer {
    private static Map<Integer, Customer> lsCustomer = new HashMap<>();
    private static ListCustomer instance = null;
    private ListCustomer() {
    }
    public static ListCustomer getInstance(){
        if(instance == null){
            instance = new ListCustomer();
        }
        return instance;
    }

    public Customer addCustomer(int id, String name, String birthdate, String address, String phone, String email){
        Customer tmpcustomer =  new Customer( id, name, birthdate, address, phone, email);
        return tmpcustomer;
    }

    public Map<Integer, Customer> getLsCustomer(){
        return lsCustomer;
    }
}
