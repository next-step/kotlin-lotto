package calculator

object StringAddCalculator {

    private val customRegex = Regex("//(.)\n(.*)")
    private const val ZERO = 0

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return ZERO
        return calculateAdd(text)
    }

    private fun calculateAdd(text: String): Int {
        if (splitCustom(text).isEmpty()) {
            return splitDefault(text).sumOf { it.toPositiveIntOrException() }
        }
        return splitCustom(text).sumOf { it.toPositiveIntOrException() }
    }

    private fun String.toPositiveIntOrException(): Int {
        val toIntValue = toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력하세요.")
        if (toIntValue < ZERO) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
        return toIntValue
    }

    private fun splitDefault(text: String): List<String> {
        return text.trim().split(delimiters = Delimiter.valuesArray())
    }

    private fun splitCustom(text: String): List<String> {
        val matchResult = customRegex.find(text)
        return if (matchResult != null) {
            val (customDelimiter, tokens) = matchResult.destructured
            tokens.split(customDelimiter)
        } else {
            emptyList()
        }
    }
}
