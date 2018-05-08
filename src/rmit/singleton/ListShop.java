package rmit.singleton;

import rmit.Shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListShop {
    private static Map<Integer, Shop> lsShop = new HashMap<>();
    private static ListShop instance = null;

    private ListShop() {

    }
    public static ListShop getInstance(){
        if(instance == null){
            instance = new ListShop();
        }
        return instance;

    }

    public Shop addShop(int code, String address, String owner, String phone, String email, double accountBalance){
        Shop tmpshop = new Shop(code, address, owner, phone, email, accountBalance);
        return tmpshop;
    }

    public Map<Integer, Shop> getlsShop(){
        return lsShop;
    }
}
