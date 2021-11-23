package calculator.domain

import calculator.parser.StringSplitModule

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrEmpty() || text.isNullOrBlank()) return 0

        return StringSplitModule
            .split(text)
            .sumOf { it }
    }
}
