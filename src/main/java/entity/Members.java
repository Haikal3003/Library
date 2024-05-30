package entity;

import utils.Utils;

public class Members {
    private int idMember;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Members(String name, String phone, String email, String address) {
        this.idMember = Utils.generateRandomId();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
