/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trials;

import dcaa_registrar2.RegistrationLogin;
import java.awt.Color;
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
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GOD
 */
public class EDIT_SEARCH extends javax.swing.JFrame {

    /**
     * Creates new form EDIT_SEARCH
     */
    public EDIT_SEARCH() {
        initComponents();
         ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(no);
        bg2.add(yes);
 
         schoolyear2();
         
         jScrollPane1.setFocusable(true);
          table_update();
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
                Logger.getLogger(BALIKARAL_SHS.class.getName()).log(Level.SEVERE, null, ex);
            }catch ( SQLException ex) {
                Logger.getLogger(BALIKARAL_SHS.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
            
        }
    
    
       
       
       
       
         private void table_update()
    {
                                       
        
                                           int c;
                                            
                                            try {
                                                
                                                
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                            PreparedStatement ps;   
                                            ps=Mycon.prepareStatement("select * from balikaral_shs");
                                           //ps= Mycon.prepareStatement("select s.school_year_id, a.lrnStatus, a.psa, a.lrnNumber, a.s_lname, a.s_fname, a.s_mname, a.s_extension, a.bdate, a.sex, a.age, a.ip, a.ip_status, a.mother_tongue, a.address, a.zip_code from basic_education a, school_year s  where a.school_year_id = s.id ");
                                                // coategory, brand and product gi merge nako by : initial description for c=category, b=brand and p=product
                                            //  ps= Mycon.prepareStatement("select p.idproduct, p.product, p.description, c.name, b.brandname, p.cost_price, p.retail_price, p.quantity, p.barcode, p.status  from product p,category c, brand b  where p.cat_id = c.id and p.brand_id = b.id");
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
                                                         //v.add(rs.getString("id")); 
                                                          v.add(rs.getString("school_year_id"));
                                                          v.add(rs.getString("lrnStatus")); 
                                                           v.add(rs.getString("psa")); 
                                                            v.add(rs.getString("lrnNumber")); 
                                                             v.add(rs.getString("s_lname")); 
                                                              v.add(rs.getString("s_fname")); 
                                                               v.add(rs.getString("s_mname")); 
                                                                v.add(rs.getString("s_extension"));
                                                                 v.add(rs.getString("bdate"));
                                                                  v.add(rs.getString("sex"));
                                                                   v.add(rs.getString("age")); 
                                                                    v.add(rs.getString("ip")); 
                                                                     v.add(rs.getString("ip_status"));
                                                                      v.add(rs.getString("mother_tongue")); 
                                                                       v.add(rs.getString("address"));
                                                                        v.add(rs.getString("zip_code"));
                                                                       v.add(rs.getString("last_grade_level_completed"));
                                                                                    v.add(rs.getString("last_school_year_completed")); 
                                                                                    v.add(rs.getString("school_name")); 
                                                                                     v.add(rs.getString("school_id"));
                                                                                     v.add(rs.getString("school_address")); 
                                                                                       v.add(rs.getString("semester")); 
                                                                                        v.add(rs.getString("track")); 
                                                                                         v.add(rs.getString("strand")); 
                                                                                   
                                                    }
                                                    
                                                    model.addRow(v);
  
                                                }
                                        }  catch (ClassNotFoundException  ex) {
                                                Logger.getLogger(EDIT_SEARCH.class.getName()).log(Level.SEVERE, null, ex);
                                        }catch ( SQLException ex) {
                                                Logger.getLogger(EDIT_SEARCH.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CANCEL = new javax.swing.JButton();
        CANCEL4 = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        FATHER_FNAME = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        CELPHONE = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MOTHER_FNAME = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ZIPCODE = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TELNO = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        AGE = new javax.swing.JTextField();
        FATHER_LNAME = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LRNNO = new javax.swing.JTextField();
        ST_MDNAME = new javax.swing.JTextField();
        ST_FNAME = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        MOTHERTONGUE = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        FATHER_MDNAME = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        MOTHER_LNAME = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        ST_LNAME = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        ST_EXNAME = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        YES_IPSPECIFY = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        PSA = new javax.swing.JTextField();
        MOTHER_MDNAME = new javax.swing.JTextField();
        ADDRESS = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        LRN = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        GUARD_MDNAME = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        GUARD_FNAME = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        GUARD_LNAME = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        male = new javax.swing.JCheckBox();
        female = new javax.swing.JCheckBox();
        no = new javax.swing.JCheckBox();
        yes = new javax.swing.JCheckBox();
        jLabel49 = new javax.swing.JLabel();
        schoolyr = new javax.swing.JComboBox();
        jTextField22 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        LEVELCOMPLETED = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        SYCOMPLETED = new javax.swing.JTextField();
        SCHOOLID = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        SCHOOLNAME = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        SCHOOLADDRESS = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        ONE = new javax.swing.JCheckBox();
        TWO = new javax.swing.JCheckBox();
        jLabel59 = new javax.swing.JLabel();
        TRACK = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        STRAND = new javax.swing.JComboBox<>();
        CANCEL1 = new javax.swing.JButton();
        ADD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SCHOOL YEAR", "STATUS", "PSA NO.", "LRN NO.", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "EXTENSION NAME", "BIRTH DATE", "GENDER", "AGE", "IP", "IP STATUS", "MOTHER TONGUE", "ADDRESS", "ZIP CODE", "LAST GRADE LEVEL", "LAST SY COMPLETED", "SCHOOL NAME", "SCHOOL ID", "SCHOOL ADDRESS", "SEMESTER", "TRACK", "STRAND"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.setGridColor(new java.awt.Color(51, 51, 51));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(5);
        jTable1.setSelectionBackground(new java.awt.Color(0, 51, 102));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        CANCEL.setBackground(new java.awt.Color(51, 51, 51));
        CANCEL.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        CANCEL.setForeground(new java.awt.Color(255, 0, 0));
        CANCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/trash.png"))); // NOI18N
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });

