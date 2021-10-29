package lotto.domain

import lotto.domain.LottoPrice.Companion.LOTTO_PRICE
import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class TotalRate(private val lottoResults: List<LottoResult>) {

    private fun calculating(): BigDecimal {
        val totalPrize = sumPrize()
        val budget = sumLottoCount()
        return totalPrize.divide(budget, 2, RoundingMode.FLOOR)
    }

    private fun sumLottoCount() = (lottoResults.sumOf { it.prizeAndCountPair().second } * LOTTO_PRICE).toBigDecimal()

    private fun sumPrize() = lottoResults.sumOf {
        val (lottoPrize, count) = it.prizeAndCountPair()
        lottoPrize.prize * count
    }.toBigDecimal()

    companion object {
        fun calculatingOf(lottoResults: List<LottoResult>): BigDecimal = TotalRate(lottoResults).calculating()
    }
}
