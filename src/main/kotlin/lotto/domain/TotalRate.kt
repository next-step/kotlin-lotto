package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class TotalRate private constructor(private val benefit: BigDecimal) {

    fun toBenefit() = benefit

    companion object {
        fun calculatingOf(lottoResults: LottoResults): TotalRate {
            val totalPrize = sumPrize(lottoResults)
            val budget = sumLottoCount(lottoResults)
            return TotalRate(totalPrize.divide(budget, 2, RoundingMode.FLOOR))
        }

        private fun sumLottoCount(lottoResults: LottoResults): BigDecimal =
            (lottoResults.toList().sumOf { it.prizeAndCountPair().second } * Lotto.PRICE).toBigDecimal()

        private fun sumPrize(lottoResults: LottoResults): BigDecimal = lottoResults.toList().sumOf {
            val (lottoPrize, count) = it.prizeAndCountPair()
            lottoPrize.prize * count
        }.toBigDecimal()
    }
}
