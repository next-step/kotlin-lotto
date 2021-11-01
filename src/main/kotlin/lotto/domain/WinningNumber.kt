package lotto.domain

import lotto.domain.LottoOperator.LOTTO_SIZE
import lotto.exception.InvalidWinningNumberException
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_MESSAGE

class WinningNumber(
    winningNumbers: List<String>,
) {
    val winningNumbers: List<LottoNumber> = winningNumbers.map {
        LottoNumber(it.toInt())
    }

    init {
        if (winningNumbers.isEmpty() || winningNumbers.size != LOTTO_SIZE) {
            throw InvalidWinningNumberException(INVALID_WINNING_NUMBER_MESSAGE)
        }
    }
}
