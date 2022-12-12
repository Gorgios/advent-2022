package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 12")
class Day12Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day12(Resources.fileAsChar2dArray("Day12Example.txt")).solvePart1();

        // assert
        assertEquals(answer, 31)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day12(Resources.fileAsChar2dArray("Day12.txt")).solvePart1();

        // assert
        assertEquals(answer, 520)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day12(Resources.fileAsChar2dArray("Day12Example.txt")).solvePart2();

        // assert
        assertEquals(answer, 29)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day12(Resources.fileAsChar2dArray("Day12.txt")).solvePart2();

        // assert
        assertEquals(answer, 508)
    }


}