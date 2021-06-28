package Model;

public interface ICashierSalesManagement {
    String GetAll();
    void Add(int id,int cscid,int cspid);
    void Delete(int id);
}
