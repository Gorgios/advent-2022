package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day21(Resources.fileAsListOfString("Day21Example.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 152)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day21(Resources.fileAsListOfString("Day21.txt")).solvePart1();

        // assert
        Assertions.assertEquals(answer, 364367103397416)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day21(Resources.fileAsListOfString("Day21Example.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 301)
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day21(Resources.fileAsListOfString("Day21.txt")).solvePart2();

        // assert
        Assertions.assertEquals(answer, 3782852515583)
    }
}