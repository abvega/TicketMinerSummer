package TicketMiner.User;
/**
 * Controller class for LoginGUI
 */

import TicketMiner.Dao.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginGUI {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passWord;
    @FXML
    private Button login;
    @FXML
    private Button back;
    @FXML
    private Button newUser;
    private UserDao users = new UserDao();

    public void goBack(ActionEvent event) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/MainMenuGUI.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    public void login(ActionEvent event) throws IOException, SQLException {
        if(checkCreds(userName.getText(), passWord.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/UserGUI.fxml"));
            Parent tableParent = loader.load();
            Scene scene = new Scene(tableParent);
            UserGUI userGUI = loader.getController();
            userGUI.setUser(userName.getText());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.WARNING, "Username and/or password do not exist");
        alert.show();
    }
    private boolean checkCreds(String userName, String passWord)throws SQLException{
        return users.authenticate(userName, passWord);
    }
    @FXML
    private void newUser(ActionEvent event) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/NewUserGUI.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
