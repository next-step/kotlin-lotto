package lotto.view.input.parser

import lotto.model.data.ParseResult
import lotto.util.parseToInt

open class IntInputParser(private val range: IntRange = Int.MIN_VALUE..Int.MAX_VALUE) : InputParser<Int> {

    override fun parseValue(inputString: String?): ParseResult<Int> =
        when (val parsedInputResult = inputString.parseToInt()) {
            is ParseResult.Error -> ParseResult.Error(ERROR_MESSAGE_NO_NUMBER)
            is ParseResult.Value -> parseValue(parsedInputResult)
        }

    private fun parseValue(parsedIntValue: ParseResult.Value<Int>): ParseResult<Int> =
        if (parsedIntValue.value in range) {
            parsedIntValue
        } else {
            ParseResult.Error(makeErrorMessage(range))
        }

    private fun makeErrorMessage(range: IntRange): String {
        return if (range.last == Int.MAX_VALUE) {
            "${range.first - 1} 보다 큰 값을 입력해 주세요. "
        } else {
            "${range.first} ~ ${range.last} 사이 값을 입력해 주세요."
        }
    }

    companion object {
        private const val ERROR_MESSAGE_NO_NUMBER = "숫자로 입력해 주세요."
    }
}
