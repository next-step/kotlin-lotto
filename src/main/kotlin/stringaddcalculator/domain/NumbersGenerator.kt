package stringaddcalculator.domain

import java.util.regex.Matcher
import java.util.regex.Pattern

class NumbersGenerator {

    fun generate(input: String): Numbers {
        if (input.length == 1) {
            return Numbers(listOf(Number.of(input)))
        }
        val matcher = CUSTOM_DELIMITER_PATTERN.matcher(input)
        if (matcher.find()) {
            return byCustomDelimiters(matcher)
        }
        return byDefaultDelimiters(input)
    }

    private fun byCustomDelimiters(matcher: Matcher): Numbers {
        val customDelimiter = matcher.group(1)
        return matcher.group(2).split(customDelimiter)
            .map { it.trim() }
            .map { Number.of(it) }
            .let { Numbers(it) }
    }

    private fun byDefaultDelimiters(input: String) = input.split(DEFAULT_DELIMITER_REGEX)
        .map { it.trim() }
        .map { Number.of(it) }
        .let { Numbers(it) }

    companion object {
        private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()
        private val CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)")
    }
}
