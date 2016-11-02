package VIBClass;



import java.sql.*;

/**
 * Created by minnieliu on 2016-11-01.
 */
public class Customer {

    OraManager oraManager;

    public Customer() {
        oraManager = new OraManager();
    }

    public int addCustomer(String name, int phoneNumber, String gender) {
        String insertQuery = "INSERT INTO customer VALUES ("
                + name + ","
                + phoneNumber + ","
                + gender + ")";

        System.out.println(insertQuery);
        int rowCountInsertQuery = oraManager.execute(insertQuery);
        return rowCountInsertQuery;

    }


//addCustomer(name, phoneNumber){
//// insert new customer into instance
//        }
//
//
//        Add in a new member (account#){
//            //Add email address, password ….
//        }

    }
}



