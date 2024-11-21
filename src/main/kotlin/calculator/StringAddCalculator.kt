package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        val customDelimiter = getCustomDelimiterOrNull(text)
        return when {
            customDelimiter != null && !text.isNullOrEmpty() -> {
                val endIndex = text.indexOf(CUSTOM_DELIMITER_SUFFIX)
                val suffixLength = CUSTOM_DELIMITER_SUFFIX.length
                text.substring(endIndex + suffixLength)
                    .splitByDelimitersAndSum(",", ":", customDelimiter = customDelimiter)
            }
            !text.isNullOrEmpty() -> text.splitByDelimitersAndSum(",", ":")
            else -> 0
        }
    }

    private fun getCustomDelimiterOrNull(text: String?): String? {
        val customDelimiterStartIndex = text?.indexOf(CUSTOM_DELIMITER_PREFIX) ?: return null
        return if (customDelimiterStartIndex >= 0) {
            val endIdx = text.indexOf(CUSTOM_DELIMITER_SUFFIX)
            if (endIdx >= 0) {
                val startIdx = customDelimiterStartIndex + CUSTOM_DELIMITER_PREFIX.length
                text.substring(startIdx, endIdx)
            } else {
                null
            }
        } else {
            null
        }
    }

    private fun String.splitByDelimitersAndSum(
        vararg defaultDelimiters: String,
        customDelimiter: String? = null,
    ): Int {
        val delimiters =
            combineWithCustomDelimiter(
                defaultDelimiters = defaultDelimiters,
                customDelimiter = customDelimiter,
            )
        return split(*delimiters).sumOf(::parseValidatedInt)
    }

    private fun combineWithCustomDelimiter(
        vararg defaultDelimiters: String,
        customDelimiter: String?,
    ): Array<out String> {
        return if (!customDelimiter.isNullOrEmpty()) {
            mutableListOf(*defaultDelimiters).apply {
                add(customDelimiter)
            }.toTypedArray()
        } else {
            defaultDelimiters
        }
    }

    private fun parseValidatedInt(text: String): Int {
        val number = text.toIntOrNull() ?: -1
        validateNonNegative(number)
        return number
    }

    private fun validateNonNegative(number: Int) {
        if (number < 0) {
            throw RuntimeException("음수는 계산할 수 없습니다.")
        }
    }

    companion object {
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\n"
    }
}
