package TicketMiner;

import TicketMiner.Dao.UserDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RunTicketMiner extends Application{
        public static void main(String[] args){
            launch(args);
        }
        @Override
        public void start(Stage primaryStage){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/WelcomeScreen.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.sizeToScene();
                primaryStage.show();
                UserDao dao = new UserDao();
                System.out.println(dao.getUser("test"));
            }catch(IOException | SQLException e){
                e.printStackTrace();
            }
        }
    }

