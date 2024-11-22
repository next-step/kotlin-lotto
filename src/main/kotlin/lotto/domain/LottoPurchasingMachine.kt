package lotto.domain

class LottoPurchasingMachine(val money: Int) {
    init {
        require(money % LOTTO_PRICE_UNIT == 0) { LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE }
    }

    fun buyCount(): Int {
        return money / LOTTO_PRICE_UNIT
    }

    companion object {
        private const val LOTTO_PRICE_UNIT = 1000
        private const val LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE = "구매금액은 1000원 단위로만 가능합니다."
    }
}
