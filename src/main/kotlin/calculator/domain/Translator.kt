package calculator.domain

import calculator.vo.Tokens

const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"
private val DEFAULT_DELIMITERS = listOf(",", ":")

class Translator {
    fun translate(input: String): Tokens {
        val parsedInput = translateWithCustom(input) ?: translateWithDefault(input)
        return Tokens.of(parsedInput)
    }

    private fun translateWithDefault(input: String) = input.split(*DEFAULT_DELIMITERS.toTypedArray())

    private fun translateWithCustom(input: String): List<String>? {
        val regexForCustomDelim = Regex(CUSTOM_DELIMITER_PATTERN).find(input)

        regexForCustomDelim?.let {
            val (customDelimiter, parsedInput) = it.destructured
            return parsedInput.split(customDelimiter)
        }

        return null
    }
}
