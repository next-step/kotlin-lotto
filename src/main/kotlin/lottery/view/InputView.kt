package lottery.view

import lottery.validator.InputValidator

object InputView {
    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val INVALID_PURCHASE_AMOUNT_EXCEPTION = "구입 금액은 숫자로 입력해주세요."
    private const val INVALID_BONUS_NUMBER_EXCEPTION = "보너스 볼 번호를 숫자로 입력해주세요."

    fun inputAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        val input = readln()
        require(input.toIntOrNull() != null) { INVALID_PURCHASE_AMOUNT_EXCEPTION }
        return input.toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBERS)
        return InputValidator.validateWinningNumbers(readln())
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        val input = readln()
        require(input.toIntOrNull() != null) { INVALID_BONUS_NUMBER_EXCEPTION }
        return input.toInt()
    }
}
