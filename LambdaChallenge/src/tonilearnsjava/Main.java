package tonilearnsjava;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printTheParts = (String s) -> Arrays.stream(s.split(" ")).forEach(word -> System.out.println(word));
        printTheParts.accept("The heights to which great men reached and kept was not attained in sudden flight but they while their companions slept were toiling upwards in the night");

        Function<String, String> everySecondChar = s -> {
            StringBuilder  returnVal = new StringBuilder();
            for(int i = 0 ; i < s.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println("-----------------");
        System.out.println(everySecondChar.apply("1234567890"));

        System.out.println("-----------------");
        System.out.println(everySecondCharacter(everySecondChar, "1234567890"));

        Supplier<String> iLoveJava = () -> "I Love Java!";

        var supplyResult = iLoveJava.get();

        System.out.println(supplyResult);
    }

    public static <T,R> R everySecondCharacter(Function<T, R> func, T source){
        return func.apply(source);
    }
}
