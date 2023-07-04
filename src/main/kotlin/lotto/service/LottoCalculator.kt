package lotto.service

import lotto.domain.Rank

object LottoCalculator {

    fun calculatePrizeMoney(rank: Rank): Long {
        return when (rank) {
            Rank.FIFTH -> 5_000
            Rank.FOURTH -> 50_000
            Rank.THIRD -> 1_500_000
            Rank.SECOND -> 30_000_000
            Rank.FIRST -> 2_000_000_000
            else -> 0
        }
    }
}
