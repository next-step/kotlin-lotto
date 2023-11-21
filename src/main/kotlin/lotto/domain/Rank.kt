package lotto.domain

import lotto.domain.vo.Amount
import lotto.domain.vo.MatchCount
import lotto.domain.vo.RankFrequency

enum class Rank(val matchCount: MatchCount, val winningMoney: Amount) {
    FIRST(MatchCount.of(6), Amount.of(2_000_000_000)),
    SECOND(MatchCount.of(5), Amount.of(30_000_000)),
    THIRD(MatchCount.of(5), Amount.of(1_500_000)),
    FOURTH(MatchCount.of(4), Amount.of(50_000)),
    FIFTH(MatchCount.of(3), Amount.of(5_000)),
    MISS(MatchCount.of(0), Amount.of(0));

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            if (countOfMatch == 5 && matchBonus) {
                return SECOND
            }

            return values().find { it.matchCount == MatchCount.of(countOfMatch) }
                ?: throw IllegalArgumentException("해당하는 등수가 없습니다.")
        }
    }
}
