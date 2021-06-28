package Model;

import static Model.DataBaseClasses.ShoppingCarts;

public class ShoppingCartManagement implements IShoppingCartManagement {

    public String GetAll() {
        String a = "";
        for (ShoppingCart item : ShoppingCarts) {
            a += item.SCID + " " + item.SCCustomerID + " " + item.SCProductID + "\n";
        }
        return "ID" + " " + "Customer ID" + " " + "Product ID" +
                '\n' + a;
    }

    public void Add(int id, int sccid, int scpid) {
        ShoppingCarts.add(new ShoppingCart(id, sccid, scpid));
    }

    public void Delete(int id) {
        for (int i = 0; i < ShoppingCarts.size(); i++) {
            if (ShoppingCarts.get(i).SCID == id) {
                ShoppingCarts.remove(i);
            }
        }
    }
}
