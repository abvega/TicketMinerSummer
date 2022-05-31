import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminPanel {
    public AdminPanel() {
        EventList events = EventList.getInstance();
        String loop;
        Scanner in = new Scanner(System.in);
        int input;
        Event eventAd = null;
        do {
            try {
                System.out.println("""
                        What would you like to do? Press\s
                        1. To create a new event\s
                        2. To inquire an event\s
                        3. To modify an event\s
                        4. To exit.""");
                input = Integer.parseInt(in.nextLine());
                switch (input) {
                    case 1:
                        events.createEvent();
                        break;
                    case 2:
                        System.out.println("What is the ID of the event you want to lookup? ");
                        System.out.println(events.getEvent(Integer.parseInt(in.nextLine())));
                        break;
                    case 3:
                        do {
                            try {
                                System.out.println("What is the ID of the event you want to modify?");
                                eventAd = events.getEvent(Integer.parseInt(in.nextLine()));
                            }catch(InputMismatchException i){
                                System.out.println("Message "+ i);

                            }catch(NumberFormatException n){
                                System.out.println("Message "+ n);
                                System.out.println("ID numbers don't have letters");
                            }
                        }while(eventAd == null);
                        events.modifyEvent(eventAd);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Please check inputs and try again");
                }
            } catch (NumberFormatException i) {
                System.out.println("Please use the provided options");
            }
            System.out.println("Would you like to go back to the Admin menu?");
            loop = in.nextLine();
        }while(loop.equalsIgnoreCase("yes"));
    }
}
