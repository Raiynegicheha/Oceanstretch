package com.raiyne.oceanstreach;

public class Animals {
    String name,email,contact,description;

    public Animals(String name, String email, String contact, String description) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.description = description;
    }

    public Animals() {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
