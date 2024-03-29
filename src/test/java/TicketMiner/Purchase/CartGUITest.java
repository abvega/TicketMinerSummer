package TicketMiner.Purchase;

import TicketMiner.Dao.EventDaoImplementation;
import TicketMiner.Dao.UserDao;
import TicketMiner.Event.Event;
import TicketMiner.User.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

public class CartGUITest extends ApplicationTest {
    User user;
    Event event;
    @Override
    public void start(Stage stage) throws Exception {
        EventDaoImplementation eDao = new EventDaoImplementation();
        UserDao uDao = new UserDao();
        user = uDao.getUser("test");
        event = eDao.getEvent(59);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CartGUI.fxml"));
        stage.setScene(new Scene(loader.load()));
        CartGUI gui = loader.getController();
        gui.setUser(user);
        gui.setEvent(event);
        gui.setQuants(1,1,1,1,1);
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
        clickOn("#confirm");
        sleep(10000);
    }
}