package calculator

object TextSplitter {
    fun splitText(text: String, delimiters: List<String>): List<String> {
        val regexPattern = delimiters.joinToString(separator = "|")
        return text.split(regexPattern.toRegex())
    }
}
