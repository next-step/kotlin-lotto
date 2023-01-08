package lotto.ui

object InputViews {

    private const val MESSAGE_INPUT_PRICE = "구입금액을 입력해 주세요."
    private const val MESSAGE_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val MESSAGE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해주세요."
    private const val DELIMITERS = ", "
    private const val DEFAULT_PRICE = 0
    private const val DEFAULT_BONUS_NUMBER = 0

    fun inputPrice(): Int {
        println(MESSAGE_INPUT_PRICE)
        return readLine()?.toIntOrNull() ?: DEFAULT_PRICE
    }

    fun inputWinningNumber(): List<String> {
        println(MESSAGE_INPUT_WINNING_NUMBER)
        return readLine()?.split(DELIMITERS) ?: emptyList()
    }

    fun inputBonusNumber(): Int {
        println(MESSAGE_INPUT_BONUS_NUMBER)
        return readLine()?.toIntOrNull() ?: DEFAULT_BONUS_NUMBER
    }
}
