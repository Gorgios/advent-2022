package pl.jreclaw.advent

class Day21(private val input: List<String>) {

    fun solvePart1(): Long {
        return getMap()["root"]!!
    }

    fun solvePart2(): Long {
        val human = "humn"
        var elem = human
        val omit = mutableListOf(human)
        val rootLine = input.first { it.startsWith("root") }.substringAfter(":")
        while (!rootLine.contains(elem)) {
            elem = input.first() { !it.startsWith(elem) && it.contains(elem) }.substringBefore(":").trim()
            omit.add(elem)
        }
        val map = getMap().toMutableMap()
        omit.forEach { map.remove(it) }
        var toReplace = omit.last()
        var goal = map[rootLine.split("\\+|-|\\*|/".toRegex()).filter { it.isNotBlank() }.first {
            it.trim() != toReplace
        }.trim()]!!
        map[toReplace] = goal
        while (toReplace != human) {
            val split = input.first { it.trim().startsWith(toReplace) }.substringAfter(":").split(" ")
                .map { it.trim() }.filter { it.isNotBlank() }
            goal = reverseCalc(map, toReplace, split)
            toReplace = if (map.containsKey(split[0])) {
                split[2]
            } else {
                split[0]
            }
            map[toReplace] = goal
        }
        return map[human]!!
    }

    private fun getMap(): Map<String, Long> {
        var copy = input.toMutableList()
        val map = input.filter {
            when (it.substringAfter(": ").trim().toLongOrNull()) {
                is Long -> true
                else -> false
            }
        }.associate {
            it.substringBefore(":") to it.substringAfter(": ").toLong()
        }.toMutableMap()
        while (map.size < input.size) {
            for (line in ArrayList(copy)) {
                val split = line.substringAfter(": ").split(" ").map { s -> s.trim() }
                if (split.size == 3 && map.contains(split[0]) && map.contains(split[2])) {
                    map[line.substringBefore(":")] = calc(map, split)
                    copy.remove(line)
                }
            }
        }
        return map.toMap()
    }

    private fun calc(map: Map<String, Long>, split: List<String>): Long =
        when (split[1]) {
            "*" -> map[split[0]]!! * map[split[2]]!!
            "-" -> map[split[0]]!! - map[split[2]]!!
            "+" -> map[split[0]]!! + map[split[2]]!!
            else -> map[split[0]]!! / map[split[2]]!!
        }

    private fun reverseCalc(map: Map<String, Long>, toReplace: String, w: List<String>): Long =
        when (w[1]) {
            "/" -> when (map.containsKey(w[0])) {
                true -> map[w[0]]!! / map[toReplace]!!
                else -> map[toReplace]!! * map[w[2]]!!
            }

            "-" -> when (map.containsKey(w[0])) {
                true -> map[w[0]]!! - map[toReplace]!!
                else -> map[toReplace]!! + map[w[2]]!!
            }

            "+" -> when (map.containsKey(w[0])) {
                true -> map[toReplace]!! - map[w[0]]!!
                else -> map[toReplace]!! - map[w[2]]!!
            }

            else -> when (map.containsKey(w[0])) {
                true -> map[toReplace]!! / map[w[0]]!!
                else -> map[toReplace]!! / map[w[2]]!!
            }
        }
}