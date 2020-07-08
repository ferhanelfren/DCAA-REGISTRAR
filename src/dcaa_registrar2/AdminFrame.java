/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_registrar2;

import trials.table_suggetions;
import static com.jtransc.event.JTranscEventLoop.frame;
import static dcaa_registrar2.StudentFrame.usernamedeskStudent;
import java.awt.Color;
import java.awt.Component;

import java.awt.Font;

import java.io.File;

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
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author GOD
 */
public class AdminFrame extends javax.swing.JFrame {

String path;
File filed;
    
    /**
     * Creates new form mainframe
     */
    public AdminFrame() {
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
        bg2.add(Male1);
        bg2.add(Female1);
        
        ButtonGroup bg3 = new ButtonGroup();
        bg3.add(Malevice);
        bg3.add(Femalevice);
        
        ButtonGroup bg4 = new ButtonGroup();
        bg4.add(Malereg);
        bg4.add(Femalereg);
     
       SomeWindow();
       table_update();
       tableEditFormat();
     

    }
    
    
    Connection Mycon;
    //ResultSet rs;
    
    
 
    
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


 private void table_update()
    {
               int c;              
                                            try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select * from school_year");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTableSchoolYear.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("id")); 
                                                          v.add(rs.getString("school_year_name"));
                                                           v.add(rs.getString("timestamp"));
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                            
                                            
                                                 try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select * from school_president_director");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTableSchoolPresident.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("id")); 
                                                          v.add(rs.getString("fullname"));
                                                           
                                                           v.add(rs.getString("status"));
                                                           v.add(rs.getString("gender"));
                                                         
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                            
                                                 
                                                        try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select * from school_registrar_incharge");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTableRegistrar.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("id")); 
                                                          v.add(rs.getString("fullname"));
                                                           
                                                           v.add(rs.getString("status"));
                                                           v.add(rs.getString("gender"));
                                                         
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                         
                                         try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select * from school_vicepresident");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTableSchoolVice.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("id")); 
                                                          v.add(rs.getString("fullname"));
                                                           
                                                           v.add(rs.getString("status"));
                                                           v.add(rs.getString("gender"));
                                                         
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }                
                                              
                                         
                                         
                                           try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select * from sections");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTableSection.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("id")); 
                                                          v.add(rs.getString("section_name"));
                                                          
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }    
                                           
                                              try {       
                                           Class.forName("com.mysql.cj.jdbc.Driver");
                                           Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root"); 
                                           PreparedStatement ps;   
                                           ps=Mycon.prepareStatement("select * from useraccount");
                                           ResultSet rs = ps.executeQuery();
                                            ResultSetMetaData rsd=rs.getMetaData();
                                                c = rsd.getColumnCount();            
                                                DefaultTableModel model =  (DefaultTableModel)jTableUserAccount.getModel() ;
                                                
                                            model.setRowCount(0);
                                                while (rs.next()) 
                                                {          
                                                    Vector v = new Vector();
                                                    for (int i = 0; i <= 35; i++) 
                                                    { 
                                                         v.add(rs.getString("id")); 
                                                          v.add(rs.getString("username"));
                                                          v.add(rs.getString("fullname"));
                                                          v.add(rs.getString("gender"));
                                                          v.add(rs.getString("question"));
                                                          v.add(rs.getString("answer"));
                                                          v.add(rs.getString("password"));
                                                          
                                                    }
                                                    model.addRow(v); 
                                                }
                                        }  catch (ClassNotFoundException | SQLException  ex) {
                                               JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }      
                                                       
                                            
    }
       
       
       private void tableEditFormat()
       {
           
            
                                                 jTableSchoolYear.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,14));
                                                jTableSchoolYear.getTableHeader().setOpaque(false);
                                                jTableSchoolYear.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableSchoolYear.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableSchoolYear.getRowHeight(10);
                                                

                                                DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)  jTableSchoolYear.getTableHeader().getDefaultRenderer();
                                                renderer.setHorizontalAlignment(SwingConstants.CENTER);

                                               TableColumn col = jTableSchoolYear.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
                                                    dtcr.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col.setCellRenderer(dtcr);
                                                    
                                                    jTableSchoolYear.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                    
                                                    
                                                    
                                                
                                                      jTableSchoolPresident.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,15));
                                                jTableSchoolPresident.getTableHeader().setOpaque(false);
                                                jTableSchoolPresident.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableSchoolPresident.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableSchoolPresident.getRowHeight(20);
                                                
                                                DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer)   jTableSchoolPresident.getTableHeader().getDefaultRenderer();
                                                renderer2.setHorizontalAlignment(SwingConstants.CENTER);
                                          

                                                jTableSchoolPresident.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                jTableSchoolPresident.getColumnModel().getColumn(3).setPreferredWidth(10);
                                              
                                                    
                                                 TableColumn col2 = jTableSchoolPresident.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr2 = new DefaultTableCellRenderer();  
                                                    dtcr2.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col2.setCellRenderer(dtcr);
                                                    
                                                    
                                                    
                                                
                                                  jTableRegistrar.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,15));
                                                jTableRegistrar.getTableHeader().setOpaque(false);
                                                jTableRegistrar.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableRegistrar.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableRegistrar.getRowHeight(20);
                                                DefaultTableCellRenderer renderer3 = (DefaultTableCellRenderer)  jTableRegistrar.getTableHeader().getDefaultRenderer();
                                                renderer3.setHorizontalAlignment(SwingConstants.CENTER);

                                                jTableRegistrar.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                jTableRegistrar.getColumnModel().getColumn(3).setPreferredWidth(10);
                                              
                                                
                                                 TableColumn col3 = jTableRegistrar.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr3 = new DefaultTableCellRenderer();  
                                                    dtcr3.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col3.setCellRenderer(dtcr);
                                                    
                                                    
                                                    
                                                    jTableSchoolVice.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,15));
                                                jTableSchoolVice.getTableHeader().setOpaque(false);
                                                jTableSchoolVice.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableSchoolVice.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableSchoolVice.getRowHeight(20);
                                                DefaultTableCellRenderer renderer4 = (DefaultTableCellRenderer)  jTableSchoolVice.getTableHeader().getDefaultRenderer();
                                                renderer4.setHorizontalAlignment(SwingConstants.CENTER);

                                                jTableSchoolVice.getColumnModel().getColumn(0).setPreferredWidth(10);
                                                jTableSchoolVice.getColumnModel().getColumn(3).setPreferredWidth(10);

                                                 TableColumn col4 = jTableSchoolVice.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr4 = new DefaultTableCellRenderer();  
                                                    dtcr4.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col4.setCellRenderer(dtcr);
                                                    
                                                    
                                                    
                                                    
                                                jTableSection.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,15));
                                                jTableSection.getTableHeader().setOpaque(false);
                                                jTableSection.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableSection.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableSection.getRowHeight(20);
                                                DefaultTableCellRenderer renderer5 = (DefaultTableCellRenderer)  jTableSection.getTableHeader().getDefaultRenderer();
                                                renderer5.setHorizontalAlignment(SwingConstants.CENTER);

                                                

                                                 TableColumn col5 = jTableSection.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr5 = new DefaultTableCellRenderer();  
                                                    dtcr5.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col5.setCellRenderer(dtcr);
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    jTableUserAccount.getTableHeader().setFont(new Font("Segui UI", Font.BOLD,15));
                                                jTableUserAccount.getTableHeader().setOpaque(false);
                                                jTableUserAccount.getTableHeader().setBackground(new Color(165,19,29));
                                                jTableUserAccount.getTableHeader().setForeground(new Color(255,255,255));
                                                jTableUserAccount.getRowHeight(20);
