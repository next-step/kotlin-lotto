package lotto.dto

import java.lang.IllegalArgumentException

private const val MINIMUM_WINNING_COUNT = 3

private const val SECOND_PRIZE_CANDIDATE = 5

enum class LottoResult(
    val matchCount: Int,
    val winningMoney: Int,
    val matchBonus: Boolean = false
) {

    NO_MATCH(0,  0),
    MATCH_ONE_NUMBERS(1, 0),
    MATCH_TWO_NUMBERS(2, 0),
    MATCH_THREE_NUMBERS(3, 5_000),
    MATCH_FOUR_NUMBERS(4, 50_000),
    MATCH_FIVE_NUMBERS(SECOND_PRIZE_CANDIDATE, 1_500_000),
    MATCH_FIVE_NUMBERS_WITH_BONUS(SECOND_PRIZE_CANDIDATE, 30_000_000, true),
    MATCH_SIX_NUMBERS(6, 2_000_000_000);

    fun isWinning(): Boolean {
        return matchCount >= MINIMUM_WINNING_COUNT
    }

    companion object {
        fun fromMatchCount(count: Int, matchBonus: Boolean): LottoResult {
            if(isSecondPrize(count, matchBonus)){
                return MATCH_FIVE_NUMBERS_WITH_BONUS
            }
            return values().firstOrNull { it.matchCount == count } ?: throw IllegalArgumentException("당첨된 개수는 3~6개 중 하나입니다.")
        }

        private fun isSecondPrize(count: Int, matchBonus: Boolean) = count == SECOND_PRIZE_CANDIDATE && matchBonus

        fun winningValues(): List<LottoResult> {
            return values().filter { it.matchCount >= MINIMUM_WINNING_COUNT }
        }
    }
}
