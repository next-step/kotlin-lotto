package stringaddcalculator.domain

class Separators {

    private val separators = setOf(
        Separator(COLON),
        Separator(COMMA)
    )

    operator fun contains(separator: String): Boolean {
        return separators.any { it == Separator(separator) }
    }

    companion object {
        private const val COLON = ":"
        private const val COMMA = ","
    }
}
