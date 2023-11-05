package calculator

import calculator.NumberExtractor.extract

object StringAddCalculator {
    private const val RETURN_VALUE = 0

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return RETURN_VALUE
        }

        val tokens = extract(text)
        return tokens.sum()
    }
}
