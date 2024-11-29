package stringadd

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return RESULT_ON_ERROR
        val inputs =
            parseInputs(text).map {
                val num = it.trim().toIntOrNull() ?: RESULT_ON_ERROR
                if (num < 0) throw RuntimeException("숫자는 음수일 수 없습니다")
                num
            }
        return addByInputSize(inputs)
    }

    private fun parseInputs(text: String): List<String> {
        val delimiters = mutableListOf(DELIMITER_COLON, DELIMITER_COMMA) // default delimiters
        val splitTarget =
            if (text.startsWith(CUSTOM_DELIMITER_PREFIX)) {
                val delimiterAndInput = splitDelimiterAndInput(text)
                val customDelimiter = parseCustomDelimiter(delimiterAndInput[0])
                delimiters.add(customDelimiter)
                delimiterAndInput[1]
            } else {
                text
            }
        return splitTarget.split(delimiters = delimiters.toTypedArray())
    }

    private fun splitDelimiterAndInput(text: String): List<String> {
        val splitText = text.split("\n")
        require(splitText.size == 2) {
            "$CUSTOM_DELIMITER_PREFIX 와 New line 사이에 커스텀 delimiter 를 추가 하십쇼"
        }
        return splitText
    }

    private fun parseCustomDelimiter(input: String): String {
        return input.takeIf { it.startsWith(CUSTOM_DELIMITER_PREFIX) }
            ?.removePrefix(CUSTOM_DELIMITER_PREFIX)
            .orEmpty()
    }

    private fun addByInputSize(inputs: List<Int>): Int {
        require(inputs.isNotEmpty())
        return inputs.sum()
    }

    companion object {
        private const val RESULT_ON_ERROR = 0
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val CUSTOM_DELIMITER_PREFIX = "//"
    }
}
