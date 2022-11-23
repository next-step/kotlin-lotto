package calculator.application.parser.impl

import calculator.application.parser.Parser
import calculator.application.parser.model.CustomDelimiter
import calculator.application.parser.model.Delimiter
import calculator.application.parser.model.DelimiterEnum
import calculator.common.model.PositiveInteger

object DelimiterParser : Parser {

    private const val CUSTOM_DELIMITER_PREFIX = "//"
    private const val CUSTOM_DELIMITER_SUFFIX = "\n"
    private const val REGEX_PATTERN = "$CUSTOM_DELIMITER_PREFIX(.*)$CUSTOM_DELIMITER_SUFFIX(.*)"
    private const val EMPTY_STRING = ""

    override fun parseToPositiveIntegerList(inputString: String): List<PositiveInteger> {
        var input = inputString
        var delimiters = DelimiterEnum.valuesStringArray()

        if (hasCustomDelimiter(input)) {
            val customDelimiter = findCustomDelimiters(input)
            input = cleanDelimiter(input, customDelimiter.value)
            delimiters = delimiters.plus(customDelimiter.value)
        }

        val numberArray = input.split(*delimiters)
        return numberArray.map { it.toPositiveInteger() }.toList()
    }

    private fun hasCustomDelimiter(inputString: String) = Regex(REGEX_PATTERN).find(inputString) != null

    private fun findCustomDelimiters(inputString: String): Delimiter {
        val delimiter = Regex(REGEX_PATTERN).find(inputString)?.groupValues?.get(1) ?: throw RuntimeException("")
        return CustomDelimiter(delimiter)
    }

    private fun cleanDelimiter(inputString: String, customDelimiterValue: String) = inputString
        .replace("$CUSTOM_DELIMITER_PREFIX${customDelimiterValue}$CUSTOM_DELIMITER_SUFFIX", EMPTY_STRING)

    private fun String.toPositiveInteger(): PositiveInteger =
        try {
            val number = this.toInt()
            PositiveInteger(number)
        } catch (e: NumberFormatException) {
            throw ParsingException("숫자만 입력을 할 수 있습니다.")
        } catch (e: IllegalArgumentException) {
            throw ParsingException("0과 같거나 큰 숫자만 가능합니다")
        }
}

data class ParsingException(
    override val message: String
) : RuntimeException()
