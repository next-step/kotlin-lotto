package lotto.view

object InputView {
    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val ERR_INVALID_INPUT = "유효한 입력이 아닙니다. 다시 입력해주세요."

    fun readMoney(isValid: (value: String) -> Boolean) = readValue(isValid, INPUT_MONEY)

    fun readWinningNumbers() = readValue({ true }, INPUT_WINNING_NUMBERS)

    private fun readValue(
        isValid: (value: String) -> Boolean,
        titleMsg: String,
        errMsg: String = ERR_INVALID_INPUT
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
