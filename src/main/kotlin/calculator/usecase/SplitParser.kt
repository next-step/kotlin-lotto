package calculator.usecase

import java.lang.RuntimeException

interface Parser {
    fun parse(str: String): List<Int>
}

class SplitParser : Parser {

    override fun parse(str: String): List<Int> {
        val inputs = CUSTOM_SEPARATOR_REGEX.find(str)?.let {
            parseByCustomSeparator(it)
        } ?: str.split(BASIC_SEPARATOR_REGEX)

        validateToken(inputs)

        return inputs.map { token ->
            token.toInt()
        }
    }

    private fun parseByCustomSeparator(matchResult: MatchResult): List<String>? {
        matchResult.let {
            val customDelimiter = it.groupValues[CUSTOM_DELIMITER_INDEX]
            return it.groupValues[CONTENT_INDEX].split(customDelimiter)
        }
    }

    private fun validateToken(tokens: List<String>) {
        tokens.forEach { token ->
            val number = token.toIntOrNull() ?: throw IllegalArgumentException("숫자를 제외한 문자가 올 수 없습니다.")

            if (number < 0) {
                throw IllegalArgumentException("입력값은 음수가 올 수 없습니다.")
            }
        }
    }

    companion object {
        private val BASIC_SEPARATOR_REGEX = Regex("""[,:]""")
        private val CUSTOM_SEPARATOR_REGEX = Regex("""//(.)\\n(.*)""")
        private const val CUSTOM_DELIMITER_INDEX = 1
        private const val CONTENT_INDEX = 2
    }
}
