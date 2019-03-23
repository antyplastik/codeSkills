import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.print(generateTriangle(10, 1, "\n"));
    }

    public static String generateTriangle(final Integer levels, final Integer value, final String endLineRegex) {
        String result = "";

        List<Integer> prev = new ArrayList<>();

        for (int row = 0; row < levels; row++) {

            List<Integer> actual = new ArrayList<>();

            for (int col = 0; col < row + 1; col++) {
                if (col == 0 | col == row | row == 0 | row == 1)
                    actual.add(value);

                else {
                    Integer val1 = prev.get(col -1);
                    Integer val2 = 0;

                    if (prev.size() <= row + 1)
                        val2 = prev.get(col);

                    Integer sum = val1 + val2;
                    actual.add(sum);
                }
            }

            prev = actual;
            result = result + getLine(prev, endLineRegex);
        }

        return result;
    }


    private static String getLine(List<Integer> stringList, String endLineRegex) {
        String result = "";

        for (Integer integer : stringList)
            result = result + "\t" + integer;

        result = result.replaceFirst("^.","");
        return result + endLineRegex;
    }

}
