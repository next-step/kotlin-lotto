package lotto.model.data

enum class Winning(private val matchCount: Int, val winMoney: Int) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2000_000_000),
    LOST_GAME(0, 0);

    fun isWin(winningLotto: Lotto, lotto: Lotto): Boolean {
        return if (this.matchCount == 0)
            false
        else
            return winningLotto.countOfMatchNumber(lotto) == this.matchCount
    }
}

val WinningSet = setOf(Winning.LOST_GAME, Winning.FIFTH, Winning.FOURTH, Winning.THIRD, Winning.FIRST)
