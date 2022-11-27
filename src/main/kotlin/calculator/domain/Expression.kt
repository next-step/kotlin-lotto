package calculator.domain

class Expression(
    val value: String = DEFAULT_EXPRESSION_VALUE
) {

    companion object {
        private const val DEFAULT_EXPRESSION_VALUE = ""
    }

}