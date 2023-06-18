package com.nextstep.second.lotto.domain

enum class LottoReward(
    val totalSameNumber: Int,
    val reward: Int
) {
    NONE(0, 0),
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    SIXTH(6, 2_000_000_000);

    companion object {
        fun valueOf(countMatch: Int): LottoReward {
            return when (countMatch) {
                3 -> THIRD
                4 -> FOURTH
                5 -> FIFTH
                6 -> SIXTH
                else -> NONE
            }
        }
        fun getRewardsForCelebrate(): List<LottoReward> {
            return listOf(THIRD, FOURTH, FIFTH, SIXTH)
        }
    }
}
