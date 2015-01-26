package com.appian.cards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main class to demonstrate the Deck of Cards application. 
 */
public class Main {
	/**
	 * SL4J logger.
	 */
    private final Logger log = LoggerFactory.getLogger(getClass());

	public Main() {
		log.info("Starting a demonstration of the Deck of Cards...");
		IDeck deck = new Deck();
		deck.shuffle();
		
		int num = 1;
		while (true) {
			Card card = deck.dealOneCard();
			if (card == null) {
				break;
			}
			else {
				log.info(num + ") " + card); 
			}
			num++;
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
