package com.nextstep.lotto.domain

class LottoResult(lottos: List<Lotto>, winningLotto: WinningLotto) {
    private val results: Map<Int, Int> = findMatchResult(lottos, winningLotto)
    private val price: Int = lottos.size * 1000

    private fun findMatchResult(lottos: List<Lotto>, winningLotto: WinningLotto): Map<Int, Int> {
        return lottos.map { winningLotto.findNumberOfMatch(it) }
            .groupingBy { it }.eachCount()
    }

    fun findNumberOfLottoByMatchCount(matchCount: Int): Int {
        return results[matchCount] ?: 0
    }

    fun findPrizeByMatchCount(matchCount: Int): Int {
        return Prize.findPrize(matchCount)
    }

    fun getIncomingRate(): Double {
        val totalPrize = results.map { findPrizeByMatchCount(it.key) * it.value }.sum()

        return totalPrize.div(price.toDouble())
    }
}
