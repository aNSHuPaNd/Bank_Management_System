package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton signin, signup, clear;
    JTextField cardtext;
    JPasswordField pintext;

    Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);    //ny default it is centre

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label); //add in frame

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardtext = new JTextField();
        cardtext.setFont(new Font("Arial", Font.BOLD, 14));
        cardtext.setBounds(300, 150, 230, 30);
        add(cardtext);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pintext = new JPasswordField();
        pintext.setFont(new Font("Arial", Font.BOLD, 14));
        pintext.setBounds(300, 220, 230, 30);
        add(pintext);

        signin = new JButton("SIGN IN");
        signin.setBounds(300, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        add(signin);
        signin.addActionListener(this);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);  //set the size of Login Frame
        setLocation(350, 200);  //(L to R,T to B)
        setVisible(true);   //Visible the Login Frame
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardtext.setText("");
            pintext.setText("");
        } else if (ae.getSource() == signin) {
            String cardNumb = cardtext.getText();
            String pinNumb = pintext.getText();
            try {
                Conn c = new Conn();
                String query = "select * from login where cardNo = '" + cardNumb + "' and pinNo = '" + pinNumb + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinNumb).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);  //to close login frame
            new SignupOne().setVisible(true);   //to open signup frame
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
