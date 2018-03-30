package rmit;

public class Shop {
    private int Code;
    private String Address;
    private String Owner;
    private String Phone;
    private String Email;
    private double accountBalance;

    public void add(int Code, String Address, String Owner, String Phone, String Email, double accountBalance){
        //code
    }

    public void edit(int Code){
        //code
    }

    public void view(int Code){
        //code
    }

    public void delete(int Code){
        //code
    }

    public Shop() {
    }

    public Shop(int code, String address, String owner, String phone, String email, double accountBalance) {
        Code = code;
        Address = address;
        Owner = owner;
        Phone = phone;
        Email = email;
        this.accountBalance = accountBalance;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
