package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 8")
class Day08Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day08(Resources.fileAsListOfString("Day08Example.txt")).solvePart1();

        // assert
        assertEquals(answer, 21)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day08(Resources.fileAsListOfString("Day08.txt")).solvePart1();

        // assert
        assertEquals(answer, 1533)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day08(Resources.fileAsListOfString("Day08Example.txt")).solvePart2();

        // assert
        assertEquals(answer, 8)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day08(Resources.fileAsListOfString("Day08.txt")).solvePart2();

        // assert
        assertEquals(answer, 345744)
    }
}