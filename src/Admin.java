import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Admin extends JFrame implements ActionListener {
    JFrame f;
    JButton b1, b2, b3, b4;

    Admin() {
        f = new JFrame("Admin");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        b1 = new JButton("Logout");
        b1.setBounds(120, 40, 150, 40);
        f.add(b1);

        b2 = new JButton("Details");
        b2.setBounds(120, 120, 150, 40);
        f.add(b2);

        b3 = new JButton("Schedule");
        b3.setBounds(120, 200, 150, 40);
        f.add(b3);

        b4 = new JButton("Charges");
        b4.setBounds(120, 280, 150, 40);
        f.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        f.setVisible(true);
        f.setSize(580, 350);
        f.setResizable(false);

    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            f.setVisible(false);
            new App();
        } else if (ee.getSource() == b2) {
            f.setVisible(false);
            try {
                new Details();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ee.getSource() == b3) {
            f.setVisible(false);
            new Schedule();
        } else if (ee.getSource() == b4) {
            f.setVisible(false);
            new Charges();
        }
    }
}
