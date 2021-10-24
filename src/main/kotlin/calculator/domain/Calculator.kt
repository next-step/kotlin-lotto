package calculator.domain

class Calculator(
    private val input: String? = null,
) {
    fun add(): Int {
        val expressions = Expression.from(input)
        return convertNumbers(expressions)
            .sumOf { it.toInt() }
    }

    private fun convertNumbers(expressions: List<String>): List<Number> {
        return expressions.map { Number(it) }
            .toList()
    }
}
