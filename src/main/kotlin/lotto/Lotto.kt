package lotto

import lotto.number.Numbers
import lotto.rank.LottoRank

class Lotto(
    val numbers: Numbers =
        Numbers(
            RANGE
                .shuffled()
                .take(COUNT)
                .sorted(),
        ),
) {
    fun getRank(winningNumbers: List<Int>): LottoRank {
        val matchCount = winningNumbers.count { isMatch(it) }
        return LottoRank.getRank(matchCount = matchCount)
    }

    private fun isMatch(winningNumber: Int): Boolean = numbers.numbers.contains(winningNumber)

    companion object {
        private const val COUNT = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private val RANGE = (MIN_NUMBER..MAX_NUMBER).toList()
        const val PRICE: Int = 1_000
    }
}
