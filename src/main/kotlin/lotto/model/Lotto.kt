package lotto.model

const val LOTTO_PRICE = 1_000

data class Lotto(val numbers: List<Int>) {
    lateinit var win: Win

    fun checkWin(winner: Lotto) {
        val matchNumbers = numbers.filter { it in winner.numbers }.map { it }

        win = getPrize(matchNumbers.size)
    }

    fun checkPrize(): Int {
        return win.prize
    }
}
