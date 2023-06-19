package lotto

class StringAddCalculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrEmpty()) {
            return 0
        }
        val numbers = split(expression).map { it.toInt() }
        validate(numbers)

        return numbers.sum()
    }

    private fun split(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val (_, customDelimiter, tokens) = it.groupValues
            return tokens.split(customDelimiter)
        }

        return text.split(DEFAULT_DELIMITERS)
    }

    private fun validate(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException()
        }
    }

    companion object {
        private val DEFAULT_DELIMITERS = Regex("[,:]")
    }
}
