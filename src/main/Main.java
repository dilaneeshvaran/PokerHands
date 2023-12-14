package main;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /* Print all cards in deck
        for (main.Card card : deck.getCards()) {
            System.out.println(card);
        }*/
        // Create a player
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        // Create a deck and shuffle it
        Deck deck = new Deck();
        deck.shuffle();


        // generate 5 random cards
        List<Card> player1Hand = deck.dealRandomHand();
        List<Card> player2Hand = deck.dealRandomHand();
        // give cards to players
        player1.setHand(player1Hand);
        player2.setHand(player2Hand);

        System.out.println("===========Display player's hand==========");
        // Display player's hand
        System.out.println(player1.getName() + "'s Cards:");
        for (Card card : player1.getHand()) {
            System.out.println(card);
        }
        System.out.println("");
        // Display the player 2's hand
        System.out.println(player2.getName() + "'s Cards:");
        for (Card card : player2.getHand()) {
            System.out.println(card);
        }

        System.out.println("\n");
        System.out.println("===========The best combinaison for each Player==========");
        System.out.println("Player 1 : " + Combinaisons.getHandRank(player1Hand));
        System.out.println("Player 2 : " + Combinaisons.getHandRank(player2Hand));
        System.out.println("======================");

        // Determine the winner
        int winner = DetermineWinner.determineWinner(player1Hand, player2Hand);
        if (winner == 1) {
            System.out.println("Player 1 wins!");
        } else if (winner == 2) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

}
