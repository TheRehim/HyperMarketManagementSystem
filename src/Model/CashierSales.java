package Model;

import static Model.DataBaseClasses.CashierSale;

public class CashierSales implements CashierManagement{
    public static String requiredpermissions = "cashiersales";
    public int CSID;
    public int CSCashierID;
    public int CSProductID;

    public CashierSales(int CSID, int CSCashierID, int CSProductID) {
        this.CSID = CSID;
        this.CSCashierID = CSCashierID;
        this.CSProductID = CSProductID;
    }

    public CashierSales() {
    }

    public int getCSID() {
        return CSID;
    }

    public void setCSID(int CSID) {
        this.CSID = CSID;
    }

    public int getCSCashierID() {
        return CSCashierID;
    }

    public void setCSCashierID(int CSCashierID) {
        this.CSCashierID = CSCashierID;
    }

    public int getCSProductID() {
        return CSProductID;
    }

    public void setCSProductID(int CSProductID) {
        this.CSProductID = CSProductID;
    }

    public String GetAll() {
        String a = "";
        for (CashierSales item : CashierSale) {
            a += item.CSID + " " + item.CSCashierID + " " + item.CSProductID + "\n";
        }
        return "ID" + " " + "Cashier ID" + " " + "Product ID" +
                '\n' + a;
    }
}
