package lotto.domain

import lotto.domain.vo.Amount
import lotto.domain.vo.RankFrequency

enum class Rank(val countOfMatch: RankFrequency, val winningMoney: Amount) {
    FIRST(RankFrequency.of(6), Amount.of(2_000_000_000)),
    SECOND(RankFrequency.of(5), Amount.of(30_000_000)),
    THIRD(RankFrequency.of(5), Amount.of(1_500_000)),
    FOURTH(RankFrequency.of(4), Amount.of(50_000)),
    FIFTH(RankFrequency.of(3), Amount.of(5_000)),
    MISS(RankFrequency.of(0), Amount.of(0));

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            return when (countOfMatch) {
                6 -> FIRST
                5 -> if (matchBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
        }
    }
}
