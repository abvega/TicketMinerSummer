import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

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

    public void setUser(User userIn){
        this.user = userIn;
        userLabel.setText(user.getUserName());
        userBalance.setText(Double.toString(user.getMoneyTotal()));
    }
    public void setEvent(Event eventIn){
        this.event = eventIn;
        eventName.setText(event.getName());
        eventDate.setText(event.getDate());
        eventTime.setText(event.getTime());
        venueName.setText(event.getVenueName());
    }
    public void setQuants(int vipQ, int gldQ, int slvrQ, int brnzQ, int gaQ){
        this.vipQ.setText(Integer.toString(vipQ));
        this.gldQ.setText(Integer.toString(gldQ));
        this.slvrQ.setText(Integer.toString(slvrQ));
        this.brnzQ.setText(Integer.toString(brnzQ));
        this.gaQ.setText(Integer.toString(gaQ));
    }
    public void setPrices(double vip, double gld, double slvr, double brnz, double ga){
        this.vip.setText(Double.toString(vip));
        this.gld.setText(Double.toString(gld));
        this.slvr.setText(Double.toString(slvr));
        this.brnz.setText(Double.toString(brnz));
        this.ga.setText(Double.toString(ga));
        this.total.setText(Double.toString(vip+gld+slvr+brnz+ga));
    }
    public void confirmPurchase(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Confirm Purchase");
        alert.setContentText(setAlertContent());
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            recordTransaction();
        }
        alert.close();
    }
    private String setAlertContent(){
        return "TicketMiner.Event name: "+ event.getName()+"\n"+
                "Quantity of tickets purchased: \n" +
                "VIP: " + vipQ.getText()+ "\n"+
                "Gold: " + gld.getText()+"\n"+
                "Silver " +slvrQ.getText()+"\n"+
                "Bronze " +brnzQ.getText()+"\n"+
                "General Admission " +gaQ.getText()+"\n"+
                "Total price: " + total.getText()+"\n"+
                "Username: " + user.getUserName()+"\n"+
                "Balance: " + user.getMoneyTotal()+"\n"+
                "New Balance after transaction: "+ (user.getMoneyTotal() - Double.parseDouble(total.getText()));
    }
    private void recordTransaction() {
        if (user.getMoneyTotal() > Double.parseDouble(total.getText())) {
            event.setVipQuant(Integer.parseInt(vipQ.getText()));
            event.setGoldQuant(Integer.parseInt(gldQ.getText()));
            event.setSlvrQuant(Integer.parseInt(slvrQ.getText()));
            event.setBrnzQuant(Integer.parseInt(brnzQ.getText()));
            event.setGaQuant(Integer.parseInt(gaQ.getText()));
            user.setMoneyTotal(Double.parseDouble(total.getText()));
            user.setTixBought(totalTickets());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Not enough funds in this user's account");
            alert.setContentText("Please raise more funds in this user's account");
            alert.show();
        }
    }
    private int totalTickets(){
        return Integer.parseInt(vipQ.getText() + gldQ.getText() + slvrQ.getText()+ brnzQ.getText()+gaQ.getText());
    }
}
