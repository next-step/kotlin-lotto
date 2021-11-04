package lotto.domain

import lotto.exception.InvalidLottoNumberException

@JvmInline
value class LottoNumber(
    val value: Int,
) {
    init {
        if (value !in LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER) {
            throw InvalidLottoNumberException()
        }
    }

    companion object {
        const val LOTTO_FIRST_NUMBER = 1
        const val LOTTO_LAST_NUMBER = 45

        const val LOTTO_SIZE = 6
    }
}
