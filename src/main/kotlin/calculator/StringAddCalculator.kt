package calculator

object StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val addExpression = AddExpression(text)
        return addExpression.sum()
    }
}
