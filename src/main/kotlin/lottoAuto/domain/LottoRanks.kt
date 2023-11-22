package lottoAuto.domain

data class LottoRanks(
    val ranks: List<LottoRank>
) {
    fun getTotalWinningMoney(): Int {
        return ranks.sumOf { it.winningMoney }
    }

    fun groupByLottoRank(): Map<LottoRank, Int> { // 반환 객체 생성 및 calcProfit 위임
        val lottoRankCountMap = ranks
            .groupingBy { it }
            .eachCount()
        return LottoRank.values().filterNot { it == LottoRank.MISS }.associateWith { lottoRankCountMap[it] ?: 0 }
    }
}
