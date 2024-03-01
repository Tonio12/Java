package tonilearnsjava;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance) { }

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var placesToVisit = new LinkedList<Place>();
        addPlace(placesToVisit, "Melbourne", 877);
        addPlace(placesToVisit, "Brisbane", 917);
        addPlace(placesToVisit, "Adelaide", 1374);
        addPlace(placesToVisit, "Alice Springs", 2771);
        addPlace(placesToVisit, "Perth", 3923);
        addPlace(placesToVisit, "Darwin", 3972);
        System.out.println(placesToVisit);

        String choice =  "";
        menu();
        do {
            System.out.print("Enter Choice: ");
             choice =  scanner.nextLine().toLowerCase();
            switch (choice.charAt(0)) {
                case 'f' -> addPlaceAtStart(placesToVisit);
                case 'b' -> addPlaceAtEnd(placesToVisit);
                case 'l' -> listPlaces(placesToVisit);
                case 'm' -> menu();
            }
        }while (choice.charAt(0) != 'q');


    }

    public static void addPlace(LinkedList<Place> list, String name, int distance){
        Place newPlace = new Place(name, distance);
        boolean alreadyAdded = false;
        for (Place place : list) {
            if (place.name().equalsIgnoreCase(name)) {
                alreadyAdded = true;
                System.out.println("Place Already On List");
                break;
            }
        }
        if (!alreadyAdded){
            list.add(newPlace);
        }
    }

    public static void menu(){
        String menu= """
                     Available  actions (Select word or letter)
                     (F)orward
                     (B)ackward
                     (L)ist place
                     (M)enu
                     (Q)uit""";

        System.out.println(menu);
    }

    public  static  void addPlaceAtStart(LinkedList<Place> list){
       System.out.print("Enter Name Of Place To Add: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Distance From Cydney: ");
        int distance = scanner.nextInt();
        scanner.nextLine();
        var place = new Place(name,distance);
        list.addFirst(place);
    }

    public  static  void addPlaceAtEnd(LinkedList<Place> list){
        System.out.print("Enter Name Of Place To Add: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Distance From Sydney: ");
        int distance = scanner.nextInt();
        scanner.nextLine();
        addPlace(list,name,distance);
    }

    public static void listPlaces(LinkedList<Place> list){
        var iterator = list.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
