package TicketMiner.Event;

import java.math.BigDecimal;
/**
 * Event class lays blueprint for event objects to be used with TicketMiner. Contains functionality to manipulate
 * Venue objects without referencing venue object directly.
 * @author alexvega
 */

public class Event {
    private int id;
    private String type;
    private String name;
    private String date;
    private String time;
    private BigDecimal vipPrc;
    private BigDecimal gldPrc;
    private BigDecimal slvrPrc;
    private BigDecimal brnzPrc;
    private BigDecimal gaPrc;
    private int vipQuant = 0;
    private int goldQuant = 0;
    private int slvrQuant = 0;
    private int brnzQuant = 0;
    private int gaQuant = 0;
    private Venue venue;
    private boolean fWorks;
    private int fWorkCost;

    public Event(){}

    public Event(String type, String name, String date, String time, BigDecimal vipPrc, BigDecimal gldPrc, BigDecimal slvrPrc, BigDecimal brnzPrc, BigDecimal gaPrc, Venue venue, boolean fWorks, int fWorkCost) {
        this.type = type;
        this.name = name;
        this.date = date;
        this.time = time;
        this.vipPrc = vipPrc;
        this.gldPrc = gldPrc;
        this.slvrPrc = slvrPrc;
        this.brnzPrc = brnzPrc;
        this.gaPrc = gaPrc;
        this.venue = venue;
        this.fWorks = fWorks;
        this.fWorkCost = fWorkCost;
    }

