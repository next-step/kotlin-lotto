package lotto.domain.ticket

import lotto.domain.rank.LottoRank

class WinningStatistics(lottoGamesBuyPrice: Int, lottoGameRanks: List<LottoRank>) {
    private val _lottoGameRankMap: Map<LottoRank, Int> = lottoGameRanks
        .sorted()
        .groupingBy { it }
        .eachCount()

    val rankMap: Map<LottoRank, Int>
        get() = _lottoGameRankMap.toMap()

    val prizeMoneySum: Long = _lottoGameRankMap.map { entry ->
        val prize = entry.key.prize
        val count = entry.value

        val rankSum = prize.toLong() * count

        rankSum
    }.sum()

    val profitRate: Double = prizeMoneySum.toDouble() / lottoGamesBuyPrice
}
