package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    int random;
    JTextField nameText, fnameText, emailText, addressText, cityText, stateText, pincodeText;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton other, unmarried, married, others, female, male;

    SignupOne() {
        setLayout(null);

        Random rn = new Random();
        random = Math.abs((rn.nextInt() % 9000) + 1000);

        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel persDetails = new JLabel("Page 1: Personal Details");
        persDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        persDetails.setBounds(290, 80, 400, 30);
        add(persDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(300, 140, 400, 30);
        add(nameText);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameText = new JTextField();
        fnameText.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameText.setBounds(300, 190, 400, 30);
        add(fnameText);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(300, 290, 60, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(450, 290, 120, 30);
        add(female);

        others = new JRadioButton("Other");
        others.setBackground(Color.WHITE);
        others.setBounds(600, 290, 180, 30);
        add(others);

        ButtonGroup gendergroup = new ButtonGroup();    //used for grouping the Radio buttons so that only one should be selected
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(300, 340, 400, 30);
        add(emailText);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(300, 390, 100, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(450, 390, 100, 30);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(600, 390, 100, 30);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();    //used for grouping the Radio buttons so that only one should be selected
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));
        addressText.setBounds(300, 440, 400, 30);
        add(addressText);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(300, 490, 400, 30);
        add(cityText);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(300, 540, 400, 30);
        add(stateText);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pincodeText = new JTextField();
        pincodeText.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeText.setBounds(300, 590, 400, 30);
        add(pincodeText);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(620, 660, 80, 30);
        add(next);
        next.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gend = "";
        if (male.isSelected()) {
            gend = "male";
        } else if (female.isSelected()) {
            gend = "female";
        } else if (others.isSelected()) {
            gend = "Other";
        }

        String email = emailText.getText();
        String marit = "";
        if (married.isSelected()) {
            marit = "Married";
        } else if (unmarried.isSelected()) {
            marit = "Unmarried";
        } else if (other.isSelected()) {
            marit = "Other";
        }

        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pincodeText.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "F.Name is Required");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "dob is Required");
            } else if (gend.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is Required");
            } else if (marit.equals("")) {
                JOptionPane.showMessageDialog(null, "Marital is Required");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required");
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            } else {
                Conn c = new Conn();    // Connection establishing
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gend + "', '" + email + "', '" + marit + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
                c.s.executeUpdate(query);   //Execute query
                setVisible(false);  //to close SignupOne frame
                new SignupTwo().setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
