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

    companion object {
        fun valueOf(countMatch: Int, matchedBonus: Boolean): LottoReward {
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
