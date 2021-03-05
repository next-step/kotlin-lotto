package stringaddcalculator.domain

import java.lang.RuntimeException

class Calculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        if (text.length < 2) text.toInt()
        if (text.toInt() < 0) throw RuntimeException("$text is negative")

        val result: MatchResult? = Regex("//(.)\n(.*)").find(text)

        return result?.let {
            val customDelimiter: String = it.groupValues[1]
            val tokens: List<String> = it.groupValues[2].split(customDelimiter)
            tokens.sumBy(String::toInt)
        } ?: run {
            text.split(",", ":").sumBy(String::toInt)
        }
    }
}
