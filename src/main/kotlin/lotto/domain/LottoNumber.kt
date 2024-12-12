package lotto.domain

import lotto.constant.MAXIMUM_NUMBER
import lotto.constant.MINIMUM_NUMBER

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MINIMUM_NUMBER..MAXIMUM_NUMBER) {
            CANNOT_CREATE_LOTTO_NUMBER_MESSAGE.format(MINIMUM_NUMBER, MAXIMUM_NUMBER)
        }
    }

    companion object {
        private const val CANNOT_CREATE_LOTTO_NUMBER_MESSAGE = "Lotto number must be between %s and %s."
    }
}
