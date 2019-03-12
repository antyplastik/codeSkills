import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PinValidatorTest {
    @Test
    public void validPins() {
        assertEquals(true, PinValidator.validate("1234"));
        assertEquals(true, PinValidator.validate("0000"));
        assertEquals(true, PinValidator.validate("1111"));
        assertEquals(true, PinValidator.validate("123456"));
        assertEquals(true, PinValidator.validate("098765"));
        assertEquals(true, PinValidator.validate("000000"));
        assertEquals(true, PinValidator.validate("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertEquals(false, PinValidator.validate("a234"));
        assertEquals(false, PinValidator.validate(".234"));
    }

    @Test
    public void invalidLengths() {
        assertEquals(false, PinValidator.validate("1"));
        assertEquals(false, PinValidator.validate("12"));
        assertEquals(false, PinValidator.validate("123"));
        assertEquals(false, PinValidator.validate("12345"));
        assertEquals(false, PinValidator.validate("1234567"));
        assertEquals(false, PinValidator.validate("-1234"));
        assertEquals(false, PinValidator.validate("1.234"));
        assertEquals(false, PinValidator.validate("00000000"));
    }
}