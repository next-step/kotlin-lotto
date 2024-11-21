package lotto

import lotto.number.Numbers
import lotto.rank.LottoRank

class Lotto(
    val numbers: Numbers =
        Numbers(
            (1..45)
                .toList()
                .shuffled()
                .take(6)
                .sorted(),
        ),
) {
    fun getRank(winningNumbers: List<Int>): LottoRank {
        val matchCount = winningNumbers.count { isMatch(it) }
        return LottoRank.getRank(matchCount = matchCount)
    }

    private fun isMatch(winningNumber: Int): Boolean = numbers.numbers.contains(winningNumber)
}
