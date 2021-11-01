package lotto.domain

import lotto.domain.LottoOperator.LOTTO_SIZE
import lotto.exception.InvalidWinningNumberException
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_MESSAGE

class WinningNumber(
    value: List<String>,
) {
    val value: List<LottoNumber> = value.map {
        LottoNumber(it.toInt())
    }

    init {
        if (value.isEmpty() || value.size != LOTTO_SIZE) {
            throw InvalidWinningNumberException(INVALID_WINNING_NUMBER_MESSAGE)
        }
    }
}
