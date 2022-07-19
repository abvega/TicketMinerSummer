package TicketMiner.Admin;
/**
 * Controller class for CreateNewGUI.fxml.
 */

import TicketMiner.Dao.EventDaoImplementation;
import TicketMiner.Dao.VenueDao;
import TicketMiner.Event.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class CreateNewGUI implements Initializable {
    private final EventDaoImplementation dao = new EventDaoImplementation();
    private final VenueDao vDao = new VenueDao();
    private ArrayList<VenueSm> venues = vDao.getVenues();
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
    private TextField unavailPct;
    @FXML
    private Label cap;
    @FXML
    private CheckBox fireworks;
    @FXML
    private ComboBox<String> CBoxVen;
    @FXML
    private Label venType;
    @FXML
    private Label venCost;

    public CreateNewGUI() throws SQLException {
    }

    /**
     * when called verifies user input as valid, then creates new event and venue and adds to EventList ArrayList
     * using admin inputs.
     * @param event
     */
    @FXML
    private void newEvent(ActionEvent event){
        try {
            String eventName = eventNameField.getText();
            String eventType = eventTypeField.getText();
            String eventDate = eventDateField.getText();
            String eventTime = eventTimeField.getText();
            String venueName = CBoxVen.getSelectionModel().getSelectedItem();
            String venueType = venType.getText();
            int capacity = Integer.parseInt(cap.getText());
            int vCost = Integer.parseInt(venCost.getText());
            int vip = Integer.parseInt(vipPct.getText());
            int gld = Integer.parseInt(gldPct.getText());
            int slvr = Integer.parseInt(slvrPct.getText());
            int brnz = Integer.parseInt(brnzPct.getText());
            int ga = Integer.parseInt(gaPct.getText());
            int rsrv = Integer.parseInt(rsrvPct.getText());
            int unaPct = Integer.parseInt(unavailPct.getText());
            BigDecimal vipPrce = BigDecimal.valueOf(Double.parseDouble(vipPrice.getText()));
            BigDecimal gldPrce = BigDecimal.valueOf(Double.parseDouble(gldPrice.getText()));
            BigDecimal slvrPrce = BigDecimal.valueOf(Double.parseDouble(slvrPrice.getText()));
            BigDecimal brnzPrce = BigDecimal.valueOf(Double.parseDouble(brnzPrice.getText()));
            BigDecimal gaPrc = BigDecimal.valueOf(Double.parseDouble(gaPrice.getText()));
            boolean fworks = fireworks.isSelected();
            if(divCheck(vip,gld,slvr,brnz,ga,rsrv, unaPct)) {
                Venue venue = new Venue(venueName,venueType, capacity, vip, gld, slvr, brnz, ga, rsrv,unaPct,vCost);
                Event eve = new Event(eventType, eventName, eventDate, eventTime, vipPrce, gldPrce, slvrPrce, brnzPrce, gaPrc, venue, fworks, 10000);
                try {
                    confirmCreate(eve);
                }catch(SQLException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Cannot create new event");
                }
            }
            else{
                errorMessage("Percentage total error","Seat percentages must total 100%");
            }
        }catch(IllegalArgumentException e){
           Alert alert = new Alert(Alert.AlertType.ERROR, "Use proper inputs please.");
            alert.show();
        }
    }

    /**
     * This function is called by the back button to go back to previous scene.
     * @param event
     * @throws IOException
     */
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/AdminPanelGUI.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }

    /**
     * Creates an alert window to prompt user for additional input to confirm creation on new event object.
     * @param event
     */
    @FXML
    private void confirmCreate(Event event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("This event will be added to the database: ");
        alert.setContentText(event.toString());
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            dao.add(event);
            resetForm();
        }
        alert.close();
    }

    /**
     * Resets all fields to default when invoked.
     */
    @FXML
    private void resetForm(){
        eventNameField.setText("");
        eventTypeField.setText("");
        eventNameField.setText("");
        eventDateField.setText("");
        eventTimeField.setText("");
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
        unavailPct.setText("0");
    }

    /**
     * Accepts percentage numbers from user input and checks if the total of all percentages equals 100
     * @param vip percentage
     * @param gld percentage
     * @param slvr percentage
     * @param brnz percentage
     * @param ga percentage
     * @param rsrv percentage
     * @return false if total > 100 or if total < 100
     * true if == 100
     */
    private boolean divCheck(int vip, int gld, int slvr, int brnz, int ga, int rsrv, int unaPct) {
        return(vip + gld + slvr + brnz + ga + rsrv + unaPct == 100);
    }

    /**
     * Creates an Alert window using header and body to set text on the Alert.
     * @param header String used to set Alert header.
     * @param body String used to set Alert content text.
     */
    private void errorMessage(String header, String body){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.setContentText(body);
        alert.show();
    }
    private void setComboBox(){
        for(VenueSm venue: venues){
            CBoxVen.getItems().add(venue.getName());
        }
        CBoxVen.setOnAction((event) ->{
            int index = CBoxVen.getSelectionModel().getSelectedIndex();
            VenueSm venue = venues.get(index);
            cap.setText(Integer.toString(venue.getCapacity()));
            venType.setText(venue.getType());
            venCost.setText(Integer.toString(venue.getCost()));
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setComboBox();
    }
}
