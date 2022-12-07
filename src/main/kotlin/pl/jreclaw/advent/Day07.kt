package pl.jreclaw.advent

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Day07(private val input: List<String>) {
    fun solvePart1(): Int =
        getTotal(buildFileSystem())

    fun solvePart2(): Int {
        val root = buildFileSystem()
        val min: Int = (300_000_00 - (700_000_00 - root.getTotalSum()))
        return findMinMeetsCondition(root, min)
    }

    private fun getTotal(root: Directory): Int {
        var total = 0
        val sum = root.getTotalSum()
        if (sum <= 100_000) {
            total = sum
        }
        for (el in root.getSubDirs()) {
            total += getTotal(el)
        }
        return total
    }

    private fun buildFileSystem(): Directory {
        val root = Directory("/")
        val dirStack: Stack<Directory> = Stack()
        dirStack.add(root)
        input.forEach {
            if (it.startsWith("$ cd")) {
                when (val dir = it.trim().split(" ")[2]) {
                    "/" -> dirStack.removeAll { el -> el != root }
                    ".." -> dirStack.pop()
                    else -> {
                        val next = dirStack.peek().getIfContains(dir)
                        dirStack.add(next)
                    }
                }
            } else {
                val split = it.trim().split(" ")
                when (val possNum = split[0].toIntOrNull()) {
                    is Int -> dirStack.peek()?.addFile(split[1], possNum)
                    else -> Unit
                }
            }
        }
        return root
    }

    private fun findMinMeetsCondition(root: Directory, min: Int, list: MutableList<Int> = LinkedList()): Int {
        if (root.getTotalSum() >= min) {
            list.add(root.getTotalSum())
        }
        for (el in root.getSubDirs()) {
            findMinMeetsCondition(el, min, list)
        }
        return list.min()
    }

    class Directory(
        private val name: String,
        private var sumOfFiles: Int = 0,
        private val subDirs: MutableList<Directory> = ArrayList(),
        private val files: MutableSet<String> = HashSet()
    ) {
        fun getTotalSum(): Int =
            sumOfFiles + subDirs.sumOf {
                it.getTotalSum()
            }

        fun addFile(fileName: String, size: Int) {
            if (!files.contains(fileName)) {
                sumOfFiles += size
                files.add(fileName)
            }
        }

        fun getIfContains(name: String): Directory {
            val dir = subDirs.singleOrNull { it.name == name }
            if (dir != null) {
                return dir
            }
            val newDir = Directory(name)
            subDirs.add(newDir)
            return newDir
        }

        fun getSubDirs(): List<Directory> =
            subDirs
    }
}