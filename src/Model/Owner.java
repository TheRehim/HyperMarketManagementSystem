package Model;

import static Model.DataBaseClasses.Owners;

public class Owner {
    public static String requiredpermissions = "owner";
    public int ID;
    public String FirstName;
    public String SurName;
    public String PhoneNumber;
    public String EmailAddress;

    public Owner(int ID, String firstName, String surName, String phoneNumber, String emailAddress) {
        this.ID = ID;
        FirstName = firstName;
        SurName = surName;
        PhoneNumber = phoneNumber;
        EmailAddress = emailAddress;
    }

    public Owner() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String GetAll() {
        String a = "";
        for (Owner item : Owners) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" +
                '\n' + a;
    }
}
