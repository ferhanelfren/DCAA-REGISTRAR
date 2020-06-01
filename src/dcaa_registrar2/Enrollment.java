/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GOD
 */
public class Enrollment extends javax.swing.JFrame {

    /**
     * Creates new form Enrollment
     */
    public Enrollment() {
        initComponents();
      //  studentname();
        //schoolyear2();
         sectionname();
         StudentTable();
          tableEditFormat();
          table_update();
          registrar();
        ButtonGroup bg = new ButtonGroup();
        bg.add(He);
        bg.add(She);
         
         
      //   lRn();
        // tRack();
        // gRade();
    }

    
      public class student
            
    {
        
        
        int id;
        
        String name;
        
        
        public student (int id, String name)
        {
            
            this.id = id;
            this.name= name;
            
            
        }

        @Override
        public String toString()
        {
            
            return name;
            
        } 
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
           @Override
           public String toString ()
           {   
               return name;  
            }
       }
     
     public class Section 
       {
           int id;
           String name;
           public Section (int id, String name)
           {     
               this.id=id;
               this.name=name;     
           }
           @Override
           public String toString ()
           {   
               return name;  
            }
       }
     
      public class Lrn 
       {
           int id;
           String name;
           public Lrn (int id, String name)
           {     
               this.id=id;
               this.name=name;     
           }
           @Override
           public String toString ()
           {   
               return name;  
            }
       }
      
      public class Gradelevels 
       {
           int id;
           String name;
           public Gradelevels (int id, String name)
           {     
               this.id=id;
               this.name=name;     
           }
           @Override
           public String toString ()
           {   
               return name;  
            }
       }
      
      public class Trackenrolled 
       {
           int id;
           String name;
           public Trackenrolled (int id, String name)
           {     
               this.id=id;
               this.name=name;     
           }
           @Override
           public String toString ()
           {   
               return name;  
            }
       }
      
      
      public class Registrar 
       {
           int id;
           String name;
           public Registrar (int id, String name)
           {     
               this.id=id;
               this.name=name;     
           }
           @Override
           public String toString ()
           {   
               return name;  
            }
       }
      
      
       public class President 
       {
           int id;
           String name;
           public President (int id, String name)
           {     
               this.id=id;
               this.name=name;     
           }
           @Override
           public String toString ()
           {   
               return name;  
            }
       }
      
      
    
    Connection Mycon;
    ResultSet rs;
    
    
      private void StudentTable()
    
    {
        
        int c;
           try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from enrolled_students");
                rs= ps.executeQuery();
                
                DefaultTableModel modelt = (DefaultTableModel)jTable.getModel();
                ResultSetMetaData rsd=rs.getMetaData();
                   c = rsd.getColumnCount(); 
                
                     modelt.setRowCount(0);

                
                                    while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         //v.add(rs.getString("id")); 
                                                           
                                                        v.add(new student(rs.getInt(1), rs.getString(6)));
                                                    }
                                                    
