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

    fun calculateTotalReward(cnt: Int): Int {
        return reward * cnt
    }

    companion object {
        fun valueOf(countMatch: Int, matchedBonus: Boolean = false): LottoReward {
            if (countMatch == 5 && matchedBonus) {
                return FIFTH_BONUS
            }

            return values().find { it.totalSameNumber == countMatch }
                ?: NONE
        }

        fun getRewardsForCelebrate(): List<LottoReward> {
            return listOf(THIRD, FOURTH, FIFTH, FIFTH_BONUS, SIXTH)
        }
    }
}
