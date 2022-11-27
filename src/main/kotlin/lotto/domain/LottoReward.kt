package lotto.domain

import lotto.util.NumberUtil

class LottoReward(
    winLottoList: List<WinLottoPrize>
) {
    private val prizeList: List<Int> = winLottoList.map { it.prizeMoney }
    private val totalPrize: Int = prizeList.sum()

    fun earningRate(inputPayment: Int): Double {
        val earningRate = totalPrize.toDouble() / inputPayment.toDouble()
        return NumberUtil.floor(earningRate, EARNING_RATE_DECIMAL_PLACE)
    }

    companion object {
        private const val EARNING_RATE_DECIMAL_PLACE = 2
    }
}
