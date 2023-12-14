package main;
import java.util.List;
public class DetermineWinner {
    public static int determineWinner(List<Card> hand1, List<Card> hand2) {
        Combinaisons.HandRank rank1 = Combinaisons.getHandRank(hand1);
        Combinaisons.HandRank rank2 = Combinaisons.getHandRank(hand2);

        //compare according to enum instance order
        if (rank1.compareTo(rank2) > 0) {
            return 1; // Player 1 wins
        } else if (rank1.compareTo(rank2) < 0) {
            return 2; // Player 2 wins
        } else {
            return 0; // It's a tie
        }
    }
}
