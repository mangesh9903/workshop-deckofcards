package com.bridgelabz.deckofcards.controller;

import com.bridgelabz.deckofcards.service.DeckOfCardsI;
import com.bridgelabz.deckofcards.serviceimpl.DeckOfCards;

public class HomeControllerDeckOfCards {
    public static void main(String[] args) {
        System.out.println("Welcome to Deck Of Cards Game.");
        DeckOfCardsI deckOfCards = new DeckOfCards();
        deckOfCards.setupDeckOfCards();
    }
}
