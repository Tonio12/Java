package tonilearnsjava;

import java.util.Arrays;

public abstract class Line implements Mappable{
    private double[][] location;

    public Line(String...  locations){
        this.location = new double[locations.length][];
        int index = 0;
        for(var l : locations){
            this.location[index++] = Mappable.stringToLatLon(l);
        }
    }

    @Override
    public String render() {
        return "Render " + this + " as LINE" + "(" + locations( ) + ")";
    }

    private String locations() {
        return Arrays.deepToString(location);
    }
}
