package tonilaernsjava;

public class Building implements Mappable {
    private String name;
    private String usage;

    public Building(String name, String usage) {
        this.name = name;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public String getUsage() {
        return usage;
    }

    @Override
    public String getLabel() {
        return "building";
    }

    @Override
    public Geometry geometryType() {
        return Geometry.POINT;
    }

    @Override
    public String iconType() {
        return "point";
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                ", name": "%s", "usage": "%s"\s""".formatted(getName(),getUsage());
    }
}
