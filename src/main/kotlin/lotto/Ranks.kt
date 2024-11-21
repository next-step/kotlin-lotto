package lotto

typealias MatchedCount = Int

data class Ranks(private val values: Map<Rank, MatchedCount>) {
    fun count(rank: Rank): Int {
        return values[rank] ?: 0
    }

    fun rate(amount: Amount): String {
        val totalPrize =
            values.map {
                it.key.prize(it.value)
            }.sumOf {
                it.value
            }

        return Amount(totalPrize).rate(amount)
            .toString()
    }

    companion object {
        fun fromGroupBy(counts: List<Rank>): Ranks {
            return Ranks(counts.groupingBy { it }.eachCount())
        }
    }
}
