package lotto.domain

import lotto.Const

class LottoPrice(
    private val price: Int
) {
    init {
        requireBiggerThanLottoPrice()
    }

    constructor(price: String?) : this(stringToInt(price))

    private fun requireBiggerThanLottoPrice() {
        require(price >= LottoPurchase.LOTTO_PRICE) { Const.ErrorMsg.INPUT_VALUE_CANNOT_CONVERSE_LOTTO_PRICE_ERROR_MSG }
    }

    operator fun div(other: Int): Int = this.price / other

    operator fun compareTo(other: Int): Int = this.price.compareTo(other)

    companion object {
        private fun stringToInt(price: String?): Int {
            require(!price.isNullOrBlank()) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR_MSG }
            return requireNotNull(price.toIntOrNull()) { Const.ErrorMsg.INPUT_VALUE_IS_NOT_INT_ERROR_MSG }
        }
    }
}
