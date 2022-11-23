package calculator

object Tokenizer {

    fun tokenize(input: String): List<String> {
        return internalTokenize(input).map { it.trim() }
    }

    private fun internalTokenize(input: String): List<String> {
        val result: List<String>? = customTokenize(input)
        if (result != null) {
            return result
        }

        return input.split("[,:]".toRegex())
    }

    private fun customTokenize(text: String): List<String>? {
        val result: MatchResult = Regex("//(.)\n(.*)").find(text) ?: return null
        val customDelimiter: String = result.groupValues[1]
        return result.groupValues[2].split(customDelimiter)
    }
}
