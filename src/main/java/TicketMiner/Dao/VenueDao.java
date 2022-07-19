package TicketMiner.Dao;

import TicketMiner.Event.VenueSm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VenueDao {
    static Connection con = SQLConnection.getConnection();
    public void add(VenueSm venue) throws SQLException {
        String query = "insert into venues(Name, Type, Capacity, Concert_Capacity, Cost, VIP_Pct, Gold_Pct, Silver_Pct, Bronze_Pct," +
                "General_Admission_Pct, Reserved_Extra_Pct)VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, venue.getName());
        ps.setString(2, venue.getType());
        ps.setInt(3, venue.getCapacity());
        ps.setInt(4, venue.getConcertCap());
        ps.setInt(5, venue.getCost());
        ps.setInt(6, venue.getVipPct());
        ps.setInt(7, venue.getGldPct());
        ps.setInt(8, venue.getSlvrPct());
        ps.setInt(9, venue.getBrnzPct());
        ps.setInt(10, venue.getGaPct());
        ps.executeUpdate();
    }
    public void delete(int id) throws SQLException {
        String query = "delete from venues where ID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
    public VenueSm getVenue(int id) throws SQLException {
        String query ="select * from venues where ID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        VenueSm venue = new VenueSm();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while(rs.next()){
            check=true;
            venue.setId(rs.getInt("ID"));
            venue.setName(rs.getString("Name"));
            venue.setType(rs.getString("Type"));
            venue.setCapacity(rs.getInt("Capacity"));
            venue.setConcertCap(rs.getInt("Concert_Capacity"));
            venue.setCost(rs.getInt("Cost"));
            venue.setVipPct(rs.getInt("VIP_Pct"));
            venue.setGldPct(rs.getInt("Gold_Pct"));
            venue.setSlvrPct(rs.getInt("Silver_Pct"));
            venue.setBrnzPct(rs.getInt("Bronze_Pct"));
            venue.setGaPct(rs.getInt("General_Admission_Pct"));
            venue.setExRsrv(rs.getInt("Reserved_Extra_Pct"));
        }
        if(check){
            return venue;
        }else {
            return null;
        }
    }
    public ArrayList<VenueSm> getVenues() throws SQLException {
        String query = "select * from venues";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<VenueSm> venues = new ArrayList<>();
        while(rs.next()){
            VenueSm venue = new VenueSm();
            venue.setId(rs.getInt("ID"));
            venue.setName(rs.getString("Name"));
            venue.setType(rs.getString("Type"));
            venue.setCapacity(rs.getInt("Capacity"));
            venue.setConcertCap(rs.getInt("Concert_Capacity"));
            venue.setCost(rs.getInt("Cost"));
            venue.setVipPct(rs.getInt("VIP_Pct"));
            venue.setGldPct(rs.getInt("Gold_Pct"));
            venue.setSlvrPct(rs.getInt("Silver_Pct"));
            venue.setBrnzPct(rs.getInt("Bronze_Pct"));
            venue.setGaPct(rs.getInt("General_Admission_Pct"));
            venue.setExRsrv(rs.getInt("Reserved_Extra_Pct"));
            venues.add(venue);
        }
        return venues;
    }
    public void update(VenueSm venue) throws SQLException {
        String query = "update venues set Name = ?, Capacity =?, Concert_Capacity = ?, Cost =?, VIP_Pct =?," +
                "Gold_Pct=?, Silver_Pct=?, Bronze_Pct=?, General_Admission_Pct= ?, Reserved_Extra_Pct =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, venue.getName());
        ps.setString(2, venue.getType());
        ps.setInt(3, venue.getCapacity());
        ps.setInt(4, venue.getConcertCap());
        ps.setInt(5, venue.getCost());
        ps.setInt(6, venue.getVipPct());
        ps.setInt(7, venue.getGldPct());
        ps.setInt(8, venue.getSlvrPct());
        ps.setInt(9, venue.getBrnzPct());
        ps.setInt(10, venue.getExRsrv());
        ps.executeUpdate();
    }
}
