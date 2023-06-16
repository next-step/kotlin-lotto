package com.nextstep.second.lotto.domain

enum class LottoReward(
    val sameNumberCnt: Int,
    val reward: Int
) {
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    SIXTH(6, 2000000000),
    NONE(0, 0);

    companion object {
        fun of(sameNumberCnt: Int): LottoReward {
            return when (sameNumberCnt) {
                THIRD.sameNumberCnt -> THIRD
                FOURTH.sameNumberCnt -> FOURTH
                FIFTH.sameNumberCnt -> FIFTH
                SIXTH.sameNumberCnt -> SIXTH
                else -> NONE
            }
        }
    }
}
