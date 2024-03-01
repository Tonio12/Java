package com.tonio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UtilitiesTestParameterized {
    private Utilities utility = new Utilities();


    @ParameterizedTest
    @CsvSource({
            "AABCDDEFF, ABCDEF",
            "ABCCABDEEF, ABCABDEF",
            "AB88EFFG, AB8EFG",
            "112233445566, 123456",
            "A, A"
    })
    void testRemovePairs(String input, String expectedOutput) {
        String result = utility.removePairs(input);
        Assertions.assertEquals(expectedOutput, result);
    }

}
