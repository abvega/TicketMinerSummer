import java.util.HashMap;
import java.util.Scanner;

public class EventList {
    private static EventList instance = null;
    private final MakeEvent makeEvent = new MakeEvent();
    private final HashMap<Integer, Event> events = makeEvent.eventFromCSV("EventListPA4FINAL.csv");
    private final Scanner in = new Scanner(System.in);

    public static EventList getInstance() {
        if(instance == null){
            instance = new EventList();
        }
        return instance;
    }

    public Event getEvent(int iD){
        return events.get(iD);
    }
    public void createEvent(){
        Event event = new Event();
        do {
            event.setiD(events.size()+1);
            System.out.println("What is the name of the event you want to create? ");
            String name = in.nextLine();
            event.setName(name);
            System.out.println("What type of event is being held? ");
            event.setType(in.nextLine());
            System.out.println("What is the venue name? ");
            event.setVenueName(in.nextLine());
            System.out.println("What day will the event be on? ");
            event.setDate(in.nextLine());
            System.out.println("What time is the event at?  ");
            event.setTime(in.nextLine());
            System.out.println(event);
            events.put(event.getiD(), event);
            System.out.println(events.size());
            System.out.println("Create new event? Y for yes and N for no. ");
        }while(in.nextLine().equalsIgnoreCase("Y"));
    }
    public void modifyEvent(Event event){
        String loop;
        do {
            System.out.println("""
                    What would you like to change about this event?\s
                    1. Event name\s
                    2. Event date\s
                    3. Event time\s
                    4. Event ticket prices\s
                    5. Venue name\s
                    6. Venue cost\s
                    7. Venue capacity\s
                    8. Seat distributions\s""");
            int input = Integer.parseInt(in.nextLine());
            switch (input) {
                case 1 -> modifyEventName(event);
                case 2 -> modifyEventDate(event);
                case 3 -> modifyEventTime(event);
                case 4 -> modifyEventPrice(event);
                case 5 -> modifyVenueName(event);
                case 6 -> modifyVenueCost(event);
                case 7 -> modifyVenueCap(event);
                case 8 -> modifySeatDiv(event);
                default -> {
                }
            }
            System.out.println("Would you like to keep modifying the same event?");
            loop = in.nextLine();
        }while(loop.equalsIgnoreCase("yes"));
    }
    public void modifyEventName(Event event){
        String name = event.getName();
        System.out.println("What would you like to event name to?");
        event.setName(in.nextLine());
        System.out.println("Event: " + name + " Event name changed to :" +event.getName());
    }
    public void modifyEventPrice(Event event){
        System.out.println("""
                What price level would you like to modify?\s
                1. VIP price\s
                2. Gold price\s
                3. Silver price\s
                4. Bronze price\s
                5. General Admission\s
                6. To exit.\s""");
        int input = Integer.parseInt(in.nextLine());
        switch (input) {
            case 1 -> {
                System.out.println("Please input the new cost for VIP tickets ");
                event.setVipPrc(Double.parseDouble(in.nextLine()));
            }
            case 2 -> {
                System.out.println("Please input the new cost for Gold tickets ");
                event.setGldPrc(Double.parseDouble(in.nextLine()));
            }
            case 3 -> {
                System.out.println("Please input the new cost for Silver tickets ");
                event.setSlvrPrc(Double.parseDouble(in.nextLine()));
            }
            case 4 -> {
                System.out.println("Please input the new cost for Bronze tickets ");
                event.setBrnzPrc(Double.parseDouble(in.nextLine()));
            }
            case 5 -> {
                System.out.println("Please input the new cost for General Admission tickets ");
                event.setGaPrc(Double.parseDouble(in.nextLine()));
            }
            default -> {
            }
        }
    }

    public void modifyEventTime(Event event){
        String time = event.getTime();
        System.out.println("Please input the updated time for this event");
        event.setTime(in.nextLine());
        System.out.println("Event " + event.getName() +" time changed from " + time + " to "+event.getTime());
    }
    public void modifyEventDate(Event event){
        String date = event.getDate();
        System.out.println("Please input the new date for this event");
        event.setDate(in.nextLine());
        System.out.println("Event "+ event.getName() + " date changed from " + date + " to "+ event.getDate());
    }
    public void modifyVenueName(Event event){
        String vName = event.getVenueName();
        System.out.println("Please input the new Venue name for this event");
        event.setVenueName(in.nextLine());
        System.out.println("Event " + event.getName() + " venue changed from " + vName +" to "+ event.getVenueName());
    }
    public void modifyVenueCost(Event event){
        int cost = event.getVenCost();
        System.out.println("Please input the new cost for the venue");
        event.setVenueCost(Integer.parseInt(in.nextLine()));
        System.out.println("Venue cost for " + event.getName() + " at "+ event.getVenueName()+ " has been changed to " + event.getVenCost() + " from " + cost);
    }
    public void modifyVenueCap(Event event){
        int cap = event.getCapacity();
        System.out.println("Please input the new capacity for the venue");
        event.setVenueCapacity(Integer.parseInt(in.nextLine()));
        System.out.println("Venue capacity for event " + event.getName() + " has been changed to " + event.getCapacity() + " from " + cap);
    }
    public void modifySeatDiv(Event event){
        int vip;
        int gld;
        int slvr;
        int brnz;
        int extr;
        do {
            System.out.println("What percentage of VIP seats would you like? ");
            vip = Integer.parseInt(in.nextLine());
            System.out.println("What percentage of Gold seats would you like? ");
            gld = Integer.parseInt(in.nextLine());
            System.out.println("What percentage of Silver seats would you like? ");
            slvr = Integer.parseInt(in.nextLine());
            System.out.println("What percentage of Bronze seats would you like? ");
            brnz = Integer.parseInt(in.nextLine());
            System.out.println("What percentage of Extra seats would you like? ");
            extr = Integer.parseInt(in.nextLine());
        }while(pctCheck(vip, gld, slvr, brnz, extr));
        event.setVIPSeatPct(vip);
        event.setGldSeatPct(gld);
        event.setSlvrSeatPct(slvr);
        event.setBrnzSeatPct(brnz);
        event.setExRsrvPct(extr);
        event.setGaSeatPct(gaQuant(vip, gld, slvr, brnz, extr));
    }
    public boolean pctCheck(int vip, int gld, int slvr, int brnz, int extr){
        int ga = 100 - (vip+gld+slvr+brnz+extr);
        return ((vip+gld+slvr+brnz+extr) >= 100 || ga >= 100);
    }
    public int gaQuant(int vip, int gld, int slvr, int brnz, int extr){
        return 100 - (vip+gld+slvr+brnz+extr);
    }
    public int size(){
        return events.size();
    }
    public void sellVip(Event event, int quant){
        event.setVipQuant(quant);
    }
    public void sellGld(Event event, int quant){
        event.setGoldQuant(quant);
    }
    public void sellSlvr(Event event, int quant){
        event.setSlvrQuant(quant);
    }
    public void sellBrnz(Event event, int quant){
        event.setBrnzQuant(quant);
    }
    public void sellGa(Event event, int quant){
        event.setGaQuant(quant);
    }
}
