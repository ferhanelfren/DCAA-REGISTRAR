/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.TableView.TableRow;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author GOD
 */

public class Insert_Files extends javax.swing.JFrame {
    
    
String path = null ;
File filed=null;

    /**
     * Creates new form Enrollment
     */
    public Insert_Files() {
        initComponents();
        
        AutoCompleteDecorator.decorate(schoolyr);
        AutoCompleteDecorator.decorate(STUDENTNAMES);
        
        menu.add(panel);
        table_update();

        jTable.getTableHeader().hide();
        jTable.getRowHeight(0);

         schoolyear();
         studentnames();
         StudentTable();
          tableEditFormat();
          table_update();
          table_update_files();
         
     
         
       
        
    }

    
      public class STUDENT
            
    {
        int id;
        String name;
        public STUDENT (int id, String name)
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
     
     public class Sections 
       {
           int id;
           String name;
           public Sections (int id, String name)
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
                                                           
                                                        v.add(new STUDENT(rs.getInt(1), rs.getString(6)));
                                                    }
                                                    
                                                    modelt.addRow(v); 
                                                   
                                                }        
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }

    }
    
      
      
      
      private void schoolyear()
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
                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
  
        }
      
       private void studentnames()
        {
             try {

                Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from enrolled_students");
                rs= ps.executeQuery();
                STUDENTNAMES.removeAllItems();
                while (rs.next())
                {             
                     STUDENTNAMES.addItem(new STUDENT(rs.getInt(1),rs.getString(6)));             
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
       
       
          private void table_update_files()
    {
               int c;              
                                            try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select a.file_id, b.school_year_name, c.fullname, a.file_name, a.file_size_in_kb, a.file_extension, a.file_content, a.timestamp from insert_data_file a, enrolled_students c, school_year b  where a.school_year_id = b.id and a.enrolled_students_id = c.id");
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
                                                          v.add(rs.getString("school_year_name")); 
                                                        
                                                          v.add(rs.getString("fullname")); 
                                                          v.add(rs.getString("file_name"));
                                                          v.add(rs.getString("file_size_in_kb")); 
                                                          v.add(rs.getString("file_extension")); 
                                                        //  v.add(rs.getString("file_content")); 
                                                        //  v.add(rs.getString("timestamp"));   
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
    }   
       
       
       
       
       
         private void tableEditFormat()
       {
           
            
                                                jTable1.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,14));
                                                jTable1.getTableHeader().setOpaque(false);
                                                jTable1.getTableHeader().setBackground(new Color(165,19,29));
                                                jTable1.getTableHeader().setForeground(new Color(255,255,255));
                                                jTable1.getRowHeight(20);
                                                
                                                jTable1.setGridColor(new Color(43,70,60));

                                                DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)  jTable1.getTableHeader().getDefaultRenderer();
                                                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                                                
                                                TableColumn col = jTable1.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
                                                    dtcr.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col.setCellRenderer(dtcr);


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
                                                 jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                 jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
                                                
                                                 
                                                 
                                                 

                                                 
       }
         
   
         
         
         
         
         
           public void LoadSearchData(){
         
         
         
    
           try {
               
               
               String src="%"+this.search.getText()+"%";
                 //System.out.println(src);
                DefaultTableModel model =  (DefaultTableModel)jTable.getModel() ;
                
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               ps = Mycon.prepareStatement("select * from insert_data_file where fullname  LIKE '"+src+"'");
           
           
               
             ResultSet rs= ps.executeQuery();
             
               
          
                         while(rs.next()){   
                             
                        
                        model.setRowCount(0);      
                             
                        //number sa mga columns sa imohang tables
                       
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23),rs.getString(24),rs.getString(25),rs.getString(26),rs.getString(27),rs.getString(28),rs.getString(29)});

                                }  
             //model.setRowCount(0);
            }catch (ClassNotFoundException  ex) {
                Logger.getLogger(suggestions.class.getName()).log(Level.SEVERE, null, ex);
            }catch ( SQLException ex) {
                Logger.getLogger(suggestions.class.getName()).log(Level.SEVERE, null, ex);
            }

           }
         
         public boolean verifyText()
    {
        
       if (schoolyr.getSelectedItem().equals("") || STUDENTNAMES.getSelectedItem().toString().equals("") || file_text.getText().equals(""))

          {
            JOptionPane.showMessageDialog(this," Failed...!!! One or More Empty");
            return false;
       
        } else {
             return true;
        }

    }
         
         
         
           
         
      private void pops(){
        
       
          menu.show(search, 0, search.getHeight());
        
    }
    
    private void click(){

        JPopupMenu menu1 = this.menu;
        
       
        
       // this.hide();
        
        menu1.setVisible(false);
    }
       
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        menu = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        schoolyr = new javax.swing.JComboBox();
        STUDENTNAMES = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        file_text = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        SAVE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        DOWNLOAD = new javax.swing.JButton();
        MORAL = new javax.swing.JButton();
        ENROLL = new javax.swing.JButton();
        HONORABLE = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(56, 74, 19));
        jLabel17.setText("Student's  Name  :");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(56, 74, 19));
        jLabel19.setText("School  Year  :");

        schoolyr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        STUDENTNAMES.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "China", "Japan", "Korea", "Indonesia", "Thailand", "Philippines" }));
        STUDENTNAMES.setSelectedIndex(-1);

        jPanel6.setBackground(new java.awt.Color(244, 241, 233));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insert  File  Here :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 1, 18), new java.awt.Color(153, 0, 0))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        file_text.setBackground(new java.awt.Color(255, 255, 255));
        file_text.setBorder(null);
        file_text.setDoubleBuffered(true);
        file_text.setDragEnabled(true);
        file_text.setFocusCycleRoot(true);
        file_text.setFocusTraversalPolicyProvider(true);
        file_text.setInheritsPopupMenu(true);
        file_text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                file_textFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                file_textFocusLost(evt);
            }
        });
        file_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                file_textKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(file_text, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(file_text, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(STUDENTNAMES, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(5, 5, 5)
                .addComponent(STUDENTNAMES, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(244, 241, 233));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

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
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

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

        DOWNLOAD.setBackground(new java.awt.Color(51, 51, 51));
        DOWNLOAD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Download/default.png"))); // NOI18N
        DOWNLOAD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        DOWNLOAD.setFocusPainted(false);
        DOWNLOAD.setRolloverEnabled(true);
        DOWNLOAD.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Download/hover.png"))); // NOI18N
        DOWNLOAD.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Download/hover.png"))); // NOI18N
        DOWNLOAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOWNLOADActionPerformed(evt);
            }
        });

        MORAL.setBackground(new java.awt.Color(51, 51, 51));
        MORAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/default.png"))); // NOI18N
        MORAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        MORAL.setFocusPainted(false);
        MORAL.setRolloverEnabled(true);
        MORAL.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/hover.png"))); // NOI18N
        MORAL.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/hover.png"))); // NOI18N
        MORAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MORALActionPerformed(evt);
            }
        });

        ENROLL.setBackground(new java.awt.Color(51, 51, 51));
        ENROLL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/default.png"))); // NOI18N
        ENROLL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        ENROLL.setFocusPainted(false);
        ENROLL.setRolloverEnabled(true);
        ENROLL.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/hover.png"))); // NOI18N
        ENROLL.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/hover.png"))); // NOI18N
        ENROLL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENROLLActionPerformed(evt);
            }
        });

        HONORABLE.setBackground(new java.awt.Color(51, 51, 51));
        HONORABLE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/default.png"))); // NOI18N
        HONORABLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        HONORABLE.setFocusPainted(false);
        HONORABLE.setRolloverEnabled(true);
        HONORABLE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/hover.png"))); // NOI18N
        HONORABLE.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/hover.png"))); // NOI18N
        HONORABLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HONORABLEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(SAVE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DELETE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DOWNLOAD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MORAL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ENROLL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HONORABLE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(HONORABLE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ENROLL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MORAL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DOWNLOAD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addGap(363, 363, 363)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setText("Search Here. . . .");
        search.setAutoscrolls(false);
        search.setBorder(null);
        search.setDoubleBuffered(true);
        search.setDragEnabled(true);
        search.setFocusCycleRoot(true);
        search.setFocusTraversalPolicyProvider(true);
        search.setInheritsPopupMenu(true);
        search.setOpaque(false);
        search.setRequestFocusEnabled(false);
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
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
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(56, 74, 19));
        jLabel25.setText("Search :");

        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "School Year", "Students Name", "File Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(43, 70, 60));
        jTable1.setSelectionForeground(new java.awt.Color(244, 241, 233));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(272, 272, 272)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void DOWNLOADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOWNLOADActionPerformed

         if (verifyText()) {
            
         DefaultTableModel model2 =  (DefaultTableModel)jTable1.getModel() ;
         int selecIndex = jTable1.getSelectedRow();
         int row = jTable1.getSelectedRow();
         int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
         String tc = jTable1.getModel().getValueAt(row, 0).toString();
         
               try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
            PreparedStatement ps;
            ps=Mycon.prepareStatement("SELECT * from insert_data_file where  file_id="+tc+" ");
            
                   if (verifyText()) 
                   {
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
                                String home = System.getProperty("user.home");
                                File filed = new File(home+"/Downloads/" + fileName);         
                                Files.copy(inputStream, Paths.get(filed + fileName));
			}

                table_update_files();
                schoolyr.setSelectedIndex(-1);
                STUDENTNAMES.setSelectedIndex(-1);
                file_text.setText("");
                JOptionPane.showMessageDialog(this, "Successfully Download","Save",JOptionPane.WARNING_MESSAGE);
 
                   }
                
            
        }catch (ClassNotFoundException | SQLException  ex) {
                        Logger.getLogger(Edit_Students_Info.class.getName()).log(Level.SEVERE, null, ex);
        }    catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Already Downloaded");
                 Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }//GEN-LAST:event_DOWNLOADActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked

       
    }//GEN-LAST:event_jTableMouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
