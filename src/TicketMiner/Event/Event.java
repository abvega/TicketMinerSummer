package TicketMiner.Event;

import javafx.beans.property.SimpleStringProperty;

public class Event {
    private int ident;
    private String type;
    private SimpleStringProperty name;
    private String date;
    private String time;
    private double vipPrc;
    private double gldPrc;
    private double slvrPrc;
    private double brnzPrc;
    private double gaPrc;
    private int vipQuant = 0;
    private int goldQuant = 0;
    private int slvrQuant = 0;
    private int brnzQuant = 0;
    private int gaQuant = 0;
    private Venue venue;
    private boolean fWorks;
    private double fWorkCost;

    public Event(){}

    public Event(int iD, String type, String name, String date, String time, double vipPrc, double gldPrc, double slvrPrc, double brnzPrc, double gaPrc, Venue venue, boolean fWorks, double fWorkCost) {
        this.ident = iD;
        this.type = type;
        this.name = new SimpleStringProperty(name);
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

    public int getID() {return ident;}
    public String getType() {return type;}
    public String getName() {return name.get();}
    public String getDate() {return date;}
    public String getTime() {return time;}
    public double getVipPrc() {return vipPrc;}
    public double getGldPrc() {return gldPrc;}
    public double getSlvrPrc() {return slvrPrc;}
    public double getBrnzPrc() {return brnzPrc;}
    public double getGaPrc() {return gaPrc;}
    public int getVipQuant() {return vipQuant;}
    public int getGoldQuant() {return goldQuant;}
    public int getSlvrQuant() {return slvrQuant;}
    public int getBrnzQuant() {return brnzQuant;}
    public int getGaQuant() {return gaQuant;}
    public Venue getVenue() {return venue;}
    public boolean getFireworks() {return fWorks;}
    public double getfWorkCost() {return fWorkCost;}
    public String getVenueName(){return this.venue.getName();}
    public int getCapacity(){return this.venue.getCapacity();}
    public int getVenCost(){return this.venue.getVenCost();}
    public int getVIPSeatRem(){return this.venue.getVIPSeatRem();}
    public int getGoldSeatRem(){return this.venue.getGoldSeatRem();}
    public int getSlvrSeatRem(){return this.venue.getSlvrSeatRem();}
    public int getBrnzSeatRem(){return this.venue.getBrnzSeatRem();}
    public int getGaSeatRem(){return this.venue.getGaSeatRem();}
    public int getExRsrvRem(){return this.venue.getExRsrvRem();}

    public void setVipPrc(double vipPrc) {this.vipPrc = vipPrc;}
    public void setGldPrc(double gldPrc) {this.gldPrc = gldPrc;}
    public void setSlvrPrc(double slvrPrc) {this.slvrPrc = slvrPrc;}
    public void setBrnzPrc(double brnzPrc) {this.brnzPrc = brnzPrc;}
    public void setGaPrc(double gaPrc) {this.gaPrc = gaPrc;}
    public void setfWorkCost(double fWorkCost) {this.fWorkCost = fWorkCost;}
    public void setiD(int iD) {this.ident = iD;}
    public void setType(String type) {this.type = type;}
    public void setName(String name) {this.name = new SimpleStringProperty(name);}
    public void setDate(String date) {this.date = date;}
    public void setTime(String time) {this.time = time;}
    public void setVipQuant(int vipQuant) {this.vipQuant = getVipQuant() + vipQuant;}
    public void setGoldQuant(int goldQuant) {this.goldQuant = getGoldQuant() + goldQuant;}
    public void setSlvrQuant(int slvrQuant) {this.slvrQuant = getSlvrQuant() + slvrQuant;}
    public void setBrnzQuant(int brnzQuant) {this.brnzQuant = getBrnzQuant() + brnzQuant;}
    public void setGaQuant(int gaQuant) {this.gaQuant = getGaQuant() + gaQuant;}
    public void setVenue(Venue venue) {this.venue = venue;}
    public void setVenueName(String name){this.venue.setName(name);}
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
    public void setfWorks(boolean fWorks) {this.fWorks = fWorks;}
    public void setfWorkCost(int fWorkCost) {this.fWorkCost = fWorkCost;}
    public String toString(){
        return "TicketMiner.TicketMiner.Event.Event ID "+getID()+"\n"
                +"TicketMiner.TicketMiner.Event.Event Name "+getName()+"\n"
                +"Date "+getDate()+"\n"
                +"Time "+getTime()+"\n"
                +"Fireworks "+getFireworks();
    }
}
