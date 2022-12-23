package lotto.model

class WinningNumbers(
    private val winning: Lotto,
    private val bonusNumber: LottoNumber
) {
    fun prizeOf(lotto: Lotto): LottoPrize {
        return LottoPrize.of(
            lotto.matchCountWith(winning),
            lotto.contains(bonusNumber)
        )
    }

    companion object {
        fun of(lotto: Lotto, bonusNumber: Int): WinningNumbers {
            return WinningNumbers(lotto, LottoNumber.of(bonusNumber))
        }
    }
}
