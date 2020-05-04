/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author GOD
 */
public class Student_Frame extends javax.swing.JFrame {

    /**
     * Creates new form mainframe
     */
    public Student_Frame() {
        initComponents();
        
        Component [] components = this.getContentPane().getComponents();
        
        for (Component component : components) {
            
            
            if (component instanceof JButton) 
            
            {
                
                ((JButton) component).setUI(new BasicButtonUI());
                
            }
            
        }
        
        
       ButtonGroup bg = new ButtonGroup();
        bg.add(Male);
        bg.add(Female);
        
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(No);
        bg2.add(Yes);
        
         ButtonGroup bg3 = new ButtonGroup();
        bg3.add(One);
        bg3.add(Two);
        bg3.add(None);
 
         schoolyear2();
         
        jScrollPane1.setFocusable(true);
        
        
        
        
        
        
        
        
        
        
      //SomeWindow();
      //  makeFrameFullSize(this);
    }
    
    
    
    
    Connection Mycon;
    
    
    
    
    
    
    
    
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

        
        private void schoolyear2()
                
                
        {
            
           
              try {

                Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from school_year");
               ResultSet rs= ps.executeQuery();
                schoolyr.removeAllItems();
                
                
                
                
                while (rs.next())
                
                {
                    
                    
                     schoolyr.addItem(new SchoolYear2(rs.getInt(1),rs.getString(2)));
                    
                }
                

               
            }catch (ClassNotFoundException  ex) {
                Logger.getLogger(Student_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }catch ( SQLException ex) {
                Logger.getLogger(Student_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
            
        }
    
    
    
    
   
    
      public boolean verifyText()
    {
        
        if (schoolyr.getSelectedItem().equals("") || LRN.getSelectedItem().toString().equals("") || STUDENT_ACCOUNT.getText().equals("") || LRNNO.getText().equals("") ||  STUDENTNAME.getText().equals("") ||   jDateChooser1.getDate() == null  ||  YES_IPSPECIFY.getText().equals("") ||  MOTHERTONGUE.getText().equals("") ||  ADDRESS.getText().equals("") ||  ZIPCODE.getText().equals("") ||  FATHERNAME.getText().equals("") ||  MOTHERNAME.getText().equals("") ||  GUARDIAN.getText().equals("") ||  TELNO.getText().equals("") ||  CELPHONE.getText().equals("") || LEVELCOMPLETED.getSelectedItem().equals("") || SYCOMPLETED.getText().equals("") ||  SCHOOLNAME.getText().equals("") || SCHOOLID.getText().equals("") || SCHOOLADDRESS.getText().equals("") || TRACK.getSelectedItem().equals("") || STRAND.getSelectedItem().equals(""))

        
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
//    private void makeFrameFullSize(JFrame aFrame) {
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    aFrame.setSize(screenSize.width, screenSize.height);
//    
//        System.out.println(aFrame);
//}
//   
    
//    private int windowWidth = 1600;
//private int windowHeight =1000;
//
//public void SomeWindow() {
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    this.setSize(windowWidth, windowHeight);
//    this.setResizable(false);
//   // this.setLocation(0,0);
//    this.setVisible(true);
//}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        usernamedesk = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        MOTHERTONGUE = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        YES_IPSPECIFY = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Yes = new javax.swing.JCheckBox();
        No = new javax.swing.JCheckBox();
        Female = new javax.swing.JCheckBox();
        Male = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        ADDRESS = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        STUDENT_ACCOUNT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        LRN = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        schoolyr = new javax.swing.JComboBox();
        jPanel23 = new javax.swing.JPanel();
        ZIPCODE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        AGE1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel43 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        STUDENTNAME = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        LRNNO = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        LEVELCOMPLETED = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        SYCOMPLETED = new javax.swing.JFormattedTextField();
        jLabel51 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        SCHOOLADDRESS = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        SCHOOLID = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        SCHOOLNAME = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        GRADELEVEL = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        TRACK = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        Two = new javax.swing.JCheckBox();
        One = new javax.swing.JCheckBox();
        jLabel47 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        MOTHERNAME = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        FATHERNAME = new javax.swing.JTextField();
        GRADE_LEVEL = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        STRAND = new javax.swing.JComboBox();
        jPanel27 = new javax.swing.JPanel();
        TELNO = new javax.swing.JFormattedTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        GUARDIAN = new javax.swing.JTextField();
        None = new javax.swing.JCheckBox();
        jLabel39 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        TRACK_ENROLLED = new javax.swing.JComboBox();
        TRACK_STRAND = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        CELPHONE = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        ADD = new javax.swing.JButton();
        CANCEL = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(253, 253, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(43, 70, 60));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 70));

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/s.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setFocusPainted(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/sh.png"))); // NOI18N
        jButton5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/sh.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(104, 143, 78));

        jTextField1.setBackground(new java.awt.Color(104, 143, 78));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5))
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(43, 70, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/sdfdf.png"))); // NOI18N

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/home/default.png"))); // NOI18N
        home.setBorder(null);
        home.setFocusPainted(false);
        home.setFocusTraversalPolicyProvider(true);
        home.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/home/hover.png"))); // NOI18N
        home.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/home/hover.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/STUDENT/default.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setFocusPainted(false);
        jButton2.setFocusTraversalPolicyProvider(true);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/STUDENT/hover.png"))); // NOI18N
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/STUDENT/hover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CASHIER/default.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setFocusPainted(false);
        jButton3.setFocusTraversalPolicyProvider(true);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CASHIER/hover.png"))); // NOI18N
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CASHIER/hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/default.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setFocusPainted(false);
        jButton4.setFocusTraversalPolicyProvider(true);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/hover.png"))); // NOI18N
        jButton4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/hover.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        usernamedesk.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usernamedesk.setForeground(new java.awt.Color(255, 255, 255));
        usernamedesk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernamedesk.setText("Name");

        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("All Rights Reserved 2020");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(usernamedesk, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernamedesk, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2)
                .addGap(0, 0, 0)
                .addComponent(jButton3)
                .addGap(0, 0, 0)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(44, 44, 44))
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setBackground(new java.awt.Color(244, 241, 233));
        jTabbedPane1.setForeground(new java.awt.Color(102, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Eras Medium ITC", 1, 24)); // NOI18N
        jTabbedPane1.addTab("   Student Information", jTabbedPane2);

        jPanel8.setBackground(new java.awt.Color(177, 209, 130));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.yellow, java.awt.Color.darkGray));

