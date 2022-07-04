package TicketMiner.Admin;
/**
 * Controller class for AdminPanelGUI
 */

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
    private Scene scene;
    private Stage stage;
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 350;

    /**
     * Method changes scene to create new event function
     * @param event
     * @throws IOException
     */
    public void createNew(ActionEvent event) throws IOException {
       scene = new Scene(FXMLLoader.load(getClass().getResource("CreateNewGUI.fxml")));
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.sizeToScene();
       stage.show();
    }

    /**
     * Changes scene to be able to modify certain events.
     * @param event
     * @throws IOException
     */
    public void modify(ActionEvent event)throws IOException{
        scene = new Scene(FXMLLoader.load(getClass().getResource("ModifyGUI.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    /**
     * Changes scene to previous scene.
     * @param event
     * @throws IOException
     */
    public void goBack(ActionEvent event)throws IOException{
        scene = new Scene(FXMLLoader.load(getClass().getResource("../MainMenuGUI.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
