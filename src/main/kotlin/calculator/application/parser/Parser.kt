package calculator.application.parser

import calculator.application.model.PositiveInteger

interface Parser {
    fun parse(inputString: String): List<PositiveInteger>
}
