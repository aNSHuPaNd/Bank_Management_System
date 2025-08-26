package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinNo) {
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from login where pinNo = '" + pinNo + "'");
            while (rs1.next()) {
                card.setText("Card Number: " + rs1.getString("cardNo").substring(0, 4) + "XXXXXXXX" + rs1.getString("cardNo").substring(12));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs2 = c.s.executeQuery("select * from bank where pinNo = '" + pinNo + "'");
            while (rs2.next()) {
                mini.setText(mini.getText() + "<html>" + rs2.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("amount") + "<br><br><html>");
                if (rs2.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs2.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs2.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
