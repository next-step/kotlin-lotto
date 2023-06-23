package calculator

class Delimiters(private val delimiter: String? = null) {
    private val delimiters: List<String>

    init {
        val defaultDelimiters = listOf(",", ":")
        delimiters = if (!delimiter.isNullOrEmpty()) {
            defaultDelimiters + delimiter
        } else {
            defaultDelimiters
        }
    }

    fun getDelimiters(): List<String> = delimiters
    fun splitText(text: String): List<String> {
        val regexPattern = delimiters.joinToString(separator = "|").toRegex()
        return text.split(regexPattern)
    }
}
