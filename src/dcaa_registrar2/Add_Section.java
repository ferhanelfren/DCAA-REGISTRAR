/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GOD
 */
public class Add_Section extends javax.swing.JFrame {

    /**
     * Creates new form Add_Section
     */
    public Add_Section() {
        initComponents();
       table_update();
    }
    
    Connection Mycon;
    ResultSet rs;
    
    
     private void table_update()
    {
               int c;              
                                            try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select * from section");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTable.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("id")); 
                                                          v.add(rs.getString("section_name"));
                                                          
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
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
        jTable = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        section = new javax.swing.JTextField();
        ADD = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 241, 233));

        jTable.setAutoCreateRowSorter(true);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Section"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(56, 74, 19));
        jLabel18.setText("Section Name:");

        ADD.setBackground(new java.awt.Color(51, 51, 51));
        ADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/default.png"))); // NOI18N
        ADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        ADD.setFocusPainted(false);
        ADD.setRolloverEnabled(true);
        ADD.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        DELETE.setBackground(new java.awt.Color(51, 51, 51));
        DELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/default.png"))); // NOI18N
        DELETE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        DELETE.setFocusPainted(false);
        DELETE.setRolloverEnabled(true);
        DELETE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DELETE))
                    .addComponent(section))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
       // SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String sec = section.getText();
       

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        //java.util.Date now = new java.util.Date();

       
         try {   

             
        Class.forName("com.mysql.cj.jdbc.Driver");
        Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
        PreparedStatement ps;
       
        ps=Mycon.prepareStatement("INSERT INTO sections (section_name, timestamp) VALUES (?,?)");
        
        ps.setString(1, sec);
        ps.setString(2, timestamp);
        

        

        ps.execute();      
        table_update();
                    JOptionPane.showMessageDialog(null, "Section Successfully Added");
                    
                    // schoolyr.setSelectedIndex(-1);
                    
                    
                    
                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());
               
         } catch (ClassNotFoundException | SQLException ex) {
                   // JOptionPane.showMessageDialog(this, ex,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }//GEN-LAST:event_ADDActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

       
    }//GEN-LAST:event_DELETEActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Section.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Section.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Section.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Section.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Section().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton DELETE;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField section;
    // End of variables declaration//GEN-END:variables
}
