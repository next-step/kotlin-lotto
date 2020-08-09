package lotto.model.prize

import lotto.model.lotto.Lotto

class Money(val value: Int) {
    init {
        validation(value)
    }

    fun canBuyLottoCount() = value / Lotto.PRICE

    operator fun times(integerData: Int): Money {
        validation(integerData)
        return Money(value * integerData)
    }

    private fun validation(value: Int) {
        require(value >= 0) { "0보다 작은 수는 돈이 아닙니다." }
    }
}
