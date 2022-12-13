package lotto.model

class WinningNumbers(private val winningLotto: Lotto) {
    fun prizeOf(lotto: Lotto): LottoPrize {
        return winningLotto.matchCount(lotto).let(LottoPrize::of)
    }
}
