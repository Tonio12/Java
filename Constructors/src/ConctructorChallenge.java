public class ConctructorChallenge {
    private String name;
    private double limit;
    private String address;

    public ConctructorChallenge(String name, double limit, String address) {
        this.name = name;
        this.limit = limit;
        this.address = address;
    }

    public ConctructorChallenge() {
        this("joe", 100, "joe@mail.com");
    }

    public ConctructorChallenge(String name, String address) {
        this(name, 100, address);
    }

    public String getName() {
        return name;
    }

    public double getLimit() {
        return limit;
    }

    public String getAddress() {
        return address;
    }
}
