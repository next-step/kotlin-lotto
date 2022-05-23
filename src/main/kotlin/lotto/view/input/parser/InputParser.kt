package lotto.view.input.parser

import lotto.model.data.ParseResult

interface InputParser<T> {
    fun parseValue(inputString: String?): ParseResult<T>
}
