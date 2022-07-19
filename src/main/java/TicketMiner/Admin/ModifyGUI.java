package TicketMiner.Admin;

import TicketMiner.Dao.EventDaoImplementation;
import TicketMiner.Event.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.BigDecimalStringConverter;
import javafx.util.converter.BooleanStringConverter;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

/**
 * Controller class for modifyGUI fxml
 */
public class ModifyGUI implements Initializable{
    private Scene scene;
    private Stage stage;
    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<Event,Integer> eventID;
    @FXML
    private TableColumn<Event,String> eventName;
    @FXML
    private TableColumn<Event,String> eventType;
    @FXML
    private TableColumn<Event,String> eventDate;
    @FXML
    private TableColumn<Event,String> eventTime;
    @FXML
    private TableColumn<Event,String> venueName;
    @FXML
    private TableColumn<Event,BigDecimal> vipPrc;
    @FXML
    private TableColumn<Event,BigDecimal> gldPrc;
    @FXML
    private TableColumn<Event,BigDecimal> slvrPrc;
    @FXML
    private TableColumn<Event,BigDecimal> brnzPrc;
    @FXML
    private TableColumn<Event,BigDecimal> gaPrc;
    @FXML
    private TableColumn<Event,Boolean> fWorks;
    @FXML
    private Label vPct;
    @FXML
    private Label gPct;
    @FXML
    private Label sPct;
    @FXML
    private Label bPct;
    @FXML
    private Label gaPct;
    @FXML
    private Label vSeatSold;
    @FXML
    private Label gSeatSold;
    @FXML
    private Label sSeatSold;
    @FXML
    private Label bSeatSold;
    @FXML
    private Label gaSeatSold;
    @FXML
    private Label vSeatRem;
    @FXML
    private Label gSeatRem;
    @FXML
    private Label sSeatRem;
    @FXML
    private Label bSeatRem;
    @FXML
    private Label gaSeatRem;
    @FXML
    private Label revenue;
    @FXML
    private Label profit;
    @FXML
    private Label totalSeats;
    @FXML
    private Label totSeatRem;
    private final EventDaoImplementation dao = new EventDaoImplementation();

    private Event selectedEvent;

