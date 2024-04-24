/*
    STUDENT NUMBER: B211202374
    NAME: ESRA
    SURNAME: ÇELİK
    COURSE NAME: SOFTWARE VERIFICATION AND VALIDATION
    GITHUB REPOSITORY ADDRESS: https://github.com/esracelk/SvvHomework
*/

package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10, 2, 5",
            "10, 4, 2.5f",
            "12.5f, 2.5f, 5",
            "10, 2.5f, 4",
            "12.5f, 5, 2.5f"} )
    public void shouldPerformDivisionCorrectly(float givenFirstNumber,
                                               float givenSecondNumber,
                                               float exceptedResult)
    {
        //Given
        float firstNumber= givenFirstNumber;
        float secondNumber = givenSecondNumber;
        float excepted =exceptedResult;
        //When
        float actualResult= Calculator.divide(firstNumber,secondNumber );
        //Then
        assertEquals(excepted, actualResult,0.001f);

    }

    @Test
    void testDivision6() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );

        // Optional. To check whether the error messages match.
        assertEquals("Illegal Argument Exception.", exception.getMessage());
    }
}