package Model;

import static Model.DataBaseClasses.InvEmployees;

public class InventoryEmployeeManagement implements IInventoryEmployeeManagement{

    public String GetAll() {
        String a = "";
        for (Employee item : InvEmployees) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.Salary + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Salary" +
                '\n' + a;
    }

    public void Add(int id, String name, String surname, String phone, String mail, float salary) {
        InvEmployees.add(new InventoryEmployee(id, name, surname, phone, mail, salary));
    }

    public void Delete(int id) {
        for (int i = 0; i < InvEmployees.size(); i++) {
            if (InvEmployees.get(i).ID == id) {
                InvEmployees.remove(i);
            }
        }
    }

    public void Edit(int id, String name, String surname, String phone, String mail, float salary) {
        for (Employee item : InvEmployees) {
            if (item.ID == id) {
                item.FirstName = name;
                item.SurName = surname;
                item.PhoneNumber = phone;
                item.EmailAddress = mail;
                item.Salary = salary;
            }
        }
    }
}
