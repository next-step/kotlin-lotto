package stringcalculator

class StringParser() {
    fun deleteCustomDelimiters(text: String): String {
        val result = Regex(Delimiters.CUSTOM_DELIMITER_FIND_REGEX).find(text)
        result?.let {
            return it.groupValues[2]
        }
        return text
    }
}
