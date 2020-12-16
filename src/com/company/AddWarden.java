package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WardenDetails extends JFrame implements ActionListener {
    JButton gh,bh1,bh2,prev;

    WardenDetails(){
        gh = new JButton("Girls Hostel");
        gh.setBounds(80,275,200,30);
        gh.addActionListener(this);
        add(gh);

        getContentPane().setBackground(Color.DARK_GRAY);

        bh1 = new JButton("Boys Hostel 1");
        bh1.setBounds(290,275,200,30);
        bh1.addActionListener(this);
        add(bh1);

        bh2= new JButton("Boys Hostel 2");
        bh2.setBounds(500,275,200,30);
        bh2.addActionListener(this);
        add(bh2);

        prev = new JButton("<<Previous");
        prev.setBounds(80,500,100,25);
        prev.addActionListener(this);
        add(prev);

        setLayout(null);
        setBounds(330,130,850,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==prev){
            new DashBoard().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==gh){
            new GirlsHostel().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==bh1){
            new BoysHostel1().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==bh2){
            new BoysHostel2().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[]args){
       new WardenDetails().setVisible(true);
    }
}
