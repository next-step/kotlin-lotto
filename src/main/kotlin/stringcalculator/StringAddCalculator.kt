package stringcalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return ZERO
        }

        return text.split(DEFAULT_SPLITTER)
            .map { it.toInt() }
            .reduce { a, b -> a + b }
    }

    companion object {
        private const val ZERO = 0
        private const val DEFAULT_SPLITTER = ","
    }
}
