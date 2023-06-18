package com.nextstep.second.lotto.domain

enum class LottoReward(
    val totalSameNumber: Int,
    val reward: Int
) {
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    SIXTH(6, 2_000_000_000);

    companion object {
        fun getRewards(): List<LottoReward> {
            return LottoReward.values().toList()
        }
    }
}
