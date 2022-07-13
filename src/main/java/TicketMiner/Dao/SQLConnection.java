package TicketMiner.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private static Connection con = null;
    static{
        String url = "jdbc:mysql://localhost:3306/TicketMiner_db";
        String user = "root";
        String pass = "TicketMinerSummer";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return con;
    }
}
