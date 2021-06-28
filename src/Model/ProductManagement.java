package Model;

import static Model.DataBaseClasses.Products;

public class ProductManagement implements IProductManagement {

    public String GetAll() {
        String a = "";
        for (Product item : Products) {
            a += item.ID + " " + item.Name + " " + item.Price + " " + item.Amount + "\n";
        }
        return "ID" + " " + "Name" + " " + "Price" + "Amount" +
                '\n' + a;
    }

    public void Add(int id, String name, float price, float amount) {
        Products.add(new Product(id, name, price, amount));
    }

    public void Delete(int id) {
        for (int i = 0; i < Products.size(); i++) {
            if (Products.get(i).ID == id) {
                Products.remove(i);
            }
        }
    }

    public void Edit(int id, String name, float price, float amount) {
        for (Product item : Products) {
            if (item.ID == id) {
                item.Name = name;
                item.Price = price;
                item.Amount = amount;
            }
        }
    }
}
