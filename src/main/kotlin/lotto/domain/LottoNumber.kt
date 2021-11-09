package lotto.domain

import lotto.exception.InvalidLottoNumberException

@JvmInline
value class LottoNumber private constructor(
    val value: Int,
) {
    companion object {
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45

        const val LOTTO_SIZE = 6
        private const val INDEX = 1

        val LOTTO_NUMBER_CACHE: Array<LottoNumber> = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER)
            .map { LottoNumber(it) }
            .toTypedArray()

        fun valueOf(number: Int): LottoNumber {
            if (number !in LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER) {
                throw InvalidLottoNumberException()
            }
            return LOTTO_NUMBER_CACHE[number - INDEX]
        }
    }
}
