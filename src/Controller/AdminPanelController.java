package Controller;

import java.util.Scanner;

public class AdminPanelController {
    static void Menu() {
        Main.menuselection = -1;
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
        Main.menuselection = Integer.parseInt(scanner.nextLine());
    }

    static void ManagerSelections() {
        System.out.println("1 - View Manager");
        System.out.println("2 - Add Manager");
        System.out.println("3 - Remove Manager");
        System.out.println("4 - Edit Manager");
        System.out.println("Enter number: ");
    }

    static void OwnerSelections() {
        System.out.println("1 - View Owners");
        System.out.println("2 - Add Owners");
        System.out.println("3 - Remove Owners");
        System.out.println("4 - Edit Owners");
        System.out.println("Enter number: ");
    }
    static void CustomerSelections() {
        System.out.println("1 - View Customer");
        System.out.println("2 - Add Customer");
        System.out.println("3 - Remove Customer");
        System.out.println("4 - Edit Customer");
        System.out.println("Enter number: ");
    }
    static void EmployeeSelections() {
        System.out.println("1 - View Employee");
        System.out.println("2 - Add Employee");
        System.out.println("3 - Remove Employee");
        System.out.println("4 - Edit Employee");
        System.out.println("Enter number: ");
    }
    static void InventoryEmployeeSelections() {
        System.out.println("1 - View Inventory Employees");
        System.out.println("2 - Add Inventory Employees");
        System.out.println("3 - Remove Inventory Employees");
        System.out.println("4 - Edit Inventory Employees");
        System.out.println("Enter number: ");
    }
    static void CashierSelections() {
        System.out.println("1 - View Cashiers");
        System.out.println("2 - Add Cashiers");
        System.out.println("3 - Remove Cashiers");
        System.out.println("4 - Edit Cashiers");
        System.out.println("Enter number: ");
    }
    static void ProductSelections() {
        System.out.println("1 - View Products");
        System.out.println("2 - Add Products");
        System.out.println("3 - Remove Products");
        System.out.println("4 - Edit Products");
        System.out.println("5 - Import Products");
        System.out.println("6 - Export Products");
        System.out.println("Enter number: ");
    }
    static void CashierSalesSelection(){
        System.out.println("1 - Scan Product");
        System.out.println("2 - Remove Scanned Product");
        System.out.println("Enter number: ");
    }
}
