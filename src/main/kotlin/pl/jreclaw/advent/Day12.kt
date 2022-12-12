package pl.jreclaw.advent

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Day12(private val input: Array<Array<Char>>) {

    fun solvePart1(): Int {
        var start: Pair<Int, Int> = Pair(0, 0)
        var end: Pair<Int, Int> = Pair(0, 0)
        val visited: MutableList<Pair<Int, Int>> = ArrayList()
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val before: MutableMap<Pair<Int, Int>, Pair<Int, Int>> = HashMap()
        input.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (c == 'S') {
                    start = Pair(j, i)
                    input[i][j] = 'a'
                }
                if (c == 'E') {
                    end = Pair(j, i)
                    input[i][j] = 'z'
                }
            }
        }
        queue.add(start)
        visited.add(start)
        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            if (pair == end) {
                var count = 0
                var currPair = pair
                while (currPair != start) {
                    count++
                    currPair = before[currPair]
                }
                return count
            }
            for (neighbor in getNeighbors(pair)) {
                if (isInRange(neighbor, input) && !visited.contains(neighbor) &&
                    (input[neighbor.second][neighbor.first].code - input[pair.second][pair.first].code <= 1)
                ) {
                    before[neighbor] = pair
                    visited.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }
        return 0
    }

    fun solvePart2(): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val visited: MutableList<Pair<Int, Int>> = ArrayList()
        val before: MutableMap<Pair<Int, Int>, Pair<Int, Int>> = HashMap()
        var end: Pair<Int, Int> = Pair(0, 0)
        input.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (c == 'E') {
                    end = Pair(j, i)
                    input[i][j] = 'z'
                }
            }
        }
        queue.add(end)
        visited.add(end)
        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            if (input[pair.second][pair.first] == 'a') {
                var count = 1
                var currPair = before[pair]!!
                while (currPair != end) {
                    count++
                    currPair = before[currPair]!!
                }
                return count
            }
            for (neighbor in getNeighbors(pair)) {
                if (isInRange(neighbor, input) && !visited.contains(neighbor) &&
                    (input[pair.second][pair.first].code - input[neighbor.second][neighbor.first].code <= 1)
                ) {
                    before[neighbor] = pair
                    visited.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }
        return 0
    }

    private fun isInRange(pair: Pair<Int, Int>, arr: Array<Array<Char>>): Boolean =
        pair.first >= 0 && pair.first < arr[0].size && pair.second >= 0 && pair.second < arr.size

    private fun getNeighbors(pair: Pair<Int, Int>): List<Pair<Int, Int>> {
        return listOf(
            Pair(pair.first + 1, pair.second),
            Pair(pair.first - 1, pair.second),
            Pair(pair.first, pair.second + 1),
            Pair(pair.first, pair.second - 1)
        )
    }

}