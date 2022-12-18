package pl.jreclaw.advent

import kotlin.math.max

class Day16(private val input: List<String>) {

    val cache: MutableMap<CacheRecord, Int> = HashMap()
    val nodes: MutableMap<String, Node> = HashMap()

    fun solvePart1(): Int {
        cache.clear()
        nodes.clear()
        val nameToNeighbors = getNameToNeighborsMap()
        for (node in nodes.values) {
            flatNeighbors(node, nameToNeighbors)
        }
        return nodes["AA"]?.find(30, HashSet(), false)!!
    }

    fun solvePart2(): Int {
        cache.clear()
        nodes.clear()
        val nameToNeighbors = getNameToNeighborsMap()
        for (node in nodes.values) {
            flatNeighbors(node, nameToNeighbors)
        }
        return nodes["AA"]?.find(26, HashSet(), true)!!
    }

    private fun flatNeighbors(node: Node, nameToNeighbors: Map<String, List<String>>) {
        val visited = mutableSetOf(node.name)
        val neighbors = ArrayList(nameToNeighbors[node.name]!!).toMutableList()
        var dist = 1
        var traverse = true
        while (traverse) {
            traverse = false
            for (neighbor in ArrayList(neighbors)) {
                if (visited.contains(neighbor)) {
                    continue
                }
                if (nodes[neighbor]?.rate == 0) {
                    neighbors.addAll(nameToNeighbors[neighbor]!!)
                    visited.add(neighbor)
                    traverse = true
                } else {
                    node.addAdj(nodes[neighbor]!!, dist)
                    visited.add(neighbor)
                }
                neighbors.remove(neighbor)
            }
            dist++
        }
    }


    // side effect - creates nodes
    private fun getNameToNeighborsMap(): Map<String, List<String>> =
        input.associate {
            val name = it.substring(6, 8)
            val rate = it.substringAfter("=").substringBefore(";").toInt()
            val adj = it.substringAfter("valve").replace("s ", "").split(",").map { it.trim() }
            nodes[name] = Node(name, rate)
            name to adj
        }

    inner class Node(val name: String, val rate: Int, val adj: MutableMap<Node, Int> = HashMap()) {

        fun addAdj(node: Node, k: Int) {
            adj[node] = k
        }

        fun find(minutes: Int, visited: Set<String>, elephantAfter: Boolean): Int {
            if (minutes <= 1) {
                return when (elephantAfter) {
                    true -> nodes["AA"]?.find(26, visited, false)!!
                    else -> 0
                }
            }
            if (cache.containsKey(CacheRecord(this, minutes, visited, elephantAfter))) {
                return cache[CacheRecord(this, minutes, visited, elephantAfter)]!!
            }
            var max = 0
            for (neighbor in adj) {
                max = if (visited.contains(name)) {
                    max(max, neighbor.key.find(minutes - neighbor.value, visited, elephantAfter))
                } else {
                    max(
                        max, max(
                            rate * (minutes - 1) + neighbor.key.find(
                                minutes - neighbor.value - 1,
                                visited + name,
                                elephantAfter
                            ),
                            neighbor.key.find(minutes - neighbor.value, visited, elephantAfter)
                        )
                    )
                }
            }
            cache[CacheRecord(this, minutes, visited, elephantAfter)] = max
            return max
        }

        override fun toString(): String =
            name

    }

    data class CacheRecord(val node: Node, val minutes: Int, val visited: Set<String>, val elephantAfter: Boolean)


}