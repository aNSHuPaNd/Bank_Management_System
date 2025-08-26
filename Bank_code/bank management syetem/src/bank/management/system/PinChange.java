package bank.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinText, rePinText;
    JButton change, back;
    String pinNumb;
    
    PinChange(String pinNumb) {
        this.pinNumb = pinNumb;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pin = new JLabel("New PIN:");
        pin.setFont(new Font("System", Font.BOLD, 16));
        pin.setForeground(Color.WHITE);
        pin.setBounds(165, 320, 180, 25);
        image.add(pin);

        pinText = new JPasswordField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 25));
        pinText.setBounds(330, 320, 180, 25);
        image.add(pinText);

        JLabel rePin = new JLabel("Re-Enter New PIN:");
        rePin.setFont(new Font("System", Font.BOLD, 16));
        rePin.setForeground(Color.WHITE);
        rePin.setBounds(165, 360, 180, 25);
        image.add(rePin);

        rePinText = new JPasswordField();
        rePinText.setFont(new Font("Raleway", Font.BOLD, 25));
        rePinText.setBounds(330, 360, 180, 25);
        image.add(rePinText);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        image.add(change);
        change.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            String npin = pinText.getText();
            String rpin = rePinText.getText();
            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if (npin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }
            if (rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
            }
            try{
                Conn c = new Conn();
                String query1 = "update bank set pinNo = '"+rpin+"' where pinNo = '"+pinNumb+"'";
                String query2 = "update login set pinNo = '"+rpin+"' where pinNo = '"+pinNumb+"'";
                String query3 = "update signupthree set pinNo = '"+rpin+"' where pinNo = '"+pinNumb+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch(Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinNumb).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
