package com.bridgelabz.deckofcards.serviceimpl;

import com.bridgelabz.deckofcards.model.Card;
import com.bridgelabz.deckofcards.model.Player;
import com.bridgelabz.deckofcards.service.DeckOfCardsI;

import java.util.*;

public class DeckOfCards implements DeckOfCardsI {
    private static final String[] SUIT = {"Spades", "Hearts", "Diamond", "Clubs"};
    private static final String[] RANK = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private static final String[][] DECK_OF_CARDS = {SUIT, RANK};
    private static final Card[] deck = new Card[52];
    private static final List<Player> playerList = new ArrayList<>();
    private static final Map<String, HashMap<String, Integer>> playerCardInfo = new HashMap<>();
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
        if (numberOfPlayers > 5 || numberOfPlayers <= 2) {
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

    @Override
    public void orderPlayerTurn(int numberOfPlayers) {
        System.out.println("Enter Players order.");
        for (int index = 0; index < numberOfPlayers; index++) {
            int turn = scanner.nextInt();
            playerList.get(index).setPlayerTurn(turn);
        }
    }

    @Override
    public void shuffleDeckOfCards() {
        Random random = new Random();
        for (int indexRow = 0; indexRow < DECK_OF_CARDS.length; indexRow++) {
            String[] tempArray = DECK_OF_CARDS[indexRow];
            for (int indexCol = 0; indexCol < tempArray.length; indexCol++) {
                int rand = indexCol + random.nextInt(tempArray.length - indexCol);
                String temp = tempArray[rand];
                tempArray[rand] = tempArray[indexCol];
                tempArray[indexCol] = temp;
            }
            DECK_OF_CARDS[indexRow] = tempArray;
        }
    }

    @Override
    public void distributeCards() {

        Comparator<Player> comparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.getPlayerTurn() > o2.getPlayerTurn())
                    return 1;
                else
                    return -1;
            }
        };

        Collections.sort(playerList, comparator);

        for (int player = 0; player < playerList.size(); player++) {
            int count = 0;
            int cardIndex = player;
            Card[] cardSet = new Card[9];
            while (count < 9) {
                Card card = deck[cardIndex];
                cardSet[count] = card;
                cardIndex = cardIndex + 5;
                count++;
            }
            playerList.get(player).setCard(cardSet);
        }
        for (Player player : playerList) {
            System.out.println(player);
        }
    }

    @Override
    public void printDect() {
        for (int index = 0; index < deck.length; index++) {
            System.out.println(deck[index]);
        }
    }

    @Override
    public void displayPlayerCards() {
        for (int indexI = 0; indexI < playerList.size(); indexI++) {
            HashMap<String, Integer> cardInfo = new HashMap<>();
            Card[] cardArray = playerList.get(indexI).getCard();
            for (int indexJ = 0; indexJ < cardArray.length; indexJ++) {
                if (cardInfo.containsKey(cardArray[indexJ].getSuit())) {
                    int value = cardInfo.get(cardArray[indexJ].getSuit());
                    cardInfo.put(cardArray[indexJ].getSuit(), value + 1);
                } else {
                    cardInfo.put(cardArray[indexJ].getSuit(), 1);
                }
            }
            playerCardInfo.put(playerList.get(indexI).getFirstName(), cardInfo);
        }
        for (Map.Entry<String, HashMap<String, Integer>> entry : playerCardInfo.entrySet()) {
            System.out.println("Key = " + entry.getKey() + " , Value = " + entry.getValue());
        }
    }
}
