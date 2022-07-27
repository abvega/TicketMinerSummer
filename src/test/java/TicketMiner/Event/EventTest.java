package TicketMiner.Event;

import TicketMiner.Dao.EventDaoImplementation;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class EventTest {

    Event event;
    Venue venue;
    @BeforeEach
    public void start(){
        event = new Event();
        venue = new Venue();
    }
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
    public void getVIPSeatRem() throws SQLException {
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(59);
        assertEquals(700, event.getVIPSeatRem());
    }

    @Test
    public void getGoldSeatRem() throws SQLException {
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(59);
        assertEquals(1400, event.getGoldSeatRem());
    }

    @Test
    public void getSlvrSeatRem() throws SQLException{
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(59);
        assertEquals(2100, event.getSlvrSeatRem());
    }

    @Test
    public void getBrnzSeatRem() throws SQLException {
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(59);
        assertEquals(2800, event.getBrnzSeatRem());
    }

    @Test
    public void getGaSeatRem() throws SQLException{
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(59);
        assertEquals(6300, event.getGaSeatRem());
    }
    @Test
    public void getExRsrvRem() throws SQLException {
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(59);
        assertEquals(700, event.getExRsrvRem());
    }

    @Test
    public void setVIPSeatPct() {
        event.setVenue(venue);
        event.setVIPSeatPct(10);
        assertEquals(10,event.getVipPct());
    }

    @Test
    public void setGldSeatPct() {
        event.setVenue(venue);
        event.setGldSeatPct(10);
        assertEquals(10, event.getGoldPct());
    }

    @Test
    public void setSlvrSeatPct() {
        event.setVenue(venue);
        event.setSlvrSeatPct(10);
        assertEquals(10,event.getSlvrPct());
    }

    @Test
    public void setBrnzSeatPct() {
        event.setVenue(venue);
        event.setBrnzSeatPct(24);
        assertEquals(24, event.getBrnzPct());
    }

    @Test
    public void setGaSeatPct() {
        event.setVenue(venue);
        event.setGaSeatPct(37);
        assertEquals(37, event.getGaPct());
    }

    @Test
    public void setExRsrvPct() {
        event.setVenue(venue);
        event.setExRsrvPct(18);
        assertEquals(18, event.getExtPct());
    }

    @Test
    public void setUnavail() {
        event.setVenue(venue);
        event.setUnavail(61);
        assertEquals(61, event.getUnavail());
    }

    @Test
    public void setfWorks() {
        event.setVenue(venue);
        event.setfWorks(false);
        assertFalse(event.getFireworks());
    }

    @Test
    public void setfWorkCost() {
        event.setfWorkCost(1000);
        assertEquals(1000,event.getfWorkCost());
    }
    @Test
    public void getRevenueTest() throws SQLException{
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(13);
        event.setVipQuant(10);
        event.setGoldQuant(10);
        event.setSlvrQuant(10);
        event.setBrnzQuant(10);
        event.setGaQuant(10);
        assertNotEquals(new BigDecimal("0.00"),event.getRevenue());
    }
    @Test
    public void getRevenueTotal() throws SQLException{
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(13);
        event.setVipQuant(10);
        event.setGoldQuant(10);
        event.setSlvrQuant(10);
        event.setBrnzQuant(10);
        event.setGaQuant(10);
        assertEquals(new BigDecimal("1386.00"), event.getRevenue());
    }
    @Test
    public void getProfitTest() throws SQLException{
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(13);
        event.setVipQuant(10);
        event.setGoldQuant(10);
        event.setSlvrQuant(10);
        event.setBrnzQuant(10);
        event.setGaQuant(10);
        assertNotEquals(new BigDecimal("0.00"), event.getProfit());
    }
    @Test
    public void getProfitTotal() throws SQLException{
        EventDaoImplementation dao = new EventDaoImplementation();
        event = dao.getEvent(13);
        event.setVipQuant(2900);
        event.setGoldQuant(5800);
        event.setSlvrQuant(8700);
        event.setBrnzQuant(11600);
        event.setGaQuant(26100);
        assertEquals(new BigDecimal("571300.00"), event.getProfit());
    }
}