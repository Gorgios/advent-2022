package pl.jreclaw.advent

import java.util.*

class Day05(private val input: List<String>) {

    fun solvePart1(): String = solve(true)

    fun solvePart2(): String = solve(false)


    private fun solve(reversed: Boolean): String {
        val stacks = getInitialStacks()
        input.subList(input.indexOf("") + 1, input.size)
            .map {
                val replaced = it.replace("(move |from |to )".toRegex(), "")
                val split = replaced.split(" ").filter { el -> el.isNotBlank() }
                Triple(split[0].toInt(), split[1].toInt() - 1, split[2].toInt() - 1)
            }.forEach { triple ->
                val stack: Stack<Char> = when (reversed) {
                    true -> stacks[triple.third]
                    else -> Stack()
                }
                IntRange(0, triple.first - 1).forEach { _ ->
                    stack.add(stacks[triple.second].pop())
                }
                if (!reversed) {
                    while (stack.isNotEmpty()) {
                        stacks[triple.third].add(stack.pop())
                    }
                }
            }
        return stacks.map { it.pop() }.fold("") { a, b -> a + b }
    }

    private fun getInitialStacks(): List<Stack<Char>> {
        val results = mutableListOf<Stack<Char>>()
        var index = input.indexOf("") - 1
        input[index].split(" ").filter { it.isNotBlank() }.forEach { _ ->
            results.add(Stack())
        }
        index--
        while (index >= 0) {
            val line = input[index];
            line.split("").chunked(4).filter { it.size == 4 }.withIndex().forEach {
                val c = it.value.filter { el -> el.isNotEmpty() }.map { str -> str.single() }
                    .singleOrNull { c -> IntRange('A'.code, 'Z'.code).contains(c.code) }
                if (c != null) {
                    results[it.index].add(c)
                }
            }
            index--;
        }
        return results
    }
}