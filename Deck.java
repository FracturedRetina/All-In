package net.krakendev;

import java.util.Random;

import net.krakendev.Card.Suit;

public class Deck {
	private Card[] cards;
	
	/**
	 * Create a new 52-card deck with no jokers 
	**/
	public Deck() {
		new Deck(DeckType.FRENCH__NOJOKERS);
	}
	public Deck(DeckType typeOfDeck) {
		switch (typeOfDeck) {
			case FRENCH__NOJOKERS:
				cards = new Card[52];
				
				for (int i = 0; i < 52; i++) {
					if (i < 13) {
						cards[i] = new Card((i + 1), Suit.CLUBS);
					} else if (i < 26) {
						cards[i] = new Card((i - 12), Suit.DIAMONDS);
					} else if (i < 39) {
						cards[i] = new Card((i - 25), Suit.HEARTS);
					} else if (i < 52) {
						cards[i] = new Card((i - 38), Suit.SPADES);
					}
				}
				
				break;
			case FRENCH__2JOKERS:
				cards = new Card[54];
				
				for (int i = 0; i < 52; i++) {
					if (i < 13) {
						cards[i] = new Card((i + 1), Suit.CLUBS);
					} else if (i < 26) {
						cards[i] = new Card((i - 12), Suit.DIAMONDS);
					} else if (i < 39) {
						cards[i] = new Card((i - 25), Suit.HEARTS);
					} else if (i < 52) {
						cards[i] = new Card((i - 38), Suit.SPADES);
					}
				}
				cards[53] = new Card(0, null);
				cards[54] = new Card(0, null);
				
				break;
			case PIQUET:
				cards = new Card[32];
				
				for (int i = 0; i < 32; i++) {
					if (i == 0) {
						cards[i] = new Card(1, Suit.CLUBS);
					} else if (i == 8) {
						cards[i] = new Card(1, Suit.DIAMONDS);
					} else if (i == 16) {
						cards[i] = new Card(1, Suit.HEARTS);
					} else if (i == 32) {
						cards[i] = new Card(1, Suit.SPADES);
					} else if (i < 8) {
						cards[i] = new Card((i + 6), Suit.CLUBS);
					} else if (i < 16) {
						cards[i] = new Card((i - 2), Suit.DIAMONDS);
					} else if (i < 24) {
						cards[i] = new Card((i - 10), Suit.HEARTS);
					} else if (i < 32) {
						cards[i] = new Card((i - 18), Suit.SPADES);
					}
				}
				
				break;
		}
	}
	
	/**
	 * @return the actual array of cards comprising this deck
	**/
	public Card[] getCards() {
		return cards;
	}
	
	/**
	 * 
	**/
	public void shuffle() {
		Random gen = new Random();
		boolean[] added = new boolean[cards.length];
		int positionToAdd = gen.nextInt(cards.length);
		Card[] newDeck = new Card[cards.length];
		
		for (int i = 0; i < cards.length; i++) {
			while (newDeck[i] == null) {
				if (!added[positionToAdd]) {
					newDeck[i] = cards[positionToAdd];
					positionToAdd = gen.nextInt(cards.length);
					added[i] = true;
				} else {
					positionToAdd = gen.nextInt(cards.length);
				}
			}
		}
		
		
		cards = newDeck;
	}
}