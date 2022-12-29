package lotto.domain

data class Ranks(val ranks: List<Rank> = listOf()) {

    val size = ranks.size

    fun rankCount(rank: Rank): Int = ranks.count { it == rank }

    fun totalPrize(): Int {
        return ranks.sumOf { it.krw.money }
    }
}
