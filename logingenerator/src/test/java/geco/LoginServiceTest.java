package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private static final String login1 = "login1";
    private static final String login2 = "login2";
    private LoginService loginService;

    @Before
    public void setUp() throws Exception {
        String [] loginExistants = new String[2];
        loginExistants[0] = login1;
        loginService = new LoginService(loginExistants);
    }

    @Test
    public void loginExists() throws Exception {
        assertTrue(loginService.loginExists(login1));
        assertFalse(loginService.loginExists(login2));
    }

    @Test
    public void addLogin() throws Exception {
        String loginAjout1 = new String("loginTest1");
        String loginAjout2 = new String("loginTest2");
        loginService.addLogin(loginAjout1);
        loginService.addLogin(loginAjout2);
        assertTrue(loginService.loginExists(loginAjout1));
        assertTrue(loginService.loginExists(loginAjout2));
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        List<String> LoginsStartingWith = loginService.findAllLoginsStartingWith("l");
        assertEquals(1, LoginsStartingWith.size());
        loginService.addLogin("login3");
        LoginsStartingWith = loginService.findAllLoginsStartingWith("l");
        assertEquals(2, LoginsStartingWith.size());
        LoginsStartingWith = loginService.findAllLoginsStartingWith("f");
        assertEquals(0, LoginsStartingWith.size());
    }

    @Test
    public void findAllLogins() throws Exception {
        List<String> allLogins = loginService.findAllLogins();
        assertEquals(1, allLogins.size());
        loginService.addLogin("login3");
        loginService.addLogin("login4");
        allLogins = loginService.findAllLogins();
        assertEquals(3, allLogins.size());
    }

}