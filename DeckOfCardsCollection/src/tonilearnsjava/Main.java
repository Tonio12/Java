package tonilearnsjava;

public class Main {
    public static void main(String[] args) {
//        List<Card> deck = Card.getStandardDeck();
//        Card.printDeck(deck);

        CardGame cardGame = new CardGame();
        cardGame.setPlayer("Tonio");
        cardGame.setPlayer("Fortu");
        cardGame.setPlayer("Perry");
        cardGame.dealHands();
        Player tonio = cardGame.getPlayer("Tonio");
        Player fortu = cardGame.getPlayer("Fortu");
        Player perry = cardGame.getPlayer("Perry");
        tonio.showHand();
        fortu.showHand();
        perry.showHand();
        cardGame.Winner();
    }
}
