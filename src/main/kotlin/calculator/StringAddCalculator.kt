package calculator

class StringAddCalculator(
    private val stringSeparator: Separator = StringSeparator()
) {
    private var nums = listOf<Int>()
        private set(value) {
            validateNumbers(value)
            field = value
        }

    fun add(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }
        nums = parseNumbers(expression)
        return nums.sum()
    }

    private fun parseNumbers(expression: String): List<Int> {
        if (isInteger(expression)) {
            return listOf(expression.toInt())
        }

        return stringSeparator.separate(expression)
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException("음수가 존재합니다.")
        }
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