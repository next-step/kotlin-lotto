package lotto.ui

object InputViews {

    private const val MESSAGE_INPUT_PRICE = "구입금액을 입력해 주세요."
    private const val MESSAGE_INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val DELIMITERS = ", "
    private const val DEFAULT_PRICE = 0

    fun inputPrice(): Int {
        println(MESSAGE_INPUT_PRICE)
        return readLine()?.toIntOrNull() ?: DEFAULT_PRICE
    }

    fun inputWinningNumber(): List<String> {
        println(MESSAGE_INPUT_WINNING_NUMBER)
        return readLine()?.split(DELIMITERS) ?: emptyList()
    }
}
