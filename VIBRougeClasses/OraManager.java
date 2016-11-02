package VIBClass;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by IvyLuo on 2016-11-01.
 */
public class OraManager {
    public java.sql.Connection conn;
    public Statement stmt;

    public OraManager() {}


    public void buildConnection() {

        try {
            System.out.println("Loading driver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Finished Loading");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to load driver");
            System.exit(-1);
        }

        try{
            System.out.println("Connecting database...");

            String url = "jdbc:oracle:thin:@localhost:1522:ug";
            conn = DriverManager.getConnection(url, "ora_m6v9a", "a31147144");
            conn.setAutoCommit(true);

            System.out.println("Connect Successful");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Connection fail"+e);

        }
    }

    public int execute(String stringForExecute){
        int rowCount = -1;
        try {
            //System.out.println(targetTable + " before execution -->");
            rowCount = stmt.executeUpdate(stringForExecute);
            System.out.println("row " + rowCount + " updated");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(stringForExecute + " : update fails");
        }
        return rowCount;
    }



    public void query(String stringForQuery){
        try {
            stmt = conn.createStatement();
            stmt.executeQuery(stringForQuery);
            System.out.println("U FINISHED QUERY");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(stringForQuery + " : query fails");
        }
        //return rs;
    }

    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("disconnect fails");
        }
    }

}