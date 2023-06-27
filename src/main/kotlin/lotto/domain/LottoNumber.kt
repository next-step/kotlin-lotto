package lotto.domain

import lotto.domain.LottoErrorMessage.LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45
import lotto.domain.LottoErrorMessage.LOTTO_NUMBERS_MUST_BE_POSITIVE

@JvmInline
value class LottoNumber private constructor(
    val number: Int
) {
    init {
        require(number > 0) { LOTTO_NUMBERS_MUST_BE_POSITIVE }
        require(number in LOTTO_NUMBERS_RANGE) { LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45 }
    }

    companion object {
        val LOTTO_NUMBERS_RANGE = 1..45
        private val LOTTO_NUMBERS = LOTTO_NUMBERS_RANGE.map { LottoNumber(it) }.toList()

        fun create(number: Int): LottoNumber = LOTTO_NUMBERS[number - 1]

        fun createRandoms(size: Int): List<LottoNumber> = LOTTO_NUMBERS.shuffled().take(size)
    }
}
