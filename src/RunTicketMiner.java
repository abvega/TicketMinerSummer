import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class RunTicketMiner extends Application{
        public static void main(String[] args){
            launch(args);
        }
        @Override
        public void start(Stage primaryStage) throws IOException {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
                Scene scene1 = new Scene(root);
                primaryStage.setScene(scene1);
                primaryStage.sizeToScene();
                primaryStage.show();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

