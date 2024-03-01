import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {
    static Scanner scanner = new Scanner(System.in);
    static Location road = new Location("at the end of the road");
    static Location hill = new Location("on top of hill with a view in all directions");
    static Location wellHouse = new Location("inside a well house for a small spring");
    static Location valley = new Location("in a forest valley beside a tumbling stream");
    static Location forest = new Location("inside a well house for a small spring");
    static Location lake = new Location("by an alpine lake surrounded by wildflowers");
    static Location stream = new Location("near a stream with a rocky bed");



    public static void main(String[] args) {
        road.addNextPlaces("W", "hill");
        road.addNextPlaces("E", "well house");
        road.addNextPlaces("S", "valley");
        road.addNextPlaces("N", "forest");

        hill.addNextPlaces("N", "forest");
        hill.addNextPlaces("E", "road");

        wellHouse.addNextPlaces("W","road");
        wellHouse.addNextPlaces("N","lake");
        wellHouse.addNextPlaces("S","stream");

        valley.addNextPlaces("N", "road");
        valley.addNextPlaces("W", "hill");
        valley.addNextPlaces("E", "stream");

        forest.addNextPlaces("S","road");
        forest.addNextPlaces("E", "lake");

        lake.addNextPlaces("W", "forest");
        lake.addNextPlaces("S", "well house");

        stream.addNextPlaces("W",  "valley");
        stream.addNextPlaces("N", "well house");

        Map<String, Location> gameBoardLocation = new HashMap<>();
        gameBoardLocation.put("road", road);
        gameBoardLocation.put("hill", hill);
        gameBoardLocation.put("well house", wellHouse);
        gameBoardLocation.put("valley", valley);
        gameBoardLocation.put("forest", forest);
        gameBoardLocation.put("stream", stream);



        String text = """
                You're standing inside a well house from  a small spring
                From here, you can see:""";

        String res = "road";
        do{
            System.out.println(text);
            gameBoardLocation.get(res).getNextPlaces().forEach((k,v)->System.out.println("A " + v + " to the "  + k));
            System.out.print("Select Your Next Direction (Q to Quit) >> ");
            res = scanner.next();
        }while (!res.equals("q"));
    }
}
