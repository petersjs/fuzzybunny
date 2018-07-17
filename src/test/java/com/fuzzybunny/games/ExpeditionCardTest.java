package com.fuzzybunny.games;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.fuzzybunny.games.lostCities.ExpeditionCard;
import com.fuzzybunny.games.lostCities.ExpeditionCard.ExpeditionCardColor;

// arrange, act, assert
class ExpeditionCardTest {
    
    @DisplayName("Should accept legal number values")
    @ParameterizedTest(name = "{index} => value=''{0}''")
    @ValueSource(ints = {0,2,3,4,5,6,7,8,9,10})
    void shouldAcceptLegalNumberValues(int value) {
    		ExpeditionCard card = new ExpeditionCard(ExpeditionCardColor.RED, value);
		assertEquals(value, card.getValue());
		
    }

    @DisplayName("Should throw exceptions for illegal number values")
    @ParameterizedTest(name = "{index} => message=''{0}''")
    @ValueSource(ints = {1,11,12,-1})
    void shouldThrowExceptionsForIllegalNumberValues(int value) {
    		assertThrows(IllegalArgumentException.class, () -> { new ExpeditionCard(ExpeditionCardColor.RED, value); });
    }
    
    @DisplayName("Should set investment flag")
    @ParameterizedTest(name = "{index} => value=''{0}'' expected=''{1}''")
    @CsvSource({ "0,true", "2,false", "3,false", "4,false", "5,false", "6,false", "7,false", "8,false", "9,false", "10,false"})
     void shouldSetInvestmentFlag(int value, boolean expected) {
    		ExpeditionCard card = new ExpeditionCard(ExpeditionCardColor.RED, value);
		assertEquals(expected, card.isInvestment());
    }
    
    @DisplayName("Should report color red correctly")
    @ParameterizedTest(name = "{index} => color=''{0}'' expected=''{1}''")
    @CsvSource({ "RED,true", "YELLOW,false", "BLUE,false", "GREEN,false", "WHITE,false"})
     void shouldReportRedCorrectly(ExpeditionCardColor color, boolean expected) {
    		ExpeditionCard card = new ExpeditionCard(color, 2);
		assertEquals(expected, card.isRed());
    }
    
    @DisplayName("Should report color yellow correctly")
    @ParameterizedTest(name = "{index} => color=''{0}'' expected=''{1}''")
    @CsvSource({ "RED,false", "YELLOW,true", "BLUE,false", "GREEN,false", "WHITE,false"})
     void shouldReportYellowCorrectly(ExpeditionCardColor color, boolean expected) {
    		ExpeditionCard card = new ExpeditionCard(color, 2);
		assertEquals(expected, card.isYellow());
    }
    
    @DisplayName("Should report color blue correctly")
    @ParameterizedTest(name = "{index} => color=''{0}'' expected=''{1}''")
    @CsvSource({ "RED,false", "YELLOW,false", "BLUE,true", "GREEN,false", "WHITE,false"})
     void shouldReportBlueCorrectly(ExpeditionCardColor color, boolean expected) {
    		ExpeditionCard card = new ExpeditionCard(color, 2);
		assertEquals(expected, card.isBlue());
    }
    
    @DisplayName("Should report color green correctly")
    @ParameterizedTest(name = "{index} => color=''{0}'' expected=''{1}''")
    @CsvSource({ "RED,false", "YELLOW,false", "BLUE,false", "GREEN,true", "WHITE,false"})
     void shouldReportGreenCorrectly(ExpeditionCardColor color, boolean expected) {
    		ExpeditionCard card = new ExpeditionCard(color, 2);
		assertEquals(expected, card.isGreen());
    }
    
    @DisplayName("Should report color white correctly")
    @ParameterizedTest(name = "{index} => color=''{0}'' expected=''{1}''")
    @CsvSource({ "RED,false", "YELLOW,false", "BLUE,false", "GREEN,false", "WHITE,true"})
     void shouldReportWhiteCorrectly(ExpeditionCardColor color, boolean expected) {
    		ExpeditionCard card = new ExpeditionCard(color, 2);
		assertEquals(expected, card.isWhite());
    }
    
