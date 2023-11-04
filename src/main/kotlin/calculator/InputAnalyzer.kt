package calculator

class InputAnalyzer(private var inputString: String) {
    private val delimiters: MutableList<String> = DEFAULT_DELIMITER.toMutableList()

    init {
        extractCustomDelimiter()
    }
    
    private fun extractCustomDelimiter() {
        val delimiterMatch = CUSTOM_DELIMITER_PATTERN.find(inputString)

        delimiterMatch?.let {
            delimiters.add(it.groupValues[1])
            this.inputString = it.groupValues[2]
        }
    }

    fun extractNumbers(): List<Int> {
        return inputString.split(*delimiters.toTypedArray())
            .map { it.toInt() }
    }

    companion object {
        private val DEFAULT_DELIMITER = listOf(",", ":")
        private val CUSTOM_DELIMITER_PATTERN = Regex("""//(.*)\\n(.*)""")
    }
}