//                                                DefaultTableCellRenderer rightRenderer6 = new DefaultTableCellRenderer();
//                                                rightRenderer6.setHorizontalAlignment(JLabel.RIGHT);
                                                    
                                                
                                                 DefaultTableCellRenderer renderer6 = (DefaultTableCellRenderer)  jTableUserAccount.getTableHeader().getDefaultRenderer();
                                                renderer6.setHorizontalAlignment(SwingConstants.CENTER);
                                                
                                                jTableUserAccount.removeColumn(jTableUserAccount.getColumnModel().getColumn(3));
                                                jTableUserAccount.removeColumn(jTableUserAccount.getColumnModel().getColumn(3));
                                                jTableUserAccount.removeColumn(jTableUserAccount.getColumnModel().getColumn(3));

                                                 TableColumn col6 = jTableUserAccount.getColumnModel().getColumn(0);
                                                    DefaultTableCellRenderer dtcr6 = new DefaultTableCellRenderer();  
                                                    dtcr6.setHorizontalAlignment(SwingConstants.CENTER);
                                                    col6.setCellRenderer(dtcr);


       }
       
      public boolean verifyTextSchoolYear()
    {
        
        if (SY.getText().equals(""))

          {
            JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");
            return false;

        } else {
             return true;
        }
    }
      
            public boolean verifyTextSchoolPresident()
    {
        
        if (NAME.getText().equals("") || STATUS.getText().equals("") )

          {
           JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");
            return false;

        } else {
             return true;
        }
    }
            
      
        public boolean verifyTextSchoolRegistrar()
    {
        
        if (NAMEreg.getText().equals("") || STATUSreg.getText().equals("") )

          {
            JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");
            return false;

        } else {
             return true;
        }
    }
      
      
    public boolean verifyTextVicePresident()
    {
        
        if (NAMEvice.getText().equals("") || STATUSvice.getText().equals("") )

          {
            JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");
            return false;
         
        } else {
             return true;
        }
    }     
    
    
    public boolean verifyTextSection()
    {
        
        if (section.getText().equals(""))

          {
            JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");
            return false;
         
        } else {
             return true;
        }
    }    
    
    
    
    public boolean verifyTextUser()
    {
        
        if (email.getText().equals("") || fullname.getText().equals("") || question.getText().equals("") || answer.getText().equals("") || password.getText().equals("") )

          {
           JOptionPane.showMessageDialog(this," Unable to Save" + "\n Please fill the Necessary Empty Fields");
            return false;
         
        } else {
             return true;
        }
    }    
        
        
      
      public void LoadSearchDataSchoolYear(){
           try {
               String name="%"+this.searchschoolyear.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableSchoolYear.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               ps = Mycon.prepareStatement("select * from school_year where school_year_name LIKE '"+name+"'"); 
                         ResultSet rs= ps.executeQuery();
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
                                }  
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
     }

           public void LoadSearchDataSchoolPresident(){
           try {
               String name="%"+this.searchschoolPresident.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableSchoolPresident.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               ps = Mycon.prepareStatement("select * from school_president_director where fullname LIKE '"+name+"'"); 
                         ResultSet rs= ps.executeQuery();
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                                }  
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
     }
      
          public void LoadSearchDataVice(){
           try {
               String name="%"+searchschoolVice.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableSchoolVice.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
               ps = Mycon.prepareStatement("select * from school_vicepresident where fullname LIKE '"+name+"'"); 
                         ResultSet rs= ps.executeQuery();
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                                }  
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
     }
          

             public void LoadSearchDataReg(){
           try {
               String name="%"+searchschoolRegistrar.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableRegistrar.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
                ps = Mycon.prepareStatement("select * from school_registrar_incharge where fullname LIKE '"+name+"'"); 
                         ResultSet rs= ps.executeQuery();
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                                }  
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
     }
             
             
              public void LoadSearchDataSection(){
           try {
               String name="%"+searchsection.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableRegistrar.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
                ps = Mycon.prepareStatement("select * from sections where section_name LIKE '"+name+"'"); 
                         ResultSet rs= ps.executeQuery();
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
                                }  
            }catch (ClassNotFoundException | SQLException  ex) {
                JOptionPane.showMessageDialog(this,  ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
              }
              
              
                     public void LoadSearchDataUser(){
           try {
               String name="%"+searchuser.getText()+"%";
               DefaultTableModel model =  (DefaultTableModel)jTableUserAccount.getModel() ;
               int col;
               Class.forName("com.mysql.cj.jdbc.Driver");
               Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");   
               PreparedStatement ps;
                ps = Mycon.prepareStatement("select * from useraccount where fullname LIKE '"+name+"'"); 
                         ResultSet rs= ps.executeQuery();
                         model.setRowCount(0);
                         while(rs.next()){   
                             //number sa mga columns sa imohang tables
                        model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
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
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel6 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        He = new javax.swing.JCheckBox();
        She = new javax.swing.JCheckBox();
        jPanel54 = new javax.swing.JPanel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernamedeskAdmin = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        searchschoolyear = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        SY = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSchoolYear = new javax.swing.JTable();
        jPanel61 = new javax.swing.JPanel();
        ADD = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableUserAccount = new javax.swing.JTable();
        jPanel66 = new javax.swing.JPanel();
        ADD5 = new javax.swing.JButton();
        UPDATE5 = new javax.swing.JButton();
        DELETE5 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel34 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        fullname = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        Male1 = new javax.swing.JCheckBox();
        Female1 = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        answer = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        password = new javax.swing.JTextField();
        jPanel59 = new javax.swing.JPanel();
        searchuser = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        searchsection = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        DELETE4 = new javax.swing.JButton();
        UPDATE4 = new javax.swing.JButton();
        ADD4 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        section = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableSection = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        searchschoolPresident = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        DELETE1 = new javax.swing.JButton();
        UPDATE1 = new javax.swing.JButton();
        ADD1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSchoolPresident = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        Female = new javax.swing.JCheckBox();
        Male = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        STATUS = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        NAME = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        DELETE2 = new javax.swing.JButton();
        UPDATE2 = new javax.swing.JButton();
        ADD2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSchoolVice = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        Femalevice = new javax.swing.JCheckBox();
        Malevice = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        STATUSvice = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        NAMEvice = new javax.swing.JTextField();
        jPanel56 = new javax.swing.JPanel();
        searchschoolVice = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        DELETE3 = new javax.swing.JButton();
        UPDATE3 = new javax.swing.JButton();
        ADD3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableRegistrar = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        Femalereg = new javax.swing.JCheckBox();
        Malereg = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        STATUSreg = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        NAMEreg = new javax.swing.JTextField();
        jPanel57 = new javax.swing.JPanel();
        searchschoolRegistrar = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Admin");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(253, 253, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(13, 52, 13));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/sdfdf.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(253, 253, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All Rights Reserved 2020");

        usernamedeskAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        usernamedeskAdmin.setForeground(new java.awt.Color(255, 255, 255));
        usernamedeskAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernamedeskAdmin.setText("Name");

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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/default.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/hover.png"))); // NOI18N
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/admin/hover.png"))); // NOI18N

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
                    .addComponent(usernamedeskAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(usernamedeskAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
        );

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(244, 241, 233));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchschoolyear.setBackground(new java.awt.Color(255, 255, 255));
        searchschoolyear.setText("Search Here. . . .");
        searchschoolyear.setBorder(null);
        searchschoolyear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchschoolyearFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchschoolyearFocusLost(evt);
            }
        });
        searchschoolyear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchschoolyearKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchschoolyear, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchschoolyear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel32.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SY.setBackground(new java.awt.Color(255, 255, 255));
        SY.setBorder(null);
        SY.setColumns(12);
        SY.setForeground(new java.awt.Color(0, 0, 0));
        try {
            SY.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        SY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SY.setCaretColor(new java.awt.Color(102, 0, 0));
        SY.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        SY.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        SY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SYKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SY, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SY, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("School Year :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jTableSchoolYear.setAutoCreateRowSorter(true);
        jTableSchoolYear.setBackground(new java.awt.Color(255, 255, 255));
        jTableSchoolYear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableSchoolYear.setForeground(new java.awt.Color(0, 0, 0));
        jTableSchoolYear.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "School Year", "Timestamp"
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
        jTableSchoolYear.setOpaque(false);
        jTableSchoolYear.setRequestFocusEnabled(false);
        jTableSchoolYear.setRowHeight(30);
        jTableSchoolYear.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTableSchoolYear.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableSchoolYear.setShowVerticalLines(false);
        jTableSchoolYear.getTableHeader().setReorderingAllowed(false);
        jTableSchoolYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSchoolYearMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSchoolYear);

        jPanel61.setBackground(new java.awt.Color(244, 241, 233));
        jPanel61.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

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

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DELETE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("School Year     ", jPanel3);

        jPanel5.setBackground(new java.awt.Color(244, 241, 233));

        jPanel33.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableUserAccount.setAutoCreateRowSorter(true);
        jTableUserAccount.setBackground(new java.awt.Color(255, 255, 255));
        jTableUserAccount.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableUserAccount.setForeground(new java.awt.Color(0, 0, 0));
        jTableUserAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Email", "Full Name", "Gender", "Security Question", "Answer", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUserAccount.setOpaque(false);
        jTableUserAccount.setRequestFocusEnabled(false);
        jTableUserAccount.setRowHeight(30);
        jTableUserAccount.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTableUserAccount.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableUserAccount.setShowVerticalLines(false);
        jTableUserAccount.getTableHeader().setReorderingAllowed(false);
        jTableUserAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserAccountMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableUserAccount);

        jPanel66.setBackground(new java.awt.Color(244, 241, 233));
        jPanel66.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

        ADD5.setBackground(new java.awt.Color(51, 51, 51));
        ADD5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/default.png"))); // NOI18N
        ADD5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        ADD5.setFocusPainted(false);
        ADD5.setRolloverEnabled(true);
        ADD5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD5ActionPerformed(evt);
            }
        });

        UPDATE5.setBackground(new java.awt.Color(51, 51, 51));
        UPDATE5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/default.png"))); // NOI18N
        UPDATE5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        UPDATE5.setFocusPainted(false);
        UPDATE5.setRolloverEnabled(true);
        UPDATE5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE5ActionPerformed(evt);
            }
        });

        DELETE5.setBackground(new java.awt.Color(51, 51, 51));
        DELETE5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/default.png"))); // NOI18N
        DELETE5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        DELETE5.setFocusPainted(false);
        DELETE5.setRolloverEnabled(true);
        DELETE5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADD5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DELETE5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DELETE5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel34.setBackground(new java.awt.Color(204, 204, 204));
        jPanel34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(43, 70, 60));
        jLabel23.setText("Email Address :");

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        email.setBorder(null);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(43, 70, 60));
        jLabel13.setText("Full Name :");

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fullname.setBackground(new java.awt.Color(255, 255, 255));
        fullname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fullname.setText("Last Name, First Name Middle Name");
        fullname.setBorder(null);
        fullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fullnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fullnameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullname, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 51, 51));
        jLabel38.setText("Gender :");

        Male1.setBackground(new java.awt.Color(204, 204, 204));
        Male1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Male1.setForeground(new java.awt.Color(43, 70, 60));
        Male1.setText("Male");
        Male1.setBorder(null);
        Male1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Male1.setInheritsPopupMenu(true);
        Male1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Male1ActionPerformed(evt);
            }
        });

        Female1.setBackground(new java.awt.Color(204, 204, 204));
        Female1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Female1.setForeground(new java.awt.Color(43, 70, 60));
        Female1.setText("Female");
        Female1.setBorder(null);
        Female1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Female1.setInheritsPopupMenu(true);
        Female1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Female1ActionPerformed(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(43, 70, 60));
        jLabel24.setText("Security Question :");

        question.setBackground(new java.awt.Color(255, 255, 255));
        question.setColumns(20);
        question.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        question.setRows(5);
        question.setBorder(null);
        jScrollPane8.setViewportView(question);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(43, 70, 60));
        jLabel14.setText("Answer :");

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        answer.setBackground(new java.awt.Color(255, 255, 255));
        answer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        answer.setBorder(null);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(answer, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(43, 70, 60));
        jLabel25.setText("Password :");

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        password.setBorder(null);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(Male1)
                        .addGap(110, 110, 110)
                        .addComponent(Female1))
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23))
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25))
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel38)
                .addGap(0, 0, 0)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Male1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Female1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel34);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchuser.setBackground(new java.awt.Color(255, 255, 255));
        searchuser.setText("Search Here. . . .");
        searchuser.setBorder(null);
        searchuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchuserFocusLost(evt);
            }
        });
        searchuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchuserKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchuser, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchuser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("User Accouts    ", jPanel5);

        jPanel15.setBackground(new java.awt.Color(244, 241, 233));

        jPanel29.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchsection.setBackground(new java.awt.Color(255, 255, 255));
        searchsection.setText("Search Here. . . .");
        searchsection.setBorder(null);
        searchsection.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchsectionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchsectionFocusLost(evt);
            }
        });
        searchsection.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchsectionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchsection, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchsection, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel65.setBackground(new java.awt.Color(244, 241, 233));
        jPanel65.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

        DELETE4.setBackground(new java.awt.Color(51, 51, 51));
        DELETE4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/default.png"))); // NOI18N
        DELETE4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        DELETE4.setFocusPainted(false);
        DELETE4.setRolloverEnabled(true);
        DELETE4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE4ActionPerformed(evt);
            }
        });

        UPDATE4.setBackground(new java.awt.Color(51, 51, 51));
        UPDATE4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/default.png"))); // NOI18N
        UPDATE4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        UPDATE4.setFocusPainted(false);
        UPDATE4.setRolloverEnabled(true);
        UPDATE4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE4ActionPerformed(evt);
            }
        });

        ADD4.setBackground(new java.awt.Color(51, 51, 51));
        ADD4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/default.png"))); // NOI18N
        ADD4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        ADD4.setFocusPainted(false);
        ADD4.setRolloverEnabled(true);
        ADD4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADD4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DELETE4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DELETE4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel27.setBackground(new java.awt.Color(204, 204, 204));
        jPanel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("Section Name :");

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        section.setBackground(new java.awt.Color(255, 255, 255));
        section.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        section.setForeground(new java.awt.Color(0, 0, 0));
        section.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        section.setBorder(null);
        section.setMargin(new java.awt.Insets(1, 1, 1, 1));
        section.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sectionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(section, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(56, 56, 56))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTableSection.setBackground(new java.awt.Color(255, 255, 255));
        jTableSection.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableSection.setForeground(new java.awt.Color(0, 0, 0));
        jTableSection.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Section"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableSection.setRowHeight(20);
        jTableSection.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTableSection.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableSection.setShowVerticalLines(false);
        jTableSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSectionMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableSection);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Section    ", jPanel15);

        jPanel26.setBackground(new java.awt.Color(244, 241, 233));

        jPanel31.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1161, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchschoolPresident.setBackground(new java.awt.Color(255, 255, 255));
        searchschoolPresident.setText("Search Here. . . .");
        searchschoolPresident.setBorder(null);
        searchschoolPresident.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchschoolPresidentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchschoolPresidentFocusLost(evt);
            }
        });
        searchschoolPresident.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchschoolPresidentKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchschoolPresident, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchschoolPresident, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel62.setBackground(new java.awt.Color(244, 241, 233));
        jPanel62.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

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

        ADD1.setBackground(new java.awt.Color(51, 51, 51));
        ADD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/default.png"))); // NOI18N
        ADD1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        ADD1.setFocusPainted(false);
        ADD1.setRolloverEnabled(true);
        ADD1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADD1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DELETE1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DELETE1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTableSchoolPresident.setBackground(new java.awt.Color(255, 255, 255));
        jTableSchoolPresident.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableSchoolPresident.setForeground(new java.awt.Color(0, 0, 0));
        jTableSchoolPresident.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Status", "Gender"
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
        jTableSchoolPresident.setRequestFocusEnabled(false);
        jTableSchoolPresident.setRowHeight(30);
        jTableSchoolPresident.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTableSchoolPresident.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableSchoolPresident.setShowVerticalLines(false);
        jTableSchoolPresident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSchoolPresidentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSchoolPresident);

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Female.setBackground(new java.awt.Color(204, 204, 204));
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

        Male.setBackground(new java.awt.Color(204, 204, 204));
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

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("Name :");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setText("Status:");

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        STATUS.setBackground(new java.awt.Color(255, 255, 255));
        STATUS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STATUS.setForeground(new java.awt.Color(0, 0, 0));
        STATUS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        STATUS.setBorder(null);
        STATUS.setMargin(new java.awt.Insets(1, 1, 1, 1));
        STATUS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                STATUSKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STATUS, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        NAME.setBackground(new java.awt.Color(255, 255, 255));
        NAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NAME.setForeground(new java.awt.Color(0, 0, 0));
        NAME.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NAME.setBorder(null);
        NAME.setMargin(new java.awt.Insets(1, 1, 1, 1));
        NAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NAMEKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NAME, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(Male)
                                .addGap(18, 18, 18)
                                .addComponent(Female)
                                .addGap(231, 231, 231)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Male, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Female, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("President     ", jPanel26);

        jPanel8.setBackground(new java.awt.Color(244, 241, 233));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel63.setBackground(new java.awt.Color(244, 241, 233));
        jPanel63.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

        DELETE2.setBackground(new java.awt.Color(51, 51, 51));
        DELETE2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/default.png"))); // NOI18N
        DELETE2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        DELETE2.setFocusPainted(false);
        DELETE2.setRolloverEnabled(true);
        DELETE2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE2ActionPerformed(evt);
            }
        });

        UPDATE2.setBackground(new java.awt.Color(51, 51, 51));
        UPDATE2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/default.png"))); // NOI18N
        UPDATE2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        UPDATE2.setFocusPainted(false);
        UPDATE2.setRolloverEnabled(true);
        UPDATE2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE2ActionPerformed(evt);
            }
        });

        ADD2.setBackground(new java.awt.Color(51, 51, 51));
        ADD2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/default.png"))); // NOI18N
        ADD2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        ADD2.setFocusPainted(false);
        ADD2.setRolloverEnabled(true);
        ADD2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADD2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DELETE2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DELETE2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTableSchoolVice.setBackground(new java.awt.Color(255, 255, 255));
        jTableSchoolVice.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableSchoolVice.setForeground(new java.awt.Color(0, 0, 0));
        jTableSchoolVice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Status", "Gender"
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
        jTableSchoolVice.setRequestFocusEnabled(false);
        jTableSchoolVice.setRowHeight(30);
        jTableSchoolVice.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTableSchoolVice.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableSchoolVice.setShowVerticalLines(false);
        jTableSchoolVice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSchoolViceMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableSchoolVice);

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));
        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Femalevice.setBackground(new java.awt.Color(204, 204, 204));
        Femalevice.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Femalevice.setForeground(new java.awt.Color(43, 70, 60));
        Femalevice.setText("Female");
        Femalevice.setBorder(null);
        Femalevice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Femalevice.setInheritsPopupMenu(true);
        Femalevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleviceActionPerformed(evt);
            }
        });

        Malevice.setBackground(new java.awt.Color(204, 204, 204));
        Malevice.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Malevice.setForeground(new java.awt.Color(43, 70, 60));
        Malevice.setText("Male");
        Malevice.setBorder(null);
        Malevice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Malevice.setInheritsPopupMenu(true);
        Malevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleviceActionPerformed(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 51, 51));
        jLabel36.setText("Gender :");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 51));
        jLabel18.setText("Name :");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 51));
        jLabel19.setText("Status:");

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        STATUSvice.setBackground(new java.awt.Color(255, 255, 255));
        STATUSvice.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STATUSvice.setForeground(new java.awt.Color(0, 0, 0));
        STATUSvice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        STATUSvice.setBorder(null);
        STATUSvice.setMargin(new java.awt.Insets(1, 1, 1, 1));
        STATUSvice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                STATUSviceKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(STATUSvice, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STATUSvice, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        NAMEvice.setBackground(new java.awt.Color(255, 255, 255));
        NAMEvice.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NAMEvice.setForeground(new java.awt.Color(0, 0, 0));
        NAMEvice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NAMEvice.setBorder(null);
        NAMEvice.setMargin(new java.awt.Insets(1, 1, 1, 1));
        NAMEvice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NAMEviceKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NAMEvice, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NAMEvice, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(Malevice)
                        .addGap(18, 18, 18)
                        .addComponent(Femalevice)
                        .addGap(231, 231, 231)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Malevice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Femalevice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchschoolVice.setBackground(new java.awt.Color(255, 255, 255));
        searchschoolVice.setText("Search Here. . . .");
        searchschoolVice.setBorder(null);
        searchschoolVice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchschoolViceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchschoolViceFocusLost(evt);
            }
        });
        searchschoolVice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchschoolViceKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchschoolVice, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchschoolVice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel36.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Vice - President    ", jPanel8);

        jPanel7.setBackground(new java.awt.Color(244, 241, 233));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel64.setBackground(new java.awt.Color(244, 241, 233));
        jPanel64.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.red));

        DELETE3.setBackground(new java.awt.Color(51, 51, 51));
        DELETE3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/default.png"))); // NOI18N
        DELETE3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        DELETE3.setFocusPainted(false);
        DELETE3.setRolloverEnabled(true);
        DELETE3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/DELETE/hover.png"))); // NOI18N
        DELETE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE3ActionPerformed(evt);
            }
        });

        UPDATE3.setBackground(new java.awt.Color(51, 51, 51));
        UPDATE3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/default.png"))); // NOI18N
        UPDATE3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        UPDATE3.setFocusPainted(false);
        UPDATE3.setRolloverEnabled(true);
        UPDATE3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/UPDATE/hover.png"))); // NOI18N
        UPDATE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE3ActionPerformed(evt);
            }
        });

        ADD3.setBackground(new java.awt.Color(51, 51, 51));
        ADD3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/default.png"))); // NOI18N
        ADD3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 143, 78), 2));
        ADD3.setFocusPainted(false);
        ADD3.setRolloverEnabled(true);
        ADD3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/ADD/hover.png"))); // NOI18N
        ADD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ADD3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPDATE3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DELETE3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DELETE3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTableRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        jTableRegistrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        jTableRegistrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Status", "Gender"
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
        jTableRegistrar.setRequestFocusEnabled(false);
        jTableRegistrar.setRowHeight(30);
        jTableRegistrar.setSelectionBackground(new java.awt.Color(0, 51, 0));
        jTableRegistrar.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableRegistrar.setShowVerticalLines(false);
        jTableRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRegistrarMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableRegistrar);

        jPanel18.setBackground(new java.awt.Color(204, 204, 204));
        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Femalereg.setBackground(new java.awt.Color(204, 204, 204));
        Femalereg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Femalereg.setForeground(new java.awt.Color(43, 70, 60));
        Femalereg.setText("Female");
        Femalereg.setBorder(null);
        Femalereg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Femalereg.setInheritsPopupMenu(true);
        Femalereg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleregActionPerformed(evt);
            }
        });

        Malereg.setBackground(new java.awt.Color(204, 204, 204));
        Malereg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Malereg.setForeground(new java.awt.Color(43, 70, 60));
        Malereg.setText("Male");
        Malereg.setBorder(null);
        Malereg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Malereg.setInheritsPopupMenu(true);
        Malereg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleregActionPerformed(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 51, 51));
        jLabel37.setText("Gender :");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setText("Name :");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 51));
        jLabel21.setText("Status:");

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        STATUSreg.setBackground(new java.awt.Color(255, 255, 255));
        STATUSreg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        STATUSreg.setForeground(new java.awt.Color(0, 0, 0));
        STATUSreg.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        STATUSreg.setBorder(null);
        STATUSreg.setMargin(new java.awt.Insets(1, 1, 1, 1));
        STATUSreg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                STATUSregKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(STATUSreg, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STATUSreg, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        NAMEreg.setBackground(new java.awt.Color(255, 255, 255));
        NAMEreg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NAMEreg.setForeground(new java.awt.Color(0, 0, 0));
        NAMEreg.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NAMEreg.setBorder(null);
        NAMEreg.setMargin(new java.awt.Insets(1, 1, 1, 1));
        NAMEreg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NAMEregKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NAMEreg, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NAMEreg, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(Malereg)
                        .addGap(18, 18, 18)
                        .addComponent(Femalereg)
                        .addGap(231, 231, 231)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Malereg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Femalereg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchschoolRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        searchschoolRegistrar.setText("Search Here. . . .");
        searchschoolRegistrar.setBorder(null);
        searchschoolRegistrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchschoolRegistrarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchschoolRegistrarFocusLost(evt);
            }
        });
        searchschoolRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchschoolRegistrarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(searchschoolRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchschoolRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel35.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Registrar  ", jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
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

        setSize(new java.awt.Dimension(1461, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeActionPerformed

    private void SheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SheActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Mainframe s = new Mainframe();
       Mainframe.usernamedesk.setText(usernamedeskAdmin.getText());
       this.hide();
       s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchschoolyearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchschoolyearFocusGained

        if( searchschoolyear.getText().trim().equals("Search Here. . . ."))
        {
            searchschoolyear.setText("");
            searchschoolyear.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchschoolyearFocusGained

    private void searchschoolyearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchschoolyearFocusLost

        if(searchschoolyear.getText().trim().equals(""))
        {
            searchschoolyear.setText("Search Here. . . .");
            searchschoolyear.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchschoolyearFocusLost

    private void searchschoolyearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchschoolyearKeyReleased
                    
        LoadSearchDataSchoolYear();
       
    }//GEN-LAST:event_searchschoolyearKeyReleased

    private void jTableSchoolYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSchoolYearMouseClicked

        DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolYear.getModel() ;
        int selecIndex = jTableSchoolYear.getSelectedRow();
        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();

        SY.setText(model2.getValueAt(selecIndex, 1).toString());

    }//GEN-LAST:event_jTableSchoolYearMouseClicked

    private void SYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SYKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SYKeyTyped

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        String SYNAME = SY.getText();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        if (verifyTextSchoolYear()) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.1.1.2:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("insert into school_year (school_year_name,timestamp) values (?,?)");
                //("select * from user where username=? and password=?");

                if (verifyTextSchoolYear()) {

                    ps.setString(1, SYNAME);
                    ps.setString(2, timestamp);

                    ps.executeUpdate();
                    table_update();
                    SY.setText("");

                    JOptionPane.showMessageDialog(null, "School Year Successfully Added");

                }

            } catch (ClassNotFoundException  ex) {
                Logger.getLogger(Add_SchoolYear.class.getName()).log(Level.SEVERE, null, ex);
            }catch ( SQLException ex) {
                Logger.getLogger(Add_SchoolYear.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_ADDActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed

        try {

            String SYNAME = SY.getText();

            if (verifyTextSchoolYear()) {

                DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolYear.getModel() ;
                int selecIndex= jTableSchoolYear.getSelectedRow();

                int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("update school_year  set school_year_name=? where id=?");

                    ps.setString(1, SYNAME);;
                    ps.setInt(2,id);

                    if (verifyTextSchoolYear()) {
                        ps.execute();
                        table_update();

                        // schoolyr.setSelectedIndex(-1);

                        SY.setText("");

                        JOptionPane.showMessageDialog(null, "Successfully Updated");

                    }

                    // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

                } catch (ClassNotFoundException | SQLException   ex) {

                    JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Failed...!!! One or More Empty ");
        }

    }//GEN-LAST:event_UPDATEActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record","Warning",JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION)

        {

            if (verifyTextSchoolYear()) {

                try {

                    DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolYear.getModel() ;
                    int selecIndex = jTableSchoolYear.getSelectedRow();
                    int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("delete from school_year where id=?");
                    ps.setInt(1, id);

                    if (verifyTextSchoolYear()) {

                        ps.execute();
                        table_update();
                        JOptionPane.showMessageDialog(null, "Successfully Deleted");
                        //schoolyr.setSelectedIndex(-1);

                        SY.setText("");

                    }
                }catch (ClassNotFoundException | SQLException  ex) {
                    Logger.getLogger(Add_School_President.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {

            JOptionPane.showMessageDialog(null, "Then please Proceed");

        }

    }//GEN-LAST:event_DELETEActionPerformed

    private void searchschoolPresidentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchschoolPresidentFocusGained
          if( searchschoolPresident.getText().trim().equals("Search Here. . . ."))
        {
            searchschoolPresident.setText("");
            searchschoolPresident.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchschoolPresidentFocusGained

    private void searchschoolPresidentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchschoolPresidentFocusLost

        if(searchschoolPresident.getText().trim().equals(""))
        {
            searchschoolPresident.setText("Search Here. . . .");
            searchschoolPresident.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchschoolPresidentFocusLost

    private void searchschoolPresidentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchschoolPresidentKeyReleased
       LoadSearchDataSchoolPresident();
    }//GEN-LAST:event_searchschoolPresidentKeyReleased

    private void jTableSchoolPresidentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSchoolPresidentMouseClicked
        DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolPresident.getModel() ;
        int selecIndex = jTableSchoolPresident.getSelectedRow();
        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();

        NAME.setText(model2.getValueAt(selecIndex, 1).toString());
        STATUS.setText(model2.getValueAt(selecIndex, 2).toString());

        if (model2.getValueAt(selecIndex, 3).toString().equals("Male")) {
            Male.setSelected(true);
            Female.setSelected(false);
        }else {
            Female.setSelected(true);
            Male.setSelected(false);
        }
    }//GEN-LAST:event_jTableSchoolPresidentMouseClicked

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleActionPerformed

    private void STATUSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STATUSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_STATUSKeyReleased

    private void NAMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NAMEKeyReleased

        int position = NAME.getCaretPosition();
        NAME.setText(NAME.getText().toUpperCase());
        NAME.setCaretPosition(position);
    }//GEN-LAST:event_NAMEKeyReleased

    private void DELETE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE1ActionPerformed

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record ?","Warning",JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION)

        {

            if (verifyTextSchoolPresident()) {

                try {

                    DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolPresident.getModel() ;
                    int selecIndex = jTableSchoolPresident.getSelectedRow();
                    int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("delete from school_president_director where id=?");
                    ps.setInt(1, id);

                    if (verifyTextSchoolPresident()) {

                        ps.execute();
                        table_update();
                        JOptionPane.showMessageDialog(null, "Successfully Deleted");
                        //schoolyr.setSelectedIndex(-1);

                        NAME.setText("");
                        STATUS.setText("");

                    }
                }catch (ClassNotFoundException | SQLException  ex) {
                    Logger.getLogger(Add_School_President.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {

            JOptionPane.showMessageDialog(null, "Then please Proceed");

        }
    }//GEN-LAST:event_DELETE1ActionPerformed

    private void UPDATE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE1ActionPerformed

        String lname=NAME.getText();
        String stat=STATUS.getText();
        String gender = "Male";
        if (Female.isSelected()) {
            gender="Female";
        }

        if (verifyTextSchoolPresident()) {

            DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolPresident.getModel() ;
            int selecIndex= jTableSchoolPresident.getSelectedRow();

            int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("update school_president_director set fullname=?, status=?, gender=? where id=?");

                ps.setString(1, lname);
                ps.setString(2, stat);
                ps.setString(3, gender);

                // ps.setString(4,timestamp );
                ps.setInt(4,id);

                if (verifyTextSchoolPresident()) {
                    ps.execute();
                    table_update();

                    // schoolyr.setSelectedIndex(-1);

                    NAME.setText("");
                    STATUS.setText("");
                    

                    JOptionPane.showMessageDialog(null, "Successfully Updated");

                }

                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

            } catch (ClassNotFoundException | SQLException   ex) {

                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_UPDATE1ActionPerformed

    private void ADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD1ActionPerformed
        String lname=NAME.getText();
        String stat=STATUS.getText();

        //      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //        String date = dateFormat.format(jDateChooser1.getDate());

        String gender = "Male";
        if (Female.isSelected()) {
            gender="Female";
        }

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        

        if (verifyTextSchoolPresident()) {

            try {

                

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("insert into school_president_director (fullname, status, gender, timestamp) values (?,?,?,?)");

                ps.setString(1, lname);
                ps.setString(2, stat);
                ps.setString(3, gender);
                ps.setString(4,timestamp );

                if (verifyTextSchoolPresident()) {

                    ps.execute();
                    table_update();
                    //  schoolyr.setSelectedIndex(-1);

                    NAME.setText("");
                    STATUS.setText("");
                    

                    JOptionPane.showMessageDialog(null, "Successfully Added");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ADD1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       StudentFrame s = new StudentFrame();
       StudentFrame.usernamedeskStudent.setText(usernamedeskAdmin.getText());
       this.hide();
       s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DELETE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE2ActionPerformed
       
        
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record ?","Warning",JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION)

        {

            if (verifyTextVicePresident()) {

                 try {
                
         DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolVice.getModel() ;
        int selecIndex = jTableSchoolVice.getSelectedRow();
        int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("delete from school_vicepresident where id=?");
                ps.setInt(1, id);

                
                     if (verifyTextVicePresident()) {
                         
                         
                           ps.execute();
                table_update();
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                    NAMEvice.setText("");
                    STATUSvice.setText("");
                    
                     }

            }catch (ClassNotFoundException | SQLException  ex) {
                Logger.getLogger(Add_School_VicePresident.class.getName()).log(Level.SEVERE, null, ex);
            }
   
            }
        } 
                                         
    }//GEN-LAST:event_DELETE2ActionPerformed

    private void UPDATE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE2ActionPerformed
            String lname=NAMEvice.getText();
            String stat=STATUSvice.getText();
            String gender = "Male";
            if (Femalevice.isSelected()) {
                gender="Female";
            }

            
            if (verifyTextVicePresident()) {
                
        DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolVice.getModel() ;
        int selecIndex= jTableSchoolVice.getSelectedRow();
        
        int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());
                
            try {


                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("update school_vicepresident set fullname=?,status=?,gender=? where id=?");

                 ps.setString(1, lname);
                 ps.setString(2, stat);
                 ps.setString(3, gender);
                 ps.setInt(4,id);

                if (verifyTextVicePresident()) {
                    ps.execute();
                    table_update();

                    
                   
                    NAMEvice.setText("");
                    STATUSvice.setText("");
                   

                    JOptionPane.showMessageDialog(null, "Successfully Updated");

                }

                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

            } catch (ClassNotFoundException | SQLException   ex) {

                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
            
    }//GEN-LAST:event_UPDATE2ActionPerformed

    private void ADD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD2ActionPerformed

                   String lname=NAMEvice.getText();
                String stat=STATUSvice.getText();

  

        
        String gender = "Male";
        if (Femalevice.isSelected()) {
            gender="Female";
        }

        
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        //java.util.Date now = new java.util.Date();

        if (verifyTextVicePresident()) {

            try {


                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("insert into school_vicepresident (fullname, status, gender, timestamp) values (?,?,?,?)");
             
                ps.setString(1, lname);
                ps.setString(2, stat);
                ps.setString(3, gender);
                ps.setString(4,timestamp );

                if (verifyTextVicePresident()) {

                    ps.execute();
                    table_update();
                    
                    
                    NAMEvice.setText("");
                    STATUSvice.setText("");
                    
                   
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ADD2ActionPerformed

    private void jTableSchoolViceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSchoolViceMouseClicked
        
        
        DefaultTableModel model2 =  (DefaultTableModel)jTableSchoolVice.getModel() ;
        int selecIndex = jTableSchoolVice.getSelectedRow();
        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();

        NAMEvice.setText(model2.getValueAt(selecIndex, 1).toString());
        STATUSvice.setText(model2.getValueAt(selecIndex, 2).toString());
         if (model2.getValueAt(selecIndex, 3).toString().equals("Male")) {
            Malevice.setSelected(true);
            Femalevice.setSelected(false);
        }else {
            Femalevice.setSelected(true);
            Malevice.setSelected(false);
        }
        
        
    }//GEN-LAST:event_jTableSchoolViceMouseClicked

    private void FemaleviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleviceActionPerformed

    private void MaleviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleviceActionPerformed

    private void STATUSviceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STATUSviceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_STATUSviceKeyReleased

    private void NAMEviceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NAMEviceKeyReleased
         int position = NAMEvice.getCaretPosition();
       NAMEvice.setText(NAMEvice.getText().toUpperCase());
      NAMEvice.setCaretPosition(position);
    }//GEN-LAST:event_NAMEviceKeyReleased

    private void searchschoolViceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchschoolViceFocusGained
         if( searchschoolVice.getText().trim().equals("Search Here. . . ."))
        {
            searchschoolVice.setText("");
            searchschoolVice.setForeground(Color.black);
        }

    }//GEN-LAST:event_searchschoolViceFocusGained

    private void searchschoolViceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchschoolViceFocusLost
       if(searchschoolVice.getText().trim().equals(""))
        {
            searchschoolVice.setText("Search Here. . . .");
            searchschoolVice.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchschoolViceFocusLost

    private void searchschoolViceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchschoolViceKeyReleased
        LoadSearchDataVice();
    }//GEN-LAST:event_searchschoolViceKeyReleased

    private void DELETE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE3ActionPerformed
       
         int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record ?","Warning",JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION)

        {

            
            if (verifyTextSchoolRegistrar()) {
                
                
                
                  try {
                
                
                DefaultTableModel model2 =  (DefaultTableModel)jTableRegistrar.getModel() ;
                int selecIndex = jTableRegistrar.getSelectedRow();
                int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("delete from school_registrar_incharge where id=?");
                ps.setInt(1, id);

                
                      if (verifyTextSchoolRegistrar()) {
                          
                          
                ps.execute();
                table_update();
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                
               
                    NAMEreg.setText("");
                    STATUSreg.setText("");
                
                          
                      }
                
              
               

            }catch (ClassNotFoundException | SQLException  ex) {
                Logger.getLogger(Add_School_Registrar_Incharge.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
            }
            
          

        } else {

            JOptionPane.showMessageDialog(null, "Then please Proceed");

        }
        
        
        
    }//GEN-LAST:event_DELETE3ActionPerformed

    private void UPDATE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE3ActionPerformed
          String lname=NAMEreg.getText();
         String stat=STATUSreg.getText();


        
        String gender = "Male";
        if (Femalereg.isSelected()) {
            gender="Female";
        }

        
       
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);



        if (verifyTextSchoolRegistrar()) {
            try {
                
                
        DefaultTableModel model2 =  (DefaultTableModel)jTableRegistrar.getModel() ;
        int selecIndex= jTableRegistrar.getSelectedRow();
        int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("update school_registrar_incharge set fullname=?, status=?, gender=? where id=?");

                 ps.setString(1, lname);
                 ps.setString(2, stat);
                 ps.setString(3, gender);
                
               // ps.setString(4,timestamp );
                ps.setInt(4,id);

                if (verifyTextSchoolRegistrar()) {
                    ps.execute();
                    table_update();

                   
                   
                    NAMEreg.setText("");
                    STATUSreg.setText("");
                   

                    JOptionPane.showMessageDialog(null, "Successfully Updated");

                }

                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

            } catch (ClassNotFoundException | SQLException   ex) {

                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_UPDATE3ActionPerformed

    private void ADD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD3ActionPerformed

        String lname=NAMEreg.getText();
                String stat=STATUSreg.getText();

        String gender = "Male";
        if (Femalereg.isSelected()) {
            gender="Female";
        }

        
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);



        if (verifyTextSchoolRegistrar()) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("insert into school_registrar_incharge (fullname, status, gender, timestamp) values (?,?,?,?)");
             
                ps.setString(1, lname);
                ps.setString(2, stat);
                ps.setString(3, gender);
                ps.setString(4,timestamp );

                if (verifyTextSchoolRegistrar()) {

                    ps.execute();
                    table_update();
                   
                    
                    NAMEreg.setText("");
                    STATUSreg.setText("");
                  
                   
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ADD3ActionPerformed

    private void jTableRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRegistrarMouseClicked
       
        
        
        DefaultTableModel model2 =  (DefaultTableModel)jTableRegistrar.getModel() ;
        int selecIndex = jTableRegistrar.getSelectedRow();
        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();

        NAMEreg.setText(model2.getValueAt(selecIndex, 1).toString());
        STATUSreg.setText(model2.getValueAt(selecIndex, 2).toString());
         if (model2.getValueAt(selecIndex, 3).toString().equals("Male")) {
            Malereg.setSelected(true);
            Femalereg.setSelected(false);
        }else {
            Femalereg.setSelected(true);
            Malereg.setSelected(false);
        }
        
        
    }//GEN-LAST:event_jTableRegistrarMouseClicked

    private void FemaleregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleregActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemaleregActionPerformed

    private void MaleregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleregActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaleregActionPerformed

    private void STATUSregKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STATUSregKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_STATUSregKeyReleased

    private void NAMEregKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NAMEregKeyReleased
        int position = NAMEreg.getCaretPosition();
       NAMEreg.setText(NAMEreg.getText().toUpperCase());
     NAMEreg.setCaretPosition(position);
    }//GEN-LAST:event_NAMEregKeyReleased

    private void searchschoolRegistrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchschoolRegistrarFocusGained
          if( searchschoolRegistrar.getText().trim().equals("Search Here. . . ."))
        {
            searchschoolRegistrar.setText("");
            searchschoolRegistrar.setForeground(Color.black);
        }

    }//GEN-LAST:event_searchschoolRegistrarFocusGained

    private void searchschoolRegistrarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchschoolRegistrarFocusLost
        if(searchschoolRegistrar.getText().trim().equals(""))
        {
            searchschoolRegistrar.setText("Search Here. . . .");
            searchschoolRegistrar.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchschoolRegistrarFocusLost

    private void searchschoolRegistrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchschoolRegistrarKeyReleased
      LoadSearchDataReg();
    }//GEN-LAST:event_searchschoolRegistrarKeyReleased

    private void searchsectionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchsectionFocusGained
           if( searchsection.getText().trim().equals("Search Here. . . ."))
        {
            searchsection.setText("");
            searchsection.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchsectionFocusGained

    private void searchsectionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchsectionFocusLost
         if(searchsection.getText().trim().equals(""))
        {
            searchsection.setText("Search Here. . . .");
            searchsection.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchsectionFocusLost

    private void searchsectionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchsectionKeyReleased
      LoadSearchDataSection();
    }//GEN-LAST:event_searchsectionKeyReleased

    private void DELETE4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE4ActionPerformed
         int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record ?","Warning",JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION)

        {

            if (verifyTextSection()) {

                try {

                    DefaultTableModel model2 =  (DefaultTableModel)jTableSection.getModel() ;
                    int selecIndex = jTableSection.getSelectedRow();
                    int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("delete from sections where id=?");
                    ps.setInt(1, id);

                    if (verifyTextSection()) {

                        ps.execute();
                        table_update();
                        JOptionPane.showMessageDialog(null, "Section Successfully Deleted");
                        //schoolyr.setSelectedIndex(-1);

                        section.setText("");
                        

                    }
                }catch (ClassNotFoundException | SQLException  ex) {
                    Logger.getLogger(Add_School_President.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {

            JOptionPane.showMessageDialog(null, "Then please Proceed");

        }
    }//GEN-LAST:event_DELETE4ActionPerformed

    private void UPDATE4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE4ActionPerformed
       
        
        
        
        String sec = section.getText();

        if (verifyTextSection()) {

            DefaultTableModel model2 =  (DefaultTableModel)jTableSection.getModel() ;
            int selecIndex=jTableSection.getSelectedRow();

            int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("update sections  set section_name=? where id=?");

                ps.setString(1, sec);
              
                ps.setInt(2,id);

                if (verifyTextSection()) {
                    ps.execute();
                    table_update();

                    // schoolyr.setSelectedIndex(-1);

                     section.setText("");

                    JOptionPane.showMessageDialog(null, "Section Successfully Updated");

                }

                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

            } catch (ClassNotFoundException | SQLException   ex) {

                JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_UPDATE4ActionPerformed

    private void ADD4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD4ActionPerformed
       String sec = section.getText();
       

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        //java.util.Date now = new java.util.Date();

        if (verifyTextSection()) {
            
            
             try {   

             
        Class.forName("com.mysql.cj.jdbc.Driver");
        Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
        PreparedStatement ps;
       
        ps=Mycon.prepareStatement("INSERT INTO sections (section_name, timestamp) VALUES (?,?)");
        
        ps.setString(1, sec);
        ps.setString(2, timestamp);
        

        

        ps.execute();      
        table_update();
                    JOptionPane.showMessageDialog(null, "Section Successfully Added");
                    
                   section.setText("");
                    
                    
                    
                // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());
               
         } catch (ClassNotFoundException | SQLException ex) {
                   // JOptionPane.showMessageDialog(this, ex,"ERROR",  JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(table_suggetions.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
            
            
        }
        
        
    }//GEN-LAST:event_ADD4ActionPerformed

    private void sectionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sectionKeyReleased
        int position = section.getCaretPosition();
       section.setText(section.getText().toUpperCase());
      section.setCaretPosition(position);
    }//GEN-LAST:event_sectionKeyReleased

    private void jTableSectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSectionMouseClicked

       
         DefaultTableModel model2 =  (DefaultTableModel)jTableSection.getModel() ;
        int selecIndex = jTableSection.getSelectedRow();
        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();

        section.setText(model2.getValueAt(selecIndex, 1).toString());
        
        
    }//GEN-LAST:event_jTableSectionMouseClicked

    private void jTableUserAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserAccountMouseClicked
           DefaultTableModel model2 =  (DefaultTableModel)jTableUserAccount.getModel() ;
        int selecIndex = jTableUserAccount.getSelectedRow();
        //SchoolYear2 sy = (SchoolYear2)schoolyr.getSelectedItem();

        email.setText(model2.getValueAt(selecIndex, 1).toString());
        fullname.setText(model2.getValueAt(selecIndex, 2).toString());
        
        
        if (model2.getValueAt(selecIndex, 3).toString().equals("Male")) {
            Male1.setSelected(true);
            Female1.setSelected(false);
        }else {
            Female1.setSelected(true);
            Male1.setSelected(false);
        }
        
        
        question.setText(model2.getValueAt(selecIndex, 4).toString());
        answer.setText(model2.getValueAt(selecIndex, 5).toString());
        password.setText(model2.getValueAt(selecIndex, 6).toString());
    }//GEN-LAST:event_jTableUserAccountMouseClicked

    private void ADD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD5ActionPerformed
        
        String user = email.getText();
        String fname = fullname.getText();
        String ques = question.getText();
        String ans = answer.getText();
        String mdname = password.getText();

        String gender = "Male";
        if (Female1.isSelected()) {
            gender="Female";
        }

       
        //       String status = jComboBox1.getSelectedItem().toString();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now= LocalDateTime.now();
        String timestamp = dtf.format(now);

        if (verifyTextUser()) {

            try {

              
                Class.forName("com.mysql.cj.jdbc.Driver");
                Mycon=DriverManager.getConnection("jdbc:mysql://127.1.1.2:3306/dcaa_registrar","root","root");
                PreparedStatement ps;
                ps=Mycon.prepareStatement("insert into useraccount ( username, fullname, gender, question, answer, password, timestamp ) values (?,?,?,?,?,?,?)"); //id, username, fullname, gender, address, password, timestamp
                ps.setString(1, user);
                ps.setString(2, fname);
                ps.setString(3, gender);
                ps.setString(4, ques);
                ps.setString(5, ans);
                ps.setString(6, mdname);
                ps.setString(7, timestamp);

                if (verifyTextUser()) {
                    ps.executeUpdate();
                    table_update();
                    JOptionPane.showMessageDialog(this, "User Successfully Saved");
                    
                    
                    email.setText("");
                    fullname.setText("");
                    question.setText("");
                    answer.setText("");
                    password.setText("");

                }
            } catch (ClassNotFoundException  ex) {
                JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(RegistrationLogin.class.getName()).log(Level.SEVERE, null, ex);
            }catch ( SQLException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(RegistrationLogin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
        }
    }//GEN-LAST:event_ADD5ActionPerformed

    private void UPDATE5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE5ActionPerformed
       
            try {

        String user = email.getText();
        String fname = fullname.getText();
        String ques = question.getText();
        String ans = answer.getText();
        String mdname = password.getText();

        String gender = "Male";
        if (Female.isSelected()) {
            gender="Female";
        }

            if (verifyTextSchoolYear()) {

                DefaultTableModel model2 =  (DefaultTableModel)jTableUserAccount.getModel() ;
                int selecIndex= jTableUserAccount.getSelectedRow();

                int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("update useraccount  set username=?, fullname=?, gender=?, question=?, answer=?, password=?   where id=?");
   
                        ps.setString(1, user);
                        ps.setString(2, fname);
                        ps.setString(3, gender);
                        ps.setString(4, ques);
                        ps.setString(5, ans);
                        ps.setString(6, mdname);
                        ps.setInt(7, id);

                    if (verifyTextSchoolYear()) {
                        ps.execute();
                        table_update();

                        // schoolyr.setSelectedIndex(-1);

                        SY.setText("");

                        JOptionPane.showMessageDialog(null, "User Successfully Updated");
                        
                        email.setText("");
                        fullname.setText("");
                        question.setText("");
                        answer.setText("");
                        password.setText("");
                        
                        
                    }

                    // DESKTOP.schoolyear.setText(jComboBox1.getSelectedItem().toString());

                } catch (ClassNotFoundException | SQLException   ex) {

                    JOptionPane.showMessageDialog(this, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Failed...!!! One or More Empty ");
        }

        
        
        
    }//GEN-LAST:event_UPDATE5ActionPerformed

    private void DELETE5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE5ActionPerformed
           int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record ?","Warning",JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION)

        {

            if (verifyTextUser()) {

                try {

                    DefaultTableModel model2 =  (DefaultTableModel)jTableUserAccount.getModel() ;
                    int selecIndex = jTableUserAccount.getSelectedRow();
                    int id = Integer.parseInt(model2.getValueAt(selecIndex, 0).toString());

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Mycon=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dcaa_registrar","root","root");
                    PreparedStatement ps;
                    ps=Mycon.prepareStatement("delete from useraccount where id=?");
                    ps.setInt(1, id);

                    if (verifyTextUser()) {

                        ps.execute();
                        table_update();
                        JOptionPane.showMessageDialog(null, "User Successfully Deleted");
                        //schoolyr.setSelectedIndex(-1);

                        email.setText("");
                        fullname.setText("");
                        question.setText("");
                        answer.setText("");
                        password.setText("");

                    }
                }catch (ClassNotFoundException | SQLException  ex) {
                    Logger.getLogger(Add_School_President.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {

            JOptionPane.showMessageDialog(null, "Then please Proceed");

        }
    }//GEN-LAST:event_DELETE5ActionPerformed

    private void searchuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchuserFocusGained
         if( searchuser.getText().trim().equals("Search Here. . . ."))
        {
            searchuser.setText("");
            searchuser.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchuserFocusGained

    private void searchuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchuserFocusLost
        if(searchuser.getText().trim().equals(""))
        {
            searchuser.setText("Search Here. . . .");
            searchuser.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchuserFocusLost

    private void searchuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchuserKeyReleased
         LoadSearchDataUser();
    }//GEN-LAST:event_searchuserKeyReleased

    private void fullnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullnameFocusGained
        if( fullname.getText().trim().equals("Last Name, First Name Middle Name"))
        {
            fullname.setText("");
            fullname.setForeground(Color.black);
        }
    }//GEN-LAST:event_fullnameFocusGained

    private void fullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullnameFocusLost
        if(fullname.getText().trim().equals(""))
        {
            fullname.setText("Last Name, First Name Middle Name");
            fullname.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_fullnameFocusLost

    private void Male1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Male1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Male1ActionPerformed

    private void Female1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Female1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Female1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
        
       JOptionPane.showMessageDialog(this, " Unable to Close : " + "\n Please Log out Before you Leave   ","Message", JOptionPane.WARNING_MESSAGE);
        
//        Mainframe m = new Mainframe();
//        this.hide();
//        m.setVisible(true);

    }//GEN-LAST:event_formWindowClosing

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

          ProfileFrame m = new ProfileFrame();
      ProfileFrame.usernamedeskProf.setText(usernamedeskAdmin.getText());
      this.hide();
      m.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

       int dialogResult = JOptionPane.showConfirmDialog(null, "System Log out?","Warning",JOptionPane.YES_NO_OPTION);
         
         if (dialogResult == JOptionPane.YES_OPTION) 
         
         {
             
             Login l = new Login();
             this.hide();
             l.setVisible(true);
             dispose();
             
             
         } else {
          
            Mainframe m = new Mainframe();
            m.setVisible(true);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    
          
    
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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton ADD1;
    private javax.swing.JButton ADD2;
    private javax.swing.JButton ADD3;
    private javax.swing.JButton ADD4;
    private javax.swing.JButton ADD5;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton DELETE1;
    private javax.swing.JButton DELETE2;
    private javax.swing.JButton DELETE3;
    private javax.swing.JButton DELETE4;
    private javax.swing.JButton DELETE5;
    private javax.swing.JCheckBox Female;
    private javax.swing.JCheckBox Female1;
    private javax.swing.JCheckBox Femalereg;
    private javax.swing.JCheckBox Femalevice;
    private javax.swing.JCheckBox He;
    private javax.swing.JCheckBox Male;
    private javax.swing.JCheckBox Male1;
    private javax.swing.JCheckBox Malereg;
    private javax.swing.JCheckBox Malevice;
    private javax.swing.JTextField NAME;
    private javax.swing.JTextField NAMEreg;
    private javax.swing.JTextField NAMEvice;
    private javax.swing.JTextField STATUS;
    private javax.swing.JTextField STATUSreg;
    private javax.swing.JTextField STATUSvice;
    private javax.swing.JFormattedTextField SY;
    private javax.swing.JCheckBox She;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton UPDATE1;
    private javax.swing.JButton UPDATE2;
    private javax.swing.JButton UPDATE3;
    private javax.swing.JButton UPDATE4;
    private javax.swing.JButton UPDATE5;
    private javax.swing.JTextField answer;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fullname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel63;
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
    private javax.swing.JPanel jPanel31;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableRegistrar;
    private javax.swing.JTable jTableSchoolPresident;
    private javax.swing.JTable jTableSchoolVice;
    private javax.swing.JTable jTableSchoolYear;
    private javax.swing.JTable jTableSection;
    private javax.swing.JTable jTableUserAccount;
    private javax.swing.JTextField password;
    private javax.swing.JTextArea question;
    private javax.swing.JTextField searchschoolPresident;
    private javax.swing.JTextField searchschoolRegistrar;
    private javax.swing.JTextField searchschoolVice;
    private javax.swing.JTextField searchschoolyear;
    private javax.swing.JTextField searchsection;
    private javax.swing.JTextField searchuser;
    private javax.swing.JTextField section;
    public static javax.swing.JLabel usernamedeskAdmin;
    // End of variables declaration//GEN-END:variables
}
