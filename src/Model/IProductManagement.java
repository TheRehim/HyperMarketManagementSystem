package Model;

public interface IProductManagement {
    String GetAll();

    public void Add(int id, String name, float price, float amount);

    public void Edit(int id, String name, float price, float amount);

    public void Delete(int id);
}
