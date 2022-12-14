package lotto.model

class WinningNumbers(private val winningLotto: Lotto) {
    fun prizeOf(lotto: Lotto): LottoPrize {
        return winningLotto.matchCountWith(lotto).let(LottoPrize::of)
    }
}
