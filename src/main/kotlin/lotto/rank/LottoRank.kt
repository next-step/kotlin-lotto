package lotto.rank

import lotto.Lotto

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0),
    ;

    companion object {
        fun getRank(
            lotto: Lotto,
            winningNumbers: List<Int>,
        ): LottoRank = entries.find { it -> it.matchCount == winningNumbers.count { lotto.isMatch(it) } } ?: NONE

        private fun Lotto.isMatch(winningNumber: Int): Boolean = numbers.numbers.contains(winningNumber)
    }
}
