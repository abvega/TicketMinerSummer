package TicketMiner.Dao;

import TicketMiner.User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    static Connection con = SQLConnection.getConnection();
    public void add(User user) throws SQLException {
        String query = "INSERT INTO users(Username,Password,Money_Available,First_Name," +
                "Last_Name,Tickets_Purchased,TicketMiner_Membership) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassWord());
        ps.setBigDecimal(3, user.getMoneyTotal());
        ps.setString(4, user.getFirstName());
        ps.setString(5, user.getLastName());
        ps.setInt(6, user.getTixBought());
        ps.setBoolean(7, user.getIsMember());
        ps.executeUpdate();
    }
    public void delete(int id) throws SQLException {
        String query = "delete from users where ID =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public User getUser(String userName) throws SQLException {
        String query = "select * from users where Username =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, userName);
        User user = new User();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while(rs.next()){
            check = true;
            user.setID(rs.getInt("ID"));
            user.setUserName(rs.getString("Username"));
            user.setPassWord(rs.getString("Password"));
            user.setMoney(rs.getBigDecimal("Money_Available"));
            user.setFirstName(rs.getString("First_Name"));
            user.setLastName(rs.getString("Last_Name"));
            user.setTixBought(rs.getInt("Tickets_Purchased"));
            user.setMember(rs.getBoolean("TicketMiner_Membership"));
        }
        if(check){
            return user;
        }
        else{
            return null;
        }
    }
    public ArrayList<User> getUsers() throws SQLException {
        String query = "select * from users";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while(rs.next()){
            User user = new User();
            user.setID(rs.getInt("ID"));
            user.setUserName(rs.getString("Username"));
            user.setPassWord(rs.getString("Password"));
            user.setMoney(rs.getBigDecimal("Money_Available"));
            user.setFirstName(rs.getString("First_Name"));
            user.setLastName(rs.getString("Last_Name"));
            user.setTixBought(rs.getInt("Tickets_Purchased"));
            user.setMember(rs.getBoolean("TicketMiner_Membership"));
            users.add(user);
        }
        return users;
    }
    public void update(User user) throws SQLException {
        String query = "update users set  Username = ? , Password = ?," +
                "Money_Available =?, First_Name =?, Last_Name =?, Tickets_Purchased =?," +
                "TicketMiner_Membership =? where ID =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassWord());
        ps.setBigDecimal(3, user.getMoneyTotal());
        ps.setString(4, user.getFirstName());
        ps.setString(5, user.getLastName());
        ps.setInt(6, user.getTixBought());
        ps.setBoolean(7, user.getIsMember());
        ps.setInt(8, user.getID());
        ps.executeUpdate();
    }
    public boolean authenticate(String userName, String password) throws SQLException {
        if(getUser(userName)==null){
            return false;
        }
        return getUser(userName).getPassWord().equals(password);
    }
}
