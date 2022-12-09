package pl.jreclaw.advent

import java.util.*
import kotlin.collections.HashSet
import kotlin.math.abs
import kotlin.math.sign

class Day09(private val input: List<String>) {

    fun solvePart1(): Int =
        solve(2)

    fun solvePart2(): Int =
        solve(10)

    private fun solve(size: Int): Int {
        val set: MutableSet<Point> = HashSet()
        val parts = Array(size) { Point(0, 0) }
        input.forEach {
            val split = it.trim().split(" ")
            for (i in 0 until split[1].toInt()) {
                parts[0] = moveHead(parts[0], split[0][0])
                for (j in 1 until size) {
                    parts[j] = moveTail(parts[j - 1], parts[j])
                }
                set.add(parts.last())
            }
        }
        return set.size
    }

    private fun moveHead(head: Point, dir: Char): Point =
        when (dir) {
            'R' -> Point(head.x + 1, head.y)
            'L' -> Point(head.x - 1, head.y)
            'U' -> Point(head.x, head.y - 1)
            'D' -> Point(head.x, head.y + 1)
            else -> error("Unrecognized direction - \$(dir)}")
        }

    private fun moveTail(head: Point, tail: Point): Point {
        if (head.touching(tail)) {
            return tail
        }
        val yDiff = head.y - tail.y
        val xDiff = head.x - tail.x
        return Point(tail.x + (xDiff.sign + xDiff) / 2, tail.y + (yDiff.sign + yDiff) / 2)
    }

    class Point(val x: Int, val y: Int) {

        fun touching(other: Point): Boolean =
            abs(x - other.x) <= 1 && abs(y - other.y) <= 1

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Point)
                return false
            else {
                if (other.x == this.x && other.y == this.y)
                    return true
            }
            return false
        }

        override fun hashCode() = Objects.hash(x, y)

        override fun toString() = "($x,$y)"

    }
}