package calculator

class StringAddCalculator {
    fun calculate(text: String?): Int {
        val elements = StringAddCalculatorParser.parse(text)

        if (elements.isEmpty()) {
            return NULL_OR_BLANK_RETURN_VALUE
        }

        return elements.sumOf { it.number }
    }

    companion object {
        private const val NULL_OR_BLANK_RETURN_VALUE = 0
    }
}
