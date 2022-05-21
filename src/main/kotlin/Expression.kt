class Expression {
    var operators = listOf<String>()
    var digits = listOf<String>()

    fun getTokens(text: String): List<String> {
        val tokens = if (text.trim().isNullOrEmpty()) {
            listOf("0")
        } else {
            text.split(",|:".toRegex())
        }

        require(tokens.all { it.toInt() > 0 })

        return tokens
    }
}