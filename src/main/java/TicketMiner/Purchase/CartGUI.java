package TicketMiner.Purchase;

import TicketMiner.Event.Event;
import TicketMiner.User.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import java.math.BigDecimal;
import java.util.Optional;

public class CartGUI {

    private User user;
    private Event event;

    @FXML
    private Label userLabel;
    @FXML
    private Label userBalance;
    @FXML
    private Label eventName;
    @FXML
    private Label eventDate;
    @FXML
    private Label eventTime;
    @FXML
    private Label venueName;
    @FXML
    private Label vip;
    @FXML
    private Label vipQ;
    @FXML
    private Label gld;
    @FXML
    private Label gldQ;
    @FXML
    private Label slvr;
    @FXML
    private Label slvrQ;
    @FXML
    private Label brnz;
    @FXML
    private Label brnzQ;
    @FXML
    private Label ga;
    @FXML
    private Label gaQ;
    @FXML
    private Label total;

    /**
     * method used to set the User info for the user buying tickets.
     * @param userIn
     */
    public void setUser(User userIn){
        this.user = userIn;
        userLabel.setText(user.getUserName());
        userBalance.setText(user.getMoneyTotal().toString());
    }

    /**
     * Method is used to set the Event the user selected to buy tickets from.
     * @param eventIn
     */
    public void setEvent(Event eventIn){
        this.event = eventIn;
        eventName.setText(event.getName());
        eventDate.setText(event.getDate());
        eventTime.setText(event.getTime());
        venueName.setText(event.getVenueName());
    }
    /**
     * method accepts quantities of purchased tickets and displays them on Cart screen
     * @param vipQ
     * @param gldQ
     * @param slvrQ
     * @param brnzQ
     * @param gaQ
     */
    public void setQuants(int vipQ, int gldQ, int slvrQ, int brnzQ, int gaQ){
        this.vipQ.setText(Integer.toString(vipQ));
        this.gldQ.setText(Integer.toString(gldQ));
        this.slvrQ.setText(Integer.toString(slvrQ));
        this.brnzQ.setText(Integer.toString(brnzQ));
        this.gaQ.setText(Integer.toString(gaQ));
    }
    /**
     * method accepts prices of event user purchased tickets to, then displays them on Cart screen to confirm.
     * @param vip
     * @param gld
     * @param slvr
     * @param brnz
     * @param ga
     */
    public void setPrices(double vip, double gld, double slvr, double brnz, double ga){
        this.vip.setText(Double.toString(vip));
        this.gld.setText(Double.toString(gld));
        this.slvr.setText(Double.toString(slvr));
        this.brnz.setText(Double.toString(brnz));
        this.ga.setText(Double.toString(ga));
        this.total.setText(Double.toString(vip+gld+slvr+brnz+ga));
    }

    /**
     * Method displays alert to confirm transaction on user input.
     */
    @FXML
    private void confirmPurchase(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Confirm Purchase");
        alert.setContentText(setAlertContent());
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            recordTransaction();
        }
        alert.close();
    }

    /**
     * Creates a string from transaction info to be used in confirmation alert.
     * @return string that is used to confirm transaction
     */
    private String setAlertContent(){
        return "Event name: "+ event.getName()+"\n"+
                "Quantity of tickets purchased: \n" +
                "VIP: " + vipQ.getText()+ "\n"+
                "Gold: " + gldQ.getText()+"\n"+
                "Silver " +slvrQ.getText()+"\n"+
                "Bronze " +brnzQ.getText()+"\n"+
                "General Admission " +gaQ.getText()+"\n"+
                "Total price: " + total.getText()+"\n"+
                "Username: " + user.getUserName()+"\n"+
                "Balance: " + user.getMoneyTotal()+"\n"+
                "New Balance after transaction: "+ (user.getMoneyTotal().subtract(new BigDecimal(total.getText())));
    }

    /**
     * When called, checks if the user can afford transaction, if true, records the transaction and deducts cost from
     * users account. If false, alert window pops up telling user they have insufficient funds.
     */
    private void recordTransaction() {
        if(user.getMoneyTotal().compareTo(new BigDecimal(total.getText())) > 0) {
            event.setVipQuant(Integer.parseInt(vipQ.getText()));
            event.setGoldQuant(Integer.parseInt(gldQ.getText()));
            event.setSlvrQuant(Integer.parseInt(slvrQ.getText()));
            event.setBrnzQuant(Integer.parseInt(brnzQ.getText()));
            event.setGaQuant(Integer.parseInt(gaQ.getText()));
            user.newMoneyTotal(BigDecimal.valueOf(Double.parseDouble(total.getText())));
            user.setTixBought(totalTickets());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Not enough funds in this user's account");
            alert.setContentText("Please raise more funds in this user's account");
            alert.show();
        }
    }

    /**
     * Calculates the total number of tickets user bought
     * @return total number of tickets
     */
    private int totalTickets(){
        return Integer.parseInt(vipQ.getText() + gldQ.getText() + slvrQ.getText()+ brnzQ.getText()+gaQ.getText());
    }
}
