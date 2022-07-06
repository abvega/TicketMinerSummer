package TicketMiner.Event;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MakeVenueSm {
    public ArrayList<VenueSm> venueFromCSV(String fileName){
        ArrayList<VenueSm> venues = new ArrayList<>();
        try(Scanner sc = new Scanner((new File(fileName)))){
            String headLine = sc.nextLine();
            String line = sc.nextLine();
            while(sc.hasNextLine()){
                String[] values = line.split(",");
                VenueSm venue = makeVenueSm(arrangeInfo(headLine.split(","), values));
                venues.add(venue);
                line = sc.nextLine();
            }
        }catch(IOException i){
            System.out.println("Cannot find venueSm file");
        }
        return venues;
    }
    public String[] arrangeInfo(String[] headLine, String[] data){
        String[] tempD = new String[headLine.length];
        for(int i = 0; i < headLine.length; i++){
            if(headLine[i].equalsIgnoreCase("ID")){
                tempD[0] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Name")){
                tempD[1] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Type")){
                tempD[2] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Capacity")){
                tempD[3] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Concert Capacity")){
                tempD[4] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Cost")){
                tempD[5] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("VIP Pct")){
                tempD[6] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Gold Pct")){
                tempD[7] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Silver Pct")){
                tempD[8] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Bronze Pct")){
                tempD[9] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("General Admission Pct")){
                tempD[10] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Reserved Extra Pct")){
                tempD[11] = data[i];
            }
        }
        return tempD;
    }
    public VenueSm makeVenueSm(String[] data){
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String type = data[2];
        int capacity = Integer.parseInt(data[3]);
        int concertCap = Integer.parseInt(data[4]);
        BigDecimal cost = new BigDecimal(data[5]);
        int vip = Integer.parseInt(data[6]);
        int gld = Integer.parseInt(data[7]);
        int slvr = Integer.parseInt(data[8]);
        int brnz = Integer.parseInt(data[9]);
        int ga = Integer.parseInt(data[10]);
        int xtra = Integer.parseInt(data[11]);
        return new VenueSm(id,name,type,capacity,concertCap,cost,vip,gld,slvr,brnz,ga,xtra);
    }
}
