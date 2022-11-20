package calculator.application.parser.impl

import calculator.application.parser.Parser
import calculator.application.parser.model.Delimiter
import calculator.common.model.PositiveInteger

object DelimiterParser : Parser {
    override fun parse(inputString: String): List<PositiveInteger> {
        val delimiters = Delimiter.valuesStringArray()
        val delimiterArray = inputString.split(*delimiters)
        return delimiterArray.map { it.toPositiveInteger() }.toList()
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
