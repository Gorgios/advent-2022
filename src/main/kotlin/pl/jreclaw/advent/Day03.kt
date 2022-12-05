package pl.jreclaw.advent

class Day03(private val input: List<String>) {

    fun solvePart1(): Int =
        input.sumOf {
            val a1 = it.substring(0, it.length / 2).split("")
            val a2 = it.substring(it.length / 2).split("")
            val common = a1.intersect(a2.toSet()).single { e -> e.isNotEmpty() }
            calcCode(common.first())
        }

    fun solvePart2(): Int =
        input.asSequence()
            .map { s -> s.split("").filter { it.isNotEmpty() }.toSet() }
            .chunked(3)
            .map {
                it.reduce { curr, next ->
                    curr.intersect(next)
                }
            }.map {
                it.single().first()
            }.sumOf { calcCode(it)
            }

    private fun calcCode(character: Char): Int =
        1 + when (val c = character.code) {
            in 'a'.code..'z'.code -> c - 'a'.code
            else -> c - 'A'.code + 26
        }

}
