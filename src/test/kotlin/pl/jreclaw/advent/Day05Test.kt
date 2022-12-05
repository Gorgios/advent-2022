package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {
    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day05(Resources.fileAsListOfString("Day05Example.txt")).solvePart1();

        // assert
        assertEquals(answer, "CMZ")
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day05(Resources.fileAsListOfString("Day05.txt")).solvePart1();

        // assert
        assertEquals(answer, "TQRFCBSJJ")
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day05(Resources.fileAsListOfString("Day05Example.txt")).solvePart2();

        // assert
        assertEquals(answer, "MCD")
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day05(Resources.fileAsListOfString("Day05.txt")).solvePart2();

        // assert
        assertEquals(answer, "RMHFJNVFP")
    }
}