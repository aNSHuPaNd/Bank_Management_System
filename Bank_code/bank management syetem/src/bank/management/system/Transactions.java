package bank.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,miniState,pinChange,balEnq,exit;
    String pinNumb;
    Transactions(String pinNumb) {
        this.pinNumb = pinNumb;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        image.add(deposit);
        deposit.addActionListener(this);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        image.add(fastcash);
        fastcash.addActionListener(this);

        miniState = new JButton("Mini Statement");
        miniState.setBounds(355, 450, 150, 30);
        image.add(miniState);
        miniState.addActionListener(this);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 30);
        image.add(pinChange);
        pinChange.addActionListener(this);

        balEnq = new JButton("Balance Enquiry");
        balEnq.setBounds(355, 485, 150, 30);
        image.add(balEnq);
        balEnq.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        image.add(exit);
        exit.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        } else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumb).setVisible(true);
        } else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumb).setVisible(true);
        } else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumb).setVisible(true);
        } else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumb).setVisible(true);
        } else if(ae.getSource() == balEnq){
            setVisible(false);
            new BalanceEnquiry(pinNumb).setVisible(true);
        } else if(ae.getSource() == miniState){
            new MiniStatement(pinNumb).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
