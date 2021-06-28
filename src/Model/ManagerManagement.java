package Model;

import static Model.DataBaseClasses.Managers;

public class ManagerManagement implements IManagerManagement{
    public String GetAll() {
        String a = "";
        for (Employee item : Managers) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.Salary + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Salary" +
                '\n' + a;
    }

    public void Add(int id, String name, String surname, String phone, String mail, float salary) {
        Managers.add(new Manager(id, name, surname, phone, mail, salary));
    }

    public void Delete(int id) {
        for (int i = 0; i < Managers.size(); i++) {
            if (Managers.get(i).ID == id) {
                Managers.remove(i);
            }
        }
    }

    public void Edit(int id, String name, String surname, String phone, String mail, float salary) {
        for (Employee item : Managers) {
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
