package rmit;

public class Customer {
    private String name;
    private String birthdate;
    private String address;
    private String phone;
    private String email;

    public Customer(String name, String birthdate, String address, String phone, String email) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%-20.20s  %-20.20s  %-20.20s  %-20.20s  %-20.20s",this.name,this.birthdate,this.address,this.phone,this.email);

//        return "Customer{" +
//                "name='" + name + '\'' +
//                ", birthdate='" + birthdate + '\'' +
//                ", address='" + address + '\'' +
//                ", phone='" + phone + '\'' +
//                ", email='" + email + '\'' +
//                '}';
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
