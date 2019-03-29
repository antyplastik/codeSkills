package validators;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;
//import org.testng.annotations.Test;
import org.junit.*;

import static org.testng.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class EmailValidatorTest {

    private Validator emailValidator = new EmailValidator();

    @Test
    @Parameters(method = "testStrings")
    public void testValidate(String testString, boolean expected) {
        assertEquals(emailValidator.validate(testString), expected);
    }

    public Object[] testStrings() {
        return new Object[]{
                new Object[]{"test@test.com", true},
                new Object[]{"test12@test.com", true},
                new Object[]{"teST@test.hr", true},
                new Object[]{"test@test.pl", true},
                new Object[]{"tes$#@t@test.com", false},

        };
    }
}