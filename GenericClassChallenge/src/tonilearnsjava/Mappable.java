package tonilearnsjava;

public interface Mappable {
    String render();

    static double[] stringToLatLon(String location){
        var splits = location.split(",");
        double lat = Double.parseDouble(splits[0]);
        double lng = Double.parseDouble(splits[1]);
        return new double []{lat, lng};
    }


}
