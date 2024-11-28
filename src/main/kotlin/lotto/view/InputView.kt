package lotto.view

class InputView {
    companion object {
        fun purchaseAmount(): Int {
            println(PURCHASE_INFORMATION_MESSAGE)
            return readln().toIntOrNull()
                ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER)
        }

        fun winningNumbers(): Set<Int> {
            return readln().replace(REPLACEMENT_SOURCE, REPLACEMENT_TARGET)
                .split(WINNING_NUMBER_DELIMITERS)
                .also { if (it.size != 6) throw IllegalArgumentException(ERROR_WRONG_NUMBER_COUNT) }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER) }
                .toSet()
        }

        private const val PURCHASE_INFORMATION_MESSAGE = "구입금액을 입력해 주세요."
        private const val WINNING_NUMBER_DELIMITERS = ","
        private const val REPLACEMENT_SOURCE = " "
        private const val REPLACEMENT_TARGET = ""

        private const val ERROR_INVALID_NUMBER = "유효한 숫자를 입력해주세요."
        private const val ERROR_WRONG_NUMBER_COUNT = "정확히 6개의 숫자를 입력해야 합니다."
    }
}
