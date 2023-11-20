package lotto.domain

class LottoResult(
    private val result: Map<Revenue, Int>
) {

    fun getLottoRankCount(key: Int): Int {
        if (key < MINIMUM_MATCH_COUNT) {
            return 0
        }
        return result.getOrDefault(Revenue.of(key, false), DEFAULT_MAP_VALUE)
    }

    fun getLottoRankingMatchCount(key: Revenue): Int {
        return result.getOrDefault(key, DEFAULT_MAP_VALUE)
    }

    fun calcRate(lottoPrice: Int, userLottoCount: Int): Double {
        val userTotalPay = lottoPrice * userLottoCount
        var revenue = 0
        result.keys.forEach {

            revenue += this.getLottoRankingMatchCount(it) * it.prizeMoney
        }
        return revenue / userTotalPay.toDouble()
    }

    companion object {
        const val MINIMUM_MATCH_COUNT: Int = 3
        private const val DEFAULT_MAP_VALUE: Int = 0
    }
}
