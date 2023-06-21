package calculator

class StringAddCalculator(
    private val stringSeparator: Separator = StringSeparator()
) {
    fun add(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }
        return getNumbers(expression).sum()
    }

    private fun getNumbers(expression: String): Numbers {
        if (isInteger(expression)) {
            return Numbers(listOf(expression.toInt()))
        }
        return Numbers(stringSeparator.separate(expression))
    }

    private fun isInteger(expression: String): Boolean {
        return runCatching {
            expression.toInt()
            true
        }.getOrElse {
            false
        }
    }
}