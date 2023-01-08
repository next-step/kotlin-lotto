package lotto.domain

class WinningLotto(
    val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    init {
        if (winningNumbers.isEmpty() || winningNumbers.size != LIMIT_WINNING_NUMBER) {
            throw IllegalArgumentException("당첨 번호는 6개 입니다.")
        }
        validateWinningNumber()
    }

    fun isMatchBonus(bonusNumber: Int): Boolean {
        return this.bonusNumber == bonusNumber
    }

    private fun validateWinningNumber() {
        for (winningNumber in winningNumbers) {
            require(winningNumber in LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER) {
                MESSAGE_LOTTO_RANGE
            }
        }
    }

    companion object {
        private const val LIMIT_WINNING_NUMBER = 6

        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        private const val MESSAGE_LOTTO_RANGE = "당첨 번호는 1 ~ 45 범위의 숫자로만 구성될 수 있습니다."

        fun of(winningNumbers: List<String>, bonusNumber: Int): WinningLotto {
            return WinningLotto(winningNumbers.map { it.toInt() }, bonusNumber)
        }
    }
}
