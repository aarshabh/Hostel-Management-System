package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddStudent extends JFrame implements ActionListener {
    JTextField stu,sno,ph,city;
    JRadioButton m,f;
    JComboBox br,dd,mm,yyyy;
    JButton next;
    //JComboBox<Integer> dd,mm,yyyy;
    AddStudent(){
        JLabel head= new JLabel("Enter Student Details");
        head.setBounds(275,10,500,40);
        head.setForeground(Color.white);
        head.setFont(new Font("",Font.PLAIN,30));
        add(head);


        //adding images
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/boy.jpeg"));
        Image i2 = i.getImage().getScaledInstance(300,240,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(450,60,300,240);
        add(img);
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/girl.jpeg"));
        Image ii2 = ii.getImage().getScaledInstance(300,240,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimg= new JLabel(ii3);
        iimg.setBounds(450,310,300,300);
        add(iimg);



        getContentPane().setBackground(Color.darkGray);


        //adding details


        JLabel usn = new JLabel("USN");
        usn.setBounds(50,70,100,20);
        usn.setFont(new Font("",Font.PLAIN,20));
        usn.setForeground(Color.white);
        add(usn);
        sno=new JTextField();
        sno.setBounds(150,70,120,20);
        add(sno);

        JLabel name = new JLabel("Name");
        name.setBounds(50,120,100,20);
        name.setFont(new Font("",Font.PLAIN,20));
        name.setForeground(Color.white);
        add(name);
        stu = new JTextField();
        stu.setBounds(150,120,120,20);
        add(stu);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(50,170,100,20);
        branch.setFont(new Font("",Font.PLAIN,20));
        branch.setForeground(Color.white);
        add(branch);


        String dept[] = {"Computer Science Engineering","Information Science Engineering","Electronics and Communication Engineering",
                "Mechanical Engineering","Electrical and Electronics Engineering","Electrical and Instrumentation Engineering","Civil Engineering",
                "Architecture"};
        br = new JComboBox(dept);
        br.setBounds(150,170,285,25);
        add(br);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(50,220,100,20);
        gender.setFont(new Font("",Font.PLAIN,20));
        gender.setForeground(Color.white);
        add(gender);

        m= new JRadioButton("M");
        m.setBounds(150,220,40,20);
        m.setForeground(Color.white);
        m.setBackground(Color.darkGray);
        add(m);
        f= new JRadioButton("F");
        f.setBounds(230,220,40,20);
        f.setForeground(Color.white);
        f.setBackground(Color.darkGray);
        add(f);
        /*gen=new JTextField();
        gen.setBounds(150,130,120,20);
        add(gen);*/


        JLabel dob = new JLabel("DOB");
        dob.setBounds(50,270,100,20);
        dob.setFont(new Font("",Font.PLAIN,20));
        dob.setForeground(Color.white);
        add(dob);
        //drop down box for date of birth in dd/mm/yyyy format
        //date
        String d[]=new String[31];
        int date =1;
        for(int j=0;j<31;j++){
            d[j]=date + "";
            date++;
        }
        dd = new JComboBox(d);
        dd.setBounds(150,270,40,20);
        add(dd);
        //month
        String mon[]={"January", "February","March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        mm= new JComboBox(mon);
        mm.setBounds(200,270,85,20);
        add(mm);

        //year
        String y[]=new String[25];
        int year =1995;
        for(int j=0;j<25;j++){
            y[j]=year + "";
            year++;
        }
        yyyy = new JComboBox(y);
        yyyy.setBounds(295,270,60,20);
        add(yyyy);



        JLabel nc = new JLabel("Native");
        nc.setBounds(50,320,100,20);
        nc.setFont(new Font("",Font.PLAIN,20));
        nc.setForeground(Color.white);
        add(nc);
        city=new JTextField();
        city.setBounds(150,320,120,20);
        add(city);


        JLabel phone = new JLabel("Phone");
        phone.setBounds(50,370,100,20);
        phone.setFont(new Font("",Font.PLAIN,20));
        phone.setForeground(Color.white);
        add(phone);
        ph=new JTextField();
        ph.setBounds(150,370,120,20);
        add(ph);

        //next button
        next = new JButton("Next>>");
        next.setBounds(175,470,100,25);
        next.addActionListener(this);
        add(next);

        //name.add(img);
        setLayout(null);
        setBounds(330,130,850,650);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String t2 = stu.getText();
        String t1 = sno.getText();
        String t4 = ph.getText();
        String t3 = city.getText();

        String gender=null;
        if(m.isSelected()){
            gender="M";
        }
        else if(f.isSelected()){
            gender="F";
        }
        String branch =(String)br.getSelectedItem();
        String d=(String)dd.getSelectedItem();
        String mon=(String)mm.getSelectedItem();
        String y=(String)yyyy.getSelectedItem();
        String dob = d + mon + y;

        conn c = new conn();
        String str= "insert into student value('"+t1+"','"+t2+"','"+branch+"','"+gender+"','"+d+"','"+mon+"','"+y+"','"+t3+"','"+t4+"')";

        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Detail Added");
            this.setVisible(false);
        }catch (Exception e){
            System.out.println(e);
        }


    }

    /*public static void main(String[]args){
        new AddStudent().setVisible(true);
    }*/
}
