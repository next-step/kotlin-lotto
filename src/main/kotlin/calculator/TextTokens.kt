package calculator

class TextTokens(private val tokens: List<PositiveNumber>) : Iterable<PositiveNumber> {
    fun sum(): Int {
        return tokens.sumOf { it.number }
    }

    override fun iterator(): Iterator<PositiveNumber> {
        return tokens.iterator()
    }
}
