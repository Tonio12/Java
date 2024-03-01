import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String challenge1 = "I want a bike";
        String challenge2 = "I want a ball";
        System.out.println(challenge1.matches("^I.+?bike$"));

        String regEx = "I want a .*";
        System.out.println(challenge1.matches(regEx));
        System.out.println(challenge2.matches(regEx));

        Pattern pattern = Pattern.compile("I want a \\w+.");
        Matcher matcher = pattern.matcher(challenge1);

        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscore";
        System.out.println(challenge4.replaceAll("\\s",  "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("^(aaa)bc+d{3}ef{3}g$"));

        String challenge6 = "abcd.123";
        System.out.println(challenge6.matches("^[a-zA-z]+.[0-9]+$"));

        String challenge7 = "abcd.123ubqz.7tzik.999";
        Pattern pattern1 = Pattern.compile("([a-zA-z]+.[0-9]+)");
        Matcher matcher1 = pattern1.matcher(challenge7);

        while (matcher1.find()){
            System.out.println("Occurrence: " + matcher1.group(1) + " First at " + matcher1.start() + " to " + matcher1.end());
        }

        String challenge11 = "{0,2}, {0,5}, {1,3}, {2,4}";
        Pattern pattern2 = Pattern.compile("(\\d+,\\d+)");
        Matcher matcher2 = pattern2.matcher(challenge11);

        while (matcher2.find()){
            System.out.println("Occurrence: " + matcher2.group(1));
        }

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));
    }
}
