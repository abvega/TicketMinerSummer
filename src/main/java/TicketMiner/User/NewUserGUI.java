package TicketMiner.User;

import TicketMiner.Dao.UserDao;
import TicketMiner.MainMenuGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Optional;

public class NewUserGUI {
    private UserDao dao = new UserDao();
    @FXML
    private Button tenK;
    @FXML
    private Button create;
    @FXML
    private TextField monies;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField passWord;
    @FXML
    private TextField confirmPass;
    @FXML
    private TextField userName;

    @FXML
    private void addMonies(){
        monies.setText(Integer.toString(10000));
    }
    @FXML
    private void makeUser() throws SQLException, IOException {
        if(!confirmPass.getText().equals(passWord.getText())){
            createAlert("passwords do not match", "Check inputs and verify passwords match before continuing.");
        }
        else {
            User user = new User(firstName.getText(), lastName.getText(),
                    new BigDecimal(monies.getText()), false, userName.getText(), passWord.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Creating new User: ");
            alert.setContentText(user.returnUser());
            Optional<ButtonType> result = alert.showAndWait();
            ButtonType selected = result.orElse(null);
            if(selected == ButtonType.OK){
                //dao.add(user);
            }
            else if(selected == ButtonType.CANCEL){

            }
        }
    }
    private void createAlert(String header, String body){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(header);
        alert.setContentText(body);
        alert.show();
    }
}
