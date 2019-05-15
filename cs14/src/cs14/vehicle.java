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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Abhimani
 */
public class vehicle {
    
    private String VID,OID,Type/*,RegDate*/;
    private Date RegDate = new Date();
    private int numServices;
    
    static final String DB_URL =
      "jdbc:mysql://localhost:3306/cs14db";
    static final String DB_DRV =
      "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    
    public vehicle(String vid,String oid,int numServices,Date regDate,String type){
        this.VID = vid;
        this.OID = oid;
        this.RegDate = regDate;
        this.Type = type;
        this.numServices = numServices;
    }
    
    public String toString(){
        return ("Vehicle info: "+getVID()+" "+getOID()+" "+getRegDate()+" "+getType()+" "+getNumServices()+"\n");
    }
    
    public String getVID(){return VID;}
    public String getOID(){return OID;}
    public Date getRegDate(){return RegDate;}
    public String getType(){return Type;}
    public int getNumServices(){return numServices;}
    
    public void createNewEntry(vehicle v) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = connection.createStatement();
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
            dNow = v.getRegDate();
            statement.execute("INSERT INTO vehicle(VehicleID,OwnerID,NumServices,RegDate,Type) VALUES('"+v.getVID()+"','"+v.getOID()+"','"+v.getNumServices()+"','"+ft.format(dNow)+"','"+v.getType()+"');");
            String ID = v.getVID();
            resultSet = statement.executeQuery("SELECT * FROM vehicle WHERE VehicleID='"+ID+"'");
            if(resultSet.next()){
                JOptionPane.showMessageDialog(null,"Vehicle registered");
            }
            else{
                JOptionPane.showMessageDialog(null,"Error in Adding vehicle data");
            }
            connection.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error!\n"+ex);
        }
        
    }
    
    public void updateEntry(vehicle v) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = connection.createStatement();
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
            dNow = v.getRegDate();
            statement.execute("UPDATE vehicle SET OwnerID= '"+v.getOID()+"',NumServices='"+v.getNumServices()+"',RegDate='"+ft.format(dNow)+"',Type='"+v.getType()+"'WHERE VehicleID='"+v.getVID()+"'" );
            String ID = v.getVID();
            resultSet = statement.executeQuery("SELECT * FROM vehicle WHERE VehicleID='"+ID+"'");
            if(resultSet.next()){
                //JFrame parent = new JFrame();
                JOptionPane.showMessageDialog(null,"Vehicle data Updated");
            }
            else{
                JOptionPane.showMessageDialog(null,"Error in updating vehicle data");
            }
            connection.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error!\n"+ex);
        }
        
    }
    
    public void deleteEntry(vehicle v) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = connection.createStatement();
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    // yes option
                    statement.execute("DELETE FROM vehicle WHERE VehicleID='"+v.getVID()+"'" );
                     JOptionPane.showMessageDialog(null,"Vehicle data Deleted");
            }
            else {
                // no option
                 JOptionPane.showMessageDialog(null,"Vehicle data not deleted");
            }
            connection.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error!\n"+ex);
        }
        
    }
    
}
