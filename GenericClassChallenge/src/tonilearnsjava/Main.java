package tonilearnsjava;

public class Main {
    public static void main(String[] args) {
        var korleBu = new Hospitals("Korle  Bu", "5.536852606423365,-0.22644129183971834");
        var ridge = new Hospitals("Rigde", "5.5616608093993465,-0.1986651765209769");

        var pra = new River("Pra", "5.664617207924008, -1.4197486932699073","5.681015992728043,-1.5351051331725458");

        Layer<Hospitals> hospitalsLayer = new Layer<>();
        hospitalsLayer.addElement(korleBu);
        hospitalsLayer.addElement(ridge);

        Layer<River> riverLayer = new Layer<>();
        riverLayer.addElement(pra);



        hospitalsLayer.renderLayer();
        riverLayer.renderLayer();
    }
}
