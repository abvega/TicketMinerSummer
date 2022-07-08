package TicketMiner;
/**
 * Controller class for welcomeScreenGUI
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class GUIFrame {

    private final int WINDOW_WIDTH = 750;
    private final int WINDOW_HEIGHT = 500;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * When exit button is pressed, program terminates
     */
    public void close(){
        System.exit(0);
    }

    /**
     * When start button is pressed, this method changes scene to main menu
     * @param event
     * @throws IOException
     */
    public void start(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/MainMenuGUI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
    }
}

