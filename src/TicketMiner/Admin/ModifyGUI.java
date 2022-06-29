package TicketMiner.Admin;

import TicketMiner.Event.Event;
import TicketMiner.Event.EventList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Controller class for modifyGUI fxml
 */
public class ModifyGUI implements Initializable {
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
    private TableColumn<Event,Double> vipPrc;
    @FXML
    private TableColumn<Event,Double> gldPrc;
    @FXML
    private TableColumn<Event,Double> slvrPrc;
    @FXML
    private TableColumn<Event,Double> brnzPrc;
    @FXML
    private TableColumn<Event,Double> gaPrc;
    @FXML
    private TableColumn<Event,Boolean> fWorks;

    private EventList eventList = EventList.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setValues();
        editable();
    }

    /**
     * Used to create an observable list from TicketMiner.TicketMiner.Event.EventList ArrayList to display events on table
     * @return observableList of events for tableview
     */

    private ObservableList<Event> getEvents(){
        return FXCollections.observableArrayList(eventList.getArrayList());
    }

    /**
     * When called will set each table column to display the desired TicketMiner.TicketMiner.Event.Event information
     */
    private void setValues(){
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
        vipPrc.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        gldPrc.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        slvrPrc.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        brnzPrc.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        gaPrc.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        fWorks.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
    }
    public void goBack(ActionEvent event) throws IOException {
        scene = new Scene(FXMLLoader.load(getClass().getResource("AdminPanelGUI.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    public void changeEventName(TableColumn.CellEditEvent editedCell) {
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setName(editedCell.getNewValue().toString());
    }
    public void changeType(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setType(editedCell.getNewValue().toString());
    }
    public void changeDate(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setDate(editedCell.getNewValue().toString());
    }
    public void changeTime(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setTime(editedCell.getNewValue().toString());
    }
    public void changeVIP(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setVipPrc((Double)editedCell.getNewValue());
    }
    public void changeGld(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setGldPrc((Double)editedCell.getNewValue());
    }
    public void changeSlvr(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setSlvrPrc((Double)editedCell.getNewValue());
    }
    public void changeBrnz(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setBrnzPrc((Double)editedCell.getNewValue());
    }
    public void changeGa(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setGaPrc((Double)editedCell.getNewValue());
    }
    public void changeFworks(TableColumn.CellEditEvent editedCell){
        Event eventSelected = table.getSelectionModel().getSelectedItem();
        eventSelected.setfWorks((Boolean)editedCell.getNewValue());
    }
}
