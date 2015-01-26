package com.appian.cards;

/**
 * The suit that a playing card can have. 
 */
public enum Suit {
	SPADES("Spades"),
	HEARTS("Hearts"),
	DIAMONDS("Diamonds"),
	CLUBS("Clubs");
	
	/**
	 * The string representation of the card value.
	 */
	private final String name;
	
	/**
	 * Creates a suit with the string name defined. 
	 * @param name - String representation of the suit.
	 */
	private Suit(String name) {
		this.name = name;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return name;
	}
}