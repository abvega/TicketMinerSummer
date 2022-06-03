import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    Scanner in = new Scanner(System.in);






























    /**

    public MainMenu() {
        int input;
        while(true){
            try {
                System.out.println("""
                        Welcome to TicketMiner\s
                        Are you a(n)\s
                        1. Admin\s
                        2. User\s
                        """);
                input = Integer.parseInt(in.nextLine());
                switch(input){
                    case 1:
                        new AdminPanel();
                        break;
                    case 2:
                        new UserPanel();
                        break;
                    case 3:
                        return;
                    default:
                        throw new IllegalStateException("Unexpected value: " + input);
                }
            }catch (InputMismatchException | IllegalStateException i) {
                System.out.println("Message " + i);
            }
        }
    }
     */
}

