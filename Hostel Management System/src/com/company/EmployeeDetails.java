package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeDetails extends JFrame implements ActionListener {

    JButton load,back;
    JTextField f;
    DefaultTableModel t1 = new DefaultTableModel();
    int count=0;

    EmployeeDetails(){

        JLabel s = new JLabel("ID");
        s.setBounds(480,15,120,30);
        s.setFont(new Font("",Font.PLAIN,20));
        add(s);
        f = new JTextField();
        f.setBounds(550,20,100,25);
        add(f);


        t1.addColumn("Emp ID");
        t1.addColumn("Name");
        t1.addColumn("Gender");
        t1.addColumn("Post");
        t1.addColumn("Mail ID");
        t1.addColumn("Salary");
        t1.addColumn("Phone");

        JTable table = new JTable(t1);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(25,60,1000,600);
        add(sp);


        f.addActionListener(ae -> {
            t1.setRowCount(0);
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from employee where employee.id = '"+f.getText()+"'");
                while(rs.next()){
                    t1.addRow(new Object[]{
                            rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
                            ,rs.getString(6),rs.getString(7)
                    });
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        });

        load = new JButton("LOAD");
        load.setBackground(Color.black);
        load.setForeground(Color.white);
        load.addActionListener(this);
        load.setBounds(390,700,120,25);
        add(load);

        back = new JButton("BACK");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        back.setBounds(530,700,120,25);
        add(back);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setBounds(190,20,1080,800);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==load){
            try{
                count++;
                conn c = new conn();
                String r = "select * from employee";
                if(count>=1){
                    t1.setRowCount(0);
                    count=0;
                }
                ResultSet rs = c.s.executeQuery(r);
                while(rs.next()){
                    t1.addRow(new Object[]{
                            rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
                            ,rs.getString(6), rs.getString(7)
                    });
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back){
            this.setVisible(false);
            new HostelDetails().setVisible(true);
        }

    }

    public static void main(String[] args){
        new EmployeeDetails().setVisible(true);
    }
}
