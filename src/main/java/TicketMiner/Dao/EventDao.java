package TicketMiner.Dao;

import TicketMiner.Event.Event;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EventDao {
    public int add(Event event)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public Event getEvent(int id)
        throws SQLException;
    public ArrayList<Event> getEvents()
        throws SQLException;
    public void update(Event event)
        throws SQLException;
}
