package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class LottoResults(
    private val lottoResults: List<LottoResult>
) {
    fun get() = lottoResults.toList()

    fun rateOfResult(lottoPrice: LottoPrice): BigDecimal {
        val realLottoPrice = lottoPrice / LottoPurchase.LOTTO_PRICE * LottoPurchase.LOTTO_PRICE
        return BigDecimal(sumOfResult()).divide(BigDecimal(realLottoPrice), 2, RoundingMode.HALF_UP)
    }

    fun winningLottoCount(lottoPrize: LottoPrize): Int =
        lottoResults.firstOrNull { it.lottoPrize == lottoPrize }
            ?.matchedLottoCount
            ?.toInt() ?: 0

    private fun sumOfResult(): Int = lottoResults.sumOf {
        it.lottoPrize.prizeMoney * it.matchedLottoCount.toInt()
    }
}

fun List<LottoResult>.toLottoResults() = LottoResults(this)
