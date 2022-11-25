package lotto.domain

import lotto.domain.LottoNumber.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MINIMUM_LOTTO_NUMBER

@JvmInline
value class LottoNumbers(val value: List<LottoNumber> = (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).shuffled().take(MAXIMUM_LOTTO_NUMBER_LENGTH).sorted().map { LottoNumber(it) }) {
    constructor(value: String) : this(
        value.split(DELIMITER)
            .map { LottoNumber(it.toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.")) }
    )

    companion object {
        const val MAXIMUM_LOTTO_NUMBER_LENGTH = 6
        const val DELIMITER = ", "
    }
}
