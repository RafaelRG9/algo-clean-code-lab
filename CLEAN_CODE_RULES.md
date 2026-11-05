Rule 1 (Function Length): Functions should do one thing, do it well, and do it only (target: under 15 lines).

Rule 2 (Meaningful Names): Avoid single-letter variables except standard loop counters (i, j). Use intention-revealing names (e.g., hasSeenCharacter, characterCode).

Rule 3 (Guard Clauses): Handle edge cases (null, empty strings, oversized inputs) at the very top of the function to reduce nested indentation.