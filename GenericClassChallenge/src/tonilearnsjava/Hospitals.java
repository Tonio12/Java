package tonilearnsjava;

public class Hospitals extends Point{
    private String name;

    public Hospitals(String name, String location) {
        super(location);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " National Park";
    }
}
