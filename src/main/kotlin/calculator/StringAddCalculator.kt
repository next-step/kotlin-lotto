package calculator

import calculator.utils.StringUtil

@JvmInline
value class StringAddCalculator(private val text: String) {

    fun add(): Int = when (text.isNotBlank()) {
        true -> toInts(StringUtil.convertTexts(text)).sumOf { it }.toInt()
        false -> ZERO
    }

    private fun toInts(convertTexts: List<String>): List<UInt> = convertTexts.map {
        it.toUInt()
    }

    companion object {
        private const val ZERO = 0
    }
}
