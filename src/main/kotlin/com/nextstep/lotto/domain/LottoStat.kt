package com.nextstep.lotto.domain

data class LottoStat(private val matchCounts: List<Int>) {
    private val stat: Map<Rank, Int>

    init {
        val matchCountsToCounts = mutableMapOf<Rank, Int>()
        matchCounts.forEach { matchCountsToCounts[Rank.from(it)] = matchCountsToCounts.getOrDefault(Rank.from(it), 0) + 1 }
        stat = matchCountsToCounts
    }

    fun lottoCountOf(matchNumbers: Int): Int {
        require(matchNumbers in (0..6)) { "일치하는 숫자의 개수는 0에서 7사이 입니다. rank: $matchNumbers" }
        return lottoCountOf(Rank.from(matchNumbers))
    }

    private fun lottoCountOf(rank: Rank): Int {
        return stat[rank] ?: 0
    }

    fun profitRate(): Double {
        val totalPurchase = stat.values.sum() * LOTTO_PRICE.toDouble()
        val totalProfit = Rank.values().sumOf { it.prize * lottoCountOf(it) }
        return String.format("%.2f", totalProfit / totalPurchase).toDouble()
    }
}
