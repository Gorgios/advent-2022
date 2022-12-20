package pl.jreclaw.advent

import kotlin.math.abs

class Day18(input: List<String>) {

    private val triples = input.map {
        val split = it.split(",")
        Triple(split[0].toInt(), split[1].toInt(), split[2].toInt())
    }

    private val xMin = triples.minOfOrNull { it.first }!!
    private val xMax = triples.maxOfOrNull { it.first }!!
    private val yMin = triples.minOfOrNull { it.second }!!
    private val yMax = triples.maxOfOrNull { it.second }!!
    private val zMin = triples.minOfOrNull { it.third }!!
    private val zMax = triples.maxOfOrNull { it.third }!!

    private val remaining = IntRange(xMin, xMax).flatMap { x ->
        IntRange(yMin, yMax).flatMap { y ->
            IntRange(zMin, zMax).map { z ->
                Triple(x, y, z)
            }.filterNot { triples.contains(it) }
        }
    }.toSet()

    fun solvePart1(): Int =
        triples.sumOf { p1 ->
            6 - triples.count { p2 -> touching(p1, p2) }
        }

    fun solvePart2(): Int {
        val notTrapped: MutableSet<Triple<Int, Int, Int>> = HashSet()
        remaining.filter {
            listOf(xMin, xMax).contains(it.first) ||
                    listOf(yMin, yMax).contains(it.second) ||
                    listOf(zMin, zMax).contains(it.third)
        }.forEach {
            dfs(it.first, it.second, it.third, remaining, notTrapped)
        }
        return solvePart1() - remaining.minus(notTrapped).sumOf { p1 ->
            triples.count { p2 -> touching(p1, p2) }
        }
    }

    private fun dfs(
        x: Int,
        y: Int,
        z: Int,
        grid: Set<Triple<Int, Int, Int>>,
        visited: MutableSet<Triple<Int, Int, Int>>
    ) {
        if (x < xMin || x > xMax || y < yMin || y > yMax || z < zMin || z > zMax ||
            visited.contains(Triple(x, y, z)) || !grid.contains(Triple(x, y, z))
        ) {
            return
        }
        visited.add(Triple(x, y, z))
        dfs(x + 1, y, z, grid, visited)
        dfs(x - 1, y, z, grid, visited)
        dfs(x, y + 1, z, grid, visited)
        dfs(x, y - 1, z, grid, visited)
        dfs(x, y, z + 1, grid, visited)
        dfs(x, y, z - 1, grid, visited)
    }


    private fun touching(p1: Triple<Int, Int, Int>, p2: Triple<Int, Int, Int>): Boolean {
        var sum = 0
        var same = 0
        for (i in 0 until 3) {
            if (p1.toList()[i] == p2.toList()[i]) {
                same++;
            } else {
                sum += abs(p1.toList()[i] - p2.toList()[i])
            }
        }
        return same == 2 && sum == 1
    }
}
