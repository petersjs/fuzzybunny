package com.fuzzybunny.games.lostCities;

public class ExpeditionCard {

	private ExpeditionCardColor color;
	private int value;
	
	public enum ExpeditionCardColor {
		RED,
		WHITE,
		BLUE,
		GREEN,
		YELLOW; 
	}
	
	public ExpeditionCard(ExpeditionCardColor color, int value) {
		validateValue(value);

		this.color = color;
		this.value = value;
	}
	
	private boolean validateValue(int value) {
		if ((value < 2 || value > 10) && value != 0) {
			throw new IllegalArgumentException("Value must be 0 or be between 2 and 10, inclusive.");
		}
		
		return true;
	}

	public ExpeditionCardColor getColor() {
		return color;
	}

	public void setColor(ExpeditionCardColor color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isInvestment() {
		return value == 0;
	}
	
	public boolean isRed() {
		return this.color == ExpeditionCardColor.RED;
	}
	
	public boolean isYellow() {
		return this.color == ExpeditionCardColor.YELLOW;
	}
	
	public boolean isGreen() {
		return this.color == ExpeditionCardColor.GREEN;
	}
	
	public boolean isBlue() {
		return this.color == ExpeditionCardColor.BLUE;		
	}
	
	public boolean isWhite() {
		return this.color == ExpeditionCardColor.WHITE;
	}
	
	public boolean isSameColor(ExpeditionCard card) {
		return this.color == card.getColor();
	}
	
	public boolean isHigherValue(ExpeditionCard card) {
		return card.getValue() == 0 || this.value > card.getValue();
	}
}