package lotto.model

const val LOTTO_PRICE = 1_000

data class Lotto(val numbers: List<Int>) {
    lateinit var win: Win

    fun checkWin(winner: Lotto) {
        var matchNumberCount = 0
        winner.numbers.forEach {
            if (numbers.contains(it)) {
                matchNumberCount++
            }
        }
        win = getPrize(matchNumberCount)
    }

    fun checkPrize(): Int {
        return win.prize
    }
}
