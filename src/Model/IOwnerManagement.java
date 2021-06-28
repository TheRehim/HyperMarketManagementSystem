package Model;

public interface IOwnerManagement {
    String GetAll();

    void Add(int id, String name, String surname, String phone, String mail);

    void Delete(int id);

    void Edit(int id, String name, String surname, String phone, String mail);
}
