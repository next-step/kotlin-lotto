package calculator.utils

object Separator {

    private val REGEX_FOR_SEPARATOR_EXTRACTION = Regex("(?<=//)(.*?)(?=\n)")

    fun findSeparatorInString(str: String) =
        REGEX_FOR_SEPARATOR_EXTRACTION.find(str)?.value ?: ""

    fun divideBySeparator(separator: String, text: String): List<String> {
        if (separator.isBlank()) return text.split(Regex("[,:]"))
        return text.split(separator)
    }

    fun getNextValue(text: String): String {
        return text.substringAfter("\n")
    }
}
