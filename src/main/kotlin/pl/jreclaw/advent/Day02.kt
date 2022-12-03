package pl.jreclaw.advent

class Day02(private val input: List<String>) {

    enum class Move {
        ROCK, PAPER, SCISSORS;

        fun getMoveScore(): Int =
            when (this) {
                ROCK -> 1
                PAPER -> 2
                SCISSORS -> 3
            }
    }

    fun solvePart1(): Int =
        input.fold(0) { sum, pair ->
            val split = pair.split(" ")
            sum + duel(convertToMove(split[0]), convertToMove(split[1]))
        }

    fun solvePart2(): Int =
        input.fold(0) {sum, pair ->
            val split = pair.split(" ")
            sum + duelWithExpectedResult(convertToMove(split[0]), split[1].first())
        }

    private fun convertToMove(s: String): Move =
        when ((s.first().code - 'A'.code) % 23) {
            0 -> Move.ROCK
            1 -> Move.PAPER
            2 -> Move.SCISSORS
            else -> error("No suitable move for ${s.first()} character")
        }

    private fun duel(opponent: Move, player: Move): Int =
        if (opponent == player) {
            3 + player.getMoveScore()
        } else {
            when (opponent) {
                Move.PAPER ->
                    when (player) {
                        Move.SCISSORS -> 6 + player.getMoveScore()
                        else -> player.getMoveScore()
                    }

                Move.ROCK ->
                    when (player) {
                        Move.PAPER -> 6 + player.getMoveScore()
                        else -> player.getMoveScore()
                    }

                Move.SCISSORS -> {
                    when (player) {
                        Move.ROCK -> 6 + player.getMoveScore()
                        else -> player.getMoveScore()
                    }
                }
            }
        }

    /* expected result is char with following values
        'X' : lost
        'Y' : draw
        'Z' : win
     */
    private fun duelWithExpectedResult(opponent: Move, expectedResult: Char): Int =
        when (expectedResult) {
            'Y' -> 3 + opponent.getMoveScore()
            'X' -> when (opponent) {
                Move.ROCK -> Move.SCISSORS.getMoveScore()
                Move.SCISSORS -> Move.PAPER.getMoveScore()
                Move.PAPER -> Move.ROCK.getMoveScore()
            }
            'Z' -> 6 + when (opponent) {
                Move.ROCK -> Move.PAPER.getMoveScore()
                Move.SCISSORS -> Move.ROCK.getMoveScore()
                Move.PAPER -> Move.SCISSORS.getMoveScore()
            }
            else -> error("Can't figure out expected result from $expectedResult character")
        }

}