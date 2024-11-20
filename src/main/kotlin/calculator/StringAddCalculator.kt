package calculator

object StringAddCalculator {

    private val DEFAULT_SEPARATOR = listOf(
        ",",
        ":",
    )

    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0
        return expression
            .parse(DEFAULT_SEPARATOR)
            .validate()
            .calculate()
    }

    private fun String.parse(separator: List<String>): List<Int> {
        return this.split(*separator.toTypedArray()).map { it.toInt() }
    }

    private fun List<Int>.validate(): List<Int> {
        this.forEach { if (it < 0) throw RuntimeException("음수값을 포함 할 수 없습니다") }
        return this
    }

    private fun List<Int>.calculate(): Int {
        return this.sum()
    }

}
