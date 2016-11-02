package VIBClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ivylu on 2016-11-01.
 */
public class Employee {

    int employeeID;
    String name;
    private ArrayList<Employee> employeelist;
    OraManager oraManager;

    // Constructor
    public Employee() {
        oraManager = new OraManager();
        oraManager.buildConnection();
    }

    // java.sql.Connection con = Connection.getInstance().getConnection();

    public int getEmployeeID() {
        return employeeID;
    }

    public boolean isEmployee(int employeeID) {
        for (Employee e : employeelist) {
            if (employeeID == e.getEmployeeID()) {
                return true;
            }
        }
        return false;
    }

    public void addEmployee(int employeeID, String name) {
       // String insertQuery = "INSERT INTO employee VALUES (" + employeeID + "," + name + ")";
        String insertQuery = "INSERT INTO employee VALUES (19875,'It Works')";
        System.out.println(insertQuery);
         oraManager.execute(insertQuery);

    }

    //delete employee tuple that matches the employeeID
    public void removeEmployee(int employeeID) {
        for (Employee e : employeelist) {
            if (employeeID == e.getEmployeeID()) {
                employeelist.remove(e);
            }
        }
    }

    //return the list of name of customer who has birthday this month
    public List<String> birthdayGift(String currentMonth) {
        return null;
    }

    // select all tuples with inventory less than low
    public List<String> lowStockReport(int low) {
        return null;
    }

    // select the matching product
    // then add the numberAdded to current inventory
    public void addInventory(int productID, int numAdded) {

    }

    // let employee add in new member (Change customer to member)
    public void addNewMember(int accountNum) {

    }


    public static void main(String argv[]) {
        Employee employee = new Employee();
        employee.addEmployee(93485, "'IT WORKS'");
        System.out.println("FINISHES");
   /*     try {
            while (rs.next()) {
                int employeeID = rs.getInt("employeeID");
                String name = rs.getString("name");
                System.out.println("EmployeeID: "+ employeeID + "Name: "+ name + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
