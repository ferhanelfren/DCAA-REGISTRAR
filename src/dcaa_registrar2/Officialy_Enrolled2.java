/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;


import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author GOD
 */
public class Officialy_Enrolled2 extends javax.swing.JFrame {

    /**
     * 
     */
    public Officialy_Enrolled2() {
        initComponents();
      AutoCompleteDecorator.decorate(stnames);
      AutoCompleteDecorator.decorate(sect);

        SomeWindow();

        //schoolyear2();

        stnamae();

        sectionname();

        tableformat();

        table_update();

    }



    

    

    Connection Mycon;

    ResultSet rs;

    

    

    

    

    public void SomeWindow() {

    //this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//    this.setSize(windowWidth, windowHeight);

    this.setResizable(false);

   // this.setDefaultCloseOperation(0);

   // this.setLocation(0,0);

    this.setVisible(true);

}

    

    

//     public class SchoolYear2 

//       {

//           int id;

//           String name;

//           public SchoolYear2 (int id, String name)

//           {     

//               this.id=id;

//               this.name=name;     

//           }

//           @Override

//           public String toString ()

//           {   

//               return name;  

//            }

//       }

//     

     

     

     

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

    

    

    

    private void table_update()

    {

               int c;              

                                            try {       

                                           Class.forName("com.mysql.cj.jdbc.Driver");

                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 

                                           PreparedStatement ps;   

                                           //select a.file_id, b.school_year_name, c.fullname, a.file_name, a.file_size_in_kb, a.file_extension, a.file_content, a.timestamp from insert_data_file a, enrolled_students c, school_year b  where a.school_year_id = b.id and a.enrolled_students_id = c.id

                                           ps=Mycon.prepareStatement("select a.id, s.school_year_id, s.fullname, s.grade_level,  b.section_name from enrolled_students s, sections b, officialy_enrolled_students a  where a.enrolled_students_id = s.id and a.sections_id = b.id");

                                           ResultSet rs = ps.executeQuery();

                                            ResultSetMetaData rsd=rs.getMetaData();

                                                c = rsd.getColumnCount();            

                                                DefaultTableModel modelStudent =  (DefaultTableModel)jTable.getModel() ;

                                                

                                            modelStudent.setRowCount(0);

                                                while (rs.next()) 

                                                {          

                                                    Vector v = new Vector();

                                                    for (int i = 0; i <= 35; i++) 

                                                    { 

                                                         v.add(rs.getString("id")); 

                                                          v.add(rs.getString("school_year_id"));

                                                          v.add(rs.getString("fullname")); 

                                                          v.add(rs.getString("grade_level")); 

                                                          v.add(rs.getString("section_name")); 

                                                        

                                                    }

                                                    modelStudent.addRow(v); 

                                                }

                                        }  catch (ClassNotFoundException | SQLException  ex) {

                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);

                                        }

    }

       

    

//     private void schoolyear2()

//        {

//             try {

//

//                Class.forName("com.mysql.cj.jdbc.Driver");

//            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   

//                PreparedStatement ps;

//                ps=Mycon.prepareStatement("select * from school_year");

//                rs= ps.executeQuery();

//                syear.removeAllItems();

//                while (rs.next())

//                {             

//                     syear.addItem(new SchoolYear2(rs.getInt(1),rs.getString(2)));             

//                }

//            }catch (ClassNotFoundException | SQLException  ex) {

//                  JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);

//            }

//

