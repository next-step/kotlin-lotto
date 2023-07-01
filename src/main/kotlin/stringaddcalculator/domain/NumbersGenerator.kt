package stringaddcalculator.domain

import java.util.regex.Matcher
import java.util.regex.Pattern

class NumbersGenerator(private val input: String) {

    fun generate(): Numbers {
        val matcher = CUSTOM_DELIMITER_PATTERN.matcher(input)
        if (matcher.find()) {
            return byCustomDelimiters(matcher)
        }
        return byDefaultDelimiters()
    }

    private fun byCustomDelimiters(matcher: Matcher): Numbers {
        val customDelimiter = matcher.group(1)
        return matcher.group(2).split(customDelimiter)
            .map { it.trim() }
            .map { Number.of(it) }
            .let { Numbers(it) }
    }

    private fun byDefaultDelimiters() = input.split(DEFAULT_DELIMITER_REGEX)
        .map { it.trim() }
        .map { Number.of(it) }
        .let { Numbers(it) }

    companion object {
        private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()
        private val CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)")
    }
}
