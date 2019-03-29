import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generateTriangleString(10, 1, "\n"));
    }

    public static List<String> generateTriangleList(final Integer levels, final Integer value, final String endLineRegex) {
        return generateTriangle(levels, value, endLineRegex);
    }

    public static String generateTriangleString(final Integer levels, final Integer value, final String endLineRegex) {
        return generateTriangle(levels, value, endLineRegex).stream().collect(Collectors.joining());
    }

    private static List<String> generateTriangle(final Integer levels, final Integer value, final String endLineRegex) {
        String result = "";
        List<String> resultList = new ArrayList<>();

        List<Integer> prev = new ArrayList<>();

        for (int row = 0; row < levels; row++) {

            List<Integer> actual = new ArrayList<>();

            for (int col = 0; col < row + 1; col++) {
                if (col == 0 | col == row | row == 0 | row == 1)
                    actual.add(value);

                else {
                    Integer val1 = prev.get(col - 1);
                    Integer val2 = 0;

                    if (prev.size() <= row + 1)
                        val2 = prev.get(col);

                    Integer sum = val1 + val2;
                    actual.add(sum);
                }
            }

            prev = actual;
//            result = result + getLine(prev, endLineRegex);
            resultList.add(getLine(prev,endLineRegex));
        }

        return resultList;
    }


    private static String getLine(final List<Integer> stringList, final String endLineRegex) {
        String result = "";

        for (Integer integer : stringList)
            result = result + "\t" + integer;

        result = result.replaceFirst("^.", "");
        return result + endLineRegex;
    }

}
