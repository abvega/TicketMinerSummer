package TicketMiner.Event;

public class Venue {
    private String name;
    private int capacity = 0;
    private int vipSeat = 0;
    private int goldSeat = 0;
    private int slvrSeat = 0;
    private int brnzSeat = 0;
    private int gaSeat = 0;
    private int exRsrv = 0;
    private int venCost = 0;
    private int vipSeatRem = 0;
    private int goldSeatRem = 0;
    private int slvrSeatRem = 0;
    private int brnzSeatRem = 0;
    private int gaSeatRem = 0;
    private int exRsrvRem = 0;


    public Venue(String name, int capacity, int vipSeat, int goldSeat, int slvrSeat, int brnzSeat, int gaSeat, int exRsrv, int venCost) {
        this.name = name;
        this.capacity = capacity;
        this.vipSeat = vipSeat;
        this.goldSeat = goldSeat;
        this.slvrSeat = slvrSeat;
        this.brnzSeat = brnzSeat;
        this.gaSeat = gaSeat;
        this.exRsrv = exRsrv;
        this.venCost = venCost;
        this.vipSeatRem = ((vipSeat/100)*capacity);
        this.goldSeatRem = ((goldSeat/100)*capacity);
        this.slvrSeatRem = ((slvrSeat/100)*capacity);
        this.brnzSeatRem = ((brnzSeat/100)*capacity);
        this.gaSeatRem = ((gaSeat/100)*capacity);
        this.exRsrvRem = ((exRsrv/100)*capacity);
    }
    public Venue(){}

    public String getName(){return name;}
    public int getCapacity() {return capacity;}
    public int getVIPSeatRem() {return vipSeatRem;}
    public int getGoldSeatRem() {return goldSeatRem;}
    public int getSlvrSeatRem() {return slvrSeatRem;}
    public int getBrnzSeatRem() {return brnzSeatRem;}
    public int getGaSeatRem() {return gaSeatRem;}
    public int getExRsrvRem() {return exRsrvRem;}
    public int getVenCost() {return venCost;}
    public void setVenCost(int venCost){this.venCost = venCost;}
    public void setName(String name){this.name = name;}
    public void setCapacity(int capacity){this.capacity = capacity;}
    public void setVipSeatRem(int vipSeatRem) {this.vipSeatRem = getVIPSeatRem() - vipSeatRem;}
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
    public String toString(){
        return  "TicketMiner.TicketMiner.Event.Venue Name " +getName()+"\n"
                +"TicketMiner.TicketMiner.Event.Venue Capacity "+getCapacity()+"\n"
                +"VIP Seats Left "+getVIPSeatRem()+"\n"
                +"Gold Seats Left "+getGoldSeatRem()+"\n"
                +"Silver Seats Left "+getSlvrSeatRem()+"\n"
                +"Bronze Seats Left " +getBrnzSeatRem()+"\n"
                +"Extra Reserved Seats Left "+getExRsrvRem()+"\n"
                +"Genaral Admission Seats Left "+getGaSeatRem()+"\n";
    }
}
