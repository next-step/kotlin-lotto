package calculator.application.parser

import calculator.common.model.PositiveInteger

interface Parser {
    fun parseToPositiveIntegerList(inputString: String): List<PositiveInteger>
}
