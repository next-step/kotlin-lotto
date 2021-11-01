package calculator

import calculator.utils.StringUtil

@JvmInline
value class StringAddCalculator(private val text: String) {

    fun add(): Int = when (text.isNotBlank()) {
        true -> StringUtil.convertTexts(text).sumOf { it.toInt() }
        false -> ZERO
    }

    companion object {
        private const val ZERO = 0
    }
}
