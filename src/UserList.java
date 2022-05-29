import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserList {
    private static UserList instance;
    private final MakeUser makeUser = new MakeUser();
    private final HashMap<String, User> users = makeUser.userFromCSV("CustomerListPA4FINAL.csv");
    private final Scanner in = new Scanner(System.in);

    public static UserList getInstance(){
        if(instance == null){
            instance = new UserList();
        }
        return instance;
    }
    public User getUser(String userName){
        if(!userExist(userName)){
            return null;
        }
        return users.get(userName);
    }
    public boolean userExist(String userName){
        return users.containsKey(userName);
    }
    public void modifyUser(User user){
        int input;
        System.out.println("""
                How would you like to modify your user profile?.\s
                1.User Name\s
                2.First Name\s
                3.Last Name\s
                4.Password\s
                """);
        input = Integer.parseInt(in.nextLine());
        switch (input){
            case 1:
                chngUserName(user);
                break;
            case 2:
                chngFrstNme(user);
                break;
            case 3:
                chngLstNme(user);
                break;
            case 4:
                chngPssWrd(user);
                break;
            default:
                break;
        }
    }
    public void chngUserName(User user){
        String input;
        System.out.println("What would you like to change your user name to? ");
        input = in.nextLine();
        user.setIserName(input);
    }
    public void chngPssWrd(User user){
        String input;
        while(true) {
            System.out.println("Input your current password");
            input = in.nextLine();
            if (user.getPassWord().equalsIgnoreCase(input)) {
                System.out.println("Please type in your new password");
                user.setPassWord(in.nextLine());
                return;
            } else {
                System.out.println("That password is incorrect.");
            }
        }
    }

    /**
     *
     * @param user
     * user passed to check membership status
     * @param amt
     *if user is member, 10% is applied to amt
     */
    public void chngBalance(User user, double amt) {
        if (chckBlnce(user, amt)) {
            if (user.getIsMember()) {
                amt = amt * .1;
            }
            user.setMoneyTotal(amt);
        }
        else{
            System.out.println("User doesn't have enough money in this account");
        }
    }
    public void chngFrstNme(User user){
        String input;
        System.out.println("What would you like to change this user's first name to?");
        input = in.nextLine();
        user.setFirstName(input);
        System.out.println("User's name has been change to " + user.getFirstName());
    }
    public void chngLstNme(User user){
        String input;
        System.out.println("What would you like to change this user's first name to?");
        input = in.nextLine();
        user.setLastName(input);
        System.out.println("User's last name has been changed to "+ user.getLastName());
    }
    public void updtTix(User user, int tix){
        user.setTixBought(tix);
    }
    public void chngMem(User user){
        user.setMember(!user.getIsMember());
    }
    public boolean chckBlnce(User user, double total){
        return (user.getMoneyTotal()< total);
    }

    /**
     *
     * @param userName
     * @param passW
     * @return boolean
     *  accepts user input of username and password.returns true if the username exists as well as the
     *  password matching what user input.
     */
    public boolean auth(String userName, String passW){
        User myUser = users.get(userName);
        return users.containsKey(userName) && myUser.getPassWord().equalsIgnoreCase(passW);
    }
}
