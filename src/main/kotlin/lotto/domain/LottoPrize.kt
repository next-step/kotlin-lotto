package lotto.domain

import lotto.util.NumberUtil

class LottoPrize(
    prizeList: List<Int>
) {
    private val totalPrize: Int = prizeList.sum()

    fun totalRate(inputPayment: Int): Double {
        val totalRate = totalPrize.toDouble() / inputPayment.toDouble()
        return NumberUtil.floor(totalRate, EARING_RATE_DECIMAL_PLACE)
    }

    companion object {
        private const val EARING_RATE_DECIMAL_PLACE = 2
    }
}