    public int getID() {return id;}
    public String getType() {return type;}
    public String getName() {return name;}
    public String getDate() {return date;}
    public String getTime() {return time;}
    public BigDecimal getVipPrc() {return vipPrc;}
    public BigDecimal getGldPrc() {return gldPrc;}
    public BigDecimal getSlvrPrc() {return slvrPrc;}
    public BigDecimal getBrnzPrc() {return brnzPrc;}
    public BigDecimal getGaPrc() {return gaPrc;}
    public int getVipQuant() {return vipQuant;}
    public int getGoldQuant() {return goldQuant;}
    public int getSlvrQuant() {return slvrQuant;}
    public int getBrnzQuant() {return brnzQuant;}
    public int getGaQuant() {return gaQuant;}
    public Venue getVenue() {return venue;}
    public boolean getFireworks() {return fWorks;}
    public int getfWorkCost() {return fWorkCost;}
    public String getVenueName(){return this.venue.getName();}
    public String getVenueType(){return this.venue.getVenType();}
    public int getCapacity(){return this.venue.getCapacity();}
    public int getVenCost(){return this.venue.getVenCost();}
    public int getVIPSeatRem(){return this.venue.getVIPSeatRem();}
    public int getGoldSeatRem(){return this.venue.getGoldSeatRem();}
    public int getSlvrSeatRem(){return this.venue.getSlvrSeatRem();}
    public int getBrnzSeatRem(){return this.venue.getBrnzSeatRem();}
    public int getGaSeatRem(){return this.venue.getGaSeatRem();}
    public int getTotalSeatsRem(){return (getCapacity() - (getTotalSeatSold()));}
    public int getExRsrvRem(){return this.venue.getExRsrvRem();}
    public int getVipPct(){return this.venue.getVipSeat();}
    public int getGoldPct(){return this.venue.getGoldSeat();}
    public int getSlvrPct(){return this.venue.getSlvrSeat();}
    public int getBrnzPct(){return this.venue.getBrnzSeat();}
    public int getGaPct(){return this.venue.getGaSeat();}
    public int getExtPct(){return this.venue.getExRsrv();}
    public int getUnavail(){return this.venue.getUnavail();}
    public BigDecimal getRevenue(){
        return ((vipPrc.multiply(BigDecimal.valueOf(vipQuant)))
                .add(gldPrc.multiply(BigDecimal.valueOf(goldQuant)))
                .add(slvrPrc.multiply(BigDecimal.valueOf(slvrQuant)))
                .add(brnzPrc.multiply(BigDecimal.valueOf(brnzQuant)))
                .add(gaPrc.multiply(BigDecimal.valueOf(gaQuant))));
    }
    public BigDecimal getProfit(){
        return getRevenue().subtract(BigDecimal.valueOf(getVenCost()).add(BigDecimal.valueOf(fWorkCost)));
    }
    public int getTotalSeatSold(){
        return ((vipQuant+goldQuant+slvrQuant+brnzQuant+gaQuant));
    }
    public int getSeatsLeft(){
        return (getCapacity() - getTotalSeatSold());
    }
    public void setVipPrc(BigDecimal vipPrc) {
        if(vipPrc.compareTo(BigDecimal.valueOf(0))<0){
            throw new IllegalArgumentException("VIP price cant be negative");
        }
        this.vipPrc = vipPrc;}
    public void setGldPrc(BigDecimal gldPrc) {this.gldPrc = gldPrc;}
    public void setSlvrPrc(BigDecimal slvrPrc) {this.slvrPrc = slvrPrc;}
    public void setBrnzPrc(BigDecimal brnzPrc) {this.brnzPrc = brnzPrc;}
    public void setGaPrc(BigDecimal gaPrc) {this.gaPrc = gaPrc;}
    public void setiD(int iD) {this.id = iD;}
    public void setType(String type) {this.type = type;}
    public void setName(String name) {this.name = name;}
    public void setDate(String date) {this.date = date;}
    public void setTime(String time) {this.time = time;}
    public void setVipQuant(int vipQuant) {this.vipQuant = this.vipQuant + vipQuant;}
    public void setGoldQuant(int goldQuant) {this.goldQuant = this.goldQuant + goldQuant;}
    public void setSlvrQuant(int slvrQuant) {this.slvrQuant = this.slvrQuant + slvrQuant;}
    public void setBrnzQuant(int brnzQuant) {this.brnzQuant = this.brnzQuant + brnzQuant;}
    public void setGaQuant(int gaQuant) {this.gaQuant = this.gaQuant + gaQuant;}
    public void setVenue(Venue venue) {this.venue = venue;}
    public void setVenueName(String name){this.venue.setName(name);}
    public void setVenueType(String type){this.venue.setVenType(type);}
    public void setVenueCapacity(int capacity){this.venue.setCapacity(capacity);}
    public void setVenueCost(int venCost){this.venue.setVenCost(venCost);}
    public void setVIPSeatRem(int seats){this.venue.setVipSeatRem(seats);}
    public void setGoldSeatRem(int seats){this.venue.setGoldSeatRem(seats);}
    public void setSlvrSeatRem(int seats){this.venue.setSlvrSeatRem(seats);}
    public void setBrnzSeatRem(int seats){this.venue.setBrnzSeatRem(seats);}
    public void setGaSeatRem(int seats){this.venue.setGaSeatRem(seats);}
    public void setExRsrvRem(int seats){this.venue.setExRsrvRem(seats);}
    public void setVIPSeatPct(int pct){this.venue.setVipSeatPct(pct);}
    public void setGldSeatPct(int pct){this.venue.setGldSeatPct(pct);}
    public void setSlvrSeatPct(int pct){this.venue.setSlvrSeatPct(pct);}
    public void setBrnzSeatPct(int pct){this.venue.setBrnzSeatPct(pct);}
    public void setGaSeatPct(int pct){this.venue.setGaSeatPct(pct);}
    public void setExRsrvPct(int pct){this.venue.setExRsrvPct(pct);}
    public void setUnavail(int pct){this.venue.setUnavailPct(pct);}
    public void setfWorks(boolean fWorks) {this.fWorks = fWorks;}
    public void setfWorkCost(int fWorkCost) {this.fWorkCost = fWorkCost;}
    public String toString(){
        return "Event ID "+getID()+"\n"
                +"Event Name "+getName()+"\n"
                +"Date "+getDate()+"\n"
                +"Time "+getTime()+"\n"
                +"Fireworks "+getFireworks()+"\n"
                +"VIP Seat Pct" +getVipPct();
    }
}
