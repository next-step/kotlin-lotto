package calculator

object StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val expression = Expression(text)
        if (expression.isNumber()) {
            return expression.toInt()
        }

        TODO("Not yet implemented")
    }
}
