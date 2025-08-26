package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panText, aadharText;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;

    SignupTwo() {
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 140, 100, 30);
        add(rel);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categ = new JLabel("Category:");
        categ.setFont(new Font("Raleway", Font.BOLD, 20));
        categ.setBounds(100, 190, 100, 30);
        add(categ);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel inco = new JLabel("Income:");
        inco.setFont(new Font("Raleway", Font.BOLD, 20));
        inco.setBounds(100, 240, 200, 30);
        add(inco);

        String valIncome[] = {"Null", "< 1,50,000", "< 3,00,000", "< 5,00,000", "> 5,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);

        JLabel qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);

        String valEducation[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occu = new JLabel("Occupation:");
        occu.setFont(new Font("Raleway", Font.BOLD, 20));
        occu.setBounds(100, 390, 200, 30);
        add(occu);

        String valOccupation[] = {"Salaried", "Self-Employed", "Businessman", "Student", "Retired", "Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 14));
        panText.setBounds(300, 440, 400, 30);
        add(panText);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharText.setBounds(300, 490, 400, 30);
        add(aadharText);

        JLabel senCitz = new JLabel("Senior Citizen:");
        senCitz.setFont(new Font("Raleway", Font.BOLD, 20));
        senCitz.setBounds(100, 540, 200, 30);
        add(senCitz);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup citizen = new ButtonGroup();
        citizen.add(syes);
        citizen.add(sno);

        JLabel exiAcc = new JLabel("Existing Account:");
        exiAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        exiAcc.setBounds(100, 590, 200, 30);
        add(exiAcc);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existing = new ButtonGroup();
        existing.add(eyes);
        existing.add(eno);

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
        String sreligion = (String) religion.getSelectedItem(); //typecast it becaue it returns the object
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = panText.getText();
        String saadhar = aadharText.getText();

        String seniorcitizen = "";
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingacc = "";
        if (eyes.isSelected()) {
            existingacc = "Yes";
        } else if (eno.isSelected()) {
            existingacc = "No";
        }

        try {
            Conn c = new Conn();    // Connection establishing
            String query = "insert into signuptwo values('" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + seniorcitizen + "', '" + existingacc + "', '" + span + "', '" + saadhar + "')";
            c.s.executeUpdate(query);   //Execute query
            setVisible(false);
            new SignupThree().setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo();
    }
}
