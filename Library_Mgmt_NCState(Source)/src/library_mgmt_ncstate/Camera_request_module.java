/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_mgmt_ncstate;

import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 *
 * @author Isha
 */
public class Camera_request_module extends javax.swing.JFrame {

    /**
     * Creates new form Camera_request_module
     */
    static final String jdbcURL 
	= "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl";
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static String patron_id; 
    public Camera_request_module(String id) {
        patron_id = id;
        initComponents();
        connect();
        System.out.println("hi3");
        load_camera_list();
        System.out.println("hi4");
    }
    
    public static void connect()
    {
                try {
            // Load the driver. This creates an instance of the driver
	    // and calls the registerDriver method to make Oracle Thin
	    // driver available to clients.
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
	    String user = "msaikia"; 	// For example, "jsmith"
	    //String user = "ibobra";
            //String passwd = "200109140";	// Your 9 digit student ID number
	    String passwd = "200109120";
                 // Get a connection from the first driver in the
		// DriverManager list that recognizes the URL jdbcURL
		conn = DriverManager.getConnection(jdbcURL, user, passwd);
		// Create a statement object that will be sending your
		// SQL statements to the DBMS
		stmt = conn.createStatement();
                System.out.println("hi5");
                }
       
     catch(Throwable oops) {
            oops.printStackTrace();
        }
         finally {
                close(rs);
                //close(stmt);
                //close(conn);
            }
    }
    
    public void refresh ()
    {
        jTextArea1.setText( "");
        jXDatePicker1.setDate(null);
    }
    
