package TicketMiner.Dao;

import TicketMiner.Event.Event;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Dao {
    void add(Event event)
        throws SQLException;
    void delete(int id)
        throws SQLException;
    Event getEvent(int id)
        throws SQLException;
    ArrayList<Event> getEvents()
        throws SQLException;
    void update(Event event)
        throws SQLException;
}
