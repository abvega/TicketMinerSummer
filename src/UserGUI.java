import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserGUI implements Initializable {
    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<Event, String> event;
    @FXML
    private TableColumn<Event, String> date;
    @FXML
    private TableColumn<Event, String> time;
    @FXML
    private TableColumn<Event, String> venue;
    @FXML
    private TableColumn<Event, Double> vip;
    @FXML
    private TableColumn<Event, Double> gold;
    @FXML
    private TableColumn<Event, Double> slvr;
    @FXML
    private TableColumn<Event, Double> brnz;
    @FXML
    private TableColumn<Event, Double> gnrl;
    @FXML
    private Label userLabel;
    @FXML
    private Label balance;
    @FXML
    private Label vipLabel;
    @FXML
    private Label gldLabel;
    @FXML
    private Label slvrLabel;
    @FXML
    private Label brnzLabel;
    @FXML
    private Label gaLabel;
    @FXML
    private TextField vipAmt;
    @FXML
    private TextField gldAmt;
    @FXML
    private TextField slvrAmt;
    @FXML
    private TextField brnzAmt;
    @FXML
    private TextField gaAmt;
    @FXML
    private Label vipTot;
    @FXML
    private Label gldTot;
    @FXML
    private Label slvrTot;
    @FXML
    private Label brnzTot;
    @FXML
    private Label gaTot;
    @FXML
    private Label totTot;

    private EventList eventList = EventList.getInstance();
    private UserList userList = UserList.getInstance();
    private User logUser;
    private Event selectedEvent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValues();
        setTotals();

    }
    private ObservableList<Event> getEvents(){
        return FXCollections.observableArrayList(eventList.getArrayList());
    }
    private void setValues(){
        event.setCellValueFactory(new PropertyValueFactory<>("name"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        venue.setCellValueFactory(new PropertyValueFactory<>("VenueName"));
        vip.setCellValueFactory(new PropertyValueFactory<>("vipPrc"));
        gold.setCellValueFactory(new PropertyValueFactory<>("gldPrc"));
        slvr.setCellValueFactory(new PropertyValueFactory<>("slvrPrc"));
        brnz.setCellValueFactory(new PropertyValueFactory<>("brnzPrc"));
        gnrl.setCellValueFactory(new PropertyValueFactory<>("gaPrc"));
        table.setItems(getEvents());
        table.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount() > 0){
                select();
            }
        });
    }
    private void select(){
        if(table.getSelectionModel().getSelectedItem() != null){
            selectedEvent = table.getSelectionModel().getSelectedItem();
            vipLabel.setText(Double.toString(selectedEvent.getVipPrc()));
            gldLabel.setText(Double.toString(selectedEvent.getGldPrc()));
            slvrLabel.setText(Double.toString(selectedEvent.getSlvrPrc()));
            brnzLabel.setText(Double.toString(selectedEvent.getBrnzPrc()));
            gaLabel.setText(Double.toString(selectedEvent.getGaPrc()));
        }
    }
    public void setTotals(){
        vipTot.setText(Double.toString(0.00));
        gldTot.setText(Double.toString(0.00));
        slvrTot.setText(Double.toString(0.00));
        brnzTot.setText(Double.toString(0.00));
        gaTot.setText(Double.toString(0.00));
    }
    public void setUser(String userName){
        this.logUser = userList.getUser(userName);
        userLabel.setText(logUser.getUserName());
        balance.setText(Double.toString(logUser.getMoneyTotal()));
    }
    public void setVipTot(){
        vipTot.setText(Double.toString(Double.parseDouble(vipLabel.getText())*Double.parseDouble(vipAmt.getText())));
    }
    public void setGldTot(){
        gldTot.setText(Double.toString(Double.parseDouble(gldLabel.getText()) * Double.parseDouble(gldAmt.getText())));
    }
    public void setSlvrTot(){
        slvrTot.setText(Double.toString(Double.parseDouble(slvrLabel.getText())*Double.parseDouble(slvrAmt.getText())));
    }
    public void setBrnzTot(){
        brnzTot.setText(Double.toString(Double.parseDouble(brnzLabel.getText())*Double.parseDouble(brnzAmt.getText())));
    }
    public void setGaTot(){
        gaTot.setText(Double.toString(Double.parseDouble(gaLabel.getText())*Double.parseDouble(gaAmt.getText())));
    }
    public void setTotTot(){
        totTot.setText(Double.toString(Double.parseDouble(vipTot.getText())+Double.parseDouble(gldTot.getText())
        +Double.parseDouble(slvrTot.getText())+Double.parseDouble(brnzTot.getText())+Double.parseDouble(gaTot.getText())));
    }
    public void confirmPurchase(ActionEvent event) throws IOException {
        if(!totTot.getText().equalsIgnoreCase("") || Integer.parseInt(totTot.getText()) > 0){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CartGUI.fxml"));
            Parent tableParent = loader.load();
            Scene scene = new Scene(tableParent);
            CartGUI cartGUI = loader.getController();
            cartGUI.setUser(logUser);
            cartGUI.setEvent(selectedEvent);
            cartGUI.setPrices(Double.parseDouble(vipTot.getText()), Double.parseDouble(gldTot.getText()),
                    Double.parseDouble(slvrTot.getText()), Double.parseDouble(brnzTot.getText()), Double.parseDouble(gaTot.getText()));
            cartGUI.setQuants(Integer.parseInt(vipAmt.getText()), Integer.parseInt(gldAmt.getText()), Integer.parseInt(slvrAmt.getText())
            , Integer.parseInt(brnzAmt.getText()), Integer.parseInt(gaAmt.getText()));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please calculate total before proceeding to cart");
        alert.show();
    }
}
