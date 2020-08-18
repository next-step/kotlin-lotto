package com.nextstep.lotto.domain

class LottoResult(lottos: Lottos, winningLotto: WinningLotto) {
    private val results: Map<Int, Int> = lottos.findMatchResult(winningLotto)
    private val price: Int = lottos.lottos.size * 1000

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
