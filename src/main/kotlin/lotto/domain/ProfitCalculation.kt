package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

class ProfitCalculation {

    fun getProfitRate(lottoRanks: Map<LottoRank, Int>, budget: Int): Float {
        val rate = lottoRanks.map { it.value * it.key.winningPrice }
            .sum() / budget.toFloat()
        return roundDecimal(rate)
    }

    private fun roundDecimal(number: Float): Float {
        val decimalFormat = DecimalFormat("#.##")
        decimalFormat.roundingMode = RoundingMode.DOWN
        return decimalFormat.format(number).toFloat()
    }
}
