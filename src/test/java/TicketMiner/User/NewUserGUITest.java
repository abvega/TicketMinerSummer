package TicketMiner.User;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.assertj.core.api.Assertions;
import org.junit.After;

import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;


public class NewUserGUITest extends ApplicationTest {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/NewUserGUI.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
    @Test
    public void tenKTest(){
        clickOn("#tenK");
        sleep(5000);
    }
    @Test
    public void passWordCheckTest(){
        clickOn("#passWord").write("password1");
        clickOn("#confirmPass").write("password2");
        clickOn("#create");
        sleep(5000);
    }
    @Test
    public void makeUserTest(){
        clickOn("#firstName").write("chev");
        clickOn("#lastName").write("chelios");
        clickOn("#userName").write("crankJunkie");
        clickOn("#passWord").write("dontstop1");
        clickOn("#confirmPass").write("dontstop1");
        clickOn("#create");
        sleep(5000);
    }
}