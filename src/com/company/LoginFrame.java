package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
//import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    LoginFrame(){
        l1=new JLabel("Username");
        l1.setBounds(200,100, 100,30);
        add(l1);
        t1= new JTextField();
        t1.setBounds(275,105,100,20);
        add(t1);

        l2=new JLabel("Password");
        l2.setBounds(200,140, 100,30);
        add(l2);
        t2= new JPasswordField();
        t2.setBounds(275,145,100,20);
        add(t2);

        b1= new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(170,180,120,20);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Cancel");
        b2.setBounds(295,180,120,20);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setBounds(435,250,600,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1) {
            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();
            String st = "select * from login where username = '" + username + "' and password = '" + password + "'";
            try {

                ResultSet r = c.s.executeQuery(st);
                //while (r.next()) {
                    if(r.next())
                    {
                        new PreHomeScreen().setVisible(true);
                        this.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "INVALID USERNAME AND PASSWORD");
                        this.setVisible(false);
                    }
                //}
            } catch (SQLException ea) {
                ea.printStackTrace();
            }
        }
        else if(e.getSource()==b2){
            System.exit(0);
        }
    }
    public static void main(String[]args){
        new LoginFrame();
    }
}
