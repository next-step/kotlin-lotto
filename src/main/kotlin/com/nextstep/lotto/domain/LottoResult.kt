package com.nextstep.lotto.domain

class LottoResult(lottos: List<Lotto>, winningLotto: WinningLotto) {
    private val results: Map<Prize, Int> = findMatchResult(lottos, winningLotto)
    private val price: Int = lottos.size * 1000

    private fun findMatchResult(lottos: List<Lotto>, winningLotto: WinningLotto): Map<Prize, Int> {
        return lottos.map { winningLotto.getMatchResult(it) }
            .groupingBy { Prize.findPrize(it) }.eachCount()
    }

    fun findNumberOfLottoByMatchCount(prize: Prize): Int {
        return results[prize] ?: 0
    }

    fun getIncomingRate(): Double {
        val totalPrize = results.map { it.key.prize * it.value }.sum()

        return totalPrize.div(price.toDouble())
    }
}
