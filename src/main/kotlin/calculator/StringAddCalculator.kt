package calculator

class StringAddCalculator {
    private val delimiters = arrayOf(",", ":")

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val (del, content) = text.extractDelimiter()

        val dels = delimiters.addIfNotNull(del)

        val tokens = content.split(*dels)
            .map { it.toPositiveInt() }

        return tokens.sum()
    }
}

private fun String.toPositiveInt() = this.toInt().takeIf {
    it >= 0
} ?: throw IllegalArgumentException("Num should not be negative")

private fun Array<String>.addIfNotNull(str: String?) =
    if (str != null) {
        this + str
    } else {
        this
    }

private fun String.extractDelimiter() =
    Regex("""//(.)\n(.*)""").find(this)
        ?.let { Pair(it.groupValues[1], it.groupValues[2]) }
        ?: Pair(null, this)
