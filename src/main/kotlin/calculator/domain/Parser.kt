package calculator.domain

import calculator.vo.IntNumber
import calculator.vo.Numbers

object Parser {

    fun parse(expression: String): Numbers =
        Numbers(expression.split(",", ":").map(String::trim).map(IntNumber::fromString))
}
