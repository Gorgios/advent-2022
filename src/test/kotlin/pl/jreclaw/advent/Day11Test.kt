package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 11")
class Day11Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day11(Resources.fileAsListOfString("Day11Example.txt")).solvePart1();

        // assert
        assertEquals(answer, 10605)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day11(Resources.fileAsListOfString("Day11.txt")).solvePart1();

        // assert
        assertEquals(answer, 66802)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day11(Resources.fileAsListOfString("Day11Example.txt")).solvePart2();

        // assert
        assertEquals(answer, 2713310158)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day11(Resources.fileAsListOfString("Day11.txt")).solvePart2();

        // assert
        assertEquals(answer, 21800916620)
    }


}