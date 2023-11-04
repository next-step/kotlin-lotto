package calculator

object StringSpliterator: Spliterator<String> {

    private val customizeDelimiter = "^//(.)\\n(.*)".toRegex()
    private val symbols = listOf(",", ":")

    override fun split(value: String): List<String> =
        parse(splitCustomizeDelimiter(value), 0)

    private fun splitCustomizeDelimiter(value: String): List<String> =
        customizeDelimiter.matchEntire(value)?.let {
            val delimiter = it.groupValues[1]
            it.groupValues[2].split(delimiter)
        } ?: listOf(value)

    private tailrec fun parse(input: List<String>, index: Int): List<String> {
        return if (index < symbols.size) parse(symbolParse(input, symbols[index]), index + 1)
            else input
    }

    private fun symbolParse(input: List<String>, symbol: String): List<String> = input.flatMap { it.split(symbol) }

}
