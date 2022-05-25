package calculator

class StringAddCalculator {
    private val delimiters = arrayOf(",", ":")

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val (del, content) = text.extractDelimiter()

        val tokens = content.split(*delimiters.addIfNotNull(del))
            .map { it.toInt() }

        return tokens.reduce { total, right -> total + right }
    }

    private fun Array<String>.addIfNotNull(str: String?) =
        if (str != null) { this + str } else { this }

    private fun String.extractDelimiter() =
        Regex("""//(.)\\n(.*)""").find(this)
            ?.let { Pair(it.groupValues[1], it.groupValues[2]) }
            ?: Pair(null, this)
}
