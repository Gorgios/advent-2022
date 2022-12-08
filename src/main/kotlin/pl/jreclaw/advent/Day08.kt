package pl.jreclaw.advent

import kotlin.math.max

class Day08(private val input: List<String>) {
    fun solvePart1(): Int {
        val array = get2DArray()
        val visible = Array(input.size) { i ->
            Array(input[0].length) { j ->
                i == 0 || j == 0 || i == input.size - 1 || j == input[0].length - 1
            }
        }

        IntRange(0, array[0].size - 1).forEach {
            travel(array, visible, 0, it, 1, 0)
            travel(array, visible, array.size - 1, it, -1, 0)
            travel(array, visible, it, 0, 0, 1)
            travel(array, visible, it, array.size - 1, 0, -1)

        }
        return visible.sumOf { it.count { e -> e } }
    }

    private fun travel(
        array: Array<Array<Int>>,
        visible: Array<Array<Boolean>>,
        row: Int,
        col: Int,
        iAdder: Int,
        jAdder: Int
    ) {
        var curMax = array[row][col]
        var i = row;
        var j = col;
        i += iAdder
        j += jAdder
        while (i >= 0 && i < array.size && j >= 0 && j < array.size) {
            if (array[i][j] > curMax) {
                visible[i][j] = true
            }
            curMax = max(curMax, array[i][j])
            i += iAdder
            j += jAdder
        }
    }

    fun solvePart2(): Int {
        val array = get2DArray()
        var max = 0
        array.forEachIndexed { i, el ->
            el.forEachIndexed { j, el2 ->
                if (j > 0 && j < array[0].size - 1 && i > 0 && i < array.size - 1) {
                    max = max(traverseForOne(array, i, j), max)
                }
            }
        }
        return max
    }

    private fun traverseForOne(arr: Array<Array<Int>>, startI: Int, startJ: Int): Int {
        var down = 1;
        var up = 1;
        var left = 1;
        var right = 1;
        var i = startI + 1
        while (i < arr.size - 1 && arr[startI][startJ] > arr[i][startJ]) {
            down++
            i++
        }
        i = startI - 1
        while (i > 0 && arr[startI][startJ] > arr[i][startJ]) {
            up++
            i--
        }
        var j = startJ + 1
        while (j < arr[0].size - 1 && arr[startI][startJ] > arr[startI][j]) {
            right++;
            j++
        }
        j = startJ - 1
        while (j > 0 && arr[startI][startJ] > arr[startI][j]) {
            left++
            j--
        }
        return up * down * left * right
    }


    private fun get2DArray(): Array<Array<Int>> =
        Array(input.size) { i ->
            Array(input[0].length) { j ->
                input[i][j].digitToInt()
            }
        }

}