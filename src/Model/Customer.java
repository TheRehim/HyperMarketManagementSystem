package Model;

import static Model.DataBaseClasses.Customers;

public class Customer {
    public static String requiredpermissions = "customer";
    public int ID;
    public String FirstName;
    public String SurName;
    public String PhoneNumber;
    public String EmailAddress;
    public String CardInfo;

    public Customer() {
    }

    public Customer(int ID, String firstName, String surName, String phoneNumber, String emailAddress, String cardInfo) {
        this.ID = ID;
        FirstName = firstName;
        SurName = surName;
        PhoneNumber = phoneNumber;
        EmailAddress = emailAddress;
        CardInfo = cardInfo;
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

    public String getCardInfo() {
        return CardInfo;
    }

    public void setCardInfo(String cardInfo) {
        CardInfo = cardInfo;
    }

    public String GetAll() {
        String a = "";
        for (Customer item : Customers) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.CardInfo + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Card Info" +
                '\n' + a;
    }
}
