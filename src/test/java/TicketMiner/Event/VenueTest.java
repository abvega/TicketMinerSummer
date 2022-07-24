package TicketMiner.Event;

import org.junit.Test;

import static org.junit.Assert.*;

public class VenueTest {
    Venue venue = new Venue();
    @Test
    public void testVIPSeat(){
        assertEquals(10, venue.getCapacity());
    }
}