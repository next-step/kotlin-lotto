package lotto.model

import java.lang.NumberFormatException

class BonusNumber(input: String) {
    val number = generateBonusNumber(input)

    private fun generateBonusNumber(input: String): Int {
        checkValidNumber(input)
        return input.toInt()
    }

    private fun checkValidNumber(input: String) {
        try {
            input.toInt()
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력 가능합니다.")
        }
    }
}
