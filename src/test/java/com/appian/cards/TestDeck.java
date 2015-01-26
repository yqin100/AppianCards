package com.appian.cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestDeck {
	@Test
	public void testAllSuitsValueInDeck() {
		IDeck deck = new Deck();
		List<Card> cards = getCardsFromDeck(deck);
		
		for (Suit suit : Suit.values()) {
			for (CardValue cardValue : CardValue.values()) {
				for (Iterator<Card> iter = cards.iterator(); iter.hasNext();) {
					Card card = iter.next();
					if (card.getCardValue() == cardValue &&
						card.getSuit() == suit) {
						iter.remove();
						break;
					}
				}
			}
		}
		
		Assert.assertTrue(cards.size() == 0);
	}
	
	@Test
	public void testDealOneCard() {
		IDeck deck = new Deck(); 
		int numCards = Suit.values().length * CardValue.values().length;
		
		Card card;
		for (int i = 0; i < numCards; i++) {
			card = deck.dealOneCard();
			Assert.assertTrue(card != null);
		}
		
		card = deck.dealOneCard();
		Assert.assertTrue(card == null);
	}
	
	@Test
	public void testDeck() {
		int numCards = Suit.values().length * CardValue.values().length;
		IDeck deck1 = new Deck();
		IDeck deck2 = new Deck();
		
		Card card1;
		Card card2;
		for (int i = 0; i < numCards; i++) {
			card1 = deck1.dealOneCard();
			card2 = deck2.dealOneCard();
			
			Assert.assertTrue(card1 != null && card2 != null);
			Assert.assertTrue(card1.equals(card2));
			Assert.assertTrue(card1.hashCode() == card2.hashCode());
		}

		card1 = deck1.dealOneCard();
		card2 = deck2.dealOneCard();
		
		Assert.assertTrue(card1 == null && card2 == null);
	}
	
	@Test
	public void testShuffle() {
		int numCards = Suit.values().length * CardValue.values().length;
		double percentageAllowed = 10.0 / 100.0;
		int numCardsNotChangedAllowed = (int)Math.floor(numCards * percentageAllowed);
		IDeck shuffleDeck = new Deck();
		shuffleDeck.shuffle();
		List<Card> shuffledCards = getCardsFromDeck(shuffleDeck);
		IDeck deck = new Deck();
		List<Card> cards = getCardsFromDeck(deck);
		
		int numCardsEqual = 0;
		for (int i = 0; i < numCards; i++) {
			if (cards.get(i).equals(shuffledCards.get(i))) {
				numCardsEqual++;
			}
		}
		
		Assert.assertTrue(numCardsEqual <= numCardsNotChangedAllowed);
		System.out.println("Number of cards allowed to be same => " + numCardsNotChangedAllowed);
		System.out.println("Actual number of cards that are the same => " + numCardsEqual);
	}
	
	private List<Card> getCardsFromDeck(IDeck deck) {
		List<Card> cards = new ArrayList<>();
		while (true) {
			Card card = deck.dealOneCard();
			if (card == null) {
				break;
			}
			else {
				cards.add(card);
			}
		}
		return cards;
	}
}