package lotto.domain

class Ranks(val ranks: List<Rank>) {
    operator fun plus(other: Ranks): Ranks {
        return Ranks(ranks + other.ranks)
    }

    fun calculateTotalPrizeMoney(): Long {
        return ranks.sumOf { it.winningMoney }
    }
}
