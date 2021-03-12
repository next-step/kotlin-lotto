package calculator.domain

import calculator.vo.DEFAULT_TOKEN_VALUE

object Checker {
    fun parseInteger(str: String): Int {
        if (str.isBlank()) return DEFAULT_TOKEN_VALUE

        try {
            return str.toInt()
        } catch (e: NumberFormatException) {
            throw RuntimeException("잘못된 구분자를 입력하셨습니다. Input tokens = [$str]")
        }
    }
}
