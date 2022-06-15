import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    public void close(ActionEvent event){
        System.exit(0);
    }

    public void start(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainMenuGUI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
    }
}

