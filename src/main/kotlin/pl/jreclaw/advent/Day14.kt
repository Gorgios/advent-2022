package pl.jreclaw.advent

import kotlin.math.max
import kotlin.math.min

class Day14(private val input: List<String>) {

    fun solvePart1(): Int =
        play(1)

    fun solvePart2(): Int =
        play(2)

    private fun play(part: Int): Int {
        val obstacles = generateObstacles()
        var counter = 0
        val lowest = obstacles.map { it.second }.max() + when (part) {
            1 -> 0
            else -> 1
        }
        while (true) {
            var start = Pair(500, 0);
            while (true) {
                if (start.second == lowest) {
                    if (part == 1) {
                        return counter
                    } else {
                        obstacles.add(start)
                        break;
                    }
                } else if (!obstacles.contains(Pair(start.first, start.second + 1))) {
                    start = Pair(start.first, start.second + 1)
                } else if (!obstacles.contains(Pair(start.first - 1, start.second + 1))) {
                    start = Pair(start.first - 1, start.second + 1)
                } else if (!obstacles.contains(Pair(start.first + 1, start.second + 1))) {
                    start = Pair(start.first + 1, start.second + 1)
                } else {
                    obstacles.add(start)
                    if (part == 2 && start == Pair(500, 0)) {
                        return counter + 1
                    }
                    break
                }
            }
            counter++
        }
    }

    private fun generateObstacles(): MutableSet<Pair<Int, Int>> {
        val obstacles: MutableSet<Pair<Int, Int>> = HashSet()
        input.forEach {
            val split = it.split("->").map { el -> el.trim() }
            for (i in 0 until split.size - 1) {
                val from = split[i].split(",")
                val to = split[i + 1].split(",")
                if (from[1].toInt() == to[1].toInt()) {
                    for (x in min(from[0].toInt(), to[0].toInt())..max(from[0].toInt(), to[0].toInt())) {
                        obstacles.add(Pair(x, from[1].toInt()))
                    }
                } else {
                    for (y in min(from[1].toInt(), to[1].toInt())..max(from[1].toInt(), to[1].toInt())) {
                        obstacles.add(Pair(from[0].toInt(), y))
                    }
                }
            }
        }
        return obstacles
    }
}