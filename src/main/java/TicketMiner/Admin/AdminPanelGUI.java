package TicketMiner.Admin;
/**
 * Controller class for AdminPanelGUI
 */

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPanelGUI {
    @FXML
    private Label myLabel;
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 350;

    /**
     * Method changes scene to create new event function
     * @param event
     * @throws IOException
     */
    @FXML
    private void createNew(ActionEvent event) throws IOException {
       Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/CreateNewGUI.fxml")));
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.sizeToScene();
       stage.show();
    }

    /**
     * Changes scene to be able to modify certain events.
     * @param event
     * @throws IOException
     */
    @FXML
    private void modify(ActionEvent event)throws IOException{
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/ModifyGUI.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    /**
     * Changes scene to previous scene.
     * @param event
     * @throws IOException
     */
    @FXML
    private void goBack(ActionEvent event)throws IOException{
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/MainMenuGUI.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    @FXML
    private void modifyUser(ActionEvent event) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/ModifyUserGUI.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
