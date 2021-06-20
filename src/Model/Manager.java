package Model;

import static Model.DataBaseClasses.Managers;

public class Manager extends Employee implements ManagerManagement{
    public static String requiredpermissions = "manager";

    public Manager(int ID, String firstName, String surName, String phoneNumber, String emailAddress, float salary) {
        super(ID, firstName, surName, phoneNumber, emailAddress, salary);
    }

    public Manager() {

    }

    public String GetAll() {
        String a = "";
        for (Manager item : Managers) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.Salary + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Salary" +
                '\n' + a;
    }
}
