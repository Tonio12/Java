package tonilearnsjava;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {
    private final List<T> listOfElementsToMap;

    public Layer() {
        this.listOfElementsToMap = new ArrayList<>();
    }

    public void addElement(T... t) {
        listOfElementsToMap.addAll(List.of(t));
    }

    public void  renderLayer(){
        for(T element: listOfElementsToMap){
            System.out.println(element.render());
        }
    }
}
