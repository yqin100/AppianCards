# Appian - Deck of Cards Problem

## Purpose

This project will simulate a deck of playing cards (52 cards, 4 suits, Ace, 2 - 10, Jack, Queen, King) and have two actions that can be applied to the deck.

- shuffle() - Shuffle returns no value, but results in the cards in the deck being randomly permuted. Please do not use library-provided “shuffle” operations to implement this function. You may use library provided random number generators in your solution if needed.
- dealOneCard() - This function should return one card from the deck to the caller. Specifically, a call to shuffle followed by 52 calls to dealOneCard() should result in the caller being provided all 52 cards of the deck in a random order. If the caller then makes a 53rd call dealOneCard(), no card is dealt.

## Testing

There are two Junit classes to test the project code.
- TestCard.java
- TestDeck.java

## Run Program
There is a Main.java file that runs the application as a demonstration.  It will shuffle the deck and deal out all the cards until the deck is empty.

Start by building jar file.  The following will create an executable jar.

```sh
$ gradle fatJar
```

Then run the executable jar file.

```sh
$ java -jar AppianCards-all-1.0.jar
```
