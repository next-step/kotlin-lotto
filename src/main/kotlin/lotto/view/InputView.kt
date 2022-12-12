package lotto.view

object InputView {
    private const val INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val ERROR = "[ERROR] "

    fun inputAmount(): String {
        println(INPUT_AMOUNT_MESSAGE)
        return readln()
    }

    fun inputNumberOfManualLotto(): String {
        println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE)
        return readln()
    }

    fun inputWinningNumber(): String {
        println(INPUT_WINNING_NUMBER)
        return readln()
    }

    fun inputBonusNumber(): String {
        println(INPUT_BONUS_NUMBER)
        return readln()
    }

    fun printError(message: String) {
        println(ERROR + message)
    }
}
