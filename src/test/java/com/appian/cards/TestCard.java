package com.appian.cards;

import org.junit.Assert;
import org.junit.Test;

public class TestCard {
	/**
	 * Testing the suit of the card to be equal.
	 */
	@Test
	public void testCardSuit() {
		Card card1 = new Card(Suit.CLUBS, CardValue.ACE);
		Card card2 = new Card(Suit.CLUBS, CardValue.EIGHT);
		
		Assert.assertTrue(card1.getSuit() == card2.getSuit());
		Assert.assertTrue(card1.getCardValue() != card2.getCardValue());
		Assert.assertTrue(!card1.equals(card2));
	}
	
	/**
	 * Testing the card value to be equal.
	 */
	@Test
	public void testCardValue() {
		Card card1 = new Card(Suit.CLUBS, CardValue.SEVEN);
		Card card2 = new Card(Suit.DIAMONDS, CardValue.SEVEN);
		
		Assert.assertTrue(card1.getSuit() != card2.getSuit());
		Assert.assertTrue(card1.getCardValue() == card2.getCardValue());
		Assert.assertTrue(!card1.equals(card2));
	}
	
	/**
	 * Testing the equality of cards. 
	 */
	@Test
	public void testCards() {
		Card card1a = new Card(Suit.HEARTS, CardValue.FIVE);
		Card card1b = new Card(Suit.HEARTS, CardValue.FIVE);
		Card card2a = new Card(Suit.SPADES, CardValue.THREE);
		Card card2b = new Card(Suit.SPADES, CardValue.THREE);
		
		Assert.assertTrue(card1a.getCardValue() == card1b.getCardValue());
		Assert.assertTrue(card1a.getSuit() == card1b.getSuit());
		Assert.assertTrue(card1a.equals(card1b));
		Assert.assertTrue(card1a.hashCode() == card1b.hashCode());

		Assert.assertTrue(card2a.getCardValue() == card2b.getCardValue());
		Assert.assertTrue(card2a.getSuit() == card2b.getSuit());
		Assert.assertTrue(card2a.equals(card2b));
		Assert.assertTrue(card2a.hashCode() == card2b.hashCode());
	}
}