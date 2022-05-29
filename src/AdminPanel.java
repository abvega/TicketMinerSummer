import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminPanel {
    private final EventList events = EventList.getInstance();

    public AdminPanel() {
        String loop;
        Scanner in = new Scanner(System.in);
        int input;
        int inputAd;
        do {
            try {
                System.out.println("What would you like to do? Press 1 to create a new event, 2 to inquire an event or 3 modify an event or 4 to exit.");
                input = Integer.parseInt(in.nextLine());
                switch (input) {
                    case 1:
                        events.createEvent();
                        break;
                    case 2:
                        System.out.println("What is the ID of the event you want to lookup? ");
                        inputAd = Integer.parseInt(in.nextLine());
                        System.out.println(events.getEvent(inputAd));
                        break;
                    case 3:
                        do {
                            inputAd = 0;
                            try {
                                System.out.println("What is the ID of the event you want to modify?");
                                inputAd = Integer.parseInt(in.nextLine());
                            }catch(InputMismatchException i){
                                System.out.println("Message "+ i);

                            }catch(NumberFormatException n){
                                System.out.println("Message "+ n);
                                System.out.println("ID numbers don't have letters");
                            }
                        }while(events.getEvent(inputAd) == null);
                        events.modifyEvent(inputAd);
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
