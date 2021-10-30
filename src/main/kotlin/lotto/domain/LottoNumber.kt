package lotto.domain

import lotto.exception.IllegalLottoNumberException

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        if (value !in MIN..MAX) {
            throw IllegalLottoNumberException()
        }
    }

    companion object {
        const val MIN = 1
        const val MAX = 45
    }
}
