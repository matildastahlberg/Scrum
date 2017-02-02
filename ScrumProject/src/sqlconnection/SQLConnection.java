
 

package sqlconnection; 

import java.sql.*;
import javax.xml.transform.Result;


public class SQLConnection {
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=MyTestingDB;user=Testing;password=123456";
        Connection con = DriverManager.getConnection(connectionURL);
        
        System.out.println("You are connected");
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Roll");
        while(rs.next()){
        int ID = rs.getInt(1);
        String status = rs.getString(2); 
        System.out.println(ID + " " + status);
        
        }
    }
    
        public static Statement getDatabas() throws ClassNotFoundException, SQLException{
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=MyTestingDB;user=Testing;password=123456";
        Connection con = DriverManager.getConnection(connectionURL);
  
     Statement st = con.createStatement();

        return st;
    }
}


