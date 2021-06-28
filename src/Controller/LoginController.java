package Controller;

import java.util.Scanner;

public class LoginController {
    static boolean Login(){
        Scanner scanner = new Scanner(System.in);
        String[] Unames = new String[]{"manager1", "owner1", "customer1", "employee1", "invemployee1", "cashier1"};
        String[] Upasses = new String[]{"mng123", "own123", "cst123", "emp123", "inemp123", "csh123"};
        String[] Utypes = new String[]{"Manager", "Owner", "Customer", "Employee", "Inventory Employee", "Cashier"};
        System.out.print("UserName: ");
        String enteredUname = scanner.nextLine();
        System.out.print("Password: ");
        String enteredUpass = scanner.nextLine();
        boolean p = true;
        for (int i = 0; i < Unames.length; i++) {
            if (Unames[i].equals(enteredUname) && Upasses[i].equals(enteredUpass)) {
                Main.classname = Utypes[i];
                Main.permissions = new String[]{""};
                p = true;
                break;
            } else {
                p = false;
            }
        }
        switch (Main.classname) {//giving permissions according to logined user type
            case "Manager":
                Main.permissions = new String[]{"cashiersales", "customer", "employee", "inventoryemployee", "cashier", "view product"};
                break;
            case "Owner":
                Main.permissions = new String[]{"manager", "owner", "product", "cashiersales", "customer", "employee", "inventoryemployee", "cashier"};
                break;
            case "Customer":
                Main.permissions = new String[]{"shoppingcart", "view product"};
                break;
            case "Employee":
                Main.permissions = new String[]{"customer"};
                break;
            case "Cashier":
                Main.permissions = new String[]{"cashiersales"};
                break;
            case "Inventory Employee":
                Main.permissions = new String[]{"product"};
                break;
            default:
                Main.permissions = new String[]{""};
                break;
        }
        return p;
    }
}
