/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_mgmt_ncstate;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mukka
 */
public class LFForm extends javax.swing.JFrame {

    /**
     * Creates new form LFForm
     */
    static final String jdbcURL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl";
    static Connection conn = null;
    static Statement stmt = null;
    //static ResultSet rs = null;
    static String patronid ;
    
    
    public LFForm(String id) {
        patronid = id;
        initComponents();
        initialize();
        load_lf_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Clear Dues");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton4.setText("Close");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jButton1)
                                .addGap(53, 53, 53)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jButton1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        ResultSet rs = null;
        try
        {
            String check_query = "SELECT COUNT(DISTINCT(C.RES_ID)) FROM Reservation R, CalcLateFee C WHERE R.patron_id = '"+patronid+"' AND R.res_id = C.res_id AND C.Status = 0";
            //System.out.println("3 -> "+check_query);
            rs = stmt.executeQuery(check_query);
            int count = 0;
            while(rs.next())
                count = rs.getInt(1);
            
            if(count==0)
            {
                jTextField1.setText("No balances due.");
            }
            else
            {
                //ResultSet rs2 = null;
                Statement stmt2 = conn.createStatement();
                Statement stmt3 = conn.createStatement();
                
                String update_query = "UPDATE CalcLateFee SET Status = 1 WHERE Res_id IN (SELECT C.Res_id FROM Reservation R, CalcLateFee C WHERE R.patron_id = '"+patronid+"' AND R.res_id = C.res_id AND C.Status = 0)";
                //System.out.println("4 -> "+update_query);
                stmt2.executeUpdate(update_query);
                jTextField1.setText("All due balances have been cleared.");
                
                String priv = "UPDATE Patron SET Privilege=1 WHERE Patron_id='"+patronid+"' AND Privilege=0";
                stmt3.executeUpdate(priv);
                //load_lf_table();
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

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        load_lf_table();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked

    /**
     * @param args the command line arguments
     */
    
    public void initialize()
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
            
            //ResultSet rs = null;
                
        }
       
     catch(Throwable oops) {
            oops.printStackTrace();
        }
         finally {
                //close(rs);
                //close(stmt);
                //close(conn);
            }
    }
    
    public void load_lf_table()
    {
        DefaultTableModel modellf = new DefaultTableModel();
        modellf.addColumn("Resource Type");
        modellf.addColumn("Resource Name");
        modellf.addColumn("Checked-out Date");
        modellf.addColumn("Due Date");
        modellf.addColumn("Checked-in Date");
        modellf.addColumn("Late Fee");
        
        ResultSet rs = null;
        try
        {
            String query = "SELECT R.Resc_id, R.Resc_type, TO_CHAR(R.Checkout_date, 'MM/DD/YYYY HH:MI:SS AM'), TO_CHAR(R.Due_date, 'MM/DD/YYYY HH:MI:SS AM'), TO_CHAR(R.Checkin_date, 'MM/DD/YYYY HH:MI:SS AM'), C.Late_fee FROM Reservation R, CalcLateFee C WHERE R.patron_id = '"+patronid+"' AND R.res_id = C.res_id AND C.Status = 0";
            //System.out.println("1 -> "+query);
            rs = stmt.executeQuery(query);
            int count = 0;
            int total_late_fee = 0;
            while(rs.next())
            {
                count++;
                String r_id = rs.getString(1);
                String r_type = rs.getString(2);
                String co_date = rs.getString(3);
                String due_date = rs.getString(4);
                String ci_date = rs.getString(5);
                int fee = rs.getInt(6);
                
                total_late_fee = total_late_fee + fee;
                
                String r_name = "";
                ResultSet rs2 = null;
                Statement stmt2 = conn.createStatement();
                String res_query;
                
                switch(r_type)
                {
                    case "Book":
                        res_query = "SELECT DISTINCT B.title FROM Book B, BookList BL WHERE BL.book_id = '"+r_id+"' and BL.isbn = B.isbn";
                        //System.out.println("2 -> "+res_query);
                        rs2 = stmt2.executeQuery(res_query);
                        while(rs2.next())
                        {
                            r_name = rs2.getString(1);
                        }
                        break;
                    
                    case "Journal":
                        res_query = "SELECT DISTINCT J.title FROM Journal J, JournalList JL WHERE JL.journal_id = '"+r_id+"' and JL.issn = J.issn";
                        //System.out.println("2 -> "+res_query);
                        rs2 = stmt2.executeQuery(res_query);
                        while(rs2.next())
                        {
                            r_name = rs2.getString(1);
                        }
                        break;
                        
                    case "Conf":
                        res_query = "SELECT DISTINCT C.title FROM Conf C, CPList CL WHERE CL.paper_id = '"+r_id+"' and CL.conf_num = C.conf_num";
                        //System.out.println("2 -> "+res_query);
                        rs2 = stmt2.executeQuery(res_query);
                        while(rs2.next())
                        {
                            r_name = rs2.getString(1);
                        }
                        break;
                        
                    case "Room":
                        r_name = r_id;
                        break;
                        
                    case "Camera":
                        res_query = "SELECT DISTINCT C.make, C.model FROM Camera C WHERE C.camera_id = '"+r_id+"'";
                        //System.out.println("2 -> "+res_query);
                        rs2 = stmt2.executeQuery(res_query);
                        while(rs2.next())
                        {
                            r_name = rs2.getString(1) + " " + rs2.getString(2);
                        }
                        break;
                        
                    default:
                        r_name = "";
                        
                }
                
                modellf.addRow(new Object[]{r_type, r_name, co_date, due_date, ci_date, fee});
                
            }
            if(count==0)
            {
                jTextField1.setText("No balances due.");
                modellf.addRow(new Object[]{"", "Total", "", "", "", 0});
                jTable1.setModel(modellf);
            }
            else
            {
                modellf.addRow(new Object[]{"", "Total", "", "", "", total_late_fee});
                jTable1.setModel(modellf);
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
        
    }
    
    
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
            java.util.logging.Logger.getLogger(LFForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LFForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LFForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LFForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LFForm(patronid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}