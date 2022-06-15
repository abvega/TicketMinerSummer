import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuGUI {
    private Stage stage;
    private Parent root;
    private Scene scene;
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 250;

    public void goBack(ActionEvent event) throws IOException {
        scene = new Scene(FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    public void admin(ActionEvent event) throws IOException{
        scene = new Scene(FXMLLoader.load(getClass().getResource("AdminPanelGUI.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    public void user(ActionEvent event) throws IOException{

    }
}
