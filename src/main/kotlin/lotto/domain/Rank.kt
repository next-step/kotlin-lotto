package lotto.domain

class Rank {
    val ranks = mutableMapOf<PrizeMoney, Int>(
        PrizeMoney.FIRST to 0,
        PrizeMoney.SECOND to 0,
        PrizeMoney.THIRD to 0,
        PrizeMoney.FOURTH to 0,
        PrizeMoney.FIFTH to 0
    )

    fun addRank(countMatch: Int, isBonus: Boolean = false) {
        val ranking = findRanking(countMatch, isBonus)
        if (ranking != PrizeMoney.MISS) {
            ranks[ranking] = ranks.getValue(ranking) + 1
        }
    }

    private fun findRanking(countMatch: Int, isBonus: Boolean): PrizeMoney {
        return when {
            PrizeMoney.FIRST.isIt(countMatch) -> PrizeMoney.FIRST

            PrizeMoney.SECOND.isIt(countMatch) && isBonus -> PrizeMoney.SECOND

            PrizeMoney.THIRD.isIt(countMatch) -> PrizeMoney.THIRD

            PrizeMoney.FOURTH.isIt(countMatch) -> PrizeMoney.FOURTH

            PrizeMoney.FIFTH.isIt(countMatch) -> PrizeMoney.FIFTH

            else -> PrizeMoney.MISS
        }
    }
}

