package stringadd

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        val inputs: List<Int> = parseInputs(text).map { it.trim().toIntOrNull() ?: 0 }
        return addByInputSize(inputs)
    }

    private fun parseInputs(text: String): List<String> {
        val delimiters = mutableListOf(",", ":") // default delimiters
        val splitTarget =
            if (text.startsWith(CUSTOM_DELIMITER_PREFIX)) {
                val delimiterAndInput = text.split("\n")
                require(delimiterAndInput.size == 2) {
                    "$CUSTOM_DELIMITER_PREFIX 와 New line 사이에 커스텀 delimiter 를 추가 하십쇼"
                }
                val customDelimiter = parseCustomDelimiter(delimiterAndInput[0])
                delimiters.add(customDelimiter)
                delimiterAndInput[1]
            } else {
                text
            }
        return splitTarget.split(delimiters = delimiters.toTypedArray())
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
        private const val CUSTOM_DELIMITER_PREFIX = "//"
    }
}
