package TicketMiner.User;

import TicketMiner.Dao.EventDaoImplementation;
import TicketMiner.Dao.UserDao;
import TicketMiner.Event.Event;

import TicketMiner.Purchase.CartGUI;
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
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * controller class for UserGUI.fxml
 */

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
    private EventDaoImplementation eventList = new EventDaoImplementation();
    private UserDao userList = new UserDao();
    private User logUser;
    private Event selectedEvent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setValues();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setTotals();
    }
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/LoginGUI.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @return an observableList to populate tableview table
     */
    private ObservableList<Event> getEvents() throws SQLException {
        return FXCollections.observableArrayList(eventList.getEvents());
    }

    /**
     * method used to initiate the columns for the table
     */
    private void setValues() throws SQLException {
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

    /**
     * When user selects an event method sets labels with ticket prices
     */
    private void select(){
        if(table.getSelectionModel().getSelectedItem() != null){
            selectedEvent = table.getSelectionModel().getSelectedItem();
            vipLabel.setText(selectedEvent.getVipPrc().toString());
            gldLabel.setText(selectedEvent.getGldPrc().toString());
            slvrLabel.setText(selectedEvent.getSlvrPrc().toString());
            brnzLabel.setText(selectedEvent.getBrnzPrc().toString());
            gaLabel.setText(selectedEvent.getGaPrc().toString());
        }
    }

    /**
     * sets the total labels to default value
     */
    public void setTotals(){
        vipTot.setText(new BigDecimal("0.00").toString());
        gldTot.setText(new BigDecimal("0.00").toString());
        slvrTot.setText(new BigDecimal("0.00").toString());
        brnzTot.setText(new BigDecimal("0.00").toString());
        gaTot.setText(new BigDecimal("0.00").toString());
    }

    /**
     *
     * @param userName used to define user who's logged in and display on scene
     */
    public void setUser(String userName) throws SQLException {
        this.logUser = userList.getUser(userName);
        userLabel.setText(logUser.getUserName());
        balance.setText(logUser.getMoneyTotal().toString());
    }

    /**
     * calculates the total cost of the user's chosen vip ticket amount and displays value
     */
    public void setVipTot(){
        vipTot.setText(new BigDecimal(vipLabel.getText())
                .multiply(BigDecimal.valueOf(Integer.parseInt(vipAmt.getText()))).toString());
    }

    /**
     * calculates the total cost of the user's chosen gold ticket amount and displays value
     */
    public void setGldTot(){
        gldTot.setText(new BigDecimal(gldLabel.getText())
                .multiply(BigDecimal.valueOf(Integer.parseInt(gldAmt.getText()))).toString());
    }

    /**
     * calculates the total cost of the user's chosen silver ticket amount and displays value
     */
    public void setSlvrTot(){
        slvrTot.setText(new BigDecimal(slvrLabel.getText())
                .multiply(BigDecimal.valueOf(Integer.parseInt(slvrAmt.getText()))).toString());
    }

    /**
     * calculates the total cost of the user's chosen bronze ticket amount and displays value
     */
    public void setBrnzTot(){
        brnzTot.setText(new BigDecimal(brnzLabel.getText())
                .multiply(BigDecimal.valueOf(Integer.parseInt(brnzAmt.getText()))).toString());
    }

    /**
     * calculates the total cost of the user's chosen general admission ticket amount and displays value
     */
    public void setGaTot(){
        gaTot.setText(new BigDecimal(gaLabel.getText())
                .multiply(BigDecimal.valueOf(Integer.parseInt(gaAmt.getText()))).toString());
    }

    /**
     * takes totals of all ticket amounts and calculates a final total
     */
    public void setTotTot(){
        totTot.setText(new BigDecimal(vipTot.getText()).add(new BigDecimal(gldTot.getText()))
                .add(new BigDecimal(slvrTot.getText())).add(new BigDecimal(brnzTot.getText()))
                .add(new BigDecimal(gaTot.getText())).toString());

    }

    /**
     * Method used to change scene to CartGUI.fxml after user confirms price of tickets.
     * @param event
     * @throws IOException
     */
    public void confirmPurchase(ActionEvent event) throws IOException {
        if(!totTot.getText().equalsIgnoreCase("") || Integer.parseInt(totTot.getText()) > 0){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/CartGUI.fxml"));
            Parent tableParent = loader.load();
            Scene scene = new Scene(tableParent);
            CartGUI cartGUI = loader.getController();
            cartGUI.setUser(logUser);
            cartGUI.setEvent(selectedEvent);
            cartGUI.setPrices(Double.parseDouble(vipTot.getText()), Double.parseDouble(gldTot.getText()),
                    Double.parseDouble(slvrTot.getText()), Double.parseDouble(brnzTot.getText()), Double.parseDouble(gaTot.getText()));
            cartGUI.setQuants(Integer.parseInt(vipAmt.getText()), Integer.parseInt(gldAmt.getText()), Integer.parseInt(slvrAmt.getText()),
                    Integer.parseInt(brnzAmt.getText()), Integer.parseInt(gaAmt.getText()));
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.ERROR, "Please calculate total before proceeding to cart");
        alert.show();
    }
}