//        }

    

     

     

     

      private void stnamae()

        {

             try {



                Class.forName("com.mysql.cj.jdbc.Driver");

            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   

                PreparedStatement ps;

                ps=Mycon.prepareStatement("select * from enrolled_students");

                rs= ps.executeQuery();

                stnames.removeAllItems();

                while (rs.next())

                {             

                     stnames.addItem(new student(rs.getInt(1),rs.getString(6)));             

                }

            }catch (ClassNotFoundException | SQLException  ex) {

                  JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);

            }



        }

      

      

      

      private void sectionname()

        {

             try {



                Class.forName("com.mysql.cj.jdbc.Driver");

            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   

                PreparedStatement ps;

                ps=Mycon.prepareStatement("select * from sections");

                ResultSet rs= ps.executeQuery();

                sect.removeAllItems();

                //sectioNsSH.removeAllItems();

                while (rs.next())

                {             

                      sect.addItem(new Section(rs.getInt(1),rs.getString(2)));

                     //sectioNsSH.addItem(new StudentFrame.Section(rs.getInt(1),rs.getString(2)));

                }

            }catch (ClassNotFoundException | SQLException  ex) {

                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);

            }

  

        }


      private void tableformat()

              

      {

          

                                                jTable.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,16));

                                                jTable.getTableHeader().setOpaque(false);

                                                jTable.getTableHeader().setBackground(new Color(165,19,29));

                                                jTable.getTableHeader().setForeground(new Color(255,255,255));

                                                jTable.getRowHeight(20);

                                                



                                                DefaultTableCellRenderer renderer3 = (DefaultTableCellRenderer)  jTable.getTableHeader().getDefaultRenderer();

                                                renderer3.setHorizontalAlignment(SwingConstants.CENTER);

                                                

                                                TableColumn col =  jTable.getColumnModel().getColumn(0);
                                              
                                                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  

                                                    dtcr.setHorizontalAlignment(SwingConstants.CENTER);

                                                    col.setCellRenderer(dtcr);
                                                    
                                                    
                                                 TableColumn col1 =  jTable.getColumnModel().getColumn(1);
                                                
                                                    DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();  

                                                    dtcr1.setHorizontalAlignment(SwingConstants.CENTER);

                                                    col1.setCellRenderer(dtcr);    
                                                    
                                                TableColumn col2 =  jTable.getColumnModel().getColumn(2);
                                                
                                                    DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();  

                                                    dtcr2.setHorizontalAlignment(SwingConstants.LEFT);

                                                    col2.setCellRenderer(dtcr); 
                                                    
                                                    
                                                TableColumn col3 =  jTable.getColumnModel().getColumn(3);
                                                
                                                    DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();  

                                                    dtcr3.setHorizontalAlignment(SwingConstants.CENTER);

                                                    col3.setCellRenderer(dtcr);   
                                                    
                                                TableColumn col4 =  jTable.getColumnModel().getColumn(4);
                                                
                                                    DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();  

                                                    dtcr4.setHorizontalAlignment(SwingConstants.CENTER);

                                                    col4.setCellRenderer(dtcr);   
                                                    

          

          

          

      }

     

      

       public boolean verifyText()
  {
      
        if (stnames.getSelectedItem().toString().equals("") || sect.getSelectedItem().toString().equals("") )



          {

            JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");

            return false;



        } else {

             return true;

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
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        stnames = new javax.swing.JComboBox();
        sect = new javax.swing.JComboBox();
        ADD = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(253, 253, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 51, 0));

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

        jPanel3.setBackground(new java.awt.Color(253, 253, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), " Search Here . . .  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 0, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(153, 153, 153));
        search.setText("Search Here . . .");
        search.setBorder(null);
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search)
        );

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  Student Name", "  Grade Level", "  Section" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        jTable.setBackground(new java.awt.Color(253, 253, 255));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "School Year", "Student Name", "Grade Level", "Section"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(30);
        jTable.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable.setShowVerticalLines(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        stnames.setBackground(new java.awt.Color(0, 0, 0));
        stnames.setEditable(true);
        stnames.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        stnames.setForeground(new java.awt.Color(0, 0, 0));
        stnames.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        sect.setBackground(new java.awt.Color(0, 0, 0));
        sect.setEditable(true);
        sect.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        sect.setForeground(new java.awt.Color(0, 0, 0));
        sect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(stnames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(sect, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DELETE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR)
                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stnames, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sect, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
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

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed

           try {



            if (verifyText()) {



                

                

                student names = (student)stnames.getSelectedItem();

                Section  st = (Section)sect.getSelectedItem(); // SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();


                DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");

                LocalDateTime now= LocalDateTime.now();

                String timestamp = dtf.format(now);


                try {



                               



                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");

                    PreparedStatement ps;

                    ps=Mycon.prepareStatement("insert into officialy_enrolled_students (enrolled_students_id, sections_id,timestamp) values (?,?,?)");

                    ps.setInt(1,names.id);
                    ps.setInt(2,st.id);
                    ps.setString(3,timestamp);



                    if (verifyText()) {



                        ps.execute();

                        table_update();
                        
                        stnames.setSelectedIndex(-1);
                        sect.setSelectedIndex(-1);

                        JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");

                    }

                } catch (ClassNotFoundException | SQLException ex) {

                    JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);

                }

            }



        } catch (Exception e) {



            JOptionPane.showMessageDialog(this, " Unable to Save" + "\n Please Fill in all the Necessary Student Basic Information");



        }
    }//GEN-LAST:event_ADDActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed

        
                student names = (student)stnames.getSelectedItem();

                Section  st = (Section)sect.getSelectedItem();
        
        
        try {

            if (verifyText()) {

                DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
                int selecIndex= jTable.getSelectedRow();
                int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                

               
                if (verifyText()) {
                    try {
                       

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                        PreparedStatement ps;
                        //ps=Mycon.prepareStatement("update enrolled_students set s.school_year_name, a.lrnStatus, a.student_account_no, a.lrnNumber, a.fullname, a.bdate, a.sex, a.age, a.ip, a.ip_status, a.mother_tongue, a.address, a.zip_code, a.fathername, a.mothername, a.guardianname, a.telephone, a.cellphone, a.last_grade_level_completed, a.last_school_year_completed, a.school_name, a.school_id, a.school_address, a.semester, a.track, a.strand, a.grade_level, a.enrolled_track from enrolled_students a, school_year s  where a.school_year_id = s.id ");
                        //ps=Mycon.prepareStatement("update enrolled_students set school_year_id=?, lrnStatus=?, student_account_no=?, lrnNumber=?, fullname=?, bdate=?, sex=?, age=?, ip=?, ip_status=?, mother_tongue=?, address=?, zip_code=?, fathername=?, mothername=?, guardianname=?, telephone=?, cellphone=?, last_grade_level_completed=?, last_school_year_completed=?, school_name=?, school_id=?, school_address=?, semester=?, track=?, strand=?, grade_level=?, enrolled_track=? where id=?");
                        ps=Mycon.prepareStatement("update officialy_enrolled_students set enrolled_students_id=?, sections_id=? where id=?");

                        if (verifyText()) {
                            ps.setInt(1,names.id);
                            ps.setInt(2,st.id);
                            ps.setInt(3,id);

                            ps.execute();
                            table_update();
                            
                            stnames.setSelectedIndex(-1);
                            sect.setSelectedIndex(-1);

                            // schoolyr.setSelectedIndex(-1);
                          

                            JOptionPane.showMessageDialog(null, "Student Successfully Updated");

                        }

                        // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

                    } catch (ClassNotFoundException | SQLException ex) {

                        JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, " Unable to Update" + "\n Student ID is not Specified");
        }

    }//GEN-LAST:event_UPDATEActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

        try {

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
                    ps=Mycon.prepareStatement("delete from officialy_enrolled_students where id=?");
                    ps.setInt(1, id);

                    ps.execute();
                    table_update();
                    
                    stnames.setSelectedIndex(-1);
                    sect.setSelectedIndex(-1);
                    
                    JOptionPane.showMessageDialog(null, "Student Successfully Deleted");
                    
                    
                   
                }catch (ClassNotFoundException | SQLException  ex) {
                    Logger.getLogger(Add_Students.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, " Unable to Delete" + "\n Student ID is not Specified");
        }

    }//GEN-LAST:event_DELETEActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
            
