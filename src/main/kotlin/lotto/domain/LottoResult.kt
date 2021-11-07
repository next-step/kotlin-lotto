package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

data class LottoResult(val result: Map<Rank, Int>) {

    private fun getTotalPrize(): Int {
        return result.keys.map { it.prizeByCount(result.getValue(it)) }.sum()
    }

    fun getProfit(money: Money): Float {
        val profit = (getTotalPrize() / (Lotto.getPurchasedLottoCount(money) * Lotto.PRICE.money * 1f))
        return DECIMAL_FORMAT.format(profit).toFloat()
    }

    companion object {
        val DECIMAL_FORMAT = DecimalFormat("#.##").apply {
            roundingMode = RoundingMode.HALF_UP
        }
    }
}
