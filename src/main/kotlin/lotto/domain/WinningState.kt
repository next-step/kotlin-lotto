package lotto.domain

class WinningState {
    private val winningList = mutableListOf<Winning>()

    fun recordResult(result: Winning) {
        winningList.add(result)
    }

    fun getWinningCount(winning: Winning): Int {
        return winningList.filter {
            it == winning
        }.size
    }

    fun getAllWinningAmount(): Int {
        return winningList.map {
            getWinningAmount(it)
        }.sumOf { amount ->
            amount
        }
    }

    private fun getWinningAmount(winning: Winning): Int {
        return when (winning) {
            Winning.FIRST -> 2000000000
            Winning.SECOND -> 1500000
            Winning.THIRD -> 50000
            Winning.FOURTH -> 5000
            Winning.FAIL -> 0
        }
    }
}
