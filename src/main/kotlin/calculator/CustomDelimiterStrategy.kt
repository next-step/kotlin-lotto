package calculator

class CustomDelimiterStrategy : DelimiterStrategy {
    override fun supports(text: String): Boolean {
        return text.startsWith("//") && text.contains("\n")
    }

    override fun parse(text: String): List<Int> {
        val delimiter = text.substring(2, 3)
        return text.substring(4)
            .split(delimiter)
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }
}
