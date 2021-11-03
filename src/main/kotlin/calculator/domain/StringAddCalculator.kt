package calculator.domain

import calculator.parser.StringSplitModule

class StringAddCalculator(
    private val stringSplitModule: StringSplitModule = StringSplitModule()
) {

    fun add(text: String?): Int {
        if (text.isNullOrEmpty() || text.isNullOrBlank()) return 0

        return stringSplitModule.split(text).sumOf { it }
    }
}