    @DisplayName("Should tell if two cards are same color")
    @ParameterizedTest(name = "{index} => color1=''{0}'' color2=''{1}'' expected=''{2}''")
    @CsvSource({ 
    		"RED,RED,true", "RED,YELLOW,false", "RED,GREEN,false", "RED,BLUE,false", "RED,WHITE,false",
    		"YELLOW,RED,false", "YELLOW,YELLOW,true", "YELLOW,GREEN,false", "YELLOW,BLUE,false", "YELLOW,WHITE,false",
    		"GREEN,RED,false", "GREEN,YELLOW,false", "GREEN,GREEN,true", "GREEN,BLUE,false", "GREEN,WHITE,false",
    		"BLUE,RED,false", "BLUE,YELLOW,false", "BLUE,GREEN,false", "BLUE,BLUE,true", "BLUE,WHITE,false",
    		"WHITE,RED,false", "WHITE,YELLOW,false", "WHITE,GREEN,false", "WHITE,BLUE,false", "WHITE,WHITE,true"
    })
     void shouldCompareCardsOfTwoColorsCorrectly(ExpeditionCardColor color1, ExpeditionCardColor color2, boolean expected) {
    		ExpeditionCard card1 = new ExpeditionCard(color1, 2);
    		ExpeditionCard card2 = new ExpeditionCard(color2, 2);
    		
		assertEquals(expected, card1.isSameColor(card2));
    }

    @DisplayName("Should tell if a card is higher than another")
    @ParameterizedTest(name = "{index} => color1=''{0}'' color2=''{1}'' expected=''{2}''")
    @CsvSource({ 
    		"0,0,true", "0,2,false", "0,3,false", "0,4,false", "0,5,false", "0,6,false", "0,7,false", "0,8,false", "0,9,false", "0,10,false",
    		"2,0,true", "2,2,false", "2,3,false", "2,4,false", "2,5,false", "2,6,false", "2,7,false", "2,8,false", "2,9,false", "2,10,false",
    		"3,0,true", "3,2,true", "3,3,false", "3,4,false", "3,5,false", "3,6,false", "3,7,false", "3,8,false", "3,9,false", "3,10,false",
    		"4,0,true", "4,2,true", "4,3,true", "4,4,false", "4,5,false", "4,6,false", "4,7,false", "4,8,false", "4,9,false", "4,10,false",
    		"5,0,true", "5,2,true", "5,3,true", "5,4,true", "5,5,false", "5,6,false", "5,7,false", "5,8,false", "5,9,false", "5,10,false",
    		"6,0,true", "6,2,true", "6,3,true", "6,4,true", "6,5,true", "6,6,false", "6,7,false", "6,8,false", "6,9,false", "6,10,false",
    		"7,0,true", "7,2,true", "7,3,true", "7,4,true", "7,5,true", "7,6,true", "7,7,false", "7,8,false", "7,9,false", "7,10,false",
    		"8,0,true", "8,2,true", "8,3,true", "8,4,true", "8,5,true", "8,6,true", "8,7,true", "8,8,false", "8,9,false", "8,10,false",
    		"9,0,true", "9,2,true", "9,3,true", "9,4,true", "9,5,true", "9,6,true", "9,7,true", "9,8,true", "9,9,false", "9,10,false",
    		"10,0,true", "10,2,true", "10,3,true", "10,4,true", "10,5,true", "10,6,true", "10,7,true", "10,8,true", "10,9,true", "10,10,false"
    	})
     void shouldCompareCardValues(int value1, int value2, boolean expected) {
    		ExpeditionCard card1 = new ExpeditionCard(ExpeditionCardColor.RED, value1);
    		ExpeditionCard card2 = new ExpeditionCard(ExpeditionCardColor.RED, value2);
    		
		assertEquals(expected, card1.isHigherValue(card2));
    }

}
