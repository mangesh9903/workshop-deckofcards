package com.bridgelabz.deckofcards.serviceimpl;

import com.bridgelabz.deckofcards.model.Card;
import com.bridgelabz.deckofcards.model.Player;
import com.bridgelabz.deckofcards.service.DeckOfCardsI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeckOfCards implements DeckOfCardsI {
    private static final String[] SUIT = {"Spades", "Hearts", "Diamond", "Clubs"};
    private static final String[] RANK = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private static final String[][] DECK_OF_CARDS = {SUIT, RANK};
    private static final Card[] deck = new Card[52];
    private static final List<Player> playerList = new ArrayList<>();

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

    @Override
    public void addPlayers(int numberOfPlayers) {
        System.out.println("Player Details.");
        if (numberOfPlayers >= 4 || numberOfPlayers <= 2) {
            System.out.println("Please Enter Player InBetween 2 to 4 ");
        } else {
            for (int index = 0; index < numberOfPlayers; index++) {
                System.out.println("Enter First Name Of Player.");
                String firstName = scanner.next();
                System.out.println("Enter Last Name Of Player.");
                String lastName = scanner.next();
                Player player = new Player(firstName, lastName);
                playerList.add(player);
                for (int index2 = 0; index2 < playerList.size(); index2++) {
                    System.out.println(playerList.get(index2));
                }
            }
        }
    }
}
