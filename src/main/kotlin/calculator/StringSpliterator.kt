package calculator

class StringSpliterator: Spliterator<String> {

    private val symbols = listOf(",", ":")

    override fun split(value: String): List<String> {
        val separated = customizeSeparator.find(value)?.let {
            val separator = it.groupValues[1]
            val split = it.groupValues[2].split(separator)
            split
        } ?: listOf(value)
        return parse(separated, 0)
    }

    private tailrec fun parse(input: List<String>, index: Int): List<String> {
        return if (index < symbols.size) parse(symbolParse(input, symbols[index]), index + 1)
            else input
    }

    private fun symbolParse(input: List<String>, symbol: String): List<String> = input.flatMap { it.split(symbol) }

    companion object {
        private val customizeSeparator = "^//(.)\\n(.*)".toRegex()
    }
}
