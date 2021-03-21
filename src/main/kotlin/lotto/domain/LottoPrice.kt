package lotto.domain

class LottoPrice(
    val value: Int
) : Comparable<LottoPrice> {
    init {
        require(value >= MINIMUM_PRICE_UNIT) {
            "최소 ${MINIMUM_PRICE_UNIT}원 이상 구매할 수 있습니다."
        }
    }

    fun isGreaterThanEqualsByCount(count: Int): Boolean {
        return this >= convertCountToLottoPrice(count)
    }

    private fun convertCountToLottoPrice(count: Int): LottoPrice {
        return LottoPrice(count * MINIMUM_PRICE_UNIT)
    }

    fun calculateAutomaticCount(manualLottoCount: Int): Int {
        return value / MINIMUM_PRICE_UNIT - manualLottoCount
    }

    override fun compareTo(other: LottoPrice): Int {
        return this.value - other.value
    }

    companion object {
        const val MINIMUM_PRICE_UNIT = 1000
    }
}
