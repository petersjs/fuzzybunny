package com.comics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NameUpdaterTest {

    @DisplayName("Should decode properly")
    @ParameterizedTest(name = "{index} => source=''{0}'' expected=''{1}''")
    @CsvSource({ 
    		",''", 
    		"'',''",
    		"Justice League v1 001 (2018) (2 covers),Justice League v1 001 (2018) ",
    		"Justice League 001 v1 (2018) (2 covers),Justice League v1 001 (2018) ",
    		"Justice League 001 (2018) (2 covers),Justice League 001 (2018) ",
    		"Justice League 001 (of 6) (2018) (2 covers),Justice League 001 (of 06) (2018) ",
    		"Justice League 001 (of 06) (2018) (2 covers),Justice League 001 (of 06) (2018) ",
    		"Justice League 001 (OF 06) (2018) (2 covers),Justice League 001 (of 06) (2018) ",
    		"Justice League 001 (of 12) (2018) (2 covers),Justice League 001 (of 12) (2018) ",
    		"Justice League 001 (01-2018) (2 covers),Justice League 001 (01-2018) ",
    		"Justice League 001 (12-2018) (2 covers),Justice League 001 (12-2018) ",
    		"Justice League 1001 (2018) (2 covers),Justice League 1001 (2018) ",
    		"Batman & Robin 999 (2018) (2 covers),Batman and Robin 999 (2018) "
    		})
    void shouldDecodeProperly(String source, String expected) {
    		String actual = NameUpdater.updateFileName(source);
    		
		assertEquals(expected, actual);
    }
  
}
