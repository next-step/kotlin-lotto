package lotto.rank

import lotto.Lotto
import lotto.statistics.WinningNumber

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
    val matchBonus: Boolean = false,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, matchBonus = true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0),
    ;

    companion object {
        fun getRank(
            lotto: Lotto,
            winningNumber: WinningNumber,
        ): LottoRank =
            entries.find {
                isMatched(
                    rank = it,
                    matchCount = winningNumber.countMatchingNumbers(lotto),
                    matchBonus = lotto.isMatchedBonus(winningNumber.bonusBall),
                )
            } ?: NONE

        private fun isMatched(
            rank: LottoRank,
            matchCount: Int,
            matchBonus: Boolean,
        ): Boolean = rank.matchBonus == matchBonus && rank.matchCount == matchCount
    }
}
