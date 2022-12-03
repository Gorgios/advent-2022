import pl.jreclaw.advent.Day01
import pl.jreclaw.advent.Resources.fileAsListOfString

fun main(args: Array<String>) {
    val day1input = fileAsListOfString("Day01.txt")
    println("Day 1 part 1: ${Day01(day1input).solvePart1()}")
    println("Day 1 part 2: ${Day01(day1input).solvePart2()}")

}