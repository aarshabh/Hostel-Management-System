package com.company;

import javax.swing.*;
import java.awt.*;

public class MessDetails extends JFrame {


    JTextField chair,table,vegetables,plates,cylinder;
    MessDetails(){

        JLabel ch = new JLabel("Add Chairs");
        ch.setBounds(280,140,140,30);
        ch.setFont(new Font("",Font.PLAIN,25));
        chair = new JTextField();
        chair.setBounds(430,143,70,30);
        add(chair);
        add(ch);

        JLabel ta = new JLabel("Add Tables");
        ta.setBounds(280,180,140,30);
        ta.setFont(new Font("",Font.PLAIN,25));
        table = new JTextField();
        table.setBounds(430,183,70,30);
        add(ta);
        add(table);

        JLabel veg = new JLabel("Add Chairs");
        veg.setBounds(280,220,140,30);
        veg.setFont(new Font("",Font.PLAIN,25));
        vegetables = new JTextField();
        vegetables.setBounds(430,223,70,30);
        add(vegetables);
        add(veg);

        JLabel pl = new JLabel("Add Chairs");
        pl.setBounds(280,260,140,30);
        pl.setFont(new Font("",Font.PLAIN,25));
        plates = new JTextField();
        plates.setBounds(430,263,70,30);
        add(plates);
        add(pl);

        JLabel cy = new JLabel("Add Chairs");
        cy.setBounds(280,300,140,30);
        cy.setFont(new Font("",Font.PLAIN,25));
        cylinder = new JTextField();
        cylinder.setBounds(430,303,70,30);
        add(cylinder);
        add(cy);

        setLayout(null);
        setBounds(330,130,850,650);
        setVisible(true);
    }
    public static void main(String[]args){
        new MessDetails().setVisible(true);
    }
}
