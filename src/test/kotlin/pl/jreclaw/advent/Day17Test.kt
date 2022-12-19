package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 17")
class Day17Test {

    private val input = ">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>";

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day17(input).solvePart1();

        // assert
        Assertions.assertEquals(answer, 3068)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day17(Resources.fileAsString("Day17.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 3191)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day17(input).solvePart2();

        // assert
        Assertions.assertEquals(answer, 1514285714288)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day17(Resources.fileAsString("Day17.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 1572093023267)
    }
}