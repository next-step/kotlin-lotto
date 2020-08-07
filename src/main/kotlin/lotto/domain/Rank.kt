package lotto.domain

class Rank {
    val ranks = mutableMapOf<PrizeMoney, Int>(
        PrizeMoney.FIRST to 0,
        PrizeMoney.SECOND to 0,
        PrizeMoney.THIRD to 0,
        PrizeMoney.FOURTH to 0,
        PrizeMoney.FIFTH to 0,
        PrizeMoney.MISS to 0
    )

    fun addRank(ranking: PrizeMoney) {
        if (ranking != PrizeMoney.MISS) {
            ranks[ranking] = ranks.getValue(ranking) + 1
        }
    }
}

