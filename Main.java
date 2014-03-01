package net.krakendev;

public class Main {
	public static void main(String[] args) {
		Deck deck = new Deck(DeckType.PIQUET);
		
		for (Card card : deck.getCards()) {
			System.out.println(card);
		}
	}
}