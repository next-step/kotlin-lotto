package lotto.domain

import lotto.domain.LottoOperator.LOTTO_FIRST_NUMBER
import lotto.domain.LottoOperator.LOTTO_LAST_NUMBER
import lotto.domain.LottoOperator.LOTTO_SIZE
import lotto.exception.InvalidWinningNumberException
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_MESSAGE
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_RANGE_MESSAGE

class WinningNumber(
    winningNumbers: List<String>,
) {
    val winningNumbers: List<Int> = winningNumbers.map { it.toInt() }

    init {
        if (winningNumbers.isEmpty() || winningNumbers.size != LOTTO_SIZE) {
            throw InvalidWinningNumberException(INVALID_WINNING_NUMBER_MESSAGE)
        }
        validateWinningNumber()
    }

    private fun validateWinningNumber() {
        for (winningNumber in winningNumbers) {
            if (winningNumber !in LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER) {
                throw InvalidWinningNumberException(INVALID_WINNING_NUMBER_RANGE_MESSAGE)
            }
        }
    }
}
