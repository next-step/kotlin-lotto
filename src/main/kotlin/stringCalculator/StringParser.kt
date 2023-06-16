package stringCalculator

class StringParser {
    fun parse(inputString: String): List<String> {

        val customSeparator = checkCustomSeparator(inputString)
            ?: return inputString.split(":", ",")

        return inputString.replace("//$customSeparator\n", "").split(":", ",", customSeparator)
    }

    private fun checkCustomSeparator(inputString: String): String? {
        val pattern = Regex(CUSTOM_SEPARATOR_PATTERN)
        val matchResult = pattern.find(inputString)
        return matchResult?.groupValues?.get(1)
    }

    companion object {
        const val CUSTOM_SEPARATOR_PATTERN = """//(.*)\n"""
    }
}