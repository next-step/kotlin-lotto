package lotto.model

const val LOTTO_PRICE = 1_000

data class Lotto(val numbers: List<Int>) {
    lateinit var win: Win

    fun checkWin(winner: WinnerLotto) {
        val matchNumbers = numbers.filter { it in winner.numbers.numbers }.map { it }
        val matchBonusNumber = numbers.filter { it == winner.bonusNumber }.map { it }

        win = getPrize(matchNumbers.size, matchBonusNumber.size)
    }

    fun checkPrize(): Int {
        return win.prize
    }
}
