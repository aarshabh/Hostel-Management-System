package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HostelDetails extends JFrame implements ActionListener {
    JButton warden,student,mess,rooms,fupdate,back,logout;

    HostelDetails(){

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/logo.jpeg"));
        Image ii = i.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(ii);
        JLabel image = new JLabel(i1);
        image.setBounds(300,150,200,200);
        add(image);

        JLabel l1 = new JLabel("SELECT BELOW");
        l1.setFont(new Font("",Font.BOLD,25));
        l1.setBounds(170,80,240,30);
        l1.setForeground(Color.blue);
        add(l1);

        warden = new JButton("WARDEN");
        warden.setBounds(100,160,120,30);
        warden.setBackground(Color.BLACK);
        warden.setForeground(Color.white);
        warden.addActionListener(this);
        add(warden);

        student = new JButton("STUDENT");
        student.setBounds(100,200,120,30);
        student.setBackground(Color.BLACK);
        student.setForeground(Color.white);
        student.addActionListener(this);
        add(student);

        mess = new JButton("EMPLOYEE");
        mess.setBounds(100,240,120,30);
        mess.setForeground(Color.white);
        mess.setBackground(Color.BLACK);
        mess.addActionListener(this);
        add(mess);

        rooms = new JButton("ROOMS");
        rooms.setBounds(100,280,120,30);
        rooms.setForeground(Color.white);
        rooms.setBackground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);

        back = new JButton("BACK");
        back.setBounds(100,320,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        add(back);

        logout = new JButton("LOG OUT");
        logout.setBounds(230,400,100,30);
        logout.setForeground(Color.black);
        logout.setBackground(Color.white);
        logout.addActionListener(this);
        add(logout);

        getContentPane().setBackground(Color.gray);
        setBounds(470,150,600,600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            this.setVisible(false);
            new DashBoard().setVisible(true);
        }
        else if(ae.getSource() == warden){
            this.setVisible(false);
            new WardenDetails().setVisible(true);
        }
        else if(ae.getSource() == student){
            this.setVisible(false);
            new StudentDetails().setVisible(true);
        }
        else if(ae.getSource() == mess){
            this.setVisible(false);
            new EmployeeDetails().setVisible(true);
        }
        else if(ae.getSource() == rooms){
            this.setVisible(false);
            new RoomDetails().setVisible(true);
        }
        else if(ae.getSource()==logout){
            this.setVisible(false);
            new PreHomeScreen().setVisible(true);
        }
    }
    public static void main(String[] agrs){
        new HostelDetails().setVisible(true);
    }
}
