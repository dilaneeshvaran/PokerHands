package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] symbols = {"H", "D", "C", "S"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String symbol : symbols) {
            for (String value : values) {
                cards.add(new Card(symbol.charAt(0), value));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Function to give 5 random cards to players
    public List<Card> dealRandomHand() {
        if (cards.size() < 5) {
            System.out.println("Not enough cards in deck.");
            return Collections.emptyList();
        }

        List<Card> hand = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(cards.size());
            hand.add(cards.remove(randomIndex));
        }

        return hand;

    }
}