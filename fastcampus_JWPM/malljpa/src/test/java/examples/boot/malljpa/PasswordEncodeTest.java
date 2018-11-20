package examples.boot.malljpa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeTest {
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() throws Exception{
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Test
    public void passwordEncoder() throws Exception{
        String encoder = passwordEncoder.encode("1234");
        System.out.println(encoder);

        boolean matches = passwordEncoder.matches("1234", "{bcrypt}$2a$10$.Jgr.Ul6C4usgmuJJ4dmNuwUz16d6T58UiZiU10W.doLhXVqJDLHW");
        Assert.assertTrue(matches);
    }
}
