package getServices.model;

import java.util.List;

public class Provider {
    private int id;
    private String pname;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private List<String> field;
    private Double rate;
    private String resume;
    private String username;
    private String password;

    
    public Provider(int id, String pname, String phoneno, String email, String address, String city){   // OLD CONSTRUCTOR
        this.id=id;
        this.pname=pname;
        this.phoneNumber=phoneno;
        this.email=email;
        this.address=address;
        this.city=city;
    }
    
    public Provider(int id, String pname, String phoneno, String email, String address, String city, double rate, String resume){   // OLD CONSTRUCTOR
        this.id=id;
        this.pname=pname;
        this.phoneNumber=phoneno;
        this.email=email;
        this.address=address;
        this.city=city;
        this.rate=rate;
        this.resume=resume;
    }
    
    public Provider(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getField() {
        return field;
    }

    public void setField(List<String> field) {
        this.field = field;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
