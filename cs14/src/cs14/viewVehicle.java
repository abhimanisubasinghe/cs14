/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs14;

import static cs14.vehicle.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Abhimani
 */
public class viewVehicle extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewVehicle
     */
    public viewVehicle() {
        initComponents();
        show_vehicle();
    }
    static final String DB_URL =
      "jdbc:mysql://localhost:3306/cs14db";
    static final String DB_DRV =
      "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "";
    
    public ArrayList<vehicle> vehicleList(){
        ArrayList<vehicle> vehicleList = new ArrayList<>();
      
        try{
            Connection connection;
            connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            statement = connection.createStatement();
            String query1 = "SELECT * FROM vehicle";
            resultSet = statement.executeQuery(query1);
            vehicle v;
            while(resultSet.next()){
                v = new vehicle(resultSet.getString("VehicleID"),resultSet.getString("OwnerID"),resultSet.getInt("NumServices"),resultSet.getDate("RegDate"),resultSet.getString("Type"));
                vehicleList.add(v);
            }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return vehicleList;
     }
    
    public void show_vehicle(){
        ArrayList<vehicle> list = vehicleList();
        DefaultTableModel model = (DefaultTableModel)jTblVehicleView.getModel();
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]= list.get(i).getVID();
            row[1]= list.get(i).getOID();
            row[2]= list.get(i).getRegDate();
            row[3]= list.get(i).getType();
            row[4]= list.get(i).getNumServices();
            model.addRow(row);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTblVehicleView = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtVID = new javax.swing.JTextField();
        txtOID = new javax.swing.JTextField();
        calRegDate = new com.toedter.calendar.JDateChooser();
        txtVType = new javax.swing.JTextField();
        txtNServices = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTblVehicleView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle ID", "Owner's iD", "Registered Date", "Vehicle Type", "Num of Services"
            }
        ));
        jTblVehicleView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblVehicleViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblVehicleView);

        jLabel1.setText("Vehicle ID");

        jLabel2.setText("Owner's ID");

        jLabel3.setText("Reg Date");

        jLabel4.setText("Vehicle Type");

        jLabel5.setText("Num of Services");

        txtVID.setEnabled(false);

        calRegDate.setDateFormatString("yyyy-MM-dd");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(btnUpdate))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(calRegDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtVID)
                                .addComponent(txtOID)
                                .addComponent(txtVType)
                                .addComponent(txtNServices))
                            .addComponent(btnDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(btnRefresh)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(txtVID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtOID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addComponent(calRegDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtVType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(txtNServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTblVehicleViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblVehicleViewMouseClicked
        // TODO add your handling code here:
        int i = jTblVehicleView.getSelectedRow();
        TableModel model = jTblVehicleView.getModel();
        txtVID.setText(model.getValueAt(i,0).toString());
        txtOID.setText(model.getValueAt(i,1).toString());
        String date = model.getValueAt(i, 2).toString();
        ((JTextField)calRegDate.getDateEditor().getUiComponent()).setText(date);
        txtVType.setText(model.getValueAt(i, 3).toString());
        txtNServices.setText(model.getValueAt(i, 4).toString());
        //calRegDate.setDate(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_jTblVehicleViewMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String VID,OID,Type; 
        int num;
        Date RegDate = new Date();
        
        VID = txtVID.getText();
        OID = txtOID.getText();
        Type = txtVType.getText();
        RegDate = calRegDate.getDate();
        num = Integer.parseInt(txtNServices.getText());
        //System.out.println(RegDate+" "+num);
        
        vehicle v = new vehicle(VID,OID,num,RegDate,Type);
        System.out.println(v);
        v.updateEntry(v);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTblVehicleView.getModel();
        model.setRowCount(0);
        show_vehicle();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String VID,OID,Type; 
        int num;
        Date RegDate = new Date();
        Date today = new Date();
        
        VID = txtVID.getText();
        OID = txtOID.getText();
        Type = txtVType.getText();
        RegDate = calRegDate.getDate();
        num = Integer.parseInt(txtNServices.getText());
        //System.out.println(RegDate+" "+num);
        
        vehicle v = new vehicle(VID,OID,num,RegDate,Type);
        System.out.println(v);
        v.deleteEntry(v);
        txtVID.setText("");
        txtOID.setText("");
        txtVType.setText("");
        txtNServices.setText("");
        calRegDate.setDate(today);
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser calRegDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblVehicleView;
    private javax.swing.JTextField txtNServices;
    private javax.swing.JTextField txtOID;
    private javax.swing.JTextField txtVID;
    private javax.swing.JTextField txtVType;
    // End of variables declaration//GEN-END:variables
}
