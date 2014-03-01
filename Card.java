package net.krakendev;

import java.util.Random;

public class Card {
	public enum Suit {
		SPADES, DIAMONDS, CLUBS, HEARTS
	}
	protected boolean faceUp = true;
	public final byte rank;
	public final Suit suit;
	
	/**
	 * Creates a random card
	**/
	public Card() {
		Random gen = new Random();
		
		this.rank = (byte) gen.nextInt(14);
		this.suit = Suit.values()[gen.nextInt(4)];
	}
	
	/**
	 * Creates a random card that is legal in a certain Deck Type
	**/
	public Card(DeckType deckType) {
		Random gen = new Random();
		
		switch (deckType) {
			case FRENCH__NOJOKERS:
				this.rank = (byte) (gen.nextInt(13) + 1);
				this.suit = Suit.values()[gen.nextInt(4)];
				
				break;
			case FRENCH__2JOKERS:
				this.rank = (byte) gen.nextInt(14);
				this.suit = Suit.values()[gen.nextInt(4)];
				
				break;
			case PIQUET:
				byte randNum = (byte) gen.nextInt(8);
				
				switch (randNum) {
					case 0: this.rank = 1;
						break;
					default: this.rank = (byte) (randNum + 5);
						break;
				}
				this.suit = Suit.values()[gen.nextInt(4)];
				
				break;
			default:
				this.rank = (byte) gen.nextInt(14);
				this.suit = Suit.values()[gen.nextInt(4)];
		}
	}
	
	/**
	 * @param suit
	 * @param rank
	 * </br>
	 * 		--KEY--
	 * 		</br>
	 * 			0 = Joker</br>
	 * 			1 = Ace</br>
	 * 			11 = Jack</br>
	 * 			12 = Queen</br>
	 * 			13 = King
	**/
	public Card(int rank, Suit suit) {
		this.rank = (byte) rank;
		this.suit = suit;
	}
	/**
	 * @param cardStr 
	 * </br>
	 * 		--KEY--
	 * 		</br>
	 * 			0 = Joker</br>
	 * 			1 = Ace</br>
	 * 			11 = Jack</br>
	 * 			12 = Queen</br>
	 * 			13 = King
	**/
	public Card(String cardStr) {
		cardStr = cardStr.toLowerCase();
		//Remove whitespace
		cardStr = cardStr.replaceAll("\\s", "");
		
		if (cardStr.contains("joker")) {
			this.rank = 0;
			this.suit = null;
			return;
		}
		
		
		String rank = cardStr.substring(0, cardStr.indexOf("of"));
		String suit = cardStr.substring(cardStr.indexOf("of") + 2, cardStr.length());
		
		switch (rank) {
			case "joker": this.rank = 0;
				break;
			case "ace": this.rank = 1;
				break;
			case "jack": this.rank = 11;
				break;
			case "queen": this.rank = 12;
				break;
			case "king": this.rank = 13;
				break;
			default: this.rank = (byte) Integer.parseInt(rank);
				break;
		}
		
		Suit newSuit = null;
		
		for (Suit val : Suit.values()) {
			if (suit.contains(val.toString().toLowerCase())) {
				newSuit = val;
			}
		}
		
		this.suit = newSuit;
	}
	
	/**
	 * @return true if card has the same rank and suit as this; false otherwise
	**/
	public boolean sameAs(Card card) {
		if (this.rank == card.rank && this.suit == card.suit) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Flip over this card</br>
	 * Invert this card's <code>faceUp</code> value
	**/
	public void flip() {
		faceUp = !faceUp;
	}
	/**
	 * Specify this card's <code>faceUp</code> value
	**/
	public void setFaceUp(boolean newVal) {
		faceUp = newVal;
	}
	/**
	 * @return If this card
	**/
	public boolean isFaceUp() {
		return this.faceUp;
	}
	
	@Override
	public String toString() {
		String strToReturn = "";
		
		switch (this.rank) {
			case 0: return "joker";
			case 1: strToReturn += ("ace");
				break;
			//2-10
			default: 
				if (rank < 14) {
					strToReturn += (Integer.toString(rank));
				} else {
					strToReturn += (rank + " ($@#!)");
				}
				break;
			case 11: strToReturn += ("jack");
				break;
			case 12: strToReturn += ("queen");
				break;
			case 13: strToReturn += ("king");
				break;
		}
		
		if (suit != null) {
			strToReturn += (" of " + suit.toString().toLowerCase());
		} else {
			strToReturn += (" of null");
		}
		
		return strToReturn;
	}
}