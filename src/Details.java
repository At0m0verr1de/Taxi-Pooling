import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.*;

public class Details extends JFrame implements ActionListener {
    JFrame f;
    JButton b1, b2, b3, b4;
    ConnectionClass c1 = new ConnectionClass();
    String q1 = "select * from login";
    ResultSet rs = c1.stm.executeQuery(q1);
    DefaultTableModel model = new DefaultTableModel(new String[] { "BITSID", "Name", "Phone" }, 0);
    Container cnt = this.getContentPane();

    Details() throws SQLException {
        f = new JFrame("BITS Cab Service");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        cnt.setLayout(new FlowLayout(FlowLayout.CENTER));

        while (rs.next()) {
            String[] tbData = { rs.getString("BITSID"), rs.getString("Name"), String.valueOf(rs.getInt("Phone")) };
            model.addRow(tbData);
        }

        JTable t1 = new JTable(model);
        t1.setBounds(20, 20, 150, 40);
        JScrollPane pg = new JScrollPane(t1);
        cnt.add(pg);
        this.pack();
        t1.setFont(new Font("Serif", Font.BOLD, 20));
        t1.setRowHeight(40);
        t1.setRowMargin(10);
        f.add(t1);

        b1 = new JButton("Back");
        b1.setBounds(120, 200, 150, 40);
        f.add(b1);

        b1.addActionListener(this);

        f.setVisible(true);
        f.setSize(580, 350);
        f.setResizable(false);

    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            f.setVisible(false);
            new Admin();
        }
    }
}
