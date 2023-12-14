package main;

import java.util.*;

public class Combinaisons {
    public enum HandRank {
        HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH
    }
    public static HandRank getHandRank(List<Card> hand) {
        Map<Character, Integer> cardRanks = new HashMap<>();
        List<Integer> rankCounts = new ArrayList<>();

        // Convert card ranks to numerical values
        for (Card card : hand) {
            char rank = card.getSymbol();
            int value = Character.isDigit(rank) ? Character.getNumericValue(rank) : getNonNumericCardValue(rank);

            // Count occurrences of each rank
            cardRanks.put(rank, cardRanks.getOrDefault(rank, 0) + 1);

            // Store numerical values
            rankCounts.add(value);
        }

        // Sort the rank values
        Collections.sort(rankCounts);

        // Check for different hand ranks
        if (isStraight(rankCounts)) {
            if (isFlush(hand)) {
                return HandRank.STRAIGHT_FLUSH;
            } else {
                return HandRank.STRAIGHT;
            }
        } else if (isFlush(hand)) {
            return HandRank.FLUSH;
        } else if (hasFourOfAKind(cardRanks)) {
            return HandRank.FOUR_OF_A_KIND;
        } else if (hasFullHouse(cardRanks)) {
            return HandRank.FULL_HOUSE;
        } else if (hasThreeOfAKind(cardRanks)) {
            return HandRank.THREE_OF_A_KIND;
        } else if (hasTwoPair(cardRanks)) {
            return HandRank.TWO_PAIR;
        } else if (hasOnePair(cardRanks)) {
            return HandRank.ONE_PAIR;
        } else {
            return HandRank.HIGH_CARD;
        }
    }

    //check for a straight
    private static boolean isStraight(List<Integer> ranks) {
        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i + 1) - ranks.get(i) != 1) {
                return false;
            }
        }
        return true;
    }

    //check for a flush
    private static boolean isFlush(List<Card> hand) {
        char symbol = hand.get(0).getSymbol();
        for (Card card : hand) {
            if (card.getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasFourOfAKind(Map<Character, Integer> cardRanks) {
        return cardRanks.containsValue(4);
    }

    private static boolean hasFullHouse(Map<Character, Integer> cardRanks) {
        return cardRanks.containsValue(3) && cardRanks.containsValue(2);
    }

    private static boolean hasThreeOfAKind(Map<Character, Integer> cardRanks) {
        return cardRanks.containsValue(3);
    }

    private static boolean hasTwoPair(Map<Character, Integer> cardRanks) {
        int pairCount = 0;
        for (int count : cardRanks.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private static boolean hasOnePair(Map<Character, Integer> cardRanks) {
        return cardRanks.containsValue(2);
    }

    //get numerical values for card symbols
    private static int getNonNumericCardValue(char rank) {
        switch (rank) {
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return -1; //invalid symbol
        }
    }
}
