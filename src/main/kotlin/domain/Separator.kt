package domain

class Separator {

    private val delimiters = mutableListOf(",", ":")

    fun extractIntegers(input: String): List<Int> {
        require(input.isNotBlank()) { return listOf(0) }
        val (delimiter, splitText) = REGEX.matchEntire(input)?.destructured
            ?: return toIntList(input)
        addDelimiter(delimiter)
        return toIntList(splitText)
    }

    private fun toIntList(text: String): List<Int> {
        return text.split(*delimiters.toTypedArray())
            .map { each ->
                val parsedInt = each.toIntOrNull()
                requireNotNull(parsedInt) { "숫자 이외의 값 혹은 음수는 사용될 수 없습니다." }
                require(parsedInt > 0) { "양수만 사용될 수 있습니다." }
                parsedInt
            }
    }

    private fun addDelimiter(delimiter: String) {
        delimiters.add(delimiter)
    }

    companion object {
        private val REGEX = Regex("//(.*?)\n(.*)")
    }
}
