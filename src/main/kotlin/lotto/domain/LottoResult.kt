package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

class LottoResult {
    private val result: HashMap<Int, Int> = hashMapOf()

    fun setLottoResult(matchedNumberCount: Int) {
        if (matchedNumberCount >= MINIMUM_MATCH_COUNT) {
            result[matchedNumberCount] = result.getOrDefault(matchedNumberCount, 0) + 1
        }
    }

    fun getLottoResult(key: Int): Int {
        return result[key] ?: 0
    }

    fun calcRate(lottoPrice: Int, userLottoCount: Int): String {
        val userTotalPay = lottoPrice * userLottoCount
        DECIMAL_FORMAT.roundingMode = RoundingMode.DOWN
        var revenue = 0
        result.keys.forEach {
            revenue += this.getLottoResult(it) * REVENUE_MAP.getOrDefault(it, 0)
        }
        val result = revenue / userTotalPay.toDouble()

        return DECIMAL_FORMAT.format(result)
    }

    companion object {
        private const val MINIMUM_MATCH_COUNT: Int = 3
        private val DECIMAL_FORMAT: DecimalFormat = DecimalFormat("#.##")
        private val REVENUE_MAP: HashMap<Int, Int> = hashMapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000
        )
    }
}
