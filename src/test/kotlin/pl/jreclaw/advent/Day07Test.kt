package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 7")
class Day07Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day07(Resources.fileAsListOfString("Day07Example.txt")).solvePart1();

        // assert
        assertEquals(answer, 95437)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day07(Resources.fileAsListOfString("Day07.txt")).solvePart1();

        // assert
        assertEquals(answer, 1581595)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day07(Resources.fileAsListOfString("Day07Example.txt")).solvePart2();

        // assert
        assertEquals(answer, 24933642)
    }

    @Test
    fun `Part 2 lsActual`() {
        // act
        val answer = Day07(Resources.fileAsListOfString("Day07.txt")).solvePart2();

        // assert
        assertEquals(answer, 1544176)
    }
}