                                                    modelt.addRow(v); 
                                                   
                                                }        
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }

    }
    
      
        
      
      
       private void table_update()
    {
               int c;              
                                            try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select a.id, s.school_year_name, a.lrnStatus, a.student_account_no, a.lrnNumber, a.fullname, a.bdate, a.sex, a.age, a.ip, a.ip_status, a.mother_tongue, a.address, a.zip_code, a.fathername, a.mothername, a.guardianname, a.telephone, a.cellphone, a.last_grade_level_completed, a.last_school_year_completed, a.school_name, a.school_id, a.school_address, a.semester, a.track, a.strand, a.grade_level, a.enrolled_track from enrolled_students a, school_year s  where a.school_year_id = s.id ");
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
                                                          v.add(rs.getString("school_year_name"));
                                                          v.add(rs.getString("lrnStatus")); 
                                                           v.add(rs.getString("student_account_no")); 
                                                            v.add(rs.getString("lrnNumber")); 
                                                             v.add(rs.getString("fullname")); 
                                                                 v.add(rs.getString("bdate"));
                                                                  v.add(rs.getString("sex"));
                                                                   v.add(rs.getString("age")); 
                                                                    v.add(rs.getString("ip")); 
                                                                     v.add(rs.getString("ip_status"));
                                                                      v.add(rs.getString("mother_tongue")); 
                                                                       v.add(rs.getString("address"));
                                                                        v.add(rs.getString("zip_code"));
                                                                        v.add(rs.getString("fathername"));
                                                                        v.add(rs.getString("mothername"));
                                                                        v.add(rs.getString("guardianname"));
                                                                        v.add(rs.getString("telephone"));
                                                                        v.add(rs.getString("cellphone"));
                                                                       v.add(rs.getString("last_grade_level_completed"));
                                                                                    v.add(rs.getString("last_school_year_completed")); 
                                                                                    v.add(rs.getString("school_name")); 
                                                                                     v.add(rs.getString("school_id"));
                                                                                     v.add(rs.getString("school_address")); 
                                                                                       v.add(rs.getString("semester")); 
                                                                                        v.add(rs.getString("track")); 
                                                                                         v.add(rs.getString("strand")); 
                                                                                         v.add(rs.getString("grade_level"));
                                                                                          v.add(rs.getString("enrolled_track")); 
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
    }
       
       
         private void tableEditFormat()
       {
           
            
                                                jTable.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,16));
                                                jTable.getTableHeader().setOpaque(false);
                                                jTable.getTableHeader().setBackground(new Color(165,19,29));
                                                jTable.getTableHeader().setForeground(new Color(255,255,255));
                                                jTable.getRowHeight(20);
                                                

                                                DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)  jTable.getTableHeader().getDefaultRenderer();
                                                renderer.setHorizontalAlignment(SwingConstants.CENTER);
