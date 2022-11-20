package calculator.application.parser

import calculator.common.model.PositiveInteger

interface Parser {
    fun parse(inputString: String): List<PositiveInteger>
}
