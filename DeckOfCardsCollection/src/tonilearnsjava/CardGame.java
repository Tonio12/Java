package tonilearnsjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame {
    private final List<Card> deck;
    private final List<Player> players;

    private final List<Integer> scores;

    public CardGame() {
        deck = Card.getStandardDeck();
        players = new ArrayList<>(4);
        scores = new ArrayList<>(4);
        removeUnusedCards();
    }

    public void setPlayer(String name){
        players.add(new Player(name));
    }

    private void removeUnusedCards(){
        deck.removeIf((s)-> startsWithUnusedCard(s.face()));
    }

    private static boolean startsWithUnusedCard(String fruit) {
        return fruit.startsWith("2") || fruit.startsWith("3") ||  fruit.startsWith("4") || fruit.startsWith("5");
    }

    public Player getPlayer(String name){
        for(var player :  players){
            if(player.getName().equals(name)){
                return player;
            }
        }
        System.out.print("Player Not Found");
        return null;
    }

    public void dealHands(){
        Collections.shuffle(deck);
        Card.printDeck(deck);
        for(int i = 0; i < players.size(); i++){
            players.get(i).setHand(deck.get(0),deck.get(1),deck.get(2));
            deck.removeAll(List.of(deck.get(0),deck.get(1),deck.get(2)));
        }
        for(int j = 0; j < players.size(); j++){
            players.get(j).setHand(deck.get(0),deck.get(1));
            deck.removeAll(List.of(deck.get(0),deck.get(1)));
        }
    }

    public void Winner(){
        for(int i = 0; i < players.size(); i++){
            int playerScore = 0;
            for(var card : players.get(i).getHand()){
                playerScore += card.rank();
            }
            scores.add(playerScore);
        }
        printScores();
        int highestScore = Collections.max(scores);
        System.out.println("-".repeat(30));
        System.out.println("Winner Is " + players.get(scores.indexOf(highestScore)) + " (" + highestScore + ")" );
    }

    private void printScores(){
        int i = 0;
        for(var player : players){
            System.out.println(player + " Score: " + scores.get(i++));
        }
    }
}
