package calculator

class TextSplitter(private val text: String, private val delimiters: List<String>) {
    companion object {
        fun splitText(text: String, delimiters: List<String>): List<String> {
            val regexPattern = delimiters.joinToString(separator = "|")
            return text.split(regexPattern.toRegex())
        }
    }
}
