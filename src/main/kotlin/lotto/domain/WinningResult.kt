package lotto.domain

import lotto.domain.model.Rank

class WinningResult(private val result: Map<Rank, Int>) {

    fun getOrDefault(rank: Rank, default: Int): Int = result.getOrDefault(rank, default)

    companion object {

        fun calculateWinningCount(ranks: List<Rank>): WinningResult {
            val result = mutableMapOf<Rank, Int>()
            ranks.forEach { rank ->
                result[rank] = result[rank]?.inc() ?: 1
            }

            return WinningResult(result)
        }
    }
}
