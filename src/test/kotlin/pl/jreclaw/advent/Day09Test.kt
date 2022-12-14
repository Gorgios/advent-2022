package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 9")
class Day09Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day09(Resources.fileAsListOfString("Day09Example.txt")).solvePart1();

        // assert
        assertEquals(answer, 13)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day09(Resources.fileAsListOfString("Day09.txt")).solvePart1();

        // assert
        assertEquals(answer, 5883)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day09(Resources.fileAsListOfString("Day09Example.txt")).solvePart2();

        // assert
        assertEquals(answer, 1)
    }

    @Test
    fun `Part 2 Example 2`() {
        // act
        val answer = Day09(Resources.fileAsListOfString("Day09Example2.txt")).solvePart2();

        // assert
        assertEquals(answer, 36)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day09(Resources.fileAsListOfString("Day09.txt")).solvePart2();

        // assert
        assertEquals(answer, 2367)
    }
}