import TicketMiner.Event.Event;
import TicketMiner.Event.Venue;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class EventTest {
    Event event = new Event();
    Venue venue = new Venue();
    @Test
    public void setVipPrc() {
        try {
            event.setVipPrc(new BigDecimal(100));
            assertEquals(BigDecimal.valueOf(100), event.getVipPrc());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @Test
    public void setGldPrc() {
        try{
            event.setGldPrc(new BigDecimal(100));
            assertEquals(BigDecimal.valueOf(100), event.getGldPrc());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @Test
    public void setSlvrPrc() {
        try {
            event.setSlvrPrc(new BigDecimal(100));
            assertEquals(BigDecimal.valueOf(100), event.getSlvrPrc());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Test
    public void setBrnzPrc() {
        try {
            event.setBrnzPrc(new BigDecimal(100));
            assertEquals(BigDecimal.valueOf(100), event.getBrnzPrc());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Test
    public void setGaPrc() {
        try{
            event.setGaPrc(new BigDecimal(100));
            assertEquals(BigDecimal.valueOf(100), event.getGaPrc());
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Test
    public void setiD() {
        event.setiD(10);
        assertEquals(10, event.getID());
    }

    @Test
    public void setType() {
        event.setType("Concert");
        assertEquals("Concert", event.getType());
    }

    @Test
    public void setName() {
        event.setName("Java Live");
        assertEquals("Java Live", event.getName());
    }

    @Test
    public void setDate() {
        event.setDate("3/20/2022");
        assertEquals("3/20/2022", event.getDate());
    }

    @Test
    public void setTime() {
        event.setTime("1:00 PM");
        assertEquals("1:00 PM", event.getTime());
    }

    @Test
    public void setVipQuant() {
        event.setVipQuant(50);
        assertEquals(50, event.getVipQuant());
    }

    @Test
    public void setGoldQuant() {
        event.setGoldQuant(50);
        assertEquals(50, event.getGoldQuant());
    }

    @Test
    public void setSlvrQuant() {
        event.setSlvrQuant(50);
        assertEquals(50, event.getSlvrQuant());
    }

    @Test
    public void setBrnzQuant() {
        event.setBrnzQuant(50);
        assertEquals(50, event.getBrnzQuant());
    }

    @Test
    public void setGaQuant() {
        event.setGaQuant(100);
        assertEquals(100, event.getGaQuant());
    }

    @Test
    public void setVenue() {
        event.setVenue(venue);
        assertNotNull(event.getVenue());
    }

    @Test
    public void setVenueName() {
        event.setVenue(venue);
        event.setVenueName("Spongebob's house");
        assertEquals("Spongebob's house", event.getVenueName());
    }

    @Test
    public void setVenueType() {
        venue.setVenType("Stadium");
        event.setVenue(venue);
        assertEquals("Stadium", event.getVenueType());
    }

    @Test
    public void setVenueCapacity() {
        venue.setCapacity(10000);
        event.setVenue(venue);
        assertEquals(10000, event.getCapacity());
    }

    @Test
    public void setVenueCost() {
        venue.setVenCost(10000);
        event.setVenue(venue);
        assertEquals(10000, event.getVenCost());
    }

    @Test
    public void setVIPSeatRem() {
        venue.setVipSeatPct(10);
        venue.setCapacity(100);
        event.setVenue(venue);
        assertEquals(10, event.getVIPSeatRem());
    }

    @Test
    public void setGoldSeatRem() {
    }

    @Test
    public void setSlvrSeatRem() {
    }

    @Test
    public void setBrnzSeatRem() {
    }

    @Test
    public void setGaSeatRem() {
    }

    @Test
    public void setExRsrvRem() {
    }

    @Test
    public void setVIPSeatPct() {
    }

    @Test
    public void setGldSeatPct() {
    }

    @Test
    public void setSlvrSeatPct() {
    }

    @Test
    public void setBrnzSeatPct() {
    }

    @Test
    public void setGaSeatPct() {
    }

    @Test
    public void setExRsrvPct() {
    }

    @Test
    public void setUnavail() {
    }

    @Test
    public void setfWorks() {
    }

    @Test
    public void setfWorkCost() {
    }
}