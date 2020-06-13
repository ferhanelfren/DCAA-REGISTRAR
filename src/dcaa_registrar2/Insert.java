/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import com.itextpdf.io.util.FileUtil;
import com.mysql.cj.jdbc.Blob;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GOD
 */
public class Insert extends javax.swing.JFrame {

    
    String path = null ;
    /**
     * Creates new form Insert
     */
     
   
    public Insert() {
        initComponents();
         table_update();
         table_update2();
       
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
                                           ps=Mycon.prepareStatement("select * from insertfilesample");
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
                                                          v.add(rs.getString("file_name"));
                                                          v.add(rs.getString("fileS")); 
                                                           
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
    }
    
    
       private void table_update2()
    {
               int c;              
                                            try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select * from insertfilesample2");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTable1.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                          v.add(rs.getString("file_id")); 
                                                          v.add(rs.getString("file_name"));
                                                          v.add(rs.getString("file_size_in_kb")); 
                                                          v.add(rs.getString("file_extension")); 
                                                        
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
        jTextField1 = new javax.swing.JTextField();
        open = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        download2 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        browse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "File Name", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("image");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("jButton7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("DATA SAVED");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "File Name", "Size", "File Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Byte.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton9.setText("Download");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        download2.setText("Download2");
        download2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                download2ActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jButton10.setText("path");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        browse.setText(" Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(download2)
                                .addGap(43, 43, 43)
                                .addComponent(delete))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(open)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)
                                    .addComponent(jButton4)
                                    .addComponent(jButton7))
                                .addGap(128, 128, 128)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addGap(34, 34, 34)
                        .addComponent(browse)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(open)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addGap(17, 17, 17)
                                .addComponent(jButton6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton9))))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(download2)
                    .addComponent(jButton10)
                    .addComponent(browse))
                .addContainerGap(38, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        
        JFileChooser jfchoose = new JFileChooser();
        jfchoose.showOpenDialog(this);
        
        InputStream input = null;
        FileOutputStream output = null;
        
         
           int len;
        String query;
        PreparedStatement pstmt;
        
         try {   
             

             File files = jfchoose.getSelectedFile();
             jTextField1.setText(files.getAbsolutePath());
            FileInputStream fis = new FileInputStream(files);
            len = (int)files.length();
            
             
        Class.forName("com.mysql.cj.jdbc.Driver");
        Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
        PreparedStatement ps;
       
        
        
           
        
        ps=Mycon.prepareStatement("INSERT INTO insertfilesample (file_name, files) VALUES (?,?)");
       
         //   pstmt = Mycon.prepareStatement(query);
            ps.setString(1,files.getName());
          //  ps.setInt(2, len);
            
            //method to insert a stream of bytes
          //  ps.setBinaryStream(2, fis, len); 
            
         
            ps.setBlob(2, fis, len);
            
            
            ps.executeUpdate();
             table_update();
                    JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");
                    
                  
                    
                    
                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());
               
         } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
         
         
        
        
        try {
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        
    }//GEN-LAST:event_openActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfchoose = new JFileChooser();
        jfchoose.showOpenDialog(this);
        
        InputStream input = null;
        FileOutputStream output = null;
        
         
           int len;
        String query;
        PreparedStatement pstmt;
        
         try {   
             
//          byte[] fileContent = Files.readAllBytes(pat);
//          ByteArrayInputStream bias = new ByteArrayInputStream(fileContent);
//          File pdf = new File(ENROLLMENT.getText());
//          FileInputStream FileInput = new FileInputStream(pdf);        
//          ByteArrayOutputStream bos = new ByteArrayOutputStream();
//          
             
        Class.forName("com.mysql.cj.jdbc.Driver");
        Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
        PreparedStatement ps;
       
        
        
            File files = jfchoose.getSelectedFile();
            byte[] b = new byte[(int)files.length()];
           // FileInputStream fis = new FileInputStream(files);
           // len = (int)files.length();
        
        ps=Mycon.prepareStatement("INSERT INTO insertfilesample (file_name, files) VALUES (?,?)");
       
         //   pstmt = Mycon.prepareStatement(query);
            ps.setString(1,files.getName());
            ps.setBytes(2, b);
          //  ps.setInt(2, len);
            
            //method to insert a stream of bytes
          //  ps.setBinaryStream(2, fis, len); 
            
         
           // ps.setBlob(2, fis, len);
           // 
            
            ps.executeUpdate();
             table_update();
                    JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");
                    
                  
                    
                    
                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());
               
         } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         JFileChooser jfchoose = new JFileChooser();
        jfchoose.showOpenDialog(this);
        
       // InputStream input = null;
         
          
          
        
         try {   
              File files = jfchoose.getSelectedFile();
              FileInputStream io = new FileInputStream(files);
              byte [] pdfData = new byte[(int) files.length()];
              DataInputStream dis;
              
              dis = new DataInputStream(new FileInputStream(files));
              dis.readFully(pdfData);
              dis.close();

          
             
        Class.forName("com.mysql.cj.jdbc.Driver");
        Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
        PreparedStatement ps;
        ps=Mycon.prepareStatement("INSERT INTO insertfilesample (file_name, files) VALUES (?,?)");
       
         //   pstmt = Mycon.prepareStatement(query);
            ps.setString(1,files.getName());
            
            ps.setBytes(2, pdfData);
      
           
            ps.executeUpdate();
            ps.setBinaryStream(1,  (InputStream)dis,(int)files.length());

             table_update();
                    JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");

         } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
