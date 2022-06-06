package lotto.domain

import lotto.constants.ErrorMessages

/**
 * Created by Jaesungchi on 2022.06.05..
 */
data class LottoNumber private constructor(val value: Int) {

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        val LOTTO_NUMBER_RANGE = MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER

        private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.associateWith { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            require(value in LOTTO_NUMBER_RANGE) { ErrorMessages.NUMBER_IS_OVER_OR_UNDER_BASE }
            return LOTTO_NUMBERS[value] ?: throw IllegalArgumentException()
        }
    }
}
