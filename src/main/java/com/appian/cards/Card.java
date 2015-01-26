package com.appian.cards;

/**
 * Class to define one playing card.  
 * A playing card is defined by a suit and a card value. 
 */
public class Card {
	/**
	 * The suit of  the card.
	 */
	private final Suit suit;
	/**
	 * The value of the card.
	 */
	private final CardValue cardValue;
	
	/**
	 * Creates a card from a defined suit and card value.
	 * @param suit - The suit of the card. 
	 * @param cardValue - The value of the card.
	 */
	public Card(Suit suit, CardValue cardValue) {
		this.suit = suit;
		this.cardValue = cardValue;
	}
	
	/**
	 * Gets the suit of the card.
	 * @return Suit of the card.
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Gets the value of the card.
	 * @return Value of the card.
	 */
	public CardValue getCardValue() {
		return cardValue;
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
			Card card = (Card)obj;
			if (this.suit == card.suit &&
					this.cardValue == card.cardValue) {
				isEquals = true;
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
		hash = 31 * hash + this.suit.hashCode();
		hash = 31 * hash + this.cardValue.hashCode();
		return hash;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", cardValue=" + cardValue + "]";
	}
}
