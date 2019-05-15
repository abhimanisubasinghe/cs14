package cs14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    
    static final String DB_URL =
      "jdbc:mysql://localhost:3306/cs14db";
   static final String DB_DRV =
      "com.mysql.jdbc.Driver";
   static final String DB_USER = "root";
   static final String DB_PASSWD = "";
   
   public static void main(String args[]){
       Connection connection = null;
       Statement statement = null;
       ResultSet resultSet = null;
       
       try{
           connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
           statement = connection.createStatement();
           resultSet = statement.executeQuery("SELECT * FROM login");
           while(resultSet.next()){
               System.out.printf("%s\t%s\n",
                       resultSet.getString(1),
                       resultSet.getString(2));
           }
       }   
       
       catch(SQLException ex){
           System.out.println(ex);
   }
       finally{
           try{
               resultSet.close();
               statement.close();
               connection.close();
           }
           catch(SQLException ex){
               System.out.println(ex);
           }
       }
       
   }
    
}
