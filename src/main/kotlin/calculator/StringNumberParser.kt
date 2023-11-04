package calculator

class StringNumberParser {
    fun getCustomSeparator(input: String): String? {
        return Regex(CUSTOM_SEPARATOR_PATTERN).find(input)
            ?.groupValues
            ?.get(1)
    }

    companion object {
        private const val CUSTOM_SEPARATOR_PATTERN= """^//(.)\\n(.*)$"""
    }
}

