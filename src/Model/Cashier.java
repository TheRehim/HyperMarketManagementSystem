package Model;

import static Model.DataBaseClasses.Cashiers;

public class Cashier extends Employee{
    public static String requiredpermissions = "cashier";

    public Cashier() {
    }

    public Cashier(int ID, String firstName, String surName, String phoneNumber, String emailAddress, float salary) {
        super(ID, firstName, surName, phoneNumber, emailAddress, salary);
    }
}
