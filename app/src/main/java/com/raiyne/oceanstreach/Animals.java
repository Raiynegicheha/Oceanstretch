package com.raiyne.oceanstreach;


public class Animals {
    String Name,Email,Number,Description;
    String imageurl;

    public Animals(){

    }

    public Animals(String Name, String Email, String Number, String Description, String imageURL) {
        this.Name = Name;
        this.Email = Email;
        this.Number = Number;
        this.Description = Description;
        this.imageurl = imageURL;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }



}
