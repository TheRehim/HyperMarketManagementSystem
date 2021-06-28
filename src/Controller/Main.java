package Controller;

import Model.Employee;
import Model.Manager;
import Model.Cashier;
import Model.CashierSales;
import Model.ShoppingCart;
import Model.Owner;
import Model.Product;
import Model.Customer;
import Model.InventoryEmployee;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Model.DataBaseClasses.*;

public class Main {
    static String classname = "";
    static String[] permissions = new String[8];
    static int menuselection = -1;
    static int submenuselection = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee emp = new Employee();
        Manager mng = new Manager();
        Customer cst = new Customer();
        CashierSales cshsl = new CashierSales();
        Cashier csh = new Cashier();
        InventoryEmployee invemp = new InventoryEmployee();
        Owner own = new Owner();
        Product prd = new Product();
        ShoppingCart shpcrt = new ShoppingCart();
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
                classname = Utypes[i];
                permissions = new String[]{""};
                p = true;
                break;
            } else {
                p = false;
            }
        }
        if (p) {
            System.out.print("Logged In Successfully as " + classname + '\n');
        } else {
            System.out.print("Username or Password is Wrong, Check your credentials");
        }
        switch (classname) {//giving permissions according to logined user type
            case "Manager":
                permissions = new String[]{"cashiersales", "customer", "employee", "inventoryemployee", "cashier", "view product"};
                break;
            case "Owner":
                permissions = new String[]{"manager", "owner", "product", "cashiersales", "customer", "employee", "inventoryemployee", "cashier"};
                break;
            case "Customer":
                permissions = new String[]{"shoppingcart", "view product"};
                break;
            case "Employee":
                permissions = new String[]{"customer"};
                break;
            case "Cashier":
                permissions = new String[]{"cashiersales"};
                break;
            case "Inventory Employee":
                permissions = new String[]{"product"};
                break;
            default:
                permissions = new String[]{""};
                break;
        }
        List<String> permlist = Arrays.asList(permissions);
        while (p) {
            menuselection = -1;//selecting a tab from menu
            submenuselection = -1;//select a tab from submenu
            Menu();
            switch (menuselection) {
                case 1:
                    if (permlist.contains(emp.requiredpermissions)) {//checks if user has permissions that is being need in the class user accessing to
                        System.out.println("1 - View Employee");
                        System.out.println("2 - Add Employee");
                        System.out.println("3 - Remove Employee");
                        System.out.println("4 - Edit Employee");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 2:
                    if (permlist.contains(invemp.requiredpermissions)) {
                        System.out.println("1 - View Inventory Employees");
                        System.out.println("2 - Add Inventory Employees");
                        System.out.println("3 - Remove Inventory Employees");
                        System.out.println("4 - Edit Inventory Employees");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 3:
                    if (permlist.contains(csh.requiredpermissions)) {
                        System.out.println("1 - View Cashiers");
                        System.out.println("2 - Add Cashiers");
                        System.out.println("3 - Remove Cashiers");
                        System.out.println("4 - Edit Cashiers");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 4:
                    if (permlist.contains(prd.requiredpermissions)) {
                        System.out.println("1 - View Products");
                        System.out.println("2 - Add Products");
                        System.out.println("3 - Remove Products");
                        System.out.println("4 - Edit Products");
                        System.out.println("5 - Import Products");
                        System.out.println("6 - Export Products");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else if (permlist.contains("view product")) {
                        System.out.println("1 - View Products");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                        if (submenuselection != 1) {
                            System.out.println("Enter correct number");
                            submenuselection = -1;
                            break;
                        }
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 5:
                    if (permlist.contains(mng.requiredpermissions)) {
                        System.out.println("1 - View Manager");
                        System.out.println("2 - Add Manager");
                        System.out.println("3 - Remove Manager");
                        System.out.println("4 - Edit Manager");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 6:
                    if (permlist.contains(cst.requiredpermissions)) {
                        System.out.println("1 - View Customer");
                        System.out.println("2 - Add Customer");
                        System.out.println("3 - Remove Customer");
                        System.out.println("4 - Edit Customer");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 7:
                    if (permlist.contains(own.requiredpermissions)) {
                        System.out.println("1 - View Owners");
                        System.out.println("2 - Add Owners");
                        System.out.println("3 - Remove Owners");
                        System.out.println("4 - Edit Owners");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 8:
                    if (permlist.contains(shpcrt.requiredpermissions)) {
                        System.out.println("1 - View Products");
                        System.out.println("2 - Add Product to Shopping Cart");
                        System.out.println("3 - Delete Product from Shopping Cart");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 9:
                    if (permlist.contains(cshsl.requiredpermissions)) {
                        System.out.println("1 - Scan Product");
                        System.out.println("2 - Remove Scanned Product");
                        System.out.println("Enter number: ");
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You can not access those files");
                        menuselection = -1;
                    }
                    break;
                case 10:
                    p = false;
                    menuselection = -1;
                    submenuselection = -1;
                    break;
                default:
                    System.out.println("Enter correct number");
                    submenuselection = -1;
                    break;
            }
            switch (menuselection) {
                case 1:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(emp.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Salary" + '\n' + "Enter with ';' symbol for each part ending");
                            String newemp = scanner.nextLine();
                            int newid;
                            if (Employees.size() > 0) {
                                newid = Employees.get((Employees.size() - 1)).ID + 1;
                            } else {
                                newid = 0;
                            }
                            Employees.add(new Employee(
                                    newid,
                                    newemp.split(";")[0],
                                    newemp.split(";")[1],
                                    newemp.split(";")[2],
                                    newemp.split(";")[3],
                                    Float.parseFloat(newemp.split(";")[4])));
                            break;
                        case 3:
                            System.out.println("Enter ID of Employee to delete");
                            int deleteemp = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < Employees.size(); i++) {
                                if (Employees.get(i).ID == deleteemp) {
                                    Employees.remove(i);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editempid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Employee to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editemp = scanner.nextLine();
                            for (Employee item : Employees) {
                                if (item.ID == editempid) {
                                    item.FirstName = editemp.split(";")[0];
                                    item.SurName = editemp.split(";")[1];
                                    item.PhoneNumber = editemp.split(";")[2];
                                    item.EmailAddress = editemp.split(";")[3];
                                    item.Salary = Float.parseFloat(editemp.split(";")[4]);
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 2:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(invemp.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Salary" + '\n' + "Enter with ';' symbol for each part ending");
                            String newinvemp = scanner.nextLine();
                            int newid;
                            if (InvEmployees.size() > 0) {
                                newid = InvEmployees.get((InvEmployees.size() - 1)).ID + 1;
                            } else {
                                newid = 0;
                            }
                            InvEmployees.add(new InventoryEmployee(
                                    newid,
                                    newinvemp.split(";")[0],
                                    newinvemp.split(";")[1],
                                    newinvemp.split(";")[2],
                                    newinvemp.split(";")[3],
                                    Float.parseFloat(newinvemp.split(";")[4])
                            ));
                            break;
                        case 3:
                            System.out.println("Enter ID of Inventory Employee to delete");
                            int deleteinvemp = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < InvEmployees.size(); i++) {
                                if (InvEmployees.get(i).ID == deleteinvemp) {
                                    InvEmployees.remove(i);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editinvmpid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Inventory Employee to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editinvemp = scanner.nextLine();
                            for (InventoryEmployee item : InvEmployees) {
                                if (item.ID == editinvmpid) {
                                    item.FirstName = editinvemp.split(";")[0];
                                    item.SurName = editinvemp.split(";")[1];
                                    item.PhoneNumber = editinvemp.split(";")[2];
                                    item.EmailAddress = editinvemp.split(";")[3];
                                    item.Salary = Float.parseFloat(editinvemp.split(";")[4]);
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 3:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(csh.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Salary" + '\n' + "Enter with ';' symbol for each part ending");
                            String newcsh = scanner.nextLine();
                            int newid;
                            if (Cashiers.size() > 0) {
                                newid = Cashiers.get((Cashiers.size() - 1)).ID + 1;
                            } else {
                                newid = 0;
                            }
                            Cashiers.add(new Cashier(
                                    newid,
                                    newcsh.split(";")[0],
                                    newcsh.split(";")[1],
                                    newcsh.split(";")[2],
                                    newcsh.split(";")[3],
                                    Float.parseFloat(newcsh.split(";")[4])
                            ));
                            break;
                        case 3:
                            System.out.println("Enter ID of Cashier to delete");
                            int deletecsh = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < Cashiers.size(); i++) {
                                if (Cashiers.get(i).ID == deletecsh) {
                                    Cashiers.remove(i);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editcshid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Cashier to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editcsh = scanner.nextLine();
                            for (Cashier item : Cashiers) {
                                if (item.ID == editcshid) {
                                    item.FirstName = editcsh.split(";")[0];
                                    item.SurName = editcsh.split(";")[1];
                                    item.PhoneNumber = editcsh.split(";")[2];
                                    item.EmailAddress = editcsh.split(";")[3];
                                    item.Salary = Float.parseFloat(editcsh.split(";")[4]);
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 4:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(prd.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: Name, Price, Amount" + '\n' + "Enter with ';' symbol for each part ending");
                            String newprd = scanner.nextLine();
                            int newid;
                            if (Products.size() > 0) {
                                newid = Products.get((Products.size() - 1)).ID + 1;
                            } else {
                                newid = 0;
                            }
                            Products.add(new Product(
                                    newid,
                                    newprd.split(";")[0],
                                    Float.parseFloat(newprd.split(";")[1]),
                                    Float.parseFloat(newprd.split(";")[2])
                            ));
                            break;
                        case 3:
                            System.out.println("Enter ID of Product to delete");
                            int deleteprd = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < Products.size(); i++) {
                                if (Products.get(i).ID == deleteprd) {
                                    Products.remove(i);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editprdid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Product to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editprd = scanner.nextLine();
                            for (Product item : Products) {
                                if (item.ID == editprdid) {
                                    item.Name = editprd.split(";")[0];
                                    item.Price = Float.parseFloat(editprd.split(";")[1]);
                                    item.Amount = Float.parseFloat(editprd.split(";")[2]);
                                }
                            }
                        case 5:
                            System.out.println("Enter ID of Product to Import");
                            int importid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and Amount of Product" + '\n');
                            float importamount = Float.parseFloat(scanner.nextLine());
                            for (Product item : Products) {
                                if (item.ID == importid) {
                                    item.Amount += importamount;
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Enter ID of Product to Export");
                            int exportid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and Amount of Product" + '\n');
                            float exportamount = Float.parseFloat(scanner.nextLine());
                            for (Product item : Products) {
                                if (item.ID == exportid) {
                                    item.Amount -= exportamount;
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 5:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(mng.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Salary" + '\n' + "Enter with ';' symbol for each part ending");
                            String newmng = scanner.nextLine();
                            int newid;
                            if (Managers.size() > 0) {
                                newid = Managers.get((Managers.size() - 1)).ID + 1;
                            } else {
                                newid = 0;
                            }
                            Managers.add(new Manager(
                                    newid,
                                    newmng.split(";")[0],
                                    newmng.split(";")[1],
                                    newmng.split(";")[2],
                                    newmng.split(";")[3],
                                    Float.parseFloat(newmng.split(";")[4])
                            ));
                            break;
                        case 3:
                            System.out.println("Enter ID of Manager to delete");
                            int deletemng = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < Managers.size(); i++) {
                                if (Managers.get(i).ID == deletemng) {
                                    Managers.remove(i);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editmngid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Manager to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editmng = scanner.nextLine();
                            for (Manager item : Managers) {
                                if (item.ID == editmngid) {
                                    item.FirstName = editmng.split(";")[0];
                                    item.SurName = editmng.split(";")[1];
                                    item.PhoneNumber = editmng.split(";")[2];
                                    item.EmailAddress = editmng.split(";")[3];
                                    item.Salary = Float.parseFloat(editmng.split(";")[4]);
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 6:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(cst.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Card Info" + '\n' + "Enter with ';' symbol for each part ending");
                            String newcst = scanner.nextLine();
                            int newid;
                            if (Customers.size() > 0) {
                                newid = Customers.get((Customers.size() - 1)).ID + 1;
                            } else {
                                newid = 0;
                            }
                            Customers.add(new Customer(
                                    newid,
                                    newcst.split(";")[0],
                                    newcst.split(";")[1],
                                    newcst.split(";")[2],
                                    newcst.split(";")[3],
                                    newcst.split(";")[4]
                            ));

                            break;
                        case 3:
                            System.out.println("Enter ID of Customer to delete");
                            int deletecst = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < Customers.size(); i++) {
                                if (Customers.get(i).ID == deletecst) {
                                    Customers.remove(i);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editcstid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Customer to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editcst = scanner.nextLine();
                            for (Customer item : Customers) {
                                if (item.ID == editcstid) {
                                    item.FirstName = editcst.split(";")[0];
                                    item.SurName = editcst.split(";")[1];
                                    item.PhoneNumber = editcst.split(";")[2];
                                    item.EmailAddress = editcst.split(";")[3];
                                    item.CardInfo = editcst.split(";")[4];
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 7:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(own.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Card Info" + '\n' + "Enter with ';' symbol for each part ending");
                            String newown = scanner.nextLine();
                            int newid;
                            if (Owners.size() > 0) {
                                newid = Owners.get((Owners.size() - 1)).ID + 1;
                            } else {
                                newid = 0;
                            }
                            Owners.add(new Owner(
                                    newid,
                                    newown.split(";")[0],
                                    newown.split(";")[1],
                                    newown.split(";")[2],
                                    newown.split(";")[3]
                            ));
                            break;
                        case 3:
                            System.out.println("Enter ID of Owner to delete");
                            int deleteown = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < Owners.size(); i++) {
                                if (Owners.get(i).ID == deleteown) {
                                    Owners.remove(i);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editownid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Owner to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editown = scanner.nextLine();
                            for (Owner item : Owners) {
                                if (item.ID == editownid) {
                                    item.FirstName = editown.split(";")[0];
                                    item.SurName = editown.split(";")[1];
                                    item.PhoneNumber = editown.split(";")[2];
                                    item.EmailAddress = editown.split(";")[3];
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 8:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(shpcrt.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: Customer ID, Product ID" + '\n' + "Enter with ';' symbol for each part ending");
                            String newshpcrt = scanner.nextLine();
                            int newid;
                            if (ShoppingCarts.size() > 0) {
                                newid = ShoppingCarts.get((ShoppingCarts.size() - 1)).SCID + 1;
                            } else {
                                newid = 0;
                            }
                            ShoppingCarts.add(new ShoppingCart(
                                    newid,
                                    Integer.parseInt(newshpcrt.split(";")[0]),
                                    Integer.parseInt(newshpcrt.split(";")[1])
                            ));
                            break;
                        case 3:
                            System.out.println("Enter ID to remove product from Shopping Cart");
                            int deleteshpcrt = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < ShoppingCarts.size(); i++) {
                                if (ShoppingCarts.get(i).SCID == deleteshpcrt) {
                                    ShoppingCarts.remove(i);
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 9:
                    switch (submenuselection) {
                        case 1:
                            System.out.println("Enter: Cashier ID, Product ID" + '\n' + "Enter with ';' symbol for each part ending");
                            String newcshsl = scanner.nextLine();
                            int newid;
                            if (CashierSale.size() > 0) {
                                newid = CashierSale.get((CashierSale.size() - 1)).CSID + 1;
                            } else {
                                newid = 0;
                            }
                            CashierSale.add(new CashierSales(
                                    newid,
                                    Integer.parseInt(newcshsl.split(";")[0]),
                                    Integer.parseInt(newcshsl.split(";")[1])
                            ));
                            break;
                        case 2:
                            System.out.println("Enter ID to remove scanned product");
                            int deletecshsl = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < CashierSale.size(); i++) {
                                if (CashierSale.get(i).CSID == deletecshsl) {
                                    CashierSale.remove(i);
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                default:
                    submenuselection = -1;
                    menuselection = -1;
                    break;
            }
        }
    }

    private static void Menu() {
        menuselection = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU: ");
        System.out.println("1 - Employees");
        System.out.println("2 - InventoryEmployees");
        System.out.println("3 - Cashiers");
        System.out.println("4 - Products");
        System.out.println("5 - Managers");
        System.out.println("6 - Customers");
        System.out.println("7 - Owners");
        System.out.println("8 - Shopping");
        System.out.println("9 - Cashier scan system");
        System.out.println("10 - Exit System");
        System.out.println("Enter number: ");
        menuselection = Integer.parseInt(scanner.nextLine());
    }
}