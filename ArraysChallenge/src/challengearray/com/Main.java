package challengearray.com;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//    System.out.println("Minimum Value In The Arrays is "+ findMin(readIntegers()));
    reverse(readIntegers());
    }

    public static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Elements of Your Array Separated By A Comma");
        String string = scanner.nextLine();
        String[] arrayString = string.split(",");
        System.out.println(Arrays.toString(arrayString));
        int[] integerArray = new int[arrayString.length];

        for (int  i = 0; i < integerArray.length;  i++){
            integerArray[i] = Integer.parseInt(arrayString[i].trim());
        }
        return integerArray;
    }

    public static int findMin(int... args){
        Arrays.sort(args);
        return args[0];
    }

    public static  void reverse(int[] array){
        System.out.println("Array: "+ Arrays.toString(array));
        int[] reversedArray = new int[array.length];
        for (int i  = array.length-1; i >= 0 ; i--){
            reversedArray[array.length  - (i + 1)] = array[i];
        }
        System.out.println("Reversed Array: "+ Arrays.toString(reversedArray));
    }
}
