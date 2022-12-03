package pl.jreclaw.advent

class Day01 (private val input: List<String>) {
    fun solvePart1(): Int = solve(1)

    fun solvePart2(): Int = solve(3)

    private fun solve(limit: Int): Int {
        val list = mutableListOf<Int>()
        var curr = 0
        for (food in input) {
            if (food.isEmpty()) {
                list.add(curr)
                curr = 0
            } else {
                curr += food.toInt()
            }
        }
        if (curr != 0) {
            list.add(curr)
        }
        return list.sortedDescending().take(limit).sum()
    }

}