import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class App extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1;
    JButton b1, b2;

    App() {
        f = new JFrame("BITS Cab Service");
        f.setBackground(Color.white);
        f.setLayout(null);

        b1 = new JButton("Admin");
        b1.setBounds(40, 50, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("Student");
        b2.setBounds(200, 50, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        f.add(b2);

        f.getContentPane();
        f.setVisible(true);
        f.setSize(350, 150);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            f.setVisible(false);
            new AdminLogin();
        } else if (ae.getSource() == b2) {
            f.setVisible(false);
            new UserLogin();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }

    // public static void showMenu() {
    // System.out.println("Enter any one of the following options:");
    // System.out.println("S -> register yourself");
    // System.out.println("T -> request new trip");
    // System.out.println("C -> check details for a trip");
    // System.out.println("A -> accept a trip");
    // System.out.println("R -> reject a trip");
    // }

    // public static void handleInput(String input) {
    // switch (input) {
    // case "S":
    // registerUser();
    // break;
    // case "T":
    // // TODO: Hande trip request
    // break;

    // case "C":
    // // TODO: Handle details check
    // break;

    // case "A":
    // // TODO: Hande trip acceptation
    // break;

    // case "R":
    // // TODO: Hande trip rejection
    // break;

    // default:
    // System.out.println("Please enter a valid input");
    // }
    // }

    // public static void registerUser() {
    // System.out.println("Please enter your name, BITS ID no and phone number in
    // the same order");
    // Scanner sc = new Scanner(System.in);
    // String name = sc.nextLine();
    // String ID = sc.nextLine();
    // Long phoneNo = sc.nextLong();
    // sc.close();

    // User user = new User(ID, name, phoneNo);
    // UsersData data = new UsersData();
    // if (data.getRegisteredUsers().contains(user)) {
    // System.out.println("You are already registered");
    // } else {
    // data.addUser(user);
    // System.out.println("You are registered!!");
    // }
    // }
}
