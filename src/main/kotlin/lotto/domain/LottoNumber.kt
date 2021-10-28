package lotto.domain

import lotto.exception.IllegalLottoNumberException

data class LottoNumber(val value: Int) {
    init {
        if (value !in 1..45) {
            throw IllegalLottoNumberException()
        }
    }
}
