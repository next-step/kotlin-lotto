package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(val map: Map<LottoRank, Int>) {
    fun calculateProfitRate(purchaseAmount: Int): Double {
        val profitRate = getTotalProfit() / purchaseAmount.toDouble()
        return BigDecimal(profitRate).setScale(SCALE, RoundingMode.DOWN).toDouble()
    }

    private fun getTotalProfit(): Int {
        var total = 0
        map.forEach { (lottoRank, count) ->
            total += lottoRank.price * count
        }
        return total
    }


    companion object {
        const val SCALE = 2
    }
}