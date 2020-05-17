/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GOD
 */
public class Edit_Record extends javax.swing.JFrame {

    /**
     * Creates new form Edit_Record
     */
    
    String filepath;
    public Edit_Record() {
        initComponents();
        table_update();
        
            jTable.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,20));
            jTable.getTableHeader().setOpaque(false);
            jTable.getTableHeader().setBackground(new Color(165,19,29));
            jTable.getTableHeader().setForeground(new Color(255,255,255));
            jTable.getRowHeight(100);
        
    }
    
    
    
    
       public class SchoolYear2 
       {
           
           int id;
           String name;
           
           
           public SchoolYear2 (int id, String name)

           {
            
               this.id=id;
               this.name=name;
               
           }
           
           
           
           public String toString ()
            {
               
               return name;
               
               
            }
           
           
           
           
           
       }
    
   
        
    
    
    
    
    
    
    
    
    
    
    

    Connection Mycon;
    ResultSet rs;
   

//      private void schoolyear2()
//              
//             
//        {
//            
//           
//              try {
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
//                PreparedStatement ps;
//                ps=Mycon.prepareStatement("select * from school_year");
//                rs= ps.executeQuery();
//                schoolyr.removeAllItems();
//                
//                
//                
//                
//                while (rs.next())
//                
//                {
//                    
//                    
//                     schoolyr.addItem(new SchoolYear2(rs.getInt(1),rs.getString(2)));
//                    
//                }
//                
//
//               
//            }catch (ClassNotFoundException  ex) {
//                Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
//            }catch ( SQLException ex) {
//                Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            
//            
//            
//        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        private void table_update()
    {
                                       
        
                                                                    int c;
                                            
                                            try {
                                                
                                                
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select a.id, b.fullname, a.crt_enrollment, a.crt_goodmoral, a.crt_completion, a.honorable_dismissal, a.sf10, a.sf9, a.psa, a.diploma, a.timestamp from student_records a, enrolled_students b  where  a.enrolled_students_id = b.id");
                                           ResultSet rs = ps.executeQuery();
                                            
                                           
                                           //a.id, b.name, c.fullname, a.crt_enrollment, a.crt_goodmoral, a.crt_completion, a.honorable_dismissal, a.sf10, a.sf9, a.psa, a.diploma from student_records a, school_year b, enrolled_students c where a.school_year_id = b.id and a.enrolled_students_id = c.id 
                                           //select p.idproduct, p.product, p.description, c.name, b.brandname, p.cost_price, p.retail_price, p.quantity, p.barcode, p.status  from product p,category c, brand b  where p.cat_id = c.id and p.brand_id = b.id
                                            
                                           
                                           
                                          // a.id,b.school_year_id, b.student_account_no, b.lrnNumber, b.fullname, b.sex, b.grade_level, b.enrolled_track, a.crt_enrollment, a.crt_goodmoral, a.crt_completion, a.honorable_dismissal, a.sf10, a.sf9, a.psa, a.diploma, a.timestamp from student_records a, enrolled_students b where  a.enrolled_students_id = b.id and a.school_year_id = b.id
                                          //a.id , b.school_year_id, c.student_account_no, c.lrnNumber, c.fullname, c.sex, c.grade_level, c.enrolled_track, a.crt_enrollment, a.crt_goodmoral, a.crt_completion, a.honorable_dismissal, a.sf10, a.sf9, a.psa, a.diploma, a.timestamp from student_records a, enrolled_students b where  a.enrolled_students_id= c.id and a.enrolled_students_school_year_id= b.id 
                                           
                                           
                                            ResultSetMetaData rsd=rs.getMetaData();
                                            
                                           c = rsd.getColumnCount();
                                            
                                                DefaultTableModel model =  (DefaultTableModel)jTable.getModel() ;
                                            
//                                            
//                                          DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//                                              rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
//                                              jTable.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
//                                              
                                               
                                               
                                            model.setRowCount(0);
                                            
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("crt_enrollment"));
                                                         v.add(rs.getString("crt_goodmoral"));
                                                         v.add(rs.getString("crt_completion"));
                                                         v.add(rs.getString("honorable_dismissal"));
                                                         v.add(rs.getString("sf10"));
                                                         v.add(rs.getString("sf9"));
                                                         v.add(rs.getString("psa"));
                                                         v.add(rs.getString("diploma"));
                                                        
                                                      
                                                                                   
                                                    }
                                                    
                                                    model.addRow(v); 
                                                   
                                                }
                                        }  catch (ClassNotFoundException  ex) {
                                                Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
                                        }catch ( SQLException ex) {
                                                Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        enrollment = new javax.swing.JButton();
        ENROLLMENT = new javax.swing.JTextField();
        OPEN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Forms and Records");
        setAlwaysOnTop(true);

        jPanel5.setBackground(new java.awt.Color(43, 70, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All Rights Reserved 2020");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1497, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(244, 241, 233));

        jTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Certificate of Enrollment", "Certificate of Good Moral", "Certificate of Completion", "Honorable Dismissal", "SF 10", "SF 9", "PSA", "Diploma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setGridColor(new java.awt.Color(67, 21, 23));
        jTable.setRowHeight(25);
        jTable.setSelectionBackground(new java.awt.Color(104, 143, 78));
        jTable.setSelectionForeground(new java.awt.Color(165, 19, 29));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        enrollment.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        enrollment.setForeground(new java.awt.Color(204, 0, 0));
        enrollment.setText("File");
        enrollment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        enrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollmentActionPerformed(evt);
            }
        });

        OPEN.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        OPEN.setForeground(new java.awt.Color(204, 0, 0));
        OPEN.setText("Open");
        OPEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPENActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(ENROLLMENT, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enrollment, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OPEN, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ENROLLMENT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enrollment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(OPEN)))
                .addContainerGap(458, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
       
        
         DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
        int selecIndex = jTable.getSelectedRow();
        
        
        ENROLLMENT.setText(model2.getValueAt(selecIndex, 1).toString() );
        
        
    }//GEN-LAST:event_jTableMouseClicked

    private void enrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollmentActionPerformed
        JFileChooser jfchoose = new JFileChooser();
        jfchoose.showOpenDialog(this);

        try {

            File f =  jfchoose.getSelectedFile();
            //filepath = f.getName();
            filepath = f.getAbsolutePath();
            filepath = filepath.replace('\\', '/');
            ENROLLMENT.setText(filepath);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_enrollmentActionPerformed

    private void OPENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPENActionPerformed

        filepath = ENROLLMENT.getText();

        try {

            File pdfFile = new File(filepath);

            if (pdfFile.exists()) {

                if (Desktop.isDesktopSupported()) {

                    Desktop.getDesktop().open(pdfFile);

                } else {

                    JOptionPane.showMessageDialog(rootPane, "Desktop is not supported");

                }

            } else {

                JOptionPane.showMessageDialog(rootPane, "File is not Exists");

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Error");

        }

    }//GEN-LAST:event_OPENActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Edit_Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Record().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ENROLLMENT;
    private javax.swing.JButton OPEN;
    private javax.swing.JButton enrollment;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
