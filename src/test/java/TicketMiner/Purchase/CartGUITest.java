package TicketMiner.Purchase;

import TicketMiner.Dao.EventDaoImplementation;
import TicketMiner.Dao.UserDao;
import TicketMiner.Event.Event;
import TicketMiner.User.User;
import TicketMiner.User.UserGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class CartGUITest extends ApplicationTest {
    User user;
    Event event;
    @Override
    public void start(Stage stage) throws Exception {
        EventDaoImplementation eDao = new EventDaoImplementation();
        UserDao uDao = new UserDao();
        user = uDao.getUser("alexvega");
        event = eDao.getEvent(59);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CartGUI.fxml"));
        stage.setScene(new Scene(loader.load()));
        CartGUI gui = loader.getController();
        gui.setUser(user);
        gui.setEvent(event);
        gui.setQuants(5,10,15,20,25);
        gui.setPrices(100,100,100,100,100);
        stage.show();
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
    @Test
    public void test(){
        sleep(5000);
        clickOn("#confirm");
    }
}