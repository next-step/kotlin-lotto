package calculator.utils

object RegexPattern {
    val customDelimiterPattern = Regex("//(.)\n(.*)")
}

fun String.findByPattern(): MatchResult? = RegexPattern.customDelimiterPattern.find(this)
