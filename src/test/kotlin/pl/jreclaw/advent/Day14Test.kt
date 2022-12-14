package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {
    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day14(Resources.fileAsListOfString("Day14Example.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 24)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day14(Resources.fileAsListOfString("Day14.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 828)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day14(Resources.fileAsListOfString("Day14Example.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 93)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day14(Resources.fileAsListOfString("Day14.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 25500)
    }
}