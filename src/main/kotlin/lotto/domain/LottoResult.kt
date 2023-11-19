package lotto.domain

class LottoResult {
    private val result: MutableMap<Revenue, Int> = Revenue.values().associateWith { DEFAULT_MAP_VALUE }.toMutableMap()

    fun setLottoResult(matchedNumberCount: Int) {
        if (matchedNumberCount >= MINIMUM_MATCH_COUNT) {
            val key = Revenue.of(matchedNumberCount)
            result[key] = result.getOrDefault(key, 0) + 1
        }
    }

    fun getLottoRankCount(key: Int): Int {
        if (key < MINIMUM_MATCH_COUNT) {
            return 0
        }
        return result[Revenue.of(key)] ?: 0
    }

    fun calcRate(lottoPrice: Int, userLottoCount: Int): Double {
        val userTotalPay = lottoPrice * userLottoCount
        var revenue = 0
        result.keys.forEach {

            revenue += this.getLottoRankCount(it.matchCount) * it.prizeMoney
        }
        return revenue / userTotalPay.toDouble()
    }

    companion object {
        private const val MINIMUM_MATCH_COUNT: Int = 3
        private const val DEFAULT_MAP_VALUE: Int = 0
    }
}