//        try {
//            
//            Runtime.getRuntime().e
//            
//        } catch (Exception e) {
//        }
        
Connection con;
PreparedStatement ps;
ResultSet rs;
PreparedStatement pst;
Blob blob;
InputStream in;
InputStream input;
OutputStream output;
        try {
ps = (PreparedStatement) Mycon.createStatement();
rs = ps.executeQuery("select insertfilesample from files");
int i = 1;
  
blob = null;
while (rs.next()) {
blob = (Blob) rs.getBlob("files");
}
  
input = blob.getBinaryStream();
output=new FileOutputStream("");
byte by[]=blob.getBytes(0,(int)blob.length());
  
output.write(by);
  
 
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
Mycon.close();
} catch (java.sql.SQLException sqle) {
  
}
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser jfchoose = new JFileChooser();
        jfchoose.showOpenDialog(this);
        FileReader fr;
        File file;
        try {

        file = jfchoose.getSelectedFile();

        int fileLength = (int) file.length();
        InputStream stream = (InputStream) new FileInputStream(file);

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("INSERT INTO insertfilesample (file_name, files) VALUES (?,?)");
                ps.setString(1,file.getName());
                ps.setAsciiStream(2, stream, fileLength);


        ps.executeUpdate();
        
         table_update();
                    JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");
        
        }
         catch (Exception e) {
                     JOptionPane.showMessageDialog(this, e,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, e);
        
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
                
Connection con;
PreparedStatement ps;
ResultSet rs;
PreparedStatement pst;
Blob blob=null;
//InputStream in;
//InputStream input;
//OutputStream output;
byte[] buffer = new byte[4096];
        File file= new File("c:\\MyPath\\myPDF.pdf");
        
//        try {
//
//		if ((new File("c:\\Java-Interview.pdf")).exists()) {
//
//			Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler");
//			p.waitFor();
//
//		} else {
//
//			System.out.println("File is not exists");
//
//		}
//
//		System.out.println("Done");
//
//  	  } catch (Exception ex) {
//		ex.printStackTrace();
//	  }

           // FileOutputStream output = null;
 
            
          //  InputStream is = blob.getBlob();
//       try{
//            FileOutputStream output= new FileOutputStream(file);
//            int b = 0;
//            while ((b = blob.getBlob().read()) != -1) {
//                output.write(buffer);
//
//            }
//            output.close();
//        }catch(IOException ex){
//            System.err.println("Blob Error: "  + ex.getMessage());
//        }
//            
	
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
           DefaultTableModel modelz =  (DefaultTableModel)jTable.getModel() ;
        int selecIndex = jTable.getSelectedRow();
        
       //JButton button = new JButton((Icon) jButton5);
        //String button = jButton5.getActionCommand();
        jTextField1.setText(modelz.getValueAt(selecIndex, 1).toString() );
        
       //button.setAction(modelz.getValueAt(selecIndex, 1).toString() );
       
      // JOptionPane.showMessageDialog(this, button);
        
       // students.setSelectedItem(modelz.getValueAt(selecIndex, 0).toString() );
       
//  
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
         try {

        

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("SELECT *FROM insertfilesample2");
                 //ps.executeUpdate();
        
        rs = ps.executeQuery();
        
        
             while (rs.next()) 
             
             {                 
             
                 System.out.println("Following flies are downloaded from database..");
                 
                 
                                int fileId = rs.getInt("id");
				String fileName = rs.getString("file_name");
				long fileSizeInKb = rs.getLong("file_size_in_kb"); // edit ni
				String fileExtension = rs.getString("file_extension"); // edit ni
				System.out.println("File Id:"+fileId);
				System.out.println("File Name:"+fileName);
				System.out.println("File Size In KB:"+fileSizeInKb);
				System.out.println("File Extension:"+fileExtension);
				
				Blob blob = (Blob) rs.getBlob("file_content");
				InputStream inputStream = blob.getBinaryStream();
				
				System.out.println("-----------------------------------");
				Files.copy(inputStream, Paths.get("C:\\Users\\GOD\\Desktop\\DownLoadFiles"+fileName));
                 
                 
                 
                 
             }
        
        
        
         table_update();
                    JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");
        
        }
         catch (Exception e) {
                     JOptionPane.showMessageDialog(this, e,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, e);
        
        }
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

//        
//		JFileChooser jfchoose = new JFileChooser();
//                jfchoose.showOpenDialog(this);
//        
//        
//        try {
//            
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
//                PreparedStatement ps;
//                ps=Mycon.prepareStatement("INSERT INTO insertfilesample2 (file_name,file_size_in_kb,file_extension,file_content)VALUES(?,?,?,?)");
//                
//             File dir = jfchoose.getSelectedFile();
//             Stream<Path> list = Files.list(dir.toPath());
//             
//                        /*
//			 *Below line belongs to JDK 1.8 API so make sure you are running this code on JDK 1.8.
//			 *And you IDE pointing to compiler version 1.8
//			 */
//                        List<Path> pathList = list.collect(Collectors.toList());
//                        
//			System.out.println("Following files are saved in database..");
//                        
//                       // JOptionPane.showMessageDialog(this, "Following files are saved in database..");
//                        
//                        
//                        
//			for (Path path : pathList) {
//				
//                                JOptionPane.showMessageDialog(this, path.getFileName());
//                                
//                                
//                               // File files =jfchoose.getSelectedFile() ;
//                               // jTextField1.setText(files.getAbsolutePath());
//				File files = path.toFile();
//				String fileName = files.getName();
//				long fileLength = files.length();
//				long fileLengthInKb=fileLength/1024;
//				
//				ps.setString(1, fileName);
//				ps.setLong(2, fileLengthInKb);
//				
//				ps.setString(3, fileName.substring(fileName.lastIndexOf(".")+1));
//				
//				FileInputStream fis = new FileInputStream(files);
//				ps.setBinaryStream(4, fis, fileLength);
//				
//				ps.addBatch();
//			}
//			
//                        
//                        
//                        JOptionPane.showMessageDialog(this, "----------------------------------------");
//			int[] executeBatch = ps.executeBatch();
//			for (int i : executeBatch) {
//				System.out.println(i);
//			}
//            
//            
//            
//        } catch (Exception e) {
//        }
//        
//		       
//				 
			
			
		
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

		
		try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("INSERT INTO insertfilesample2 (file_name,file_size_in_kb,file_extension,file_content)VALUES(?,?,?,?)");

                                File filed = null;
                                filed = new File (path);
                                
                                System.out.println("Following files are saved in database..");                 		
				System.out.println(filed.getName());

				String fileName = filed.getName();
                                
				long fileLength =filed.length();
                                
				long fileLengthInKb=fileLength/1024;
				
				ps.setString(1, fileName);                               
				ps.setLong(2, fileLengthInKb);				
				ps.setString(3, fileName.substring(fileName.lastIndexOf(".")+1));
				
				FileInputStream fis = new FileInputStream(filed);
				ps.setBinaryStream(4, fis, fileLength);

                                ps.execute();
                                table_update2();
                                
                                JOptionPane.showMessageDialog(this, "Successfully Save","Save",JOptionPane.WARNING_MESSAGE);     
                                
			System.out.println("----------------------------------------");
                        System.out.println("");
                        
                        
//			int executeUpdate = ps.executeUpdate();
//			for (int i : executeUpdate) {
//				System.out.println(i);
//			}
		} catch (IOException e) {
			e.printStackTrace();
                        JOptionPane.showMessageDialog(this, e,"ERROR",  JOptionPane.ERROR_MESSAGE);
		} catch (SQLException ex) {
                     JOptionPane.showMessageDialog(this, ex,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                     JOptionPane.showMessageDialog(this, ex,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
	
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    
  
    
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       
        
      
		try{
                    
                    
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("SELECT *FROM insertfilesample2");
                 //ps.executeUpdate();
        
                rs = ps.executeQuery();
                    
			System.out.println("Following flies are downloaded from database..");
                        
                          
			while (rs.next()) {
                            
                            
				int fileId = rs.getInt("file_id");
				String fileName = rs.getString("file_name");
				long fileSizeInKb = rs.getLong("file_size_in_kb");
				String fileExtension = rs.getString("file_extension");
				System.out.println("File Id:"+fileId);
				System.out.println("File Name:"+fileName);
				System.out.println("File Size In KB:"+fileSizeInKb);
				System.out.println("File Extension:"+fileExtension);
				
				Blob blob = (Blob) rs.getBlob("file_content");
				InputStream inputStream = blob.getBinaryStream();
				
				System.out.println("-----------------------------------");
				//Files.copy(inputStream, Paths.get("dynamicDownloadPath()"+fileName));
                                Files.copy(inputStream, Paths.get("C:\\Users\\GOD\\Desktop\\Downloads\\DownLoadFiles/"+fileName));
                               // Files.copy(inputStream, Paths.get("DownLoadFiles/"+fileName));
                             
                                
                                
			}
		} catch (IOException e) {
		} catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
	
    }//GEN-LAST:event_jButton9ActionPerformed

    private void download2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_download2ActionPerformed
       
        
        DefaultTableModel model2 =  (DefaultTableModel)jTable1.getModel() ;
         int selecIndex = jTable1.getSelectedRow();
         int row = jTable1.getSelectedRow();
         int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
         String tc = jTable1.getModel().getValueAt(row, 0).toString();
         
         
         
         
            try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
            PreparedStatement ps;
            //select profileImage from tbl_welcome where id = 1117
           // ps=Mycon.prepareStatement("SELECT * from insertfilesample2 where file_id=?, file_name=?, file_size_in_kb=?, file_extension=?, file_content=? ");
            ps=Mycon.prepareStatement("SELECT * from insertfilesample2 where  file_id="+tc+" ");
            //ps.setInt(1, id);
               
               // ps.execute();
                
                 rs = ps.executeQuery();
                    
			System.out.println("Following flies are downloaded from database..");
                        
                          
			while (rs.next()) {
                            
                            
				int fileId = rs.getInt("file_id");
				String fileName = rs.getString("file_name");
				long fileSizeInKb = rs.getLong("file_size_in_kb");
				String fileExtension = rs.getString("file_extension");
				System.out.println("File Id:"+fileId);
				System.out.println("File Name:"+fileName);
				System.out.println("File Size In KB:"+fileSizeInKb);
				System.out.println("File Extension:"+fileExtension);
				
				Blob blob = (Blob) rs.getBlob("file_content");
				InputStream inputStream = blob.getBinaryStream();
				
				System.out.println("-----------------------------------");
				
                                //Files.copy(inputStream, Paths.get("C:\\Users\\GOD\\Desktop\\Downloads\\DownLoadFiles/"+fileName));
                       
                              
                                       String home = System.getProperty("user.home");
                                        File filed = new File(home+"/Downloads/" + fileName); 
                                        
                                         Files.copy(inputStream, Paths.get(filed + fileName));
			}

                table_update2();
                JOptionPane.showMessageDialog(this, "Successfully Download","Save",JOptionPane.WARNING_MESSAGE);
                  
            
        }catch (ClassNotFoundException | SQLException  ex) {
                        Logger.getLogger(Edit_Students_Info.class.getName()).log(Level.SEVERE, null, ex);
        }    catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Already Downloaded");
                 Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
             }
 
         
         
