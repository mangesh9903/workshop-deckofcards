package com.bridgelabz.deckofcards.serviceimpl;

import com.bridgelabz.deckofcards.model.Card;
import com.bridgelabz.deckofcards.model.Player;
import com.bridgelabz.deckofcards.service.DeckOfCardsI;

import java.util.Scanner;

public class DeckOfCards implements DeckOfCardsI {
    private static final String[] SUIT = {"Spades", "Hearts", "Diamond", "Clubs"};
    private static final String[] RANK = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private static final String[][] DECK_OF_CARDS = {SUIT, RANK};
    private static final Card[] deck = new Card[52];
    private

    Scanner scanner = new Scanner(System.in);

    @Override
    public void setupDeckOfCards() {
        int index = 0;
        for (String suit : DECK_OF_CARDS[0]) {
            for (String rank : DECK_OF_CARDS[1]) {
                deck[index++] = new Card(suit, rank);
            }
        }
    }

}
