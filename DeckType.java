package net.krakendev;

public enum DeckType {
	/**
	 * Standard 52-card deck with 2 jokers.
	**/
	FRENCH__2JOKERS(54),
	/**
	 * Standard 52-card deck with no jokers.
	**/
	FRENCH__NOJOKERS(52),
	/**
	 * 32-card deck with values 2 through 6 removed.
	**/
	PIQUET(32);
	
	public final int SIZE;
	DeckType(int numOfCards) {
		SIZE = numOfCards;
	}
}
