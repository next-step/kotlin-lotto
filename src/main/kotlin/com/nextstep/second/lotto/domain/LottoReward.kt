package com.nextstep.second.lotto.domain

enum class LottoReward(
    val totalSameNumber: Int,
    val reward: Int
) {
    NONE(0, 0),
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_BONUS(5, 30_000_000),
    SIXTH(6, 2_000_000_000);

    override fun toString(): String {
        return when (this) {
            THIRD -> "${THIRD.totalSameNumber}개 일치 (${THIRD.reward}원)"
            FOURTH -> "${FOURTH.totalSameNumber}개 일치 (${FOURTH.reward}원)"
            FIFTH -> "${FIFTH.totalSameNumber}개 일치 (${FIFTH.reward}원)"
            FIFTH_BONUS -> "${FIFTH_BONUS.totalSameNumber}개 일치, 보너스볼 일치 (${FIFTH_BONUS.reward}원)"
            SIXTH -> "${THIRD.totalSameNumber}개 일치 (${THIRD.reward}원)"
            NONE -> "당첨 수령한 결과가 아님"
        }
    }

    companion object {
        fun valueOf(countMatch: Int, matchedBonus: Boolean = false): LottoReward {
            return when {
                countMatch == 3 -> THIRD
                countMatch == 4 -> FOURTH
                countMatch == 5 && matchedBonus -> FIFTH_BONUS
                countMatch == 5 -> FIFTH
                countMatch == 6 -> SIXTH
                else -> NONE
            }
        }

        fun getRewardsForCelebrate(): List<LottoReward> {
            return listOf(THIRD, FOURTH, FIFTH, FIFTH_BONUS, SIXTH)
        }
    }
}
