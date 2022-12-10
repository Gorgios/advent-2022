package pl.jreclaw.advent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {

    @Test
    fun `Part 1 Example`() {
        // act
        val answer = Day10(Resources.fileAsListOfString("Day10Example.txt")).solvePart1();

        // assert
        assertEquals(answer, 13140)
    }

    @Test
    fun `Part 1 Actual`() {
        // act
        val answer = Day10(Resources.fileAsListOfString("Day10.txt")).solvePart1();

        // assert
        assertEquals(answer, 15220)
    }

    @Test
    fun `Part 2 Example`() {
        // act
        val answer = Day10(Resources.fileAsListOfString("Day10Example.txt")).solvePart2().split("\n")

        // assert
        Resources.fileAsListOfString("Day10ExampleResult.txt")
            .forEachIndexed {
                    index, s ->  assertEquals(answer[index], s)
            }
    }

    @Test
    fun `Part 2 Actual`() {
        // act
        val answer = Day10(Resources.fileAsListOfString("Day10.txt")).solvePart2().split("\n")

        // assert
        Resources.fileAsListOfString("Day10Result.txt")
            .forEachIndexed {
                index, s ->  assertEquals(answer[index], s)
            }
    }

}