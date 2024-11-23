package calculator

import calculator.StringSplitter.splitByCommaAndColon

class StringAddCalculator {
    fun add(text: String?): Long {
        if (text.isNullOrBlank()) return 0
        return splitByCommaAndColon(text).sumOf { it.toLong() }
    }
}
