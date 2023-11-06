package me.parker.nextstep.kotlinlotto.calculator

object StringCalculator {

    private const val DEFAULT_SEPARATOR_COMMA = ","
    private const val DEFAULT_SEPARATOR_COLON = ":"

    private const val CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)"

    fun add(input: String): Int {
        val matchedResult = Regex(CUSTOM_SEPARATOR_REGEX).find(input)
        val customSeparator = matchedResult?.groupValues?.get(1)
        val textAfterNewline = matchedResult?.groupValues?.get(2)

        if (!customSeparator.isNullOrEmpty() && !textAfterNewline.isNullOrEmpty()) {
            return textAfterNewline.split(DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON, customSeparator)
                .sumOf { it.toInt() }
        }

        return input.split(DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON)
            .sumOf { it.toInt() }
    }
}
