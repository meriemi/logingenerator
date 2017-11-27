package geco;

import java.security.SecureRandom;

public class PasswordGeneration {
    static final String LOGIN_BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom sec = new SecureRandom();
    static final int len = 8;

    public String getRandomPassword(){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( LOGIN_BASE.charAt( sec.nextInt(LOGIN_BASE.length()) ) );
        return sb.toString();
    }
}
