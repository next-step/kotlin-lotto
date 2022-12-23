package lotto.model

class WinningNumbers(private val winningLotto: Lotto) {
    fun prizeOf(lotto: Lotto): LottoPrize {
        return LottoPrize.of(lotto.matchCountWith(winningLotto), true)
    }
}
