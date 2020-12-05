package com.company;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame {
    JMenuBar mb;
    JMenu m1,m2;

    JMenuItem i1,i2,i3,i4;
    DashBoard(){
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/hostel1.jpeg"));
        Image ii1 = i.getImage().getScaledInstance(1280,800,Image.SCALE_DEFAULT);
        ImageIcon ii2 = new ImageIcon(ii1);
        JLabel l= new JLabel(ii2);
        l.setBounds(0,0,1280,800);
        add(l);


        mb = new JMenuBar();
        add(mb);

        m1 = new JMenu("HOSTEL MANAGEMENT SYSTEM");
        m1.setForeground(Color.darkGray);
        mb.add(m1);

        m2 = new JMenu("OFFICE");
        m2.setForeground(Color.black);
        mb.add(m2);

        i1 = new JMenuItem("WARDEN DETAILS");
        m1.add(i1);

        i2 = new JMenuItem("ADD EMPLOYEE");
        m2.add(i2);

        i3 = new JMenuItem("ADD ROOM");
        m2.add(i3);

        i4 = new JMenuItem("MESS");
        m2.add(i4);
        //m2.setVisible(true);
        l.add(mb);
        mb.setBounds(0,0,1280,25);

        JLabel l1= new JLabel("RNSIT Hostel");
        l1.setBounds(450,75,400,80);
        l1.setForeground(Color.black);
        l1.setFont(new Font("",Font.BOLD,30));
        l.add(l1);

        setLayout(null);
        setBounds(140,20,1280,800);
        setVisible(true);

    }
    public static void main(String[]args){
        new DashBoard().setVisible(true);
    }
}
