package pl.jreclaw.advent

class Day11(private val input: List<String>) {

    fun solvePart1(): Long =
        solve(1, 20)

    fun solvePart2(): Long =
        solve(2, 10000)

    private fun solve(part: Int, size: Int): Long {
        val map: Map<Int, Monkey> = getMonkeyMap(part)
        for (k in 0 until size) {
            for (i in 0 until map.size) {
                map[i]?.play(map)
            }
        }
        return map.values.map { it.getCount() }.sortedDescending().take(2).reduce { acc, i -> i * acc }
    }

    private fun getMonkeyMap(part: Int): Map<Int, Monkey> {
        val map: MutableMap<Int, Monkey> = HashMap()
        val newInput = input.map { it.trim() }.chunked(7)
        val moduloMap: MutableMap<Int, Int> = HashMap()
        var id = 0
        newInput.forEach { s ->
            s.forEach {
                if (it.startsWith("Test: divisible by ")) {
                    moduloMap[id] = it.replace("Test: divisible by ", "").toInt()
                    id++
                }
            }
        }
        newInput.forEach {
            var monkeyId = -1
            var operation = ' '
            var factor = "old"
            val list: MutableList<Item> = ArrayList()
            val throwTo: MutableMap<Boolean, Int> = HashMap()
            it.forEach { s ->
                if (s.startsWith("Monkey")) {
                    monkeyId = s.split(" ")[1].first().digitToInt()
                }
                else if (s.startsWith("Starting items:")) {
                    val replaced = s.replace("Starting items: ", "").split(",")
                    replaced.filter { it.isNotBlank() }.forEach { itemValue ->
                        when (part) {
                            1 -> list.add(Part1Item(itemValue.trim().toInt(), moduloMap))
                            else -> list.add(Part2Item(itemValue.trim().toInt(), moduloMap))
                        }
                    }
                }
                else if (s.trim().startsWith("Operation: new = old")) {
                    val replaced = s.replace("Operation: new = old ", "").split(" ")
                    operation = replaced[0].first()
                    factor = replaced[1]
                }
                else if (s.trim().startsWith("If true: throw to monkey ")) {
                    throwTo[true] = s.replace("If true: throw to monkey ", "").toInt()
                }
                else if (s.trim().startsWith("If false: throw to monkey ")) {
                    throwTo[false] = s.replace("If false: throw to monkey ", "").toInt()
                }
            }
            map[monkeyId] = Monkey(monkeyId, list, operation, factor, throwTo)
        }
        return map
    }

    class Monkey(
        private val id: Int,
        private val items: MutableList<Item>,
        private val operation: Char,
        private val factor: String,
        private val throwTo: Map<Boolean, Int>,
        private var count: Long = 0L
    ) {
        fun getCount(): Long =
            count

        private fun addItem(item: Item) {
            items.add(item)
        }

        fun play(monkeys: Map<Int, Monkey>) {
            while (items.size > 0) {
                val first = items.removeFirst()
                when (operation) {
                    '*' -> when (factor) {
                        "old" -> first.square()
                        else -> first.updateValue(0, factor.toInt())
                    }

                    '+' -> when (factor) {
                        "old" -> first.addSame()
                        else -> first.updateValue(factor.toInt(), 1)
                    }
                }
                count++
                val mo = monkeys[throwTo[first.meetReq(id)]]
                mo?.addItem(first)
            }
        }

    }

    interface Item {
        fun updateValue(add: Int, mul: Int)
        fun square()
        fun addSame()
        fun meetReq(monkey: Int): Boolean

    }

    class Part1Item(private var number: Int, private val moduloMap: Map<Int, Int>) : Item {
        override fun updateValue(add: Int, mul: Int) {
            number = (number * mul + add) / 3
        }

        override fun square() {
            number = (number * number) / 3
        }

        override fun addSame() {
            number = (number * 2) / 3
        }

        override fun meetReq(monkey: Int): Boolean {
            return number % moduloMap[monkey]!! == 0
        }

    }

    class Part2Item(private val number: Int, private val moduloMap: Map<Int, Int>) : Item {
        private val resultsMap: MutableMap<Int, Int> = HashMap()

        init {
            moduloMap.forEach {
                resultsMap.put(it.key, number % it.value)
            }
        }

        override fun updateValue(add: Int, mul: Int) {
            resultsMap.forEach {
                resultsMap[it.key] = (it.value * mul + add) % moduloMap[it.key]!!
            }
        }

        override fun square() {
            resultsMap.forEach {
                resultsMap[it.key] = (it.value * it.value) % moduloMap[it.key]!!
            }
        }

        override fun addSame() {
            resultsMap.forEach {
                resultsMap[it.key] = (it.value * 2) % moduloMap[it.key]!!
            }
        }

        override fun meetReq(monkey: Int): Boolean =
            resultsMap[monkey] == 0

    }
}