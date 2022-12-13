package pl.jreclaw.advent;

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 13")
class Day13Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day13(Resources.fileAsListOfString("Day13Example.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 13)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day13(Resources.fileAsListOfString("Day13.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 5393)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day13(Resources.fileAsListOfString("Day13Example.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 140)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day13(Resources.fileAsListOfString("Day13.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 26712)
    }
}
