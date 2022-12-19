package pl.jreclaw.advent

import kotlin.math.max

class Day17(private val input: String) {

    fun solvePart1(): Long =
        solve(2022)

    fun solvePart2(): Long =
        solve(1000000000000)

    private fun solve(goal: Long): Long {
        val grid: MutableMap<Int, Array<Boolean>> = HashMap()
        val cache: MutableMap<Cache, Pair<Int, Int>> = HashMap()
        val cacheCounter: MutableMap<Cache, Int> = HashMap()

        grid[0] = Array(7) { true }
        for (i in 1..4) {
            grid[i] = Array(7) { false }
        }

        val moves = Move.values()
        var maxHeight = 0
        var rock = 0L
        var index = 0
        var cumulatedHeight = 0L
        var toSubtract = 0
        var nextMove = 0
        var stillCache = true
        var currMove = ArrayList(moves[0].struct).toMutableList().map { Pair(it.first, it.second + 4) }

        while (rock < goal) {
            val operation = input[index]
            currMove = performOperation(operation, currMove, grid)
            currMove = currMove.map { Pair(it.first, it.second - 1) }.toMutableList()
            if (performOperation(
                    input[(index + 1) % input.length],
                    currMove,
                    grid
                ).any() { grid[it.second - 1]!![it.first] }
            ) {
                var max = 0
                index = (index + 1) % input.length
                currMove = performOperation(input[index], currMove, grid)
                currMove.forEach {
                    max = max(max, it.second)
                    grid[it.second]!![it.first] = true
                }
                maxHeight = max(maxHeight, max)
                rock++
                nextMove = (nextMove + 1)%moves.size
                currMove = ArrayList(moves[nextMove].struct).toMutableList()
                    .map { Pair(it.first, it.second + 4 + maxHeight) }
                IntRange(maxHeight, maxHeight + 7).forEach { grid.putIfAbsent(it, Array(7) { false }) }

                val last5: MutableList<Pair<Int, Int>> = ArrayList()
                for (i in maxHeight - 4..maxHeight) {
                    for (j in 0..6) {
                        if (grid.containsKey(maxHeight) && grid[maxHeight]!![j]) {
                            last5.add(Pair(j, i - maxHeight))
                        }
                    }
                }
                val ca = Cache(last5, nextMove, index)
                if (stillCache) {
                    // need minimum 2 caches to avoid random cases
                    if (cache.containsKey(ca) && cacheCounter[ca]!! > 1) {
                        val diff = rock - cache[ca]!!.first
                        val diffHeight = maxHeight - cache[ca]!!.second
                        cumulatedHeight = maxHeight + ((goal - rock) / diff) * diffHeight
                        rock += ((goal - rock) / diff) * diff
                        toSubtract = maxHeight
                        stillCache = false
                    }
                    cache[ca] = Pair(rock.toInt(), maxHeight)
                    cacheCounter.putIfAbsent(ca, 0)
                    cacheCounter[ca] = cacheCounter[ca]!! + 1
                }
            }

            index = (index + 1) % input.length
        }
        return cumulatedHeight + (maxHeight - toSubtract)
    }

    private fun performOperation(
        operation: Char,
        currMove: List<Pair<Int, Int>>,
        grid: Map<Int, Array<Boolean>>
    ): List<Pair<Int, Int>> {
        return when (operation) {
            '>' ->
                if (!currMove.any() { it.first + 1 > 6 } && !currMove.any() { pair -> grid[pair.second]!![pair.first + 1] }) {
                    currMove.map { Pair(it.first + 1, it.second) }
                } else {
                    currMove
                }

            else ->
                if (!currMove.any() { it.first - 1 < 0 } && !currMove.any() { pair -> grid[pair.second]!![pair.first - 1] }) {
                    currMove.map { Pair(it.first - 1, it.second) }
                } else {
                    currMove
                }
        }
    }


    enum class Move(val struct: List<Pair<Int, Int>>) {
        PLAIN(listOf(Pair(2, 0), Pair(3, 0), Pair(4, 0), Pair(5, 0))),
        CROSS(listOf(Pair(3, 0), Pair(2, 1), Pair(3, 1), Pair(4, 1), Pair(3, 2))),
        REVERSED_L(listOf(Pair(2, 0), Pair(3, 0), Pair(4, 0), Pair(4, 1), Pair(4, 2))),
        I(listOf(Pair(2, 0), Pair(2, 1), Pair(2, 2), Pair(2, 3))),
        SQUARE(listOf(Pair(2, 0), Pair(2, 1), Pair(3, 0), Pair(3, 1)))

    }

    data class Cache(val last5: List<Pair<Int, Int>>, val move: Int, val index: Int) {

    }
}