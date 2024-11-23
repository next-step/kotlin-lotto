package calculator

import calculator.StringSplitter.split

class StringAddCalculator {
    fun add(text: String?): Long {
        if (text.isNullOrBlank()) return 0
        return split(text).sumOf { it.toLong() }
    }
}
