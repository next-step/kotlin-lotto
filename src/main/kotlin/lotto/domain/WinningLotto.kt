package lotto.domain

class WinningLotto(
    inputNumbers: List<String>
) {

    val winningNumbers = inputNumbers.map { it.toInt() }

    init {
        if (winningNumbers.isEmpty() || winningNumbers.size != LIMIT_WINNING_NUMBER) {
            throw IllegalArgumentException("당첨 번호는 6개 입니다.")
        }
        validateWinningNumber()
    }

    private fun validateWinningNumber() {
        for (winningNumber in winningNumbers) {
            if (winningNumber !in LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER) {
                throw IllegalArgumentException("당첨 번호는 1 ~ 45 범위의 숫자로만 구성될 수 있습니다.")
            }
        }
    }

    companion object {
        private const val LIMIT_WINNING_NUMBER = 6

        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
    }
}
