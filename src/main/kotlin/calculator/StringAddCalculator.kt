package calculator

object StringAddCalculator {

    private val DEFAULT_SEPARATOR = listOf(
        ",",
        ":",
    )

    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0
        return expression.parse(DEFAULT_SEPARATOR).calculate()
    }

    private fun String.parse(separator: List<String>): List<Int> {
        return this.split(*separator.toTypedArray()).map { it.toInt() }
    }

    private fun List<Int>.calculate(): Int {
        return this.sum()
    }

}
