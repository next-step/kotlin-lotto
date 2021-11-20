package lotto.domain

class WinningState {
    private val winningList = mutableListOf<Winning>()

    fun recordResult(result: Winning) {
        winningList.add(result)
    }

    fun findFirstCount() = winningList.filter { it == Winning.FIRST }.size

    fun findSecondCount() = winningList.filter { it == Winning.SECOND }.size

    fun findThirdCount() = winningList.filter { it == Winning.THIRD }.size

    fun findFourthCount() = winningList.filter { it == Winning.FOURTH }.size

    fun getWinningAmount(): Int {
        return winningList.map {
            it.prise
        }.sumOf { amount ->
            amount
        }
    }
}
