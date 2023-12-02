import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayOne {
    private static final String[][] NUM_ARR = {
            { "one", "one1one" },
            { "two", "two2two" },
            { "three", "t3e" },
            { "four", "f4r" },
            { "five", "f5e" },
            { "six", "s6x" },
            { "seven", "s7n" },
            { "eight", "e8t" },
            { "nine", "n9e" }
    };
    Scanner lines;
    Pattern re;

    DayOne(Scanner lineData) {
        this.lines = lineData;
        this.re = Pattern.compile("\\d");
    }

    public static void main(String[] args) throws Exception {
        try {
            File file = new File("../inputs/day_one.txt");

            DayOne day_one_1 = new DayOne(new Scanner(file));
            System.out.println(day_one_1.part_one());

            DayOne day_one_2 = new DayOne(new Scanner(file));
            System.out.println(day_one_2.part_two());

        } catch (FileNotFoundException e) {
            System.err.println("An error Occurred!");
            e.printStackTrace();
        }
    }

    public int part_one() {
        int sum = 0;
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            sum += calibration_value(line);
        }
        return sum;
    }

    public int part_two() {
        int sum = 0;

        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            String newLine = line;

            for (String[] pattern : NUM_ARR) {
                newLine = newLine.replace(pattern[0], pattern[1]);
            }

            sum += calibration_value(newLine);
        }
        return sum;
    }

    private int calibration_value(String line) {
        Matcher matches = re.matcher(line);

        List<String> digits = new ArrayList<String>();
        while (matches.find()) {
            digits.add(matches.group());
        }

        return Integer.parseInt(digits.getFirst() + digits.getLast());
    }
}
