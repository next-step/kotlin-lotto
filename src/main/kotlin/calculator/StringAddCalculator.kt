package calculator

object StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = parseToNumbers(text)
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수가 전달되어서는 안됩니다.")
        }
        return numbers.sum()
    }

    private fun parseToNumbers(text: String): List<Int> {
        return text.substringAfter("\n")
            .split(*getDelimiters(text).toTypedArray())
            .map { it.toInt() }
    }

    private fun getDelimiters(text: String): List<String> {
        return if (text.startsWith("//")) {
            listOf(",", ":", text.substringAfter("//").substringBefore("\n"))
        } else {
            listOf(",", ":")
        }
    }
}
