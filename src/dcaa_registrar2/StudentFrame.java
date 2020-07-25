/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import static dcaa_registrar2.Mainframe.usernamedesk;
import trials.suggestions;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
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
public class StudentFrame extends javax.swing.JFrame {

String path;
File filed;
    
    /**
     * Creates new form mainframe
     */
    public StudentFrame() {
        initComponents();
        
        Component [] components = this.getContentPane().getComponents();
        
        for (Component component : components) {
            
            
            if (component instanceof JButton) 
            
            {
                
                ((JButton) component).setUI(new BasicButtonUI());
                
            }
            
        }
        
        table_update();
        schoolyear2();
        ButtonGroup bg = new ButtonGroup();
        bg.add(Male);
        bg.add(Female);
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(No);
        bg2.add(Yes);
        ButtonGroup bg3 = new ButtonGroup();
        bg3.add(He);
        bg3.add(She);
       tableEditFormat();
       SomeWindow();
        AutoCompleteDecorator.decorate(stnames);
          AutoCompleteDecorator.decorate(schoolyr);
        table_update_files();
        StudentCombo();
        sectionname();
        registrar();
        Pres();
        vpres();
        StudentTable_SHS();
        table_update_SHS();
        StudentTable_JHS();
        table_update_JHS();

    }
    
    
    Connection Mycon;
    ResultSet rs;
    
    
 
    
//   private int windowWidth = 1385;
//private int windowHeight =  712;

public void SomeWindow() {
    //this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    this.setSize(windowWidth, windowHeight);
    this.setResizable(false);
   // this.setDefaultCloseOperation(0);
   // this.setLocation(0,0);
    this.setVisible(true);
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
       
       public class VPresident 
       {
           int id;
           String name;
           public VPresident (int id, String name)
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
                                                DefaultTableModel modelStudent =  (DefaultTableModel)jTableStudents.getModel() ;
                                                
                                            modelStudent.setRowCount(0);
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
                                                    modelStudent.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
    }
       
       
       private void tableEditFormat()
       {
           
            
                                                jTableStudents.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,14));
                                                jTableStudents.getTableHeader().setOpaque(false);
                                                jTableStudents.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableStudents.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableStudents.getRowHeight(20);
                                               
                                                
                                                    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)  jTableStudents.getTableHeader().getDefaultRenderer();
                                                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                                                // jTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
                                                
                                                TableColumn col = jTableStudents.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
                                                    dtcr.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col.setCellRenderer(dtcr);
                                                
                                                
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(1));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(1));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(1));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    jTableStudents.removeColumn(jTableStudents.getColumnModel().getColumn(3));
                                                    
                                                    
                                                    jTableStudents.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                    jTableStudents.getColumnModel().getColumn(1).setPreferredWidth(10);
                                                    jTableStudents.getColumnModel().getColumn(2).setPreferredWidth(100);
