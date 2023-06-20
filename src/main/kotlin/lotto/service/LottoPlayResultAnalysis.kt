package lotto.service

import lotto.model.Lotto

object LottoPlayResultAnalysis {

    fun getWinningRatio(
        purchaseAmount: Int, winningLottos: List<Lotto>
    ): Double {
        return getTotalWinningPrize(winningLottos) / purchaseAmount.toDouble()
    }

    private fun getTotalWinningPrize(winningLottos: List<Lotto>): Long =
        winningLottos.sumOf { it.lottoPrize.prizeAmount }

    fun staticPrize(winningLottos: List<Lotto>, prize: Long): Int =
        winningLottos.count { it.lottoPrize.prizeAmount == prize }

}
