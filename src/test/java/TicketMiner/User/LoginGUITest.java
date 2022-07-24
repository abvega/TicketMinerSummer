package TicketMiner.User;

import TicketMiner.RunTicketMiner;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.Assert.*;

public class LoginGUITest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/LoginGUI.fxml"));
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
    public void testLogin(){
        clickOn("#userName").write("alexvega");
        clickOn("#passWord").write("Fun!23");
        clickOn("#login");
    }
}