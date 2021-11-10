package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class TotalRate private constructor(private val benefit: BigDecimal) {

    fun getBenefit() = benefit

    companion object {
        fun calculatingOf(lottoResults: LottoResults): TotalRate {
            val totalPrize = lottoResults.sumPrize()
            val budget = lottoResults.sumLottoCount()
            return TotalRate(totalPrize.divide(budget, 2, RoundingMode.FLOOR))
        }
    }
}
