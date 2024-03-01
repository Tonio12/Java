package tonilaernsjava;
enum Geometry{LINE,POINT, POLYGON}
public interface Mappable {
    String JSON_PROPERTY = """
            "properties":{%s}""";
    String getLabel();
    Geometry geometryType();
    String iconType();

    default String toJSON(){
        return """
                "type": "%s", "label": "%s", "maker": "%s"\s""".formatted(geometryType(),getLabel(),iconType());
    }

    static void mapIt(Mappable mappable){
        System.out.printf((JSON_PROPERTY) + "%n", mappable.toJSON());
    }
}
