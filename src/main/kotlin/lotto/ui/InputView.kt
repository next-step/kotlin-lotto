package lotto.ui

import lotto.application.WinnerInfo

object InputView {
    private const val PAYMENT_PROMPT = "구입금액을 입력해 주세요."
    private const val NUMBER_OF_MANUAL_PROMPT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val MANUAL_LOTTO_PROMPT = "수동으로 구매할 번호를 입력해 주세요."
    private const val NUMBER_VALIDATION_FAIL = "숫자를 입력해 주세요."
    private const val WINNER_PROMPT = "지난 주 당첨 번호를 입력해 주세요."
    private const val WINNER_VALIDATION_FAIL = "당첨 번호를 , 로 구분하여 입력해 주세요. (예시: 1, 2, 3, 4, 5, 6)"
    private const val BONUS_BALL_PROMPT = "보너스 볼을 입력해 주세요."
    private val DELIMITER_PATTERN = "\\s*,\\s*".toRegex()
    private val LINE_PATTERN = """^\s*(\d+\s*,\s*){5}\d+\s*$""".toRegex()
    private val NEWLINE = System.lineSeparator()

    fun getPayment(): Long {
        val number = getNumber(PAYMENT_PROMPT) ?: return getPayment()
        return number.toLong()
    }

    fun getNumberOfManual(): Int = getNumber(NEWLINE + NUMBER_OF_MANUAL_PROMPT) ?: getNumberOfManual()

    fun getManualLotto(numberOfManual: Int): List<List<Int>> {
        println(NEWLINE + MANUAL_LOTTO_PROMPT)
        return (1..numberOfManual)
            .map { getLine() }
    }

    fun getWinner(): WinnerInfo {
        println(WINNER_PROMPT)
        val line = getLine()
        val bonusBall = getBonusBall()
        return WinnerInfo(line, bonusBall)
    }

    private fun getNumber(prompt: String): Int? {
        println(prompt)
        val result = readln().toIntOrNull()
        if (result == null) {
            println(NUMBER_VALIDATION_FAIL)
        }
        return result
    }

    private fun getLine(): List<Int> {
        val rawInput = readln()
        if (!validateLine(rawInput)) {
            println(WINNER_VALIDATION_FAIL)
            return getLine()
        }
        return rawInput.split(DELIMITER_PATTERN).map { it.toInt() }
    }

    private fun getBonusBall(): Int = getNumber(BONUS_BALL_PROMPT) ?: getBonusBall()

    private fun validateLine(line: String): Boolean = line.matches(LINE_PATTERN)
}
