package lotto.rank

import lotto.Lotto
import lotto.statistics.WinningNumber

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
    val matchBonus: Boolean = false,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0),
    ;

    data class Key(
        val matchCount: Int,
        val matchBonus: Boolean,
        val message: String? = BONUS_BALL_MESSAGE.takeIf { matchCount == SECOND.matchCount && matchBonus },
    )

    val key: Key
        get() {
            return Key(matchCount = matchCount, matchBonus = matchBonus)
        }

    companion object {
        fun getRank(
            lotto: Lotto,
            winningNumber: WinningNumber,
        ): LottoRank =
            entries.find { it ->
                isMatched(
                    rank = it,
                    matchCount = winningNumber.numbers.numbers.count { lotto.isMatch(it) },
                    matchBonus = lotto.numbers.numbers.contains(winningNumber.bonusBall.number),
                )
            } ?: NONE

        private fun Lotto.isMatch(winningNumber: Int): Boolean = numbers.numbers.contains(winningNumber)

        private fun isMatched(
            rank: LottoRank,
            matchCount: Int,
            matchBonus: Boolean,
        ): Boolean = rank.matchBonus == matchBonus && rank.matchCount == matchCount

        private const val BONUS_BALL_MESSAGE = "보너스 볼 일치"
    }
}
