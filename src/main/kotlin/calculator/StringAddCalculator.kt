package calculator

private const val COMMA_DELIMITER = ","

private const val COLON_DELIMITER = ":"

private const val CUSTOM_START_WITH_MARKER = "//"

private const val CUSTOM_END_WITH_MARKER = "\n"

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = extractDelimiters(text)
        return numbers.sumOf { it.toIntOrThrowIfInvalid() }
    }

    private fun extractDelimiters(text: String): List<String> {
        return if (isCustomDelimiter(text)) {
            val remainderText = text.substringAfter(CUSTOM_END_WITH_MARKER)
            val customDelimiters = parseCustomDelimiter(text)
            remainderText.split(customDelimiters)
        } else {
            text.split(COMMA_DELIMITER, COLON_DELIMITER)
        }
    }

    private fun isCustomDelimiter(input: String): Boolean {
        return input.startsWith(CUSTOM_START_WITH_MARKER)
    }

    private fun parseCustomDelimiter(input: String): String {
        return input.substringAfter(CUSTOM_START_WITH_MARKER).substringBefore(CUSTOM_END_WITH_MARKER)
    }

    private fun String.toIntOrThrowIfInvalid(): Int {
        return this.toIntOrNull()?.also {
            if (it < 0) throw RuntimeException("음수를 입력할 수 없습니다 : $this")
        } ?: throw RuntimeException("잘못된 입력값입니다 : $this")
    }
}
