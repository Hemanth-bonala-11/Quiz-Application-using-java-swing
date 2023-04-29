package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Child implements ItemListener{
    String option;
    JComboBox c1;
    Child(JComboBox c1){
        this.c1=c1;
    }
    @Override
    public void itemStateChanged(ItemEvent ie){
        if(ie.getSource()==c1){
           option= (String)c1.getSelectedItem();
        }
    }
}
public class Login extends JFrame implements ActionListener{
 
    JButton rules, back;
    JTextField tfname;
    JComboBox c1;
    
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        String options[] = {"Java","Cpp","R","C"};
        try{
        ImageIcon i1 = new ImageIcon(getClass().getResource("kbt2.png"));
        JLabel image = new JLabel(i1);
        
        image.setBounds(0, 0, 600, 500);
        add(image);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel heading = new JLabel("Kaun Banega ");
        heading.setBounds(700, 20, 500, 40);
        JLabel heading2 =new JLabel("Topper ??");
        heading2.setBounds(750,70,500,40);
        
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        heading2.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading2.setForeground(new Color(30, 144, 254));
        add(heading);
        add(heading2);
        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 120, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(735, 170, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        JLabel topic=new JLabel("Select the topic ");
        topic.setBounds(735,210,150,25);
        topic.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        topic.setForeground(new Color(30, 144, 254));
        c1=new JComboBox(options);
        Child obj=new Child(c1);
        c1.addItemListener(obj);
        c1.setBounds(900,210,150,25);
        c1.setForeground(new Color(30, 144, 254));
        add(topic);
        add(c1);
        
        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            if(!(name.equals(""))){
            String option=(String)c1.getSelectedItem();
            setVisible(false);
            Rules obj=new Rules(name,option);
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter name to Start Quiz ");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }
   
    
    public static void main(String[] args) {
        new Login();
    }
}
