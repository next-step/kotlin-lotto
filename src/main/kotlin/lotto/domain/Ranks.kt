package lotto.domain

data class Ranks(val ranks: List<Rank> = listOf()) {

    val size = ranks.size

    fun missCount(): Int = ranks.count { it == Rank.MISS }
    fun fifthCount(): Int = ranks.count { it == Rank.FIFTH }
    fun fourthCount(): Int = ranks.count { it == Rank.FOURTH }
    fun thirdCount(): Int = ranks.count { it == Rank.THIRD }
    fun secondCount(): Int = ranks.count { it == Rank.SECOND }
    fun firstCount(): Int = ranks.count { it == Rank.FIRST }

    fun totalPrize(): Int {
        return ranks.map { it.krw.money }.sum()
    }
}
