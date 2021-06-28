package Model;

import static Model.DataBaseClasses.Employees;

public class EmployeeManagement implements IEmployeeManagement {
    public String GetAll() {
        String a = "";
        for (Employee item : Employees) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.Salary + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Salary" +
                '\n' + a;
    }

    public void Add(int id, String name, String surname, String phone, String mail, float salary) {
        Employees.add(new Employee(id, name, surname, phone, mail, salary));
    }

    public void Delete(int id) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).ID == id) {
                Employees.remove(i);
            }
        }
    }

    public void Edit(int id, String name, String surname, String phone, String mail, float salary) {
        for (Employee item : Employees) {
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
