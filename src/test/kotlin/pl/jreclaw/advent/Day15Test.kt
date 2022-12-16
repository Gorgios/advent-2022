package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 15")
class Day15Test {
    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day15(Resources.fileAsListOfString("Day15Example.txt")).solvePart1(10);

        // assert
        Assertions.assertEquals(answer, 26)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day15(Resources.fileAsListOfString("Day15.txt")).solvePart1(2_000_000);

        // assert
        Assertions.assertEquals(answer, 4876693)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day15(Resources.fileAsListOfString("Day15Example.txt")).solvePart2(20);

        // assert
        Assertions.assertEquals(answer, 56000011)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day15(Resources.fileAsListOfString("Day15.txt")).solvePart2(4_000_000);

        // assert
        Assertions.assertEquals(answer, 11645454855041)
    }
}