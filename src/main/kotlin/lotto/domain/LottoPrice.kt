package lotto.domain

class LottoPrice(
    val value: Int
) {
    init {
        require(value >= MINIMUM_PRICE) {
            "최소 ${MINIMUM_PRICE}원 이상 구매할 수 있습니다."
        }
    }

    fun getMaximumCount(): LottoCount {
        return LottoCount.from(value / MINIMUM_PRICE)
    }

    fun calculateAutomaticCount(manualLottoCount: LottoCount): LottoCount {
        return LottoCount.from(value / MINIMUM_PRICE - manualLottoCount.value)
    fun calculateAutomaticCount(manualLottoCount: Int): Int {
        return value / MINIMUM_PRICE_UNIT - manualLottoCount
    }
    }

    companion object {
        const val MINIMUM_PRICE = 1000
    }
}
