package Model;

public interface ICustomerManagement {
    String GetAll();

    void Add(int id, String name, String surname, String phone, String mail, String cardinfo);

    void Delete(int id);

    void Edit(int id, String name, String surname, String phone, String mail, String cardinfo);
}
