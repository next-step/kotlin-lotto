package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

data class LottoResult(val result: Map<Rank, Int>) {

    private fun getTotalPrize(): Int {
        return result.keys.map { it.prizeByCount(result.getValue(it)) }.sum()
    }

    fun getProfit(money: Money): Float {
        val profit = (getTotalPrize() / (money.lottoCount * Money.LOTTO_PRICE * 1f))
        return DECIMAL_FORMAT.format(profit).toFloat()
    }

    companion object {
        val DECIMAL_FORMAT = DecimalFormat("#.##").apply {
            roundingMode = RoundingMode.HALF_UP
        }
    }
}