        CANCEL4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        CANCEL4.setForeground(new java.awt.Color(255, 0, 0));
        CANCEL4.setText("SEARCH");
        CANCEL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCEL4ActionPerformed(evt);
            }
        });

        username.setBackground(new java.awt.Color(51, 51, 51));
        username.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setText(" Search.......");
        username.setBorder(null);
        username.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        username.setFocusCycleRoot(true);
        username.setFocusTraversalPolicyProvider(true);
        username.setInheritsPopupMenu(true);
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1670, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CANCEL4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CANCEL4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel5KeyPressed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("MIDDLE  NAME :");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("FIRST  NAME :");

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("FIRST  NAME :");

        FATHER_FNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FATHER_FNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FATHER_FNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FATHER_FNAMEActionPerformed(evt);
            }
        });
        FATHER_FNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FATHER_FNAMEKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Country");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("LAST  NAME :");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("BASIC  EDUCATION  ENROLLMENT FORM");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        CELPHONE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CELPHONE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CELPHONE.setText("+63");
        CELPHONE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CELPHONEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CELPHONEFocusLost(evt);
            }
        });
        CELPHONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CELPHONEActionPerformed(evt);
            }
        });
        CELPHONE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CELPHONEKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("City / Province");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Indigenous People (IP) :");

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("MIDDLE  NAME :");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("if YES, please specify :");

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("CELLPHONE NO. : ");

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(204, 204, 204));
        jTextField17.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(0, 0, 0));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("PARENT'S / GUARDIAN'S INFORMATION");
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("School Year :");

        MOTHER_FNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MOTHER_FNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MOTHER_FNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MOTHER_FNAMEKeyReleased(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("LAST NAME :");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("EXTENSION  NAME :");

        ZIPCODE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ZIPCODE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ZIPCODE.setText("0000000000");
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

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("AGE :");

        TELNO.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TELNO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TELNO.setText("(00) 000 0000");
        TELNO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TELNOFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TELNOFocusLost(evt);
            }
        });
        TELNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TELNOKeyTyped(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("MIDDLE  NAME :");

        AGE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AGE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AGE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AGEKeyTyped(evt);
            }
        });

        FATHER_LNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FATHER_LNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FATHER_LNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FATHER_LNAMEKeyReleased(evt);
            }
        });

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("TELEPHONE NO. : ");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PSA Birth Certificate No. :");

        LRNNO.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LRNNO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LRNNO.setText("N/A");
        LRNNO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LRNNOFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                LRNNOFocusLost(evt);
            }
        });
        LRNNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LRNNOKeyTyped(evt);
            }
        });

        ST_MDNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ST_MDNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ST_MDNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ST_MDNAMEKeyReleased(evt);
            }
        });

        ST_FNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ST_FNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ST_FNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ST_FNAMEKeyReleased(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("STUDENT INFORMATION");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Learner's Reference No. (LRN):  ");

        jLabel27.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Street");

        MOTHERTONGUE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MOTHERTONGUE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MOTHERTONGUE.setText("N/A");
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

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("FIRST  NAME :");

        FATHER_MDNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FATHER_MDNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FATHER_MDNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FATHER_MDNAMEKeyReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Barangay");

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("GENDER :");

        MOTHER_LNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MOTHER_LNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MOTHER_LNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MOTHER_LNAMEKeyReleased(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 51, 51));
        jLabel36.setText("FATHER'S NAME :");

        ST_LNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ST_LNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ST_LNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ST_LNAMEKeyReleased(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("ADDRESS :");

        ST_EXNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ST_EXNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ST_EXNAME.setText("e.g. Jr., II, III (if applicable)");
        ST_EXNAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ST_EXNAMEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ST_EXNAMEFocusLost(evt);
            }
        });
        ST_EXNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ST_EXNAMEKeyReleased(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 51, 51));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Type legibly all the following information in CAPS LOCK / CAPITAL letters. Submit accomplished form to the Person-in-charge / Registrar.");

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("INSTRUCTIONS :");

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("LAST NAME :");

        YES_IPSPECIFY.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        YES_IPSPECIFY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        YES_IPSPECIFY.setText("N/A");
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

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 51, 51));
        jLabel41.setText("MOTHER'S NAME :");

        PSA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PSA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PSA.setText("N/A");
        PSA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PSAFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PSAFocusLost(evt);
            }
        });
        PSA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PSAKeyPressed(evt);
            }
        });

        MOTHER_MDNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MOTHER_MDNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MOTHER_MDNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MOTHER_MDNAMEKeyReleased(evt);
            }
        });

        ADDRESS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ADDRESS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ADDRESS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ADDRESSKeyReleased(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Please Select below: ");

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("DATE OF BIRTH :");

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("ZIP CODE :");

        LRN.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO LRN", "WITH LRN", "NO LRN - BALIK ARAL", "WITH LRN BALIK ARAL" }));

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 51, 51));
        jLabel45.setText("GUARDIAN'S NAME :");

        GUARD_MDNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GUARD_MDNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GUARD_MDNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GUARD_MDNAMEKeyReleased(evt);
            }
        });

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("MIDDLE  NAME :");

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("FIRST  NAME :");

        GUARD_FNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GUARD_FNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GUARD_FNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUARD_FNAMEActionPerformed(evt);
            }
        });
        GUARD_FNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GUARD_FNAMEKeyReleased(evt);
            }
        });

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("LAST NAME :");

        GUARD_LNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GUARD_LNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GUARD_LNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GUARD_LNAMEKeyReleased(evt);
            }
        });

        jDateChooser1.setForeground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N

        male.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("MALE");
        male.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        male.setInheritsPopupMenu(true);

        female.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("FEMALE");
        female.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        female.setInheritsPopupMenu(true);

        no.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        no.setForeground(new java.awt.Color(255, 255, 255));
        no.setText("NO");
        no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no.setInheritsPopupMenu(true);

        yes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        yes.setForeground(new java.awt.Color(255, 255, 255));
        yes.setText("YES");
        yes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yes.setInheritsPopupMenu(true);

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("MOTHER TONGUE :");

        schoolyr.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jTextField22.setEditable(false);
        jTextField22.setBackground(new java.awt.Color(204, 204, 204));
        jTextField22.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(0, 0, 0));
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setText("For Returning Learners (Balik - Aral / Repeater ) and Those Who are Transferee");
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("LAST GRADE LEVEL COMPLETED :");

        LEVELCOMPLETED.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LEVELCOMPLETED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("LAST SCHOOL YEAR COMPLETED :");

        SYCOMPLETED.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SYCOMPLETED.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SYCOMPLETED.setText("yyyy-yyyy");
        SYCOMPLETED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SYCOMPLETEDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SYCOMPLETEDFocusLost(evt);
            }
        });

        SCHOOLID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SCHOOLID.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("SCHOOL ID :");

        SCHOOLNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SCHOOLNAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SCHOOLNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SCHOOLNAMEKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SCHOOLNAMEKeyReleased(evt);
            }
        });

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("SCHOOL NAME :");

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("SCHOOL ADDRESS :");

        SCHOOLADDRESS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SCHOOLADDRESS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SCHOOLADDRESS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SCHOOLADDRESSKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Street");

        jLabel55.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Barangay");

        jLabel56.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("City / Province");

        jLabel57.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Country");

        jTextField23.setEditable(false);
        jTextField23.setBackground(new java.awt.Color(204, 204, 204));
        jTextField23.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(0, 0, 0));
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setText("For Learners in Senior High School");
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("SEMESTER :");

        ONE.setBackground(new java.awt.Color(102, 102, 102));
        ONE.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        ONE.setForeground(new java.awt.Color(255, 255, 255));
        ONE.setText("1st");
        ONE.setAlignmentX(1.0F);
        ONE.setAlignmentY(1.0F);
        ONE.setAutoscrolls(true);
        ONE.setBorderPainted(true);
        ONE.setBorderPaintedFlat(true);
        ONE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ONE.setIconTextGap(10);
        ONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ONEActionPerformed(evt);
            }
        });

        TWO.setBackground(new java.awt.Color(102, 102, 102));
        TWO.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        TWO.setForeground(new java.awt.Color(255, 255, 255));
        TWO.setText("2nd");
        TWO.setAlignmentX(1.0F);
        TWO.setAlignmentY(1.0F);
        TWO.setAutoscrolls(true);
        TWO.setBorderPainted(true);
        TWO.setBorderPaintedFlat(true);
        TWO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TWO.setIconTextGap(10);
        TWO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TWOActionPerformed(evt);
            }
        });

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("TRACK :");

        TRACK.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TRACK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACADEMIC", "TECHNICAL-VOCATIONAL" }));

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("STRAND :");

        STRAND.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        STRAND.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABM", "GAS", "HUMMS", "CCS", "CSS", "EIM", "FOS", "FBS", "HOUSE KEEPING", "BEAUTY NAILCARE" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel15))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel26)))
                                .addComponent(jLabel19)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ST_LNAME, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ST_FNAME, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ST_MDNAME, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ST_EXNAME, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addGap(400, 400, 400)
                                        .addComponent(jLabel41))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(276, 276, 276)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel30)
                                                    .addComponent(jLabel40)
                                                    .addComponent(jLabel31))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(MOTHER_LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(MOTHER_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(MOTHER_MDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(214, 214, 214)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(289, 289, 289))))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel45))
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGap(72, 72, 72)
                                    .addComponent(jLabel43)
                                    .addGap(18, 18, 18)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(AGE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(male, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(female, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel37)
                                        .addComponent(jLabel18))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(YES_IPSPECIFY, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(ADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(40, 40, 40)
                                            .addComponent(jLabel44)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ZIPCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(9, 9, 9))))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(92, 92, 92)
                                    .addComponent(jLabel49)
                                    .addGap(18, 18, 18)
                                    .addComponent(MOTHERTONGUE, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel17)
                                .addGap(53, 53, 53)
                                .addComponent(no)
                                .addGap(44, 44, 44)
                                .addComponent(yes))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel47)
                                            .addComponent(jLabel48)
                                            .addComponent(jLabel46))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(GUARD_LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GUARD_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GUARD_MDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel13))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FATHER_LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FATHER_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FATHER_MDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(130, 130, 130)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TELNO)
                                    .addComponent(CELPHONE, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(475, 475, 475)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(LRN, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel58)
                .addGap(36, 36, 36)
                .addComponent(ONE)
                .addGap(18, 18, 18)
                .addComponent(TWO)
                .addGap(77, 77, 77)
                .addComponent(jLabel59)
                .addGap(18, 18, 18)
                .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jLabel60)
                .addGap(18, 18, 18)
                .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 325, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LEVELCOMPLETED, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addComponent(SYCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SCHOOLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel52)
                                .addGap(13, 13, 13)
                                .addComponent(SCHOOLID))
                            .addComponent(SCHOOLADDRESS))))
                .addGap(206, 206, 206))
            .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jTextField22)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
                .addComponent(jTextField2)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(272, 272, 272)
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(LRNNO, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(318, 318, 318)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(PSA, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42)
                        .addGap(0, 0, 0)
                        .addComponent(LRN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LRNNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ST_LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ST_MDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_EXNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(male)
                            .addComponent(female)
                            .addComponent(jLabel20)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(AGE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yes)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MOTHERTONGUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YES_IPSPECIFY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ZIPCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FATHER_LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FATHER_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FATHER_MDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MOTHER_LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MOTHER_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MOTHER_MDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TELNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CELPHONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(GUARD_LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(GUARD_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(GUARD_MDNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SYCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LEVELCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SCHOOLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SCHOOLID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SCHOOLADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ONE, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TWO, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(jPanel5);

        CANCEL1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        CANCEL1.setForeground(new java.awt.Color(255, 0, 0));
        CANCEL1.setText("CANCEL");
        CANCEL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCEL1ActionPerformed(evt);
            }
        });

        ADD.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ADD.setForeground(new java.awt.Color(255, 0, 0));
        ADD.setText("SAVE");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1528, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CANCEL1)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 180, Short.MAX_VALUE)
                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(CANCEL1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
        this.dispose();
    }//GEN-LAST:event_CANCELActionPerformed

    private void CANCEL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCEL4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CANCEL4ActionPerformed

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained

        if( username.getText().trim().equals("Username"))
        {
            username.setText("");
            username.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost

        if ( username.getText().trim().isEmpty()) {
            username.setForeground(new Color(255,255,255));
            username.setText("Username");
        }
    }//GEN-LAST:event_usernameFocusLost

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void FATHER_FNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FATHER_FNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FATHER_FNAMEActionPerformed

    private void FATHER_FNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FATHER_FNAMEKeyReleased

        int position = FATHER_FNAME.getCaretPosition();
        FATHER_FNAME.setText(FATHER_FNAME.getText().toUpperCase());
        FATHER_FNAME.setCaretPosition(position);
    }//GEN-LAST:event_FATHER_FNAMEKeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void CELPHONEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CELPHONEFocusGained

        //

        if(CELPHONE.getText().trim().equals("+63"))
        {
            CELPHONE.setText("");
            CELPHONE.setForeground(Color.black);
        }
    }//GEN-LAST:event_CELPHONEFocusGained

    private void CELPHONEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CELPHONEFocusLost

        if ( CELPHONE.getText().trim().isEmpty()) {
            CELPHONE.setForeground(new Color(51,51,51));
            CELPHONE.setText("yyyy-yyyy");
        }
    }//GEN-LAST:event_CELPHONEFocusLost

    private void CELPHONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CELPHONEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CELPHONEActionPerformed

    private void CELPHONEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CELPHONEKeyTyped

        if (!Character.isDigit(evt.getKeyChar())) {

            evt.consume();

        }
    }//GEN-LAST:event_CELPHONEKeyTyped

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void MOTHER_FNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MOTHER_FNAMEKeyReleased

        int position = MOTHER_FNAME.getCaretPosition();
        MOTHER_FNAME.setText(MOTHER_FNAME.getText().toUpperCase());
        MOTHER_FNAME.setCaretPosition(position);
    }//GEN-LAST:event_MOTHER_FNAMEKeyReleased

    private void ZIPCODEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ZIPCODEFocusGained
        if(ZIPCODE.getText().trim().equals("0000000000"))
        {
            ZIPCODE.setText("");
            ZIPCODE.setForeground(Color.black);
        }
    }//GEN-LAST:event_ZIPCODEFocusGained

    private void ZIPCODEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ZIPCODEFocusLost
        if(ZIPCODE.getText().trim().equals(""))
        {
            ZIPCODE.setText("0000000000");
            ZIPCODE.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_ZIPCODEFocusLost

    private void ZIPCODEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZIPCODEKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {

            evt.consume();

        }
    }//GEN-LAST:event_ZIPCODEKeyTyped

    private void TELNOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TELNOFocusGained
        if(TELNO.getText().trim().equals("(00) 000 0000"))
        {
            TELNO.setText("");
            TELNO.setForeground(Color.black);
        }
    }//GEN-LAST:event_TELNOFocusGained

    private void TELNOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TELNOFocusLost
        if(TELNO.getText().trim().equals(""))
        {
            TELNO.setText("(00) 000 0000");
            TELNO.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_TELNOFocusLost

    private void TELNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TELNOKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {

            evt.consume();

        }
    }//GEN-LAST:event_TELNOKeyTyped

    private void AGEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AGEKeyTyped

        if (!Character.isDigit(evt.getKeyChar())) {

            evt.consume();

        }
    }//GEN-LAST:event_AGEKeyTyped

    private void FATHER_LNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FATHER_LNAMEKeyReleased

        int position = FATHER_LNAME.getCaretPosition();
        FATHER_LNAME.setText(FATHER_LNAME.getText().toUpperCase());
        FATHER_LNAME.setCaretPosition(position);
    }//GEN-LAST:event_FATHER_LNAMEKeyReleased

    private void LRNNOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LRNNOFocusGained

        if(LRNNO.getText().trim().equals("N/A"))
        {
            LRNNO.setText("");
            LRNNO.setForeground(Color.black);
        }
    }//GEN-LAST:event_LRNNOFocusGained

    private void LRNNOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LRNNOFocusLost

        if (LRNNO.getText().trim().isEmpty()) {
            LRNNO.setForeground(new Color(51,51,51));
            LRNNO.setText("N/A");
        }
    }//GEN-LAST:event_LRNNOFocusLost

    private void LRNNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LRNNOKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {

            evt.consume();

        }
    }//GEN-LAST:event_LRNNOKeyTyped

    private void ST_MDNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ST_MDNAMEKeyReleased

        int position = ST_MDNAME.getCaretPosition();
        ST_MDNAME.setText(ST_MDNAME.getText().toUpperCase());
        ST_MDNAME.setCaretPosition(position);
    }//GEN-LAST:event_ST_MDNAMEKeyReleased

    private void ST_FNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ST_FNAMEKeyReleased

        int position = ST_FNAME.getCaretPosition();
        ST_FNAME.setText(ST_FNAME.getText().toUpperCase());
        ST_FNAME.setCaretPosition(position);
    }//GEN-LAST:event_ST_FNAMEKeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void MOTHERTONGUEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERTONGUEFocusGained

        if(MOTHERTONGUE.getText().trim().equals("N/A"))
        {
            MOTHERTONGUE.setText("");
            MOTHERTONGUE.setForeground(Color.black);
        }
    }//GEN-LAST:event_MOTHERTONGUEFocusGained

    private void MOTHERTONGUEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERTONGUEFocusLost

        if(MOTHERTONGUE.getText().trim().equals(""))
        {
            MOTHERTONGUE.setText("N/A");
            MOTHERTONGUE.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_MOTHERTONGUEFocusLost

    private void MOTHERTONGUEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MOTHERTONGUEKeyReleased

        int position = MOTHERTONGUE.getCaretPosition();
        MOTHERTONGUE.setText(MOTHERTONGUE.getText().toUpperCase());
        MOTHERTONGUE.setCaretPosition(position);
    }//GEN-LAST:event_MOTHERTONGUEKeyReleased

    private void FATHER_MDNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FATHER_MDNAMEKeyReleased

        int position = FATHER_MDNAME.getCaretPosition();
        FATHER_MDNAME.setText(FATHER_MDNAME.getText().toUpperCase());
        FATHER_MDNAME.setCaretPosition(position);
    }//GEN-LAST:event_FATHER_MDNAMEKeyReleased

    private void MOTHER_LNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MOTHER_LNAMEKeyReleased

        int position = MOTHER_LNAME.getCaretPosition();
        MOTHER_LNAME.setText(MOTHER_LNAME.getText().toUpperCase());
        MOTHER_LNAME.setCaretPosition(position);
    }//GEN-LAST:event_MOTHER_LNAMEKeyReleased

    private void ST_LNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ST_LNAMEKeyReleased

        //to uppercase already
        int position = ST_LNAME.getCaretPosition();
        ST_LNAME.setText(ST_LNAME.getText().toUpperCase());
        ST_LNAME.setCaretPosition(position);
    }//GEN-LAST:event_ST_LNAMEKeyReleased

    private void ST_EXNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ST_EXNAMEFocusGained
        if(ST_EXNAME.getText().trim().equals("e.g. Jr., II, III (if applicable)"))
        {
            ST_EXNAME.setText("");
            ST_EXNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_ST_EXNAMEFocusGained

    private void ST_EXNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ST_EXNAMEFocusLost

        if(ST_EXNAME.getText().trim().equals(""))
        {
            ST_EXNAME.setText("e.g. Jr., II, III (if applicable)");
            ST_EXNAME.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_ST_EXNAMEFocusLost

    private void ST_EXNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ST_EXNAMEKeyReleased

        int position = ST_EXNAME.getCaretPosition();
        ST_EXNAME.setText(ST_EXNAME.getText().toUpperCase());
        ST_EXNAME.setCaretPosition(position);
    }//GEN-LAST:event_ST_EXNAMEKeyReleased

    private void YES_IPSPECIFYFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYFocusGained
        if(YES_IPSPECIFY.getText().trim().equals("N/A"))
        {
            YES_IPSPECIFY.setText("");
            YES_IPSPECIFY.setForeground(Color.black);
        }
    }//GEN-LAST:event_YES_IPSPECIFYFocusGained

    private void YES_IPSPECIFYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYFocusLost
        if(YES_IPSPECIFY.getText().trim().equals(""))
        {
            YES_IPSPECIFY.setText("N/A");
            YES_IPSPECIFY.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_YES_IPSPECIFYFocusLost

    private void YES_IPSPECIFYKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYKeyReleased

        int position = YES_IPSPECIFY.getCaretPosition();
        YES_IPSPECIFY.setText(YES_IPSPECIFY.getText().toUpperCase());
        YES_IPSPECIFY.setCaretPosition(position);
    }//GEN-LAST:event_YES_IPSPECIFYKeyReleased

    private void PSAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PSAFocusGained

        if( PSA.getText().trim().equals("N/A"))
        {
            PSA.setText("");
            PSA.setForeground(Color.black);
        }
    }//GEN-LAST:event_PSAFocusGained

    private void PSAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PSAFocusLost

        if ( PSA.getText().trim().isEmpty()) {
            PSA.setForeground(new Color(51,51,51));
            PSA.setText("N/A");
        }
    }//GEN-LAST:event_PSAFocusLost

    private void PSAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PSAKeyPressed

    }//GEN-LAST:event_PSAKeyPressed

    private void MOTHER_MDNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MOTHER_MDNAMEKeyReleased

        int position = MOTHER_MDNAME.getCaretPosition();
        MOTHER_MDNAME.setText(MOTHER_MDNAME.getText().toUpperCase());
        MOTHER_MDNAME.setCaretPosition(position);
    }//GEN-LAST:event_MOTHER_MDNAMEKeyReleased

    private void ADDRESSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADDRESSKeyReleased

        int position = ADDRESS.getCaretPosition();
        ADDRESS.setText(ADDRESS.getText().toUpperCase());
        ADDRESS.setCaretPosition(position);
    }//GEN-LAST:event_ADDRESSKeyReleased

    private void GUARD_MDNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GUARD_MDNAMEKeyReleased

        int position = GUARD_MDNAME.getCaretPosition();
        GUARD_MDNAME.setText(GUARD_MDNAME.getText().toUpperCase());
        GUARD_MDNAME.setCaretPosition(position);
    }//GEN-LAST:event_GUARD_MDNAMEKeyReleased

    private void GUARD_FNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUARD_FNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GUARD_FNAMEActionPerformed

    private void GUARD_FNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GUARD_FNAMEKeyReleased

        int position = GUARD_FNAME.getCaretPosition();
        GUARD_FNAME.setText(GUARD_FNAME.getText().toUpperCase());
        GUARD_FNAME.setCaretPosition(position);
    }//GEN-LAST:event_GUARD_FNAMEKeyReleased

    private void GUARD_LNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GUARD_LNAMEKeyReleased

        int position = GUARD_LNAME.getCaretPosition();
        GUARD_LNAME.setText(GUARD_LNAME.getText().toUpperCase());
        GUARD_LNAME.setCaretPosition(position);
    }//GEN-LAST:event_GUARD_LNAMEKeyReleased

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void SYCOMPLETEDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SYCOMPLETEDFocusGained

        if(SYCOMPLETED.getText().trim().equals("yyyy-yyyy"))
        {
            SYCOMPLETED.setText("");
            SYCOMPLETED.setForeground(Color.black);
        }
    }//GEN-LAST:event_SYCOMPLETEDFocusGained

    private void SYCOMPLETEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SYCOMPLETEDFocusLost

        if ( SYCOMPLETED.getText().trim().isEmpty()) {
            SYCOMPLETED.setForeground(new Color(51,51,51));
            SYCOMPLETED.setText("yyyy-yyyy");
        }
    }//GEN-LAST:event_SYCOMPLETEDFocusLost

    private void SCHOOLNAMEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SCHOOLNAMEKeyPressed

    }//GEN-LAST:event_SCHOOLNAMEKeyPressed

    private void SCHOOLNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SCHOOLNAMEKeyReleased

        int position = SCHOOLNAME.getCaretPosition();
        SCHOOLNAME.setText(SCHOOLNAME.getText().toUpperCase());
        SCHOOLNAME.setCaretPosition(position);
    }//GEN-LAST:event_SCHOOLNAMEKeyReleased

    private void SCHOOLADDRESSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SCHOOLADDRESSKeyReleased

        int position = SCHOOLADDRESS.getCaretPosition();
        SCHOOLADDRESS.setText( SCHOOLADDRESS.getText().toUpperCase());
        SCHOOLADDRESS.setCaretPosition(position);
    }//GEN-LAST:event_SCHOOLADDRESSKeyReleased

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void ONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ONEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ONEActionPerformed

    private void TWOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TWOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TWOActionPerformed

    private void CANCEL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCEL1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_CANCEL1ActionPerformed

    public boolean verifyText()
    {
        
        if (schoolyr.getSelectedItem().equals("") || LRN.getSelectedItem().toString().equals("") || PSA.getText().equals("") || LRNNO.getText().equals("") ||  ST_LNAME.getText().equals("") ||  ST_FNAME.getText().equals("") ||  ST_MDNAME.getText().equals("") ||  ST_EXNAME.getText().equals("") ||  jDateChooser1.getDate() == null ||  YES_IPSPECIFY.getText().equals("") ||  MOTHERTONGUE.getText().equals("") ||  ADDRESS.getText().equals("") ||  ZIPCODE.getText().equals("") ||  FATHER_LNAME.getText().equals("") ||  FATHER_FNAME.getText().equals("") ||  FATHER_MDNAME.getText().equals("") ||  MOTHER_LNAME.getText().equals("") ||  MOTHER_FNAME.getText().equals("") ||  MOTHER_MDNAME.getText().equals("") ||  GUARD_LNAME.getText().equals("") ||  GUARD_FNAME.getText().equals("") ||  GUARD_MDNAME.getText().equals("") ||  TELNO.getText().equals("") ||  CELPHONE.getText().equals("") || LEVELCOMPLETED.getSelectedItem().equals("") || SYCOMPLETED.getText().equals("") ||  SCHOOLNAME.getText().equals("") || SCHOOLID.getText().equals("") || SCHOOLADDRESS.getText().equals("") || TRACK.getSelectedItem().equals("") || STRAND.getSelectedItem().equals(""))

        
        {
            
            JOptionPane.showMessageDialog(this," Failed...!!! One or More Empty");
            
            return false;
            
        }else if(jDateChooser1.getDate().compareTo(new Date()) > 0) {
            
            JOptionPane.showMessageDialog(this, "Failed...!!!, Please Check the Year of Birth Date, Present Year is not Allowed");
            
            return false;
            
            
        } else {
            
             return true;
        }
     
        
    }
    
  
    
    
    
    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        //

        SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String lrn = LRN.getSelectedItem().toString();
        String psa =PSA.getText();
        String lrnno=LRNNO.getText();
        String lname=ST_LNAME.getText();
        String fname =ST_FNAME.getText();
        String mdname=ST_MDNAME.getText();
        String exname =ST_EXNAME.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = dateFormat.format(jDateChooser1.getDate());

        String age=AGE.getText();
        String gender = "male";
        if (female.isSelected()) {
            gender="female";
        }

        String ip = "no";
        if (yes.isSelected()) {
            ip="yes";
        }

        String ipstat=YES_IPSPECIFY.getText();
        String mothertong=MOTHERTONGUE.getText();
        String add= ADDRESS.getText();
        String zip=ZIPCODE.getText();
        String flname=FATHER_LNAME.getText();
        String ffnmae=FATHER_FNAME.getText();
        String fmdname=FATHER_MDNAME.getText();
        String mlname=MOTHER_LNAME.getText();
        String mfname=MOTHER_FNAME.getText();
        String mmdname=MOTHER_MDNAME.getText();
        String glnamae=GUARD_LNAME.getText();
        String gfname=GUARD_FNAME.getText();
        String gmdname=GUARD_MDNAME.getText();
        String tel=TELNO.getText();
        String cp=CELPHONE.getText();
        String levelcompleted = LEVELCOMPLETED.getSelectedItem().toString();
        String sycompleted=SYCOMPLETED.getText();
        String schoolname = SCHOOLNAME.getText();
        String schoolid = SCHOOLID.getText();
        String schooladdress = SCHOOLADDRESS.getText();
        String sem = "TWO";
        if (TWO.isSelected()) {
            sem = "TWO";
        }

        String track=TRACK.getSelectedItem().toString();
        String strand=STRAND.getSelectedItem().toString();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
            PreparedStatement ps;
            ps=Mycon.prepareStatement("insert into balikaral_shs (school_year_id, lrnStatus, psa, lrnNumber, s_lname, s_fname, s_mname, s_extension, bdate, sex, age, ip, ip_status, mother_tongue, address, zip_code, f_lname, f_fname, f_mname, m_lname, m_fname, m_mname, g_lname, g_fname, g_mname, telephone, cellphone, last_grade_level_completed, last_school_year_completed, school_name, school_id, school_address, semester, track, strand, timestamp) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, sy.id);
            ps.setString(2,lrn);
            ps.setString(3,psa);
            ps.setString(4,lrnno);
            ps.setString(5, lname);
            ps.setString(6, fname);
            ps.setString(7, mdname);
            ps.setString(8, exname);
            ps.setString(9, date);
            ps.setString(10, gender);
            ps.setString(11, age);
            ps.setString(12, ip);
            ps.setString(13, ipstat);
            ps.setString(14, mothertong);
            ps.setString(15, add);
            ps.setString(16, zip);
            ps.setString(17, flname);
            ps.setString(18, ffnmae);
            ps.setString(19, fmdname);
            ps.setString(20, mlname);
            ps.setString(21, mfname);
            ps.setString(22, mmdname);
            ps.setString(23, glnamae);
            ps.setString(24, gfname);
            ps.setString(25, gmdname);
            ps.setString(26, tel);
            ps.setString(27, cp);
            ps.setString(28, levelcompleted);
            ps.setString(29, sycompleted);
            ps.setString(30, schoolname);
            ps.setString(31, schoolid);
            ps.setString(32, schooladdress);
            ps.setString(33, sem);
            ps.setString(34, track);
            ps.setString(35, strand);
            ps.setString(36,timestamp );

            //ps.execute();

            //  JOptionPane.showMessageDialog(null, "Successfully Added");
            if (verifyText()) {

                ps.execute();

                schoolyr.setSelectedIndex(-1);
                LRN.setSelectedIndex(-1);
                PSA.setText("N/A");
                LRNNO.setText("N/A");
                ST_LNAME.setText("");
                ST_FNAME.setText("");
                ST_MDNAME.setText("");
                ST_EXNAME.setText("e.g. Jr., II, III (if applicable)");

              // java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(");
               //jDateChooser1.setDate(date2);

                male.setSelected(true);
                female.setSelected(true);

                no.setSelected(false);
                yes.setSelected(false);

                AGE.setText("");
                YES_IPSPECIFY.setText("N/A");
                MOTHERTONGUE.setText("N/A");
                ADDRESS.setText("");
                ZIPCODE.setText("0000000000");
                FATHER_LNAME.setText("");
                FATHER_FNAME.setText("");
                FATHER_MDNAME.setText("");
                MOTHER_LNAME.setText("");
                MOTHER_FNAME.setText("");
                MOTHER_MDNAME.setText("");
                GUARD_LNAME.setText("");
                GUARD_FNAME.setText("");
                GUARD_MDNAME.setText("");
                TELNO.setText("(00) 000 0000");
                CELPHONE.setText("+63");
                LEVELCOMPLETED.setSelectedIndex(-1);
                SYCOMPLETED.setText("yyyy-yyyy");
                SCHOOLNAME.setText("");
                SCHOOLID.setText("");
                SCHOOLADDRESS.setText("");
                TRACK.setSelectedIndex(-1);
                STRAND.setSelectedIndex(-1);

                JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");
                table_update();
            }

            // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

        } catch (ClassNotFoundException  ex) {
            Logger.getLogger(RegistrationLogin.class.getName()).log(Level.SEVERE, null, ex);
        }catch ( SQLException ex) {
            Logger.getLogger(RegistrationLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ADDActionPerformed

    private void jPanel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel model2 =  (DefaultTableModel)jTable1.getModel() ;
         int selecIndex = jTable1.getSelectedRow();
         
         schoolyr.setSelectedItem(model2.getValueAt(selecIndex, 0).toString() );
         LRN.setSelectedItem(model2.getValueAt(selecIndex, 1).toString() );
         LRNNO.setText(model2.getValueAt(selecIndex, 2).toString());
         ST_LNAME.setText(model2.getValueAt(selecIndex, 3).toString());
         ST_FNAME.setText(model2.getValueAt(selecIndex, 4).toString());
         PSA.setText(model2.getValueAt(selecIndex, 5).toString());
         PSA.setText(model2.getValueAt(selecIndex, 6).toString());
         ST_MDNAME.setText(model2.getValueAt(selecIndex, 7).toString());
         ST_EXNAME.setText(model2.getValueAt(selecIndex, 8).toString());
      // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
     //   String date = dateFormat.format(jDateChooser1.getDate());
      //      date.setDate(model2.getValueAt(selecIndex, 10).toString());
         
      
      Date bdate;
        
        try {
            
            bdate=new SimpleDateFormat("yyyy/MM/dd").parse(model2.getValueAt(selecIndex, 9).toString());
            jDateChooser1.setDate(bdate);
            
        } catch (ParseException ex) {
            Logger.getLogger(EDIT_SEARCH.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
      //int selecIndex = jTable1.getSelectedRow();
        
        if (model2.getValueAt(selecIndex, 10).toString().equals("male")) {
            
            male.setSelected(true);
            female.setSelected(false);
            
        }else {
            
            female.setSelected(true);
            male.setSelected(false);
            
        }
        
        AGE.setText(model2.getValueAt(selecIndex, 11).toString());
        
         if (model2.getValueAt(selecIndex, 12).toString().equals("no")) {
            
            no.setSelected(true);
            yes.setSelected(false);
        }else {
            
            yes.setSelected(true);
            no.setSelected(false);
        }
         
                YES_IPSPECIFY.setText(model2.getValueAt(selecIndex, 13).toString());
                MOTHERTONGUE.setText(model2.getValueAt(selecIndex, 14).toString());
                ADDRESS.setText(model2.getValueAt(selecIndex, 15).toString());
                ZIPCODE.setText(model2.getValueAt(selecIndex, 16).toString());
                FATHER_LNAME.setText(model2.getValueAt(selecIndex, 17).toString());
                FATHER_FNAME.setText(model2.getValueAt(selecIndex, 18).toString());
                FATHER_MDNAME.setText(model2.getValueAt(selecIndex, 19).toString());
                MOTHER_LNAME.setText(model2.getValueAt(selecIndex, 20).toString());
                MOTHER_FNAME.setText(model2.getValueAt(selecIndex, 21).toString());
                MOTHER_MDNAME.setText(model2.getValueAt(selecIndex, 22).toString());
                GUARD_LNAME.setText(model2.getValueAt(selecIndex, 23).toString());
                GUARD_FNAME.setText(model2.getValueAt(selecIndex, 24).toString());
                GUARD_MDNAME.setText(model2.getValueAt(selecIndex, 25).toString());
                TELNO.setText(model2.getValueAt(selecIndex, 26).toString());
                CELPHONE.setText(model2.getValueAt(selecIndex, 27).toString());
                LEVELCOMPLETED.setSelectedItem(model2.getValueAt(selecIndex, 28).toString() );
                SYCOMPLETED.setText(model2.getValueAt(selecIndex, 29).toString());
                SCHOOLNAME.setText(model2.getValueAt(selecIndex, 30).toString());
                SCHOOLID.setText(model2.getValueAt(selecIndex, 31).toString());
                SCHOOLADDRESS.setText(model2.getValueAt(selecIndex, 32).toString());
                TRACK.setSelectedItem(model2.getValueAt(selecIndex, 33).toString() );
                STRAND.setSelectedItem(model2.getValueAt(selecIndex, 34).toString() );
         
         
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(EDIT_SEARCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EDIT_SEARCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EDIT_SEARCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EDIT_SEARCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EDIT_SEARCH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField ADDRESS;
    private javax.swing.JTextField AGE;
    private javax.swing.JButton CANCEL;
    private javax.swing.JButton CANCEL1;
    private javax.swing.JButton CANCEL4;
    private javax.swing.JTextField CELPHONE;
    private javax.swing.JTextField FATHER_FNAME;
    private javax.swing.JTextField FATHER_LNAME;
    private javax.swing.JTextField FATHER_MDNAME;
    private javax.swing.JTextField GUARD_FNAME;
    private javax.swing.JTextField GUARD_LNAME;
    private javax.swing.JTextField GUARD_MDNAME;
    private javax.swing.JComboBox<String> LEVELCOMPLETED;
    private javax.swing.JComboBox<String> LRN;
    private javax.swing.JTextField LRNNO;
    private javax.swing.JTextField MOTHERTONGUE;
    private javax.swing.JTextField MOTHER_FNAME;
    private javax.swing.JTextField MOTHER_LNAME;
    private javax.swing.JTextField MOTHER_MDNAME;
    private javax.swing.JCheckBox ONE;
    private javax.swing.JTextField PSA;
    private javax.swing.JTextField SCHOOLADDRESS;
    private javax.swing.JTextField SCHOOLID;
    private javax.swing.JTextField SCHOOLNAME;
    private javax.swing.JComboBox<String> STRAND;
    private javax.swing.JTextField ST_EXNAME;
    private javax.swing.JTextField ST_FNAME;
    private javax.swing.JTextField ST_LNAME;
    private javax.swing.JTextField ST_MDNAME;
    private javax.swing.JTextField SYCOMPLETED;
    private javax.swing.JTextField TELNO;
    private javax.swing.JComboBox<String> TRACK;
    private javax.swing.JCheckBox TWO;
    private javax.swing.JTextField YES_IPSPECIFY;
    private javax.swing.JTextField ZIPCODE;
    private javax.swing.JCheckBox female;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JCheckBox male;
    private javax.swing.JCheckBox no;
    private javax.swing.JComboBox schoolyr;
    public static javax.swing.JTextField username;
    private javax.swing.JCheckBox yes;
    // End of variables declaration//GEN-END:variables
}
