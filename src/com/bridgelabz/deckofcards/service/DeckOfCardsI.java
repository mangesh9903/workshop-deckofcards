package com.bridgelabz.deckofcards.service;

public interface DeckOfCardsI {
    void setupDeckOfCards();

    void addPlayers(int numberOfPlayers);

    void orderPlayerTurn(int numberOfPlayers);

    void shuffleDeckOfCards();

    void distributeCards();

    void printDect();
}
