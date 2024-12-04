package lotto.view

class InputView {
    companion object {
        private const val PURCHASE_INFORMATION_MESSAGE = "구입금액을 입력해 주세요."
        private const val WINNING_NUMBER_DELIMITERS = ","
        private const val REPLACEMENT_SOURCE = " "
        private const val REPLACEMENT_TARGET = ""
        private const val WINNING_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val BONUS_BALL_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val ERROR_INVALID_NUMBER = "유효한 숫자를 입력해주세요."
        private const val ERROR_WRONG_NUMBER_COUNT = "정확히 6개의 숫자를 입력해야 합니다."

        fun purchaseAmount(): Int {
            println(PURCHASE_INFORMATION_MESSAGE)
            return readln().toIntOrNull()
                ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER)
        }

        fun winningNumbers(): Set<Int> {
            println(WINNING_NUMBER_INPUT_MESSAGE)
            return readln().replace(REPLACEMENT_SOURCE, REPLACEMENT_TARGET)
                .split(WINNING_NUMBER_DELIMITERS)
                .also { require(it.size == 6) { ERROR_WRONG_NUMBER_COUNT } }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER) }
                .toSet()
        }

        fun bonusBall(): Int {
            println(BONUS_BALL_NUMBER_INPUT_MESSAGE)
            return readln().toIntOrNull()
                ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER)
        }
    }
}
