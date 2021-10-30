package lotto.domain

import lotto.exception.IllegalLottoNumberException

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        if (value !in 1..45) {
            throw IllegalLottoNumberException()
        }
    }
}
