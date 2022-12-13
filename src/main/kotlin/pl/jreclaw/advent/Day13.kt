package pl.jreclaw.advent

import java.lang.Integer.max
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class Day13(private val input: List<String>) {

    fun solvePart1(): Int =
        input.filter { it.isNotBlank() }.chunked(2).map {
            val left = createList(it[0])
            val right = createList(it[1])
            MyListComparator().compare(left, right) >= 0
        }.foldIndexed(0) { index, acc, b ->
            when (b) {
                true -> acc + index + 1
                else -> acc
            }
        }

    fun solvePart2(): Int {
        val two = createList("[[2]]")
        val six = createList("[[6]]")
        val toSort = input.filter { it.isNotBlank() }
            .map {
                createList(it)
            }.toMutableList()
        toSort.addAll(listOf(two, six))
        val sorted = toSort.sortedWith(MyListComparator().reversed())
        return (sorted.indexOf(two) + 1) * (sorted.indexOf(six) + 1)
    }

    private fun createList(s: String): MyList {
        val rootList = MyList(LinkedList())
        val stack: Stack<MyList> = Stack();
        stack.add(rootList)
        for (c in 1 until s.length) {
            when (s[c]) {
                '[' -> {
                    val newItem = MyList(LinkedList())
                    stack.peek().addElement(newItem)
                    stack.push(newItem)
                }

                ']' -> {
                    stack.pop()
                }

                ',' -> Unit
                else -> {
                    val num = when (c + 1 < s.length && s[c + 1].digitToIntOrNull() != null) {
                        true -> s.substring(c, c + 2).toInt()
                        else -> s[c].digitToInt()
                    }
                    val newItem = MyList(ArrayList(), num)
                    stack.peek().addElement(newItem)
                }
            }
        }
        return rootList
    }

    class MyListComparator : Comparator<MyList> {
        override fun compare(list1: MyList?, list2: MyList?): Int {
            if (list1 == list2) {
                return 0
            }
            if (list1 == null) {
                return 1
            }
            if (list2 == null) {
                return -1
            }
            if (list1.getValue() != -1 && list2.getValue() == -1) {
                list1.addElement(MyList(ArrayList(), list1.getValue()))
                list1.resetValue()
            }
            if (list1.getValue() == -1 && list2.getValue() != -1) {
                list2.addElement(MyList(ArrayList(), list2.getValue()))
                list2.resetValue()
            }
            if (list1.getValue() > list2.getValue()) {
                return -1
            }
            if (list1.getValue() < list2.getValue()) {
                return 1
            }
            for (i in 0 until max(list1.getElements().size, list2.getElements().size)) {
                val result = compare(list1.getElement(i), list2.getElement(i))
                if (result != 0) {
                    return result
                }
            }
            return 0
        }
    }

    class MyList(private val elements: MutableList<MyList>, private var value: Int = -1) {
        fun getValue(): Int =
            value

        fun resetValue() {
            value = -1
        }

        fun getElements(): List<MyList> =
            elements

        fun getElement(i: Int): MyList? =
            when (elements.size > i) {
                true -> elements[i]
                else -> null
            }

        fun addElement(element: MyList) {
            elements.add(element)
        }

    }
}