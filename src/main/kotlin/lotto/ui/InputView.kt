package lotto.ui

import lotto.domain.LottoLine
import lotto.domain.LottoNumber
import lotto.domain.LottoPayment
import lotto.domain.WinningLine

object InputView {
    private const val PAYMENT_PROMPT = "구입금액을 입력해 주세요."
    private const val NUMBER_VALIDATION_FAIL_PROMPT = "숫자를 입력해 주세요."
    private const val WINNER_PROMPT = "지난 주 당첨 번호를 입력해 주세요."
    private const val WINNER_VALIDATION_FAIL_PROMPT = "당첨 번호를 , 로 구분하여 입력해 주세요. (예시: 1, 2, 3, 4, 5, 6)"
    private const val BONUS_BALL_PROMPT = "보너스 볼을 입력해 주세요."
    private val DELIMITER_PATTERN = "\\s*,\\s*".toRegex()
    private val LINE_PATTERN = """^\s*(\d+\s*,\s*){5}\d+\s*$""".toRegex()

    fun getPayment(): LottoPayment {
        println(PAYMENT_PROMPT)
        val rawInput = readln()
        if (!validateNumber(rawInput)) {
            println(NUMBER_VALIDATION_FAIL_PROMPT)
            return getPayment()
        }
        return LottoPayment.from(rawInput.toLong())
    }

    fun getWinner(): WinningLine {
        println(WINNER_PROMPT)
        val line: LottoLine = getLine()
        val bonusBall: LottoNumber = getBonusBall()
        return WinningLine(line, bonusBall)
    }

    private fun getLine(): LottoLine {
        val rawInput = readln()
        if (!validateLine(rawInput)) {
            println(WINNER_VALIDATION_FAIL_PROMPT)
            return getLine()
        }
        val tokens = rawInput.split(DELIMITER_PATTERN)
        val values = tokens.map { it.toInt() }
        return LottoLine.from(values)
    }

    private fun getBonusBall(): LottoNumber {
        println(BONUS_BALL_PROMPT)
        val rawInput = readln()
        if (!validateNumber(rawInput)) {
            println(NUMBER_VALIDATION_FAIL_PROMPT)
            return getBonusBall()
        }
        return LottoNumber.from(rawInput.toInt())
    }

    private fun validateNumber(input: String): Boolean = input.toIntOrNull() != null

    private fun validateLine(line: String): Boolean = line.matches(LINE_PATTERN)
}
