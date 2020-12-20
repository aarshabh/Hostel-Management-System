package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField id_no,name,mail,ph,sal;
    JRadioButton m,f;
    JComboBox role;
    JButton ad;

    AddEmployee(){
        JLabel head = new JLabel("Add Employee");
        head.setBounds(100,60,180,40);
        head.setForeground(Color.white);
        head.setFont(new Font("Tacoma",Font.BOLD,25));
        add(head);

        JLabel id = new JLabel("ID Number");
        id.setBounds(80,140,120,30);
        id.setFont(new Font("",Font.PLAIN,20));
        id.setForeground(Color.white);
        id_no = new JTextField();
        id_no.setBounds(230,140,120,30);
        add(id_no);
        add(id);

        JLabel n = new JLabel("Name");
        n.setBounds(80,180,120,30);
        n.setFont(new Font("",Font.PLAIN,20));
        n.setForeground(Color.white);
        name = new JTextField();
        name.setBounds(230,180,120,30);
        add(name);
        add(n);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(80,220,120,20);
        gender.setForeground(Color.white);
        gender.setFont(new Font("",Font.PLAIN,20));
        m= new JRadioButton("M");
        m.setBounds(230,220,40,20);
        add(m);
        f= new JRadioButton("F");
        f.setBounds(320,220,40,20);
        add(f);
        add(gender);

        JLabel work= new JLabel("Select Post");
        work.setBounds(80,260,140,20);
        work.setFont(new Font("",Font.PLAIN,20));
        work.setForeground(Color.white);
        String task[] = {"Office Staff","Accountant","Mess In-charge","Security","Cook","Cleaner","Driver"};
        role = new JComboBox(task);
        role.setBounds(230,260,150,20);
        add(role);
        add(work);

        JLabel email = new JLabel("E-mail ID");
        email.setBounds(80,300,120,30);
        email.setFont(new Font("",Font.PLAIN,20));
        email.setForeground(Color.white);
        add(email);
        mail = new JTextField();
        mail.setBounds(230,305,180,30);
        add(mail);

        JLabel fee = new JLabel("Salary");
        fee.setBounds(80,340,120,30);
        fee.setFont(new Font("",Font.PLAIN,20));
        fee.setForeground(Color.white);
        add(fee);
        sal = new JTextField();
        sal.setBounds(230,345,120,30);
        add(sal);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(80,380,120,30);
        phone.setFont(new Font("",Font.PLAIN,20));
        phone.setForeground(Color.white);
        add(phone);
        ph = new JTextField();
        ph.setBounds(230,385,120,30);
        add(ph);

        ad = new JButton("ADD");
        ad.setBounds(160,435,70,25);
        ad.setBackground(Color.white);
        ad.addActionListener(this);
        add(ad);

        getContentPane().setBackground(Color.darkGray);
        setLayout(null);
        setBounds(330,110,850,650);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        String t1 = id_no.getText();
        String t2 = name.getText();
        String t3 = (String) role.getSelectedItem();
        String t4 = null;
        String t5 = mail.getText();
        String t6 = sal.getText();
        String t7 = ph.getText();

        if(m.isSelected()){
            t4 = "M";
        }
        else if(f.isSelected()){
            t4 = "F";
        }
        conn c = new conn();
        try{
            String str = "insert into employee value('"+t1+"','"+t2+"','"+t4+"','"+t3+"','"+t5+"','"+t6+"','"+t7+"')";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Employee Added");
            this.setVisible(false);
        }catch (Exception e){
            System.out.println(e);;
        }
    }



    public static void main(String[]args){
        new AddEmployee().setVisible(true);
    }
}
