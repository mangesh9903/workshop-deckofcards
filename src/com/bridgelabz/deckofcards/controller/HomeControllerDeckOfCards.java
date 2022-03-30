package com.bridgelabz.deckofcards.controller;

import com.bridgelabz.deckofcards.service.DeckOfCardsI;
import com.bridgelabz.deckofcards.serviceimpl.DeckOfCards;

import java.util.Scanner;

public class HomeControllerDeckOfCards {
    public static void main(String[] args) {
        System.out.println("Welcome to Deck Of Cards Game.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter How Many Player you want");
        int noOfPlayers = scanner.nextInt();
        DeckOfCardsI deckOfCards = new DeckOfCards();
        deckOfCards.setupDeckOfCards();
        deckOfCards.addPlayers(noOfPlayers);
        deckOfCards.orderPlayerTurn(noOfPlayers);
    }
}
