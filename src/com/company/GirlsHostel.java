package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GirlsHostel extends JFrame implements ActionListener {

    JTextField id_no,name,mail,ph,num;
    JComboBox id_proof;
    JRadioButton m,f;
    JButton back,add;
    GirlsHostel(){
        JLabel id = new JLabel("College ID");
        id.setBounds(280,160,120,30);
        id.setFont(new Font("",Font.PLAIN,20));
        add(id);
        id_no = new JTextField();
        id_no.setBounds(390,165,120,20);
        add(id_no);

        JLabel n = new JLabel("Name");
        n.setBounds(280,200,120,30);
        n.setFont(new Font("",Font.PLAIN,20));
        add(n);
        name = new JTextField();
        name.setBounds(390,205,120,20);
        add(name);

        JLabel gen = new JLabel("Gender");
        gen.setBounds(280,230,120,30);
        gen.setFont(new Font("",Font.PLAIN,20));
        add(gen);
        m=new JRadioButton("M");
        m.setBounds(390,230,40,30);
        m.setForeground(Color.black);
        add(m);
        f=new JRadioButton("F");
        f.setBounds(440,230,40,30);
        f.setForeground(Color.black);
        add(f);

        JLabel govt = new JLabel("ID Proof");
        govt.setBounds(280,270,120,30);
        govt.setFont(new Font("",Font.PLAIN,20));
        add(govt);
        String str[]= {"Aadhar Card","Pan Card","Driving License","Voter ID"};
        id_proof = new JComboBox(str);
        id_proof.setBounds(390,270,110,30);
        add(id_proof);

        JLabel number= new JLabel("ID Number");
        number.setFont(new Font("",Font.PLAIN,20));
        number.setBounds(280,310,120,30);
        add(number);
        num = new JTextField();
        num.setBounds(390,315,120,20);
        add(num);

        JLabel email = new JLabel("E-mail ID");
        email.setBounds(280,350,120,30);
        email.setFont(new Font("",Font.PLAIN,20));
        add(email);
        mail = new JTextField();
        mail.setBounds(390,355,120,20);
        add(mail);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(280,390,120,30);
        phone.setFont(new Font("",Font.PLAIN,20));
        add(phone);
        ph = new JTextField();
        ph.setBounds(390,395,120,30);
        add(ph);


        back = new JButton("<<Back");
        back.addActionListener(this);
        back.setBounds(30,550,100,20);
        add(back);

        add = new JButton("Add");
        add.setBounds(335,450,100,25);
        add.addActionListener(this);
        add(add);


        setLayout(null);
        setBounds(330,110,850,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String t1 = id_no.getText();
        String t2 = name.getText();
        String t3 = num.getText();
        String t4 = mail.getText();
        String t5 = ph.getText();

        String gender=null;


        if(m.isSelected()){
            gender="M";
        }
        else if(f.isSelected()){
            gender="F";
        }

        String pro= (String) id_proof.getSelectedItem();

        conn c = new conn();
        String str= "insert into warden value('"+t1+"','"+t2+"','"+gender+"','"+pro+"','"+t3+"','"+t4+"','"+t5+"')";

        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Detail Added");
            this.setVisible(false);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    /*public static void main(String[] args){
        new GirlsHostel().setVisible(true);
    }*/
}
