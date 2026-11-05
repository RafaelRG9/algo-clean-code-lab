package com.lab.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UniqueStringCheckerTest {

    private final UniqueStringChecker checker = new UniqueStringChecker();

    @Test
    @DisplayName("Should throw IllegalArgumentException when input is null")
    void shouldThrowExceptionWhenNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> checker.hasAllUniqueCharacters(null))
                .withMessageContaining("Input text cannot be null");
    }

    @Test
    @DisplayName("Empty string should be considered unique")
    void emptyStringShouldBeUnique() {
        assertThat(checker.hasAllUniqueCharacters("")).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcdef", "Algorithm", "123456", "subdermatoglyphic"})
    @DisplayName("Should return true for strings with all unique characters")
    void shouldReturnTrueForUniqueStrings(String input) {
        assertThat(checker.hasAllUniqueCharacters(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa", "hello", "Java", "repetitive", "  "})
    @DisplayName("Should return false for strings with duplicate characters")
    void shouldReturnFalseForDuplicateStrings(String input) {
        assertThat(checker.hasAllUniqueCharacters(input)).isFalse();
    }
}