package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class WardenDetails extends JFrame implements ActionListener {
    JTextField usn;
    JButton load, back;
    DefaultTableModel t1 = new DefaultTableModel();
    int count = 0;

    WardenDetails(){

        t1.addColumn("ID");
        t1.addColumn("Hostel");
        t1.addColumn("Name");
        t1.addColumn("Gender");
        t1.addColumn("ID Proof");
        t1.addColumn("ID Number");
        t1.addColumn("Main ID");
        t1.addColumn("Phone No");

        JTable table = new JTable(t1);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(25,40,1000,600);
        add(sp);

        JLabel id = new JLabel("ID");
        id.setBounds(490,10,120,25);
        id.setFont(new Font("",Font.PLAIN,20));
        id.setForeground(Color.black);
        add(id);
        usn = new JTextField();
        usn.setBounds(570,10,120,25);
        add(usn);

        usn.addActionListener(ae -> {
            t1.setRowCount(0);
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from warden where warden.id = '"+usn.getText()+"'");
                while(rs.next()){
                    t1.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getString(6),rs.getObject(7), rs.getString(8)});
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        });

        load = new JButton("LOAD DATA");
        load.addActionListener(this);
        load.setBackground(Color.white);
        load.setForeground(Color.black);
        load.setBounds(360,680,140,30);
        add(load);

        back = new JButton("BACK");
        back.addActionListener(this);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(510,680,140,30);
        add(back);

        //getContentPane().setBackground(Color.black);
        setLayout(null);
        setVisible(true);
        setBounds(180,30,1080,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==load){
            try{
                count++;
                conn c = new conn();
                String r = "select * from warden";
                if(count>=1){
                    t1.setRowCount(0);
                    count=0;
                }
                ResultSet rs = c.s.executeQuery(r);
                while(rs.next()){
                    t1.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getString(6),rs.getObject(7), rs.getString(8)});
                }
            }catch (Exception e){}
        }
        else if(ae.getSource()==back){
            this.setVisible(false);
            new HostelDetails().setVisible(true);
        }
    }

    public static void main(String[]args){
        new WardenDetails().setVisible(true);
    }
}
