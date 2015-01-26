package com.appian.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class to represent a playing deck, which holds a collection of cards.
 */
public class Deck implements IDeck {
	/**
	 * SL4J logger.
	 */
    private final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * A list of cards for the playing deck.
	 */
	private final List<Card> cards = new ArrayList<>(); 
	
	/**
	 * Creates every permutation of cards from a combination of suits and card values.
	 */
	public Deck() {
		for (Suit suit : Suit.values()) {
			for (CardValue cardValue : CardValue.values()) {
				cards.add(new Card(suit,cardValue));
			}
		}
	}
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj == this) {
			isEquals = true;
		}
		else if (obj == null || obj.getClass() != this.getClass()) {
			isEquals = false;
		}
		else {
			Deck deck = (Deck)obj;
			if (deck.cards.size() != this.cards.size()) {
				isEquals = false;
			}
			else {
				isEquals = true;
				for (int i = 0; i < deck.cards.size(); i++) {
					if (!deck.cards.get(i).equals(this.cards.get(i))) {
						isEquals = false;
						break;
					}
				}
			}
		}
		return isEquals;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		if (cards != null) {
			int index = 1;
			for (Card card : cards) {
				hash = 31 * hash * index + card.hashCode();
				index++;
			}
		}
		return hash;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Deck contents...");
		if (cards != null) {
			for (Card card : cards) {
				sb.append(card).append("\r\n");
			}
		}
		return sb.toString();
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public void shuffle() {
		log.debug("Starting shuffling deck...");
		Random random = new Random();
		int size = cards.size();
		for (int i = 0; i < size; i++) {
			int swapIndex = random.nextInt(size);
			
			if (swapIndex == i) {
				continue;
			}
			else {
				Card a = cards.get(i);
				Card b = cards.get(swapIndex);
				cards.set(i, b);
				cards.set(swapIndex, a);
			}
		}
		log.debug("Finished shuffling deck.");
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public Card dealOneCard() {
		log.debug("Dealing one card...");
		if (cards.size() == 0) {
			log.debug("Deck is empty, returning null.");
			return null;
		}
		Card card = cards.remove(0);
		log.debug("Card dealt => " + card);
		return card;
	}
}