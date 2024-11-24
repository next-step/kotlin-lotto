package lotto

import lotto.number.Numbers
import lotto.rank.LottoRank
import lotto.statistics.WinningNumber

data class Lotto(
    val numbers: Numbers =
        Numbers(
            RANGE
                .shuffled()
                .take(COUNT)
                .sorted(),
        ),
) {
    fun getRank(winningNumbers: WinningNumber): LottoRank = LottoRank.getRank(lotto = this, winningNumber = winningNumbers)

    companion object {
        private const val COUNT = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private val RANGE = (MIN_NUMBER..MAX_NUMBER).toList()
        const val PRICE: Int = 1_000
    }
}
