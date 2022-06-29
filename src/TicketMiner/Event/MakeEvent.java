package TicketMiner.Event;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MakeEvent {
    public ArrayList <Event> eventFromCSV(String fileName){
        ArrayList<Event> events = new ArrayList<>();
        try(Scanner br = new Scanner((new File(fileName)))){
            String headLine = br.nextLine();
            String line = br.nextLine();
            while(br.hasNextLine()){
                String[] values = line.split(",");
                Event event = makeEvent(setArrangeInfo(headLine.split(","),values));
                events.add(event);
                line = br.nextLine();
            }
        }catch(FileNotFoundException f){
            System.out.println("TicketMiner.TicketMiner.Event.Event file not found " + f);
        }
        return events;
    }
    public String[] setArrangeInfo(String[] headLine, String[] data){
        String[] tempD = new String[headLine.length];
        for(int i =0; i < headLine.length; i++){
            if(headLine[i].equalsIgnoreCase("TicketMiner.TicketMiner.Event.Event ID")){
                tempD[0] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("TicketMiner.TicketMiner.Event.Event Type")){
                tempD[1] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Name")){
                tempD[2] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Date")){
                tempD[3] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Time")){
                tempD[4] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Vip Price")){
                tempD[5] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Gold Price")){
                tempD[6] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Silver Price")){
                tempD[7] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Bronze Price")){
                tempD[8] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("General Admission Price")){
                tempD[9] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("TicketMiner.TicketMiner.Event.Venue Name")){
                tempD[10] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Pct Seats Unavailable")){
                tempD[11] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("TicketMiner.TicketMiner.Event.Venue Type")){
                tempD[12] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Capacity")){
                tempD[13] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Cost")){
                tempD[14] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Vip Pct")){
                tempD[15] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Gold Pct")){
                tempD[16] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Silver Pct")){
                tempD[17] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Bronze Pct")){
                tempD[18] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("General Admission Pct")){
                tempD[19] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Reserved Extra Pct")){
                tempD[20] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Fireworks Planned")){
                tempD[21] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Fireworks Cost")){
                if(data.length<headLine.length){
                    tempD[22] = "0.00";
                }
                else{tempD[22] = data[i];}
            }
        }
        return tempD;
    }
    public Event makeEvent(String[] data){
        Venue myVenue;
        int iD = Integer.parseInt(data[0]);
        String eventType = data[1];
        String eventName = data[2];
        String date = data[3];
        String time = data[4];
        double vipPrc = Double.parseDouble(data[5]);
        double goldPrc = Double.parseDouble(data[6]);
        double slvrPrc = Double.parseDouble(data[7]);
        double brnzPrc = Double.parseDouble(data[8]);
        double gaPrc = Double.parseDouble(data[9]);
        String venueName = data[10];
        int pctUnav = Integer.parseInt(data[11]);
        String venueType = data[12];
        int capacity = Integer.parseInt(data[13]);
        int venueCost = Integer.parseInt(data[14]);
        int vipPct = Integer.parseInt(data[15]);
        int goldPct = Integer.parseInt(data[16]);
        int slvrPct = Integer.parseInt(data[17]);
        int brnzPct = Integer.parseInt(data[18]);
        int gapPct = Integer.parseInt(data[19]);
        int rsrvPct = Integer.parseInt(data[20]);
        boolean fWorks = (data[21].equalsIgnoreCase("yes"));
        double fWorksCost = Double.parseDouble(data[22]);
        myVenue = new Venue(venueName, capacity, vipPct, goldPct, slvrPct, brnzPct, gapPct,rsrvPct, venueCost);
        return new Event(iD, eventType, eventName, date, time, vipPrc, goldPrc, slvrPrc, brnzPrc, gaPrc, myVenue, fWorks,fWorksCost);
    }
}