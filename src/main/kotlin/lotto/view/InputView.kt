package lotto.view

object InputView {
    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요. 남은 개수 : "

    private const val ERR_INVALID_INPUT = "유효한 입력이 아닙니다. 다시 입력해주세요."

    fun readMoney(isValid: (value: Int) -> Boolean) = readNumber(INPUT_MONEY) { isValid(it.toInt()) }.toInt()

    fun readWinningNumbers() = readValue(INPUT_WINNING_NUMBERS)

    fun readBonusNumber() = readNumber(INPUT_BONUS_NUMBER).toInt()

    fun readManualCount() = readValue(INPUT_MANUAL_COUNT)

    fun readManualNumbers(remainCount: Int) = readValue(INPUT_MANUAL_NUMBERS + remainCount)

    private fun readNumber(
        titleMsg: String,
        errMsg: String = ERR_INVALID_INPUT,
        isValid: (value: String) -> Boolean = { true }
    ) = readValue(titleMsg, errMsg) { isValid(it) && it.toIntOrNull() != null }

    private fun readValue(
        titleMsg: String,
        errMsg: String = ERR_INVALID_INPUT,
        isValid: (value: String) -> Boolean = { true }
    ): String {
        println(titleMsg)
        var string = readLine()

        while (string.isNullOrBlank() || !isValid(string)) {
            println(errMsg)
            string = readLine()
        }

        return string
    }
}
