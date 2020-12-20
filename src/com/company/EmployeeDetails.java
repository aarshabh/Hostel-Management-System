package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MessDetails extends JFrame implements ActionListener {

    JButton load,back;
    JTextField f;
    DefaultTableModel t1 = new DefaultTableModel();
    int count=0;

    MessDetails(){

        JLabel s = new JLabel("USN");
        s.setBounds(480,15,120,30);
        s.setFont(new Font("",Font.PLAIN,20));
        add(s);
        f = new JTextField();
        f.setBounds(550,20,100,25);
        add(f);


        t1.addColumn("USN");
        t1.addColumn("Fee Paid");
        t1.addColumn("Fee Due");
        JTable table = new JTable(t1);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(25,60,1000,600);
        add(sp);


        f.addActionListener(ae -> {
            t1.setRowCount(0);
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from student where student.fees = '"+f.getText()+"'");
                while(rs.next()){
                    int left =80000 - (Integer) rs.getObject(7);
                    t1.addRow(new Object[] { rs.getString(1 ),rs.getString(7),left});
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
                String r = "select * from student";
                if(count>=1){
                    t1.setRowCount(0);
                    count=0;
                }
                ResultSet rs = c.s.executeQuery(r);
                while(rs.next()){

                }
            }catch (Exception e){}
        }
        else if(ae.getSource()==back){
            this.setVisible(false);
            new HostelDetails().setVisible(true);
        }

    }

    public static void main(String[] args){
        new MessDetails().setVisible(true);
    }
}
