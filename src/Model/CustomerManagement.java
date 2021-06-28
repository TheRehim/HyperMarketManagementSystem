package Model;

import static Model.DataBaseClasses.Customers;

public class CustomerManagement {

    public String GetAll() {
        String a = "";
        for (Customer item : Customers) {
            a += item.ID + " " + item.FirstName + " " + item.SurName + " " + item.PhoneNumber + " " + item.EmailAddress + " " + item.CardInfo + "\n";
        }
        return "ID" + " " + "FirstName" + " " + "SurName" + " " + "Phone Number" + " " + "Email Address" + " " + "Card Info" +
                '\n' + a;
    }

    public void Add(int id, String name, String surname, String phone, String mail, String cardinfo) {
        Customers.add(new Customer(id, name, surname, phone, mail, cardinfo));
    }

    public void Delete(int id) {
        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).ID == id) {
                Customers.remove(i);
            }
        }
    }

    public void Edit(int id, String name, String surname, String phone, String mail, String cardinfo) {
        for (Customer item : Customers) {
            if (item.ID == id) {
                item.FirstName = name;
                item.SurName = surname;
                item.PhoneNumber = phone;
                item.EmailAddress = mail;
                item.CardInfo = cardinfo;
            }
        }
    }
}
