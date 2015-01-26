package com.appian.cards;

/**
 * Values a card can have. 
 */
public enum CardValue {
	ACE("Ace"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	JACK("Jack"),
	QUEEN("Queen"),
	KING("King");
	
	/**
	 * The string representation of the card value.
	 */
	private final String name;
	
	/**
	 * Creates a card value with the string name defined. 
	 * @param name - String representation of the card value.
	 */
	private CardValue(String name) {
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