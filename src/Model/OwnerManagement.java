package Model;

import static Model.DataBaseClasses.Owners;

public class OwnerManagement implements IOwnerManagement{

    public String GetAll() {
        String a = "";
        for (Owner item : Owners) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" +
                '\n' + a;
    }

    public void Add(int id, String name, String surname, String phone, String mail) {
        Owners.add(new Owner(id, name, surname, phone, mail));
    }

    public void Delete(int id) {
        for (int i = 0; i < Owners.size(); i++) {
            if (Owners.get(i).ID == id) {
                Owners.remove(i);
            }
        }
    }

    public void Edit(int id, String name, String surname, String phone, String mail) {
        for (Owner item : Owners) {
            if (item.ID == id) {
                item.FirstName = name;
                item.SurName = surname;
                item.PhoneNumber = phone;
                item.EmailAddress = mail;
            }
        }
    }
}
