package TicketMiner.Dao;

import TicketMiner.Event.Event;
import TicketMiner.Event.Venue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDaoImplementation implements EventDao{
    static Connection con = SQLConnection.getConnection();
    @Override
    public int add(Event event) throws SQLException {
        String query ="insert into events(Event_Type, Pct_Seats_Unavailable, Gold_Price, General_Admission_Price," +
                "Capacity, Time, Reserved_Extra_Pct, Venue_Type, Data, VIP_Price, General_Admission_Pct, Name, Bronze_Pct" +
                "Cost, Bronze_Price, Fireworks_Cost, Silver_Pct, Silver_Price, Fireworks_Planned, Venue_Name, " +
                "Event_ID, VIP_Pct, Gold_Pct) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, event.getType());
        ps.setInt(2, event.getUnavail());
        ps.setBigDecimal(3, event.getGldPrc());
        ps.setBigDecimal(4, event.getGaPrc());
        ps.setInt(5, event.getCapacity());
        ps.setString(6, event.getTime());
        ps.setInt(7, event.getExtPct());
        ps.setString(8,event.getVenueType());
        ps.setString(9, event.getDate());
        ps.setBigDecimal(10, event.getVipPrc());
        ps.setInt(11,event.getGaPct());
        ps.setString(12, event.getName());
        ps.setInt(13,event.getBrnzPct());
        ps.setInt(14, event.getVenCost());
        ps.setBigDecimal(15, event.getBrnzPrc());
        ps.setDouble(16, event.getfWorkCost());
        ps.setInt(17, event.getSlvrPct());
        ps.setBigDecimal(18, event.getSlvrPrc());
        ps.setBoolean(19, event.getFireworks());
        ps.setString(20, event.getVenueName());
        ps.setInt(21, event.getID());
        ps.setInt(22, event.getVipPct());
        ps.setInt(23, event.getGoldPct());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from events where Event_ID =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
    }

    @Override
    public Event getEvent(int id) throws SQLException {
        String query = " select * from events where Event_ID =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Event event = new Event();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while(rs.next()){
            check = true;
            event.setiD(rs.getInt("Event_ID"));
            event.setName(rs.getString("Name"));
            event.setType(rs.getString("Event_Type"));
            event.setDate(rs.getString("Date"));
            event.setTime(rs.getString("Time"));
            event.setVipPrc(rs.getBigDecimal("VIP_Price"));
            event.setGldPrc(rs.getBigDecimal("Gold_Price"));
            event.setSlvrPrc(rs.getBigDecimal("Silver_Price"));
            event.setBrnzPrc(rs.getBigDecimal("Bronze_Price"));
            event.setGaPrc(rs.getBigDecimal("General_Admission_Price"));
            event.setfWorks(rs.getBoolean("Fireworks_Planned"));
            event.setfWorkCost(rs.getDouble("Fireworks_Cost"));
            event.setVenue(new Venue());
            event.setVenueName(rs.getString("Venue_Name"));
            event.setVenueCapacity(rs.getInt("Capacity"));
            event.setVIPSeatPct(rs.getInt("VIP_Pct"));
            event.setGldSeatPct(rs.getInt("Gold_Pct"));
            event.setSlvrSeatPct(rs.getInt("Silver_Pct"));
            event.setBrnzSeatPct(rs.getInt("Bronze_Pct"));
            event.setGaSeatPct(rs.getInt("General_Admission_Pct"));
            event.setExRsrvPct(rs.getInt("Reserved_Extra_Pct"));
            event.setVenueCost(rs.getInt("Cost"));
        }
        if (check) {
            return event;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Event> getEvents() throws SQLException {
        String query = "select * from events";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<Event> events = new ArrayList<>();
        while(rs.next()){
            Event event = new Event();
            event.setVenue(new Venue());
            event.setiD(rs.getInt("Event_ID"));
            event.setName(rs.getString("Name"));
            event.setType(rs.getString("Event_Type"));
            event.setDate(rs.getString("Date"));
            event.setTime(rs.getString("Time"));
            event.setVipPrc(rs.getBigDecimal("VIP_Price"));
            event.setGldPrc(rs.getBigDecimal("Gold_Price"));
            event.setSlvrPrc(rs.getBigDecimal("Silver_Price"));
            event.setBrnzPrc(rs.getBigDecimal("Bronze_Price"));
            event.setGaPrc(rs.getBigDecimal("General_Admission_Price"));
            event.setfWorks(rs.getBoolean("Fireworks_Planned"));
            event.setfWorkCost(rs.getDouble("Fireworks_Cost"));
            event.setVenueName(rs.getString("Venue_Name"));
            event.setVenueCapacity(rs.getInt("Capacity"));
            event.setVIPSeatPct(rs.getInt("VIP_Pct"));
            event.setGldSeatPct(rs.getInt("Gold_Pct"));
            event.setSlvrSeatPct(rs.getInt("Silver_Pct"));
            event.setBrnzSeatPct(rs.getInt("Bronze_Pct"));
            event.setGaSeatPct(rs.getInt("General_Admission_Pct"));
            event.setExRsrvPct(rs.getInt("Reserved_Extra_Pct"));
            event.setVenueCost(rs.getInt("Cost"));
            events.add(event);
        }
        return events;
    }

    @Override
    public void update(Event event) throws SQLException {
        String query = "update event set Event_Type=?, Pct_Seats_Unavailable=?, Gold_Price=?, General_Admission_Price=?," +
                "Capacity=?, Time=?, Reserved_Extra_Pct=?, Venue_Type=?, Data=?, VIP_Price=?, General_Admission_Pct=?, Name=?, Bronze_Pct=?" +
                "Cost=?, Bronze_Price=?, Fireworks_Cost=?, Silver_Pct=?, Silver_Price=?, Fireworks_Planned=?, Venue_Name=?," +
                "Event_ID=?, VIP_Pct=?, Gold_Pct=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, event.getType());
        ps.setInt(2, event.getUnavail());
        ps.setBigDecimal(3, event.getGldPrc());
        ps.setBigDecimal(4, event.getGaPrc());
        ps.setInt(5, event.getCapacity());
        ps.setString(6, event.getTime());
        ps.setInt(7, event.getExtPct());
        ps.setString(8,event.getVenueType());
        ps.setString(9, event.getDate());
        ps.setBigDecimal(10, event.getVipPrc());
        ps.setInt(11,event.getGaPct());
        ps.setString(12, event.getName());
        ps.setInt(13,event.getBrnzPct());
        ps.setInt(14, event.getVenCost());
        ps.setBigDecimal(15, event.getBrnzPrc());
        ps.setDouble(16, event.getfWorkCost());
        ps.setInt(17, event.getSlvrPct());
        ps.setBigDecimal(18, event.getSlvrPrc());
        ps.setBoolean(19, event.getFireworks());
        ps.setString(20, event.getVenueName());
        ps.setInt(21, event.getID());
        ps.setInt(22, event.getVipPct());
        ps.setInt(23, event.getGoldPct());
        ps.executeUpdate();
    }
}
