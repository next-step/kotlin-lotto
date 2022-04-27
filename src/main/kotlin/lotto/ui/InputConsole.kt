package lotto.ui

object InputConsole : Input {
    private const val BUY_NOTHING = 0
    private const val ERR_INPUT_INVALID_NUMBER = "[ERROR] The given input number is invalid"

    override fun inputLottoGamesBuyPrice(): Int =
        runCatching {
            readLine()
                ?.toInt()
                ?: BUY_NOTHING
        }.getOrElse {
            throw IllegalArgumentException(ERR_INPUT_INVALID_NUMBER)
        }

    override fun inputWinningNumbersForLastWeek(): String =
        run {
            readLine() ?: throw IllegalArgumentException(ERR_INPUT_INVALID_NUMBER)
        }
}
