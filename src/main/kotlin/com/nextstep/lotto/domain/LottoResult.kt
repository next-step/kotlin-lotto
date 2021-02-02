package com.nextstep.lotto.domain

class LottoResult(lottos: List<UserLotto>, winningLotto: WinningLotto) {
    private val results: Map<Prize, Int> = findMatchResult(lottos, winningLotto)
    private val price: Int = lottos.size * 1000

    private fun findMatchResult(lottos: List<UserLotto>, winningLotto: WinningLotto): Map<Prize, Int> {
        return lottos.map { winningLotto.findNumberOfMatch(it) }
            .groupingBy { Prize.findPrize(it) }.eachCount()
    }

    fun findNumberOfLottoByMatchCount(matchCount: Int): Int {
        return results[Prize.findPrize(matchCount)] ?: 0
    }

    fun getIncomingRate(): Double {
        val totalPrize = results.map { it.key.prize * it.value }.sum()

        return totalPrize.div(price.toDouble())
    }
}
