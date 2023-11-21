package lotto.domain

import lotto.data.LottoRanking
import java.util.EnumMap

object LottoCalculator {

    fun calculateWinningRate(cash: Int, winningStatus: EnumMap<LottoRanking, Int>): Float {
        val totalPrice = winningStatus.toList().sumOf { it.first.findPrize(it) }

        return totalPrice / cash.toFloat()
    }

    fun getTimes(cash: Int, gameCost: Int): Int {
        return cash / gameCost
    }
}
