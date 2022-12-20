package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 18")
class Day18Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day18(Resources.fileAsListOfString("Day18Example.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 64)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day18(Resources.fileAsListOfString("Day18.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 4288)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day18(Resources.fileAsListOfString("Day18Example.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 58)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day18(Resources.fileAsListOfString("Day18.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 2494)
    }

}