    public void load_camera_list()
    {
        DefaultListModel modelcam = new DefaultListModel();
        try{
            rs = stmt.executeQuery("SELECT CAMERA_ID FROM CAMERA");
            System.out.println("hi1");            
            while (rs.next()) {
		    String camera_id = rs.getString("CAMERA_ID");
                    System.out.println(camera_id);
                    modelcam.addElement(camera_id);
                }
            System.out.println("hi2");
                jList1.setModel(modelcam);
                
                
        }
                catch(Throwable oops){
                        oops.printStackTrace();
                        }
        finally {
                close(rs);
                //close(stmt);
                //close(conn);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setName("camer_frame"); // NOI18N
        setSize(new java.awt.Dimension(200, 150));

        jPanel1.setName("cmaera_panel"); // NOI18N

        jList1.setName("camera_list"); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Camera List");
        jLabel1.setName("CameraList_label"); // NOI18N

        jList2.setName("Camera_detail"); // NOI18N
        jScrollPane2.setViewportView(jList2);

        jButton1.setText("Request");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setText("Checkout Date");

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel3.setText("Select a camera from the list, fill the request form and Click on Request button");

        jLabel4.setText("Select a Friday");

        jLabel5.setText("Camera Details");
        jLabel5.setName("CameraList_label"); // NOI18N

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel1)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addGap(104, 104, 104))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(34, 34, 34))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        DefaultListModel modeldetail = new DefaultListModel();
        String cam_id = (String) jList1.getSelectedValue();
        try{
            rs = stmt.executeQuery("SELECT Camera_id,make,model,lens,memory_avail,l.lib_name"
                    + " FROM Camera c, library l where l.lib_no = c.lib_no and camera_id = '" 
                    + cam_id + "'");
            modeldetail.clear();
            while (rs.next()) {
              String camera_id = rs.getString("camera_id");
                    String make = rs.getString("make");
                    String model = rs.getString("model");
                    String lens = rs.getString("lens");
                    String memory_avail = rs.getString("memory_avail");
                    String library_name = rs.getString("lib_name");
              modeldetail.addElement("Camera_Id: " + camera_id );
              modeldetail.addElement("Make: " + make );
              modeldetail.addElement("Model: " + model );
              modeldetail.addElement("Lens: " + lens );
              modeldetail.addElement("Memory_avail: " + memory_avail );
              modeldetail.addElement("Library_name: " + library_name );
            }
                jList2.setModel(modeldetail);
        }
                catch(Throwable oops){
                        oops.printStackTrace();
                        }
        finally {
                close(rs);
                //close(stmt);
                //close(conn);
            }
    }//GEN-LAST:event_jList1MouseClicked

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
        int count = 0;
        int flag = 0;
        Calendar c = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
         
        String cam_id = (String) jList1.getSelectedValue();
        String formatedDate = "01/01/2015";
        if (jXDatePicker1.getDate().toString().substring(0,3).equals("Fri"))
        {
            try
            {
            java.util.Date date = (java.util.Date)formatter.parse(jXDatePicker1.getDate().toString());
            c.setTime(date);
            formatedDate = c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" +c.get(Calendar.YEAR);  
            }
            catch (Throwable oops)
            {
                oops.printStackTrace();
            }
            c.setTime(jXDatePicker1.getDate()); 
            c.add(Calendar.DATE, 6); 
            try{
            rs = stmt.executeQuery("Select patron_id,que_pos from resv_camera_q where intended_friday = "+ 
            "TO_CHAR(to_date('" + formatedDate +"','DD/MM/YYYY'), 'DD-MON-YY') and camera_id = '" + cam_id +"'");
            while (rs.next())
            {
                if (rs.getString("patron_id").equals(patron_id))
                    flag = 1;
                count++;
            }
            
            if (count != 0 && flag ==0)
            {
                jTextArea1.setText("Your request will be in the waitlist your position in the queue would be "+ (count)  
                + "\n" + " If cleared, the checkout date will be: "+ jXDatePicker1.getDate().toString().substring(0,10)
                    + " from 9AM to Noon" + "\n" +
                    "The return date will be: " + c.getTime().toString().substring(0,10)
                                + " by 9 PM"  + "\n" +"Click on Request Button to confirm!");
                }
            else if (count == 0)
            {
                 jTextArea1.setText("The checkout date will be: "+ jXDatePicker1.getDate().toString().substring(0,10)
                    + " from 9AM to Noon" + "\n" +
                    "The return date will be: " + c.getTime().toString().substring(0,10)
                                + " by 9 PM"  + "\n" +"Click on Request Button to confirm!");
            }
            else
                jTextArea1.setText("You are already in the waitlist for this camera on this date."
                        + " Kindly choose another date or another camera!");
            }
                catch(Throwable oops){
                        oops.printStackTrace();
                }
        finally {
                close(rs);
                //close(stmt);
                //close(conn);
            }
        }
        else
            jTextArea1.setText("Please select a Friday Only!");
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int count = 0;
        Calendar c = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
         
        String cam_id = (String) jList1.getSelectedValue();
        String formatedDate = "01/01/2015";
        try{
            try
            {
            java.util.Date date = (java.util.Date)formatter.parse(jXDatePicker1.getDate().toString());
            System.out.println("date: " + date);  
            c.setTime(date);
            formatedDate = c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" +c.get(Calendar.YEAR);
            }
            catch (Throwable oops)
            {
                oops.printStackTrace();
            }
            System.out.println("Select que_pos from resv_camera_q where intended_friday = "+ 
            "TO_CHAR(to_date('" + formatedDate +"','DD/MM/YYYY'), 'DD-MON-YY') and camera_id = '" + cam_id + "'");
            rs = stmt.executeQuery("Select que_pos from resv_camera_q where intended_friday = "+ 
            "TO_CHAR(to_date('" + formatedDate +"','DD/MM/YYYY'), 'DD-MON-YY') and camera_id = '" + cam_id + "'");
            while (rs.next())
            {
                count++;
            }
            System.out.println("insert into resv_camera_q values ('" + cam_id +"','" + patron_id +
                         "',TO_CHAR(to_date('" + formatedDate +"','DD/MM/YYYY'), 'DD-MON-YY') "
                    + "," + (count+1)+")");
            rs = stmt.executeQuery("insert into resv_camera_q values ('" + cam_id +"','" + patron_id +
                         "',TO_CHAR(to_date('" + formatedDate +"','DD/MM/YYYY'), 'DD-MON-YY') "
                    + "," + (count+1)+")");
            rs = stmt.executeQuery("Commit");
            if (count == 0)
            {
                jTextArea1.setText("Your reservation has been made");
            }
            else {
            jTextArea1.setText("Your request has been saved and your position in the queue is "+ (count));
                }
        }
                catch(Throwable oops){
                        oops.printStackTrace();
                }
        finally {
                close(rs);
                //close(stmt);
                //close(conn);
            }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); }
            catch(Throwable oops) 
            {
                oops.printStackTrace();
            }
        }
    }

    static void close(Statement st) {
        if(st != null) {
            try { st.close(); } catch(Throwable oops) {oops.printStackTrace();}
        }
    }

    static void close(ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch(Throwable oops) {oops.printStackTrace();}
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Camera_request_module.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Camera_request_module.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Camera_request_module.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Camera_request_module.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Camera_request_module(patron_id).setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}