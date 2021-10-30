package calculator

object StringAddCalculator {
    fun add(text: String?) =
        Expression.make(text)
            .value
            .map { Number.make(it).value }
            .reduce { acc, i -> acc + i }
}
