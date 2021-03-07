package calculator

class CustomReadStrategy() : StringReadStrategy {
    override fun readString(string: String): List<String> {
        val separator = getCustomSeparator(string)
        val stringWithOutCustomSeparator = getStringWithOutCustomSeparator(string)

        return stringWithOutCustomSeparator.split(separator)
    }

    private fun getCustomSeparator(string: String): String {
        val regexResult = Regex("//(.)\n(.*)").find(string)
        return regexResult!!.groupValues[1]
    }

    private fun getStringWithOutCustomSeparator(string: String): String {
        val regexResult = Regex("//(.)\n(.*)").find(string)
        return regexResult!!.groupValues[2]
    }
}
