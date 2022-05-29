import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    Scanner in = new Scanner(System.in);

    public MainMenu() {
        int input;
        while(true){
            try {
                System.out.println("""
                        Welcome to TicketMiner\s
                        Are you a\s
                        1. Admin\s
                        2. User\s
                        """);
                input = Integer.parseInt(in.nextLine());
                if (input == 1) {
                    new AdminPanel();
                }
                if (input == 2) {
                    new UserPanel();
                }
            }catch (InputMismatchException | NumberFormatException i) {
                System.out.println("Message " + i);
            }
        }
    }
}

