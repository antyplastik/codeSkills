package validators;

import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class EmailValidator implements Validator {

    public boolean validate(String input) {
        String result;
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9]{1,}[@][a-zA-Z0-9]{1,}[.][a-zA-Z]{1,4})");
        Matcher matcher = pattern.matcher(input);

        return matcher.find() ? true : false;
    }
}
