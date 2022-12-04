import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Proposed extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton b1, b2, b3;
    UserData usr;

    Proposed(UserData usr) throws SQLException {
        this.usr = usr;
        ConnectionClass obj = new ConnectionClass();
        String query = "SELECT * FROM proposed where MemberID like '%" + usr.getBITSID() + "%';";
        ResultSet rs = obj.stm.executeQuery(query);
        rs.next();

        f = new JFrame("Rides");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("From");
        l1.setBounds(190, 30, 500, 50);
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l1);

        l2 = new JLabel("To");
        l2.setBounds(190, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l2);

        l3 = new JLabel("Date");
        l3.setBounds(190, 30, 500, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l3);

        l4 = new JLabel("Time");
        l4.setBounds(190, 30, 500, 50);
        l4.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l4);

        l5 = new JLabel("Members");
        l5.setBounds(190, 30, 500, 50);
        l5.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l5);

        l6 = new JLabel("Cost (/head)");
        l6.setBounds(190, 30, 500, 50);
        l6.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l6);

        l7 = new JLabel(rs.getString("Source"));
        l7.setBounds(190, 30, 500, 50);
        l7.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l7);

        l8 = new JLabel(rs.getString("Destination"));
        l8.setBounds(190, 30, 500, 50);
        l8.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l8);

        l9 = new JLabel(rs.getString("Date"));
        l9.setBounds(190, 30, 500, 50);
        l9.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l9);

        l10 = new JLabel(rs.getString("Time"));
        l10.setBounds(190, 30, 500, 50);
        l10.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l10);

        l11 = new JLabel(rs.getString("MemberID"));
        l11.setBounds(190, 30, 500, 50);
        l11.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l11);

        l12 = new JLabel(rs.getString("Cost"));
        l12.setBounds(190, 30, 500, 50);
        l12.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l12);

        l13 = new JLabel("Accept Ride?");
        l13.setBounds(190, 30, 500, 50);
        l13.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(l13);

        b1 = new JButton("Yes");
        b1.setBounds(500, 500, 120, 30);
        f.add(b1);

        b2 = new JButton("No");
        b2.setBounds(600, 600, 120, 30);
        f.add(b2);

        b3 = new JButton("Back");
        b3.setBounds(700, 700, 120, 30);
        f.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        f.getContentPane();
        f.setVisible(true);
        f.setSize(1000, 1000);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String query = "SELECT * FROM proposed where MemberID like '%" + usr.getBITSID() + "%';";
                ResultSet rs = obj.stm.executeQuery(query);
                rs.next();
                String[] members = rs.getString("MemberID").split(" ");
                for (int i = 0; i < members.length; i++) {
                    if (members[i].substring(0, members[i].length() - 1).equals(usr.getBITSID())) {
                        members[i] = usr.getBITSID() + "A";
                        break;
                    }
                }
                String newMembers = "";
                for (int i = 0; i < members.length; i++) {
                    newMembers += members[i] + " ";
                }
                query = "UPDATE proposed SET MemberID = '" + newMembers + "' WHERE MemberID like '%" + usr.getBITSID()
                        + "%';";
                int aa = obj.stm.executeUpdate(query);
                f.setVisible(false);

                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Ride Confirmed for you. Waiting for other members.");
                    f.setVisible(false);
                    new Student(this.usr);
                } else {
                    JOptionPane.showMessageDialog(null, "Error.");
                    this.f.setVisible(false);
                    this.f.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String query = "Delete from proposed WHERE MemberID like '%" + usr.getBITSID() + "%';";
                int aa = obj.stm.executeUpdate(query);
                f.setVisible(false);

                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Ride rejected.");
                    f.setVisible(false);
                    new Student(this.usr);
                } else {
                    JOptionPane.showMessageDialog(null, "Error.");
                    this.f.setVisible(false);
                    this.f.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b3) {
            f.setVisible(false);
            new Student(this.usr);
        }
    }
}
