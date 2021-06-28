package Model;

import static Model.DataBaseClasses.CashierSale;

public class CashierSalesManagement implements ICashierSalesManagement{

    public String GetAll() {
        String a = "";
        for (CashierSales item : CashierSale) {
            a += item.CSID + " " + item.CSCashierID + " " + item.CSProductID + "\n";
        }
        return "ID" + " " + "Cashier ID" + " " + "Product ID" +
                '\n' + a;
    }

    public void Add(int id, int cscid, int cspid) {
        CashierSale.add(new CashierSales(id, cscid, cspid));
    }

    public void Delete(int id) {
        for (int i = 0; i < CashierSale.size(); i++) {
            if (CashierSale.get(i).CSID == id) {
                CashierSale.remove(i);
            }
        }
    }
}
