package lotto.domain

import java.util.EnumMap

data class MatchResult(
    private val rankToCount: EnumMap<Rank, Int>,
) {
    val totalPrize: Int = rankToCount.entries.sumOf { it.key.prize * it.value }

    fun get(rank: Rank): Int = rankToCount.getOrDefault(rank, 0)

    companion object {
        fun from(rankToCount: Map<Rank, Int>): MatchResult = MatchResult(EnumMap(rankToCount))

        fun of(vararg counts: Pair<Rank, Int>): MatchResult = from(counts.toMap())
    }
}
