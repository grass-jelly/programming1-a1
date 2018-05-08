package rmit;

import rmit.decorator.Decorator;

public class Customer {
    private int id;
    private String name;
    private String birthdate;
    private String address;
    private String phone;
    private String email;

    public Customer(int id, String name, String birthdate, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public void getNotified(Drawing drawing) {
        System.out.println("The drawing result is: "+ drawing.getJackpot());
    }

    public void subscribe(Decorator drawing){
        drawing.customers.add(this);
    }

    @Override
    public String toString() {
        return String.format("%05d  %-20.20s  %-20.20s  %-20.20s  %-20.20s  %-20.20s",this.id, this.name,this.birthdate,this.address,this.phone,this.email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
