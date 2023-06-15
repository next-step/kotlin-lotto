package step1

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }
        val numbers = split(text).map { it.toInt() }
        validate(numbers)

        return numbers.sum()
    }

    private fun split(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }

        return text.split(",", ":")
    }

    private fun validate(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException()
        }
    }
}
