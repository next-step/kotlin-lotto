package lotto.domain

import lotto.domain.model.LottoResult
import lotto.domain.model.Money
import java.math.RoundingMode
import java.text.DecimalFormat

object LottoCalculator {
    private const val DECIMAL_PATTERN = "#.##"
    private val decimalFormat = DecimalFormat(DECIMAL_PATTERN).apply {
        roundingMode = RoundingMode.DOWN
    }

    fun earningRate(results: List<LottoResult>, money: Money): Double {
        var totalPrize = 0.0
        results.forEach {
            totalPrize += it.count.value * it.prize.reward.value
        }

        if (money.value == 0) return 0.0

        return decimalFormat.format(totalPrize / money.value).toDouble()
    }
}
