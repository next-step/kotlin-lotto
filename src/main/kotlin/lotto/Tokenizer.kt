package lotto

object Tokenizer {
    private const val CUSTOM_TOKEN_INDEX = 1
    private const val CUSTOM_TARGET_STRING_INDEX = 2

    private val tokenRegex = "[,:]".toRegex()
    private val customRegex = Regex("//(.)\n(.*)")

    fun tokenize(input: String): List<String> {
        return internalTokenize(input).map { it.trim() }
    }

    private fun internalTokenize(input: String): List<String> {
        val result: List<String>? = customTokenize(input)
        if (result != null) {
            return result
        }

        return input.split(tokenRegex)
    }

    private fun customTokenize(text: String): List<String>? {
        val result: MatchResult = customRegex.find(text) ?: return null
        val customDelimiter: String = result.groupValues[CUSTOM_TOKEN_INDEX]
        return result.groupValues[CUSTOM_TARGET_STRING_INDEX].split(customDelimiter)
    }
}
