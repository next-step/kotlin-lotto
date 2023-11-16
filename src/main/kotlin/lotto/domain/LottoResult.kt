package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.EnumMap

class LottoResult {
    private val result: EnumMap<Revenue, Int> = EnumMap<Revenue, Int>(Revenue::class.java)

    fun setLottoResult(matchedNumberCount: Int) {
        if (matchedNumberCount >= MINIMUM_MATCH_COUNT) {
            val key = Revenue.of(matchedNumberCount)
            result[key] = result.getOrDefault(key, 0) + 1
        }
    }

    fun getLottoResult(key: Int): Int {
        if (key < MINIMUM_MATCH_COUNT) {
            return 0
        }
        return result[Revenue.of(key)] ?: 0
    }

    fun calcRate(lottoPrice: Int, userLottoCount: Int): String {
        val userTotalPay = lottoPrice * userLottoCount
        DECIMAL_FORMAT.roundingMode = RoundingMode.DOWN
        var revenue = 0
        result.keys.forEach {

            revenue += this.getLottoResult(it.matchCount) * it.prizeMoney
        }
        val result = revenue / userTotalPay.toDouble()

        return DECIMAL_FORMAT.format(result)
    }

    companion object {
        private const val MINIMUM_MATCH_COUNT: Int = 3
        private val DECIMAL_FORMAT: DecimalFormat = DecimalFormat("#.##")
    }
}
