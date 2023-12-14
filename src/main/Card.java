package main;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private char symbol;
    private String value;

    public Card(char symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }


    public char getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " " + symbol;
    }
}