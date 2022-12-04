package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day03Test {
    // arrange
    private val exampleInput =
        listOf(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
        )

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day03(exampleInput).solvePart1();

        // assert
        assertEquals(answer, 157)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day03(Resources.fileAsListOfString("Day03.txt")).solvePart1();

        // assert
        assertEquals(answer, 7850)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day03(exampleInput).solvePart2();

        // assert
        assertEquals(answer, 70)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day03(Resources.fileAsListOfString("Day03.txt")).solvePart2();

        // assert
        assertEquals(answer, 2581)
    }
}