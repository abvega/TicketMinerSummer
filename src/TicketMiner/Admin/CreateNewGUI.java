package TicketMiner.Admin;

import TicketMiner.Event.Event;
import TicketMiner.Event.EventList;
import TicketMiner.Event.Venue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


public class CreateNewGUI {
    private Parent root;
    private Scene scene;
    private Stage stage;
    private EventList events = EventList.getInstance();
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    @FXML
    private TextField eventNameField;
    @FXML
    private TextField eventTypeField;
    @FXML
    private TextField eventDateField;
    @FXML
    private TextField eventTimeField;
    @FXML
    private TextField venueNameField;
    @FXML
    private TextField vipPrice;
    @FXML
    private TextField gldPrice;
    @FXML
    private TextField slvrPrice;
    @FXML
    private TextField brnzPrice;
    @FXML
    private TextField gaPrice;
    @FXML
    private TextField vipPct;
    @FXML
    private TextField gldPct;
    @FXML
    private TextField slvrPct;
    @FXML
    private TextField brnzPct;
    @FXML
    private TextField gaPct;
    @FXML
    private TextField rsrvPct;
    @FXML
    private TextField cap;
    @FXML
    private CheckBox fireworks;

    public void newEvent(ActionEvent event){
        try {
            int iD = events.size() + 1;
            String eventName = eventNameField.getText();
            String eventType = eventTypeField.getText();
            String eventDate = eventDateField.getText();
            String eventTime = eventTimeField.getText();
            String venueName = venueNameField.getText();
            int capacity = Integer.parseInt(cap.getText());
            int vip = Integer.parseInt(vipPct.getText());
            int gld = Integer.parseInt(gldPct.getText());
            int slvr = Integer.parseInt(slvrPct.getText());
            int brnz = Integer.parseInt(brnzPct.getText());
            int ga = Integer.parseInt(gaPct.getText());
            int rsrv = Integer.parseInt(rsrvPct.getText());
            double vipPrce = Double.parseDouble(vipPrice.getText());
            double gldPrce = Double.parseDouble(gldPrice.getText());
            double slvrPrce = Double.parseDouble(slvrPrice.getText());
            double brnzPrce = Double.parseDouble(brnzPrice.getText());
            double gaPrc = Double.parseDouble(gaPrice.getText());
            boolean fworks = fireworks.isSelected();
            if(divCheck(vip,gld,slvr,brnz,ga,rsrv)) {
                Venue venue = new Venue(venueName, capacity, vip, gld, slvr, brnz, ga, rsrv, 0);
                Event eve = new Event(iD, eventType, eventName, eventDate, eventTime, vipPrce, gldPrce, slvrPrce, brnzPrce, gaPrc, venue, fworks, 10000);
                confirmCreate(eve);
            }
            else{
                errorMessage("Percentage total error","Seat percentages must total 100%");
            }
        }catch(IllegalArgumentException e){
           Alert alert = new Alert(Alert.AlertType.ERROR, "Use proper inputs please.");
            alert.show();
        }
    }
    public void goBack(ActionEvent event) throws IOException {
        scene = new Scene(FXMLLoader.load(getClass().getResource("AdminPanelGUI.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }
    @FXML
    private void confirmCreate(Event event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("This event will be added to the database: ");
        alert.setContentText(event.toString());
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            events.add(event);
        }
        resetForm();
        alert.close();
    }
    @FXML
    private void resetForm(){
        eventNameField.setText("");
        eventTypeField.setText("");
        eventNameField.setText("");
        eventDateField.setText("");
        eventTimeField.setText("");
        venueNameField.setText("");
        fireworks.setSelected(false);
        cap.setText("");
        vipPrice.setText("0.00");
        gldPrice.setText("0.00");
        slvrPrice.setText("0.00");
        brnzPrice.setText("0.00");
        gaPrice.setText("0.00");
        vipPct.setText("5");
        gldPct.setText("10");
        slvrPct.setText("15");
        brnzPct.setText("20");
        gaPct.setText("45");
        rsrvPct.setText("5");
    }
    private boolean divCheck(int vip, int gld, int slvr, int brnz, int ga, int rsrv) {
        return(vip + gld + slvr + brnz + ga + rsrv == 100);
    }
    private void errorMessage(String header, String body){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.setContentText(body);
        alert.show();
    }
}
