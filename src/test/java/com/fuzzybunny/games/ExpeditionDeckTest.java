package com.fuzzybunny.games;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.fuzzybunny.games.lostCities.ExpeditionCard;
import com.fuzzybunny.games.lostCities.ExpeditionCard.ExpeditionCardColor;
import com.fuzzybunny.games.lostCities.ExpeditionDeck;

public class ExpeditionDeckTest {

	@DisplayName("Should create empty deck")
	@Test
	void shouldCreateEmptyDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		assertNotNull(deck);
		assertEquals(0, deck.count());
	}
	
	@DisplayName("Should create full deck")
	@Test
	void shouldCreateFullDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		deck.init();
		assertEquals(60, deck.count());
	}
	
	@DisplayName("Should report true on empty deck")
	@Test
	void shouldReportTrueOnEmptyDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		assertTrue(deck.isEmpty());
	}
	
	@DisplayName("Should report false on full deck")
	@Test
	void shouldReportFalseOnFullDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		deck.init();
		assertFalse(deck.isEmpty());
	}

	@DisplayName("Should report false on non-empty deck")
	@Test
	void shouldReportFalseOnNonEmptyDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		ExpeditionCard card = new ExpeditionCard(ExpeditionCardColor.WHITE, 0);
	
		deck.putCardOnTop(card)
		;
		assertFalse(deck.isEmpty());
	}

	@DisplayName("Should draw card from full deck")
	@Test
	void ShouldDrawCardFromFullDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		deck.init();
		deck.drawCard();
		assertEquals(59, deck.count());
	}
	
	@DisplayName("Should throw exception on draw from empty deck")
	@Test
	void ShouldNotDrawCardFromEmptyDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
    		assertThrows(IndexOutOfBoundsException.class, () -> { deck.drawCard(); });
	}
	
	@DisplayName("Should put card on top of empty deck")
	@Test
	void ShouldPutCardOnTopOfEmptyDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		ExpeditionCard card = new ExpeditionCard(ExpeditionCardColor.RED, 0);
		
		deck.putCardOnTop(card);
		
		assertEquals(1, deck.count());
	}
	
	@DisplayName("Should put card on top of non-empty deck")
	@Test
	void ShouldPutCardOnTopOfNonEmptyDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		ExpeditionCard card1 = new ExpeditionCard(ExpeditionCardColor.RED, 0);
		ExpeditionCard card2 = new ExpeditionCard(ExpeditionCardColor.BLUE, 2);
		ExpeditionCard drawnCard = null;
		
		deck.putCardOnTop(card1);
		deck.putCardOnTop(card2);
		assertEquals(2, deck.count());
		
		drawnCard = deck.drawCard();
		assertEquals(2, drawnCard.getValue());
		assertEquals(ExpeditionCardColor.BLUE, drawnCard.getColor());
	}
	
	@DisplayName("Should put card on bottom of empty deck")
	@Test
	void ShouldPutCardOnBottomOfEmptyDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		ExpeditionCard card = new ExpeditionCard(ExpeditionCardColor.RED, 0);
		
		deck.putCardOnBottom(card);
		
		assertEquals(1, deck.count());
	}
	
	@DisplayName("Should put card on bottom of non-empty deck")
	@Test
	void ShouldPutCardOnBottomOfNonEmptyDeck() {
		ExpeditionDeck deck = new ExpeditionDeck();
		ExpeditionCard card1 = new ExpeditionCard(ExpeditionCardColor.RED, 0);
		ExpeditionCard card2 = new ExpeditionCard(ExpeditionCardColor.GREEN, 2);
		ExpeditionCard drawnCard = null;
		
		deck.putCardOnBottom(card1);
		deck.putCardOnBottom(card2);
		assertEquals(2, deck.count());
		
		drawnCard = deck.drawCard();
		assertEquals(0, drawnCard.getValue());
		assertEquals(ExpeditionCardColor.RED, drawnCard.getColor());
	}
	
	@DisplayName("Should contain correct number of cards per color for each value")
    @ParameterizedTest(name = "{index} => value=''{0}'' expected=''{1}''")
    @CsvSource({ "0,3", "2,1", "3,1", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1", "10,1"})
	void shouldContainThreeInvestmentsPerColorOnFullDeck(int value, int expectedCount) {
		ExpeditionDeck deck = new ExpeditionDeck();
		ExpeditionCard card;
		int redCount = 0;
		int yellowCount = 0;
		int blueCount = 0;
		int greenCount = 0;
		int whiteCount = 0;
		
		deck.init();
		
		while (!deck.isEmpty()) {
			card = deck.drawCard();
			if (card.getValue() == value) {
				if (card.isRed()) redCount++;
				if (card.isBlue()) blueCount++;
				if (card.isYellow()) yellowCount++;
				if (card.isGreen()) greenCount++;
				if (card.isWhite()) whiteCount++;
			}
		}
		
		assertEquals(expectedCount, redCount, "Incorrect number of red cards.");
		assertEquals(expectedCount, yellowCount, "Incorrect number of yellow cards.");
		assertEquals(expectedCount, blueCount, "Incorrect number of blue cards.");
		assertEquals(expectedCount, greenCount, "Incorrect number of green cards.");
		assertEquals(expectedCount, whiteCount, "Incorrect number of white cards.");
	}
	
	@DisplayName("Should init decks identically")
	@Test
	void ShouldInitDecksIdentically() {
		ExpeditionDeck deck1 = new ExpeditionDeck();
		ExpeditionDeck deck2 = new ExpeditionDeck();
		ExpeditionCard card1;
		ExpeditionCard card2;
		int sameCount = 0;
		deck1.init();
		deck2.init();
		
		while (!deck1.isEmpty() && !deck2.isEmpty()) {
			card1 = deck1.drawCard();
			card2 = deck2.drawCard();
			
			if (card1.getColor() == card2.getColor() && card1.getValue() == card2.getValue()) {
				sameCount++;
			}
		}
		
		assertEquals(60, sameCount);
	}
	
	@DisplayName("Should shuffle deck")
	@Test
	void ShouldShuffleDeck() {
	ExpeditionDeck deck1 = new ExpeditionDeck();
		ExpeditionDeck deck2 = new ExpeditionDeck();
		ExpeditionCard card1;
		ExpeditionCard card2;
		int sameCount = 0;
		deck1.init();
		deck2.init();
		deck2.shuffle();
		
		while (!deck1.isEmpty() && !deck2.isEmpty()) {
			card1 = deck1.drawCard();
			card2 = deck2.drawCard();
			
			if (card1.getColor() == card2.getColor() && card1.getValue() == card2.getValue()) {
				sameCount++;
			}
		}

		assertTrue(sameCount < 5, "Too many cards in same position after shuffling");
	}
}
