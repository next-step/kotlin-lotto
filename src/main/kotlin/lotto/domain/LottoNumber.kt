package lotto.domain

import lotto.domain.LottoOperator.LOTTO_FIRST_NUMBER
import lotto.domain.LottoOperator.LOTTO_LAST_NUMBER
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
}
