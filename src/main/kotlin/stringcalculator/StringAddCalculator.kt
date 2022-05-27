package stringcalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return ZERO
        }

        return CustomSplitter.splitStrings(text)
            .ifEmpty { DefaultSplitter.splitStrings(text) }
            .map(::PositiveNumber)
            .map { it.value() }
            .reduce { a, b -> a + b }
    }

    companion object {
        private const val ZERO = 0
    }
}
