package rmit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String Code;
    private String Address;
    private String Owner;
    private String Phone;
    private String Email;
    private double accountBalance;

    public void add(String Code, String Address, String Owner, String Phone, String Email, double accountBalance) throws IOException {
        Writer output;
        output =  new BufferedWriter(new FileWriter("data.txt", true));
        output.append(Code + "\t" + Address + "\t" + Owner + "\t" + Phone + "\t" + Email + "\t" + accountBalance + "\r\n");
        output.close();
    }

    public void edit(String Code){
        //code
    }

    public String view(String code) throws IOException {
        File file = new File("data.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String result = null;
        String line;
        while ((line = br.readLine()) != null){
            String[] fields = line.split("\t");
            if(fields[0].equals(code)){
                result = line;
            }
        }
        br.close();
        return result;
    }

    public List<String> viewAll() throws IOException {
        File file = new File("data.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        List<String> result = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null){
            result.add(line);
            }
        br.close();
        return result;
    }

    public void delete(String Code){
        //code
    }

    public Shop() {
    }

    public Shop(String code, String address, String owner, String phone, String email, double accountBalance) {
        Code = code;
        Address = address;
        Owner = owner;
        Phone = phone;
        Email = email;
        this.accountBalance = accountBalance;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
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
