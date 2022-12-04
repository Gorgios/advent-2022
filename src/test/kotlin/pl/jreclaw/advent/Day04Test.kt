package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day04Test {
    // arrange
    private val exampleInput =
        listOf(
            "2-4,6-8",
            "2-3,4-5",
            "5-7,7-9",
            "2-8,3-7",
            "6-6,4-6",
            "2-6,4-8"
        )

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day04(exampleInput).solvePart1();

        // assert
        assertEquals(answer, 2)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day04(Resources.fileAsListOfString("Day04.txt")).solvePart1();

        // assert
        assertEquals(answer, 444)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day04(exampleInput).solvePart2();

        // assert
        assertEquals(answer, 4)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day04(Resources.fileAsListOfString("Day04.txt")).solvePart2();

        // assert
        assertEquals(answer, 801)
    }
}