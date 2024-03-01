package tonilearnsjava;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>(5);
    }

    public String getName() {
        return name;
    }

    public void setHand(Card... hand) {
        this.hand.addAll(List.of(hand));
    }

    @Override
    public String toString() {
        return "Player : " + name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void showHand(){
        System.out.println("-".repeat(30));
        System.out.println(this);
        hand.forEach((card -> System.out.print(card  + " \n")));
    }
}
