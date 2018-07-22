package com.geocaching;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ROT13Test {

    @DisplayName("Should decode properly")
    @ParameterizedTest(name = "{index} => source=''{0}'' expected=''{1}''")
    @CsvSource({ ",''", 
    		"'',''",
    		"ABCDEFGHIJKLMNOPQRSTUVWXYZ,NOPQRSTUVWXYZABCDEFGHIJKLM",
    		"HELLO,URYYB",
    		"WORDS WITH SPACES,JBEQF JVGU FCNPRF",
    		"NUMBERS 1234567890,AHZOREF 1234567890",
    		"SPECIALS !@#$%^&*()_+,FCRPVNYF !@#$%^&*()_+",
    		"MORE SPECIALS ~`-={}|[],ZBER FCRPVNYF ~`-={}|[]",
    		"hello,uryyb"
    		})
    void shouldDecodeProperly(String source, String expected) {
    		String actual = ROT13.decode(source);
    		
		assertEquals(expected, actual);
    }
  
}