//             // DefaultTableModel modelStudent =  (DefaultTableModel)jTableStudents.getModel() ;
//       JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDialogTitle("Specify a file save");
//        int userSelection = fileChooser.showSaveDialog(this);
//        if(userSelection == JFileChooser.APPROVE_OPTION){
//            File fileToSave = fileChooser.getSelectedFile();
//            //lets write to file
//         
//            try {
//                
//                FileWriter fw = new FileWriter(fileToSave);
//                BufferedWriter bw = new BufferedWriter(fw);
//                for (int i = 0; i < jTable.getRowCount(); i++) {
//                
//                    for (int j = 0; j <  jTable.getColumnCount(); j++) {
//                        //write
//                        bw.write(jTable.getValueAt(i, j).toString()+ ",");
//                    }
//                    bw.newLine();//record per line 
//                }
//                JOptionPane.showMessageDialog(this, "SUCCESSFULLY LOADED","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
//                bw.close();
//                fw.close();
//            } catch (IOException ex) {
//               JOptionPane.showMessageDialog(this, "ERROR","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
//            }
//            
//            
//        }



       JFileChooser save = new JFileChooser();
    save.setDialogTitle("Save as...");
    save.setFileFilter(new FileNameExtensionFilter("xls", "xlsx", "xlsm"));
    int choose = save.showSaveDialog(null);

    if(choose == JFileChooser.APPROVE_OPTION) {
        XSSFWorkbook export = new XSSFWorkbook();
        XSSFSheet sheet1 = export.createSheet("new file");
        try{
            TableModel tableModel = jTable.getModel();

            for(int i=0; i<tableModel.getRowCount(); i++) {
                
                XSSFRow newRow = sheet1.createRow(i);
                
                for(int j=0; j<tableModel.getColumnCount(); j++) {
                    
                    XSSFCell newCell = newRow.createCell((short) j );
                    
                    newCell.setCellValue(tableModel.getValueAt(i, j).toString());
                    
//                    if(i==0){
//                        
////                        XSSFCellStyle style = export.createCellStyle();
////                        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
////                        //style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
////                        style.setBorderBottom(BorderStyle.THIN);
////                        style.setBorderTop(BorderStyle.THIN);
////                        style.setBorderLeft(BorderStyle.THIN);
////                        style.setBorderRight(BorderStyle.THIN);
////                        newCell.setCellStyle(style);
//                        newCell.setCellValue(tableModel.getColumnName(j));
//                        
//                        
//                    } else {
//                        
////                        XSSFCellStyle style = export.createCellStyle();
////                        style.setBorderBottom(BorderStyle.THIN);
////                        style.setBorderTop(BorderStyle.THIN);
////                        style.setBorderLeft(BorderStyle.THIN);
////                        style.setBorderRight(BorderStyle.THIN);
////                        newCell.setCellStyle(style);
//                        newCell.setCellValue(tableModel.getValueAt(i, j).toString());
//                    
//                    }
                }
            }

            try (FileOutputStream otp = new FileOutputStream(save.getSelectedFile()+".xlsx"); 
                 BufferedOutputStream bos = new BufferedOutputStream(otp)) {
                export.write(bos);
            }

            JOptionPane.showMessageDialog(null, "Student Data Export Successfully");
        }catch(HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        


  


        
    }//GEN-LAST:event_CLEARActionPerformed

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained

          if(search.getText().trim().equals("Search Here . . ."))
        {
            search.setText("");
            search.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost

        if(search.getText().trim().equals(""))
        {
            search.setText("Search Here . . .");
            search.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchFocusLost

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked

        
         DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
        int selecIndex = jTable.getSelectedRow();
        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();

        stnames.setSelectedItem(model2.getValueAt(selecIndex, 2).toString());
        sect.setSelectedItem(model2.getValueAt(selecIndex, 4).toString());
        
        
        
        
    }//GEN-LAST:event_jTableMouseClicked

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
            java.util.logging.Logger.getLogger(Officialy_Enrolled2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Officialy_Enrolled2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Officialy_Enrolled2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Officialy_Enrolled2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Officialy_Enrolled2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton UPDATE;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox sect;
    private javax.swing.JComboBox stnames;
    // End of variables declaration//GEN-END:variables
}
