package TicketMiner.Dao;

import java.sql.*;

public class ConnectionTest {

    public ConnectionTest() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicketMiner_db","root","TicketMinerSummer");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from eventlistpa5final");
        while(resultSet.next()){
            System.out.println(resultSet.getString("Event ID"));
        }
    }
}
