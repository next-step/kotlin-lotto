package lotto.domain

class LottoPrice(
    val value: Int
) {
    init {
        require(value >= MINIMUM_PRICE_UNIT) {
            "최소 ${MINIMUM_PRICE_UNIT}원 이상 구매할 수 있습니다."
        }
    }

    fun isExceedPriceByCount(count: Int): Boolean {
        if (count < MINIMUM_COUNT_UNIT) return true
        return convertLottoPriceToCount() >= count
    }

    private fun convertLottoPriceToCount(): Int {
        return value / MINIMUM_PRICE_UNIT
    }

    private fun convertCountToLottoPrice(count: Int): LottoPrice {
        return LottoPrice(count * MINIMUM_PRICE_UNIT)
    }

    fun calculateAutomaticCount(manualLottoCount: Int): Int {
        return convertLottoPriceToCount() - manualLottoCount
    }

    companion object {
        const val MINIMUM_PRICE_UNIT = 1000
        const val MINIMUM_COUNT_UNIT = 1
    }
}
