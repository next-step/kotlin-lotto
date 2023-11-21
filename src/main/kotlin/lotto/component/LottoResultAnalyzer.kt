package lotto.component

import lotto.model.LottoPrize
import kotlin.math.round

class LottoResultAnalyzer {
    fun getRevenueRate(lottoPrizes: List<LottoPrize>): Double {
        val totalRevenue = getTotalRevenue(lottoPrizes)
        val totalPrice = getTotalPrice(lottoPrizes.size)

        // 소수점 2자리 반올림.
        return round(totalRevenue.toDouble() * 100 / totalPrice) / 100
    }

    private fun getTotalRevenue(lottoPrizes: List<LottoPrize>): Int {
        return lottoPrizes.sumOf { it.prize }
    }

    private fun getTotalPrice(lottoNumbersCount: Int): Int {
        return Lotto.getLottoTotalPrice(lottoNumbersCount)
    }
}
