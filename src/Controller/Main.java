package Controller;

import Model.*;

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
        EmployeeManagement empM = new EmployeeManagement();
        Manager mng = new Manager();
        ManagerManagement mngM = new ManagerManagement();
        Customer cst = new Customer();
        CustomerManagement cstM = new CustomerManagement();
        CashierSales cshsl = new CashierSales();
        CashierSalesManagement cshslM = new CashierSalesManagement();
        Cashier csh = new Cashier();
        CashierManagement cshM = new CashierManagement();
        InventoryEmployee invemp = new InventoryEmployee();
        InventoryEmployeeManagement invempM = new InventoryEmployeeManagement();
        Owner own = new Owner();
        OwnerManagement ownM = new OwnerManagement();
        Product prd = new Product();
        ProductManagement prdM = new ProductManagement();
        ShoppingCart shpcrt = new ShoppingCart();
        ShoppingCartManagement shpcrtM = new ShoppingCartManagement();
        boolean p = LoginController.Login();
        if (p) {
            System.out.print("Logged In Successfully as " + classname + '\n');
        } else {
            System.out.print("Username or Password is Wrong, Check your credentials");
        }
        List<String> permlist = Arrays.asList(permissions);
        while (p) {
            menuselection = -1;//selecting a tab from menu
            submenuselection = -1;//select a tab from submenu
            AdminPanelController.Menu();
            switch (menuselection) {
                case 1:
                    if (permlist.contains(emp.requiredpermissions)) {//checks if user has permissions that is being need in the class user accessing to
                        AdminPanelController.EmployeeSelections();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        NoAccess();
                    }
                    break;
                case 2:
                    if (permlist.contains(invemp.requiredpermissions)) {
                        AdminPanelController.InventoryEmployeeSelections();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        NoAccess();
                    }
                    break;
                case 3:
                    if (permlist.contains(csh.requiredpermissions)) {
                        AdminPanelController.CashierSelections();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        NoAccess();
                    }
                    break;
                case 4:
                    if (permlist.contains(prd.requiredpermissions)) {
                        AdminPanelController.ProductSelections();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else if (permlist.contains("view product")) {
                        HomeController.ProductSelection();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                        if (submenuselection != 1) {
                            EnterCorrect();
                            break;
                        }
                    } else {
                        NoAccess();
                    }
                    break;
                case 5:
                    if (permlist.contains(mng.requiredpermissions)) {
                        AdminPanelController.ManagerSelections();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        NoAccess();
                    }
                    break;
                case 6:
                    if (permlist.contains(cst.requiredpermissions)) {
                        AdminPanelController.CustomerSelections();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        NoAccess();
                    }
                    break;
                case 7:
                    if (permlist.contains(own.requiredpermissions)) {
                        AdminPanelController.OwnerSelections();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        NoAccess();
                    }
                    break;
                case 8:
                    if (permlist.contains(shpcrt.requiredpermissions)) {
                        HomeController.ShoppingCartSelection();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        NoAccess();
                    }
                    break;
                case 9:
                    if (permlist.contains(cshsl.requiredpermissions)) {
                        AdminPanelController.CashierSalesSelection();
                        submenuselection = Integer.parseInt(scanner.nextLine());
                    } else {
                        NoAccess();
                    }
                    break;
                case 10:
                    p = false;
                    menuselection = -1;
                    submenuselection = 10;
                    break;
                default:
                    EnterCorrect();
                    break;
            }
            switch (menuselection) {
                case 1:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(empM.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Salary" + '\n' + "Enter with ';' symbol for each part ending");
                            String newemp = scanner.nextLine();
                            int newid;
                            if (Employees.size() > 0) {
                                newid = Employees.get((Employees.size() - 1)).ID + 1;
                            } else {
                                newid = 1;
                            }
                            try {
                                empM.Add(newid,
                                        newemp.split(";")[0],
                                        newemp.split(";")[1],
                                        newemp.split(";")[2],
                                        newemp.split(";")[3],
                                        Float.parseFloat(newemp.split(";")[4]));
                                System.out.println("Employee added successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 3:
                            System.out.println("Enter ID of Employee to delete");
                            int deleteemp = Integer.parseInt(scanner.nextLine());
                            try {
                                empM.Delete(deleteemp);
                                System.out.println("Employee deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editempid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Employee to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editemp = scanner.nextLine();
                            try {
                                empM.Edit(editempid,
                                        editemp.split(";")[0],
                                        editemp.split(";")[1],
                                        editemp.split(";")[2],
                                        editemp.split(";")[3],
                                        Float.parseFloat(editemp.split(";")[4]));
                                System.out.println("Employee edited successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        default:
                            EnterCorrect();
                            break;
                    }
                    break;
                case 2:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(invempM.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Salary" + '\n' + "Enter with ';' symbol for each part ending");
                            String newinvemp = scanner.nextLine();
                            int newid;
                            if (InvEmployees.size() > 0) {
                                newid = InvEmployees.get((InvEmployees.size() - 1)).ID + 1;
                            } else {
                                newid = 1;
                            }
                            try {
                                invempM.Add(
                                        newid,
                                        newinvemp.split(";")[0],
                                        newinvemp.split(";")[1],
                                        newinvemp.split(";")[2],
                                        newinvemp.split(";")[3],
                                        Float.parseFloat(newinvemp.split(";")[4])
                                );
                                System.out.println("Inventory Employee added successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 3:
                            System.out.println("Enter ID of Inventory Employee to delete");
                            int deleteinvemp = Integer.parseInt(scanner.nextLine());
                            try {
                                invempM.Delete(deleteinvemp);
                                System.out.println("Inventory Employee deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editinvmpid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Inventory Employee to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editinvemp = scanner.nextLine();
                            try {
                                invempM.Edit(
                                        editinvmpid,
                                        editinvemp.split(";")[0],
                                        editinvemp.split(";")[1],
                                        editinvemp.split(";")[2],
                                        editinvemp.split(";")[3],
                                        Float.parseFloat(editinvemp.split(";")[4])
                                );
                                System.out.println("Inventory Employee edited successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        default:
                            EnterCorrect();
                            break;
                    }
                    break;
                case 3:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(cshM.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Salary" + '\n' + "Enter with ';' symbol for each part ending");
                            String newcsh = scanner.nextLine();
                            int newid;
                            if (Cashiers.size() > 0) {
                                newid = Cashiers.get((Cashiers.size() - 1)).ID + 1;
                            } else {
                                newid = 1;
                            }
                            try {
                                cshM.Add(newid,
                                        newcsh.split(";")[0],
                                        newcsh.split(";")[1],
                                        newcsh.split(";")[2],
                                        newcsh.split(";")[3],
                                        Float.parseFloat(newcsh.split(";")[4]));
                                System.out.println("Cashier added successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 3:
                            System.out.println("Enter ID of Cashier to delete");
                            int deletecsh = Integer.parseInt(scanner.nextLine());
                            try {
                                cshM.Delete(deletecsh);
                                System.out.println("Cashier deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
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
                            EnterCorrect();
                            break;
                    }
                    break;
                case 4:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(prdM.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: Name, Price, Amount" + '\n' + "Enter with ';' symbol for each part ending");
                            String newprd = scanner.nextLine();
                            int newid;
                            if (Products.size() > 0) {
                                newid = Products.get((Products.size() - 1)).ID + 1;
                            } else {
                                newid = 1;
                            }
                            try {
                                prdM.Add(newid,
                                        newprd.split(";")[0],
                                        Float.parseFloat(newprd.split(";")[1]),
                                        Float.parseFloat(newprd.split(";")[2]));
                                System.out.println("Product added successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 3:
                            System.out.println("Enter ID of Product to delete");
                            int deleteprd = Integer.parseInt(scanner.nextLine());
                            try {
                                prdM.Delete(deleteprd);
                                System.out.println("Product deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editprdid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Product to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editprd = scanner.nextLine();
                            try {
                                prdM.Edit(
                                        editprdid,
                                        editprd.split(";")[0],
                                        Float.parseFloat(editprd.split(";")[1]),
                                        Float.parseFloat(editprd.split(";")[2])
                                );
                                System.out.println("Product edited successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
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
                            EnterCorrect();
                            break;
                    }
                    break;
                case 5:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(mngM.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Salary" + '\n' + "Enter with ';' symbol for each part ending");
                            String newmng = scanner.nextLine();
                            int newid;
                            if (Managers.size() > 0) {
                                newid = Managers.get((Managers.size() - 1)).ID + 1;
                            } else {
                                newid = 1;
                            }
                            try {
                                mngM.Add(newid,
                                        newmng.split(";")[0],
                                        newmng.split(";")[1],
                                        newmng.split(";")[2],
                                        newmng.split(";")[3],
                                        Float.parseFloat(newmng.split(";")[4]));
                                System.out.println("Manager added successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 3:
                            System.out.println("Enter ID of Manager to delete");
                            int deletemng = Integer.parseInt(scanner.nextLine());
                            try {
                                mngM.Delete(deletemng);
                                System.out.println("Manager deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editmngid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Manager to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editmng = scanner.nextLine();
                            try {
                                mngM.Edit(
                                        editmngid,
                                        editmng.split(";")[0],
                                        editmng.split(";")[1],
                                        editmng.split(";")[2],
                                        editmng.split(";")[3],
                                        Float.parseFloat(editmng.split(";")[4])
                                );
                                System.out.println("Manager edited successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        default:
                            EnterCorrect();
                            break;
                    }
                    break;
                case 6:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(cstM.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Card Info" + '\n' + "Enter with ';' symbol for each part ending");
                            String newcst = scanner.nextLine();
                            int newid;
                            if (Customers.size() > 0) {
                                newid = Customers.get((Customers.size() - 1)).ID + 1;
                            } else {
                                newid = 1;
                            }
                            try {
                                cstM.Add(
                                        newid,
                                        newcst.split(";")[0],
                                        newcst.split(";")[1],
                                        newcst.split(";")[2],
                                        newcst.split(";")[3],
                                        newcst.split(";")[4]);
                                System.out.println("Customer added successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 3:
                            System.out.println("Enter ID of Customer to delete");
                            int deletecst = Integer.parseInt(scanner.nextLine());
                            try {
                                cstM.Delete(deletecst);
                                System.out.println("Customer deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editcstid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Customer to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editcst = scanner.nextLine();
                            try {
                                cstM.Edit(
                                        editcstid,
                                        editcst.split(";")[0],
                                        editcst.split(";")[1],
                                        editcst.split(";")[2],
                                        editcst.split(";")[3],
                                        editcst.split(";")[4]
                                );
                                System.out.println("Customer edited successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        default:
                            EnterCorrect();
                            break;
                    }
                    break;
                case 7:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(ownM.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: FirstName, SurName, Phone Number, Email Address, Card Info" + '\n' + "Enter with ';' symbol for each part ending");
                            String newown = scanner.nextLine();
                            int newid;
                            if (Owners.size() > 0) {
                                newid = Owners.get((Owners.size() - 1)).ID + 1;
                            } else {
                                newid = 1;
                            }
                            try {
                                ownM.Add(
                                        newid,
                                        newown.split(";")[0],
                                        newown.split(";")[1],
                                        newown.split(";")[2],
                                        newown.split(";")[3]);
                                System.out.println("Owner added successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 3:
                            System.out.println("Enter ID of Owner to delete");
                            int deleteown = Integer.parseInt(scanner.nextLine());
                            try {
                                ownM.Delete(deleteown);
                                System.out.println("Owner deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 4:
                            System.out.println("Enter ID");
                            int editownid = Integer.parseInt(scanner.nextLine());
                            System.out.println('\n' + "and new values of Owner to edit" + '\n' + "Enter with ';' symbol for each part ending");
                            String editown = scanner.nextLine();
                            try {
                                ownM.Edit(
                                        editownid,
                                        editown.split(";")[0],
                                        editown.split(";")[1],
                                        editown.split(";")[2],
                                        editown.split(";")[3]);
                                System.out.println("Owner edited successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        default:
                            EnterCorrect();
                            break;
                    }
                    break;
                case 8:
                    switch (submenuselection) {
                        case 1:
                            System.out.println(shpcrtM.GetAll());
                            break;
                        case 2:
                            System.out.println("Enter: Customer ID, Product ID" + '\n' + "Enter with ';' symbol for each part ending");
                            String newshpcrt = scanner.nextLine();
                            int newid;
                            if (ShoppingCarts.size() > 0) {
                                newid = ShoppingCarts.get((ShoppingCarts.size() - 1)).SCID + 1;
                            } else {
                                newid = 1;
                            }
                            try {
                                shpcrtM.Add(newid,
                                        Integer.parseInt(newshpcrt.split(";")[0]),
                                        Integer.parseInt(newshpcrt.split(";")[1]));
                                System.out.println("Shopping Cart Product added successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 3:
                            System.out.println("Enter ID to remove product from Shopping Cart");
                            int deleteshpcrt = Integer.parseInt(scanner.nextLine());
                            try {
                                shpcrtM.Delete(deleteshpcrt);
                                System.out.println("Shopping Cart Product deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        default:
                            EnterCorrect();
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
                                newid = 1;
                            }
                            try {
                                cshslM.Add(newid,
                                        Integer.parseInt(newcshsl.split(";")[0]),
                                        Integer.parseInt(newcshsl.split(";")[1]));
                                System.out.println("Scanned Product successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        case 2:
                            System.out.println("Enter ID to remove scanned product");
                            int deletecshsl = Integer.parseInt(scanner.nextLine());
                            try {
                                cshslM.Delete(deletecshsl);
                                System.out.println("Scanned Product deleted successfully");
                            } catch (Exception e) {
                                System.out.println("There was an error");
                            }
                            break;
                        default:
                            System.out.println("Enter correct number");
                            break;
                    }
                    break;
                case 10:
                    System.out.println("You logged out");
                    submenuselection = -1;
                    break;
                default:
                    EnterCorrect();
                    break;
            }
        }
    }

    private static void NoAccess() {
        System.out.println("You can not access those files");
        menuselection = -1;
    }

    private static void EnterCorrect() {
        System.out.println("Enter correct number");
        submenuselection = -1;
        menuselection = -1;
    }
}