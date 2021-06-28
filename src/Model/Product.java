package Model;

import static Model.DataBaseClasses.Products;

public class Product{
    public static String requiredpermissions = "product";
    public int ID;
    public String Name;
    public float Price;
    public float Amount;

    public Product() {

    }

    public Product(int ID, String name, float price, float amount) {
        this.ID = ID;
        Name = name;
        Price = price;
        Amount = amount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }

}
