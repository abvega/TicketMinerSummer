import java.util.ArrayList;
import java.util.Scanner;

public class EventList {
    private static EventList instance = null;
    private final MakeEvent makeEvent = new MakeEvent();
    private final ArrayList<Event> events = makeEvent.eventFromCSV("EventListPA4FINAL.csv");
    private final Scanner in = new Scanner(System.in);

    public static EventList getInstance() {
        if(instance == null){
            instance = new EventList();
        }
        return instance;
    }
    public void add(Event event){
        events.add(event);
    }
    public Event get(int iD){
        return events.get(iD);
    }
    public int size(){
        return events.size();
    }
    public ArrayList<Event> getArrayList(){
        return getInstance().events;
    }
}
