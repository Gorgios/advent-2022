package pl.jreclaw.advent

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Day15(private val input: List<String>) {

    fun solvePart1(row: Int): Int {
        val map: Map<Pair<Int, Int>, Pair<Int, Int>> = parseInput()
        val beaconsOnRow = map.values.filter { it.second == row }.map { it.first }.toSet()
        return map.flatMap {
            illegalPositionsOnRow(it.key, it.value, row)
        }.toSet().filterNot { beaconsOnRow.contains(it) }.size
    }

    fun solvePart2(maxRow: Int): Long {
        val map: Map<Pair<Int, Int>, Pair<Int, Int>> = parseInput()
        val illegalPositions: MutableMap<Int, MutableList<IntRange>> = HashMap()
        map.forEach {
            val newPositions = illegalPositions(it.key, it.value, maxRow)
            newPositions.forEach { (k, v) ->
                illegalPositions.getOrPut(k) { ArrayList() }.add(v)
            }
        }
        illegalPositions.forEach { (key, value) ->
            val sorted = value.sortedWith(compareBy({ it.first }, { it.last }))
            var currMax = 0
            for (j in 0 until sorted.size - 1) {
                currMax = max(sorted[j].last, currMax)
                if (currMax - sorted[j + 1].first < -1) {
                    return (currMax + 1).toLong() * 4_000_000 + key
                }
            }
        }
        return 0
    }

    private fun parseInput(): Map<Pair<Int, Int>, Pair<Int, Int>> =
        input.associate {
            val split = it.split(":")
                .map { s -> s.replaceBefore("x=", "") }
                .map { s -> s.replace("x=", "") }
                .map { s -> s.replace("y=", "") }
            val sensor = Pair(split[0].split(",")[0].trim().toInt(), split[0].split(",")[1].trim().toInt())
            val beacon = Pair(split[1].split(",")[0].trim().toInt(), split[1].split(",")[1].trim().toInt())
            sensor to beacon
        }

    private fun illegalPositionsOnRow(sensor: Pair<Int, Int>, beacon: Pair<Int, Int>, row: Int): IntRange {
        val dist = dist(sensor, beacon)
        val diff = abs(row - sensor.second)
        if (diff > dist) {
            return IntRange.EMPTY
        }
        return IntRange(sensor.first - (dist) + diff, sensor.first + dist - diff)
    }

    private fun illegalPositions(sensor: Pair<Int, Int>, beacon: Pair<Int, Int>, max: Int): Map<Int, IntRange> {
        val dist = dist(sensor, beacon)
        return IntRange(max(-sensor.second, -dist), min(dist, max - sensor.second)).associate {
            sensor.second + it to IntRange(
                max(0, sensor.first - (dist - abs(it))),
                min(sensor.first + (dist - abs(it)), max)
            )
        }
    }

    private fun dist(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int =
        abs(p1.first - p2.first) + abs(p1.second - p2.second)
}