package lotto.domain

import lotto.LottoUtils.bonusNumber
import lotto.LottoUtils.luckyNumbers

class Result(private val lottos: Lottos) {
    private val _winningResult: MutableMap<Rank, Int> = mutableMapOf(
        Rank.FIFTH to 0,
        Rank.FOURTH to 0,
        Rank.THIRD to 0,
        Rank.SECOND to 0,
        Rank.FIRST to 0
    )
    private val winningResult: Map<Rank, Int>
        get() = _winningResult

    private fun getRanks(): List<Rank> {
        return lottos.matchResults(luckyNumbers, bonusNumber)
            .map { Rank.getRank(it.first, it.second) }
    }

    fun getResult(): Map<Rank, Int> {
        Rank.values().filterNot { it == Rank.ELSE }
            .forEach { putWinningCount(it) }
        return winningResult
    }

    private fun putWinningCount(Rank: Rank) {
        val ranks = getRanks()
        _winningResult[Rank] = ranks.filter { it == Rank }.size
    }

    fun getProfit(): Int {
        val result = getResult()
        return result.map { it.key.prizeMoney * it.value }.sumBy { it }
    }
}

enum class Rank(val condition: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ELSE(0, 0);

    companion object {
        fun getRank(matchedCount: Int, bonusMatchUp: Boolean): Rank {
            var rank = values().firstOrNull { it.condition == matchedCount } ?: ELSE
            if (rank == SECOND && !bonusMatchUp) rank = THIRD
            return rank
        }
    }
}
