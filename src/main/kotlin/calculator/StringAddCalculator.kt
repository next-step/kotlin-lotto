package calculator

class StringAddCalculator {
    val delimiters = arrayOf(",", ":")

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        val tokens = text.split(*delimiters)
            .map { it.toInt() }

        return tokens.reduce { total, right -> total + right }
    }
}
