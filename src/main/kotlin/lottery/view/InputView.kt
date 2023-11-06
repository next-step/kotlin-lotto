package lottery.view

import lottery.validator.InputValidator

object InputView {
    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."

    fun inputAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return InputValidator.validateAmount(readln())
    }

    fun inputWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBERS)
        return InputValidator.validateWinningNumbers(readln())
    }
}
