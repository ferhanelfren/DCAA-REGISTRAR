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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author GOD
 */
public class Edit_Students_Info extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public Edit_Students_Info() {
        initComponents();
     table_update();

//        AutoCompleteComboBox();    
        schoolyear2();
        ButtonGroup bg = new ButtonGroup();
        bg.add(Male);
        bg.add(Female);
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(No);
        bg2.add(Yes);
        
       tableEditFormat();

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
                                           //select a.file_id, b.school_year_name, c.fullname, a.file_name, a.file_size_in_kb, a.file_extension, a.file_content, a.timestamp from insert_data_file a, enrolled_students c, school_year b  where a.school_year_id = b.id and a.enrolled_students_id = c.id
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
           
            
                                                jTable.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,18));
                                                jTable.getTableHeader().setOpaque(false);
                                                jTable.getTableHeader().setBackground(new Color(165,19,29));
                                                jTable.getTableHeader().setForeground(new Color(255,255,255));
                                                jTable.getRowHeight(20);
                                               
                                                
                                                    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)  jTable.getTableHeader().getDefaultRenderer();
                                                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                                                 jTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
                                                
                                                TableColumn col = jTable.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
                                                    dtcr.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col.setCellRenderer(dtcr);
                                                
                                                
                                                
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

                                              
                                                
                                                


       }
       
      public boolean verifyText()
    {
        
        if (schoolyr.getSelectedItem().toString().equals("")|| LRN.getSelectedItem().toString().equals("") || STUDENT_ACCOUNT1.getText().equals("") || LRNNO.getText().equals("") ||  STUDENTNAME.getText().equals("") ||   jDateChooser1.getDate() == null || AGE1.getText().equals("")    || YES_IPSPECIFY.getText().equals("") ||  MOTHERTONGUE.getText().equals("") ||  ADDRESS.getText().equals("") ||  ZIPCODE.getText().equals("") ||  FATHERNAME.getText().equals("") ||  MOTHERNAME.getText().equals("") ||  GUARDIAN.getText().equals("") ||  TELNO.getText().equals("") ||  CELPHONE.getText().equals("") || LEVELCOMPLETED.getSelectedItem().equals("") || SYCOMPLETED.getText().equals("") ||  SCHOOLNAME.getText().equals("") || SCHOOLID.getText().equals("") || SCHOOLADDRESS.getText().equals("") || TRACK.getSelectedItem().equals("") || STRAND.getSelectedItem().equals("") || GRADELEVEL.getText().equals("") || TRACK_ENROLLED.getSelectedItem().equals(""))

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
               String name="%"+this.search.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTable.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               ps = Mycon.prepareStatement("select * from enrolled_students where fullname LIKE '"+name+"'"); 
                         ResultSet rs= ps.executeQuery();
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23),rs.getString(24),rs.getString(25),rs.getString(26),rs.getString(27),rs.getString(28),rs.getString(29)});
                                }  
            }catch (ClassNotFoundException | SQLException  ex) {
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
        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        panel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        STUDENT_ACCOUNT1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        LRN = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        schoolyr = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        LRNNO = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        STUDENTNAME = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Female = new javax.swing.JCheckBox();
        Male = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        AGE1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel43 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        YES_IPSPECIFY = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Yes = new javax.swing.JCheckBox();
        No = new javax.swing.JCheckBox();
        jLabel49 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        MOTHERTONGUE = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        ADDRESS = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        FATHERNAME = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        MOTHERNAME = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        GUARDIAN = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        TELNO = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        CELPHONE = new javax.swing.JFormattedTextField();
        jLabel47 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        ZIPCODE = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel21 = new javax.swing.JPanel();
        LEVELCOMPLETED = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        SYCOMPLETED = new javax.swing.JFormattedTextField();
        jPanel44 = new javax.swing.JPanel();
        SCHOOLNAME = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        SCHOOLID = new javax.swing.JTextField();
        jPanel46 = new javax.swing.JPanel();
        SCHOOLADDRESS = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        TRACK = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        STRAND = new javax.swing.JComboBox();
        Semester = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        GRADE_LEVEL = new javax.swing.JLabel();
        TRACK_ENROLLED = new javax.swing.JComboBox();
        TRACK_STRAND = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        GRADELEVEL = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        CLEAR = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enrolled Student's");

        jPanel1.setBackground(new java.awt.Color(233, 240, 192));

        jPanel22.setBackground(new java.awt.Color(244, 241, 233));

        jTable.setAutoCreateRowSorter(true);
        jTable.setBackground(new java.awt.Color(253, 253, 255));
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

        panel.setBackground(new java.awt.Color(244, 241, 233));
        panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setForeground(new java.awt.Color(67, 21, 23));
        panel.setToolTipText("");
        panel.setAutoscrolls(true);
        panel.setFocusable(false);
        panel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        panel.setInheritsPopupMenu(true);

        jPanel3.setBackground(new java.awt.Color(244, 241, 233));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 51));
        jLabel25.setText("Learner's Reference No. (LRN):  ");

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        STUDENT_ACCOUNT1.setBackground(new java.awt.Color(255, 255, 255));
        STUDENT_ACCOUNT1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STUDENT_ACCOUNT1.setForeground(new java.awt.Color(0, 0, 0));
        STUDENT_ACCOUNT1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        STUDENT_ACCOUNT1.setText("None");
        STUDENT_ACCOUNT1.setBorder(null);
        STUDENT_ACCOUNT1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                STUDENT_ACCOUNT1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                STUDENT_ACCOUNT1FocusLost(evt);
            }
        });
        STUDENT_ACCOUNT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STUDENT_ACCOUNT1ActionPerformed(evt);
            }
        });
        STUDENT_ACCOUNT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                STUDENT_ACCOUNT1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(STUDENT_ACCOUNT1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STUDENT_ACCOUNT1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Student Account Number:");

        LRN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LRN.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No LRN", "With LRN", "No LRN - Balik Aral", "With LRN Balik Aral" }));
        LRN.setSelectedIndex(-1);

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 51, 51));
        jLabel42.setText("Please Select below: ");

        schoolyr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("School Year:");

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LRNNO, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LRNNO, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(STUDENTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STUDENTNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("Student's Name :");

        Female.setBackground(new java.awt.Color(244, 241, 233));
        Female.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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

        Male.setBackground(new java.awt.Color(244, 241, 233));
        Male.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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
        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 51, 51));
        jLabel35.setText("Gender :");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
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
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AGE1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(AGE1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDateChooser1.setBackground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jDateChooser1.setForeground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 51, 51));
        jLabel43.setText("Date of Birth:");

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
            .addGap(0, 469, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(YES_IPSPECIFY, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(YES_IPSPECIFY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 51));
        jLabel18.setText("If Yes, please specify :");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setText("Indigenous People (IP) :");

        Yes.setBackground(new java.awt.Color(244, 241, 233));
        Yes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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

        No.setBackground(new java.awt.Color(244, 241, 233));
        No.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 51, 51));
        jLabel49.setText("Mother Tongue:");

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel36Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(MOTHERTONGUE, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(138, Short.MAX_VALUE)))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MOTHERTONGUE, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(219, 219, 219)))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ADDRESS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 51, 51));
        jLabel37.setText("Address:");

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Province");

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Municipality/City");

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Street");

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 51));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Barangay");

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(FATHERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FATHERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 51, 51));
        jLabel36.setText("Father's Name:");

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 51, 51));
        jLabel38.setText("Mother's Name:");

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel39Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(MOTHERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MOTHERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 51, 51));
        jLabel39.setText("Guardian's Name:");

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel40Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(GUARDIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(58, Short.MAX_VALUE)))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GUARDIAN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
        );

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 51, 51));
        jLabel45.setText("Tellephone Number:");

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TELNO, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TELNO, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 51));
        jLabel46.setText("Cellphone Number:");

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        CELPHONE.setBackground(new java.awt.Color(255, 255, 255));
        CELPHONE.setBorder(null);
        CELPHONE.setColumns(12);
        CELPHONE.setForeground(new java.awt.Color(0, 0, 0));
        try {
            CELPHONE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-###-####")));
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

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CELPHONE, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CELPHONE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 51, 51));
        jLabel47.setText("Zip Code:");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel36))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel35)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(Male)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(Female)))
                                                .addGap(34, 34, 34))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(No)
                                                        .addGap(45, 45, 45)
                                                        .addComponent(Yes))
                                                    .addComponent(jLabel17))
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel43)
                                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(57, 57, 57))))
                                    .addComponent(jLabel15))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25)
                            .addComponent(jLabel42)
                            .addComponent(LRN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)))
                        .addGap(54, 54, 54))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LRN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Male, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Female, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Yes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        panel.addTab("Students Information", jPanel2);

        jPanel21.setBackground(new java.awt.Color(244, 241, 233));

        LEVELCOMPLETED.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LEVELCOMPLETED.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(56, 74, 19));
        jLabel51.setText("Last Grade Level Completed:");

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(56, 74, 19));
        jLabel52.setText("Last School Year Completed:");

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SYCOMPLETED, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SYCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(SCHOOLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(56, 74, 19));
        jLabel50.setText("School Name:");

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(56, 74, 19));
        jLabel53.setText("School Id:");

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel45Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(SCHOOLID, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLID, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SCHOOLADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(588, 588, 588)))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SCHOOLADDRESS, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(56, 74, 19));
        jLabel54.setText("School Address:");

        jLabel40.setForeground(new java.awt.Color(0, 102, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Barangay");

        jLabel28.setForeground(new java.awt.Color(0, 102, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Street");

        jLabel26.setForeground(new java.awt.Color(0, 102, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Municipality/City");

        jLabel24.setForeground(new java.awt.Color(0, 102, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Province");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(LEVELCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LEVELCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        panel.addTab("Balik - Aral / Repeater", jPanel5);

        jPanel27.setBackground(new java.awt.Color(244, 241, 233));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 51, 51));
        jLabel41.setText("Semester:");

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 51, 51));
        jLabel55.setText("Track:");

        TRACK.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TRACK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ACADEMIC", "TECHNICAL-VOCATIONAL" }));

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 51, 51));
        jLabel56.setText("Strand:");

        STRAND.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STRAND.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ABM", "GAS", "HUMMS", "CCS", "CSS", "EIM", "FOS", "FBS", "HOUSE KEEPING", "BEAUTY NAILCARE" }));

        Semester.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "1st Semester", "2nd Semester" }));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(Semester, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(178, 178, 178))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Semester, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TRACK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(172, Short.MAX_VALUE))
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

        jPanel28.setBackground(new java.awt.Color(244, 241, 233));

        GRADE_LEVEL.setBackground(new java.awt.Color(255, 255, 255));
        GRADE_LEVEL.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GRADE_LEVEL.setForeground(new java.awt.Color(0, 51, 51));
        GRADE_LEVEL.setText("Grade Level :");

        TRACK_ENROLLED.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TRACK_ENROLLED.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Academic - ABM", "Academic - GAS", "Academic - HUMMS", "Tech Voc - CCS", "Tech Voc - CSS", "Tech Voc - EIM", "Tech Voc - FOS", "Tech Voc - FBS", "Tech Voc - HOUSE KEEPING", "Tech Voc - BEAUTY NAILCARE" }));

        TRACK_STRAND.setBackground(new java.awt.Color(255, 255, 255));
        TRACK_STRAND.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TRACK_STRAND.setForeground(new java.awt.Color(0, 51, 51));
        TRACK_STRAND.setText("Track :");

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel47Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(GRADELEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GRADELEVEL, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TRACK_ENROLLED, 0, 324, Short.MAX_VALUE)
                    .addComponent(TRACK_STRAND)
                    .addComponent(GRADE_LEVEL)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(238, 238, 238))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(GRADE_LEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(TRACK_STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TRACK_ENROLLED, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
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
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(244, 241, 233));
        jPanel31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(ADD)
                .addGap(18, 18, 18)
                .addComponent(UPDATE)
                .addGap(18, 18, 18)
                .addComponent(DELETE)
                .addGap(18, 18, 18)
                .addComponent(CLEAR)
                .addGap(43, 43, 43))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel32.setBackground(new java.awt.Color(43, 70, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All Rights Reserved 2020");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel))
                .addGap(12, 12, 12)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    
          private void AutoCompleteComboBox(){          
          AutoCompleteDecorator.decorate(schoolyr);
          //AutoCompleteDecorator.decorate(LRN);
    }
    
    
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
      DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
      int selecIndex = jTable.getSelectedRow();
      //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
     
        schoolyr.setSelectedItem(model2.getValueAt(selecIndex, 1).toString());
        LRN.setSelectedItem(model2.getValueAt(selecIndex, 2).toString() );
        STUDENT_ACCOUNT1.setText(model2.getValueAt(selecIndex, 3).toString());
        LRNNO.setText(model2.getValueAt(selecIndex, 4).toString());
        STUDENTNAME.setText(model2.getValueAt(selecIndex, 5).toString());
        Date bdate;
        try {

            bdate=new SimpleDateFormat("yyyy-MM-dd").parse(model2.getValueAt(selecIndex, 6).toString());
            jDateChooser1.setDate(bdate);
        } catch (ParseException ex) {
            Logger.getLogger(Edit_Students_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (model2.getValueAt(selecIndex, 7).toString().equals("Male")) {
            Male.setSelected(true);
            Female.setSelected(false);
        }else {
            Female.setSelected(true);
            Male.setSelected(false);
        }
        AGE1.setText(model2.getValueAt(selecIndex, 8).toString());
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
        Semester.setSelectedItem(model2.getValueAt(selecIndex, 24).toString() );
        TRACK.setSelectedItem(model2.getValueAt(selecIndex, 25).toString() );
        STRAND.setSelectedItem(model2.getValueAt(selecIndex, 26).toString() );
       GRADELEVEL.setText(model2.getValueAt(selecIndex, 27).toString());
       TRACK_ENROLLED.setSelectedItem(model2.getValueAt(selecIndex, 28).toString() );

    }//GEN-LAST:event_jTableMouseClicked

    private void searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchCaretUpdate
       LoadSearchData();
    }//GEN-LAST:event_searchCaretUpdate

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed

                schoolyr.setSelectedIndex(-1);
                    LRN.setSelectedIndex(-1);
                    STUDENT_ACCOUNT1.setText("None");
                    LRNNO.setText("None");
                    STUDENTNAME.setText("Last Name,  First Name   Middle Name");
                    Male.setSelected(true);
                    Female.setSelected(true);
                    No.setSelected(false);
                    Yes.setSelected(false);
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
                    Semester.setSelectedIndex(0);
                    TRACK.setSelectedIndex(0);
                    STRAND.setSelectedIndex(0);
                    GRADELEVEL.setText("None");
                    TRACK_ENROLLED.setSelectedIndex(0);
    }//GEN-LAST:event_CLEARActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        
        if (verifyText()) {
            
            DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
         int selecIndex= jTable.getSelectedRow();
         int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
        
          
        SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String lrn = LRN.getSelectedItem().toString();
        String psa =STUDENT_ACCOUNT1.getText();
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

        String sem = Semester.getSelectedItem().toString();

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
                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/d");
                String dateString = String.valueOf(df.format(jDateChooser1.getDate()));
                Date myDate = df.parse(dateString);
                java.util.Date utilDate = new java.util.Date(myDate.getTime());
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                //ps=Mycon.prepareStatement("update enrolled_students set s.school_year_name, a.lrnStatus, a.student_account_no, a.lrnNumber, a.fullname, a.bdate, a.sex, a.age, a.ip, a.ip_status, a.mother_tongue, a.address, a.zip_code, a.fathername, a.mothername, a.guardianname, a.telephone, a.cellphone, a.last_grade_level_completed, a.last_school_year_completed, a.school_name, a.school_id, a.school_address, a.semester, a.track, a.strand, a.grade_level, a.enrolled_track from enrolled_students a, school_year s  where a.school_year_id = s.id ");
                //ps=Mycon.prepareStatement("update enrolled_students set school_year_id=?, lrnStatus=?, student_account_no=?, lrnNumber=?, fullname=?, bdate=?, sex=?, age=?, ip=?, ip_status=?, mother_tongue=?, address=?, zip_code=?, fathername=?, mothername=?, guardianname=?, telephone=?, cellphone=?, last_grade_level_completed=?, last_school_year_completed=?, school_name=?, school_id=?, school_address=?, semester=?, track=?, strand=?, grade_level=?, enrolled_track=? where id=?");
               ps=Mycon.prepareStatement("update enrolled_students set school_year_id=?, lrnStatus=?, student_account_no=?, lrnNumber=?, fullname=?, bdate=?, sex=?, age=?, ip=?, ip_status=?, mother_tongue=?, address=?, zip_code=?, fathername=?, mothername=?, guardianname=?, telephone=?, cellphone=?, last_grade_level_completed=?, last_school_year_completed=?, school_name=?, school_id=?, school_address=?, semester=?, track=?, strand=?, grade_level=?, enrolled_track=? where id=?");

                 if (verifyText()) {
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
                ps.setInt(29,id);

                
                      ps.execute();
                      table_update();
                    
                   // schoolyr.setSelectedIndex(-1);
                    LRN.setSelectedIndex(-1);
                    STUDENT_ACCOUNT1.setText("None");
                    LRNNO.setText("None");
                    STUDENTNAME.setText("Last Name,  First Name   Middle Name");
                    Male.setSelected(true);
                    Female.setSelected(true);
                    No.setSelected(false);
                    Yes.setSelected(false);
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
                    Semester.setSelectedIndex(0);
                    TRACK.setSelectedIndex(0);
                    STRAND.setSelectedIndex(0);
                    GRADELEVEL.setText("None");
                    TRACK_ENROLLED.setSelectedIndex(0);

                    JOptionPane.showMessageDialog(null, "Student Successfully Updated");
                   
                
                 }

                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

            } catch (ClassNotFoundException | SQLException | ParseException  ex) {

                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
       }

            
            
            
            
        }
        
           
            //catch (ParseException ex) {
               //catch (ParseException ex) {
            //catch (ParseException ex) {
               //catch (ParseException ex) {
            
         
    }//GEN-LAST:event_UPDATEActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
      
         if (verifyText()) {
        
        SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem(); // SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String lrn = LRN.getSelectedItem().toString();
        String psa =STUDENT_ACCOUNT1.getText();
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

        String sem = Semester.getSelectedItem().toString();

        String track=TRACK.getSelectedItem().toString();
        String strand=STRAND.getSelectedItem().toString();

        String gradelevel = GRADELEVEL.getText();
        String trackenroll= TRACK_ENROLLED.getSelectedItem().toString();

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        //java.util.Date now = new java.util.Date();

       

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
                    table_update();
                  //  schoolyr.setSelectedIndex(-1);
                    LRN.setSelectedIndex(-1);
                    STUDENT_ACCOUNT1.setText("None");
                    LRNNO.setText("None");
                    STUDENTNAME.setText("Last Name,  First Name   Middle Name");
                    Male.setSelected(true);
                    Female.setSelected(true);
                    No.setSelected(false);
                    Yes.setSelected(false);
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
                    Semester.setSelectedIndex(0);
                    TRACK.setSelectedIndex(0);
                    STRAND.setSelectedIndex(0);
                    GRADELEVEL.setText("None");
                    TRACK_ENROLLED.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");
                }
            } catch (ClassNotFoundException | SQLException | ParseException  ex) {
               JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
            }
    }//GEN-LAST:event_ADDActionPerformed

    private void STUDENT_ACCOUNT1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNT1FocusGained

        if( STUDENT_ACCOUNT1.getText().trim().equals("None"))
        {
            STUDENT_ACCOUNT1.setText("");
            STUDENT_ACCOUNT1.setForeground(Color.black);
        }
    }//GEN-LAST:event_STUDENT_ACCOUNT1FocusGained

    private void STUDENT_ACCOUNT1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNT1FocusLost

        if ( STUDENT_ACCOUNT1.getText().trim().isEmpty()) {
            STUDENT_ACCOUNT1.setForeground(new Color(51,51,51));
            STUDENT_ACCOUNT1.setText("None");
        }
    }//GEN-LAST:event_STUDENT_ACCOUNT1FocusLost

    private void STUDENT_ACCOUNT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STUDENT_ACCOUNT1ActionPerformed

    private void STUDENT_ACCOUNT1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNT1KeyPressed

    }//GEN-LAST:event_STUDENT_ACCOUNT1KeyPressed

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

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleActionPerformed

    private void AGE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AGE1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_AGE1KeyTyped

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

    private void ADDRESSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ADDRESSFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSFocusGained

    private void ADDRESSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ADDRESSFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSFocusLost

    private void ADDRESSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADDRESSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSKeyReleased

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

    private void TELNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TELNOKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TELNOKeyTyped

    private void CELPHONEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CELPHONEKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) ) {

            evt.consume();

        }
    }//GEN-LAST:event_CELPHONEKeyTyped

    private void SYCOMPLETEDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SYCOMPLETEDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SYCOMPLETEDKeyTyped

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

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

         DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
         int selecIndex = jTable.getSelectedRow();
         int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
         
         
         
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record","Warning",JOptionPane.YES_NO_OPTION);
         
         if (dialogResult == JOptionPane.YES_OPTION) 
         
         {
            
               try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
            PreparedStatement ps;
            ps=Mycon.prepareStatement("delete from enrolled_students where id=?");
            ps.setInt(1, id);
               
                ps.execute();
                table_update();
                JOptionPane.showMessageDialog(null, "Student Successfully Deleted");
                    //schoolyr.setSelectedIndex(-1);
                    LRN.setSelectedIndex(-1);
                    STUDENT_ACCOUNT1.setText("None");
                    LRNNO.setText("None");
                    STUDENTNAME.setText("Last Name,  First Name   Middle Name");
                    Male.setSelected(true);
                    Female.setSelected(true);
                    No.setSelected(false);
                    Yes.setSelected(false);
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
                    Semester.setSelectedIndex(0);
                    TRACK.setSelectedIndex(0);
                    STRAND.setSelectedIndex(0);
                    GRADELEVEL.setText("None");
                    TRACK_ENROLLED.setSelectedIndex(0);
            
            
        }catch (ClassNotFoundException | SQLException  ex) {
                        Logger.getLogger(Edit_Students_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        } else {
             
             JOptionPane.showMessageDialog(null, "Then please Proceed");
             
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Edit_Students_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Students_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Students_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Students_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Students_Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField ADDRESS;
    private javax.swing.JTextField AGE1;
    private javax.swing.JFormattedTextField CELPHONE;
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton DELETE;
    private javax.swing.JTextField FATHERNAME;
    private javax.swing.JCheckBox Female;
    private javax.swing.JTextField GRADELEVEL;
    private javax.swing.JLabel GRADE_LEVEL;
    private javax.swing.JTextField GUARDIAN;
    private javax.swing.JComboBox LEVELCOMPLETED;
    private javax.swing.JComboBox LRN;
    private javax.swing.JTextField LRNNO;
    private javax.swing.JTextField MOTHERNAME;
    private javax.swing.JTextField MOTHERTONGUE;
    private javax.swing.JCheckBox Male;
    private javax.swing.JCheckBox No;
    private javax.swing.JTextField SCHOOLADDRESS;
    private javax.swing.JTextField SCHOOLID;
    private javax.swing.JTextField SCHOOLNAME;
    private javax.swing.JComboBox STRAND;
    private javax.swing.JTextField STUDENTNAME;
    private javax.swing.JTextField STUDENT_ACCOUNT1;
    private javax.swing.JFormattedTextField SYCOMPLETED;
    private javax.swing.JComboBox Semester;
    private javax.swing.JFormattedTextField TELNO;
    private javax.swing.JComboBox TRACK;
    private javax.swing.JComboBox TRACK_ENROLLED;
    private javax.swing.JLabel TRACK_STRAND;
    private javax.swing.JButton UPDATE;
    private javax.swing.JTextField YES_IPSPECIFY;
    private javax.swing.JCheckBox Yes;
    private javax.swing.JTextField ZIPCODE;
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
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JComboBox schoolyr;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
