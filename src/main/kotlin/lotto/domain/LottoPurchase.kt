package lotto.domain

import lotto.util.ErrorCode

class LottoPurchase(
    price: Long,
    private val manualLottoCount: Long = DEFAULT_MANUAL_COUNT
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
        require(manualLottoCount <= lottoCount) {
            ErrorCode.MANUAL_LOTTO_COUNT_EXCEPTION.errorMessage
        }
    }

    fun getLottoCount(): Long = lottoCount

    fun getAutoLottoCount(): Long = lottoCount - manualLottoCount

    companion object {
        const val LOTTO_PRICE = 1000L
        const val LONG_ZERO = 0L
        const val DEFAULT_MANUAL_COUNT = 0L
    }
}
