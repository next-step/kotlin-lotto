package calcaulator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        return text.toNumberTokenList()
            .reduce { a, b -> a + b }
    }

    private fun String.toNumberTokenList() = CalculatorInput(this, Regex(DEFAULT_DELIMITER))
        .toNumberTokenList()

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
    }
}
