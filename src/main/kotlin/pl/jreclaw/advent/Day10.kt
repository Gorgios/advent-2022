package pl.jreclaw.advent

class Day10(private val input: List<String>) {

    fun solvePart1(): Int {
        val results: MutableList<Int> = ArrayList()
        var pos = 1
        var cycle = 0
        input.forEach {
            val split = it.split(" ")
            if ((++cycle - 20) % 40 == 0) {
                results.add(pos * cycle)
            }
            if (split[0] == "addx") {
                if ((++cycle - 20) % 40 == 0) {
                    results.add(pos * cycle)
                }
                pos += split[1].toInt()
            }
        }
        return results.sum()
    }

    fun solvePart2(): String {
        var pos = 1
        var cycle = 0
        var result = ""
        input.forEach {
            val split = it.split(" ")
            if (++cycle % 40 == 1) {
                result += "\n";
                cycle = 1
            }
            result = updateResult(cycle, pos, result)
            if (split[0] == "addx") {
                if(++cycle % 40 == 1) {
                    result += "\n"
                    cycle = 1
                }
                result = updateResult(cycle, pos, result)
                pos += split[1].toInt()
            }
        }
        return result.trim()
    }

    private fun updateResult(cycle: Int, pos: Int, result: String): String =
        result + when(cycle - pos in 0..2) {
            true -> "#"
            else -> "."
        }
}