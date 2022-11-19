package domain

class Separators {
    private val separators: MutableList<Char> = DEFAULT_SEPARATORS

    fun get(): List<Char> {
        return separators
    }

    fun add(separator: Char) {
        separators.add(separator)
    }

    fun toRegexString(): String {
        return separators.joinToString(VERTICAL_BAR)
    }

    companion object {
        private const val COMMA = ','
        private const val COLON = ':'
        private const val VERTICAL_BAR = "|"
        private val DEFAULT_SEPARATORS = mutableListOf(COMMA, COLON)
    }
}
