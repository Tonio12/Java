package tonilearnsjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static Random Random = new Random();

    public static void main(String[] args) {
        String[] firstNames = {"josEpH", "rasHeeDA", "HuBerT", "mIkE", "bEnEdiCta", "miRabel", "wINSton", "aNNa"};
        Arrays.setAll(firstNames, i -> firstNames[i].toUpperCase());
        System.out.println(Arrays.toString(firstNames));

        Arrays.setAll(firstNames, i-> firstNames[i] + " " + (char)Random.nextInt(65,91));
        System.out.println(Arrays.toString(firstNames));

        Arrays.setAll(firstNames, i -> firstNames[i]  + " " + reverseString(firstNames[i].split(" ")[0]));
        Arrays.asList(firstNames).forEach((name)->System.out.print(name  +  ", "));

        List<String> names = new ArrayList<>(List.of(firstNames));
        names.removeIf(s -> s.split(" ")[0].equals(s.split(" ")[2]));
        System.out.println("\n" + names);
    }

    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}
