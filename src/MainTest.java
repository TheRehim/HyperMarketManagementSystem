import Model.DataBaseClasses;

import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @org.junit.jupiter.api.Test
    void main() {
        //for not having any methods that returns value or even we send value to method. we decided to test our database classes and lists in it with list methods.
        // and also we didnot use our interfaces with classes specified for them. because we have less classes and we didnot need to make 1 more class for each database class.
        //it would cost us much more time and space. but would still be same as we dont have any sql database we also didnot have security issue
        try {
            assertEquals(0, DataBaseClasses.Employees.get(DataBaseClasses.Employees.size() - 1).ID, 5);
        } catch (Exception e) {
            System.out.println("Employee database error");
        }
        try {
            assertEquals(0, DataBaseClasses.InvEmployees.get(DataBaseClasses.InvEmployees.size() - 1).ID, 100);
        } catch (Exception e) {
            System.out.println("Inventory Employee database error");
        }
        try {
            assertEquals(0, DataBaseClasses.Cashiers.get(DataBaseClasses.Cashiers.size() - 1).ID, 12);
        } catch (Exception e) {
            System.out.println("Cashier database error");
        }
        try {
            assertEquals(0, DataBaseClasses.Customers.get(DataBaseClasses.Customers.size() - 1).ID, 40);
        } catch (Exception e) {
            System.out.println("Customer database error");
        }
        try {
            assertEquals(0, DataBaseClasses.Products.get(DataBaseClasses.Products.size() - 1).ID, 66);
        } catch (Exception e) {
            System.out.println("Product database error");
        }
        try {
            assertEquals(0, DataBaseClasses.Owners.get(DataBaseClasses.Owners.size() - 1).ID, 52);
        } catch (Exception e) {
            System.out.println("Owner database error");
        }
        try {
            assertEquals(0, DataBaseClasses.ShoppingCarts.get(DataBaseClasses.ShoppingCarts.size() - 1).SCID, 59);
        } catch (Exception e) {
            System.out.println("Shopping Cart database error");
        }
        try {
            assertEquals(0, DataBaseClasses.CashierSale.get(DataBaseClasses.CashierSale.size() - 1).CSID, 25);
        } catch (Exception e) {
            System.out.println("Cashier Sales database error");
        }
        try {
            assertEquals(0, DataBaseClasses.Managers.get(DataBaseClasses.Managers.size() - 1).ID, 77);
        } catch (Exception e) {
            System.out.println("Manager Sales database error");
        }
    }
}