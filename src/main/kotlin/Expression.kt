class Expression {
    var operators = listOf<String>()
    var digits = listOf<String>()

    fun getTokens(text: String): List<String> {
        return if (text.trim().isNullOrEmpty()) {
            listOf("0")
        } else {
            text.split(",|:".toRegex())
        }
    }
}