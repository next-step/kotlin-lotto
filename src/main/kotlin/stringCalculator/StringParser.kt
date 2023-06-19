package stringCalculator

class StringParser {
    fun parse(inputString: String): List<String> {

        val customSeparator = findCustomSeparator(inputString)
            ?: return inputString.split(*DEFAULT_SEPARATOR)

        return inputString.replace("//$customSeparator\n", "")
            .split(*DEFAULT_SEPARATOR, customSeparator)
    }

    private fun findCustomSeparator(inputString: String): String? {
        val pattern = CUSTOM_SEPARATOR_PATTERN
        val matchResult = pattern.find(inputString)
            ?: return null

        return matchResult.groupValues[1]
    }

    companion object {
        private val CUSTOM_SEPARATOR_PATTERN = """//(.*)\n""".toRegex()
        private val DEFAULT_SEPARATOR = arrayOf(":", ",")
    }
}