package cs14;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class test1 extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public test1() {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Username");
        model.addColumn("Password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs14db", "root", "");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM login");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
}