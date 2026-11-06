package com.lab.strings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PermutationCheckerTest {

    private final PermutationChecker checker = new PermutationChecker();

    @Test
    @DisplayName("Should throw IllegalArgumentException when first string is null")
    void shouldThrowExceptionWhenFirstStringIsNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> checker.isPermutation(null, "abc"))
                .withMessageContaining("Input strings cannot be null");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when second string is null")
    void shouldThrowExceptionWhenSecondStringIsNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> checker.isPermutation("abc", null))
                .withMessageContaining("Input strings cannot be null");
    }

    @Test
    @DisplayName("Empty strings should be permutations of each other")
    void emptyStringsShouldBePermutations() {
        assertThat(checker.isPermutation("", "")).isTrue();
    }

    @Test
    @DisplayName("Strings of different lengths cannot be permutations")
    void differentLengthStringsShouldReturnFalse() {
        assertThat(checker.isPermutation("hello", "helloworld")).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "listen, silent",
            "triangle, integral",
            "abc, bca",
            "a, a",
            "12345, 54321",
            "'d o g', 'g o d'"
    })
    @DisplayName("Should return true for valid permutations")
    void shouldReturnTrueForValidPermutations(String first, String second) {
        assertThat(checker.isPermutation(first, second)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "hello, world",
            "apple, palee",
            "aab, abb",
            "Listen, silent",
            "'dog  ', 'dog '",
            "abcd, abce"
    })
    @DisplayName("Should return false for invalid permutations")
    void shouldReturnFalseForInvalidPermutations(String first, String second) {
        assertThat(checker.isPermutation(first, second)).isFalse();
    }
}