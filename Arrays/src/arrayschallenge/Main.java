package arrayschallenge;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] myArray = new int[10];
        Random random = new Random();

        for(int i = 0;  i < myArray.length;  i++){
            myArray[i] = random.nextInt(100);
        }

        System.out.printf("Unsorted Array: %s%n", Arrays.toString(myArray));


        for(int i = 0; i < myArray.length; i++){
            for (int j = i+1; j < myArray.length; j++){
                if(myArray[j] > myArray[i]){
                    int temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }else {
                    continue;
                }
            }
        }
        System.out.printf("Descending Array: %s%n", Arrays.toString(myArray));
    }
}
