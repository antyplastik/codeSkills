import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PinValidator {

    /*
    ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.

If the function is passed a valid PIN string, return true, else return false.

eg:

Solution.validatePin("1234") === true
Solution.validatePin("12345") === false
Solution.validatePin("a234") === false
     */

    public static void main(String[] args) {

    }

    public static boolean validate(String pinToValidate) {
        boolean result = false;

        if (isCorrectFormat(pinToValidate))

            if (isDigit(pinToValidate))

                if (pinLength(pinToValidate))
                    result = true;
                else
                    System.out.println(String.format("%s has incorrect length", pinToValidate));
            else
                System.out.println(String.format("%s is not a digit", pinToValidate));
        else
            System.out.println(String.format("%s has incorrect format", pinToValidate));


        return result;
    }

    private static boolean isCorrectFormat(String value) {
        boolean result = false;
        Pattern pattern = Pattern.compile("^([\\d]{4})|([\\d]{6})$");
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches())
            result = true;

        return result;
    }

    private static boolean isDigit(String value) {
        Integer val = Integer.valueOf(value);
        boolean result = false;

        if (val >= 0)
            result = true;

        return result;
    }

    private static boolean pinLength(String value) {
        Integer pinLen = value.length();
        boolean result = false;

        if (pinLen == 4 || pinLen == 6)
            result = true;

        return result;
    }

}
