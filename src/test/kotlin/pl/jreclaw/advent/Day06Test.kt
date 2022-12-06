package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day06Test {

    private val input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day06(input).solvePart1();

        // assert
        assertEquals(answer, 11)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day06(Resources.fileAsString("Day06.txt")).solvePart1();

        // assert
        assertEquals(answer, 1134)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day06(input).solvePart2();

        // assert
        assertEquals(answer, 26)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day06(Resources.fileAsString("Day06.txt")).solvePart2();

        // assert
        assertEquals(answer, 2263)
    }
}