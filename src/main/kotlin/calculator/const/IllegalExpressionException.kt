package calculator.const

import java.lang.RuntimeException

class IllegalExpressionException : RuntimeException() {
    override val message: String = ExceptionMessage.ILLEGAL_EXPRESSION_ERROR
}
