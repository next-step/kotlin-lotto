package lotto.domain

import lotto.data.LottoRanking

object LottoCalculator {

    private const val GAME_COST = 1000

    fun calculateWinningRate(cash: Int, winningStatus: Map<LottoRanking, Int>): Float {
        val totalPrice = winningStatus.toList().sumOf { it.first.findPrize(it) }

        return totalPrice / cash.toFloat()
    }

    fun getTimes(cash: Int): Int {
        return cash / GAME_COST
    }
}
