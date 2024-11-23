package calculator

import calculator.StringSplitter.splitByComma

class StringAddCalculator {
    fun add(text: String?): Long {
        if (text.isNullOrBlank()) return 0
        return splitByComma(text).sumOf { it.toLong() }
    }
}
