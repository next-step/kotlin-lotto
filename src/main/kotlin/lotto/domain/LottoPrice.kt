package lotto.domain

import lotto.Const

class LottoPrice(
    private val price: Int
) {
    init {
        requirePositiveNumber()
    }

    fun get() = price

    private fun requirePositiveNumber() {
        require(price >= 0) { Const.ErrorMsg.INPUT_VALUE_CANNOT_CONVERSE_LOTTO_PRICE_ERROR_MSG }
    }
    operator fun div(other: Int): Int = this.price / other

    operator fun compareTo(other: Int) = this.price.compareTo(other)
}
