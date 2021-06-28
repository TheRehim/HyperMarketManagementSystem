package Model;

import static Model.DataBaseClasses.InvEmployees;

public class InventoryEmployee extends Employee{
    public static String requiredpermissions = "inventoryemployee";

    public InventoryEmployee(int ID, String firstName, String surName, String phoneNumber, String emailAddress, float salary) {
        super(ID, firstName, surName, phoneNumber, emailAddress, salary);
    }

    public InventoryEmployee() {
    }
}
