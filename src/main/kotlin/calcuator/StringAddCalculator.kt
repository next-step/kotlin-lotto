package calcuator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        val textOperands: List<String> = this.tokenizesText(text)

        return textOperands
            .mapNotNull { textOperand -> textOperand.toIntOrNull() }
            .map { number -> Operand(number) }
            .sumOf { operand -> operand.number }
    }

    private fun tokenizesText(text: String): List<String> {
        val matcher = CUSTOM_DELIMITER.find(text)

        if (matcher != null) {
            val (customDelimiter: String, matchedText: String) = matcher.destructured

            return matchedText.split(customDelimiter)
        }

        return text.split(DEFAULT_DELIMITER)
    }

    companion object {
        private val CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
        private val DEFAULT_DELIMITER = Regex("[,:]")
    }
}
