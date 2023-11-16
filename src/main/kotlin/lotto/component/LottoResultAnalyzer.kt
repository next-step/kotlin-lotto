package lotto.component

import lotto.model.LottoPrize
import kotlin.math.round

class LottoResultAnalyzer {
    fun getRevenueRate(lottoNumbersCount: Int, lottoPrice: Int, lottoPrizes: List<LottoPrize>): Double {
        require(lottoPrice > 0) {
            "로또 가격은 0 이상의 자연수 입니다."
        }

        val totalRevenue = getTotalRevenue(lottoPrizes)
        val totalPrice = getTotalPrice(lottoNumbersCount, lottoPrice)

        // 소수점 2자리 반올림.
        return round(totalRevenue.toDouble() * 100 / totalPrice) / 100
    }

    private fun getTotalRevenue(lottoPrizes: List<LottoPrize>): Int {
        return lottoPrizes.sumOf { it.prize }
    }

    private fun getTotalPrice(lottoNumbersCount: Int, lottoPrice: Int): Int {
        return lottoNumbersCount * lottoPrice
    }
}
