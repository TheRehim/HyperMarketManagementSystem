package Model;

public interface IShoppingCartManagement {
    String GetAll();

    void Add(int id, int sccid, int scpid);

    void Delete(int id);
}