//                                                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//                                                rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
//                                                jTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);

                                                jTable.removeColumn(jTable.getColumnModel().getColumn(1));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(1));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(1));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(1));
                                                 jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                jTable.removeColumn(jTable.getColumnModel().getColumn(2));
                                                
                                               //  jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                 jTable.getColumnModel().getColumn(1).setPreferredWidth(300);
                                                 
                                                 
                                                 TableColumn col = jTable.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
                                                    dtcr.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col.setCellRenderer(dtcr);
                                                 
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
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        csy = new javax.swing.JFormattedTextField();
        psy = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        sectioNs = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        LRN = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        SCHOOLYEARS = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        NAME = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        GRADES = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        He = new javax.swing.JCheckBox();
        She = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        TRACK = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        registrar = new javax.swing.JComboBox();
        position2 = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pres = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        vpresident = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        position3 = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        position4 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        CLEAR = new javax.swing.JButton();
        PRINT = new javax.swing.JButton();
        CLEAR2 = new javax.swing.JButton();
        SAVE = new javax.swing.JButton();
        CLEAR4 = new javax.swing.JButton();
        CLEAR5 = new javax.swing.JButton();
        CLEAR6 = new javax.swing.JButton();
        CLEAR7 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 241, 233));

        jPanel5.setBackground(new java.awt.Color(43, 70, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Rights Reserved 2020");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(244, 241, 233));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(56, 74, 19));
        jLabel23.setText("Coming School Year:");

        csy.setBackground(new java.awt.Color(255, 255, 255));
        csy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));
        csy.setColumns(12);
        csy.setForeground(new java.awt.Color(0, 0, 0));
        try {
            csy.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        csy.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        csy.setCaretColor(new java.awt.Color(102, 0, 0));
        csy.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        csy.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        csy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                csyKeyTyped(evt);
            }
        });

        psy.setBackground(new java.awt.Color(255, 255, 255));
        psy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));
        psy.setColumns(12);
        psy.setForeground(new java.awt.Color(0, 0, 0));
        try {
            psy.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        psy.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        psy.setCaretColor(new java.awt.Color(102, 0, 0));
        psy.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        psy.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        psy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                psyKeyTyped(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(56, 74, 19));
        jLabel18.setText("Present School Year :");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(56, 74, 19));
        jLabel20.setText("LRN :");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(56, 74, 19));
        jLabel17.setText("Student's Name :");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(56, 74, 19));
        jLabel21.setText("Grade Level :");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(56, 74, 19));
        jLabel19.setText("Section :");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(56, 74, 19));
        jLabel22.setText("Enrolled Track :");

        sectioNs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(244, 241, 233));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        LRN.setBackground(new java.awt.Color(244, 241, 233));
        LRN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LRN.setForeground(new java.awt.Color(51, 51, 51));
        LRN.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LRN, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LRN, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel8.setBackground(new java.awt.Color(244, 241, 233));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        SCHOOLYEARS.setBackground(new java.awt.Color(244, 241, 233));
        SCHOOLYEARS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SCHOOLYEARS.setForeground(new java.awt.Color(51, 51, 51));
        SCHOOLYEARS.setBorder(null);
        SCHOOLYEARS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SCHOOLYEARSKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(SCHOOLYEARS, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(SCHOOLYEARS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(244, 241, 233));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        NAME.setBackground(new java.awt.Color(244, 241, 233));
        NAME.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NAME.setForeground(new java.awt.Color(51, 51, 51));
        NAME.setBorder(null);
        NAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NAMEKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NAME, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(244, 241, 233));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        GRADES.setBackground(new java.awt.Color(244, 241, 233));
        GRADES.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GRADES.setForeground(new java.awt.Color(51, 51, 51));
        GRADES.setBorder(null);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(GRADES, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GRADES, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 51, 51));
        jLabel35.setText("Gender :");

        He.setBackground(new java.awt.Color(244, 241, 233));
        He.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        He.setForeground(new java.awt.Color(43, 70, 60));
        He.setText("Male");
        He.setBorder(null);
        He.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        He.setInheritsPopupMenu(true);
        He.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeActionPerformed(evt);
            }
        });

        She.setBackground(new java.awt.Color(244, 241, 233));
        She.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        She.setForeground(new java.awt.Color(43, 70, 60));
        She.setText("Female");
        She.setBorder(null);
        She.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        She.setInheritsPopupMenu(true);
        She.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SheActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(56, 74, 19));
        jLabel30.setText("School Year :");

        jPanel11.setBackground(new java.awt.Color(244, 241, 233));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        TRACK.setBackground(new java.awt.Color(244, 241, 233));
        TRACK.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TRACK.setForeground(new java.awt.Color(51, 51, 51));
        TRACK.setBorder(null);
        TRACK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TRACKKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(TRACK, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(244, 241, 233));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To be Sign by :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 1, 22), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(56, 74, 19));
        jLabel24.setText("Registrar In-Charge :");

        registrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        position2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(56, 74, 19));
        jLabel27.setText("Position :");

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(56, 74, 19));
        jLabel26.setText("School President :");

        pres.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(56, 74, 19));
        jLabel28.setText("School Vice President :");

        vpresident.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(56, 74, 19));
        jLabel29.setText("Position :");

        position3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(56, 74, 19));
        jLabel31.setText("Position :");

        position4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel28))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registrar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vpresident, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(position2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(position3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(position4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(position4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(position2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(position3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vpresident, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(6, 6, 6)
                .addComponent(psy, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csy, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(9, 9, 9)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sectioNs, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(77, 77, 77)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(104, 104, 104)
                                                .addComponent(She))
                                            .addComponent(He)))))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(He, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(She, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sectioNs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jPanel4.setBackground(new java.awt.Color(244, 241, 233));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

        CLEAR.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/default.png"))); // NOI18N
        CLEAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR.setFocusPainted(false);
        CLEAR.setRolloverEnabled(true);
        CLEAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/hover.png"))); // NOI18N
        CLEAR.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/hover.png"))); // NOI18N
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });

        PRINT.setBackground(new java.awt.Color(51, 51, 51));
        PRINT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Print/default.png"))); // NOI18N
        PRINT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        PRINT.setFocusPainted(false);
        PRINT.setRolloverEnabled(true);
        PRINT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Print/hover.png"))); // NOI18N
        PRINT.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Print/hover.png"))); // NOI18N
        PRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTActionPerformed(evt);
            }
        });

        CLEAR2.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD RECORD/default.png"))); // NOI18N
        CLEAR2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR2.setFocusPainted(false);
        CLEAR2.setRolloverEnabled(true);
        CLEAR2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD RECORD/hover.png"))); // NOI18N
        CLEAR2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD RECORD/hover.png"))); // NOI18N
        CLEAR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR2ActionPerformed(evt);
            }
        });

        SAVE.setBackground(new java.awt.Color(51, 51, 51));
        SAVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/default.png"))); // NOI18N
        SAVE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        SAVE.setFocusPainted(false);
        SAVE.setRolloverEnabled(true);
        SAVE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        SAVE.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEActionPerformed(evt);
            }
        });

        CLEAR4.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/default.png"))); // NOI18N
        CLEAR4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR4.setFocusPainted(false);
        CLEAR4.setRolloverEnabled(true);
        CLEAR4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/hover.png"))); // NOI18N
        CLEAR4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/hover.png"))); // NOI18N
        CLEAR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR4ActionPerformed(evt);
            }
        });

        CLEAR5.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/default.png"))); // NOI18N
        CLEAR5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR5.setFocusPainted(false);
        CLEAR5.setRolloverEnabled(true);
        CLEAR5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/hover.png"))); // NOI18N
        CLEAR5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/hover.png"))); // NOI18N
        CLEAR5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR5ActionPerformed(evt);
            }
        });

        CLEAR6.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/default.png"))); // NOI18N
        CLEAR6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR6.setFocusPainted(false);
        CLEAR6.setRolloverEnabled(true);
        CLEAR6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/hover.png"))); // NOI18N
        CLEAR6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/hover.png"))); // NOI18N
        CLEAR6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR6ActionPerformed(evt);
            }
        });

        CLEAR7.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/EDIT/default.png"))); // NOI18N
        CLEAR7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR7.setFocusPainted(false);
        CLEAR7.setRolloverEnabled(true);
        CLEAR7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/EDIT/hover.png"))); // NOI18N
        CLEAR7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/EDIT/hover.png"))); // NOI18N
        CLEAR7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CLEAR7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SAVE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PRINT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR)
                .addGap(48, 48, 48))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CLEAR7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRINT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(43, 70, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/loh.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DIGOS   CENTRAL   ADVENTIST   ACADEMY,   INC.");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lapu  -  Lapu  Ext.,  Digos  City,   Davao   del   Sur,   Pphilippines");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable.setAutoCreateRowSorter(true);
        jTable.setBackground(new java.awt.Color(244, 241, 233));
        jTable.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "School Year", "Lrn Status", "S.A  No.", "LRN No.", "Student Name", "Birth Date", "Gender", "Age", "Indigent People", "Tribe", "Mother Tongue", "Address", "Zip Code", "Father's Name", "Mother's Name", "Guardian's Name", "Tell No.", "Cell No.", "Last Grade Level Completed", "Last School Year Completed", "School Name", "School Id", "School Address", "Semester", "Track", "Strand", "Grade Level", "Track & Strand"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setFocusable(false);
        jTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable.setOpaque(false);
        jTable.setRequestFocusEnabled(false);
        jTable.setRowHeight(50);
        jTable.setSelectionBackground(new java.awt.Color(43, 70, 60));
        jTable.setSelectionForeground(new java.awt.Color(244, 241, 233));
        jTable.setShowVerticalLines(false);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setText("Search Here. . . .");
        search.setBorder(null);
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(389, 389, 389))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void psyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_psyKeyTyped

    private void csyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_csyKeyTyped

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed

