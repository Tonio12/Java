package tonilearnsjava;

import java.util.Arrays;

public abstract class Point implements Mappable{
   private double[] location = new double[2];

    public Point(String location){
        this.location= Mappable.stringToLatLon(location);
    }

    @Override
    public String render() {
        return "Render " + this + " as POINT" + "(" + location( ) + ")";
    }

    private  String location(){
        return Arrays.toString(location);
    }
}
