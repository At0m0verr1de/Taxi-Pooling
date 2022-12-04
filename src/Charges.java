import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.*;

public class Charges extends JFrame {
    JFrame f;
    JButton b1, b2, b3, b4;

    Charges() throws SQLException {
        ConnectionClass c1 = new ConnectionClass();
        ConnectionClass c2 = new ConnectionClass();
        String q1 = "select * from login";
        ResultSet rs = c1.stm.executeQuery(q1);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        Vector<String> columnNames = new Vector<String>(columnsNumber);

        columnNames.add(rsmd.getColumnName(1));
        columnNames.add("Charges");

        Vector data = new Vector();
        Vector row = new Vector();
        while (rs.next()) {
            row = new Vector(2);
            row.add(rs.getObject(1));
            String q2 = "select cost from proposed where MemberID like '%" + rs.getObject(1) + "%';";
            ResultSet rs2 = c2.stm.executeQuery(q2);
            int sum = 0;
            while (rs2.next()) {
                System.out.println("Adding");
                sum += Integer.parseInt(rs2.getString(1));
            }
            row.add(sum);
            data.add(row);
        }

        JFrame frame = new JFrame("BITS Cab Service");
        frame.setSize(500, 400);
        JScrollPane jsp = new JScrollPane(new JTable(data, columnNames));
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jsp, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

}
