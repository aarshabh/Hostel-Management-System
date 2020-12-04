package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
//import java.awt.event.*;

public class PreHomeScreen extends JFrame implements ActionListener {
    PreHomeScreen() {
        setSize(600, 600);
        setLocation(470, 150);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        JPanel l = new JPanel();
        l.setBackground(Color.YELLOW);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/logo.jpeg"));
        JLabel l1 = new JLabel(i1);
        l1.setLocation(155, 150);
        l1.setSize(255, 255);
        add(l1);

        String name = "Hostel Management System";
        JLabel l2 = new JLabel(name);
        l2.setForeground(Color.BLUE);
        l2.setLocation(120, 50);
        l2.setSize(350, 150);
        l2.setFont(new Font("", Font.BOLD, 25));
        add(l2);


        setLayout(null);
        setVisible(true);



        JButton jb = new JButton("NEXT>>");
        jb.setBackground(Color.WHITE);
        jb.setForeground(Color.BLACK);
        jb.setBounds(430, 500, 90, 25);
        jb.addActionListener(this);
        add(jb);

            /*while (true) {
                l2.setVisible(false);
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                }
                l2.setVisible(true);
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                }
            }*/
    }
    public void actionPerformed(ActionEvent ae){
        new LoginFrame().setVisible(true);
        this.setVisible(false);
    }
}
