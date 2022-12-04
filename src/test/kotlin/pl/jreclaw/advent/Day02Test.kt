package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {
    // arrange
    private val exampleInput =
        listOf("A Y", "B X", "C Z");

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day02(exampleInput).solvePart1();

        // assert
        assertEquals(answer, 15)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day02(Resources.fileAsListOfString("Day02.txt")).solvePart1();

        // assert
        assertEquals(answer, 13268)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day02(exampleInput).solvePart2();

        // assert
        assertEquals(answer, 12)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day02(Resources.fileAsListOfString("Day02.txt")).solvePart2();

        // assert
        assertEquals(answer, 15508)
    }

}