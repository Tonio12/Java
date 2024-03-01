public class EnhancedSwitch {
    public static void main(String[] args) {
        printDayOfWeek(5);
    }
    public static void printDayOfWeek(int day) {
        switch (day){
            case 0 -> System.out.println("It is a Sunday");
            case 1 -> System.out.println("It is a Monday");
            case 2 -> System.out.println("It is a Tuesday");
            case 3 -> System.out.println("It is a Wednesday");
            case 4 -> System.out.println("It is a Thursday");
            case 5 -> System.out.println("It is a Friday");
            case 6-> System.out.println("It is a Saturday");
            default -> System.out.println("Day not recognised");
        }
    }
}
