package tonilearnsjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) {
        String[] names = {"josEph", "bob", "raSHEEda", "anTOnio", "huBERT",  "WistON"};
        List<UnaryOperator<String>> operations = new ArrayList<>(List.of(String::toUpperCase, s -> s + " "  +  (char)(random.nextInt(65, 91)), Main::invertString));
        applyOperations(operations,names);

    }

    private static String invertString (String original){
        StringBuilder tempBuilder =  new StringBuilder();
        tempBuilder.append(original.split(" ")[0]);
        return original + " " + tempBuilder.reverse().toString();
    }

    private static void removeStrings(String[] source){
        List<String> names = new ArrayList<>(List.of(source));
        names.removeIf(s -> s.split(" ")[0].equals(s.substring(s.lastIndexOf(" ") + 1)));
        System.out.println(names);
    }

    public static void applyOperations(List<UnaryOperator<String>> operations, String[] names){
        for(var operation : operations){
            Arrays.setAll(names, i -> operation.apply(names[i]));
            System.out.println(Arrays.toString(names));
        }
        removeStrings(names);
    }

}
