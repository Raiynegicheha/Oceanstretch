package com.raiyne.oceanstreach;

public class Signup {
    String name,email,password,phonecontact;

    public Signup(String name, String email, String phonecontact, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonecontact = phonecontact;
    }

    public Signup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonecontact() {
        return phonecontact;
    }

    public void setPhonecontact(String phonecontact) {
        this.phonecontact = phonecontact;
    }
}
