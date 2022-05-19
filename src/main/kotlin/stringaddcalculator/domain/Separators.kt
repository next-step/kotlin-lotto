package stringaddcalculator.domain

class Separators {

    private val separators = mutableSetOf(
        Separator(COLON),
        Separator(COMMA)
    )

    val size = separators.size

    operator fun contains(separator: String): Boolean {
        return separators.any { it.value == separator }
    }

    fun add(separator: String) {
        separators.add(Separator(separator))
    }

    fun toRegex(): Regex {
        val string = separators.joinToString("") { it.value }
        return "[$string]".toRegex()
    }

    companion object {
        private const val COLON = ":"
        private const val COMMA = ","
    }
}
