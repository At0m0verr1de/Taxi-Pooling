import java.sql.*;
import java.util.*;

public class Schedule {
    Schedule() {
        ConnectionClass obj = new ConnectionClass();
        String query = "SELECT * FROM rides;";
        try {
            ResultSet rs = obj.stm.executeQuery(query);
            while (rs.next()) {
                query = "SELECT * from rides where source = '" + rs.getString("source") + "' and destination = '"
                        + rs.getString("destination") + "' and date = '" + rs.getString("date") + "';";
                ResultSet rs2 = obj.stm.executeQuery(query);
                // group the rides which have less than 30 minutes difference in time together
                // max 4 people in a group
                // put the grouped rides in the propsed table
                HashMap<String, Integer> hm = new HashMap<String, Integer>();
                while (rs2.next()) {
                    hm.put(rs2.getString("BITSID"), Integer.parseInt(rs2.getString("time").substring(0, 2)) * 60
                            + Integer.parseInt(rs2.getString("time").substring(2, 4)));
                }
                // sort the hashmap
                TreeMap<String, Integer> tm = new TreeMap<String, Integer>(hm);

                // print the sorted hashmap
                for (Map.Entry<String, Integer> en : tm.entrySet()) {
                    System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
