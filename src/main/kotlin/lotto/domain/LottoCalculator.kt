package lotto.domain

import lotto.data.LottoRanking

object LottoCalculator {

    fun calculateWinningRate(cash: Int, winningStatus: Map<LottoRanking, Int>): Float {
        val totalPrice = winningStatus.toList().sumOf { it.first.findPrize(it) }

        return totalPrice / cash.toFloat()
    }
}
