import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i=0;
        double  sum  = 0;
        while(i < 5){
             System.out.println("Enter number #" + (i+1)  + ":");
            String entry = scanner.nextLine();
            try {
                double num = Double.parseDouble(entry);
                sum += num;
                i++;
            }catch (NumberFormatException e) {
                System.out.println("Input Not Recognised.");
                System.out.println("Enter An Integer.");
            }
        }
        System.out.println("Total: "+sum);
    }
}
