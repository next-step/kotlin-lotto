package lotto.domain

import lotto.exception.InvalidLottoPriceException

@JvmInline
value class Price(
    private val value: Int,
) {

    init {
        if (value == 0 || value.rem(DEFAULT_LOTTO_PRICE) != 0) {
            throw InvalidLottoPriceException()
        }
    }

    fun checkLottoCount(): Int = value.div(DEFAULT_LOTTO_PRICE)

    companion object {
        private const val DEFAULT_LOTTO_PRICE = 1000
    }
}
