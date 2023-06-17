package step1

class StringAddCalculator {
    fun add(addableText: String?): Int {
        if (addableText.isNullOrEmpty()) {
            return 0
        }
        val numbers = split(addableText).map { it.toInt() }
        validate(numbers)

        return numbers.sum()
    }

    private fun split(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val (customDelimiter, tokens) = it.groupValues
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
