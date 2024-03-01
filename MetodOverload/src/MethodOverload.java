public class MethodOverload {
    public static double convertToCentimeters(int inches){
        return (double)(inches * 2.54);
    }

    public static double convertToCentimeters(int feet, int inches){
        int totalInches = feet * 12 + inches;
        return (double)(totalInches * 2.54);
    }

    public static void main(String[] args) {
        System.out.println(convertToCentimeters(68));
        System.out.println(convertToCentimeters(5, 8));
    }

}