        jPanel9.setBackground(new java.awt.Color(177, 209, 130));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(MOTHERTONGUE, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MOTHERTONGUE, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(56, 74, 19));
        jLabel49.setText("Mother Tongue:");

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(YES_IPSPECIFY, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(YES_IPSPECIFY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(56, 74, 19));
        jLabel18.setText("If Yes, please specify :");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(56, 74, 19));
        jLabel17.setText("Indigenous People (IP) :");

        Yes.setBackground(new java.awt.Color(177, 209, 130));
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

        No.setBackground(new java.awt.Color(177, 209, 130));
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

        Female.setBackground(new java.awt.Color(177, 209, 130));
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

        Male.setBackground(new java.awt.Color(177, 209, 130));
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

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(56, 74, 19));
        jLabel35.setText("Gender :");

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(ADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ADDRESS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(jLabel37.getFont().deriveFont(jLabel37.getFont().getStyle() | java.awt.Font.BOLD, jLabel37.getFont().getSize()+8));
        jLabel37.setForeground(new java.awt.Color(56, 74, 19));
        jLabel37.setText("Address:");

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Province");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Municipality/City");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(STUDENT_ACCOUNT, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STUDENT_ACCOUNT, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(56, 74, 19));
        jLabel6.setText("Student Account Number:");

        LRN.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LRN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No LRN", "With LRN", "No LRN - Balik Aral", "With LRN Balik Aral" }));

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(56, 74, 19));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Please Select below: ");

        schoolyr.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ZIPCODE, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZIPCODE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 74, 19));
        jLabel5.setText("School Year:");

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(jLabel44.getFont().deriveFont(jLabel44.getFont().getStyle() | java.awt.Font.BOLD, jLabel44.getFont().getSize()+8));
        jLabel44.setForeground(new java.awt.Color(56, 74, 19));
        jLabel44.setText("Zip Code:");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(43, 70, 60));
        jTextField2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(244, 241, 233));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("BASIC  EDUCATION  ENROLLMENT FORM");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Street");

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Barangay");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(56, 74, 19));
        jLabel22.setText("Age:");

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        AGE1.setBackground(new java.awt.Color(255, 255, 255));
        AGE1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AGE1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AGE1.setBorder(null);
        AGE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AGE1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AGE1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AGE1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jDateChooser1.setBackground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setForeground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(56, 74, 19));
        jLabel43.setText("Date of Birth:");

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(STUDENTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STUDENTNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(jLabel15.getFont().deriveFont(jLabel15.getFont().getStyle() | java.awt.Font.BOLD, jLabel15.getFont().getSize()+8));
        jLabel15.setForeground(new java.awt.Color(56, 74, 19));
        jLabel15.setText("Student's Name :");

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LRNNO, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LRNNO, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(56, 74, 19));
        jLabel25.setText("Learner's Reference No. (LRN):  ");

        LEVELCOMPLETED.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LEVELCOMPLETED.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(jLabel50.getFont().deriveFont(jLabel50.getFont().getStyle() | java.awt.Font.BOLD, jLabel50.getFont().getSize()+8));
        jLabel50.setForeground(new java.awt.Color(56, 74, 19));
        jLabel50.setText("School Name:");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Street");

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Barangay");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Municipality/City");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Province");

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(jLabel52.getFont().deriveFont(jLabel52.getFont().getStyle() | java.awt.Font.BOLD, jLabel52.getFont().getSize()+8));
        jLabel52.setForeground(new java.awt.Color(56, 74, 19));
        jLabel52.setText("Last School Year Completed:");

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SYCOMPLETED, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SYCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(jLabel51.getFont().deriveFont(jLabel51.getFont().getStyle() | java.awt.Font.BOLD, jLabel51.getFont().getSize()+8));
        jLabel51.setForeground(new java.awt.Color(56, 74, 19));
        jLabel51.setText("Last Grade Level Completed:");

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(SCHOOLADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(jLabel54.getFont().deriveFont(jLabel54.getFont().getStyle() | java.awt.Font.BOLD, jLabel54.getFont().getSize()+8));
        jLabel54.setForeground(new java.awt.Color(56, 74, 19));
        jLabel54.setText("School Address:");

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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
        SCHOOLID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SCHOOLIDKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(SCHOOLID, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLID, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(jLabel53.getFont().deriveFont(jLabel53.getFont().getStyle() | java.awt.Font.BOLD, jLabel53.getFont().getSize()+8));
        jLabel53.setForeground(new java.awt.Color(56, 74, 19));
        jLabel53.setText("School Id:");

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(SCHOOLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel33Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(GRADELEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GRADELEVEL, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(43, 70, 60));
        jTextField17.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(244, 241, 233));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("PARENT'S / GUARDIAN'S INFORMATION");
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(jLabel56.getFont().deriveFont(jLabel56.getFont().getStyle() | java.awt.Font.BOLD, jLabel56.getFont().getSize()+8));
        jLabel56.setForeground(new java.awt.Color(56, 74, 19));
        jLabel56.setText("Strand:");

        TRACK.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TRACK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ACADEMIC", "TECHNICAL-VOCATIONAL" }));

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(jLabel55.getFont().deriveFont(jLabel55.getFont().getStyle() | java.awt.Font.BOLD, jLabel55.getFont().getSize()+8));
        jLabel55.setForeground(new java.awt.Color(56, 74, 19));
        jLabel55.setText("Track:");

        Two.setBackground(new java.awt.Color(177, 209, 130));
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

        One.setBackground(new java.awt.Color(177, 209, 130));
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

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(jLabel47.getFont().deriveFont(jLabel47.getFont().getStyle() | java.awt.Font.BOLD, jLabel47.getFont().getSize()+8));
        jLabel47.setForeground(new java.awt.Color(56, 74, 19));
        jLabel47.setText("Semester:");

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(MOTHERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MOTHERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(jLabel38.getFont().deriveFont(jLabel38.getFont().getStyle() | java.awt.Font.BOLD, jLabel38.getFont().getSize()+8));
        jLabel38.setForeground(new java.awt.Color(56, 74, 19));
        jLabel38.setText("Mother's Name:");

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(FATHERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FATHERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        GRADE_LEVEL.setBackground(new java.awt.Color(255, 255, 255));
        GRADE_LEVEL.setFont(GRADE_LEVEL.getFont().deriveFont(GRADE_LEVEL.getFont().getStyle() | java.awt.Font.BOLD, GRADE_LEVEL.getFont().getSize()+8));
        GRADE_LEVEL.setForeground(new java.awt.Color(56, 74, 19));
        GRADE_LEVEL.setText("Grade Level :");

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(jLabel36.getFont().deriveFont(jLabel36.getFont().getStyle() | java.awt.Font.BOLD, jLabel36.getFont().getSize()+8));
        jLabel36.setForeground(new java.awt.Color(56, 74, 19));
        jLabel36.setText("Father's Name:");

        STRAND.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        STRAND.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ABM", "GAS", "HUMMS", "CCS", "CSS", "EIM", "FOS", "FBS", "HOUSE KEEPING", "BEAUTY NAILCARE" }));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TELNO, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TELNO, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(jLabel45.getFont().deriveFont(jLabel45.getFont().getStyle() | java.awt.Font.BOLD, jLabel45.getFont().getSize()+8));
        jLabel45.setForeground(new java.awt.Color(56, 74, 19));
        jLabel45.setText("Tellephone Number:");

        jTextField24.setEditable(false);
        jTextField24.setBackground(new java.awt.Color(43, 70, 60));
        jTextField24.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField24.setForeground(new java.awt.Color(244, 241, 233));
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setText("Grade Level Enrolled");
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(GUARDIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GUARDIAN, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        None.setBackground(new java.awt.Color(177, 209, 130));
        None.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        None.setForeground(new java.awt.Color(43, 70, 60));
        None.setText("None");
        None.setBorder(null);
        None.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        None.setInheritsPopupMenu(true);
        None.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoneActionPerformed(evt);
            }
        });

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(jLabel39.getFont().deriveFont(jLabel39.getFont().getStyle() | java.awt.Font.BOLD, jLabel39.getFont().getSize()+8));
        jLabel39.setForeground(new java.awt.Color(56, 74, 19));
        jLabel39.setText("Guardian's Name:");

        jTextField23.setEditable(false);
        jTextField23.setBackground(new java.awt.Color(43, 70, 60));
        jTextField23.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(244, 241, 233));
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setText("For Learners in Senior High School");
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        TRACK_ENROLLED.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TRACK_ENROLLED.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Academic - ABM", "Academic - GAS", "Academic - HUMMS", "Tech Voc - CCS", "Tech Voc - CSS", "Tech Voc - EIM", "Tech Voc - FOS", "Tech Voc - FBS", "Tech Voc - HOUSE KEEPING", "Tech Voc - BEAUTY NAILCARE" }));

        TRACK_STRAND.setBackground(new java.awt.Color(255, 255, 255));
        TRACK_STRAND.setFont(TRACK_STRAND.getFont().deriveFont(TRACK_STRAND.getFont().getStyle() | java.awt.Font.BOLD, TRACK_STRAND.getFont().getSize()+8));
        TRACK_STRAND.setForeground(new java.awt.Color(56, 74, 19));
        TRACK_STRAND.setText("Track :");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(43, 70, 60));
        jTextField3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(244, 241, 233));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("For Returning Learners (Balik - Aral / Repeater) and Those Who are Transferee");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CELPHONE, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CELPHONE, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(jLabel46.getFont().deriveFont(jLabel46.getFont().getStyle() | java.awt.Font.BOLD, jLabel46.getFont().getSize()+8));
        jLabel46.setForeground(new java.awt.Color(56, 74, 19));
        jLabel46.setText("Cellphone Number:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField17)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel46)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(103, 103, 103))
            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 1309, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(LEVELCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53)
                                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(128, 128, 128))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
            .addComponent(jTextField23)
            .addComponent(jTextField24)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(One)
                            .addGap(113, 113, 113)
                            .addComponent(Two)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(None))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel55))
                            .addGap(92, 92, 92)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel56)
                                .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GRADE_LEVEL)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TRACK_ENROLLED, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRACK_STRAND))
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(160, 160, 160)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel42)
                        .addComponent(LRN, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(210, 210, 210))
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(162, 162, 162)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addGap(218, 218, 218))
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(64, 64, 64)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(110, 110, 110)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(101, 101, 101)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel35)
                                                .addGroup(jPanel9Layout.createSequentialGroup()
                                                    .addComponent(Male)
                                                    .addGap(28, 28, 28)
                                                    .addComponent(Female))
                                                .addGroup(jPanel9Layout.createSequentialGroup()
                                                    .addComponent(No)
                                                    .addGap(45, 45, 45)
                                                    .addComponent(Yes))
                                                .addComponent(jLabel17))
                                            .addGap(33, 33, 33)
                                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel43)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18)
                                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(55, 55, 55)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel44)
                                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel49)
                                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addContainerGap(209, Short.MAX_VALUE))
                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(863, 863, 863)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(94, 94, 94)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LEVELCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(One, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Two, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(None, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84)
                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GRADE_LEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRACK_STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TRACK_ENROLLED, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel42))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LRN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(64, 64, 64)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(jLabel35)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Male, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Female, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Yes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(51, 51, 51)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(4, 4, 4)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(1639, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel9);

        jPanel10.setBackground(new java.awt.Color(177, 209, 130));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.darkGray));

        ADD.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ADD.setForeground(new java.awt.Color(255, 0, 0));
        ADD.setText("S A V E");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        CANCEL.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        CANCEL.setForeground(new java.awt.Color(255, 0, 0));
        CANCEL.setText("C A N C E L");
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });

        CLEAR.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        CLEAR.setForeground(new java.awt.Color(255, 0, 0));
        CLEAR.setText("C L E A R");
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1312, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("   Add Student Info.", jPanel8);

        jPanel12.setBackground(new java.awt.Color(203, 220, 139));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1312, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("   Edit Student Info.", jPanel11);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void MOTHERTONGUEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERTONGUEFocusGained

        if(MOTHERTONGUE.getText().trim().equals("None"))
        {
            MOTHERTONGUE.setText("");
            MOTHERTONGUE.setForeground(Color.black);
        }
    }//GEN-LAST:event_MOTHERTONGUEFocusGained

    private void MOTHERTONGUEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERTONGUEFocusLost

        if(MOTHERTONGUE.getText().trim().equals(""))
        {
            MOTHERTONGUE.setText("None");
            MOTHERTONGUE.setForeground( Color.black);
        }
    }//GEN-LAST:event_MOTHERTONGUEFocusLost

    private void MOTHERTONGUEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MOTHERTONGUEKeyReleased

        //        int position = MOTHERTONGUE.getCaretPosition();
        //        MOTHERTONGUE.setText(MOTHERTONGUE.getText().toUpperCase());
        //        MOTHERTONGUE.setCaretPosition(position);
    }//GEN-LAST:event_MOTHERTONGUEKeyReleased

    private void YES_IPSPECIFYFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYFocusGained

        if(  YES_IPSPECIFY.getText().trim().equals("Please Specify. . ."))
        {
            YES_IPSPECIFY.setText("");
            YES_IPSPECIFY.setForeground(Color.black);
        }
    }//GEN-LAST:event_YES_IPSPECIFYFocusGained

    private void YES_IPSPECIFYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYFocusLost
        if( YES_IPSPECIFY.getText().trim().equals(""))
        {
            YES_IPSPECIFY.setText("Please Specify. . .");
            YES_IPSPECIFY.setForeground( Color.black);
        }
    }//GEN-LAST:event_YES_IPSPECIFYFocusLost

    private void YES_IPSPECIFYKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YES_IPSPECIFYKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_YES_IPSPECIFYKeyReleased

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

    private void ADDRESSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ADDRESSFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSFocusGained

    private void ADDRESSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ADDRESSFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSFocusLost

    private void ADDRESSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADDRESSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSKeyReleased

    private void STUDENT_ACCOUNTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTFocusGained

        if( STUDENT_ACCOUNT.getText().trim().equals("None"))
        {
            STUDENT_ACCOUNT.setText("");
            STUDENT_ACCOUNT.setForeground(Color.black);
        }
    }//GEN-LAST:event_STUDENT_ACCOUNTFocusGained

    private void STUDENT_ACCOUNTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTFocusLost

        if ( STUDENT_ACCOUNT.getText().trim().isEmpty()) {
            STUDENT_ACCOUNT.setForeground(new Color(51,51,51));
            STUDENT_ACCOUNT.setText("None");
        }
    }//GEN-LAST:event_STUDENT_ACCOUNTFocusLost

    private void STUDENT_ACCOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STUDENT_ACCOUNTActionPerformed

    private void STUDENT_ACCOUNTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTKeyPressed

    }//GEN-LAST:event_STUDENT_ACCOUNTKeyPressed

    private void ZIPCODEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ZIPCODEFocusGained

        if( ZIPCODE.getText().trim().equals("0000"))
        {
            ZIPCODE.setText("");
            ZIPCODE.setForeground(Color.black);
        }
    }//GEN-LAST:event_ZIPCODEFocusGained

    private void ZIPCODEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ZIPCODEFocusLost
        if(ZIPCODE.getText().trim().equals(""))
        {
            ZIPCODE.setText("0000");
            ZIPCODE.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_ZIPCODEFocusLost

    private void ZIPCODEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZIPCODEKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) ) {

            evt.consume();

        }

        if (ZIPCODE.getText().length() >= 4 ) // limit to 3 characters
        evt.consume();
    }//GEN-LAST:event_ZIPCODEKeyTyped

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void AGE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AGE1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_AGE1KeyTyped

    private void STUDENTNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENTNAMEFocusGained

        if( STUDENTNAME.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            STUDENTNAME.setText("");
            STUDENTNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_STUDENTNAMEFocusGained

    private void STUDENTNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENTNAMEFocusLost

        if(STUDENTNAME.getText().trim().equals(""))
        {
            STUDENTNAME.setText("Last Name,  First Name   Middle Name");
            STUDENTNAME.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_STUDENTNAMEFocusLost

    private void STUDENTNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STUDENTNAMEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_STUDENTNAMEKeyReleased

    private void LRNNOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LRNNOFocusGained

        if(LRNNO.getText().trim().equals("None"))
        {
            LRNNO.setText("");
            LRNNO.setForeground(Color.black);
        }
    }//GEN-LAST:event_LRNNOFocusGained

    private void LRNNOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LRNNOFocusLost

        if (LRNNO.getText().trim().isEmpty()) {
            LRNNO.setForeground(Color.black);
            LRNNO.setText("None");
        }
    }//GEN-LAST:event_LRNNOFocusLost

    private void LRNNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LRNNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LRNNOActionPerformed

    private void LRNNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LRNNOKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {

            evt.consume();

        }

        if (LRNNO.getText().length() >= 12 ) // limit to 3 characters
        evt.consume();
    }//GEN-LAST:event_LRNNOKeyTyped

    private void SYCOMPLETEDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SYCOMPLETEDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SYCOMPLETEDKeyTyped

    private void SCHOOLADDRESSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLADDRESSFocusGained

        if( SCHOOLADDRESS.getText().trim().equals("None"))
        {
            SCHOOLADDRESS.setText("");
            SCHOOLADDRESS.setForeground(Color.black);
        }
    }//GEN-LAST:event_SCHOOLADDRESSFocusGained

    private void SCHOOLADDRESSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLADDRESSFocusLost
        if(SCHOOLADDRESS.getText().trim().equals(""))
        {
            SCHOOLADDRESS.setText("None");
            SCHOOLADDRESS.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_SCHOOLADDRESSFocusLost

    private void SCHOOLADDRESSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SCHOOLADDRESSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SCHOOLADDRESSKeyReleased

    private void SCHOOLIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLIDFocusGained

        if( SCHOOLID.getText().trim().equals("None"))
        {
            SCHOOLID.setText("");
            SCHOOLID.setForeground(Color.black);
        }
    }//GEN-LAST:event_SCHOOLIDFocusGained

    private void SCHOOLIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLIDFocusLost

        if(SCHOOLID.getText().trim().equals(""))
        {
            SCHOOLID.setText("None");
            SCHOOLID.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_SCHOOLIDFocusLost

    private void SCHOOLIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SCHOOLIDKeyTyped

        if (ZIPCODE.getText().length() >= 6 ) // limit to 3 characters
        evt.consume();
    }//GEN-LAST:event_SCHOOLIDKeyTyped

    private void SCHOOLNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLNAMEFocusGained

        if( SCHOOLNAME.getText().trim().equals("None"))
        {
            SCHOOLNAME.setText("");
            SCHOOLNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_SCHOOLNAMEFocusGained

    private void SCHOOLNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SCHOOLNAMEFocusLost

        if(SCHOOLNAME.getText().trim().equals(""))
        {
            SCHOOLNAME.setText("None");
            SCHOOLNAME.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_SCHOOLNAMEFocusLost

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

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void TwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TwoActionPerformed

    private void OneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OneActionPerformed

    private void MOTHERNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERNAMEFocusGained
        if(MOTHERNAME.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            MOTHERNAME.setText("");
            MOTHERNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_MOTHERNAMEFocusGained

    private void MOTHERNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MOTHERNAMEFocusLost
        if ( MOTHERNAME.getText().trim().isEmpty()) {
            MOTHERNAME.setForeground(new Color(51,51,51));
            MOTHERNAME.setText("Last Name,  First Name   Middle Name");
        }
    }//GEN-LAST:event_MOTHERNAMEFocusLost

    private void MOTHERNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MOTHERNAMEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_MOTHERNAMEKeyReleased

    private void FATHERNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FATHERNAMEFocusGained

        if(FATHERNAME.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            FATHERNAME.setText("");
            FATHERNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_FATHERNAMEFocusGained

    private void FATHERNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FATHERNAMEFocusLost

        if ( FATHERNAME.getText().trim().isEmpty()) {
            FATHERNAME.setForeground(new Color(51,51,51));
            FATHERNAME.setText("Last Name,  First Name   Middle Name");
        }
    }//GEN-LAST:event_FATHERNAMEFocusLost

    private void FATHERNAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FATHERNAMEKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FATHERNAMEKeyReleased

    private void TELNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TELNOKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TELNOKeyTyped

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void GUARDIANFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GUARDIANFocusGained
        if(GUARDIAN.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            GUARDIAN.setText("");
            GUARDIAN.setForeground(Color.black);
        }
    }//GEN-LAST:event_GUARDIANFocusGained

    private void GUARDIANFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GUARDIANFocusLost
        if(GUARDIAN.getText().trim().equals(""))
        {
            GUARDIAN.setText("Last Name,  First Name   Middle Name");
            GUARDIAN.setForeground( Color.black);
        }
    }//GEN-LAST:event_GUARDIANFocusLost

    private void GUARDIANKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GUARDIANKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_GUARDIANKeyReleased

    private void NoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoneActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void CELPHONEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CELPHONEKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) ) {

            evt.consume();

        }
    }//GEN-LAST:event_CELPHONEKeyTyped

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed

        SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String lrn = LRN.getSelectedItem().toString();
        String psa =STUDENT_ACCOUNT.getText();
        String lrnno=LRNNO.getText();
        String lname=STUDENTNAME.getText();

        //      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //        String date = dateFormat.format(jDateChooser1.getDate());

        String age=AGE1.getText();
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
        }else {

            sem = "None";

        }

        String track=TRACK.getSelectedItem().toString();
        String strand=STRAND.getSelectedItem().toString();

        String gradelevel = GRADELEVEL.getText();
        String trackenroll= TRACK_ENROLLED.getSelectedItem().toString();

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        //java.util.Date now = new java.util.Date();

        if (verifyText()) {

            try {

                //            Calendar cal = Calendar.getInstance();
                //            cal.getTime();
                //

                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/d");
                String dateString = String.valueOf(df.format(jDateChooser1.getDate()));
                Date myDate = df.parse(dateString);
                //

                java.util.Date utilDate = new java.util.Date(myDate.getTime());
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                //
                //            System.out.println(dateString);

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("insert into enrolled_students (school_year_id, lrnStatus, student_account_no, lrnNumber, fullname, bdate, sex, age, ip, ip_status, mother_tongue, address, zip_code, fathername, mothername, guardianname, telephone, cellphone, last_grade_level_completed, last_school_year_completed, school_name, school_id, school_address, semester, track, strand, grade_level, enrolled_track, timestamp) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, sy.id);
                ps.setString(2,lrn);
                ps.setString(3,psa);
                ps.setString(4,lrnno);
                ps.setString(5, lname);
                ps.setDate(6, (java.sql.Date) sqlDate);
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

                if (verifyText()) {

                    ps.execute();

                    schoolyr.setSelectedIndex(-1);
                    LRN.setSelectedIndex(-1);
                    STUDENT_ACCOUNT.setText("None");
                    LRNNO.setText("None");
                    STUDENTNAME.setText("Last Name,  First Name   Middle Name");

                    Male.setSelected(true);
                    Female.setSelected(true);

                    No.setSelected(false);
                    Yes.setSelected(false);

                    One.setSelected(false);
                    Two.setSelected(false);
                    None.setSelected(false);

                    AGE1.setText("");
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

                Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
            }catch ( SQLException ex) {

                Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
            }     catch (ParseException ex) {
                Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
            }   //catch (ParseException ex) {
            }
    }//GEN-LAST:event_ADDActionPerformed

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
        this.dispose();
    }//GEN-LAST:event_CANCELActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLEARActionPerformed

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
            java.util.logging.Logger.getLogger(Student_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField ADDRESS;
    private javax.swing.JTextField AGE1;
    private javax.swing.JButton CANCEL;
    private javax.swing.JFormattedTextField CELPHONE;
    private javax.swing.JButton CLEAR;
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
    private javax.swing.JCheckBox None;
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
    private javax.swing.JTextField YES_IPSPECIFY;
    private javax.swing.JCheckBox Yes;
    private javax.swing.JTextField ZIPCODE;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox schoolyr;
    public static javax.swing.JLabel usernamedesk;
    // End of variables declaration//GEN-END:variables
}
