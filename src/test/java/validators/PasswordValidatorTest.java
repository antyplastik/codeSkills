package validators;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;
//import org.testng.annotations.Test;
import org.junit.*;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

    private Validator passwordValidator = new PasswordValidator();

    @Test
    @Parameters(method = "testStrings")
    public void testValidate(String testString, boolean expected) {
        Assert.assertEquals(passwordValidator.validate(testString), expected);
    }

    public Object[] testStrings() {
        return new Object[]{
                new Object[]{"jei*3Xqw", true},
                new Object[]{"test12@test.com", false},
                new Object[]{"teST@test.hr", false},
                new Object[]{"t3St4$", false},
                new Object[]{"tes$#^t@test.com", false},
        };
    }
}