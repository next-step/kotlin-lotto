package lotto.ui

import lotto.domain.LottoLine

object InputView {
    private const val PAYMENT_PROMPT = "구입금액을 입력해 주세요."
    private const val PAYMENT_VALIDATION_FAIL_PROMPT = "숫자를 입력해 주세요."
    private const val WINNER_PROMPT = "지난 주 당첨 번호를 입력해 주세요."
    private val DELIMITER_PATTERN = "\\s*,\\s*".toRegex()
    private val LINE_PATTERN = """^\s*(\d+\s*,\s*){5}\d+\s*$""".toRegex()

    fun getPayment(): Int {
        println(PAYMENT_PROMPT)
        val rawInput = readln()
        if (!validateNumber(rawInput)) {
            println(PAYMENT_VALIDATION_FAIL_PROMPT)
            return getPayment()
        }
        return rawInput.toInt()
    }

    fun getWinner(): LottoLine {
        println(WINNER_PROMPT)
        val rawInput = readln()
        if (!validateLine(rawInput)) {
            return getWinner()
        }
        val tokens = rawInput.split(DELIMITER_PATTERN)
        val values = tokens.map { it.toInt() }
        return LottoLine.from(values)
    }

    private fun validateNumber(input: String): Boolean = input.toIntOrNull() != null

    private fun validateLine(line: String): Boolean = line.matches(LINE_PATTERN)
}
