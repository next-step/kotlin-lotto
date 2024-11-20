package calculator

class StringParser {
    fun split(text: String): List<String> {
        if (text.isBlank()) return emptyList()

        return text.split(DEFAULT_DELIMITERS_REGEX).filter { it.isNotBlank() }
    }

    companion object {
        private val DEFAULT_DELIMITERS_REGEX = "[,:]".toRegex()
    }
}
