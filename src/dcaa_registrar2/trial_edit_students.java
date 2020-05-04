/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.parser.TokenType.OR;

/**
 *
 * @author GOD
 */
public class trial_edit_students extends javax.swing.JFrame {

    /**
     * Creates new form trial_edit_students
     */
    public trial_edit_students() {
        initComponents();
        table_update();
        tab();
//        LoadSearchData();
      
//        jTable.getTableHeader().setFont(new Font ("Segui UI", Font.BOLD,18));
//        jTable.getTableHeader().setOpaque(false);
//        jTable.getTableHeader().setBackground(new Color(43,70,60) );
//        jTable.getTableHeader().setForeground(new Color(255,255,255));
//        jTable.getRowHeight(30);
        

            jTable.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,18));
            jTable.getTableHeader().setOpaque(false);
            jTable.getTableHeader().setBackground(new Color(165,19,29));
            jTable.getTableHeader().setForeground(new Color(255,255,255));
            jTable.getRowHeight(100);
            
        schoolyear2();
         
       // menu.add(panel);
        
       
        
    }
    
      
    private void tab(){
        
      
      
        
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
    
    
//      public class BrandItem 
//       {
//           
//           int id;
//           String brandname;
//           
//           
//           public BrandItem(int id, String brandname)
//
//           {
//            
//               this.id=id;
//               this.brandname=brandname;
//               
//           }
//           
//           
//           
//           public String toString ()
//            {
//               
//               return brandname;
//               
//               
//            }
//           
//           
//           
//           
//           
//       }

        
    
    
    
    
    
    
    
    
    
    
    

    Connection Mycon;
    ResultSet rs;
   

      private void schoolyear2()
              
             
        {
            
           
              try {

                Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from school_year");
                rs= ps.executeQuery();
                schoolyr.removeAllItems();
                
                
                
                
                while (rs.next())
                
                {
                    
                    
                     schoolyr.addItem(new SchoolYear2(rs.getInt(1),rs.getString(2)));
                    
                }
                

               
            }catch (ClassNotFoundException  ex) {
                Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
            }catch ( SQLException ex) {
                Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
            
        }

    
    
        

    
    
  
    
   
    
  
    
       private void table_update()
    {
                                       
        
                                                                    int c;
                                            
                                            try {
                                                
                                                
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select a.id, s.name, a.lrnStatus, a.student_account_no, a.lrnNumber, a.fullname, a.bdate, a.sex, a.age, a.ip, a.ip_status, a.mother_tongue, a.address, a.zip_code, a.fathername, a.mothername, a.guardianname, a.telephone, a.cellphone, a.last_grade_level_completed, a.last_school_year_completed, a.school_name, a.school_id, a.school_address, a.semester, a.track, a.strand, a.grade_level, a.enrolled_track from enrolled_students a, school_year s  where a.school_year_id = s.id ");
                                           ResultSet rs = ps.executeQuery();
                                            
                                            
                                            ResultSetMetaData rsd=rs.getMetaData();
                                            
                                           c = rsd.getColumnCount();
                                            
                                                DefaultTableModel model =  (DefaultTableModel)jTable.getModel() ;
                                            
                                            
                                          DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                                              rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
                                              jTable.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
                                              
                                                   
                                                   
                                              
                                              
                                            
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(0));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(0));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(0));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(3));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                            jTable.removeColumn(jTable.getColumnModel().getColumn(4));
                                           
                                                
                                             

                                                jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                jTable.getColumnModel().getColumn(1).setPreferredWidth(50);
                                                 jTable.getColumnModel().getColumn(2).setPreferredWidth(150);
                                                jTable.getColumnModel().getColumn(3).setPreferredWidth(9);
                                                 jTable.getColumnModel().getColumn(4).setPreferredWidth(50);
                                             
                                             
                                              
                                             
                                                   


                                                       
                                    
                                                             
                                            
                                            model.setRowCount(0);
                                            
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("id")); 
                                                          v.add(rs.getString("name"));
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
                                        }  catch (ClassNotFoundException  ex) {
                                                Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
                                        }catch ( SQLException ex) {
                                                Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
                                        }
    }
       
       
       
      public boolean verifyText()
    {
        
        if (schoolyr.getSelectedItem().equals("") || LRN.getSelectedItem().toString().equals("") || STUDENT_ACCOUNT.getText().equals("") || LRNNO.getText().equals("") ||  STUDENTNAME.getText().equals("") ||   jDateChooser1.getDate() == null ||  YES_IPSPECIFY.getText().equals("") ||  MOTHERTONGUE.getText().equals("") ||  ADDRESS.getText().equals("") ||  ZIPCODE.getText().equals("") ||  FATHERNAME.getText().equals("") ||  MOTHERNAME.getText().equals("") ||  GUARDIAN.getText().equals("") ||  TELNO.getText().equals("") ||  CELPHONE.getText().equals("") || LEVELCOMPLETED.getSelectedItem().equals("") || SYCOMPLETED.getText().equals("") ||  SCHOOLNAME.getText().equals("") || SCHOOLID.getText().equals("") || SCHOOLADDRESS.getText().equals("") || TRACK.getSelectedItem().equals("") || STRAND.getSelectedItem().equals(""))

        
          {
            
            JOptionPane.showMessageDialog(this," Failed...!!! One or More Empty");
            
            return false;
            
        }else if(jDateChooser1.getDate().compareTo(new Date()) > 0) {
            
            JOptionPane.showMessageDialog(this, "Failed...!!!, Please Check the Year of Birth Date, Present Year is not Allowed");
            
            return false;
            
            
        } else if(jDateChooser1.getDate().compareTo(new Date()) > 0) {
            
            JOptionPane.showMessageDialog(this, "Failed...!!!, Please Check the Year of Birth Date, Present Year is not Allowed");
            
            return false;
            
            
        } else {
            
             return true;
        }
     
     
        
    }
    
       
       
       
       
       
       
        
            public void LoadSearchData(){
         
         
         
    
           try {
               String src="%"+this.search.getText()+"%";
                 
                DefaultTableModel model =  (DefaultTableModel)jTable.getModel() ;
                 int col;
                Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               ps = Mycon.prepareStatement("select * from enrolled_students where fullname or lrnNumber or student_account_no LIKE '"+src+"'" );
           
           
               
               
            
               
               
               
             ResultSet rs= ps.executeQuery();
             
               
           model.setRowCount(0);
                         while(rs.next()){   
                             
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23),rs.getString(24),rs.getString(25),rs.getString(26),rs.getString(27),rs.getString(28),rs.getString(29)});
    
      
    
                                }  
             
            }catch (ClassNotFoundException  ex) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        panel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        schoolyr = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        LRN = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        STUDENT_ACCOUNT = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        LRNNO = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        STUDENTNAME = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        AGE = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        Male = new javax.swing.JCheckBox();
        Female = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        No = new javax.swing.JCheckBox();
        Yes = new javax.swing.JCheckBox();
        jLabel49 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        MOTHERTONGUE = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        YES_IPSPECIFY = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        ADDRESS = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        ZIPCODE = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        FATHERNAME = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        MOTHERNAME = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        GUARDIAN = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        TELNO = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        CELPHONE = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel21 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        LEVELCOMPLETED = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        SYCOMPLETED = new javax.swing.JFormattedTextField();
        jLabel50 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        SCHOOLNAME = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        SCHOOLID = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        SCHOOLADDRESS = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        One = new javax.swing.JCheckBox();
        Two = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        TRACK = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        STRAND = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        GRADE_LEVEL = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        GRADELEVEL = new javax.swing.JTextField();
        TRACK_STRAND = new javax.swing.JLabel();
        TRACK_ENROLLED = new javax.swing.JComboBox();
        ADD = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(233, 240, 192));

        jPanel22.setBackground(new java.awt.Color(202, 219, 183));

        jTable.setAutoCreateRowSorter(true);
        jTable.setBackground(new java.awt.Color(253, 253, 255));
        jTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
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
        jTable.setGridColor(new java.awt.Color(104, 127, 49));
        jTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable.setOpaque(false);
        jTable.setRequestFocusEnabled(false);
        jTable.setRowHeight(50);
        jTable.setSelectionBackground(new java.awt.Color(203, 220, 139));
        jTable.setSelectionForeground(new java.awt.Color(153, 0, 0));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);

        panel.setBackground(new java.awt.Color(0, 0, 255));
        panel.setForeground(new java.awt.Color(153, 0, 0));
        panel.setToolTipText("");
        panel.setAutoscrolls(true);
        panel.setFocusable(false);
        panel.setFont(new java.awt.Font("MS PGothic", 1, 20)); // NOI18N
        panel.setInheritsPopupMenu(true);

        jPanel3.setBackground(new java.awt.Color(253, 253, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getStyle() | java.awt.Font.BOLD, jLabel5.getFont().getSize()+8));
        jLabel5.setForeground(new java.awt.Color(56, 74, 19));
        jLabel5.setText("School Year:");

        schoolyr.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel42.setFont(jLabel42.getFont().deriveFont(jLabel42.getFont().getStyle() | java.awt.Font.BOLD, jLabel42.getFont().getSize()+8));
        jLabel42.setForeground(new java.awt.Color(56, 74, 19));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Please Select below: ");

        LRN.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No LRN", "With LRN", "No LRN - Balik Aral", "With LRN Balik Aral" }));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getStyle() | java.awt.Font.BOLD, jLabel6.getFont().getSize()+8));
        jLabel6.setForeground(new java.awt.Color(56, 74, 19));
        jLabel6.setText("Student Account Number:");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        STUDENT_ACCOUNT.setBackground(new java.awt.Color(255, 255, 255));
        STUDENT_ACCOUNT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STUDENT_ACCOUNT.setForeground(new java.awt.Color(0, 0, 0));
        STUDENT_ACCOUNT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        STUDENT_ACCOUNT.setText("None");
        STUDENT_ACCOUNT.setBorder(null);
        STUDENT_ACCOUNT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                STUDENT_ACCOUNTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                STUDENT_ACCOUNTFocusLost(evt);
            }
        });
        STUDENT_ACCOUNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STUDENT_ACCOUNTActionPerformed(evt);
            }
        });
        STUDENT_ACCOUNT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                STUDENT_ACCOUNTKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(STUDENT_ACCOUNT)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STUDENT_ACCOUNT, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(jLabel25.getFont().deriveFont(jLabel25.getFont().getStyle() | java.awt.Font.BOLD, jLabel25.getFont().getSize()+8));
        jLabel25.setForeground(new java.awt.Color(56, 74, 19));
        jLabel25.setText("Learner's Reference No. (LRN):  ");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        LRNNO.setBackground(new java.awt.Color(255, 255, 255));
        LRNNO.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LRNNO.setForeground(new java.awt.Color(0, 0, 0));
        LRNNO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        LRNNO.setText("None");
        LRNNO.setBorder(null);
        LRNNO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LRNNOFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                LRNNOFocusLost(evt);
            }
        });
        LRNNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LRNNOActionPerformed(evt);
            }
        });
        LRNNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LRNNOKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LRNNO)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LRNNO, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(jLabel15.getFont().deriveFont(jLabel15.getFont().getStyle() | java.awt.Font.BOLD, jLabel15.getFont().getSize()+8));
        jLabel15.setForeground(new java.awt.Color(56, 74, 19));
        jLabel15.setText("Student's Name :");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        STUDENTNAME.setBackground(new java.awt.Color(255, 255, 255));
        STUDENTNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STUDENTNAME.setForeground(new java.awt.Color(0, 0, 0));
        STUDENTNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        STUDENTNAME.setText("Last Name,  First Name   Middle Name");
        STUDENTNAME.setBorder(null);
        STUDENTNAME.setMargin(new java.awt.Insets(1, 1, 1, 1));
        STUDENTNAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                STUDENTNAMEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                STUDENTNAMEFocusLost(evt);
            }
        });
        STUDENTNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                STUDENTNAMEKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(STUDENTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STUDENTNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(jLabel43.getFont().deriveFont(jLabel43.getFont().getStyle() | java.awt.Font.BOLD, jLabel43.getFont().getSize()+8));
        jLabel43.setForeground(new java.awt.Color(56, 74, 19));
        jLabel43.setText("Date of Birth:");

        jDateChooser1.setBackground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setForeground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(jLabel21.getFont().deriveFont(jLabel21.getFont().getStyle() | java.awt.Font.BOLD, jLabel21.getFont().getSize()+8));
        jLabel21.setForeground(new java.awt.Color(56, 74, 19));
        jLabel21.setText("Age:");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        AGE.setBackground(new java.awt.Color(255, 255, 255));
        AGE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AGE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AGE.setBorder(null);
        AGE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AGEKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AGE, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AGE, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(jLabel35.getFont().deriveFont(jLabel35.getFont().getStyle() | java.awt.Font.BOLD, jLabel35.getFont().getSize()+8));
        jLabel35.setForeground(new java.awt.Color(56, 74, 19));
        jLabel35.setText("Gender :");

        Male.setBackground(new java.awt.Color(253, 253, 255));
        Male.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        Male.setForeground(new java.awt.Color(43, 70, 60));
        Male.setText("Male");
        Male.setBorder(null);
        Male.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Male.setInheritsPopupMenu(true);
        Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleActionPerformed(evt);
            }
        });

        Female.setBackground(new java.awt.Color(253, 253, 255));
        Female.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        Female.setForeground(new java.awt.Color(43, 70, 60));
        Female.setText("Female");
        Female.setBorder(null);
        Female.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Female.setInheritsPopupMenu(true);
        Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(jLabel17.getFont().deriveFont(jLabel17.getFont().getStyle() | java.awt.Font.BOLD, jLabel17.getFont().getSize()+8));
        jLabel17.setForeground(new java.awt.Color(56, 74, 19));
        jLabel17.setText("Indigenous People (IP) :");

        No.setBackground(new java.awt.Color(253, 253, 255));
        No.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        No.setForeground(new java.awt.Color(43, 70, 60));
        No.setText("No");
        No.setBorder(null);
        No.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        No.setInheritsPopupMenu(true);
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });

        Yes.setBackground(new java.awt.Color(253, 253, 255));
        Yes.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        Yes.setForeground(new java.awt.Color(43, 70, 60));
        Yes.setText("Yes");
        Yes.setBorder(null);
        Yes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Yes.setInheritsPopupMenu(true);
        Yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesActionPerformed(evt);
            }
        });

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(jLabel49.getFont().deriveFont(jLabel49.getFont().getStyle() | java.awt.Font.BOLD, jLabel49.getFont().getSize()+8));
        jLabel49.setForeground(new java.awt.Color(56, 74, 19));
        jLabel49.setText("Mother Tongue:");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        MOTHERTONGUE.setBackground(new java.awt.Color(255, 255, 255));
        MOTHERTONGUE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MOTHERTONGUE.setForeground(new java.awt.Color(0, 0, 0));
        MOTHERTONGUE.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        MOTHERTONGUE.setText("None");
        MOTHERTONGUE.setBorder(null);
        MOTHERTONGUE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MOTHERTONGUEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                MOTHERTONGUEFocusLost(evt);
            }
        });
        MOTHERTONGUE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MOTHERTONGUEKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(MOTHERTONGUE, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MOTHERTONGUE, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        YES_IPSPECIFY.setBackground(new java.awt.Color(255, 255, 255));
        YES_IPSPECIFY.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        YES_IPSPECIFY.setForeground(new java.awt.Color(0, 0, 0));
        YES_IPSPECIFY.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        YES_IPSPECIFY.setText("Please Specify. . .");
        YES_IPSPECIFY.setBorder(null);
        YES_IPSPECIFY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                YES_IPSPECIFYFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                YES_IPSPECIFYFocusLost(evt);
            }
        });
        YES_IPSPECIFY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                YES_IPSPECIFYKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(YES_IPSPECIFY, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(YES_IPSPECIFY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(jLabel18.getFont().deriveFont(jLabel18.getFont().getStyle() | java.awt.Font.BOLD, jLabel18.getFont().getSize()+8));
        jLabel18.setForeground(new java.awt.Color(56, 74, 19));
        jLabel18.setText("If Yes, please specify :");

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(jLabel37.getFont().deriveFont(jLabel37.getFont().getStyle() | java.awt.Font.BOLD, jLabel37.getFont().getSize()+8));
        jLabel37.setForeground(new java.awt.Color(56, 74, 19));
        jLabel37.setText("Address:");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        ADDRESS.setBackground(new java.awt.Color(255, 255, 255));
        ADDRESS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ADDRESS.setForeground(new java.awt.Color(0, 0, 0));
        ADDRESS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ADDRESS.setBorder(null);
        ADDRESS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ADDRESSFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ADDRESSFocusLost(evt);
            }
        });
        ADDRESS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ADDRESSKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(ADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ADDRESS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(jLabel44.getFont().deriveFont(jLabel44.getFont().getStyle() | java.awt.Font.BOLD, jLabel44.getFont().getSize()+8));
        jLabel44.setForeground(new java.awt.Color(56, 74, 19));
        jLabel44.setText("Zip Code:");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        ZIPCODE.setBackground(new java.awt.Color(255, 255, 255));
        ZIPCODE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ZIPCODE.setForeground(new java.awt.Color(0, 0, 0));
        ZIPCODE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ZIPCODE.setText("0000");
        ZIPCODE.setBorder(null);
        ZIPCODE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ZIPCODEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ZIPCODEFocusLost(evt);
            }
        });
        ZIPCODE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ZIPCODEKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ZIPCODE, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZIPCODE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(jLabel36.getFont().deriveFont(jLabel36.getFont().getStyle() | java.awt.Font.BOLD, jLabel36.getFont().getSize()+8));
        jLabel36.setForeground(new java.awt.Color(56, 74, 19));
        jLabel36.setText("Father's Name:");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        FATHERNAME.setBackground(new java.awt.Color(255, 255, 255));
        FATHERNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FATHERNAME.setForeground(new java.awt.Color(0, 0, 0));
        FATHERNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        FATHERNAME.setText("Last Name,  First Name   Middle Name");
        FATHERNAME.setBorder(null);
        FATHERNAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FATHERNAMEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                FATHERNAMEFocusLost(evt);
            }
        });
        FATHERNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FATHERNAMEKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(FATHERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FATHERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(jLabel38.getFont().deriveFont(jLabel38.getFont().getStyle() | java.awt.Font.BOLD, jLabel38.getFont().getSize()+8));
        jLabel38.setForeground(new java.awt.Color(56, 74, 19));
        jLabel38.setText("Mother's Name:");

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        MOTHERNAME.setBackground(new java.awt.Color(255, 255, 255));
        MOTHERNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MOTHERNAME.setForeground(new java.awt.Color(0, 0, 0));
        MOTHERNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        MOTHERNAME.setText("Last Name,  First Name   Middle Name");
        MOTHERNAME.setBorder(null);
        MOTHERNAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MOTHERNAMEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                MOTHERNAMEFocusLost(evt);
            }
        });
        MOTHERNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MOTHERNAMEKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(MOTHERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MOTHERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(jLabel39.getFont().deriveFont(jLabel39.getFont().getStyle() | java.awt.Font.BOLD, jLabel39.getFont().getSize()+8));
        jLabel39.setForeground(new java.awt.Color(56, 74, 19));
        jLabel39.setText("Guardian's Name:");

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        GUARDIAN.setBackground(new java.awt.Color(255, 255, 255));
        GUARDIAN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GUARDIAN.setForeground(new java.awt.Color(0, 0, 0));
        GUARDIAN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        GUARDIAN.setText("Last Name,  First Name   Middle Name");
        GUARDIAN.setBorder(null);
        GUARDIAN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GUARDIANFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                GUARDIANFocusLost(evt);
            }
        });
        GUARDIAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GUARDIANKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(GUARDIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GUARDIAN, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(jLabel45.getFont().deriveFont(jLabel45.getFont().getStyle() | java.awt.Font.BOLD, jLabel45.getFont().getSize()+8));
        jLabel45.setForeground(new java.awt.Color(56, 74, 19));
        jLabel45.setText("Tellephone Number:");

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        TELNO.setBackground(new java.awt.Color(255, 255, 255));
        TELNO.setBorder(null);
        TELNO.setColumns(12);
        TELNO.setForeground(new java.awt.Color(0, 0, 0));
        try {
            TELNO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TELNO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TELNO.setCaretColor(new java.awt.Color(102, 0, 0));
        TELNO.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        TELNO.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TELNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TELNOKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TELNO, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TELNO, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(jLabel46.getFont().deriveFont(jLabel46.getFont().getStyle() | java.awt.Font.BOLD, jLabel46.getFont().getSize()+8));
        jLabel46.setForeground(new java.awt.Color(56, 74, 19));
        jLabel46.setText("Cellphone Number:");

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        CELPHONE.setBackground(new java.awt.Color(255, 255, 255));
        CELPHONE.setBorder(null);
        CELPHONE.setColumns(12);
        CELPHONE.setForeground(new java.awt.Color(0, 0, 0));
        try {
            CELPHONE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### ### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CELPHONE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CELPHONE.setCaretColor(new java.awt.Color(102, 0, 0));
        CELPHONE.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        CELPHONE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CELPHONE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CELPHONEKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CELPHONE, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CELPHONE, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel49)
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel35)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Male)
                                .addGap(28, 28, 28)
                                .addComponent(Female))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(No)
                                .addGap(45, 45, 45)
                                .addComponent(Yes))
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel25)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel42)
                                .addComponent(jLabel5)
                                .addComponent(schoolyr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LRN, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel43)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(79, 79, 79)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addGap(0, 0, 0)
                .addComponent(LRN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Male, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Female, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Yes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        panel.addTab("Students Information", jPanel2);

        jPanel21.setBackground(new java.awt.Color(253, 253, 255));

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(jLabel51.getFont().deriveFont(jLabel51.getFont().getStyle() | java.awt.Font.BOLD, jLabel51.getFont().getSize()+8));
        jLabel51.setForeground(new java.awt.Color(56, 74, 19));
        jLabel51.setText("Last Grade Level Completed:");

        LEVELCOMPLETED.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LEVELCOMPLETED.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(jLabel52.getFont().deriveFont(jLabel52.getFont().getStyle() | java.awt.Font.BOLD, jLabel52.getFont().getSize()+8));
        jLabel52.setForeground(new java.awt.Color(56, 74, 19));
        jLabel52.setText("Last School Year Completed:");

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        SYCOMPLETED.setBackground(new java.awt.Color(255, 255, 255));
        SYCOMPLETED.setBorder(null);
        SYCOMPLETED.setColumns(12);
        SYCOMPLETED.setForeground(new java.awt.Color(0, 0, 0));
        try {
            SYCOMPLETED.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        SYCOMPLETED.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SYCOMPLETED.setCaretColor(new java.awt.Color(102, 0, 0));
        SYCOMPLETED.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        SYCOMPLETED.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SYCOMPLETED.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SYCOMPLETEDKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SYCOMPLETED, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SYCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(jLabel50.getFont().deriveFont(jLabel50.getFont().getStyle() | java.awt.Font.BOLD, jLabel50.getFont().getSize()+8));
        jLabel50.setForeground(new java.awt.Color(56, 74, 19));
        jLabel50.setText("School Name:");

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        SCHOOLNAME.setBackground(new java.awt.Color(255, 255, 255));
        SCHOOLNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SCHOOLNAME.setForeground(new java.awt.Color(0, 0, 0));
        SCHOOLNAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SCHOOLNAME.setText("None");
        SCHOOLNAME.setBorder(null);
        SCHOOLNAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SCHOOLNAMEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SCHOOLNAMEFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(SCHOOLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(jLabel53.getFont().deriveFont(jLabel53.getFont().getStyle() | java.awt.Font.BOLD, jLabel53.getFont().getSize()+8));
        jLabel53.setForeground(new java.awt.Color(56, 74, 19));
        jLabel53.setText("School Id:");

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        SCHOOLID.setBackground(new java.awt.Color(255, 255, 255));
        SCHOOLID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SCHOOLID.setForeground(new java.awt.Color(0, 0, 0));
        SCHOOLID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SCHOOLID.setText("None");
        SCHOOLID.setBorder(null);
        SCHOOLID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SCHOOLIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SCHOOLIDFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(SCHOOLID, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLID, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(jLabel54.getFont().deriveFont(jLabel54.getFont().getStyle() | java.awt.Font.BOLD, jLabel54.getFont().getSize()+8));
        jLabel54.setForeground(new java.awt.Color(56, 74, 19));
        jLabel54.setText("School Address:");

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        SCHOOLADDRESS.setBackground(new java.awt.Color(255, 255, 255));
        SCHOOLADDRESS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SCHOOLADDRESS.setForeground(new java.awt.Color(0, 0, 0));
        SCHOOLADDRESS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SCHOOLADDRESS.setText("None");
        SCHOOLADDRESS.setBorder(null);
        SCHOOLADDRESS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SCHOOLADDRESSFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SCHOOLADDRESSFocusLost(evt);
            }
        });
        SCHOOLADDRESS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SCHOOLADDRESSKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(SCHOOLADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel51)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel53)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LEVELCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(57, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(LEVELCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane2.setViewportView(jPanel21);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        panel.addTab("Balik - Aral / Repeater", jPanel5);

        jPanel27.setBackground(new java.awt.Color(253, 253, 255));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(jLabel41.getFont().deriveFont(jLabel41.getFont().getStyle() | java.awt.Font.BOLD, jLabel41.getFont().getSize()+8));
        jLabel41.setForeground(new java.awt.Color(56, 74, 19));
        jLabel41.setText("Semester:");

        One.setBackground(new java.awt.Color(253, 253, 255));
        One.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        One.setForeground(new java.awt.Color(43, 70, 60));
        One.setText("1'st Semester");
        One.setBorder(null);
        One.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        One.setInheritsPopupMenu(true);
        One.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OneActionPerformed(evt);
            }
        });

        Two.setBackground(new java.awt.Color(253, 253, 255));
        Two.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        Two.setForeground(new java.awt.Color(43, 70, 60));
        Two.setText("2'nd Semester");
        Two.setBorder(null);
        Two.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Two.setInheritsPopupMenu(true);
        Two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwoActionPerformed(evt);
            }
        });

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(jLabel55.getFont().deriveFont(jLabel55.getFont().getStyle() | java.awt.Font.BOLD, jLabel55.getFont().getSize()+8));
        jLabel55.setForeground(new java.awt.Color(56, 74, 19));
        jLabel55.setText("Track:");

        TRACK.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TRACK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ACADEMIC", "TECHNICAL-VOCATIONAL" }));

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(jLabel56.getFont().deriveFont(jLabel56.getFont().getStyle() | java.awt.Font.BOLD, jLabel56.getFont().getSize()+8));
        jLabel56.setForeground(new java.awt.Color(56, 74, 19));
        jLabel56.setText("Strand:");

        STRAND.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        STRAND.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ABM", "GAS", "HUMMS", "CCS", "CSS", "EIM", "FOS", "FBS", "HOUSE KEEPING", "BEAUTY NAILCARE" }));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel41)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addComponent(One)
                            .addGap(77, 77, 77)
                            .addComponent(Two))
                        .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel55)
                        .addComponent(jLabel56)
                        .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(110, Short.MAX_VALUE)))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(jLabel41)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(One, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Two, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(118, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel.addTab("Senior High School", jPanel6);

        jPanel28.setBackground(new java.awt.Color(253, 253, 255));

        GRADE_LEVEL.setBackground(new java.awt.Color(255, 255, 255));
        GRADE_LEVEL.setFont(GRADE_LEVEL.getFont().deriveFont(GRADE_LEVEL.getFont().getStyle() | java.awt.Font.BOLD, GRADE_LEVEL.getFont().getSize()+8));
        GRADE_LEVEL.setForeground(new java.awt.Color(56, 74, 19));
        GRADE_LEVEL.setText("Grade Level :");

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        GRADELEVEL.setBackground(new java.awt.Color(255, 255, 255));
        GRADELEVEL.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GRADELEVEL.setForeground(new java.awt.Color(0, 0, 0));
        GRADELEVEL.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        GRADELEVEL.setText("None");
        GRADELEVEL.setBorder(null);
        GRADELEVEL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GRADELEVELFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                GRADELEVELFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel29Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(GRADELEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GRADELEVEL, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        TRACK_STRAND.setBackground(new java.awt.Color(255, 255, 255));
        TRACK_STRAND.setFont(TRACK_STRAND.getFont().deriveFont(TRACK_STRAND.getFont().getStyle() | java.awt.Font.BOLD, TRACK_STRAND.getFont().getSize()+8));
        TRACK_STRAND.setForeground(new java.awt.Color(56, 74, 19));
        TRACK_STRAND.setText("Track :");

        TRACK_ENROLLED.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TRACK_ENROLLED.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Academic - ABM", "Academic - GAS", "Academic - HUMMS", "Tech Voc - CCS", "Tech Voc - CSS", "Tech Voc - EIM", "Tech Voc - FOS", "Tech Voc - FBS", "Tech Voc - HOUSE KEEPING", "Tech Voc - BEAUTY NAILCARE" }));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TRACK_ENROLLED, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TRACK_STRAND)
                        .addComponent(GRADE_LEVEL))
                    .addContainerGap(115, Short.MAX_VALUE)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(GRADE_LEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51)
                    .addComponent(TRACK_STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(TRACK_ENROLLED, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel.addTab("Grade Enrolled", jPanel7);

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

        UPDATE.setBackground(new java.awt.Color(51, 51, 51));
        UPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/default.png"))); // NOI18N
        UPDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        UPDATE.setFocusPainted(false);
        UPDATE.setRolloverEnabled(true);
        UPDATE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        DELETE.setBackground(new java.awt.Color(51, 51, 51));
        DELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/default.png"))); // NOI18N
        DELETE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        DELETE.setFocusPainted(false);
        DELETE.setRolloverEnabled(true);
        DELETE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N

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

        jPanel4.setBackground(new java.awt.Color(43, 70, 60));

        jPanel30.setBackground(new java.awt.Color(244, 241, 233));

        search.setBackground(new java.awt.Color(244, 241, 233));
        search.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        search.setBorder(null);
        search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search)
        );

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(203, 220, 139));
        jLabel1.setText("Search :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(337, 337, 337))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(ADD)
                        .addGap(18, 18, 18)
                        .addComponent(UPDATE)
                        .addGap(18, 18, 18)
                        .addComponent(DELETE)
                        .addGap(18, 18, 18)
                        .addComponent(CLEAR)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    
    
    
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
        int selecIndex = jTable.getSelectedRow();

  
        schoolyr.setSelectedItem(model2.getValueAt(selecIndex, 1).toString() );
        LRN.setSelectedItem(model2.getValueAt(selecIndex, 2).toString() );
        STUDENT_ACCOUNT.setText(model2.getValueAt(selecIndex, 3).toString());
        LRNNO.setText(model2.getValueAt(selecIndex, 4).toString());
        STUDENTNAME.setText(model2.getValueAt(selecIndex, 5).toString());

        Date bdate;
        try {

            bdate=new SimpleDateFormat("yyyy-MM-dd").parse(model2.getValueAt(selecIndex, 6).toString());
            jDateChooser1.setDate(bdate);

        } catch (ParseException ex) {
            Logger.getLogger(trial_edit_students.class.getName()).log(Level.SEVERE, null, ex);
        }
        //

        //int selecIndex = jTable1.getSelectedRow();

        if (model2.getValueAt(selecIndex, 7).toString().equals("Male")) {

            Male.setSelected(true);
            Female.setSelected(false);
        }else {

            Female.setSelected(true);
            Male.setSelected(false);
        }

        AGE.setText(model2.getValueAt(selecIndex, 8).toString());

        if (model2.getValueAt(selecIndex, 9).toString().equals("No")) {

            No.setSelected(true);
            Yes.setSelected(false);
        }else {

            Yes.setSelected(true);
            No.setSelected(false);
        }

        YES_IPSPECIFY.setText(model2.getValueAt(selecIndex, 10).toString());
        MOTHERTONGUE.setText(model2.getValueAt(selecIndex, 11).toString());
        ADDRESS.setText(model2.getValueAt(selecIndex, 12).toString());
        ZIPCODE.setText(model2.getValueAt(selecIndex, 13).toString());
        FATHERNAME.setText(model2.getValueAt(selecIndex, 14).toString());

        MOTHERNAME.setText(model2.getValueAt(selecIndex, 15).toString());

        GUARDIAN.setText(model2.getValueAt(selecIndex, 16).toString());
        TELNO.setText(model2.getValueAt(selecIndex, 17).toString());
        CELPHONE.setText(model2.getValueAt(selecIndex, 18).toString());
        LEVELCOMPLETED.setSelectedItem(model2.getValueAt(selecIndex, 19).toString() );
        SYCOMPLETED.setText(model2.getValueAt(selecIndex, 20).toString());
        SCHOOLNAME.setText(model2.getValueAt(selecIndex, 21).toString());
        SCHOOLID.setText(model2.getValueAt(selecIndex, 22).toString());
        SCHOOLADDRESS.setText(model2.getValueAt(selecIndex, 23).toString());

        if (model2.getValueAt(selecIndex, 24).toString().equals("First Semester")) {

            One.setSelected(true);
            Two.setSelected(false);
        }else {

            Two.setSelected(true);
            One.setSelected(false);
        }

        TRACK.setSelectedItem(model2.getValueAt(selecIndex, 25).toString() );
        STRAND.setSelectedItem(model2.getValueAt(selecIndex, 26).toString() );
       GRADELEVEL.setText(model2.getValueAt(selecIndex, 27).toString());
       TRACK_ENROLLED.setSelectedItem(model2.getValueAt(selecIndex, 28).toString() );

    }//GEN-LAST:event_jTableMouseClicked

    private void TwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TwoActionPerformed

    private void OneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OneActionPerformed

    private void SCHOOLADDRESSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SCHOOLADDRESSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SCHOOLADDRESSKeyReleased

    private void SCHOOLADDRESSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLADDRESSFocusLost
        if(SCHOOLADDRESS.getText().trim().equals(""))
        {
            SCHOOLADDRESS.setText("None");
            SCHOOLADDRESS.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_SCHOOLADDRESSFocusLost

    private void SCHOOLADDRESSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLADDRESSFocusGained

        if( SCHOOLADDRESS.getText().trim().equals("None"))
        {
            SCHOOLADDRESS.setText("");
            SCHOOLADDRESS.setForeground(Color.black);
        }
    }//GEN-LAST:event_SCHOOLADDRESSFocusGained

    private void SCHOOLIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLIDFocusLost

        if(SCHOOLID.getText().trim().equals(""))
        {
            SCHOOLID.setText("None");
            SCHOOLID.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_SCHOOLIDFocusLost

    private void SCHOOLIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLIDFocusGained

        if( SCHOOLID.getText().trim().equals("None"))
        {
            SCHOOLID.setText("");
            SCHOOLID.setForeground(Color.black);
        }
    }//GEN-LAST:event_SCHOOLIDFocusGained

    private void SCHOOLNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLNAMEFocusLost

        if(SCHOOLNAME.getText().trim().equals(""))
        {
            SCHOOLNAME.setText("None");
            SCHOOLNAME.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_SCHOOLNAMEFocusLost

    private void SCHOOLNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLNAMEFocusGained

        if( SCHOOLNAME.getText().trim().equals("None"))
        {
            SCHOOLNAME.setText("");
            SCHOOLNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_SCHOOLNAMEFocusGained

    private void SYCOMPLETEDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SYCOMPLETEDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SYCOMPLETEDKeyTyped

    private void CELPHONEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CELPHONEKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) ) {

            evt.consume();

        }
    }//GEN-LAST:event_CELPHONEKeyTyped

    private void TELNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TELNOKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TELNOKeyTyped

    private void GUARDIANKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GUARDIANKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_GUARDIANKeyReleased

    private void GUARDIANFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GUARDIANFocusLost
        if(GUARDIAN.getText().trim().equals(""))
        {
            GUARDIAN.setText("Last Name,  First Name   Middle Name");
            GUARDIAN.setForeground( Color.black);
        }
    }//GEN-LAST:event_GUARDIANFocusLost

    private void GUARDIANFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GUARDIANFocusGained
        if(GUARDIAN.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            GUARDIAN.setText("");
            GUARDIAN.setForeground(Color.black);
        }
    }//GEN-LAST:event_GUARDIANFocusGained

    private void MOTHERNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MOTHERNAMEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_MOTHERNAMEKeyReleased

    private void MOTHERNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERNAMEFocusLost
        if ( MOTHERNAME.getText().trim().isEmpty()) {
            MOTHERNAME.setForeground(new Color(51,51,51));
            MOTHERNAME.setText("Last Name,  First Name   Middle Name");
        }
    }//GEN-LAST:event_MOTHERNAMEFocusLost

    private void MOTHERNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERNAMEFocusGained
        if(MOTHERNAME.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            MOTHERNAME.setText("");
            MOTHERNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_MOTHERNAMEFocusGained

    private void FATHERNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FATHERNAMEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FATHERNAMEKeyReleased

    private void FATHERNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FATHERNAMEFocusLost

        if ( FATHERNAME.getText().trim().isEmpty()) {
            FATHERNAME.setForeground(new Color(51,51,51));
            FATHERNAME.setText("Last Name,  First Name   Middle Name");
        }
    }//GEN-LAST:event_FATHERNAMEFocusLost

    private void FATHERNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FATHERNAMEFocusGained

        if(FATHERNAME.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            FATHERNAME.setText("");
            FATHERNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_FATHERNAMEFocusGained

    private void ZIPCODEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZIPCODEKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) ) {

            evt.consume();

        }

        if (ZIPCODE.getText().length() >= 4 ) // limit to 3 characters
        evt.consume();
    }//GEN-LAST:event_ZIPCODEKeyTyped

    private void ZIPCODEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ZIPCODEFocusLost
        if(ZIPCODE.getText().trim().equals(""))
        {
            ZIPCODE.setText("0000");
            ZIPCODE.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_ZIPCODEFocusLost

    private void ZIPCODEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ZIPCODEFocusGained

        if( ZIPCODE.getText().trim().equals("0000"))
        {
            ZIPCODE.setText("");
            ZIPCODE.setForeground(Color.black);
        }
    }//GEN-LAST:event_ZIPCODEFocusGained

    private void ADDRESSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADDRESSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSKeyReleased

    private void ADDRESSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ADDRESSFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSFocusLost

    private void ADDRESSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ADDRESSFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSFocusGained

    private void YES_IPSPECIFYKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_YES_IPSPECIFYKeyReleased

    private void YES_IPSPECIFYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYFocusLost
        if( YES_IPSPECIFY.getText().trim().equals(""))
        {
            YES_IPSPECIFY.setText("Please Specify. . .");
            YES_IPSPECIFY.setForeground( Color.black);
        }
    }//GEN-LAST:event_YES_IPSPECIFYFocusLost

    private void YES_IPSPECIFYFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYFocusGained

        if(  YES_IPSPECIFY.getText().trim().equals("Please Specify. . ."))
        {
            YES_IPSPECIFY.setText("");
            YES_IPSPECIFY.setForeground(Color.black);
        }
    }//GEN-LAST:event_YES_IPSPECIFYFocusGained

    private void MOTHERTONGUEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MOTHERTONGUEKeyReleased

        //        int position = MOTHERTONGUE.getCaretPosition();
        //        MOTHERTONGUE.setText(MOTHERTONGUE.getText().toUpperCase());
        //        MOTHERTONGUE.setCaretPosition(position);
    }//GEN-LAST:event_MOTHERTONGUEKeyReleased

    private void MOTHERTONGUEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERTONGUEFocusLost

        if(MOTHERTONGUE.getText().trim().equals(""))
        {
            MOTHERTONGUE.setText("None");
            MOTHERTONGUE.setForeground( Color.black);
        }
    }//GEN-LAST:event_MOTHERTONGUEFocusLost

    private void MOTHERTONGUEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERTONGUEFocusGained

        if(MOTHERTONGUE.getText().trim().equals("None"))
        {
            MOTHERTONGUE.setText("");
            MOTHERTONGUE.setForeground(Color.black);
        }
    }//GEN-LAST:event_MOTHERTONGUEFocusGained

    private void YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YesActionPerformed

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoActionPerformed

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleActionPerformed

    private void AGEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AGEKeyTyped

        if (!Character.isDigit(evt.getKeyChar())) {

            evt.consume();

        }
    }//GEN-LAST:event_AGEKeyTyped

    private void STUDENTNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STUDENTNAMEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_STUDENTNAMEKeyReleased

    private void STUDENTNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENTNAMEFocusLost

        if(STUDENTNAME.getText().trim().equals(""))
        {
            STUDENTNAME.setText("Last Name,  First Name   Middle Name");
            STUDENTNAME.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_STUDENTNAMEFocusLost

    private void STUDENTNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENTNAMEFocusGained

        if( STUDENTNAME.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            STUDENTNAME.setText("");
            STUDENTNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_STUDENTNAMEFocusGained

    private void LRNNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LRNNOKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {

            evt.consume();

        }

        if (LRNNO.getText().length() >= 12 ) // limit to 3 characters
        evt.consume();
    }//GEN-LAST:event_LRNNOKeyTyped

    private void LRNNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LRNNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LRNNOActionPerformed

    private void LRNNOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LRNNOFocusLost

        if (LRNNO.getText().trim().isEmpty()) {
            LRNNO.setForeground(Color.black);
            LRNNO.setText("None");
        }
    }//GEN-LAST:event_LRNNOFocusLost

    private void LRNNOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LRNNOFocusGained

        if(LRNNO.getText().trim().equals("None"))
        {
            LRNNO.setText("");
            LRNNO.setForeground(Color.black);
        }
    }//GEN-LAST:event_LRNNOFocusGained

    private void STUDENT_ACCOUNTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTKeyPressed

    }//GEN-LAST:event_STUDENT_ACCOUNTKeyPressed

    private void STUDENT_ACCOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STUDENT_ACCOUNTActionPerformed

    private void STUDENT_ACCOUNTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTFocusLost

        if ( STUDENT_ACCOUNT.getText().trim().isEmpty()) {
            STUDENT_ACCOUNT.setForeground(new Color(51,51,51));
            STUDENT_ACCOUNT.setText("None");
        }
    }//GEN-LAST:event_STUDENT_ACCOUNTFocusLost

    private void STUDENT_ACCOUNTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTFocusGained

        if( STUDENT_ACCOUNT.getText().trim().equals("None"))
        {
            STUDENT_ACCOUNT.setText("");
            STUDENT_ACCOUNT.setForeground(Color.black);
        }
    }//GEN-LAST:event_STUDENT_ACCOUNTFocusGained

    private void GRADELEVELFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GRADELEVELFocusGained
        if(GRADELEVEL.getText().trim().equals("None"))
        {
            GRADELEVEL.setText("");
            GRADELEVEL.setForeground(Color.black);
        }
    }//GEN-LAST:event_GRADELEVELFocusGained

    private void GRADELEVELFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GRADELEVELFocusLost
        if(GRADELEVEL.getText().trim().equals(""))
        {
            GRADELEVEL.setText("None");
            GRADELEVEL.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_GRADELEVELFocusLost

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLEARActionPerformed

    private void searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchCaretUpdate

        LoadSearchData();
    }//GEN-LAST:event_searchCaretUpdate

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed

        DefaultTableModel model =  (DefaultTableModel)jTable.getModel() ;
        int selecIndex= jTable.getSelectedRow();
        
        int idenrolled = Integer.parseInt(model.getValueAt(selecIndex, 0).toString());
        
        
        SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String lrn = LRN.getSelectedItem().toString();
        String psa =STUDENT_ACCOUNT.getText();
        String lrnno=LRNNO.getText();
        String lname=STUDENTNAME.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(jDateChooser1.getDate());

        String age=AGE.getText();
          String gender = "Male";
        if (Female.isSelected()) {
            gender="Female";
        }

        String ip = "No";
        if (Yes.isSelected()) {
            ip="Yes";
        }

        String ipstat=YES_IPSPECIFY.getText();
        String mothertong=MOTHERTONGUE.getText();
        String add= ADDRESS.getText();
        String zip=ZIPCODE.getText();
        String flname=FATHERNAME.getText();

        String mlname=MOTHERNAME.getText();

        String glnamae=GUARDIAN.getText();

        String tel=TELNO.getText();
        String cp=CELPHONE.getText();
        String levelcompleted = LEVELCOMPLETED.getSelectedItem().toString();
        String sycompleted=SYCOMPLETED.getText();
        String schoolname = SCHOOLNAME.getText();
        String schoolid = SCHOOLID.getText();
        String schooladdress = SCHOOLADDRESS.getText();
        String sem = "Second Semester";
        if (One.isSelected()) {
            sem = "First Semester";
        }

        String track=TRACK.getSelectedItem().toString();
        String strand=STRAND.getSelectedItem().toString();
        
        String gradelevel = GRADELEVEL.getText();
        String trackenroll= TRACK_ENROLLED.getSelectedItem().toString();
        
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);
            
        if (verifyText()) {
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
            PreparedStatement ps;
            ps=Mycon.prepareStatement("update enrolled_students set school_year_id=?, lrnStatus=?, student_account_no=?, lrnNumber=?, fullname=?, bdate=?, sex=?, age=?, ip=?, ip_status=?, mother_tongue=?, address=?, zip_code=?, fathername=?, mothername=?, guardianname=?, telephone=?, cellphone=?, last_grade_level_completed=?, last_school_year_completed=?, school_name=?, school_id=?, school_address=?, semester=?, track=?, strand=?, grade_level=?, enrolled_track=? where id=?");
             ps.setInt(1, sy.id);
            ps.setString(2,lrn);
            ps.setString(3,psa);
            ps.setString(4,lrnno);
            ps.setString(5, lname);
            ps.setString(6, date);
            ps.setString(7, gender);
            ps.setString(8, age);
            ps.setString(9, ip);
            ps.setString(10, ipstat);
            ps.setString(11, mothertong);
            ps.setString(12, add);
            ps.setString(13, zip);
            ps.setString(14, flname);
            ps.setString(15, mlname);
            ps.setString(16, glnamae);
            ps.setString(17, tel);
            ps.setString(18, cp);
            ps.setString(19, levelcompleted);
            ps.setString(20, sycompleted);
            ps.setString(21, schoolname);
            ps.setString(22, schoolid);
            ps.setString(23, schooladdress);
            ps.setString(24, sem);
            ps.setString(25, track);
            ps.setString(26, strand);
            ps.setString(27, gradelevel);
            ps.setString(28, trackenroll);
           // ps.setString(29,timestamp );
            ps.setInt(29, idenrolled);

            //ps.execute();

            //  JOptionPane.showMessageDialog(null, "Successfully Added");
          //  if (verifyText()) {

                ps.execute();

                schoolyr.setSelectedIndex(-1);
                LRN.setSelectedIndex(-1);
                STUDENT_ACCOUNT.setText("None");
                LRNNO.setText("None");
                STUDENTNAME.setText("Last Name,  First Name   Middle Name");

                //jDateChooser1.setDateFormatString("");

                Male.setSelected(true);
                Female.setSelected(true);

                No.setSelected(false);
                Yes.setSelected(false);
                
                One.setSelected(false);
                Two.setSelected(false);
                
                AGE.setText("");
                YES_IPSPECIFY.setText("Please Specify. . .");
                MOTHERTONGUE.setText("None");
                ADDRESS.setText("");
                ZIPCODE.setText("0000");
                FATHERNAME.setText("Last Name,  First Name   Middle Name");
                MOTHERNAME.setText("Last Name,  First Name   Middle Name");
                GUARDIAN.setText("Last Name,  First Name   Middle Name");
                TELNO.setText("");
                CELPHONE.setText("");
                LEVELCOMPLETED.setSelectedIndex(0);
                SYCOMPLETED.setText("");
                SCHOOLNAME.setText("None");
                SCHOOLID.setText("None");
                SCHOOLADDRESS.setText("None");
                TRACK.setSelectedIndex(0);
                STRAND.setSelectedIndex(0);
               GRADELEVEL.setText("None");
                TRACK_ENROLLED.setSelectedIndex(0);

                JOptionPane.showMessageDialog(null, "Student Record Successfully Updated");

           // }

            // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

        } catch (ClassNotFoundException  ex) {
            
           // JOptionPane.showMessageDialog(this, "ERROR");
            
            Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
        }catch ( SQLException ex) {
            // JOptionPane.showMessageDialog(this, "ERROR");
            Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }//GEN-LAST:event_UPDATEActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed

         SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String lrn = LRN.getSelectedItem().toString();
        String psa =STUDENT_ACCOUNT.getText();
        String lrnno=LRNNO.getText();
        String lname=STUDENTNAME.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(jDateChooser1.getDate());

        String age=AGE.getText();
          String gender = "Male";
        if (Female.isSelected()) {
            gender="Female";
        }

        String ip = "No";
        if (Yes.isSelected()) {
            ip="Yes";
        }

        String ipstat=YES_IPSPECIFY.getText();
        String mothertong=MOTHERTONGUE.getText();
        String add= ADDRESS.getText();
        String zip=ZIPCODE.getText();
        String flname=FATHERNAME.getText();

        String mlname=MOTHERNAME.getText();

        String glnamae=GUARDIAN.getText();

        String tel=TELNO.getText();
        String cp=CELPHONE.getText();
        String levelcompleted = LEVELCOMPLETED.getSelectedItem().toString();
        String sycompleted=SYCOMPLETED.getText();
        String schoolname = SCHOOLNAME.getText();
        String schoolid = SCHOOLID.getText();
        String schooladdress = SCHOOLADDRESS.getText();
        String sem = "Second Semester";
        if (One.isSelected()) {
            sem = "First Semester";
        }

        String track=TRACK.getSelectedItem().toString();
        String strand=STRAND.getSelectedItem().toString();
        
        String gradelevel = GRADELEVEL.getText();
        String trackenroll= TRACK_ENROLLED.getSelectedItem().toString();
        
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);
            
        if (verifyText()) {
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
            PreparedStatement ps;
        ps=Mycon.prepareStatement("insert into enrolled_students (school_year_id, lrnStatus, student_account_no, lrnNumber, fullname, bdate, sex, age, ip, ip_status, mother_tongue, address, zip_code, fathername, mothername, guardianname, telephone, cellphone, last_grade_level_completed, last_school_year_completed, school_name, school_id, school_address, semester, track, strand, grade_level, enrolled_track, timestamp) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, sy.id);
            ps.setString(2,lrn);
            ps.setString(3,psa);
            ps.setString(4,lrnno);
            ps.setString(5, lname);
            ps.setString(6, date);
            ps.setString(7, gender);
            ps.setString(8, age);
            ps.setString(9, ip);
            ps.setString(10, ipstat);
            ps.setString(11, mothertong);
            ps.setString(12, add);
            ps.setString(13, zip);
            ps.setString(14, flname);
            ps.setString(15, mlname);
            ps.setString(16, glnamae);
            ps.setString(17, tel);
            ps.setString(18, cp);
            ps.setString(19, levelcompleted);
            ps.setString(20, sycompleted);
            ps.setString(21, schoolname);
            ps.setString(22, schoolid);
            ps.setString(23, schooladdress);
            ps.setString(24, sem);
            ps.setString(25, track);
            ps.setString(26, strand);
            ps.setString(27, gradelevel);
            ps.setString(28, trackenroll);
            ps.setString(29,timestamp );

            //ps.execute();

              JOptionPane.showMessageDialog(null, "Successfully Added");
            if (verifyText()) {

                ps.execute();

                schoolyr.setSelectedIndex(-1);
                LRN.setSelectedIndex(-1);
                STUDENT_ACCOUNT.setText("None");
                LRNNO.setText("None");
                STUDENTNAME.setText("Last Name,  First Name   Middle Name");

                //jDateChooser1.setDateFormatString("");

                Male.setSelected(true);
                Female.setSelected(true);

                No.setSelected(false);
                Yes.setSelected(false);
                
                One.setSelected(false);
                Two.setSelected(false);
                
                AGE.setText("");
                YES_IPSPECIFY.setText("Please Specify. . .");
                MOTHERTONGUE.setText("None");
                ADDRESS.setText("");
                ZIPCODE.setText("0000");
                FATHERNAME.setText("Last Name,  First Name   Middle Name");
                MOTHERNAME.setText("Last Name,  First Name   Middle Name");
                GUARDIAN.setText("Last Name,  First Name   Middle Name");
                TELNO.setText("");
                CELPHONE.setText("");
                LEVELCOMPLETED.setSelectedIndex(0);
                SYCOMPLETED.setText("");
                SCHOOLNAME.setText("None");
                SCHOOLID.setText("None");
                SCHOOLADDRESS.setText("None");
                TRACK.setSelectedIndex(0);
                STRAND.setSelectedIndex(0);
               GRADELEVEL.setText("None");
                TRACK_ENROLLED.setSelectedIndex(0);

                JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");

            }

            // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

        } catch (ClassNotFoundException  ex) {
            
           // JOptionPane.showMessageDialog(this, "ERROR");
            
            Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
        }catch ( SQLException ex) {
            // JOptionPane.showMessageDialog(this, "ERROR");
            Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_ADDActionPerformed

//     public boolean verifyText()
//    {
//        
//        if (schoolyr.getSelectedItem().equals("") || LRN.getSelectedItem().toString().equals("") || PSA.getText().equals("") || LRNNO.getText().equals("") ||  STUDENTNAME.getText().equals("") ||   jDateChooser1.getDate() == null ||  YES_IPSPECIFY.getText().equals("") ||  MOTHERTONGUE.getText().equals("") ||  ADDRESS.getText().equals("") ||  ZIPCODE.getText().equals("") ||  FATHERNAME.getText().equals("") ||  MOTHERNAME.getText().equals("") ||  GUARDIAN.getText().equals("") ||  TELNO.getText().equals("") ||  CELPHONE.getText().equals("") || LEVELCOMPLETED.getSelectedItem().equals("") || SYCOMPLETED.getText().equals("") ||  SCHOOLNAME.getText().equals("") || SCHOOLID.getText().equals("") || SCHOOLADDRESS.getText().equals("") || TRACK.getSelectedItem().equals("") || STRAND.getSelectedItem().equals(""))
//
//        
//          {
//            
//            JOptionPane.showMessageDialog(this," Failed...!!! One or More Empty");
//            
//            return false;
//            
//        }else if(jDateChooser1.getDate().compareTo(new Date()) > 0) {
//            
//            JOptionPane.showMessageDialog(this, "Failed...!!!, Please Check the Year of Birth Date, Present Year is not Allowed");
//            
//            return false;
//            
//            
//        } else if(jDateChooser1.getDate().compareTo(new Date()) > 0) {
//            
//            JOptionPane.showMessageDialog(this, "Failed...!!!, Please Check the Year of Birth Date, Present Year is not Allowed");
//            
//            return false;
//            
//            
//        } else {
//            
//             return true;
//        }
//     
//     
//        
//    }
    
    

    
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
            java.util.logging.Logger.getLogger(trial_edit_students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trial_edit_students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trial_edit_students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trial_edit_students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trial_edit_students().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField ADDRESS;
    private javax.swing.JTextField AGE;
    private javax.swing.JFormattedTextField CELPHONE;
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton DELETE;
    private javax.swing.JTextField FATHERNAME;
    private javax.swing.JCheckBox Female;
    private javax.swing.JTextField GRADELEVEL;
    private javax.swing.JLabel GRADE_LEVEL;
    private javax.swing.JTextField GUARDIAN;
    private javax.swing.JComboBox LEVELCOMPLETED;
    private javax.swing.JComboBox<String> LRN;
    private javax.swing.JTextField LRNNO;
    private javax.swing.JTextField MOTHERNAME;
    private javax.swing.JTextField MOTHERTONGUE;
    private javax.swing.JCheckBox Male;
    private javax.swing.JCheckBox No;
    private javax.swing.JCheckBox One;
    private javax.swing.JTextField SCHOOLADDRESS;
    private javax.swing.JTextField SCHOOLID;
    private javax.swing.JTextField SCHOOLNAME;
    private javax.swing.JComboBox STRAND;
    private javax.swing.JTextField STUDENTNAME;
    private javax.swing.JTextField STUDENT_ACCOUNT;
    private javax.swing.JFormattedTextField SYCOMPLETED;
    private javax.swing.JFormattedTextField TELNO;
    private javax.swing.JComboBox TRACK;
    private javax.swing.JComboBox TRACK_ENROLLED;
    private javax.swing.JLabel TRACK_STRAND;
    private javax.swing.JCheckBox Two;
    private javax.swing.JButton UPDATE;
    private javax.swing.JTextField YES_IPSPECIFY;
    private javax.swing.JCheckBox Yes;
    private javax.swing.JTextField ZIPCODE;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JComboBox schoolyr;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
