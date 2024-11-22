package stringcalculator

object TokenSplitter {
    private const val COMMA = ","
    private const val COLON = ":"
    private const val CUSTOM_SEPARATOR_START_SYMBOL = "//"
    private const val CUSTOM_SEPARATOR_END_SYMBOL = "\n"
    private const val CUSTOM_SEPARATOR_INDEX = 1

    fun splitExpBySeparator(exp: String): List<String> {
        return if (hasCustomSeparator(exp)) {
            val customSeparator = getCustomSeparator(exp)
            exp.substringAfter(CUSTOM_SEPARATOR_END_SYMBOL).split(customSeparator)
        } else {
            exp.split(COMMA, COLON)
        }
    }

    private fun getCustomSeparator(exp: String): String {
        validateContainsSymbols(exp)
        return exp.split(CUSTOM_SEPARATOR_START_SYMBOL, CUSTOM_SEPARATOR_END_SYMBOL)
            .getOrNull(CUSTOM_SEPARATOR_INDEX)
            ?.takeIf { it.isNotBlank() }
            ?: throw RuntimeException("전달된 구분자가 존재하지 않습니다.")
    }

    private fun validateContainsSymbols(exp: String) {
        if (!exp.contains(CUSTOM_SEPARATOR_START_SYMBOL) || !exp.contains(CUSTOM_SEPARATOR_END_SYMBOL)) {
            throw RuntimeException("{$exp}는 커스텀 구분자를 포함한 문자열 형태가 아닙니다.")
        }
    }

    private fun hasCustomSeparator(exp: String) = exp.startsWith(CUSTOM_SEPARATOR_START_SYMBOL)
}
