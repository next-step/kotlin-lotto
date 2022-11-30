package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(private val purchasePrice: Int, val winningAmountList: Map<Int, Int>) {
    fun calculateReturnRate(): Double {
        val totalWinningAmount = winningAmountList.map{ (rewardPrice, count) -> rewardPrice * count }.sum().toDouble()

        return BigDecimal(totalWinningAmount / purchasePrice).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    }
}