package string.splitter

import string.converter.ExpressionTokenConverter

class RegexBasedCustomSeparatorStringSplitter(
    private val converter: ExpressionTokenConverter,
) : SeparatorStringSplitter {
    override fun split(input: String): List<Int>? {
        val separator = extractCustomSeparator(input) ?: return null
        val indicatorSequence = "//${separator}\n"
        validateIndicatorLocation(input, indicatorSequence)
        val indicatorRemovedString = removeCustomSeparatorIndicator(input, indicatorSequence)
        return indicatorRemovedString.split(separator).map { converter.convert(it) }
    }

    private fun extractCustomSeparator(input: String): String? {
        return separatorRegex.find(input)?.value
    }

    private fun validateIndicatorLocation(input: String, indicatorSequence: String) {
        if (!input.startsWith(indicatorSequence)) {
            throw RuntimeException("올바르지 않은 커스텀 구분자 코드 포함식입니다")
        }
    }

    private fun removeCustomSeparatorIndicator(input: String, indicator: String): String {
        return input.replace(indicator, "")
    }

    companion object {
        val separatorRegex = Regex("(?<=//).")
    }
}
