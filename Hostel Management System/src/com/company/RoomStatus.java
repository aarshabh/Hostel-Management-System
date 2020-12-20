package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoomStatus extends JFrame implements ActionListener {
    JComboBox type;
    JTextField roomno,usn;
    JButton ad;

    RoomStatus(){
        JLabel roll = new JLabel("USN");
        roll.setBounds(270,120,120,30);
        roll.setFont(new Font("",Font.PLAIN,25));
        add(roll);
        usn = new JTextField();
        usn.setBounds(430,125,140,30);
        add(usn);

        JLabel ty = new JLabel("Room Type");
        ty.setBounds(270,160,140,30);
        ty.setFont(new Font("",Font.PLAIN,25));
        add(ty);
        String typestr[] = {"3-Sharing","4-Sharing"};
        type = new JComboBox(typestr);
        type.setBounds(430,160,120,30 );
        add(type);

        JLabel rno = new JLabel("Room No");
        rno.setFont(new Font("",Font.PLAIN,25));
        rno.setBounds(270,200,140,30);
        add(rno);
        roomno = new JTextField();
        roomno.setBounds(430,205,80,25);
        add(roomno);

        ad  = new JButton("Add");
        ad.setBounds(380,250,80,25);
        ad.addActionListener(this);
        add(ad);

        setLayout(null);
        setBounds(330,130,850,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String t1 = usn.getText();
        String t2 = (String) type.getSelectedItem();
        String t3 = roomno.getText();

        conn c = new conn();
        String str = "insert into roomstatus value('"+t1+"','"+t2+"','"+t3+"')";
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Updated");
            this.setVisible(false);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[]args){
        new RoomStatus().setVisible(true);
    }
}