//        SCHOOLYEAR.setText("empty");
//        LRN_STATUS.setText("empty");
//        STUDENT_ACCOUNT.setText("empty");
//        LRN.setText("empty");
//        STUDENT_NAME.setText("empty");
//        BDATE.setText("empty");
//        AGE.setText("empty");
//        GENDER.setText("empty");
//        IP.setText("empty");
//        IP_STATUS.setText("empty");
//        MOTHER_TONGUE.setText("empty");
//        ADDRESS.setText("empty");
//        ZIPCODE.setText("empty");
//        FATHER.setText("empty");
//        MOTHER.setText("empty");
//        GUARDIAN.setText("empty");
//        CELPHONE.setText("empty");
//        TELEPHONE.setText("empty");
//        LAST_GRADE_LEVEL.setText("empty");
//        LAST_SCHOOL_YEAR.setText("empty");
//        SCHOOL_NAME.setText("empty");
//        SCHOOL_ID.setText("empty");
//        SCHOOL_ADDRESS.setText("empty");
//        SEMESTER.setText("empty");
//        TRACK.setText("empty");
//        STRAND.setText("empty");
//        GRADE_LEVEL.setText("empty");
//        ENROLLED_TRACK.setText("empty");

    }//GEN-LAST:event_CLEARActionPerformed

    
    
    
    
    
    
    private void PRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTActionPerformed
           
        
    }//GEN-LAST:event_PRINTActionPerformed

    private void CLEAR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLEAR2ActionPerformed

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
      
