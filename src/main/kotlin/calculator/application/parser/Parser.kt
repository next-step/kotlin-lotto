package calculator.application.parser

import calculator.common.PositiveInteger

interface Parser {
    fun parse(inputString: String): List<PositiveInteger>
}
