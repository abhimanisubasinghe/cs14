package cs14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userData {
    static final String DB_URL =
      "jdbc:mysql://localhost:3306/cs14db";
    static final String DB_DRV =
      "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    
    public userData(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        
        try{
           connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
           statement = connection.createStatement();
           resultSet = statement.executeQuery("SELECT * FROM login");
           
            
        }
        catch(SQLException ex){
            System.out.println("Error!"+ex);
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
    
    public void insertUserData(String UserName,String Password){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String u = UserName;
        String p = Password;
        
        try{
            System.out.println(u+"\n"+p+"\n");
           connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
           statement = connection.createStatement();
           statement.execute("INSERT INTO login(UserName,Password) VALUES('"+u+"','"+p+"');");
           resultSet = statement.executeQuery("SELECT * FROM login");
           while(resultSet.next()){
               System.out.printf("%s\t%s\n",
                       resultSet.getString(1),
                       resultSet.getString(2));
           }
        }
        catch(SQLException ex){
            System.out.println("Error!"+ex);
        }
        finally{
            try{
//               resultSet.close();
               statement.close();
               connection.close();
           }
           catch(SQLException ex){
               System.out.println(ex);
           }
        }
    }
    
    
    
}
