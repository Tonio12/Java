public class StringMethods {
    public static void main(String[] args) {
        String birthDate = "25/11/1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("Starting Index = " +startingIndex);
        System.out.println("Birth year = "+birthDate.substring(startingIndex));

        System.out.println("Month = "+birthDate.substring(3,5));

        String newDate = String.join("/", "25","11","2000");
        System.out.println("newDate = "+newDate);

        System.out.println(newDate.replace('/','-'));
        System.out.println(newDate.replace("2","00"));

        System.out.println(newDate.replaceFirst("/","-"));
        System.out.println(newDate.replaceAll("/","---"));
    }
}
