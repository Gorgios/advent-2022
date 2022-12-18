package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 16")
class Day16Test {
    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day16(Resources.fileAsListOfString("Day16Example.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 1651)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day16(Resources.fileAsListOfString("Day16.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 1653)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day16(Resources.fileAsListOfString("Day16Example.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 1707)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day16(Resources.fileAsListOfString("Day16.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 2223)
    }


}