package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessUpdate extends JFrame implements ActionListener {


    JTextField chair,table,vegetables,plates,cylinder;
    JButton ad;

    MessUpdate(){
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/Mess.jpeg"));
        Image ii = i.getImage().getScaledInstance(850,1066,Image.SCALE_DEFAULT);
        ImageIcon iii = new ImageIcon(ii);
        JLabel l = new JLabel(iii);
        l.setBounds(0,0,850,1066);
        add(l);
        //setVisible(true);

        JLabel ch = new JLabel("Add Chairs");
        ch.setBounds(280,140,140,30);
        ch.setForeground(Color.RED);
        ch.setFont(new Font("",Font.PLAIN,25));
        chair = new JTextField();
        chair.setBounds(430,143,70,30);
        add(chair);
        l.add(ch);

        JLabel ta = new JLabel("Add Tables");
        ta.setBounds(280,180,140,30);
        ta.setForeground(Color.RED);
        ta.setFont(new Font("",Font.PLAIN,25));
        table = new JTextField();
        table.setBounds(430,183,70,30);
        l.add(ta);
        add(table);

        JLabel veg = new JLabel("Vegetables");
        veg.setBounds(280,220,140,30);
        veg.setFont(new Font("",Font.PLAIN,25));
        veg.setForeground(Color.RED);
        vegetables = new JTextField();
        vegetables.setBounds(430,223,70,30);
        add(vegetables);
        l.add(veg);

        JLabel pl = new JLabel("Add Plates");
        pl.setBounds(280,260,140,30);
        pl.setFont(new Font("",Font.PLAIN,25));
        pl.setForeground(Color.RED);
        plates = new JTextField();
        plates.setBounds(430,263,70,30);
        add(plates);
        l.add(pl);

        JLabel cy = new JLabel("Add Cylinder");
        cy.setBounds(280,300,140,30);
        cy.setFont(new Font("",Font.PLAIN,25));
        cy.setForeground(Color.RED);
        cylinder = new JTextField();
        cylinder.setBounds(430,303,70,30);
        add(cylinder);
        l.add(cy);

        ad = new JButton("Add");
        ad.setBounds(385,345,60,30);
        ad.setForeground(Color.darkGray);
        ad.setForeground(Color.black);
        ad.addActionListener(this);
        l.add(ad);

        setLayout(null);
        setBounds(400,100,850,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String t1 = chair.getText();
        String t2 = table.getText();
        String t3 = vegetables.getText();
        String t4 = plates.getText();
        String t5 = cylinder.getText();

        conn c = new conn();
        String str = "insert into messupdate values('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"')";
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"updated");
            this.setVisible(false);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[]args){
        new MessUpdate().setVisible(true);
    }
}
