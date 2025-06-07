package main.java.com.cognixia.jump.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String mySqlJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost:3306/dollars_bank";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection(){
        try{
            Class.forName(mySqlJDBCDriver);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection successful");
        }
        catch(ClassNotFoundException e){
            System.out.println("class not found exception, connection failed");
            System.out.println(e.getMessage());
        }
        catch(SQLException e){
            System.out.println("sql exception, connection failed");
            System.out.println(e.getMessage());
        }
        
        return conn;
        
    }

    public static void closeConnection(){
        try{
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
