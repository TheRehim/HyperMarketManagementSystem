package Model;

import static Model.DataBaseClasses.InvEmployees;

public class InventoryEmployee extends Employee {
    public static String requiredpermissions = "inventoryemployee";

    public InventoryEmployee(int ID, String firstName, String surName, String phoneNumber, String emailAddress, float salary) {
        super(ID, firstName, surName, phoneNumber, emailAddress, salary);
    }

    public InventoryEmployee() {
    }

    public String GetAll() {
        String a = "";
        for (InventoryEmployee item : InvEmployees) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.Salary + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Salary" +
                '\n' + a;
    }
}
