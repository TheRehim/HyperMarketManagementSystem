package Model;

import static Model.DataBaseClasses.Cashiers;

public class CashierManagement implements ICashierManagement {

    public String GetAll() {
        String a = "";
        for (Employee item : Cashiers) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.Salary + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Salary" +
                '\n' + a;
    }

    public void Add(int id, String name, String surname, String phone, String mail, float salary) {
        Cashiers.add(new Cashier(id, name, surname, phone, mail, salary));
    }

    public void Delete(int id) {
        for (int i = 0; i < Cashiers.size(); i++) {
            if (Cashiers.get(i).ID == id) {
                Cashiers.remove(i);
            }
        }
    }

    public void Edit(int id, String name, String surname, String phone, String mail, float salary) {
        for (Employee item : Cashiers) {
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
