package Snakegame;

import javax.swing.*;
import java.awt.*;

public class Example extends JFrame{

public JLabel l1,l2,l3,l4;
public JTextField t1,t2;
public JButton b1;

public Example(){}
public Example(String s){
super(s);
}

public void Setcomponents(){
  
l1 = new JLabel("Addition of two numbers");
l2 = new JLabel("First Number");
l3 = new JLabel("Second number");
l4 = new JLabel();
t1 = new JTextField();
t2 = new JTextField();
b1 = new JButton("ADD");
setLayout(null);

l1.setBounds(50,50,200,20);
l2.setBounds(50,80,100,20);
t1.setBounds(150,80,100,20);
l3.setBounds(50,130,100,20);
t2.setBounds(150,130,100,20);
b1.setBounds(80,180,100,20);
l4.setBounds(50,240,200,20);

add(l1);
add(l2);
add(t1);
add(l3);
add(t2);
add(b1);
add(l4);

}

public static void main(String [] args){
   Example frame = new Example("Swing");
  
frame.Setcomponents();

frame.setSize(300,300);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}