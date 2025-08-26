package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);    //Register the driver
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Test@123");  //Create Connection
            s = c.createStatement();    //Create statement
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