//        SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
//         student st= ( student)student_name.getSelectedItem();
//         Section sc = (Section)sectioNs.getSelectedItem();
        
         DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);
        
         try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                 Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("INSERT INTO certificate_of_enrollment (school_year_id, enrolled_students_id, sections_id, timestamp) VALUES (?,?,?,?)");
                
//                ps.setInt(1, sy.id);
//                ps.setInt(2, st.id);
//                ps.setInt(3, sc.id);
                ps.setString(4, timestamp);
                
                ps.execute();
                
                JOptionPane.showMessageDialog(this, "Successful");
                
                
                
                
            }catch (ClassNotFoundException | SQLException  ex) {
                  //JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
                   Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_SAVEActionPerformed

    private void CLEAR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR4ActionPerformed
         try {
               
             
                 
               
                Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               JasperDesign jdesign = JRXmlLoader.load("D:\\USERSsdasda\\Documents\\NetBeansProjects\\DCAA_REGISTRAR2\\src\\report_records\\enrollment_shs.jrxml");
               String query="select * from certificate_of_enrollment"; 

               JRDesignQuery updateQuery = new JRDesignQuery();
               updateQuery.setText(query);
             
               jdesign.setQuery(updateQuery);
               
               
               
                HashMap<String,Object> para = new HashMap<>();
                para.put("sy",psy.getText() );
                para.put("future sy",csy.getText() ); // 
                para.put("lrn",LRN.getText());
                para.put("name",NAME.getText());
                para.put("grade", GRADES.getText());
                para.put("section",sectioNs.getSelectedItem().toString());
                para.put("trak", SCHOOLYEARS.getText());
                para.put("schoolregistrar", registrar.getSelectedItem().toString());
                 
                
                //jTextField1
               
               JasperReport jreport = JasperCompileManager.compileReport(jdesign);
               JasperPrint jprint =JasperFillManager.fillReport(jreport, para, Mycon);
               
               JasperViewer.viewReport(jprint);
          
            }catch (ClassNotFoundException | SQLException  ex) {
                 JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (JRException ex) {         
            Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }//GEN-LAST:event_CLEAR4ActionPerformed

    private void CLEAR5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLEAR5ActionPerformed

    private void NAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NAMEKeyReleased

       int position = NAME.getCaretPosition();
       NAME.setText(NAME.getText().toUpperCase());
       NAME.setCaretPosition(position);
    }//GEN-LAST:event_NAMEKeyReleased

    private void SCHOOLYEARSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SCHOOLYEARSKeyReleased
        int position = SCHOOLYEARS.getCaretPosition();
       SCHOOLYEARS.setText(SCHOOLYEARS.getText().toUpperCase());
       SCHOOLYEARS.setCaretPosition(position);
    }//GEN-LAST:event_SCHOOLYEARSKeyReleased

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked

        DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
        int selecIndex = jTable.getSelectedRow();
      

        SCHOOLYEARS.setText(model2.getValueAt(selecIndex, 1).toString());
        LRN.setText(model2.getValueAt(selecIndex, 4).toString());
        NAME.setText(model2.getValueAt(selecIndex, 5).toString());
        
         if (model2.getValueAt(selecIndex, 7).toString().equals("Male")) {
            He.setSelected(true);
            She.setSelected(false);
        }else {
            She.setSelected(true);
            He.setSelected(false);
        }
        
        
        GRADES.setText(model2.getValueAt(selecIndex, 27).toString());
        TRACK.setText(model2.getValueAt(selecIndex, 28).toString());
    }//GEN-LAST:event_jTableMouseClicked

    private void HeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeActionPerformed

    private void SheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SheActionPerformed

    private void TRACKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TRACKKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TRACKKeyReleased

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained

        if( search.getText().trim().equals("Search Here. . . ."))
        {
            search.setText("");
            search.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost

        if(search.getText().trim().equals(""))
        {
            search.setText("Search Here. . . .");
            search.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchFocusLost

    private void CLEAR6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLEAR6ActionPerformed

    private void CLEAR7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLEAR7ActionPerformed

    
    
//     private void schoolyear2()
//        {
//             try {
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
//                PreparedStatement ps;
//                ps=Mycon.prepareStatement("select * from school_year");
//                rs= ps.executeQuery();
//                schoolyr.removeAllItems();
//                while (rs.next())
//                {             
//                     schoolyr.addItem(new SchoolYear2(rs.getInt(1),rs.getString(2)));             
//                }
//            }catch (ClassNotFoundException | SQLException  ex) {
//                  JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
//                  
//            }
//  
//        }
    
    
//    private void studentname()
//        {
//             try {
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
//                PreparedStatement ps;
//                ps=Mycon.prepareStatement("select * from enrolled_students");
//                rs= ps.executeQuery();
//                student_name.removeAllItems();
//                while (rs.next())
//                {             
//                     student_name.addItem(new student(rs.getInt(1),rs.getString(6)));             
//                }
//            }catch (ClassNotFoundException | SQLException  ex) {
//                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
//                 
//                 Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
//            }
//  
//        }
    
      private void sectionname()
        {
             try {

                Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from sections");
                rs= ps.executeQuery();
                sectioNs.removeAllItems();
                while (rs.next())
                {             
                     sectioNs.addItem(new Section(rs.getInt(1),rs.getString(2)));             
                }
            }catch (ClassNotFoundException | SQLException  ex) {
                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
  
        }
      
      
      private void registrar()
        {
             try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from school_registrar_incharge");
                rs= ps.executeQuery();
                registrar.removeAllItems();
                while (rs.next())
                {             
                     registrar.addItem(new Section(rs.getInt(1),rs.getString(2)));             
                }
            }catch (ClassNotFoundException | SQLException  ex) {
                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
  
        }
    
    
    
//     private void lRn()
//        {
//             try {
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
//                PreparedStatement ps;
//                ps=Mycon.prepareStatement("select * from enrolled_students");
//                rs= ps.executeQuery();
//                lrN.removeAllItems();
//                while (rs.next())
//                {             
//                     lrN.addItem(new Lrn(rs.getInt(1),rs.getString(5)));             
//                }
//            }catch (ClassNotFoundException | SQLException  ex) {
//                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
//                 
//                 Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
//            }
//  
//        }
    
//       private void gRade()
//        {
//             try {
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
//                PreparedStatement ps;
//                ps=Mycon.prepareStatement("select * from enrolled_students");
//                rs= ps.executeQuery();
//                gradelevel.removeAllItems();
//                while (rs.next())
//                {             
//                     gradelevel.addItem(new Gradelevels(rs.getInt(1),rs.getString(28)));             
//                }
//            }catch (ClassNotFoundException | SQLException  ex) {
//                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
//                 
//                 Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
//            }
//  
//        }
       
//       private void tRack()
//        {
//             try {
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
//                PreparedStatement ps;
//                ps=Mycon.prepareStatement("select * from enrolled_students");
//                rs= ps.executeQuery();
//                enrolledtrack.removeAllItems();
//                while (rs.next())
//                {             
//                     enrolledtrack.addItem(new Trackenrolled(rs.getInt(1),rs.getString(29)));             
//                }
//            }catch (ClassNotFoundException | SQLException  ex) {
//                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
//                 
//                 Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
//            }
//  
//        }
//    enrollment_shs
    
    
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
            java.util.logging.Logger.getLogger(Enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Enrollment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton CLEAR2;
    private javax.swing.JButton CLEAR4;
    private javax.swing.JButton CLEAR5;
    private javax.swing.JButton CLEAR6;
    private javax.swing.JButton CLEAR7;
    private javax.swing.JTextField GRADES;
    private javax.swing.JCheckBox He;
    private javax.swing.JTextField LRN;
    private javax.swing.JTextField NAME;
    private javax.swing.JButton PRINT;
    private javax.swing.JButton SAVE;
    private javax.swing.JTextField SCHOOLYEARS;
    private javax.swing.JCheckBox She;
    private javax.swing.JTextField TRACK;
    private javax.swing.JFormattedTextField csy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JComboBox position2;
    private javax.swing.JComboBox position3;
    private javax.swing.JComboBox position4;
    private javax.swing.JComboBox pres;
    private javax.swing.JFormattedTextField psy;
    private javax.swing.JComboBox registrar;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox sectioNs;
    private javax.swing.JComboBox vpresident;
    // End of variables declaration//GEN-END:variables
}
