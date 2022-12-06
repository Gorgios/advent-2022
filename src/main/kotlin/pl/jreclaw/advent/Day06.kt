package pl.jreclaw.advent

class Day06 (private val input: String) {

    fun solvePart1() =
        solve(4)

    fun solvePart2() =
        solve(14)

    private fun solve(chunks: Int) =
        chunks + IntRange(0, input.length - 1 - chunks)
            .first{
                input.substring(it, it + chunks)
                    .split("")
                    .filter { s -> s.isNotEmpty() }
                    .distinct()
                    .size == chunks
            }
}