package TicketMiner.User;

/**
 * User class blueprints for user objects
 */

public class User {
    private int iD;
    private String firstName;
    private String lastName;
    private double moneyTotal;
    private int tixBought;
    private boolean isMember;
    private String userName;
    private String passWord;
    private int amtSavd;

    public User(){}

    public User(int iD, String firstName, String lastName, double moneyTotal, boolean isMember, String userName, String passWord) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneyTotal = moneyTotal;
        this.tixBought = 0;
        this.isMember = isMember;
        this.userName = userName;
        this.passWord = passWord;
        this.amtSavd = 0;
    }

    public int getiD() {return iD;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public double getMoneyTotal() {return moneyTotal;}
    public int getTixBought() {return tixBought;}
    public boolean getIsMember() {return isMember;}
    public String getUserName() {return userName;}
    public String getPassWord() {return passWord;}
    public int getAmtSavd() {return amtSavd;}

    public void setiD(int iD) {this.iD = iD;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setMoneyTotal(double moneyTotal) {this.moneyTotal = this.moneyTotal - moneyTotal;}
    public void setTixBought(int tixBought) {this.tixBought = getTixBought() + tixBought;}
    public void setMember(boolean member) {isMember = member;}
    public void setIserName(String userName) {this.userName = userName;}
    public void setPassWord(String passWord) {this.passWord = passWord;}
    public void setAmtSavd(int amtSavd) {this.amtSavd = getAmtSavd() + amtSavd;}
    public String toString(){
        return "ID " + getiD() + "\n"
                +"First Name "+ getFirstName()+ "\n"
                +"Last Name " + getLastName()+"\n"
                +"Wallet Total "+getMoneyTotal()+"\n"
                +"Tickets Purchased "+getTixBought()+"\n"
                +"Is Member? "+getIsMember()+"\n"
                +"UserName "+getUserName()+"\n"
                +"Password is "+getPassWord()+"\n"
                +"Has saved "+ getAmtSavd();
    }
}
