package TicketMiner.Dao;

import TicketMiner.Event.Event;
import TicketMiner.Event.Venue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDaoImplementation implements Dao{
    static Connection con = SQLConnection.getConnection();
    @Override
    public void add(Event event) throws SQLException {
        String query ="INSERT INTO events(Name, Event_Type, Date, Time, Venue_Name, Venue_Type, Capacity, Cost, VIP_Pct, " +
                "Gold_Pct, Silver_Pct, Bronze_Pct, General_Admission_Pct, Reserved_Extra_Pct, Pct_Seats_Unavailable, " +
                "Vip_Price, Gold_Price, Silver_Price, Bronze_Price, General_Admission_Price, Fireworks_Planned, Fireworks_Cost) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? , ?, ? , ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, event.getName());
        ps.setString(2, event.getType());
        ps.setString(3, event.getDate());
        ps.setString(4, event.getTime());
        ps.setString(5, event.getVenueName());
        ps.setString(6, event.getVenueType());
        ps.setInt(7, event.getCapacity());
        ps.setInt(8,event.getVenCost());
        ps.setInt(9, (event.getVipPct()));
        ps.setInt(10, event.getGoldPct());
        ps.setInt(11,event.getSlvrPct());
        ps.setInt(12, event.getBrnzPct());
        ps.setInt(13,event.getGaPct());
        ps.setInt(14, event.getExtPct());
        ps.setInt(15, event.getUnavail());
        ps.setBigDecimal(16, event.getVipPrc());
        ps.setBigDecimal(17, event.getGldPrc());
        ps.setBigDecimal(18, event.getSlvrPrc());
        ps.setBigDecimal(19, event.getBrnzPrc());
        ps.setBigDecimal(20, event.getGaPrc());
        ps.setBoolean(21, event.getFireworks());
        ps.setInt(22, event.getfWorkCost());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from events where Event_ID =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
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
            event.setfWorkCost(rs.getInt("Fireworks_Cost"));
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
            event.setfWorkCost(rs.getInt("Fireworks_Cost"));
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
        String query = "update event set Name = ?, Type = ?, Date = ?, Time = ?, Venue_Name = ?, Venue_Type = ?, Capacity = ?, Cost = ?," +
                "VIP_Pct = ?, Gold_Pct = ?, Silver_Pct = ?, Bronze_Pct = ?, General_Admission_Pct =?, Reserved_Extra_Pct = ?," +
                "Pct_Seats_Unavailable = ?, VIP_Price = ?, Gold_Price, =?, Silver_Price = ?, Bronze_Price = ?, General_Admission_Price =?," +
                "Fireworks_Planned = ?, Fireworks_Cost = ?, Event_ID = ? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, event.getName());
        ps.setString(2, event.getType());
        ps.setString(3, event.getDate());
        ps.setString(4, event.getTime());
        ps.setString(5, event.getVenueName());
        ps.setString(6, event.getVenueType());
        ps.setInt(7, event.getCapacity());
        ps.setInt(8,event.getVenCost());
        ps.setInt(9, event.getVipPct());
        ps.setInt(10, event.getGoldPct());
        ps.setInt(11,event.getSlvrPct());
        ps.setInt(12, event.getBrnzPct());
        ps.setInt(13,event.getGaPct());
        ps.setInt(14, event.getExtPct());
        ps.setInt(15, event.getUnavail());
        ps.setBigDecimal(16, event.getVipPrc());
        ps.setBigDecimal(17, event.getGldPrc());
        ps.setBigDecimal(18, event.getSlvrPrc());
        ps.setBigDecimal(19, event.getBrnzPrc());
        ps.setBigDecimal(20, event.getGaPrc());
        ps.setBoolean(21, event.getFireworks());
        ps.setInt(22, event.getfWorkCost());
        ps.setInt(23, event.getID());
        ps.executeUpdate();
    }
}