//
//        // String searh= search.getText().trim();
//        
//       // if (!searh.equals("")) {
//            
//          
//           LoadSearchData();
//           pops();
//            
//      //  }
    }//GEN-LAST:event_searchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
         DefaultTableModel model2 =  (DefaultTableModel)jTable1.getModel() ;
        int selecIndex = jTable1.getSelectedRow();
        
        schoolyr.setSelectedItem(model2.getValueAt(selecIndex, 1).toString());
        STUDENTNAMES.setSelectedItem(model2.getValueAt(selecIndex, 2).toString());
        file_text.setText(model2.getValueAt(selecIndex, 3).toString());
    
      
            
    }//GEN-LAST:event_jTable1MouseClicked

    private void file_textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_file_textFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_file_textFocusGained

    private void file_textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_file_textFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_file_textFocusLost

    private void file_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_file_textKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_file_textKeyReleased

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed

    }//GEN-LAST:event_CLEARActionPerformed

    private void MORALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MORALActionPerformed
       
    }//GEN-LAST:event_MORALActionPerformed

    private void ENROLLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENROLLActionPerformed

     
    }//GEN-LAST:event_ENROLLActionPerformed

    private void HONORABLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HONORABLEActionPerformed

       
    }//GEN-LAST:event_HONORABLEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser jfchoose = new JFileChooser();
                jfchoose.showOpenDialog(this);
                
                try {
            
                       File file = jfchoose.getSelectedFile();
                       path = file.getAbsoluteFile().toString();
                      file_text.setText(file.getAbsolutePath());
                    
                    
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
       
        
        
         
        
         
         if (verifyText()) {
         
         SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
         STUDENT stud = (STUDENT)STUDENTNAMES.getSelectedItem();
         DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDateTime now= LocalDateTime.now();
         String timestamp = dtf.format(now);
             
             
              try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps = null;
                    ps=Mycon.prepareStatement("INSERT INTO insert_data_file (school_year_id, enrolled_students_id, file_name, file_size_in_kb, file_extension, file_content, timestamp)VALUES(?,?,?,?,?,?,?)");

                            
                    if (verifyText()) {
                      
                        
                        
                         
                                filed = new File (path);
                                
                                System.out.println("Following files are saved in database..");                 		
				System.out.println(filed.getName());

				String fileName = filed.getName();
                                
				long fileLength =filed.length();
                                
				long fileLengthInKb=fileLength/1024;
				
                                ps.setInt(1, sy.id);
                                ps.setInt(2, stud.id);
				ps.setString(3, fileName);                               
				ps.setLong(4, fileLengthInKb);				
				ps.setString(5, fileName.substring(fileName.lastIndexOf(".")+1));
				
				FileInputStream fis = new FileInputStream(filed);
				ps.setBinaryStream(6, fis, fileLength);
                                ps.setString(7,timestamp);

                                ps.execute();
                                table_update_files();
                                schoolyr.setSelectedIndex(-1);
                                STUDENTNAMES.setSelectedIndex(-1);
                                file_text.setText("");
                                
                                JOptionPane.showMessageDialog(this, "Successfully Save","Save",JOptionPane.WARNING_MESSAGE);     
                                
			System.out.println("----------------------------------------");
                        System.out.println("");
                        
                        
                        
                        
                  }
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
        }
         
         
       
	
        
        
    }//GEN-LAST:event_SAVEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed

        
       
         
         if (verifyText()) {
            
             
             
         DefaultTableModel model2 =  (DefaultTableModel)jTable1.getModel() ;
         int selecIndex= jTable1.getSelectedRow();
         
         int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
         
         SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
         STUDENT stud = (STUDENT)STUDENTNAMES.getSelectedItem();
        
          DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDateTime now= LocalDateTime.now();
         String timestamp = dtf.format(now);
         
             
             try {
              
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("update insert_data_file set school_year_id=?, enrolled_students_id=?, file_name=?, file_size_in_kb=?, file_extension=?, file_content=? where file_id=?");
                
               
                 if (verifyText()) {
                     
                                
                                filed = new File (path).getAbsoluteFile();
                                
                                System.out.println("Following files are saved in database..");                 		
				System.out.println(filed.getName());

				String fileName = filed.getName();
                                
				long fileLength =filed.length();
                                
				long fileLengthInKb=fileLength/1024;
				
                                ps.setInt(1, sy.id);
                                ps.setInt(2, stud.id);
				ps.setString(3, fileName);                               
				ps.setLong(4, fileLengthInKb);				
				ps.setString(5, fileName.substring(fileName.lastIndexOf(".")+1));
				
				FileInputStream fis = new FileInputStream(filed);
				ps.setBinaryStream(6, fis, fileLength);
                                
                                
                                ps.setInt(7,id);

                                ps.execute();
                                table_update_files();
                                schoolyr.setSelectedIndex(-1);
                                STUDENTNAMES.setSelectedIndex(-1);
                                file_text.setText("");

                    JOptionPane.showMessageDialog(null, "Student Successfully Updated");
   
                 }
            } catch (ClassNotFoundException | SQLException ex) {

                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
        Logger.getLogger(Insert_Files.class.getName()).log(Level.SEVERE, null, ex);
    }
       
             
             
        }
    }//GEN-LAST:event_UPDATEActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
         
        
        if (verifyText()) {
            
            
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
            ps=Mycon.prepareStatement("delete from insert_data_file where file_id=?");
            ps.setInt(1, id);
               
                     if (verifyText()) {
                         
                ps.execute();
                schoolyr.setSelectedIndex(-1);
                STUDENTNAMES.setSelectedIndex(-1);
                file_text.setText("");
                
                table_update_files();
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                     }
        }catch (ClassNotFoundException | SQLException  ex) {
                        Logger.getLogger(Edit_Students_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        } else {
             
             JOptionPane.showMessageDialog(null, "Then please Proceed");
             
        }                 
            
            
            
        }
       
                    
    }//GEN-LAST:event_DELETEActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    

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
            java.util.logging.Logger.getLogger(Insert_Files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insert_Files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insert_Files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insert_Files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insert_Files().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton DOWNLOAD;
    private javax.swing.JButton ENROLL;
    private javax.swing.JButton HONORABLE;
    private javax.swing.JButton MORAL;
    private javax.swing.JButton SAVE;
    private javax.swing.JComboBox STUDENTNAMES;
    private javax.swing.JButton UPDATE;
    private javax.swing.JTextField file_text;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox schoolyr;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}