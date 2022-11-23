package calculator.application.parser.impl

import calculator.application.parser.Parser
import calculator.application.parser.model.CustomDelimiter
import calculator.application.parser.model.DelimiterEnum
import calculator.common.model.PositiveInteger

object DelimiterParser : Parser {

    override fun parseToPositiveIntegerList(inputString: String): List<PositiveInteger> {
        var input = inputString
        var delimiters = DelimiterEnum.valuesStringArray()

        if (CustomDelimiter.hasCustomDelimiter(input)) {
            val customDelimiter = CustomDelimiter.findCustomDelimiters(input)
            input = CustomDelimiter.cleanDelimiter(input, customDelimiter.value)
            delimiters = delimiters.plus(customDelimiter.value)
        }

        val numberArray = input.split(*delimiters)
        return numberArray.map { it.toPositiveInteger() }.toList()
    }

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
