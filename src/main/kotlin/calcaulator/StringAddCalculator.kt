package calcaulator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        return text.toNumberTokenList()
            .reduce { a, b -> a + b }
    }

    companion object {
        private val REGEX_CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
        private const val DEFAULT_DELIMITER = ",|:"

        private fun String.toCalculatorInput(): CalculatorInput {
            val findResult = REGEX_CUSTOM_DELIMITER.find(this)
            val numberInputString = findResult?.groupValues?.get(2) ?: this
            val delimiter = findResult?.groupValues?.get(1) ?: DEFAULT_DELIMITER
            return CalculatorInput(numberInputString, Regex(delimiter))
        }

        private fun String.toNumberTokenList() =
            this.toCalculatorInput().toNumberTokenList()
    }
}
