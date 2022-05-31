import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPanel {
    private final UserList users = UserList.getInstance();
    private final EventList events = EventList.getInstance();
    private final Scanner in = new Scanner(System.in);

    public UserPanel(){
        int input;
        String userN;
        String pass;
        User myUser;
        do{
            System.out.println("Please input your user name");
            userN = in.nextLine();
            System.out.println("Please input your password");
            pass = in.nextLine();
            if(!users.auth(userN,pass)){
                System.out.println("Username doesn't exist or password is incorrect.");
            }
            else{
                myUser = users.getUser(userN);
                break;
            }
        }while(true);
        System.out.println("Welcome " + myUser.getUserName() + "!");
        do {
            try {
                System.out.println("""
                        What would you like to do today?\s
                        1. Buy tickets\s
                        2. Edit profile\s
                        3. Exit\s
                        """);
                input = Integer.parseInt(in.nextLine());
                switch (input) {
                    case 1 -> sellTick(myUser);
                    case 2 -> users.modifyUser(myUser);
                    case 3 -> {
                        return;
                    }
                    default -> throw new IllegalArgumentException("Please pick either buy tickets or edit profile");
                }
            } catch (InputMismatchException i) {
                System.out.println("Message: " + i);
            }
        }while(true);
    }
    public void sellTick(User user) {
        int userIn = 0;
        int limit;
        Event userEv = null;
        //or(int i =1; i < events.size(); i++){
        //  System.out.println(events.getEvent(i));
        //}
            do {
                try {
                    System.out.println("Please enter the ID of the event you wish to attend");
                    userEv = events.getEvent(Integer.parseInt(in.nextLine()));
                } catch (IllegalArgumentException n) {
                    System.out.println("that isn't a valid Id number");
                }
            }while(userEv == null);
            do{
                try {
                    System.out.println("""
                            What ticket type would you like to purchase?\s
                            1.VIP\s
                            2.Gold\s
                            3.Silver\s
                            4.Bronze\s
                            5.General Admission\s
                            """);
                    userIn = Integer.parseInt(in.nextLine());
                }catch(IllegalArgumentException i){
                    System.out.println("That isn't a valid ticket type" + i);
                }
        }while(userIn == 0);
        while (true) {
            System.out.println("How many would you like to purchase? Limit 10");
            limit = Integer.parseInt(in.nextLine());
            switch (userIn) {
                case 1 -> {
                    events.sellVip(userEv, limit);
                    users.updtTix(user, limit);
                    users.chngBalance(user, (limit * userEv.getVipPrc()));
                    return;
                }
                case 2 -> {
                    events.sellGld(userEv, limit);
                    users.updtTix(user, limit);
                    users.chngBalance(user, (limit * userEv.getGldPrc()));
                    return;
                }
                case 3 -> {
                    events.sellSlvr(userEv, limit);
                    users.updtTix(user, limit);
                    users.chngBalance(user, (limit * userEv.getSlvrPrc()));
                    return;
                }
                case 4 -> {
                    events.sellBrnz(userEv, limit);
                    users.updtTix(user, limit);
                    users.chngBalance(user, (limit * userEv.getBrnzPrc()));
                    return;
                }
                case 5 -> {
                    events.sellGa(userEv, limit);
                    users.updtTix(user, limit);
                    users.chngBalance(user, (limit * userEv.getGaPrc()));
                    return;
                }
                default -> {
                }
            }
        }
    }
}
