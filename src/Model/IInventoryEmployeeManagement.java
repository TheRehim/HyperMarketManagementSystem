package Model;

public interface IInventoryEmployeeManagement {
    String GetAll();

    void Add(int id, String name, String surname, String phone, String mail, float salary);

    void Delete(int id);

    void Edit(int id, String name, String surname, String phone, String mail, float salary);
}
