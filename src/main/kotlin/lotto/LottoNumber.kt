package lotto

import lotto.util.ExceptionMessage

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { ExceptionMessage.LOTTO_NUMBER_ERROR }
    }
}
