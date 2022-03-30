package com.bridgelabz.deckofcards.serviceimpl;

import com.bridgelabz.deckofcards.model.Card;
import com.bridgelabz.deckofcards.service.DeckOfCardsI;

public class DeckOfCards implements DeckOfCardsI {
    private static final String[] suit = {"Spades", "Hearts", "Diamond", "Clubs"};
    private static final String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private static final String[][] deckOfCards = {suit, rank};
    private static final Card[] deck = new Card[52];

    @Override
    public void setupDeckOfCards() {
        int index = 0;
        for (String suit : deckOfCards[0]) {
            for (String rank : deckOfCards[1]) {
                deck[index++] = new Card(suit, rank);
            }
        }
    }
}
