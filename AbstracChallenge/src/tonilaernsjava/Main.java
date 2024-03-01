package tonilaernsjava;

public class Main {
    public static void main(String[] args) {
        Mappable building = new Building("Korle Bu Hospital", "Health Care");

        Mappable.mapIt(building);
    }
}
