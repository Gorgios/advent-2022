package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 20")
class Day20Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day20(Resources.fileAsListOfLong("Day20Example.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 3)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day20(Resources.fileAsListOfLong("Day20.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 6640)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day20(Resources.fileAsListOfLong("Day20Example.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 1623178306)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day20(Resources.fileAsListOfLong("Day20.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 11893839037215)
    }

}