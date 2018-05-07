package rmit.Singleton;

public class FactoryShopSingleton {
    private static FactoryShopSingleton instance = null;
    private FactoryShopSingleton() {
    }
    public static FactoryShopSingleton getInstance(){
        if(instance == null){
            instance = new FactoryShopSingleton();
        }
        return instance;
    }

    public Shop create() {return new Shop();}
    public Shop create(int code, String address, String owner, String email, String phone, double accountBalance) {
        return new Shop(code, address, owner, email, phone, accountBalance);}
}
