package calculator

import calculator.StringSplitter.split

class StringAddCalculator {
    fun add(text: String?): Long {
        if (text.isNullOrBlank()) return 0
        val numbers = split(text).map { it.toLongOrNull() ?: throw IllegalArgumentException() }
        if (numbers.any { it < 0 }) throw RuntimeException()
        return numbers.sum()
    }
}
