package me.parker.nextstep.kotlinlotto.calculator

object StringCalculator {

    private const val DEFAULT_SEPARATOR_COMMA = ","
    private const val DEFAULT_SEPARATOR_COLON = ":"

    private val CUSTOM_SEPARATOR_REGEX = Regex("//(.)\n(.*)")

    fun add(input: String): Int {
        if (input.isEmpty()) return 0

        val matchedResult = CUSTOM_SEPARATOR_REGEX.find(input)
        val customSeparator = matchedResult?.groupValues?.get(1)
        val textAfterNewline = matchedResult?.groupValues?.get(2)

        if (customSeparator.isNotNullOrEmpty() && textAfterNewline.isNotNullOrEmpty()) {
            return add(
                textAfterNewline!!,
                DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON,
                customSeparator!!
            )
        }

        return add(input, DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON)
    }

    private fun String?.isNotNullOrEmpty(): Boolean {
        return !this.isNullOrEmpty()
    }

    private fun add(formula: String, vararg separators: String) =
        formula.split(*separators).sumOf { OperandNumber(it).value }
}
