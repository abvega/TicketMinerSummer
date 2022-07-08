package TicketMiner.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Factory class that reads CSV and creates user objects
 */
public class MakeUser {
    public HashMap<String, User> userFromCSV(String fileName){
        HashMap<String, User> users = new HashMap<>();
        try(Scanner br = new Scanner((new File(fileName)))){
            String headLine = br.nextLine();
            String line = br.nextLine();
            while(br.hasNextLine()){
                String[] values = line.split(",");
                User user = makeUser(setArrangeInfo(headLine.split(","), values));
                users.put(user.getUserName(),user);
                line = br.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Message "+ e);
        }
        return users;
    }

    /**
     * method is used to organize CSV into a cohesive array no matter the column order of the CSV
     * @param headLine contains titles of columns
     * @param data contains actual data in the rows
     * @return an organized String[]
     */
    public String[] setArrangeInfo(String[] headLine, String[] data){
        String[] tempD = new String[headLine.length];
        for(int i =0; i< headLine.length;i++){
            if(headLine[i].equalsIgnoreCase("ID")){
                tempD[0] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("First Name")){
                tempD[1] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Last Name")){
                tempD[2] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Password")){
                tempD[3] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Money Available")){
                tempD[4] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("TicketMiner Membership")){
                tempD[5] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("UserName")){
                tempD[6] = data[i];
            }
            else if(headLine[i].equalsIgnoreCase("Tickets Purchased")){
                tempD[7] = data[i];
            }
        }
        return tempD;
    }

    /**
     * Takes organized array and assigns data from column to variables then creates user objects.
     * @param data organized user String[].
     * @return user objects.
     */
    public User makeUser(String[] data){
        int iD = Integer.parseInt(data[0]);
        String firstName = data[1];
        String lastName = data[2];
        String passwrd = data[3];
        double money = Double.parseDouble(data[4]);
        boolean membr = Boolean.parseBoolean(data[5]);
        String usrnme = data[6];
        int tix = Integer.parseInt(data[7]);
        return new User(iD, firstName, lastName, money, membr, usrnme, passwrd);
    }
}
