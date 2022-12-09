package pl.jreclaw.advent

import kotlin.math.abs
import java.util.*
import kotlin.collections.HashSet

class Day09(private val input: List<String>) {

    fun solvePart1(): Int {
        val set: MutableSet<Point> = HashSet()
        var head = Point(0, 0)
        var tail = Point(0, 0)
        input.forEach {
            val split = it.trim().split(" ")
            for (i in 0 until split[1].toInt()) {
                head = moveHead(head, split[0][0])
                tail = moveTail(head, tail, split[0][0])
                set.add(tail)
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

    private fun moveTail(head: Point, tail: Point, dir: Char): Point {
        if (head.touching(tail)) {
            return tail
        }
        return when (dir) {
            'R' -> Point(head.x - 1, head.y)
            'L' -> Point(head.x + 1, head.y)
            'U' -> Point(head.x, head.y + 1)
            'D' -> Point(head.x, head.y - 1)
            else -> error("Unrecognized direction - \$(dir)}")
        }
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