package calculator

class Number(private val text: String?) {
    var numbers = listOf(0)
        private set

    init {
        numbers = if (hasCustomDelimiter(text)) customNumbers()
        else defaultNumbers()
    }

    private fun hasCustomDelimiter(text: String?): Boolean {
        Regex(CUSTOM_PATTERN).find(text!!) ?: return false
        return true
    }

    private fun customNumbers(): List<Int> {
        val result = Regex(CUSTOM_PATTERN).find(text!!)
        var tokens = listOf<String>()

        result?.let {
            val customDelimiter = result.groupValues[1]
            tokens = result.groupValues[2].split(customDelimiter)
            checkNegative(tokens)
            checkIllegalLetter(tokens)
        }

        return tokens.map { it.toInt() }
    }

    private fun defaultNumbers(): List<Int> {
        val tokens = text!!.split(DELIMITER_COMMA, DELIMITER_COLON)
        checkNegative(tokens)
        checkIllegalLetter(tokens)

        return tokens.map { it.toInt() }
    }

    private fun checkNegative(tokens: List<String>) {
        tokens.forEach {
            if (0 > it.toInt()) throw RuntimeException(NOT_ALLOW_NEGATIVE)
        }
    }

    private fun checkIllegalLetter(tokens: List<String>) {
        tokens.forEach {
            if (Regex(EXCEPT_NUMBER_PATTERN).find(it) != null) throw RuntimeException(NOT_ALLOW_LETTER)
        }
    }

    companion object {
        const val DELIMITER_COMMA = ","
        const val DELIMITER_COLON = ":"
        const val CUSTOM_PATTERN = "//*\\\\n(.*)"
        const val EXCEPT_NUMBER_PATTERN = "[^0-9]+"
        const val NOT_ALLOW_LETTER = "구분자 자리 외 다른 문자 입력 불가"
        const val NOT_ALLOW_NEGATIVE = "음수 입력 불가"
    }
}
