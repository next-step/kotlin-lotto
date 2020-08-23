package lotto.model.prize

class Money(private var _value: Int) {
    val value: Int
        get() = _value

    init {
        validation(value)
    }

    fun availableLottoCount() = value / LOTTO_PRICE

    fun buyLottos(lottoCount: Int) {
        require(availableLottoCount() >= lottoCount) { "구매 가능한 금액을 벗어났습니다." }
        _value -= lottoCount * LOTTO_PRICE
    }

    operator fun times(integerData: Int): Money {
        validation(integerData)
        return Money(value * integerData)
    }

    private fun validation(value: Int) {
        require(value >= 0) { "0보다 작은 수는 돈이 아닙니다." }
    }

    companion object {
        const val LOTTO_PRICE = 1_000
        fun purchaseAmount(lottoCount: Int) = lottoCount * LOTTO_PRICE
    }
}
