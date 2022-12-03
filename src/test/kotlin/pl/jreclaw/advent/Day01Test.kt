package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {
    // arrange
    private val exampleInput =
        listOf("1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000");

    @Test
    fun `Part 1`() {
        // act
        val answer = Day01(exampleInput).solvePart1();

        // assert
        assertEquals(answer, 24000)
    }

    @Test
    fun `Part 2`() {
        // act
        val answer = Day01(exampleInput).solvePart2();

        // assert
        assertEquals(answer, 45000)
    }
}