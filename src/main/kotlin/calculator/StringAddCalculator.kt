package calculator

import java.lang.RuntimeException

val delimiters = mutableListOf(",", ":")
val customDelimiterPattern = Regex("(\\/\\/(.)\\\\n)(.*)")

class StringAddCalculator {
    fun add(text: String): Int {
        if (text.isEmpty()) return 0
        if (text.length == 1) return text.toInt()
        return divideTargetTextAndDelimiter(text).split(*delimiters.toTypedArray())
            .map {
                val number = it.toInt()
                isNegativeCheck(number)
                number
            }.sum()
    }

    private fun isNegativeCheck(number: Int) {
        if (number < 0) throw RuntimeException()
    }

    private fun divideTargetTextAndDelimiter(text: String): String {
        return customDelimiterPattern.find(text)?.let {
            delimiters.add(it.groupValues[2])
            text.replace(it.groupValues[1], "")
        } ?: text
    }
}
