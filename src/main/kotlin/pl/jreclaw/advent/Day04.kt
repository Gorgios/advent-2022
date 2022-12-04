package pl.jreclaw.advent

class Day04(private val input: List<String>) {

    fun solvePart1(): Int =
        getListOfPairRanges().count {
            val intersect = it[0].intersect(it[1])
            (intersect == it[0]) or (intersect == it[1])
        }

    fun solvePart2(): Int =
        getListOfPairRanges().count {
            it[0].intersect(it[1]).isNotEmpty()
        }

    private fun getListOfPairRanges(): List<List<Set<Int>>> =
        input.flatMap {
            it.split(",")
        }.map {
            val split = it.split("-")
            IntRange(split[0].toInt(), split[1].toInt()).toSet()
        }.chunked(2)

}