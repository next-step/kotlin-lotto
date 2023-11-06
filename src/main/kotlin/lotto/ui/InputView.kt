package lotto.ui

object InputView {

    private const val INPUT_AMOUNT_NAME_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
    private const val WINNING_NUMBERS_DELIMITER = ", "

    fun inputAmount(): Int {
        println(INPUT_AMOUNT_NAME_MESSAGE)
        return readln().toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBERS_MESSAGE)
        return readln().split(WINNING_NUMBERS_DELIMITER).map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return readln().toInt()
    }
}
