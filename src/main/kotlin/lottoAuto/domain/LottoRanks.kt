package lottoAuto.domain

data class LottoRanks(
    val ranks: List<LottoRank>
) {
    fun getTotalWinningMoney(): Int {
        return ranks.sumOf { it.winningMoney }
    }

    fun groupByLottoRank(): Map<LottoRank, Int> {
        val lottoRankCountMap = ranks
            .groupingBy { it }
            .eachCount()
        return LottoRank.values().filterNot { it == LottoRank.MISS }.associateWith { lottoRankCountMap[it] ?: 0 }
    }
}
