package lotto.model

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
}
