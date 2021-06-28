package Model;

import static Model.DataBaseClasses.Cashiers;

public class Cashier extends Employee implements CashierSalesManagement{
    public static String requiredpermissions = "cashier";

    public Cashier() {
    }

    public Cashier(int ID, String firstName, String surName, String phoneNumber, String emailAddress, float salary) {
        super(ID, firstName, surName, phoneNumber, emailAddress, salary);
    }
    public String GetAll() {
        String a = "";
        for (Cashier item : Cashiers) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.Salary + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Salary" +
                '\n' + a;
    }
}
