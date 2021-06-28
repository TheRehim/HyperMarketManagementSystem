package Model;

import static Model.DataBaseClasses.Employees;

public class Employee implements EmployeeManagement{
    public static String requiredpermissions = "employee";
    public int ID;
    public String FirstName;
    public String SurName;
    public String PhoneNumber;
    public String EmailAddress;
    public float Salary;

    public Employee(int ID, String firstName, String surName, String phoneNumber, String emailAddress, float salary) {
        this.ID = ID;
        FirstName = firstName;
        SurName = surName;
        PhoneNumber = phoneNumber;
        EmailAddress = emailAddress;
        Salary = salary;
    }

    public Employee() {

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSurName() {
        return SurName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public float getSalary() {
        return Salary;
    }

    public String GetAll() {
        String a = "";
        for (Employee item : Employees) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.Salary + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Salary" +
                '\n' + a;
    }
}
