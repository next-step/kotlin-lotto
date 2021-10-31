package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class TotalRate(private val lottoResults: LottoResults) {

    private fun calculating(): BigDecimal {
        val totalPrize = sumPrize()
        val budget = sumLottoCount()
        return totalPrize.divide(budget, 2, RoundingMode.FLOOR)
    }

    private fun sumLottoCount() =
        (lottoResults.toList().sumOf { it.prizeAndCountPair().second } * Lotto.PRICE).toBigDecimal()

    private fun sumPrize() = lottoResults.toList().sumOf {
        val (lottoPrize, count) = it.prizeAndCountPair()
        lottoPrize.prize * count
    }.toBigDecimal()

    companion object {
        fun calculatingOf(lottoResults: LottoResults): BigDecimal = TotalRate(lottoResults).calculating()
    }
}
