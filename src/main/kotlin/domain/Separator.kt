package domain

class Separator {

    private val delimiters = mutableListOf(",", ":")

    fun extractIntegers(input: String): List<Int> {
        val (delimiter, splitText) = REGEX.matchEntire(input)?.destructured
            ?: return toIntList(input)
        addDelimiter(delimiter)
        return toIntList(splitText)
    }

    private fun toIntList(text: String) = text.split(*delimiters.toTypedArray())
        .map { it.toInt() }

    private fun addDelimiter(delimiter: String) {
        delimiters.add(delimiter)
    }

    companion object {
        private val REGEX = Regex("//(.*?)\n(.*)")
    }
}
