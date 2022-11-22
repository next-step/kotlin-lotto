package lotto.domain

import lotto.util.ErrorCode

class LottoPurchase(
    price: Long
) {
    private val lottoCount: Long

    init {
        lottoCount = price / LOTTO_PRICE

        require(price >= LOTTO_PRICE) {
            ErrorCode.LOTTO_MIN_LIMIT_EXCEPTION.errorMessage
        }
        require(price % LOTTO_PRICE == LONG_ZERO) {
            ErrorCode.LOTTO_PRICE_UNIT_EXCEPTION.errorMessage
        }
    }

    fun getLottoCount(): Long = lottoCount

    companion object {
        const val LOTTO_PRICE: Long = 1000
        const val LONG_ZERO: Long = 0
    }
}
