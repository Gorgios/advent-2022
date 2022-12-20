package pl.jreclaw.advent

class Day20(private val input: List<Long>) {
    fun solvePart1(): Long =
        solve(1,1)

    fun solvePart2(): Long =
        solve(10,811589153)


    private fun solve(iterations: Int, decryptionKey: Long): Long {
        val start = Node((input[0] * decryptionKey))
        var current = start
        var last = start
        val list = mutableListOf(start)
        for (i in 1 until input.size) {
            current = Node(input[i] * decryptionKey)
            list.add(current)
            last.next = current
            current.prev = last
            last = current
        }
        last.next = start
        start.prev = last
        for (j in 0 until iterations) {
            for (i in input.indices) {
                list[i].move()
            }
        }
        val zeroNode = list[input.indexOf(0)]
        return zeroNode.getFrom(1000) +zeroNode.getFrom(2000) +zeroNode.getFrom(3000)
    }

    inner class Node(val value: Long, var next: Node? = null, var prev: Node? = null) {

        fun move() {
            if (value%(input.size - 1) == 0L) {
                return
            }
            var moveBy = value%(input.size - 1)
            prev!!.next = next
            next!!.prev = prev
            var currVal = this
            while (moveBy < 0) {
                currVal = currVal.prev!!
                moveBy++
            }
            while (moveBy > 0) {
                currVal = currVal.next!!
                moveBy--
            }
            if (value > 0) {
                this.prev = currVal
                this.next = currVal.next
                this.next!!.prev = this
                currVal.next = this

            } else {
                this.next = currVal
                this.prev = currVal.prev
                this.prev!!.next = this
                currVal.prev = this
            }

        }

        fun getFrom(n: Int) :Long {
            var curr = this
            for (i in 0 until n%input.size) {
                curr = curr.next!!
            }
            return curr.value
        }
    }
}