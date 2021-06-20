package Model;

import static Model.DataBaseClasses.ShoppingCarts;

public class ShoppingCart implements ShoppingCartManagement{
    public static String requiredpermissions = "shoppingcart";
    public int SCID;
    public int SCCustomerID;
    public int SCProductID;

    public ShoppingCart(int SCID, int SCCustomerID, int SCProductID) {
        this.SCID = SCID;
        this.SCCustomerID = SCCustomerID;
        this.SCProductID = SCProductID;
    }

    public ShoppingCart() {
    }

    public int getSCID() {
        return SCID;
    }

    public void setSCID(int SCID) {
        this.SCID = SCID;
    }

    public int getSCCashierID() {
        return SCCustomerID;
    }

    public void setSCCashierID(int SCCashierID) {
        this.SCCustomerID = SCCashierID;
    }

    public int getSCProductID() {
        return SCProductID;
    }

    public void setSCProductID(int SCProductID) {
        this.SCProductID = SCProductID;
    }

    public String GetAll() {
        String a = "";
        for (ShoppingCart item : ShoppingCarts) {
            a += item.SCID + " " + item.SCCustomerID + " " + item.SCProductID + "\n";
        }
        return "ID" + " " + "Customer ID" + " " + "Product ID" +
                '\n' + a;
    }
}
