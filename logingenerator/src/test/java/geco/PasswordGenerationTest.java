package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {



    @Test
    public void getRandomPassword() throws Exception {
        String p;
        PasswordGeneration pwd = new PasswordGeneration();
        p = pwd.getRandomPassword();
        assertEquals(p.length(),8);
    }

}