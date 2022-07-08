package TicketMiner.User;

import java.util.HashMap;
import java.util.Scanner;

public class UserList {
    private static UserList instance;
    private final MakeUser makeUser = new MakeUser();
    private final HashMap<String, User> users = makeUser.userFromCSV("CustomerListPA4FINAL.csv");
    private final Scanner in = new Scanner(System.in);

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }
    public boolean userExist(String userName) {
        return (users.containsKey(userName));
    }
    public User getUser(String userName) {
        if (users.get(userName) == null) {
            return null;
        }
        return users.get(userName);
    }
}
