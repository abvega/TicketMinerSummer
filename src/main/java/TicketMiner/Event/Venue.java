package TicketMiner.Event;

public class Venue {
    private String name;
    private String venType;
    private int capacity;
    private int vipSeat;
    private int goldSeat;
    private int slvrSeat;
    private int brnzSeat;
    private int gaSeat;
    private int exRsrv;
    private int unavail;
    private int venCost;
    private double vipSeatRem;
    private double goldSeatRem;
    private double slvrSeatRem;
    private double brnzSeatRem;
    private double gaSeatRem;
    private double exRsrvRem;


    public Venue(String name,String venType, int capacity, int vipSeat, int goldSeat, int slvrSeat, int brnzSeat, int gaSeat, int exRsrv,int unavail, int venCost) {
        this.name = name;
        this.venType = venType;
        this.capacity = capacity;
        this.vipSeat = vipSeat;
        this.goldSeat = goldSeat;
        this.slvrSeat = slvrSeat;
        this.brnzSeat = brnzSeat;
        this.gaSeat = gaSeat;
        this.exRsrv = exRsrv;
        this.unavail = unavail;
        this.venCost = venCost;
        this.vipSeatRem = ((vipSeat/100.0)*capacity);
        this.goldSeatRem = ((goldSeat/100.0)*capacity);
        this.slvrSeatRem = ((slvrSeat/100.0)*capacity);
        this.brnzSeatRem = ((brnzSeat/100.0)*capacity);
        this.gaSeatRem = ((gaSeat/100.0)*capacity);
        this.exRsrvRem = ((exRsrv/100.0)*capacity);
    }
    public Venue(){}

    public String getName(){return name;}
    public String getVenType(){return venType;}
    public int getVipSeat(){return vipSeat;}
    public int getGoldSeat(){return goldSeat;}
    public int getSlvrSeat(){return slvrSeat;}
    public int getBrnzSeat(){return brnzSeat;}
    public int getGaSeat(){return gaSeat;}
    public int getExRsrv(){return exRsrv;}
    public int getUnavail(){return unavail;}
    public int getCapacity() {return capacity;}
    public int getVIPSeatRem() {return (int)vipSeatRem;}
    public int getGoldSeatRem() {return (int)goldSeatRem;}
    public int getSlvrSeatRem() {return (int)slvrSeatRem;}
    public int getBrnzSeatRem() {return (int)brnzSeatRem;}
    public int getGaSeatRem() {return (int)gaSeatRem;}
    public int getExRsrvRem() {return (int)exRsrvRem;}
    public int getVenCost() {return venCost;}
    public void setVenCost(int venCost){this.venCost = venCost;}
    public void setName(String name){this.name = name;}
    public void setVenType(String type){this.venType = type;}
    public void setCapacity(int capacity){this.capacity = capacity;}
    public void setVipSeatRem(int vipSeatRem) {this.vipSeatRem = this.vipSeatRem - vipSeatRem;}
    public void setGoldSeatRem(int goldSeatRem) {this.goldSeatRem = getGoldSeatRem() - goldSeatRem;}
    public void setSlvrSeatRem(int slvrSeatRem) {this.slvrSeatRem = getSlvrSeatRem() - slvrSeatRem;}
    public void setBrnzSeatRem(int brnzSeatRem) {this.brnzSeatRem = getBrnzSeatRem() - brnzSeatRem;}
    public void setGaSeatRem(int gaSeatRem) {this.gaSeatRem = getGaSeatRem() - gaSeatRem;}
    public void setExRsrvRem(int exRsrvRem) {this.exRsrvRem = getExRsrvRem() - exRsrvRem;}
    public void setVipSeatPct(int pct){this.vipSeat = pct;}
    public void setGldSeatPct(int pct){this.goldSeat = pct;}
    public void setSlvrSeatPct(int pct){this.slvrSeat = pct;}
    public void setBrnzSeatPct(int pct){this.brnzSeat = pct;}
    public void setGaSeatPct(int pct){this.gaSeat = pct;}
    public void setExRsrvPct(int pct){this.exRsrv = pct;}
    public void setUnavailPct(int pct){this.unavail = pct;}
    public String toString(){
        return  "Venue Name " +getName()+"\n"
                +"Venue Capacity "+capacity+"\n"
                +"VIP Seats Left "+ vipSeatRem +"\n"
                +"Gold Seats Left "+goldSeatRem+"\n"
                +"Silver Seats Left "+slvrSeatRem+"\n"
                +"Bronze Seats Left " +brnzSeatRem+"\n"
                +"Extra Reserved Seats Left "+exRsrvRem+"\n"
                +"Genaral Admission Seats Left "+gaSeatRem+"\n";
    }
}
