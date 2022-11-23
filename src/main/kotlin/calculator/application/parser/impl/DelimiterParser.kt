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
        return numberArray.map { PositiveInteger.parsing(it) }.toList()
    }
}

data class ParsingException(
    override val message: String
) : RuntimeException()
