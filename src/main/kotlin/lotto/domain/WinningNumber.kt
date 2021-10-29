package lotto.domain

import lotto.exception.InvalidWinningNumberException
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_MESSAGE
import lotto.exception.InvalidWinningNumberException.Companion.INVALID_WINNING_NUMBER_RANGE_MESSAGE

class WinningNumber private constructor(
    private val winningNumbers: List<String>,
) {

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

    fun convertWinningNumber(): List<Int> {
        return winningNumbers.map { it.toInt() }
            .toList()
    }

    companion object {
        private const val LIMIT_WINNING_NUMBER = 6

        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45

        fun from(inputWinningNumber: List<String>): List<Int> {
            return WinningNumber(inputWinningNumber).convertWinningNumber()
        }
    }
}
