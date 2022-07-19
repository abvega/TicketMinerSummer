import TicketMiner.Dao.UserDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserDao {
    @Test
    public void testGetUser() throws SQLException {
        UserDao user = new UserDao();
        assertEquals("alexvega",user.getUser("alexvega").getUserName());
    }
    @Test
    public void testAuth() throws SQLException{
        UserDao user = new UserDao();
        assertTrue(user.authenticate("alexvega", "Fun!23"));
    }
    @Test
    public void testAuthFalse()throws SQLException{
        UserDao user = new UserDao();
        assertFalse(user.authenticate("johnnybravo", "heymomma"));
    }

}
