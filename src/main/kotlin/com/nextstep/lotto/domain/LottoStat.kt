package com.nextstep.lotto.domain

data class LottoStat(private val matchCounts: List<Int>) {
    private val stat: Map<Int, Int>

    init {
        val matchCountsToCounts = mutableMapOf<Int, Int>()
        matchCounts.forEach { matchCountsToCounts[it] = matchCountsToCounts.getOrDefault(it, 0) + 1 }
        stat = matchCountsToCounts
    }

    fun lottoCountOf(matchNumbers: Int): Int {
        require(matchNumbers in (0..6)) { "일치하는 숫자의 개수는 0에서 7사이 입니다. rank: $matchNumbers" }
        return stat[matchNumbers] ?: 0
    }

    fun profitRate(): Double {
        val totalPurchase = stat.values.sum() * LOTTO_PRICE.toDouble()
        val totalProfit = lottoCountOf(3) * 5000 + lottoCountOf(4) * 50000 + lottoCountOf(5) * 1500000 + lottoCountOf(6) * 2000000000
        return String.format("%.2f", totalProfit / totalPurchase).toDouble()
    }
}
