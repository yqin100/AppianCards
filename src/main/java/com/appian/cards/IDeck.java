package com.appian.cards;

/**
 * Interface that supports actions for a deck of playing cards.
 */
public interface IDeck {
	/**
	 * Shuffles the deck of cards in a random order.
	 */
	void shuffle();
	/**
	 * Removes a card from the deck and returns the card that was removed.
	 * @return Card that was removed from the deck.  Null, if the deck is empty.
	 */
	Card dealOneCard();
}
