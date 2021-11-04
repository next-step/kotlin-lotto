package lotto.view

class InputView {

    fun inputPurchaseAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        val input = readLine() ?: DEFAULT_PURCHASE_AMOUNT

        return input.toInt()
    }

    fun inputWinningNumber(): List<Int> {
        println(INPUT_WINNING_NUMBERS)
        val winningNumbers = readLine() ?: DEFAULT_WINNING_NUMBERS

        return winningNumbers
            .split(SEPARATOR)
            .map { winningNumber ->
                winningNumber.toInt()
            }
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        val bonusNumber = readLine() ?: DEFAULT_BONUS_NUMBER

        return bonusNumber.toInt()
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구매금액을 입력해주세요."
        private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요."
        private const val SEPARATOR = ","
        private const val DEFAULT_PURCHASE_AMOUNT = "0"
        private const val DEFAULT_WINNING_NUMBERS = "0, 0, 0, 0, 0, 0"
        private const val DEFAULT_BONUS_NUMBER = "0"
    }
}
