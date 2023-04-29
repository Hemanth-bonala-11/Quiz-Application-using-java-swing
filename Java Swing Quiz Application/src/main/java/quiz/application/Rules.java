package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    String option;
    
    Rules(String name,String option) {
        this.name = name;
        this.option=option;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to KBT");
        heading.setBounds(270, 30, 700, 30);
        heading.setFont(new Font("Algerian", Font.BOLD, 28));
        heading.setForeground(new Color(0, 0, 255));
        add(heading);
        JLabel heading2 = new JLabel( option + " Quiz");
        heading2.setBounds(315,70,700,30);
        heading2.setFont(new Font("Algerian", Font.BOLD, 28));
        heading2.setForeground(new Color(30, 144, 254));
        add(heading2);
        JLabel rules = new JLabel();
        rules.setBounds(20, 110, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. There Will Be 15 Questions " + "<br><br>" +
                   
                "2. Each Question has 10 points " + "<br><br>" +
                    
                "3. Time Limit for "+"<br><br>"
                    + "-->Questions 1 to 5 is 30 seconds "+"<br><br>"
                    + "-->Questions 6 to 10 is 1 minute"+"<br><br>"
                    + "-->Questions 11 to 15 is 2 minutes "
                    + "<br><br>" +

                "4. There will be 1 Life Line"+"<br><br>"+
                    "-->50-50 : 2 wrong options will be removed "+"<br><br>"+
            "<html>"
        );
        add(rules);
        
        
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name,option);
        } else {
            setVisible(false);
            new Login();
        }
    }
   

}
