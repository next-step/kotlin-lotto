package lotto.model.data

enum class Winning(val matchCount: Int, val winMoney: Int) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2000_000_000),
    LOST_GAME(0, 0)
}

fun Winning.isWin(winningLotto: Lotto, lotto: Lotto): Boolean {
    return if (this.matchCount == 0)
        false
    else
        return winningLotto.countOfMatchNumber(lotto) == this.matchCount
}

val Winnings = Winning.values()
