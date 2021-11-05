package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_SIZE
import lotto.exception.InvalidWinningNumberException
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_MESSAGE

class WinningNumber(
    value: List<String>,
) {
    val value = value.toList().map {
        LottoNumber.valueOf(it.toInt())
    }

    init {
        if (this.value.isEmpty() || this.value.size != LOTTO_SIZE) {
            throw InvalidWinningNumberException(INVALID_WINNING_NUMBER_MESSAGE)
        }
    }
}
