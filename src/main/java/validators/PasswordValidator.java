package validators;

import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class PasswordValidator implements Validator {

    private Integer minLen = 8;
    private String illicitSpecialChars = "[<,!^$`~]";

    public boolean validate(String input) {
        return checkLenght(input)
                && checkUppercase(input)
                && checkLowercase(input)
                && checkNumber(input)
                && checkIllicitSpecialChar(input);
    }

    private boolean checkLenght(String string) {
        if(string.length() >= minLen)
            return true;
        else
            return false;
//        return string.length() >= minLen ? true : false;
    }

    private boolean checkUppercase(String string) {
        if(regexTest(string, "[A-Z]"))
            return true;
        else
            return false;
//        return regexTest(string, "[A-Z]");
    }

    private boolean checkLowercase(String string) {
        if(regexTest(string, "[a-z]"))
            return true;
        else
            return false;
//        return regexTest(string, "[a-z]");
    }

    private boolean checkNumber(String string) {
        if(regexTest(string, "[0-9]"))
            return true;
        else
            return false;
//        return regexTest(string, "[0-9]");
    }

    private boolean checkIllicitSpecialChar(String string) {
        return !regexTest(string, illicitSpecialChars);
    }

    private boolean regexTest(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find() ? true : false;
    }
}
