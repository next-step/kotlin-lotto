package specific.study

import specific.study.Delimiter.Companion.makeDefaultDelimiters

data class Delimiter(val token: Char) {
    companion object {
        private val defaultDelimiters: List<Delimiter> = listOf(
            Delimiter(','),
            Delimiter(':'),
        )

        fun makeDefaultDelimiters() = defaultDelimiters.map { it.copy() }

        fun String.extractCustomDelimiter(): List<Delimiter> =
            "//(.)\n".toRegex()
                .findAll(this)
                .map { it.groupValues[1].first() }
                .map { Delimiter(it) }
                .toList()

        fun String.removeCustomDelimiter(): String =
            "^((//(.)\n)+)".toRegex()
                .replaceFirst(this, "")

        fun String.split(delimiters: List<Delimiter>): List<String> {
            val delimiterPattern = delimiters
                .map { it.token }
                .joinToString(separator = "|").toRegex()
            return this.split(delimiterPattern)
        }

        fun String.tokenize(): List<String> {
            val delimiters: List<Delimiter> = makeDefaultDelimiters() + this.extractCustomDelimiter()
            return this
                .removeCustomDelimiter()
                .split(delimiters)
        }
    }
}
