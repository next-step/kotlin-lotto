package lotto.service

import lotto.model.Lotto

object LottoPlayResultAnalysis {

    fun getWinningRatio(
        purchaseAmount: Int, purchasedLottos: List<Lotto>
    ): Double {
        return getTotalWinningPrize(purchasedLottos) / purchaseAmount.toDouble()
    }

    private fun getTotalWinningPrize(purchasedLottos: List<Lotto>): Long =
        purchasedLottos.sumOf { it.lottoPrize.prizeAmount }

    fun staticPrize(purchasedLottos: List<Lotto>, prize: Long): Int =
        purchasedLottos.count { it.lottoPrize.prizeAmount == prize }

}
