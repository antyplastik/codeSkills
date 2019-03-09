import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StingArrToStr {

    /*
    You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items.
    We want to create the text that should be displayed next to such an item.

    Implement a function likes :: [String] -> String, which must take in input array, containing the names of people who like an item.
    It must return the display text as shown in the examples:

    likes {} // must be "no one likes this"
    likes {"Peter"} // must be "Peter likes this"
    likes {"Jacob", "Alex"} // must be "Jacob and Alex like this"
    likes {"Max", "John", "Mark"} // must be "Max, John and Mark like this"
    likes {"Alex", "Jacob", "Mark", "Max"} // must be "Alex, Jacob and 2 others like this"
    For 4 or more names, the number in and 2 others simply increases.
     */

    public static void main(String[] args) {
        String[] inputArr = {"1", "Agata is dietetic", "a", "kamil", "Kamil", "do you know Agata the dietetic?", "Marta i Kamil"};

        String inputStr;
        inputStr = Arrays.stream(inputArr)
                .map(e -> e + ", ")
                .collect(Collectors.joining());

        System.out.println("Input: " + inputStr);
        System.out.println("Output: " + whoLikesIt(inputArr).toString());
    }

    public static String whoLikesIt(String... names) {
        //Do your magic here
        String result;
        List<String> stringList = new ArrayList();

        int tmp;

        for (String res : names) {
            String[] strings = res.split(" ");
            for (String str : strings) {
                if (isNotDigit(str.charAt(0)) && isBigLetter(str.charAt(0)))
                    stringList.add(str);
            }
        }

//        String [] resultArr = stringList.toArray(new String[0]);
        result = stringList.stream().map(s -> s + ", ").collect(Collectors.joining());

        return result.substring(0, result.length() - 2);
    }

    private static boolean isLetter(Character c) {
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122)
            return true;
        return false;
    }

    private static boolean isNotDigit(Character c) {
        if (Character.isDigit(c))
            return false;
        return true;
    }

    private static boolean isBigLetter(Character c) {
        String character = String.valueOf(c);

        if (character.equals(character.toUpperCase()))
            return true;
        return false;
    }
}