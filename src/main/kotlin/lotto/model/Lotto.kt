package lotto.model

data class Lotto(val numbers: List<Int>) {
    lateinit var win: Win

    fun checkWin(winner: WinnerLotto) {
        val matchNumbers = winner.contains(numbers)
        val matchBonus = winner.containsBonus(numbers)

        win = getPrize(matchNumbers, matchBonus)
    }

    fun checkPrize(): Money {
        return win.prize
    }
}
