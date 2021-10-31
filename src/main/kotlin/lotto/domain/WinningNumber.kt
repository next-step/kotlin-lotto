package lotto.domain

import lotto.exception.InvalidWinningNumberException
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_MESSAGE
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_RANGE_MESSAGE

class WinningNumber(
    winningNumbers: List<String>,
) {
    val winningNumbers: List<Int> = winningNumbers.map { it.toInt() }

    init {
        if (winningNumbers.isEmpty() || winningNumbers.size != LIMIT_WINNING_NUMBER) {
            throw InvalidWinningNumberException(INVALID_WINNING_NUMBER_MESSAGE)
        }
        validateWinningNumber()
    }

    private fun validateWinningNumber() {
        for (winningNumber in winningNumbers) {
            if (winningNumber.toInt() !in LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER) {
                throw InvalidWinningNumberException(INVALID_WINNING_NUMBER_RANGE_MESSAGE)
            }
        }
    }

    companion object {
        private const val LIMIT_WINNING_NUMBER = 6

        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
    }
}
