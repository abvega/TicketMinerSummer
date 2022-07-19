package TicketMiner.Event;

import java.math.BigDecimal;

public class VenueSm {
    private int id;
    private String name;
    private String type;
    private int capacity;
    private int concertCap;
    private int cost;
    private int vipPct;
    private int gldPct;
    private int slvrPct;
    private int brnzPct;
    private int gaPct;
    private int exRsrv;

    public VenueSm(int id, String name, String type, int capacity, int concertCap, int cost, int vipPct, int gldPct, int slvrPct, int brnzPct, int gaPct, int exRsrv) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.concertCap = concertCap;
        this.cost = cost;
        this.vipPct = vipPct;
        this.gldPct = gldPct;
        this.slvrPct = slvrPct;
        this.brnzPct = brnzPct;
        this.gaPct = gaPct;
        this.exRsrv = exRsrv;
    }

    public VenueSm() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getConcertCap() {
        return concertCap;
    }

    public int getCost() {
        return cost;
    }

    public int getVipPct() {
        return vipPct;
    }

    public int getGldPct() {
        return gldPct;
    }

    public int getSlvrPct() {
        return slvrPct;
    }

    public int getBrnzPct() {
        return brnzPct;
    }

    public int getGaPct() {
        return gaPct;
    }

    public int getExRsrv() {
        return exRsrv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setConcertCap(int concertCap) {
        this.concertCap = concertCap;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setVipPct(int vipPct) {
        this.vipPct = vipPct;
    }

    public void setGldPct(int gldPct) {
        this.gldPct = gldPct;
    }

    public void setSlvrPct(int slvrPct) {
        this.slvrPct = slvrPct;
    }

    public void setBrnzPct(int brnzPct) {
        this.brnzPct = brnzPct;
    }

    public void setGaPct(int gaPct) {
        this.gaPct = gaPct;
    }

    public void setExRsrv(int exRsrv) {
        this.exRsrv = exRsrv;
    }
    public String toCbox(){
        return getName();
    }
}
