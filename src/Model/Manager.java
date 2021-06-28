package Model;

import static Model.DataBaseClasses.Managers;

public class Manager extends Employee {
    public static String requiredpermissions = "manager";

    public Manager(int ID, String firstName, String surName, String phoneNumber, String emailAddress, float salary) {
        super(ID, firstName, surName, phoneNumber, emailAddress, salary);
    }

    public Manager() {

    }
}
