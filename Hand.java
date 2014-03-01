package net.krakendev;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	protected List<Card> cards = new ArrayList<Card>();
	
	public Hand(Card[] cards) {
		for (Card card : cards) {
			this.cards.add(card);
		}
	}
	
	public void add(Card card) {
		this.cards.add(card);
	}
	
	public boolean contains(Card cardToFind) {
		for (Card card : cards) {
			if (card.sameAs(cardToFind)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Card getSameCard(Card cardToGet) {
		for (Card card : cards) {
			if (card.sameAs(cardToGet)) {
				return card;
			}
		}
		
		return null;
	}
	
	public boolean empty() {
		return cards.size() == 0;
	}
	public List<Card> getCards() {
		return cards;
	}
	
	/**
	 * @param card {@link Card} to remove. Will remove the first card with the same number and suit.
	**/
	public void remove(Card card) {
		if (this.contains(card)) {
			cards.remove(getSameCard(card));
		}
	}
}