import java.util.HashMap;
import java.util.Map;

enum CardinalPoint{N,S,E,W}
public class Location {
    private final String description;

    private final Map<CardinalPoint, String> nextPlaces;

    public Location(String description) {
        this.description = description;
        this.nextPlaces = new HashMap<>();
    }

    public void addNextPlaces(String direction, String value){
        if("N,S,E,W".contains(direction)){
            nextPlaces.put(CardinalPoint.valueOf(direction), value);
        }
    }

    public Map<CardinalPoint, String> getNextPlaces() {
        return nextPlaces;
    }

    public String getNextPlace(String point){
       return nextPlaces.get(CardinalPoint.valueOf(point.substring(0,1).toUpperCase()));
    }

    @Override
    public String toString() {
        return description;
    }
}
