package lotto.view

object InputView {
    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요. 남은 개수 : "

    private const val ERR_INVALID_MANUAL_COUNT = "처음 지불한 금액 이하의 장수만 발급이 가능합니다."
    private const val ERR_INVALID_INPUT = "유효한 입력이 아닙니다. 다시 입력해주세요."

    fun readMoney(isValid: (value: Int) -> Boolean) =
        readNumber(INPUT_MONEY) { isValid(it.toInt()) }.toInt()

    fun readManualCount(isValid: (value: Int) -> Boolean) =
        readNumber(INPUT_MANUAL_COUNT, ERR_INVALID_MANUAL_COUNT) { isValid(it.toInt()) }.toInt()

    fun readManualNumbers(remainCount: Int, isValid: (value: String) -> Boolean) =
        readValue(INPUT_MANUAL_NUMBERS + remainCount) { isValid(it) }

    fun readWinningNumbers() = readValue(INPUT_WINNING_NUMBERS)

    fun readBonusNumber() = readNumber(INPUT_BONUS_NUMBER).toInt()

    private fun readNumber(
        titleMsg: String,
        errMsg: String = ERR_INVALID_INPUT,
        isValid: (value: String) -> Boolean = { true }
    ) = readValue(titleMsg, errMsg) { it.toIntOrNull() != null && isValid(it) }

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
