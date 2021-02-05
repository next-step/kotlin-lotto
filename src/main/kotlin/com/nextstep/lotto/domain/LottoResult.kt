package com.nextstep.lotto.domain

import com.nextstep.lotto.domain.LottoFactory.LOTTO_PRICE

class LottoResult(lottos: Lottos, winningLotto: WinningLotto) {
    private val results: Map<Prize, Int> = findMatchResult(lottos.lottos, winningLotto)
    private val price: Int = lottos.lottos.size * LOTTO_PRICE

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
