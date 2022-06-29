import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginGUI {
    @FXML
    private TextField userName;
    @FXML
    private TextField passWord;
    @FXML
    private Button login;
    @FXML
    private Button back;
    @FXML
    private Button newUser;
    private Scene scene;
    private Stage stage;
    private UserList users = UserList.getInstance();

    public void goBack(ActionEvent event) throws IOException {
        scene = new Scene(FXMLLoader.load(getClass().getResource("MainMenuGUI.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    public void login(ActionEvent event) throws IOException {
        if(checkCreds(userName.getText(), passWord.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("UserGUI.fxml"));
            Parent tableParent = loader.load();
            Scene scene = new Scene(tableParent);
            UserGUI userGUI = loader.getController();
            userGUI.setUser(userName.getText());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.WARNING, "Username and/or password do not exist");
        alert.show();
    }
    private boolean checkCreds(String userName, String passWord){
        if(!users.userExist(userName) || !users.getUser(userName).getPassWord().equals(passWord)){
            return false;
        }
        return true;
    }
}
