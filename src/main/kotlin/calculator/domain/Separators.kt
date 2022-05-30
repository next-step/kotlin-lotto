package calculator.domain

class Separators(
    private val values: List<Separator> = listOf(
        Default,
        Custom,
    )
) {
    fun splitText(text: String): List<String> {
        val separator = getMatchSeparator(text = text)
        return separator.split(text = text)
    }

    private fun getMatchSeparator(text: String): Separator {
        return values.find { it.isMatchWithText(text = text) } ?: Default
    }
}
