package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginGenerator loginGenerator;

    @Before
    public void setUp() throws Exception {
        String[] start = new String[]{ "JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"};
        loginGenerator = new LoginGenerator(new LoginService(start));
    }

    @Test
    public void generateLoginForNomAndPrenom() throws Exception {
        String login = loginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        assertEquals("PDUR",login);
    }

    @Test
    public void generateLoginForJRAL2() throws Exception {
        String login = loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        assertEquals("JRAL2",login);
    }

    @Test
    public void loginPDUR2() {
        String login = loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertEquals("PDUR",login);
    }

    @Test
    public void loginJROLNumber() {
        String login = loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean");
        assertEquals("JROL1",login);
    }

}