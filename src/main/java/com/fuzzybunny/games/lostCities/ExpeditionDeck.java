package com.fuzzybunny.games.lostCities;

import java.util.ArrayList;
import java.util.Random;

import com.fuzzybunny.games.lostCities.ExpeditionCard.ExpeditionCardColor;

public class ExpeditionDeck  {

	ArrayList<ExpeditionCard> deck = new ArrayList<ExpeditionCard>();
	
	public ExpeditionDeck() {
	}
	
	public void init() {
		deck = new ArrayList<ExpeditionCard>();
		
		int[] values = {0,0,0,2,3,4,5,6,7,8,9,10};
		
		for (ExpeditionCardColor color : ExpeditionCardColor.values()) {
			for (int value : values) {
				deck.add(new ExpeditionCard(color, value));
			}
		}
	}
	
	public void putCardOnTop(ExpeditionCard card) {
		deck.add(0, card);
	}

	public void putCardOnBottom(ExpeditionCard card) {
		deck.add(deck.size(), card);
	}

	public ExpeditionCard drawCard() {
		return deck.remove(0);
	}

	public void shuffle() {
		Random rand = new Random();

		for (int i=0; i<deck.size(); i++) {
			int base = rand.nextInt(deck.size() - i) + i;
			ExpeditionCard temp = deck.get(i);
		    deck.set(i, deck.get(base));
		    deck.set(base, temp);
		}
	}

	public int count() {
		return deck.size();
	}

	public boolean isEmpty() {
		return deck.size() <= 0;
	}
}
