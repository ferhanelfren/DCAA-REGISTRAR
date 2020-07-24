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
public class Export_Data extends javax.swing.JFrame {

    /**
     * 
     */
    public Export_Data() {
        initComponents();
//      AutoCompleteDecorator.decorate(stnames);
//      AutoCompleteDecorator.decorate(sect);

        SomeWindow();

        //schoolyear2();

//        stnamae();

 //       sectionname();

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

                                           ps=Mycon.prepareStatement("select a.id, s.fullname, s.grade_level,  b.section_name from enrolled_students s, sections b, officialy_enrolled_students a  where a.enrolled_students_id = s.id and a.sections_id = b.id");

                                           ResultSet rs = ps.executeQuery();

                                            ResultSetMetaData rsd=rs.getMetaData();

                                                c = rsd.getColumnCount();            

                                                DefaultTableModel modelStudent =  (DefaultTableModel)jTableEnrolled.getModel() ;

                                                

                                            modelStudent.setRowCount(0);

                                                while (rs.next()) 

                                                {          

                                                    Vector v = new Vector();

                                                    for (int i = 0; i <= 35; i++) 

                                                    { 

                                                        // v.add(rs.getString("id")); 

                                                          //v.add(rs.getString("school_year_id"));

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

    

     

     

     

//      private void stnamae()
//
//        {
//
//             try {
//
//
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
//
//                PreparedStatement ps;
//
//                ps=Mycon.prepareStatement("select * from enrolled_students");
//
//                rs= ps.executeQuery();
//
//                stnames.removeAllItems();
//
//                while (rs.next())
//
//                {             
//
//                     stnames.addItem(new student(rs.getInt(1),rs.getString(6)));             
//
//                }
//
//            }catch (ClassNotFoundException | SQLException  ex) {
//
//                  JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
//
//            }
//
//
//
//        }
//
//      

      

      

//      private void sectionname()
//
//        {
//
//             try {
//
//
//
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
//
//                PreparedStatement ps;
//
//                ps=Mycon.prepareStatement("select * from sections");
//
//                ResultSet rs= ps.executeQuery();
//
//                sect.removeAllItems();
//
//                //sectioNsSH.removeAllItems();
//
//                while (rs.next())
//
//                {             
//
//                      sect.addItem(new Section(rs.getInt(1),rs.getString(2)));
//
//                     //sectioNsSH.addItem(new StudentFrame.Section(rs.getInt(1),rs.getString(2)));
//
//                }
//
//            }catch (ClassNotFoundException | SQLException  ex) {
//
//                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
//
//            }
//
//  
//
//        }


      private void tableformat()

              

      {

          

                                                jTableEnrolled.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,16));

                                                jTableEnrolled.getTableHeader().setOpaque(false);

                                                jTableEnrolled.getTableHeader().setBackground(new Color(165,19,29));

                                                jTableEnrolled.getTableHeader().setForeground(new Color(255,255,255));

                                                jTableEnrolled.getRowHeight(20);

                                                



                                                DefaultTableCellRenderer renderer3 = (DefaultTableCellRenderer)  jTableEnrolled.getTableHeader().getDefaultRenderer();

                                                renderer3.setHorizontalAlignment(SwingConstants.CENTER);

                                                

                                                TableColumn col =  jTableEnrolled.getColumnModel().getColumn(0);
                                              
                                                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  

                                                    dtcr.setHorizontalAlignment(SwingConstants.CENTER);

                                                    col.setCellRenderer(dtcr);
                                                    
                                                    
                                                 TableColumn col1 =  jTableEnrolled.getColumnModel().getColumn(1);
                                                
                                                    DefaultTableCellRenderer dtcr1 = new DefaultTableCellRenderer();  

                                                    dtcr1.setHorizontalAlignment(SwingConstants.CENTER);

                                                    col1.setCellRenderer(dtcr);    
                                                    
                                                TableColumn col2 =  jTableEnrolled.getColumnModel().getColumn(2);
                                                
                                                    DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();  

                                                    dtcr2.setHorizontalAlignment(SwingConstants.CENTER);

                                                    col2.setCellRenderer(dtcr); 
                                                    
                                                
                                                jTableEnrolled.getColumnModel().getColumn(0).setPreferredWidth(200);
//                                                jTableEnrolled.getColumnModel().getColumn(2).setPreferredWidth(10);

      }

     

      

//       public boolean verifyText()
//  {
//      
//        if (stnames.getSelectedItem().toString().equals("") || sect.getSelectedItem().toString().equals("") )
//
//
//
//          {
//
//            JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");
//
//            return false;
//
//
//
//        } else {
//
//             return true;
//
//        }
//
//   
//  }
//      

      
    
    
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEnrolled = new javax.swing.JTable();
        CLEAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Export");

        jPanel1.setBackground(new java.awt.Color(253, 253, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DIGOS   CENTRAL   ADVENTIST   ACADEMY,   INC.");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/loh.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lapu  -  Lapu  Ext.,  Digos  City,   Davao   del   Sur,   Pphilippines");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
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
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), " Search Here . . .  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 24), new java.awt.Color(204, 0, 0))); // NOI18N

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
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search)
        );

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(204, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  Student Name", "  Section" }));
        jComboBox1.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jTableEnrolled.setBackground(new java.awt.Color(253, 253, 255));
        jTableEnrolled.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student Name", "Grade Level", "Section"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        jTableEnrolled.setRowHeight(30);
        jTableEnrolled.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTableEnrolled.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableEnrolled.setShowVerticalLines(false);
        jTableEnrolled.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnrolledMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEnrolled);

        CLEAR.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Export/default.png"))); // NOI18N
        CLEAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR.setFocusPainted(false);
        CLEAR.setRolloverEnabled(true);
        CLEAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Export/hover.png"))); // NOI18N
        CLEAR.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Export/hover.png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            TableModel tableModel = jTableEnrolled.getModel();

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

    private void jTableEnrolledMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEnrolledMouseClicked

//        
//         DefaultTableModel model2 =  (DefaultTableModel)jTable.getModel() ;
//        int selecIndex = jTable.getSelectedRow();
//        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
//
//        stnames.setSelectedItem(model2.getValueAt(selecIndex, 0).toString());
//        sect.setSelectedItem(model2.getValueAt(selecIndex, 2).toString());
//        
//        
        
        
    }//GEN-LAST:event_jTableEnrolledMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

         
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

           int position = search.getCaretPosition();
       search.setText(search.getText().toUpperCase());
      search.setCaretPosition(position);
        
       if (jComboBox1.getSelectedIndex() == 0) {
            load_Names();
        } else if (jComboBox1.getSelectedIndex() == 1) {
            load_sections();
        }
       
       
       
    }//GEN-LAST:event_searchKeyReleased

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
            java.util.logging.Logger.getLogger(Export_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Export_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Export_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Export_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Export_Data().setVisible(true);
            }
        });
    }
    
    
   private void load_Names() 
   {
       
       try {
               String name="%"+this.search.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableEnrolled.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               //ps = Mycon.prepareStatement("select * from enrolled_students where fullname LIKE '"+name+"'"); 
               ps = Mycon.prepareStatement("select  s.fullname, s.grade_level,  b.section_name from enrolled_students s, sections b, officialy_enrolled_students a  where a.enrolled_students_id = s.id and a.sections_id = b.id and fullname LIKE '"+name+"'"); 
               
                         rs= ps.executeQuery();
                         
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
                                }  
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
   }
   
   
      private void load_sections() 
   {
       
       try {
               String name="%"+this.search.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableEnrolled.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               //ps = Mycon.prepareStatement("select * from enrolled_students where fullname LIKE '"+name+"'"); 
               ps = Mycon.prepareStatement("select  s.fullname, s.grade_level,  b.section_name from enrolled_students s, sections b, officialy_enrolled_students a  where a.enrolled_students_id = s.id and a.sections_id = b.id and section_name LIKE '"+name+"'"); 
               
                         rs= ps.executeQuery();
                         
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
                                }  
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
   }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLEAR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEnrolled;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
