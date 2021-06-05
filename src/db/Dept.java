package db;


import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class Dept extends JFrame {
    
   JFrame frame1;

  

    Connection con;

    ResultSet rs, rs1;

    Statement st, st1;

    PreparedStatement pst;

    String ids;

    static JTable table;

    String[] columnNames = {"dept_name"};

    String from;
    
 

    public void showTableData() {

 

        frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());

//TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

      

//String textvalue = textbox.getText();

        String dept_name = "";

       
        

        

 

        try {
             con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
                        "root", "12345sss");

            st = con.createStatement();
          

              pst = con.prepareStatement("select dept_name from student where ID = '00128'");

            ResultSet rs = pst.executeQuery();

            int i = 0;

            if (rs.next()) {

               dept_name = rs.getString("dept_name");

                

                

                model.addRow(new Object[]{dept_name});

                i++;

            }

            if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);

    }

 

    public static void main(String args[]) {

       new Dept();
                
    }

}
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