    public ModifyGUI() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setValues();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        editable();
    }

    /**
     * Used to create an observable list from TicketMiner.TicketMiner.Event.EventList ArrayList to display events on table
     * @return observableList of events for tableview
     */

    private ObservableList<Event> getEvents() throws SQLException {
        return FXCollections.observableArrayList(dao.getEvents());
    }

    /**
     * When called will set each table column to display the desired TicketMiner Event information
     */
    private void setValues() throws SQLException {
        eventID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        eventName.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventType.setCellValueFactory(new PropertyValueFactory<>("type"));
        eventDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        eventTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        venueName.setCellValueFactory(new PropertyValueFactory<>("VenueName"));
        vipPrc.setCellValueFactory(new PropertyValueFactory<>("vipPrc"));
        gldPrc.setCellValueFactory(new PropertyValueFactory<>("gldPrc"));
        slvrPrc.setCellValueFactory(new PropertyValueFactory<>("slvrPrc"));
        brnzPrc.setCellValueFactory(new PropertyValueFactory<>("brnzPrc"));
        gaPrc.setCellValueFactory(new PropertyValueFactory<>("gaPrc"));
        fWorks.setCellValueFactory(new PropertyValueFactory<>("Fireworks"));
        table.setItems(getEvents());
        table.setOnMouseClicked((MouseEvent event)->{
            if(event.getClickCount() > 0){
                select();
            }
        });
    }

    /**
     * When called will set tableview columns to be editable
     */
    private void editable(){
        table.setEditable(true);
        eventName.setCellFactory(TextFieldTableCell.forTableColumn());
        eventType.setCellFactory(TextFieldTableCell.forTableColumn());
        eventDate.setCellFactory(TextFieldTableCell.forTableColumn());
        eventTime.setCellFactory(TextFieldTableCell.forTableColumn());
        venueName.setCellFactory(TextFieldTableCell.forTableColumn());
        vipPrc.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
        gldPrc.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
        slvrPrc.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
        brnzPrc.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
        gaPrc.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
        fWorks.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
    }

    /**
     * Defines action taken when the back button is pressed on this screen
     * @param event
     * @throws IOException
     */
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        scene = new Scene(FXMLLoader.load(getClass().getResource("/AdminPanelGUI.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    /**
     * accepts selected cell on table and changes event name if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeEventName(TableColumn.CellEditEvent editedCell) {
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setName(editedCell.getNewValue().toString());
    }
    /**
     * accepts selected cell on table and changes the event type if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeType(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setType(editedCell.getNewValue().toString());
    }
    /**
     * accepts selected cell on table and changes date if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeDate(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setDate(editedCell.getNewValue().toString());
    }
    /**
     * accepts selected cell on table and changes time if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeTime(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setTime(editedCell.getNewValue().toString());
    }
    /**
     * accepts selected cell on table and changes Venue name if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeVenueName(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setVenueName(editedCell.getNewValue().toString());
    }
    /**
     * accepts selected cell on table and changes vip price if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeVIP(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setVipPrc((BigDecimal) editedCell.getNewValue());
    }
    /**
     * accepts selected cell on table and changes gold price if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeGld(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setGldPrc((BigDecimal) editedCell.getNewValue());
    }
    /**
     * accepts selected cell on table and changes silver price if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeSlvr(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setSlvrPrc((BigDecimal) editedCell.getNewValue());
    }
    /**
     * accepts selected cell on table and changes bronze price if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeBrnz(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setBrnzPrc((BigDecimal) editedCell.getNewValue());
    }
    /**
     * accepts selected cell on table and changes general admission price if user inputs new info into cell.
     * @param editedCell
     */
    @FXML
    private void changeGa(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setGaPrc((BigDecimal) editedCell.getNewValue());
    }
    /**
     * accepts selected cell on table and changes fireworks to true or false on user input.
     * @param editedCell
     */
    @FXML
    private void changeFworks(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setfWorks((Boolean)editedCell.getNewValue());
    }
    private void select(){
        setSeatPct();
        setSeatSold();
        setSeatRem();
        setTotals();
    }
    private void setSeatPct(){
        if(table.getSelectionModel().getSelectedItem() != null){
            selectedEvent = table.getSelectionModel().getSelectedItem();
            vPct.setText(Integer.toString(selectedEvent.getVipPct()));
            gPct.setText(Integer.toString(selectedEvent.getGoldPct()));
            sPct.setText(Integer.toString(selectedEvent.getSlvrPct()));
            bPct.setText(Integer.toString(selectedEvent.getBrnzPct()));
            gaPct.setText(Integer.toString(selectedEvent.getGaPct()));
        }
    }
    private void setSeatSold(){
        if(table.getSelectionModel().getSelectedItem() != null){
            selectedEvent = table.getSelectionModel().getSelectedItem();
            vSeatSold.setText(Integer.toString(selectedEvent.getVipQuant()));
            gSeatSold.setText(Integer.toString(selectedEvent.getGoldQuant()));
            sSeatSold.setText(Integer.toString(selectedEvent.getSlvrQuant()));
            bSeatSold.setText(Integer.toString(selectedEvent.getBrnzQuant()));
            gaSeatSold.setText(Integer.toString(selectedEvent.getGaQuant()));
            totalSeats.setText(Integer.toString(selectedEvent.getTotalSeatSold()));
        }
    }
    private void setSeatRem(){
        if(table.getSelectionModel().getSelectedItem() != null){
            selectedEvent = table.getSelectionModel().getSelectedItem();
            vSeatRem.setText(Integer.toString(selectedEvent.getVIPSeatRem()));
            gSeatRem.setText(Integer.toString(selectedEvent.getGoldSeatRem()));
            sSeatRem.setText(Integer.toString(selectedEvent.getSlvrSeatRem()));
            bSeatRem.setText(Integer.toString(selectedEvent.getBrnzSeatRem()));
            gaSeatRem.setText(Integer.toString(selectedEvent.getGaSeatRem()));
            totSeatRem.setText(Integer.toString(selectedEvent.getSeatsLeft()));
        }
    }
    private void setTotals(){
        if(table.getSelectionModel().getSelectedItem() != null){
            selectedEvent = table.getSelectionModel().getSelectedItem();
            revenue.setText(selectedEvent.getRevenue().toString());
            profit.setText(selectedEvent.getProfit().toString());
        }
    }
    @FXML
    private void delete(){
        EventDaoImplementation dao = new EventDaoImplementation();
        if(table.getSelectionModel().getSelectedItem() != null){
            selectedEvent = table.getSelectionModel().getSelectedItem();
            try {
                dao.delete(selectedEvent.getID());
            }catch(SQLException e){
                System.out.println("Cannot delete");
            }
        }
    }
}