//            int dialogResult = JOptionPane.showConfirmDialog(null, "Do You Want to Download File...?","Warning",JOptionPane.YES_NO_OPTION);
//         
//         if (dialogResult == JOptionPane.YES_OPTION) 
//         
//         {
//             if (id > 1) {
//                 
//                 
//               
//                 
//             }
//              
//        } else {
//             
//             JOptionPane.showMessageDialog(null, "Then please Proceed");
//             
//        }
    }//GEN-LAST:event_download2ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

           DefaultTableModel model2 =  (DefaultTableModel)jTable1.getModel() ;
         int selecIndex = jTable1.getSelectedRow();
         int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
         
         
         
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record","Warning",JOptionPane.YES_NO_OPTION);
         
         if (dialogResult == JOptionPane.YES_OPTION) 
         
         {
            
               try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
            PreparedStatement ps;
            ps=Mycon.prepareStatement("delete from insertfilesample2 where file_id=?");
            ps.setInt(1, id);
               
                ps.execute();
                table_update2();
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                  
            
        }catch (ClassNotFoundException | SQLException  ex) {
                        Logger.getLogger(Edit_Students_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        } else {
             
             JOptionPane.showMessageDialog(null, "Then please Proceed");
             
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    }//GEN-LAST:event_jButton10ActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed

        
        
                JFileChooser jfchoose = new JFileChooser();
                jfchoose.showOpenDialog(this);
                
                try {
            
                       File file = jfchoose.getSelectedFile();
                       path = file.getAbsoluteFile().toString();
                      jTextField1.setText(file.getAbsolutePath());
                    
                    
        } catch (Exception e) {
        }
    }//GEN-LAST:event_browseActionPerformed

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
            java.util.logging.Logger.getLogger(Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JButton delete;
    private javax.swing.JButton download2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton open;
    // End of variables declaration//GEN-END:variables
}
