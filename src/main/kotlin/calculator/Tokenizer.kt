package calculator

object Tokenizer {

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
        val customDelimiter: String = result.groupValues[1]
        return result.groupValues[2].split(customDelimiter)
    }
}
