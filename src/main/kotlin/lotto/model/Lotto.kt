package lotto.model

data class Lotto(val numbers: List<Int>) {
    lateinit var win: Win

    fun checkWin(winner: WinnerLotto) {
        val matchNumbers = numbers.filter { it in winner.numbers.numbers }.map { it }
        val matchBonusNumber = numbers.filter { it == winner.bonusNumber }.map { it }

        win = getPrize(matchNumbers.size, matchBonusNumber.isNotEmpty())
    }

    fun checkPrize(): Money {
        return win.prize
    }
}
