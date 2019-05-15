/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs14;

import static cs14.userData.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Abhimani
 */
public class owner {
    
    private String OID,OName,Address,ContactNum;
    
    static final String DB_URL =
      "jdbc:mysql://localhost:3306/cs14db";
    static final String DB_DRV =
      "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    
    public owner(String oid,String oName,String address,String contactNum){
        this.OID = oid;
        this.OName = oName;
        this.Address = address;
        this.ContactNum = contactNum;
    }
    
    public String getOID(){return OID;}
    public String getOName(){return OName;}
    public String getAddress(){return Address;}
    public String getContactNum(){return ContactNum;}
    
    public String toString(){
        return ("Owner info: "+getOID()+" "+getOName()+" "+getAddress()+" "+getContactNum()+"\n");
    }
    
    public void createNewEntry(owner o){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //System.out.println(u+"\n"+p+"\n");
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = connection.createStatement();
            int numServices = 0;
            statement.execute("INSERT INTO vehicleowner(OID,OwnerName,Address,ContactNum) VALUES('"+o.getOID()+"','"+o.getOName()+"','"+o.getAddress()+"','"+o.getContactNum()+"');");
            String ID = o.getOID();
            resultSet = statement.executeQuery("SELECT * FROM vehicleowner WHERE OID='"+ID+"'");
            if(resultSet.next()){
                JOptionPane.showMessageDialog(null,"Customer registered");
            }
            else{
                JOptionPane.showMessageDialog(null,"Error in Adding customer data");
            }
            connection.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error!\n"+ex);
        }
        
    }
    
}
