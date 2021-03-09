package calculator.domain

class CustomReadStrategy() : StringReadStrategy {
    override fun readString(string: String): List<String> {
        val separator = getCustomSeparator(string)
        val stringWithOutCustomSeparator = getStringWithOutCustomSeparator(string)

        return stringWithOutCustomSeparator.split(separator!!)
    }

    private fun getCustomSeparator(string: String): String? {
        val regexResult = CUSTOM_SEPARATOR_REGEX.find(string)
        return regexResult?.let { it.groupValues[1] }
    }

    private fun getStringWithOutCustomSeparator(string: String): String {
        val regexResult = CUSTOM_SEPARATOR_REGEX.find(string)
        return regexResult!!.groupValues[2]
    }

    companion object {
        private val CUSTOM_SEPARATOR_REGEX: Regex = Regex("""//(.)\\n(.*)""")
    }
}
