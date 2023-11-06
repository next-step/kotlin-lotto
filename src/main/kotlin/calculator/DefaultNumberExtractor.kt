package calculator

class DefaultNumberExtractor(
    expression: String,
) : NumberExtractor(expression) {

    override fun extractNumbers(): List<Int> {
        return expression.split(defaultDelimiters).map { NonNegativeNumber(it).value }
    }
}