//                                                  jTable.getColumnModel().getColumn(3).setPreferredWidth(10);
//                                                  jTable.getColumnModel().getColumn(4).setPreferredWidth(10);


                                                jTableinsert.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,16));
                                                jTableinsert.getTableHeader().setOpaque(false);
                                                jTableinsert.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableinsert.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableinsert.getRowHeight(20);
                                                jTableinsert.setGridColor(new Color(43,70,60));

                                                DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer)  jTableinsert.getTableHeader().getDefaultRenderer();
                                                renderer2.setHorizontalAlignment(SwingConstants.CENTER);

                                                TableColumn col2 = jTableinsert.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();  
                                                    dtcr2.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col2.setCellRenderer(dtcr2);

                                               //  jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                 jTableinsert.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                 jTableinsert.getColumnModel().getColumn(1).setPreferredWidth(10);

                                                   jTableCERTIFICATES.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,16));
                                                jTableCERTIFICATES.getTableHeader().setOpaque(false);
                                                jTableCERTIFICATES.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableCERTIFICATES.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableCERTIFICATES.getRowHeight(20);

                                                DefaultTableCellRenderer renderer4 = (DefaultTableCellRenderer)  jTableCERTIFICATES.getTableHeader().getDefaultRenderer();
                                                renderer4.setHorizontalAlignment(SwingConstants.CENTER);

                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(1));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(1));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(1));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(1));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                jTableCERTIFICATES.removeColumn(jTableCERTIFICATES.getColumnModel().getColumn(2));
                                                
                                               //  jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                 jTableCERTIFICATES.getColumnModel().getColumn(1).setPreferredWidth(300);
                                                 
                                                 
                                                 TableColumn col4 = jTableCERTIFICATES.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();  
                                                    dtcr4.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col4.setCellRenderer(dtcr4);
                                                    
                                                    
                                                     jTableCERTIFICATESSHS.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,16));
                                                jTableCERTIFICATESSHS.getTableHeader().setOpaque(false);
                                                jTableCERTIFICATESSHS.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableCERTIFICATESSHS.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableCERTIFICATESSHS.getRowHeight(20);
                                                

                                                DefaultTableCellRenderer renderer3 = (DefaultTableCellRenderer)  jTableCERTIFICATESSHS.getTableHeader().getDefaultRenderer();
                                                renderer3.setHorizontalAlignment(SwingConstants.CENTER);
                                     

                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(1));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(1));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(1));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(1));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                jTableCERTIFICATESSHS.removeColumn(jTableCERTIFICATESSHS.getColumnModel().getColumn(2));
                                                
                                               //  jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                 jTableCERTIFICATESSHS.getColumnModel().getColumn(1).setPreferredWidth(300);
                                                 
                                                 
                                                 TableColumn col3 = jTableCERTIFICATESSHS.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();  
                                                    dtcr3.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col3.setCellRenderer(dtcr3);



       }
       
       
       
       
       
       
      public boolean verifyText()
    {
        
        if ( LRNS.getSelectedItem().toString().equals("") || STUDENT_ACCOUNTS.getText().equals("") || LRNNO.getText().equals("") ||  fullname.getText().equals("") ||   jDateChooser1.getDate() == null || AGES.getText().equals("")    || YES_IPSPECIFY.getText().equals("") ||  MOTHERTONGUE.getText().equals("") ||  ADDRESS.getText().equals("") ||  ZIPCODE.getText().equals("") ||  FATHERNAME.getText().equals("") ||  MOTHERNAME.getText().equals("") ||  GUARDIAN.getText().equals("") ||  TELNO.getText().equals("") ||  CELPHONE.getText().equals("") || LEVELCOMPLETED.getSelectedItem().equals("") || SYCOMPLETED.getText().equals("") ||  SCHOOLNAME.getText().equals("") || SCHOOLID.getText().equals("") || SCHOOLADDRESS.getText().equals("") || TRACKS.getSelectedItem().equals("") || STRAND.getSelectedItem().equals("") || GRADELEVEL.getText().equals("") || TRACK_ENROLLED.getSelectedItem().equals(""))

          {
            JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");
            return false;
        }else if(jDateChooser1.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(this, " Unable to Save" + "\n Please Check the Year of Birth Date, Present Year is not Allowed");
            return false;
        } else if(jDateChooser1.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(this, " Unable to Save" + "\n Please Check the Year of Birth Date, Present Year is not Allowed");
            return false;
        } else {
             return true;
        }

    }
            public void LoadSearchDataStudent(){
           try {
               String name="%"+this.search.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableStudents.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               //ps = Mycon.prepareStatement("select * from enrolled_students where fullname LIKE '"+name+"'"); 
               ps = Mycon.prepareStatement("select a.id, s.school_year_name, a.lrnStatus, a.student_account_no, a.lrnNumber, a.fullname, a.bdate, a.sex, a.age, a.ip, a.ip_status, a.mother_tongue, a.address, a.zip_code, a.fathername, a.mothername, a.guardianname, a.telephone, a.cellphone, a.last_grade_level_completed, a.last_school_year_completed, a.school_name, a.school_id, a.school_address, a.semester, a.track, a.strand, a.grade_level, a.enrolled_track from enrolled_students a, school_year s  where a.school_year_id = s.id and fullname LIKE '"+name+"'"); 
               
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
     

            
            
            
            
          private void table_update_files()
    {
               int c;              
                                            try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select a.id, b.fullname, a.file_name, a.file_size_in_kb, a.file_extension, a.file_content, a.timestamp from  enrolled_students b, insert_data_file a where a.enrolled_students_id = b.id");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTableinsert.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                          v.add(rs.getString("id")); 
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
       
       
       
       
       
      
             public void LoadSearchDataFiles(){
    
           try {
               String src="%"+this.searchinsert.getText()+"%";
                 //System.out.println(src);
                DefaultTableModel model  =  (DefaultTableModel)jTableinsert.getModel() ;
                
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               ps = Mycon.prepareStatement("select  a.id, b.fullname, a.file_name, a.file_size_in_kb, a.file_extension, a.file_content, a.timestamp from  enrolled_students b, insert_data_file a where a.enrolled_students_id = b.id and fullname LIKE '"+src+"'");
             
           
               
             ResultSet rs;
             rs= ps.executeQuery();
                         while(rs.next()){   
                        model.setRowCount(0);          
                        //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3)});
                        //model.addRow(new Object[]{rs.getString(6)});
                                }  
             //model.setRowCount(0);
            }catch (ClassNotFoundException  ex) {
                Logger.getLogger(suggestions.class.getName()).log(Level.SEVERE, null, ex);
            }catch ( SQLException ex) {
                Logger.getLogger(suggestions.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
             
             
         private void StudentCombo()
    
    {
        
        int c;
           try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from enrolled_students");
               ResultSet rs= ps.executeQuery();
                
              
                ResultSetMetaData rsd=rs.getMetaData();
                   c = rsd.getColumnCount(); 
                
                    
                while (rs.next())
                
                {
                    stnames.addItem(new STUDENT(rs.getInt(1), rs.getString(6)));
                }
            }catch (ClassNotFoundException | SQLException  ex) {
                 JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }

    }
         
         
         public boolean verifyTextFiles()
    {
        
       if ( fullname.getText().equals("")|| file_text.getText().equals(""))

          {
            JOptionPane.showMessageDialog(this," Action Failed" + "\n Please fill the Necessary Empty Fields");
            return false;
       
        } else {
             return true;
        }
    }

         
         
         
         
           private void StudentTable_SHS()
    
    {
        
        int c;
           try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from enrolled_students");
                rs= ps.executeQuery();
                
                DefaultTableModel modelt = (DefaultTableModel)jTableCERTIFICATESSHS.getModel();
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
    
      
        
      
      
       private void table_update_SHS()
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
                                                DefaultTableModel model =  (DefaultTableModel)jTableCERTIFICATESSHS.getModel() ;
                                                
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
       
         
         
         
         
        public void  LoadSearchDataCertificatesSHS(){
           try {
               String name="%"+this.searchcertificateshs.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableCERTIFICATESSHS.getModel() ;
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
         
         public boolean verifyText_SHS()
    {
        
       if ( TRACKSH.getText().equals("")  ||  psySH.getText().equals("") || csySH.getText().equals("") || lrnnoSH.getText().equals("") || NAMESH.getText().equals("") || GRADESSH.getText().equals("") || sectioNsSH.getSelectedItem().equals("") || registrarSH.getSelectedItem().equals("") || regespositionSH.getSelectedItem().equals("") || presSH.getSelectedItem().equals("") || presposistionSH.getSelectedItem().equals("") || vpresidentSH.getSelectedItem().equals("") )

          {
            JOptionPane.showMessageDialog(this," Unable to Generate Certificate" + "\n Please fill the Necessary Empty Fields");
            return false;
       
        } else {
             return true;
        }
    }  
         

         private void StudentTable_JHS()
    
    {
        
        int c;
           try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from enrolled_students");
                rs= ps.executeQuery();
                
                DefaultTableModel modelt = (DefaultTableModel)jTableCERTIFICATES.getModel();
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
    
      
        
      
      
       private void table_update_JHS()
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
                                                DefaultTableModel model =  (DefaultTableModel)jTableCERTIFICATES.getModel() ;
                                                
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
       
         
         
         
         
        public void  LoadSearchDataCertificatesJHS(){
           try {
               String name="%"+this.searchcertificatesJHS.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableCERTIFICATES.getModel() ;
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
         
         
         public boolean verifyTextCertificatesJHS()
    {
        
       if ( psyJH.getText().equals("") || csyJH.getText().equals("") || lrnnoJH.getText().equals("") || studenameJH.getText().equals("") || GRDAESLEVELSJH.getText().equals("") || sectioNsJH.getSelectedItem().equals("") || registrarJH.getSelectedItem().equals("") || regespositionJH.getSelectedItem().equals("") || presJH.getSelectedItem().equals("") || presposistionJH.getSelectedItem().equals("") || vpresidentJH.getSelectedItem().equals("") )

          {
            JOptionPane.showMessageDialog(this," Unable to Generate Certificate" + "\n Please fill the Necessary Empty Fields");
            return false;
       
        } else {
             return true;
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
                sectioNsJH.removeAllItems();
                sectioNsSH.removeAllItems();
                while (rs.next())
                {             
                     sectioNsJH.addItem(new Section(rs.getInt(1),rs.getString(2)));
                     sectioNsSH.addItem(new Section(rs.getInt(1),rs.getString(2)));
                }
            }catch (ClassNotFoundException | SQLException  ex) {
                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
  
        }
      
       private void Pres()
        {
             try {

                Class.forName("com.mysql.cj.jdbc.Driver");
            Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from school_president_director");
                ResultSet rs= ps.executeQuery();
                presJH.removeAllItems();
                presposistionJH.removeAllItems();
                presSH.removeAllItems();
                presposistionSH.removeAllItems();
                while (rs.next())
                {             
                     presJH.addItem(new President(rs.getInt(1),rs.getString(2)));    
                     presposistionJH.addItem(new President(rs.getInt(1),rs.getString(3))); 
                     presSH.addItem(new President(rs.getInt(1),rs.getString(2)));    
                     presposistionSH.addItem(new President(rs.getInt(1),rs.getString(3)));
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
                ResultSet rs= ps.executeQuery();
                registrarJH.removeAllItems();
                regespositionJH.removeAllItems();
                registrarSH.removeAllItems();
                regespositionSH.removeAllItems();
                while (rs.next())
                {             
                     registrarJH.addItem(new Section(rs.getInt(1),rs.getString(2)));  
                     regespositionJH.addItem(new Section(rs.getInt(1),rs.getString(3)));  
                     registrarSH.addItem(new Section(rs.getInt(1),rs.getString(2)));  
                     regespositionSH.addItem(new Section(rs.getInt(1),rs.getString(3)));
                }
            }catch (ClassNotFoundException | SQLException  ex) {
                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
  
        }
      
       private void vpres()
        {
             try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
                PreparedStatement ps;
                ps=Mycon.prepareStatement("select * from school_vicepresident");
                ResultSet rs= ps.executeQuery();
                vpresidentJH.removeAllItems();
                vpresposisitionJH.removeAllItems();
                vpresidentSH.removeAllItems();
                vpresposisitionSH.removeAllItems();
                while (rs.next())
                {             
                     vpresidentJH.addItem(new VPresident(rs.getInt(1),rs.getString(2)));  
                     vpresposisitionJH.addItem(new VPresident(rs.getInt(1),rs.getString(3))); 
                     vpresidentSH.addItem(new VPresident(rs.getInt(1),rs.getString(2)));  
                     vpresposisitionSH.addItem(new VPresident(rs.getInt(1),rs.getString(3)));   
                }
            }catch (ClassNotFoundException | SQLException  ex) {
                 // JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
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
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel6 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        He = new javax.swing.JCheckBox();
        She = new javax.swing.JCheckBox();
        jPanel54 = new javax.swing.JPanel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernamedeskStudent = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        panel = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        STUDENT_ACCOUNTS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        LRNS = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        schoolyr = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        LRNNO = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        fullname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Female = new javax.swing.JCheckBox();
        Male = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        AGES = new javax.swing.JTextField();
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
        jPanel10 = new javax.swing.JPanel();
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
        jPanel11 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        TRACKS = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        STRAND = new javax.swing.JComboBox();
        Semester = new javax.swing.JComboBox();
        jPanel12 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        GRADE_LEVEL = new javax.swing.JLabel();
        TRACK_ENROLLED = new javax.swing.JComboBox();
        TRACK_STRAND = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        GRADELEVEL = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableStudents = new javax.swing.JTable();
        jPanel49 = new javax.swing.JPanel();
        ADD = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        searchinsert = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableinsert = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        file_text = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        stnames = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        CLEAR1 = new javax.swing.JButton();
        DOWNLOAD = new javax.swing.JButton();
        DELETE1 = new javax.swing.JButton();
        UPDATE1 = new javax.swing.JButton();
        SAVE = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        searchcertificatesJHS = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        csyJH = new javax.swing.JFormattedTextField();
        psyJH = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        sectioNsJH = new javax.swing.JComboBox();
        jPanel48 = new javax.swing.JPanel();
        lrnnoJH = new javax.swing.JTextField();
        jPanel50 = new javax.swing.JPanel();
        studenameJH = new javax.swing.JTextField();
        jPanel51 = new javax.swing.JPanel();
        GRDAESLEVELSJH = new javax.swing.JTextField();
        jPanel52 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        registrarJH = new javax.swing.JComboBox();
        presposistionJH = new javax.swing.JComboBox();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        presJH = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        vpresidentJH = new javax.swing.JComboBox();
        jLabel61 = new javax.swing.JLabel();
        vpresposisitionJH = new javax.swing.JComboBox();
        jLabel62 = new javax.swing.JLabel();
        regespositionJH = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCERTIFICATES = new javax.swing.JTable();
        CLEAR6 = new javax.swing.JButton();
        HONORABLE = new javax.swing.JButton();
        ENROLL = new javax.swing.JButton();
        MORAL = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        searchcertificateshs = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCERTIFICATESSHS = new javax.swing.JTable();
        jPanel55 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        csySH = new javax.swing.JFormattedTextField();
        psySH = new javax.swing.JFormattedTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        sectioNsSH = new javax.swing.JComboBox();
        jPanel56 = new javax.swing.JPanel();
        lrnnoSH = new javax.swing.JTextField();
        jPanel57 = new javax.swing.JPanel();
        NAMESH = new javax.swing.JTextField();
        jPanel58 = new javax.swing.JPanel();
        GRADESSH = new javax.swing.JTextField();
        jPanel59 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        registrarSH = new javax.swing.JComboBox();
        presposistionSH = new javax.swing.JComboBox();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        presSH = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        vpresidentSH = new javax.swing.JComboBox();
        jLabel75 = new javax.swing.JLabel();
        vpresposisitionSH = new javax.swing.JComboBox();
        jLabel76 = new javax.swing.JLabel();
        regespositionSH = new javax.swing.JComboBox();
        jLabel77 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        TRACKSH = new javax.swing.JTextField();
        CLEAR4 = new javax.swing.JButton();
        HONORABLE1 = new javax.swing.JButton();
        ENROLL1 = new javax.swing.JButton();
        MORAL1 = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

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

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 51, 51));
        jLabel63.setText("Gender :");

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(He)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(She)
                .addGap(138, 138, 138))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(He)
                    .addComponent(She)
                    .addComponent(jLabel63))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Student");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(253, 253, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(13, 52, 13));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/sdfdf.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(253, 253, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All Rights Reserved 2020");

        usernamedeskStudent.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usernamedeskStudent.setForeground(new java.awt.Color(255, 255, 255));
        usernamedeskStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernamedeskStudent.setText("Name");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/home/default.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/home/hover.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/home/hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/STUDENT/default.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/STUDENT/hover.png"))); // NOI18N
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/STUDENT/hover.png"))); // NOI18N

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/default.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/hover.png"))); // NOI18N
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/hover.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/user/default.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/user/hover.png"))); // NOI18N
        jButton4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/user/hover.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/LOG OUT/default.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.setFocusPainted(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/LOG OUT/hover.png"))); // NOI18N
        jButton6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/LOG OUT/hover.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(usernamedeskStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernamedeskStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(244, 241, 233));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search.setForeground(new java.awt.Color(153, 153, 153));
        search.setText("Search Here . . .");
        search.setBorder(null);
        search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchCaretUpdate(evt);
            }
        });
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        panel.setBackground(new java.awt.Color(244, 241, 233));
        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setForeground(new java.awt.Color(153, 0, 0));
        panel.setToolTipText("");
        panel.setAutoscrolls(true);
        panel.setFocusable(false);
        panel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        panel.setInheritsPopupMenu(true);

        jPanel9.setBackground(new java.awt.Color(244, 241, 233));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel9MouseReleased(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 51));
        jLabel25.setText("Learner's Reference No. (LRN):  ");

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        STUDENT_ACCOUNTS.setBackground(new java.awt.Color(255, 255, 255));
        STUDENT_ACCOUNTS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STUDENT_ACCOUNTS.setForeground(new java.awt.Color(153, 153, 153));
        STUDENT_ACCOUNTS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        STUDENT_ACCOUNTS.setText("None");
        STUDENT_ACCOUNTS.setBorder(null);
        STUDENT_ACCOUNTS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                STUDENT_ACCOUNTSFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                STUDENT_ACCOUNTSFocusLost(evt);
            }
        });
        STUDENT_ACCOUNTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STUDENT_ACCOUNTSActionPerformed(evt);
            }
        });
        STUDENT_ACCOUNTS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                STUDENT_ACCOUNTSKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(STUDENT_ACCOUNTS, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STUDENT_ACCOUNTS, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Student Account Number:");

        LRNS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LRNS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No LRN", "With LRN", "No LRN - Balik Aral", "With LRN Balik Aral" }));
        LRNS.setSelectedIndex(-1);

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
        LRNNO.setForeground(new java.awt.Color(153, 153, 153));
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

        fullname.setBackground(new java.awt.Color(255, 255, 255));
        fullname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fullname.setForeground(new java.awt.Color(153, 153, 153));
        fullname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fullname.setText("Last Name,  First Name   Middle Name");
        fullname.setBorder(null);
        fullname.setMargin(new java.awt.Insets(1, 1, 1, 1));
        fullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fullnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fullnameFocusLost(evt);
            }
        });
        fullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fullnameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullname, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
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

        AGES.setBackground(new java.awt.Color(255, 255, 255));
        AGES.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AGES.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        AGES.setBorder(null);
        AGES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AGESKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AGES, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(AGES, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        YES_IPSPECIFY.setForeground(new java.awt.Color(153, 153, 153));
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
        MOTHERTONGUE.setForeground(new java.awt.Color(153, 153, 153));
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
        FATHERNAME.setForeground(new java.awt.Color(153, 153, 153));
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
        MOTHERNAME.setForeground(new java.awt.Color(153, 153, 153));
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
        GUARDIAN.setForeground(new java.awt.Color(153, 153, 153));
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
            TELNO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
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
                .addContainerGap(14, Short.MAX_VALUE))
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
        ZIPCODE.setForeground(new java.awt.Color(153, 153, 153));
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25)
                            .addComponent(jLabel42)
                            .addComponent(LRNS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel35)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(Male)
                                                .addGap(18, 18, 18)
                                                .addComponent(Female)))
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(No)
                                                .addGap(45, 45, 45)
                                                .addComponent(Yes))
                                            .addComponent(jLabel17))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(57, 57, 57))))
                            .addComponent(jLabel39)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel38)
                            .addComponent(jLabel36)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schoolyr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LRNS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Male, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Female, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Yes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        jScrollPane1.setViewportView(jPanel9);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );

        panel.addTab("Students Information   ", jPanel8);

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
                .addComponent(SYCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SYCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        SCHOOLNAME.setBackground(new java.awt.Color(255, 255, 255));
        SCHOOLNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SCHOOLNAME.setForeground(new java.awt.Color(153, 153, 153));
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
        SCHOOLID.setForeground(new java.awt.Color(153, 153, 153));
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
        SCHOOLADDRESS.setForeground(new java.awt.Color(153, 153, 153));
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

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Barangay");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Street");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Municipality/City");

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
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
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LEVELCOMPLETED, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );

        panel.addTab("Balik - Aral / Repeater   ", jPanel10);

        jPanel27.setBackground(new java.awt.Color(244, 241, 233));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 51, 51));
        jLabel41.setText("Semester:");

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 51, 51));
        jLabel55.setText("Track:");

        TRACKS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TRACKS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ACADEMIC", "TECHNICAL VOCATIONAL" }));

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 51, 51));
        jLabel56.setText("Strand:");

        STRAND.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STRAND.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "ABM", "GAS", "HUMMS", "STEM", " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -", "BEAUTY NAILCARE", "CCS", "CSS", "EIM", "FBS", "FOS", "HOUSE KEEPING" }));

        Semester.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "1st Semester", "2nd Semester" }));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel56)
                    .addComponent(jLabel55)
                    .addComponent(jLabel41)
                    .addComponent(TRACKS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Semester, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Semester, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TRACKS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel.addTab("Senior High School   ", jPanel11);

        jPanel28.setBackground(new java.awt.Color(244, 241, 233));

        GRADE_LEVEL.setBackground(new java.awt.Color(255, 255, 255));
        GRADE_LEVEL.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GRADE_LEVEL.setForeground(new java.awt.Color(0, 51, 51));
        GRADE_LEVEL.setText("Grade Level :");

        TRACK_ENROLLED.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TRACK_ENROLLED.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Academic - ABM", "Academic - GAS", "Academic - HUMMS", "Academic - STEM", " ", "--------------------------------------------------------------------------", " ", "Tech Voc - CCS", "Tech Voc - CSS", "Tech Voc - EIM", "Tech Voc - FOS", "Tech Voc - FBS", "Tech Voc - HOUSE KEEPING", "Tech Voc - BEAUTY NAILCARE" }));

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
            .addGap(0, 322, Short.MAX_VALUE)
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
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TRACK_ENROLLED, 0, 0, Short.MAX_VALUE)
                    .addComponent(TRACK_STRAND)
                    .addComponent(GRADE_LEVEL)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(GRADE_LEVEL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(TRACK_STRAND, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TRACK_ENROLLED, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel.addTab("Grade Enrolled  ", jPanel12);

        jTableStudents.setBackground(new java.awt.Color(253, 253, 255));
        jTableStudents.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableStudents.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTableStudents.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableStudents.setFocusable(false);
        jTableStudents.setRequestFocusEnabled(false);
        jTableStudents.setRowHeight(30);
        jTableStudents.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTableStudents.setSelectionForeground(new java.awt.Color(244, 241, 233));
        jTableStudents.setShowVerticalLines(false);
        jTableStudents.getTableHeader().setReorderingAllowed(false);
        jTableStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableStudentsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableStudents);

        jPanel49.setBackground(new java.awt.Color(244, 241, 233));
        jPanel49.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

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

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DELETE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLEAR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(panel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Student     ", jPanel3);

        jPanel13.setBackground(new java.awt.Color(244, 241, 233));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchinsert.setBackground(new java.awt.Color(255, 255, 255));
        searchinsert.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        searchinsert.setForeground(new java.awt.Color(153, 153, 153));
        searchinsert.setText("Search Here . . .");
        searchinsert.setBorder(null);
        searchinsert.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchinsertCaretUpdate(evt);
            }
        });
        searchinsert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchinsertFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchinsertFocusLost(evt);
            }
        });
        searchinsert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchinsertKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(searchinsert, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchinsert, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jTableinsert.setAutoCreateRowSorter(true);
        jTableinsert.setBackground(new java.awt.Color(253, 253, 255));
        jTableinsert.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableinsert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Students Name", "File Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jTableinsert.setRowHeight(30);
        jTableinsert.setSelectionBackground(new java.awt.Color(43, 70, 60));
        jTableinsert.setSelectionForeground(new java.awt.Color(244, 241, 233));
        jTableinsert.setShowVerticalLines(false);
        jTableinsert.getTableHeader().setReorderingAllowed(false);
        jTableinsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableinsertMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableinsertMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(jTableinsert);

        jPanel16.setBackground(new java.awt.Color(244, 241, 233));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "   Insert  File  Here     ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 1, 24), new java.awt.Color(153, 0, 0))); // NOI18N

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        file_text.setEditable(false);
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

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(file_text, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(file_text, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jButton5.setText("Browse");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        stnames.setAutoscrolls(true);
        stnames.setDoubleBuffered(true);
        stnames.setFocusCycleRoot(true);
        stnames.setInheritsPopupMenu(true);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(43, 70, 60));
        jLabel19.setText("Student's  Name  :");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(stnames, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel19)
                .addGap(0, 0, 0)
                .addComponent(stnames, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(244, 241, 233));
        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

        CLEAR1.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/default.png"))); // NOI18N
        CLEAR1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR1.setFocusPainted(false);
        CLEAR1.setRolloverEnabled(true);
        CLEAR1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/hover.png"))); // NOI18N
        CLEAR1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/hover.png"))); // NOI18N
        CLEAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR1ActionPerformed(evt);
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

        DELETE1.setBackground(new java.awt.Color(51, 51, 51));
        DELETE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/default.png"))); // NOI18N
        DELETE1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        DELETE1.setFocusPainted(false);
        DELETE1.setRolloverEnabled(true);
        DELETE1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE1ActionPerformed(evt);
            }
        });

        UPDATE1.setBackground(new java.awt.Color(51, 51, 51));
        UPDATE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/default.png"))); // NOI18N
        UPDATE1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        UPDATE1.setFocusPainted(false);
        UPDATE1.setRolloverEnabled(true);
        UPDATE1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE1ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(SAVE)
                .addGap(18, 18, 18)
                .addComponent(UPDATE1)
                .addGap(18, 18, 18)
                .addComponent(DELETE1)
                .addGap(18, 18, 18)
                .addComponent(DOWNLOAD)
                .addGap(18, 18, 18)
                .addComponent(CLEAR1)
                .addGap(85, 85, 85))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CLEAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DOWNLOAD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DELETE1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Insert File     ", jPanel5);

        jPanel15.setBackground(new java.awt.Color(244, 241, 233));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchcertificatesJHS.setBackground(new java.awt.Color(255, 255, 255));
        searchcertificatesJHS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        searchcertificatesJHS.setForeground(new java.awt.Color(153, 153, 153));
        searchcertificatesJHS.setText("Search Here. . . .");
        searchcertificatesJHS.setBorder(null);
        searchcertificatesJHS.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchcertificatesJHSCaretUpdate(evt);
            }
        });
        searchcertificatesJHS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchcertificatesJHSFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchcertificatesJHSFocusLost(evt);
            }
        });
        searchcertificatesJHS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchcertificatesJHSKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchcertificatesJHS, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchcertificatesJHS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel33.setBackground(new java.awt.Color(244, 241, 233));
        jPanel33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(56, 74, 19));
        jLabel23.setText("Coming School Year:");

        csyJH.setBackground(new java.awt.Color(255, 255, 255));
        csyJH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));
        csyJH.setColumns(12);
        csyJH.setForeground(new java.awt.Color(0, 0, 0));
        try {
            csyJH.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        csyJH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        csyJH.setCaretColor(new java.awt.Color(102, 0, 0));
        csyJH.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        csyJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        csyJH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                csyJHKeyTyped(evt);
            }
        });

        psyJH.setBackground(new java.awt.Color(255, 255, 255));
        psyJH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));
        psyJH.setColumns(12);
        psyJH.setForeground(new java.awt.Color(0, 0, 0));
        try {
            psyJH.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        psyJH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        psyJH.setCaretColor(new java.awt.Color(102, 0, 0));
        psyJH.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        psyJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        psyJH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psyJHActionPerformed(evt);
            }
        });
        psyJH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                psyJHKeyTyped(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(56, 74, 19));
        jLabel20.setText("Present School Year :");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(56, 74, 19));
        jLabel21.setText("LRN :");

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(56, 74, 19));
        jLabel33.setText("Student's Name :");

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(56, 74, 19));
        jLabel34.setText("Grade Level :");

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(56, 74, 19));
        jLabel48.setText("Section :");

        sectioNsJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jPanel48.setBackground(new java.awt.Color(244, 241, 233));
        jPanel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        lrnnoJH.setBackground(new java.awt.Color(244, 241, 233));
        lrnnoJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lrnnoJH.setForeground(new java.awt.Color(51, 51, 51));
        lrnnoJH.setBorder(null);

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lrnnoJH, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lrnnoJH, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel50.setBackground(new java.awt.Color(244, 241, 233));
        jPanel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        studenameJH.setBackground(new java.awt.Color(244, 241, 233));
        studenameJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        studenameJH.setForeground(new java.awt.Color(51, 51, 51));
        studenameJH.setBorder(null);
        studenameJH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studenameJHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(studenameJH, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studenameJH, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanel51.setBackground(new java.awt.Color(244, 241, 233));
        jPanel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        GRDAESLEVELSJH.setBackground(new java.awt.Color(244, 241, 233));
        GRDAESLEVELSJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GRDAESLEVELSJH.setForeground(new java.awt.Color(51, 51, 51));
        GRDAESLEVELSJH.setBorder(null);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(GRDAESLEVELSJH, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GRDAESLEVELSJH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel52.setBackground(new java.awt.Color(244, 241, 233));
        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To be Sign by :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 1, 22), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(56, 74, 19));
        jLabel57.setText("Registrar In-Charge :");

        registrarJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        presposistionJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(56, 74, 19));
        jLabel58.setText("Position :");

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(56, 74, 19));
        jLabel59.setText("School President :");

        presJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(56, 74, 19));
        jLabel60.setText("School Vice President :");

        vpresidentJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(56, 74, 19));
        jLabel61.setText("Position :");

        vpresposisitionJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel62.setBackground(new java.awt.Color(255, 255, 255));
        jLabel62.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(56, 74, 19));
        jLabel62.setText("Position :");

        regespositionJH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel60))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel57))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presJH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarJH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vpresidentJH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel52Layout.createSequentialGroup()
                            .addComponent(jLabel58)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(presposistionJH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel52Layout.createSequentialGroup()
                            .addComponent(jLabel61)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(vpresposisitionJH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regespositionJH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regespositionJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presposistionJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vpresposisitionJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addComponent(registrarJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(presJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vpresidentJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel21)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel33Layout.createSequentialGroup()
                                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sectioNsJH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(6, 6, 6)
                                .addComponent(psyJH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(csyJH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csyJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psyJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel33)))
                .addGap(25, 25, 25)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sectioNsJH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTableCERTIFICATES.setBackground(new java.awt.Color(255, 255, 255));
        jTableCERTIFICATES.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableCERTIFICATES.setForeground(new java.awt.Color(0, 0, 0));
        jTableCERTIFICATES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
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
        jTableCERTIFICATES.setFocusable(false);
        jTableCERTIFICATES.setRequestFocusEnabled(false);
        jTableCERTIFICATES.setRowHeight(30);
        jTableCERTIFICATES.setSelectionBackground(new java.awt.Color(43, 70, 60));
        jTableCERTIFICATES.setSelectionForeground(new java.awt.Color(244, 241, 233));
        jTableCERTIFICATES.setShowVerticalLines(false);
        jTableCERTIFICATES.getTableHeader().setReorderingAllowed(false);
        jTableCERTIFICATES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCERTIFICATESMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableCERTIFICATES);

        CLEAR6.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/default.png"))); // NOI18N
        CLEAR6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR6.setFocusPainted(false);
        CLEAR6.setRolloverEnabled(true);
        CLEAR6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/hover.png"))); // NOI18N
        CLEAR6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/hover.png"))); // NOI18N
        CLEAR6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR6ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(MORAL)
                                .addGap(18, 18, 18)
                                .addComponent(ENROLL)
                                .addGap(18, 18, 18)
                                .addComponent(HONORABLE)
                                .addGap(18, 18, 18)
                                .addComponent(CLEAR6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CLEAR6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HONORABLE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ENROLL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MORAL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5))
                .addGap(88, 88, 88))
        );

        jTabbedPane1.addTab("Certificates (grade school& junior high)  ", jPanel15);

        jPanel26.setBackground(new java.awt.Color(244, 241, 233));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchcertificateshs.setBackground(new java.awt.Color(255, 255, 255));
        searchcertificateshs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        searchcertificateshs.setForeground(new java.awt.Color(153, 153, 153));
        searchcertificateshs.setText("Search Here. . . .");
        searchcertificateshs.setBorder(null);
        searchcertificateshs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchcertificateshsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchcertificateshsFocusLost(evt);
            }
        });
        searchcertificateshs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchcertificateshsKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchcertificateshs, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchcertificateshs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jTableCERTIFICATESSHS.setBackground(new java.awt.Color(255, 255, 255));
        jTableCERTIFICATESSHS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableCERTIFICATESSHS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
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
        jTableCERTIFICATESSHS.setFocusable(false);
        jTableCERTIFICATESSHS.setRequestFocusEnabled(false);
        jTableCERTIFICATESSHS.setRowHeight(30);
        jTableCERTIFICATESSHS.setSelectionBackground(new java.awt.Color(43, 70, 60));
        jTableCERTIFICATESSHS.setSelectionForeground(new java.awt.Color(244, 241, 233));
        jTableCERTIFICATESSHS.setShowVerticalLines(false);
        jTableCERTIFICATESSHS.getTableHeader().setReorderingAllowed(false);
        jTableCERTIFICATESSHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCERTIFICATESSHSMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableCERTIFICATESSHS);

        jPanel55.setBackground(new java.awt.Color(244, 241, 233));
        jPanel55.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel65.setBackground(new java.awt.Color(255, 255, 255));
        jLabel65.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(56, 74, 19));
        jLabel65.setText("Coming School Year:");

        csySH.setBackground(new java.awt.Color(255, 255, 255));
        csySH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));
        csySH.setColumns(12);
        csySH.setForeground(new java.awt.Color(0, 0, 0));
        try {
            csySH.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        csySH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        csySH.setCaretColor(new java.awt.Color(102, 0, 0));
        csySH.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        csySH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        csySH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                csySHKeyTyped(evt);
            }
        });

        psySH.setBackground(new java.awt.Color(255, 255, 255));
        psySH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));
        psySH.setColumns(12);
        psySH.setForeground(new java.awt.Color(0, 0, 0));
        try {
            psySH.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        psySH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        psySH.setCaretColor(new java.awt.Color(102, 0, 0));
        psySH.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        psySH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        psySH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                psySHKeyTyped(evt);
            }
        });

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(56, 74, 19));
        jLabel66.setText("Present School Year :");

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(56, 74, 19));
        jLabel67.setText("LRN :");

        jLabel68.setBackground(new java.awt.Color(255, 255, 255));
        jLabel68.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(56, 74, 19));
        jLabel68.setText("Student's Name :");

        jLabel69.setBackground(new java.awt.Color(255, 255, 255));
        jLabel69.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(56, 74, 19));
        jLabel69.setText("Grade Level :");

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(56, 74, 19));
        jLabel70.setText("Section :");

        sectioNsSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sectioNsSH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectioNsSHActionPerformed(evt);
            }
        });

        jPanel56.setBackground(new java.awt.Color(244, 241, 233));
        jPanel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        lrnnoSH.setBackground(new java.awt.Color(244, 241, 233));
        lrnnoSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lrnnoSH.setForeground(new java.awt.Color(51, 51, 51));
        lrnnoSH.setBorder(null);

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lrnnoSH, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lrnnoSH, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel57.setBackground(new java.awt.Color(244, 241, 233));
        jPanel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        NAMESH.setBackground(new java.awt.Color(244, 241, 233));
        NAMESH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NAMESH.setForeground(new java.awt.Color(51, 51, 51));
        NAMESH.setBorder(null);
        NAMESH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NAMESHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(NAMESH, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NAMESH, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanel58.setBackground(new java.awt.Color(244, 241, 233));
        jPanel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        GRADESSH.setBackground(new java.awt.Color(244, 241, 233));
        GRADESSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GRADESSH.setForeground(new java.awt.Color(51, 51, 51));
        GRADESSH.setBorder(null);

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(GRADESSH, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GRADESSH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel59.setBackground(new java.awt.Color(244, 241, 233));
        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To be Sign by :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 1, 22), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(56, 74, 19));
        jLabel71.setText("Registrar In-Charge :");

        registrarSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        presposistionSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel72.setBackground(new java.awt.Color(255, 255, 255));
        jLabel72.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(56, 74, 19));
        jLabel72.setText("Position :");

        jLabel73.setBackground(new java.awt.Color(255, 255, 255));
        jLabel73.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(56, 74, 19));
        jLabel73.setText("School President :");

        presSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel74.setBackground(new java.awt.Color(255, 255, 255));
        jLabel74.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(56, 74, 19));
        jLabel74.setText("School Vice President :");

        vpresidentSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel75.setBackground(new java.awt.Color(255, 255, 255));
        jLabel75.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(56, 74, 19));
        jLabel75.setText("Position :");

        vpresposisitionSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel76.setBackground(new java.awt.Color(255, 255, 255));
        jLabel76.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(56, 74, 19));
        jLabel76.setText("Position :");

        regespositionSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel74))
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel73)
                            .addComponent(jLabel71))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presSH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarSH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vpresidentSH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel59Layout.createSequentialGroup()
                            .addComponent(jLabel72)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(presposistionSH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel59Layout.createSequentialGroup()
                            .addComponent(jLabel75)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(vpresposisitionSH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regespositionSH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regespositionSH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presposistionSH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vpresposisitionSH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel59Layout.createSequentialGroup()
                                .addComponent(registrarSH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(presSH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel59Layout.createSequentialGroup()
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vpresidentSH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
        );

        jLabel77.setBackground(new java.awt.Color(255, 255, 255));
        jLabel77.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(56, 74, 19));
        jLabel77.setText("Track & Strand :");

        jPanel60.setBackground(new java.awt.Color(244, 241, 233));
        jPanel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 74, 19)));

        TRACKSH.setBackground(new java.awt.Color(244, 241, 233));
        TRACKSH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TRACKSH.setForeground(new java.awt.Color(51, 51, 51));
        TRACKSH.setBorder(null);

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(TRACKSH, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TRACKSH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel55Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel66)
                            .addGap(6, 6, 6)
                            .addComponent(psySH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel65)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(csySH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel55Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel68)
                                .addComponent(jLabel67)
                                .addComponent(jLabel69))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel55Layout.createSequentialGroup()
                                    .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel70)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sectioNsSH, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel55Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(csySH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psySH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel68)))
                .addGap(24, 24, 24)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sectioNsSH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CLEAR4.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/default.png"))); // NOI18N
        CLEAR4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        CLEAR4.setFocusPainted(false);
        CLEAR4.setRolloverEnabled(true);
        CLEAR4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/hover.png"))); // NOI18N
        CLEAR4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/CLEAR/hover.png"))); // NOI18N
        CLEAR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR4ActionPerformed(evt);
            }
        });

        HONORABLE1.setBackground(new java.awt.Color(51, 51, 51));
        HONORABLE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/default.png"))); // NOI18N
        HONORABLE1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        HONORABLE1.setFocusPainted(false);
        HONORABLE1.setRolloverEnabled(true);
        HONORABLE1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/hover.png"))); // NOI18N
        HONORABLE1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DISMISSAL/hover.png"))); // NOI18N
        HONORABLE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HONORABLE1ActionPerformed(evt);
            }
        });

        ENROLL1.setBackground(new java.awt.Color(51, 51, 51));
        ENROLL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/default.png"))); // NOI18N
        ENROLL1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        ENROLL1.setFocusPainted(false);
        ENROLL1.setRolloverEnabled(true);
        ENROLL1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/hover.png"))); // NOI18N
        ENROLL1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/Enrollment/hover.png"))); // NOI18N
        ENROLL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENROLL1ActionPerformed(evt);
            }
        });

        MORAL1.setBackground(new java.awt.Color(51, 51, 51));
        MORAL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/default.png"))); // NOI18N
        MORAL1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        MORAL1.setFocusPainted(false);
        MORAL1.setRolloverEnabled(true);
        MORAL1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/hover.png"))); // NOI18N
        MORAL1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/GOOD MORAL/hover.png"))); // NOI18N
        MORAL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MORAL1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(MORAL1)
                                .addGap(18, 18, 18)
                                .addComponent(ENROLL1)
                                .addGap(18, 18, 18)
                                .addComponent(HONORABLE1)
                                .addGap(18, 18, 18)
                                .addComponent(CLEAR4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CLEAR4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HONORABLE1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ENROLL1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MORAL1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane6))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Certificates (senior high)     ", jPanel26);

        jPanel63.setBackground(new java.awt.Color(253, 253, 255));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPPER BAR/Untitled-1.png"))); // NOI18N
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jLabel4.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel4MouseWheelMoved(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPPER BAR/folder.png"))); // NOI18N
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPPER BAR/refresh.png"))); // NOI18N
        jLabel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel8MouseMoved(evt);
            }
        });
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPPER BAR/viewdata.png"))); // NOI18N
        jLabel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel9MouseMoved(evt);
            }
        });
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPPER BAR/exdata.png"))); // NOI18N
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel10MouseMoved(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Digos Central Adventist Academy, Inc.");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel12.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("CLICK HERE");
        jLabel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel12MouseMoved(evt);
            }
        });
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Note: If theres any problem try to ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, 1173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(11, 11, 11))
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

        setSize(new java.awt.Dimension(1461, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchCaretUpdate
        LoadSearchDataStudent();
    }//GEN-LAST:event_searchCaretUpdate

    private void STUDENT_ACCOUNTSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTSFocusGained

        if( STUDENT_ACCOUNTS.getText().trim().equals("None"))
        {
            STUDENT_ACCOUNTS.setText("");
            STUDENT_ACCOUNTS.setForeground(Color.black);
        }
    }//GEN-LAST:event_STUDENT_ACCOUNTSFocusGained

    private void STUDENT_ACCOUNTSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTSFocusLost

        if ( STUDENT_ACCOUNTS.getText().trim().isEmpty()) {
            STUDENT_ACCOUNTS.setForeground(new Color(51,51,51));
            STUDENT_ACCOUNTS.setText("None");
        }
    }//GEN-LAST:event_STUDENT_ACCOUNTSFocusLost

    private void STUDENT_ACCOUNTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STUDENT_ACCOUNTSActionPerformed

    private void STUDENT_ACCOUNTSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STUDENT_ACCOUNTSKeyPressed

    }//GEN-LAST:event_STUDENT_ACCOUNTSKeyPressed

    private void LRNNOFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LRNNOFocusGained

        if(LRNNO.getText().trim().equals("None"))
        {
            LRNNO.setText("");
            LRNNO.setForeground(Color.black);
        }
    }//GEN-LAST:event_LRNNOFocusGained

    private void LRNNOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LRNNOFocusLost

        if (LRNNO.getText().trim().isEmpty()) {
            LRNNO.setForeground(new Color(51,51,51));
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

    private void fullnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullnameFocusGained

        if( fullname.getText().trim().equals("Last Name,  First Name   Middle Name"))
        {
            fullname.setText("");
            fullname.setForeground(Color.black);
        }
    }//GEN-LAST:event_fullnameFocusGained

    private void fullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullnameFocusLost

        if(fullname.getText().trim().equals(""))
        {
            fullname.setText("Last Name,  First Name   Middle Name");
            fullname.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_fullnameFocusLost

    private void fullnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fullnameKeyReleased
        int position = fullname.getCaretPosition();
       fullname.setText(fullname.getText().toUpperCase());
      fullname.setCaretPosition(position);
    }//GEN-LAST:event_fullnameKeyReleased

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleActionPerformed

    private void AGESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AGESKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_AGESKeyTyped

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
            MOTHERTONGUE.setForeground(new Color(153,153,153));
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
            FATHERNAME.setForeground(new Color(153,153,153));
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
            MOTHERNAME.setForeground(new Color(153,153,153));
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
            GUARDIAN.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_GUARDIANFocusLost

    private void GUARDIANKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GUARDIANKeyReleased

    }//GEN-LAST:event_GUARDIANKeyReleased

    private void TELNOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TELNOKeyTyped

    }//GEN-LAST:event_TELNOKeyTyped

    private void CELPHONEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CELPHONEKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) ) {

            evt.consume();

        }
    }//GEN-LAST:event_CELPHONEKeyTyped

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
            ZIPCODE.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_ZIPCODEFocusLost

    private void ZIPCODEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZIPCODEKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) ) {

            evt.consume();

        }

        if (ZIPCODE.getText().length() >= 4 ) // limit to 3 characters
        evt.consume();
    }//GEN-LAST:event_ZIPCODEKeyTyped

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
            SCHOOLNAME.setForeground(new Color(153,153,153));
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
            SCHOOLID.setForeground(new Color(153,153,153));
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
            SCHOOLADDRESS.setForeground(new Color(153,153,153));
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
            GRADELEVEL.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_GRADELEVELFocusLost

    private void jTableStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStudentsMouseClicked
        DefaultTableModel model2 =  (DefaultTableModel)jTableStudents.getModel() ;
        int selecIndex = jTableStudents.getSelectedRow();
        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();

        schoolyr.setSelectedItem(model2.getValueAt(selecIndex, 1).toString());
        LRNS.setSelectedItem(model2.getValueAt(selecIndex, 2).toString() );
        STUDENT_ACCOUNTS.setText(model2.getValueAt(selecIndex, 3).toString());
        LRNNO.setText(model2.getValueAt(selecIndex, 4).toString());
        fullname.setText(model2.getValueAt(selecIndex, 5).toString());
        Date bdate;
        try {

            bdate=new SimpleDateFormat("yyyy-MM-dd").parse(model2.getValueAt(selecIndex, 6).toString());
            jDateChooser1.setDate(bdate);
        } catch (ParseException ex) {
            Logger.getLogger(Add_Students.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (model2.getValueAt(selecIndex, 7).toString().equals("Male")) {
            Male.setSelected(true);
            Female.setSelected(false);
        }else {
            Female.setSelected(true);
            Male.setSelected(false);
        }
        AGES.setText(model2.getValueAt(selecIndex, 8).toString());
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
        TRACKS.setSelectedItem(model2.getValueAt(selecIndex, 25).toString() );
        STRAND.setSelectedItem(model2.getValueAt(selecIndex, 26).toString() );
        GRADELEVEL.setText(model2.getValueAt(selecIndex, 27).toString());
        TRACK_ENROLLED.setSelectedItem(model2.getValueAt(selecIndex, 28).toString() );
    }//GEN-LAST:event_jTableStudentsMouseClicked

    private void searchinsertCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchinsertCaretUpdate

    }//GEN-LAST:event_searchinsertCaretUpdate

    private void searchinsertKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchinsertKeyReleased

        LoadSearchDataFiles();
    }//GEN-LAST:event_searchinsertKeyReleased

    private void file_textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_file_textFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_file_textFocusGained

    private void file_textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_file_textFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_file_textFocusLost

    private void file_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_file_textKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_file_textKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        JFileChooser jfchoose = new JFileChooser();
        jfchoose.showOpenDialog(this);

        try {

            File file = jfchoose.getSelectedFile();
            path = file.getAbsoluteFile().toString();
            file_text.setText(file.getName());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTableinsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableinsertMouseClicked

        DefaultTableModel model2 =  (DefaultTableModel)jTableinsert.getModel() ;
        int selecIndex = jTableinsert.getSelectedRow();

        //        schoolyr.setSelectedItem(model2.getValueAt(selecIndex, 1).toString());
        stnames.setSelectedItem(model2.getValueAt(selecIndex, 1).toString());
        file_text.setText(model2.getValueAt(selecIndex, 2).toString());

        //        while (file_text.equals(true)) {
            //
            //            path = filed.getAbsoluteFile().toString();
            //
            //        }

    }//GEN-LAST:event_jTableinsertMouseClicked

    private void jTableinsertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableinsertMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableinsertMouseEntered

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed

        
        
        try {
            
       
          if (verifyTextFiles()) {

            
            STUDENT stud = (STUDENT)stnames.getSelectedItem();
            

            DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now= LocalDateTime.now();
            String timestamp = dtf.format(now);

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps = null;
                ps=Mycon.prepareStatement("INSERT INTO insert_data_file ( enrolled_students_id,file_name, file_size_in_kb, file_extension, file_content, timestamp)VALUES(?,?,?,?,?,?)");

                if (verifyTextFiles()) {

                    filed = new File (path);
                    
                    

                    System.out.println("Following files are saved in database..");
                    System.out.println(filed.getName());

                    String fileName = filed.getName();

                    long fileLength =filed.length();

                    long fileLengthInKb=fileLength/1024;

                 
                    ps.setInt(1, stud.id);
                    //ps.setString(2, none);
                    ps.setString(2, fileName);
                    ps.setLong(3, fileLengthInKb);
                    ps.setString(4, fileName.substring(fileName.lastIndexOf(".")+1));
                    FileInputStream fis = new FileInputStream(filed);
                    ps.setBinaryStream(5, fis, fileLength);
                    ps.setString(6,timestamp);
                    ps.execute();

                    table_update_files();
                    //                                schoolyr.setSelectedIndex(-1);
                    
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
        
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, " Unable to Save" + "\n Please Fill in all the Necessary Student Basic Information");
            
        }
        
        
      
    }//GEN-LAST:event_SAVEActionPerformed

    private void UPDATE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE1ActionPerformed

        try {

            if (verifyTextFiles()) {

                DefaultTableModel model2 =  (DefaultTableModel)jTableinsert.getModel() ;
                int selecIndex= jTableinsert.getSelectedRow();

                int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                
                if (id == -1) {
                    
                    
                    JOptionPane.showMessageDialog(this, "File is already Exist");
                    
                    
                } else {
                    
                    try {
                        
                        STUDENT stud =  (STUDENT)  stnames.getSelectedItem();
                        
                   
                       

                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("update insert_data_file set enrolled_students_id=?, file_name=?, file_size_in_kb=?, file_extension=?, file_content=? where id=?");

                    if (verifyTextFiles()) {

                        if (path == null) {

                            JOptionPane.showMessageDialog(this, "Error");
                        } else {

                            filed = new File (path);
                            System.out.println("Following files are saved in database..");
                            System.out.println(filed.getName());

                            String fileName = filed.getName();

                            long fileLength =filed.length();

                            long fileLengthInKb=fileLength/1024;

                            // ps.setInt(1, sy.id);
                            ps.setInt(1, stud.id);
                            ps.setString(2, fileName);
                            ps.setLong(3, fileLengthInKb);
                            ps.setString(4, fileName.substring(fileName.lastIndexOf(".")+1));

                            FileInputStream fis = new FileInputStream(filed);
                            ps.setBinaryStream(5, fis, fileLength);

                            ps.setInt(6,id);

                            ps.executeUpdate();
                            table_update_files();

                            JOptionPane.showMessageDialog(null, "Student Successfully Updated");
                            file_text.setText("");

                        }

                    }
                } catch (ClassNotFoundException | SQLException ex) {

                    JOptionPane.showMessageDialog(this, ex," Unable to Update" + "\n Student ID is not Specified", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(Add_Records.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                
                
                
                 } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, " Unable to Update" + "\n Student ID is not Specified");
                    }
                
                
            }
                    
                }
               

        } catch (HeadlessException | NumberFormatException e) {

             JOptionPane.showMessageDialog(this, " Unable to Update" + "\n Student ID is not Specified");
        }
    }//GEN-LAST:event_UPDATE1ActionPerformed

    private void DOWNLOADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOWNLOADActionPerformed

        try {
            
//             if (verifyTextFiles()) {

            DefaultTableModel model2 =  (DefaultTableModel)jTableinsert.getModel() ;
            int selecIndex = jTableinsert.getSelectedRow();
            int row = jTableinsert.getSelectedRow();
            int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
            String tc = jTableinsert.getModel().getValueAt(row, 0).toString();

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("SELECT * from insert_data_file where  id="+tc+" ");

//                if (verifyTextFiles())
//                {
                    ResultSet rs = ps.executeQuery();
                    System.out.println("Following flies are downloaded from database..");

                    while (rs.next()) {

                        int fileId = rs.getInt("id");
                        String fileName = rs.getString("file_name");
                        long fileSizeInKb = rs.getLong("file_size_in_kb");
                        String fileExtension = rs.getString("file_extension");
                        System.out.println("File Id:"+fileId);
                        System.out.println("File Name:"+fileName);
                        System.out.println("File Size In KB:"+fileSizeInKb);
                        System.out.println("File Extension:"+fileExtension);

                        Blob blob = (Blob) rs.getBlob("file_content");
                        InputStream inputStreams = blob.getBinaryStream();

                        System.out.println("-----------------------------------");
                        String home = System.getProperty("user.home");
                        File filez = new File(home+"/Downloads/" + fileName);
                        Files.copy(inputStreams, Paths.get(filez + fileName));
                    }

                    table_update_files();
                    //                schoolyr.setSelectedIndex(-1);
                    
                    JOptionPane.showMessageDialog(this, "Successfully Download");
                    fullname.setText("");
                    file_text.setText("");

               // }

            }catch (ClassNotFoundException | SQLException  ex) {
                Logger.getLogger(Add_Students.class.getName()).log(Level.SEVERE, null, ex);
            }    catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Already Downloaded","Message",JOptionPane.ERROR_MESSAGE);
               // Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}
            
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, "Download Faild");
            
        }
        
       
    }//GEN-LAST:event_DOWNLOADActionPerformed

    private void DELETE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE1ActionPerformed

        
        try {
               
        if (verifyTextFiles()) {

            DefaultTableModel model2 =  (DefaultTableModel)jTableinsert.getModel() ;
            int selecIndex = jTableinsert.getSelectedRow();
            int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record","Warning",JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION)

            {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("delete from insert_data_file where id=?");
                    ps.setInt(1, id);

                    if (verifyTextFiles()) {

                        ps.execute();
                        //                schoolyr.setSelectedIndex(-1);
                        
                        

                        table_update_files();
                        JOptionPane.showMessageDialog(null, "Successfully Deleted");
                        file_text.setText("");
                    }
                }catch (ClassNotFoundException | SQLException  ex) {
                    Logger.getLogger(Add_Students.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                JOptionPane.showMessageDialog(null, "Then please Proceed");

            }
        }
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Unable to Delete" + "\n Student ID is not Specified");
        }
        
     
    }//GEN-LAST:event_DELETE1ActionPerformed

    private void CLEAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR1ActionPerformed

    }//GEN-LAST:event_CLEAR1ActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
          LRNS.setSelectedIndex(0);
                    STUDENT_ACCOUNTS.setText("None");
                    LRNNO.setText("None");
                    fullname.setText("Last Name,  First Name   Middle Name");
                    Male.setSelected(true);
                    Female.setSelected(true);
                    No.setSelected(false);
                    Yes.setSelected(false);
                    AGES.setText("");
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
                    TRACKS.setSelectedIndex(0);
                    STRAND.setSelectedIndex(0);
                    GRADELEVEL.setText("None");
                    TRACK_ENROLLED.setSelectedIndex(0);
    }//GEN-LAST:event_CLEARActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

        try {
            
               DefaultTableModel model2 =  (DefaultTableModel)jTableStudents.getModel() ;
         int selecIndex = jTableStudents.getSelectedRow();
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
                    LRNS.setSelectedIndex(-1);
                    STUDENT_ACCOUNTS.setText("None");
                    LRNNO.setText("None");
                    fullname.setText("Last Name,  First Name   Middle Name");
                    Male.setSelected(true);
                    Female.setSelected(true);
                    No.setSelected(false);
                    Yes.setSelected(false);
                    AGES.setText("");
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
                    TRACKS.setSelectedIndex(0);
                    STRAND.setSelectedIndex(0);
                    GRADELEVEL.setText("None");
                    TRACK_ENROLLED.setSelectedIndex(0);
            
            
        }catch (ClassNotFoundException | SQLException  ex) {
                        Logger.getLogger(Add_Students.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        } 
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(this, " Unable to Delete" + "\n Student ID is not Specified");
        }
        
        
     
    }//GEN-LAST:event_DELETEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed

        try {
            
                if (verifyText()) {
            
            DefaultTableModel model2 =  (DefaultTableModel)jTableStudents.getModel() ;
         int selecIndex= jTableStudents.getSelectedRow();
         int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
        
          
        SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String lrn = LRNS.getSelectedItem().toString();
        String psa =STUDENT_ACCOUNTS.getText();
        String lrnno=LRNNO.getText();
        String lname=fullname.getText();

        //      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //        String date = dateFormat.format(jDateChooser1.getDate());

        String age=AGES.getText();
        
        
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

        String track=TRACKS.getSelectedItem().toString();
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
                    LRNS.setSelectedIndex(-1);
                    STUDENT_ACCOUNTS.setText("None");
                    LRNNO.setText("None");
                    fullname.setText("Last Name,  First Name   Middle Name");
                    Male.setSelected(true);
                    Female.setSelected(true);
                    No.setSelected(false);
                    Yes.setSelected(false);
                    AGES.setText("");
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
                    TRACKS.setSelectedIndex(0);
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
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(this, " Unable to Update" + "\n Student ID is not Specified");
        }
        
       
        
        
        
    }//GEN-LAST:event_UPDATEActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed

        try {
            
             if (verifyText()) {
        
        SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem(); // SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();
        String rnl = LRNS.getSelectedItem().toString();
        String psa =STUDENT_ACCOUNTS.getText();
        String lrnno=LRNNO.getText();
        String lname=fullname.getText();

        //      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //        String date = dateFormat.format(jDateChooser1.getDate());

        String age=AGES.getText();
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

        String track=TRACKS.getSelectedItem().toString();
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
                ps.setString(2,rnl);
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
                    LRNS.setSelectedIndex(-1);
                    STUDENT_ACCOUNTS.setText("None");
                    LRNNO.setText("None");
                    fullname.setText("Last Name,  First Name   Middle Name");
                    Male.setSelected(true);
                    Female.setSelected(true);
                    No.setSelected(false);
                    Yes.setSelected(false);
                    AGES.setText("");
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
                    TRACKS.setSelectedIndex(0);
                    STRAND.setSelectedIndex(0);
                    GRADELEVEL.setText("None");
                    TRACK_ENROLLED.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Student Successfully Enrolled");
                }
            } catch (ClassNotFoundException | SQLException | ParseException  ex) {
               JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
            }
        
            
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, " Unable to Save" + "\n Please Fill in all the Necessary Student Basic Information");
            
        }
    }//GEN-LAST:event_ADDActionPerformed

    private void searchcertificatesJHSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchcertificatesJHSFocusGained

        if( searchcertificatesJHS.getText().trim().equals("Search Here. . . ."))
        {
            searchcertificatesJHS.setText("");
            searchcertificatesJHS.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchcertificatesJHSFocusGained

    private void searchcertificatesJHSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchcertificatesJHSFocusLost

        if(searchcertificatesJHS.getText().trim().equals(""))
        {
            searchcertificatesJHS.setText("Search Here. . . .");
            searchcertificatesJHS.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchcertificatesJHSFocusLost

    private void searchcertificatesJHSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchcertificatesJHSKeyReleased

       LoadSearchDataCertificatesJHS();
    }//GEN-LAST:event_searchcertificatesJHSKeyReleased

    private void jTableCERTIFICATESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCERTIFICATESMouseClicked

        DefaultTableModel model2 =  (DefaultTableModel)jTableCERTIFICATES.getModel() ;
        int selecIndex = jTableCERTIFICATES.getSelectedRow();
      

        
        lrnnoJH.setText(model2.getValueAt(selecIndex, 4).toString());
        studenameJH.setText(model2.getValueAt(selecIndex, 5).toString());

        if (model2.getValueAt(selecIndex, 7).toString().equals("Male")) {
            He.setSelected(true);
            She.setSelected(false);
        }else {
            She.setSelected(true);
            He.setSelected(false);
        }

        GRDAESLEVELSJH.setText(model2.getValueAt(selecIndex, 27).toString());
        //        TRACK.setText(model2.getValueAt(selecIndex, 28).toString());
    }//GEN-LAST:event_jTableCERTIFICATESMouseClicked

    private void HeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeActionPerformed

    private void SheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SheActionPerformed

    private void searchcertificateshsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchcertificateshsFocusGained

        
        if( searchcertificateshs.getText().trim().equals("Search Here. . . ."))
        {
            searchcertificateshs.setText("");
            searchcertificateshs.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchcertificateshsFocusGained

    private void searchcertificateshsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchcertificateshsFocusLost

        if(searchcertificateshs.getText().trim().equals(""))
        {
            searchcertificateshs.setText("Search Here. . . .");
            searchcertificateshs.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchcertificateshsFocusLost

    private void searchcertificateshsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchcertificateshsKeyReleased

        LoadSearchDataCertificatesSHS();
    }//GEN-LAST:event_searchcertificateshsKeyReleased

    private void jTableCERTIFICATESSHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCERTIFICATESSHSMouseClicked

        DefaultTableModel model2 =  (DefaultTableModel)jTableCERTIFICATESSHS.getModel() ;
        int selecIndex = jTableCERTIFICATESSHS.getSelectedRow();
        
        searchcertificateshs.setText("Search Here. . . .");

        //        SCHOOLYEARS.setText(model2.getValueAt(selecIndex, 1).toString());
        lrnnoSH.setText(model2.getValueAt(selecIndex, 4).toString());
        NAMESH.setText(model2.getValueAt(selecIndex, 5).toString());

        if (model2.getValueAt(selecIndex, 7).toString().equals("Male")) {
            He.setSelected(true);
            She.setSelected(false);
        }else {
            She.setSelected(true);
            He.setSelected(false);
        }

        GRADESSH.setText(model2.getValueAt(selecIndex, 27).toString());
        TRACKSH.setText(model2.getValueAt(selecIndex, 28).toString());
    }//GEN-LAST:event_jTableCERTIFICATESSHSMouseClicked

    private void csySHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csySHKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_csySHKeyTyped

    private void psySHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psySHKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_psySHKeyTyped

    private void NAMESHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NAMESHKeyReleased

        int position = studenameJH.getCaretPosition();
        studenameJH.setText(studenameJH.getText().toUpperCase());
        studenameJH.setCaretPosition(position);
    }//GEN-LAST:event_NAMESHKeyReleased

    private void sectioNsSHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectioNsSHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectioNsSHActionPerformed

    private void CLEAR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR4ActionPerformed
        psyJH.setText("");
        csyJH.setText("");
        lrnnoSH.setText("");
        studenameJH.setText("");
        GRDAESLEVELSJH.setText("");
        TRACKSH.setText("");
        sectioNsJH.setSelectedIndex(-1);
        registrarJH.setSelectedIndex(-1);
        regespositionJH.setSelectedIndex(-1);
        presJH.setSelectedIndex(-1);
        presposistionJH.setSelectedIndex(-1);
        vpresidentJH.setSelectedIndex(-1);
        vpresposisitionJH.setSelectedIndex(-1);
    }//GEN-LAST:event_CLEAR4ActionPerformed

    private void HONORABLE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HONORABLE1ActionPerformed

        if (verifyText_SHS()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                JasperDesign jdesign = JRXmlLoader.load("D:\\USERSsdasda\\Documents\\NetBeansProjects\\DCAA_REGISTRAR2\\src\\reportprint\\HonorableDismissal_shs.jrxml");
                String query="select * from certificate_of_enrollment";

                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);

                jdesign.setQuery(updateQuery);

                HashMap<String,Object> para = new HashMap<>();
                para.put("sy",psySH.getText() );
                para.put("future sy",csySH.getText() ); //
                para.put("lrn",lrnnoSH.getText());
                para.put("name",NAMESH.getText());
                para.put("grade", GRADESSH.getText());
                para.put("section",sectioNsSH.getSelectedItem().toString());
                para.put("trak", TRACKSH.getText());
                para.put("schoolregistrar", registrarSH.getSelectedItem().toString());
                para.put("regpos", regespositionSH.getSelectedItem().toString());
                para.put("president", presSH.getSelectedItem().toString());
                para.put("presiposisitons", presposistionSH.getSelectedItem().toString());

                //jTextField1

                JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                JasperPrint jprint =JasperFillManager.fillReport(jreport, para, Mycon);
                JasperViewer.viewReport(jprint, false);

            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (JRException ex) {
                Logger.getLogger(Certificates_SHS.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_HONORABLE1ActionPerformed

    private void ENROLL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENROLL1ActionPerformed

        if (verifyText_SHS()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                JasperDesign jdesign = JRXmlLoader.load("D:\\USERSsdasda\\Documents\\NetBeansProjects\\DCAA_REGISTRAR2\\src\\reportprint\\Certificate OfEnrollment_shs.jrxml");
                String query="select * from certificate_of_enrollment";

                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);

                jdesign.setQuery(updateQuery);

                HashMap<String,Object> para = new HashMap<>();
                para.put("sy",psySH.getText() );
                para.put("future sy",csySH.getText() ); //
                para.put("lrn",lrnnoSH.getText());
                para.put("name",NAMESH.getText());
                para.put("grade", GRADESSH.getText());
                para.put("section",sectioNsSH.getSelectedItem().toString()); //trak TRACK
                para.put("trak", TRACKSH.getText());
                para.put("schoolregistrar", registrarSH.getSelectedItem().toString());
                para.put("regpos", regespositionSH.getSelectedItem().toString());
                //para.put("schoolpresident", pres.getSelectedItem().toString());
                //  para.put("presiposisitons", presposistion.getSelectedItem().toString());

                JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                JasperPrint jprint =JasperFillManager.fillReport(jreport, para, Mycon);
               JasperViewer.viewReport(jprint, false);

            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (JRException ex) {
                Logger.getLogger(Certificates_SHS.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_ENROLL1ActionPerformed

    private void MORAL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MORAL1ActionPerformed

        if (verifyText_SHS()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                JasperDesign jdesign = JRXmlLoader.load("D:\\USERSsdasda\\Documents\\NetBeansProjects\\DCAA_REGISTRAR2\\src\\reportprint\\GoodMoral.jrxml");
                String query="select * from certificate_of_enrollment";

                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);

                jdesign.setQuery(updateQuery);

                HashMap<String,Object> para = new HashMap<>();
                para.put("sy",psySH.getText() );
                para.put("future sy",csySH.getText() ); //
                para.put("lrn",lrnnoSH.getText());
                para.put("name", NAMESH.getText());
                para.put("grade", GRADESSH.getText());
                para.put("section",sectioNsSH.getSelectedItem().toString());
                para.put("schoolregistrar", registrarSH.getSelectedItem().toString());
                para.put("posistion1", regespositionSH.getSelectedItem().toString());
                para.put("president", presSH.getSelectedItem().toString());
                para.put("position3", presposistionSH.getSelectedItem().toString());
                para.put("vp", vpresidentSH.getSelectedItem().toString());
                para.put("position2", vpresposisitionSH.getSelectedItem().toString());

                if (She.isSelected()) {
                    para.put("genders", "She");
                }else {

                    para.put("genders", "He");
                }

                //jTextField1

                JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                JasperPrint jprint =JasperFillManager.fillReport(jreport, para, Mycon);
                JasperViewer.viewReport(jprint, false);

            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (JRException ex) {
                Logger.getLogger(Certificates_SHS.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_MORAL1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       Mainframe s = new Mainframe();
       Mainframe.usernamedesk.setText(usernamedeskStudent.getText());
       this.hide();
       s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchcertificatesJHSCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchcertificatesJHSCaretUpdate

        LoadSearchDataCertificatesJHS();
    }//GEN-LAST:event_searchcertificatesJHSCaretUpdate

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

       AdminFrame a = new AdminFrame();
        AdminFrame.usernamedeskAdmin.setText(usernamedeskStudent.getText());
        this.hide();
        a.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        
        JOptionPane.showMessageDialog(this, " Unable to Close : " + "\n Please Log out Before you Leave   ","Message", JOptionPane.WARNING_MESSAGE);
        
        StudentFrame m = new StudentFrame();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

      
      ProfileFrame m = new ProfileFrame();
      ProfileFrame.usernamedeskProf.setText(usernamedeskStudent.getText());
      
      String emailname = usernamedeskStudent.getText();
      
       try {
                              Class.forName("com.mysql.cj.jdbc.Driver");
                              Mycon=DriverManager.getConnection("jdbc:mysql://127.1.1.2:3306/dcaa_registrar","root","root");  
                              PreparedStatement ps;
                              ps = Mycon.prepareStatement("select * from useraccount where username=?");
                              ps.setString(1, emailname);
                              ResultSet rs= ps.executeQuery();

                              
                                 if (rs.next() == false) {
                                      JOptionPane.showMessageDialog(null, "Email does not Exist");
                                     // email.setText("");
                                  } else {
                                      String fullname=rs.getString("fullname");
                                      int idd = rs.getInt("id");
                                      
                                     ProfileFrame.ids.setText(String.valueOf(idd));
                                     ProfileFrame.emailadd.setText(usernamedeskStudent.getText()); 
                                     ProfileFrame.usename.setText(fullname);
                                  }
                                    
                          } catch (ClassNotFoundException  ex) {
                              Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
                          }catch ( SQLException ex) {
                              Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
                          }
      this.dispose();
      m.setVisible(true);
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

          int dialogResult = JOptionPane.showConfirmDialog(null, "System Log out?","Warning",JOptionPane.YES_NO_OPTION);
         
         if (dialogResult == JOptionPane.YES_OPTION) 
         
         {
             
             Login l = new Login();
             this.dispose();
             l.setVisible(true);
            
             
             
         } else {
          
            Mainframe m = new Mainframe();
            this.dispose();
            m.setVisible(true);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void studenameJHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studenameJHKeyReleased

        int position = studenameJH.getCaretPosition();
        studenameJH.setText(studenameJH.getText().toUpperCase());
        studenameJH.setCaretPosition(position);
    }//GEN-LAST:event_studenameJHKeyReleased

    private void psyJHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psyJHKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_psyJHKeyTyped

    private void psyJHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psyJHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psyJHActionPerformed

    private void csyJHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csyJHKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_csyJHKeyTyped

    private void MORALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MORALActionPerformed

        if (verifyTextCertificatesJHS()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                JasperDesign jdesign = JRXmlLoader.load("D:\\USERSsdasda\\Documents\\NetBeansProjects\\DCAA_REGISTRAR2\\src\\reportprint\\GoodMoral.jrxml");
                String query="select * from certificate_of_enrollment";

                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);

                jdesign.setQuery(updateQuery);

                HashMap<String,Object> para = new HashMap<>();
                para.put("sy",psyJH.getText() );
                para.put("future sy",csyJH.getText() ); //
                para.put("lrn",lrnnoJH.getText());
                para.put("name",studenameJH.getText());
                para.put("grade", GRDAESLEVELSJH.getText());
                para.put("section",sectioNsJH.getSelectedItem().toString());
                para.put("schoolregistrar", registrarJH.getSelectedItem().toString());
                para.put("posistion1", regespositionJH.getSelectedItem().toString());
                para.put("president", presJH.getSelectedItem().toString());
                para.put("position3", presposistionJH.getSelectedItem().toString());
                para.put("vp", vpresidentJH.getSelectedItem().toString());
                para.put("position2", vpresposisitionJH.getSelectedItem().toString());

                if (She.isSelected()) {
                    para.put("genders", "She");
                }else {

                    para.put("genders", "He");
                }

                JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                JasperPrint jprint =JasperFillManager.fillReport(jreport, para, Mycon);

                JasperViewer.viewReport(jprint, false);

            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Certificates_JHS.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(Certificates_JHS.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_MORALActionPerformed

    private void ENROLLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENROLLActionPerformed

        if (verifyTextCertificatesJHS()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                //                JasperDesign jdesign = JRXmlLoader.load("D:\\USERSsdasda\\Documents\\NetBeansProjects\\DCAA_REGISTRAR2\\src\\report_records\\enrollment_grade.jrxml");
                JasperDesign jdesign = JRXmlLoader.load("D:\\USERSsdasda\\Documents\\NetBeansProjects\\DCAA_REGISTRAR2\\src\\reportprint\\Certificate OfEnrollment_jhs.jrxml");
                String query="select * from certificate_of_enrollment";

                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);

                jdesign.setQuery(updateQuery);

                HashMap<String,Object> para = new HashMap<>();
                para.put("sy",psyJH.getText() );
                para.put("future sy",csyJH.getText() ); //
                para.put("lrn",lrnnoJH.getText());
                para.put("name",studenameJH.getText());
                para.put("grade", GRDAESLEVELSJH.getText());
                para.put("section",sectioNsJH.getSelectedItem().toString()); //trak TRACK
                //                para.put("trak", TRACK.getText());
                para.put("schoolregistrar", registrarJH.getSelectedItem().toString());
                para.put("regpos", regespositionJH.getSelectedItem().toString());
                //para.put("schoolpresident", pres.getSelectedItem().toString());
                //  para.put("presiposisitons", presposistion.getSelectedItem().toString());

                //jTextField1

                JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                JasperPrint jprint =JasperFillManager.fillReport(jreport, para, Mycon);

                JasperViewer.viewReport(jprint, false);

            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Certificates_JHS.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(Certificates_JHS.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_ENROLLActionPerformed

    private void HONORABLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HONORABLEActionPerformed

        if (verifyTextCertificatesJHS()) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                JasperDesign jdesign = JRXmlLoader.load("D:\\USERSsdasda\\Documents\\NetBeansProjects\\DCAA_REGISTRAR2\\src\\reportprint\\HonorableDismissal_jhs.jrxml");

                String query="select * from certificate_of_enrollment";

                JRDesignQuery updateQuery = new JRDesignQuery();
                updateQuery.setText(query);

                jdesign.setQuery(updateQuery);

                HashMap<String,Object> para = new HashMap<>();
                para.put("sy",psyJH.getText() );
                para.put("future sy",csyJH.getText() ); //
                para.put("lrn",lrnnoJH.getText());
                para.put("name",studenameJH.getText());
                para.put("grade", GRDAESLEVELSJH.getText());
                para.put("section",sectioNsJH.getSelectedItem().toString());
                //                para.put("trak", TRACK.getText());
                para.put("schoolregistrar", registrarJH.getSelectedItem().toString());
                para.put("regpos", regespositionJH.getSelectedItem().toString());
                para.put("president", presJH.getSelectedItem().toString());
                para.put("presiposisitons", presposistionJH.getSelectedItem().toString());

                //jTextField1

                JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                JasperPrint jprint =JasperFillManager.fillReport(jreport, para, Mycon);

                // JasperViewer.viewReport(jprint);
                JasperViewer.viewReport(jprint, false);

            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Certificates_JHS.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(Certificates_JHS.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_HONORABLEActionPerformed

    private void CLEAR6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR6ActionPerformed

        psyJH.setText("");
        csyJH.setText("");
        lrnnoSH.setText("");
        studenameJH.setText("");
        GRDAESLEVELSJH.setText("");
        sectioNsJH.setSelectedIndex(-1);
        registrarJH.setSelectedIndex(-1);
        regespositionJH.setSelectedIndex(-1);
        presJH.setSelectedIndex(-1);
        presposistionJH.setSelectedIndex(-1);
        vpresidentJH.setSelectedIndex(-1);
        vpresposisitionJH.setSelectedIndex(-1);
    }//GEN-LAST:event_CLEAR6ActionPerformed

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved

        
        
          jLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved

       jLabel7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel7MouseMoved

    private void jLabel8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseMoved

        jLabel8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel8MouseMoved

    private void jLabel9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseMoved

        jLabel9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel9MouseMoved

    private void jLabel10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseMoved

      jLabel10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel10MouseMoved

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
//            JFileChooser save = new JFileChooser();
//    save.setDialogTitle("Save as...");
//    save.setFileFilter(new FileNameExtensionFilter("xls", "xlsx", "xlsm"));
//    int choose = save.showSaveDialog(null);
//
//    if(choose == JFileChooser.APPROVE_OPTION) {
//        XSSFWorkbook export = new XSSFWorkbook();
//        XSSFSheet sheet1 = export.createSheet("new file");
//        try{
//            TableModel tableModel = jTableStudents.getModel();
//
//            for(int i=0; i<tableModel.getRowCount(); i++) {
//                XSSFRow newRow = sheet1.createRow(i);
//                for(int j=0; j<tableModel.getColumnCount(); j++) {
//                    XSSFCell newCell = newRow.createCell((short) j);
//                    if(i==0){
//                        
//                        XSSFCellStyle style = export.createCellStyle();
//                        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
//                        //style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//                        style.setBorderBottom(BorderStyle.THIN);
//                        style.setBorderTop(BorderStyle.THIN);
//                        style.setBorderLeft(BorderStyle.THIN);
//                        style.setBorderRight(BorderStyle.THIN);
//                        newCell.setCellStyle(style);
//                        newCell.setCellValue(tableModel.getColumnName(j));
//                        
//                        
//                    } else {
//                        
//                        XSSFCellStyle style = export.createCellStyle();
//                        style.setBorderBottom(BorderStyle.THIN);
//                        style.setBorderTop(BorderStyle.THIN);
//                        style.setBorderLeft(BorderStyle.THIN);
//                        style.setBorderRight(BorderStyle.THIN);
//                        newCell.setCellStyle(style);
//                        newCell.setCellValue(tableModel.getValueAt(i, j).toString());
//                    
//                    }
//                }
//            }
//
//            try (FileOutputStream otp = new FileOutputStream(save.getSelectedFile()+".xlsx"); 
//                 BufferedOutputStream bos = new BufferedOutputStream(otp)) {
//                export.write(bos);
//            }
//
//            JOptionPane.showMessageDialog(null, "Student Data Export Successfully");
//        }catch(HeadlessException | IOException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }

    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed

    }//GEN-LAST:event_jLabel9MousePressed

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased

    }//GEN-LAST:event_jPanel2MouseReleased

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased

    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel4MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel4MouseWheelMoved

    }//GEN-LAST:event_jLabel4MouseWheelMoved

    private void jPanel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseReleased
//          if (evt.isPopupTrigger()) 
//        {
//
//             jPopupMenu1.show(this, evt.getX(), evt.getY());
//
//        }
    }//GEN-LAST:event_jPanel9MouseReleased

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        BackUp_DataBase bk = new BackUp_DataBase();
        this.show();
        bk.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        StudentFrame s = new StudentFrame();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

       
        Officialy_Enrolled s = new Officialy_Enrolled();
        this.show();
        s.setVisible(true);
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

       Add_Records s = new Add_Records();
        this.show();
        s.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        
      // DefaultTableModel modelStudent =  (DefaultTableModel)jTableStudents.getModel() ;
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
//                for (int i = 0; i < jTableStudents.getRowCount(); i++) {
//                
//                    for (int j = 0; j <  jTableStudents.getColumnCount(); j++) {
//                        //write
//                        bw.write(jTableStudents.getValueAt(i, j).toString()+ ",");
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
        
        Export_Data s = new Export_Data();
        this.show();
        s.setVisible(true);
    
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseMoved

        jLabel12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    }//GEN-LAST:event_jLabel12MouseMoved

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       
        StudentFrame s = new StudentFrame();
        s.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void searchinsertFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchinsertFocusGained
        
        if(searchinsert.getText().trim().equals("Search Here . . ."))
        {
           searchinsert.setText("");
           searchinsert.setForeground(Color.black);
        }
  
    }//GEN-LAST:event_searchinsertFocusGained

    private void searchinsertFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchinsertFocusLost
        if(searchinsert.getText().trim().equals(""))
        {
            searchinsert.setText("Search Here . . .");
            searchinsert.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchinsertFocusLost

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
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new StudentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField ADDRESS;
    private javax.swing.JTextField AGES;
    private javax.swing.JFormattedTextField CELPHONE;
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton CLEAR1;
    private javax.swing.JButton CLEAR4;
    private javax.swing.JButton CLEAR6;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton DELETE1;
    private javax.swing.JButton DOWNLOAD;
    private javax.swing.JButton ENROLL;
    private javax.swing.JButton ENROLL1;
    private javax.swing.JTextField FATHERNAME;
    private javax.swing.JCheckBox Female;
    private javax.swing.JTextField GRADELEVEL;
    private javax.swing.JTextField GRADESSH;
    private javax.swing.JLabel GRADE_LEVEL;
    private javax.swing.JTextField GRDAESLEVELSJH;
    private javax.swing.JTextField GUARDIAN;
    private javax.swing.JButton HONORABLE;
    private javax.swing.JButton HONORABLE1;
    private javax.swing.JCheckBox He;
    private javax.swing.JComboBox LEVELCOMPLETED;
    private javax.swing.JTextField LRNNO;
    private javax.swing.JComboBox LRNS;
    private javax.swing.JButton MORAL;
    private javax.swing.JButton MORAL1;
    private javax.swing.JTextField MOTHERNAME;
    private javax.swing.JTextField MOTHERTONGUE;
    private javax.swing.JCheckBox Male;
    private javax.swing.JTextField NAMESH;
    private javax.swing.JCheckBox No;
    private javax.swing.JButton SAVE;
    private javax.swing.JTextField SCHOOLADDRESS;
    private javax.swing.JTextField SCHOOLID;
    private javax.swing.JTextField SCHOOLNAME;
    private javax.swing.JComboBox STRAND;
    private javax.swing.JTextField STUDENT_ACCOUNTS;
    private javax.swing.JFormattedTextField SYCOMPLETED;
    private javax.swing.JComboBox Semester;
    private javax.swing.JCheckBox She;
    private javax.swing.JFormattedTextField TELNO;
    private javax.swing.JComboBox TRACKS;
    private javax.swing.JTextField TRACKSH;
    private javax.swing.JComboBox TRACK_ENROLLED;
    private javax.swing.JLabel TRACK_STRAND;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton UPDATE1;
    private javax.swing.JTextField YES_IPSPECIFY;
    private javax.swing.JCheckBox Yes;
    private javax.swing.JTextField ZIPCODE;
    private javax.swing.JFormattedTextField csyJH;
    private javax.swing.JFormattedTextField csySH;
    private javax.swing.JTextField file_text;
    private javax.swing.JTextField fullname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
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
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
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
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCERTIFICATES;
    private javax.swing.JTable jTableCERTIFICATESSHS;
    private javax.swing.JTable jTableStudents;
    private javax.swing.JTable jTableinsert;
    private javax.swing.JTextField lrnnoJH;
    private javax.swing.JTextField lrnnoSH;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JComboBox presJH;
    private javax.swing.JComboBox presSH;
    private javax.swing.JComboBox presposistionJH;
    private javax.swing.JComboBox presposistionSH;
    private javax.swing.JFormattedTextField psyJH;
    private javax.swing.JFormattedTextField psySH;
    private javax.swing.JComboBox regespositionJH;
    private javax.swing.JComboBox regespositionSH;
    private javax.swing.JComboBox registrarJH;
    private javax.swing.JComboBox registrarSH;
    private javax.swing.JComboBox schoolyr;
    private javax.swing.JTextField search;
    private javax.swing.JTextField searchcertificatesJHS;
    private javax.swing.JTextField searchcertificateshs;
    private javax.swing.JTextField searchinsert;
    private javax.swing.JComboBox sectioNsJH;
    private javax.swing.JComboBox sectioNsSH;
    private javax.swing.JComboBox stnames;
    private javax.swing.JTextField studenameJH;
    public static javax.swing.JLabel usernamedeskStudent;
    private javax.swing.JComboBox vpresidentJH;
    private javax.swing.JComboBox vpresidentSH;
    private javax.swing.JComboBox vpresposisitionJH;
    private javax.swing.JComboBox vpresposisitionSH;
    // End of variables declaration//GEN-END:variables
}
