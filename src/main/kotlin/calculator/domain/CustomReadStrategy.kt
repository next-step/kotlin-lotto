package calculator.domain

import calculator.interfaces.StringReadStrategy

class CustomReadStrategy() : StringReadStrategy {
    override fun readString(string: String): List<String> {
        val separator = getCustomSeparator(string)
        val stringWithOutCustomSeparator = getStringWithOutCustomSeparator(string)

        return stringWithOutCustomSeparator.split(separator!!)
    }

    private fun getCustomSeparator(string: String): String? {
        val regexResult = Regex("//(.)\n(.*)").find(string)
        return regexResult?.let { it.groupValues[1] }
    }

    private fun getStringWithOutCustomSeparator(string: String): String {
        val regexResult = Regex("//(.)\n(.*)").find(string)
        return regexResult!!.groupValues[2]
    }
}
